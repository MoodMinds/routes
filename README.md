# Execution model -agnostic Traversal and Stream definition Language

**Routes** serves as a client-level language for defining traversals and streams, independent of the execution model
(whether synchronous or asynchronous). This Java functional DSL API relies on Lambdas for expressiveness, allowing users
to declaratively define complex execution algorithms and data structure traversals, with the emission of intermediate
items (streams). Additionally, Routes serves as a Service Provider Interface (SPI) that can be implemented by specific
executors.

## The Concept

The core concept behind this project is to separate the definition of algorithms from the choice of execution environment,
be it regular synchronous or reactive. A good point of reference is comparing Java 8 Streams API to the reactive world's Streams API,
such as `Flux` or `Mono` from [Project Reactor](https://projectreactor.io). Both Java 8 Streams and reactive streams couple their pipeline
definitions to specific executor objects (Stream, Flux, or Mono).

So, why opt for decoupling? Imagine having a single codebase that can seamlessly operate in both synchronous and asynchronous
environments, especially when this code is part of a library or framework. This project aims to provide a fundamental API for
expressing execution algorithms, along with several other features commonly expected from well-known stream APIs, but which
are often cumbersome to implement or may feel unnatural. One of the primary motivations behind this API is to eliminate
what's often referred to as "flatMap Hell," a common issue in known stream composing APIs.



### In a Nutshell

**Lambdas for Route Definitions**: Route definitions are lambda expressions, which implement functional `Stream`
  and `Action` interfaces. These defined routes, whether with or without input parameters, can be referenced from other
  routes, enabling the organization of routing algorithm logic through reusable parts. Unlike Java 8 Streams, Routes
  remain stateless expressions.

**Emitting and Non-Emitting Routes**: Routes can be declared to emit intermediate items (`Stream<Long, RuntimeException>`)
  or not emit them (`Action<RuntimeException>`). They are parameterized with types for possible emissions, including values
  and exceptions for streams and exceptions only for actions.

**Nested Routes**: Inline route expressions can be used as sub-routes wherever necessary for readability and consistency.

**Checked Exceptions**: Route functions are parameterized with an upper-bound Exception type declaration, such as
  `Action<SQLException>` or `Stream<String, Exception`, allowing the use of lambda expressions that throw checked exceptions.
  This capability is notably missing in the Java 8 Streams API.

**Exception Handling**: Route expressions support exception catching definitions, enabling the definition of handling routes
  for different types of exceptions. This feature is absent in the Java 8 Streams API due to its nature as an active iterator
  (Spliterator) and the challenges in implementing it correctly, especially for parallel streams.

**Conditional Routing**: Routes provide support for defining conditional routing, which is another feature lacking in the
  Java 8 Streams API.

**Route Arguments**: Routes can accept input arguments, such as `Action1<Input, Exception>` or
  `Stream2<Input1, Input2, Long, RuntimeException`, and so on, accommodating up to 8 input parameters.

**Access to Upstream Pipeline Data**: Pipeline data can be exposed as variables in route expressions and easily accessed
  in downstream definitions. Achieving this in Java 8 Streams can be quite unnatural, often requiring complex flat-mapping.

**Routes as a Fully Extensible API (SPI)**: While the base Routes API offers fundamental routing logic, including conditionals,
  exception handling, filtering, mapping, reducing, and more for streaming routes, it is also designed to support
  extensions for various application logic expressed in routing and streaming. For example, the [RDBMS](https://github.com/MoodMinds/rdbms)
  extends Routes to include database interactions and Relation tuples traversals, naturally expressed through routing and streaming.
  Extensions of the base Routes API can reference routes defined using the base API and incorporate them into definition expressions.


### Routes expressions

Let's take a look at the basic principles of the Routes API usage by examples.

```java
import org.moodminds.route.*;

import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.logging.Logger;

import static java.util.logging.Level.SEVERE;
import static java.util.logging.Level.WARNING;

class Sample {

  static final Logger LOG = Logger.getLogger(Sample.class.getName());


  static final Action<IOException> EXECUTION = $ -> $
          .effect(() -> LOG.info("Executing..."))
          .effect(() -> {
            throw new IOException("Error occurred");
          });

  static final Stream<Long, Exception> LONGS = $ -> $.repeat(0L, l -> l + 1L, l -> l < 10);

  static final Stream<String, RuntimeException> STRINGS = $ -> $.source("A", "B", "C");

  static final Stream1<String, Character, RuntimeException> CHARACTERS = ($, str) -> $
          .source(str, s -> s.chars().mapToObj(i -> (char) i));

  static final Action1<String, RuntimeException> PEEKING = ($, str) -> $
          .effect(str, s -> LOG.info(s));

  static final Stream<String, RuntimeException> FILTERING = $ -> $
          .filter(STRINGS, s -> s.length() > 1, filtered -> $
              .effect(filtered, s -> LOG.info(s))
              .expect(filtered));

  static final Stream<String, RuntimeException> MAPPING = $ -> $
          .map(FILTERING, String::toLowerCase, lower -> $
              .action(PEEKING, lower)
              .supply(lower, String::toUpperCase));

  static final Stream<Character, Exception> FLATTENING = $ -> $
          .stream(STRINGS, str -> $
              .stream(CHARACTERS, str));

  static final Stream<Serializable, Exception> CONCATENATING = $ -> $
          .concat(LONGS, STRINGS, val -> $
              .effect(val, o -> LOG.info("Concatenated: " + o))
              .expect(val));

  static final Stream2<Boolean, String, String, Exception> CHOOSING = ($, bool, str) -> $
          .either(bool, MAPPING)
          .option(str, String::isEmpty, () -> $
              .supply(() -> {
                throw new Exception(":(");
              }))
          .option(str, "WW"::equals, FILTERING)
          .option(STRINGS);

  static final Stream<Long, IOException> CATCHING = $ -> $
          .stream(LONGS)
              .caught(Exception.class, ex -> $
                  .effect(ex, e -> LOG.log(SEVERE, "Exception occur", e))
              .action(EXECUTION)
              .source(1L, 3L, 7L))
              .caught(ParseException.class, parseEx -> $
                  .effect(parseEx, e -> LOG.log(WARNING, "Exception occur", e))
                  .supply(parseEx, IOException::new, $::except));
}
```

### Executing Routes

Routes are designed to be executed within specific execution models, either in the regular synchronous mode or the
asynchronous reactive mode. To facilitate this execution, there is a bridging interface called `Routes`. This interface
transforms a given Route into an `Emittable` object, which can then be traversed synchronously or observed reactively
using a `Subscriber`.

Synchronous (traversal):

```java
import org.moodminds.route.Stream;
import org.moodminds.route.Routes;

import java.util.logging.Logger;

class TraversalSample {

    static final Logger LOG = Logger.getLogger(TraversalSample.class.getName());

    static final Stream<String, IOException> STRINGS = $ -> $.source("a", "b", "c"); // assume some complex stream possibly throwing IOException

    final Routes routes = null; // assume it is initialized somehow as synchronous traversal implementation

    public void traverse() throws IOException { // has to declare throws Exception that can be emitted while traversing as defined in the Stream<String, IOException>
        routes.stream(STRINGS).traverse(t -> t.each(s -> LOG.info(s)));
    }
}
```

Asynchronous (reactive):

```java
import org.moodminds.reactive.SubscribeSupport.Subscriber;
import org.moodminds.reactive.SubscribeSupport.Subscription;
import org.moodminds.route.Routes;
import org.moodminds.route.Stream;

import java.sql.SQLException;

class ReactiveSample {

    static final Stream<String, IOException> STRINGS = $ -> $.source("1", "2", "3"); // assume some complex stream possibly throwing IOException

    final Routes routes = null; // assume it is initialized somehow as reactive asynchronous implementation

    public void subscribe() {
        routes.stream(STRINGS).subscribe(new Subscriber<>() {
            @Override public void onSubscribe(Flow.Subscription subscription) {
                subscription.request(Long.MAX_VALUE); }
            @Override public void onNext(String item) {}
            @Override public void onError(IOException exception) {}
            @Override public void onError(Throwable exception) {}
            @Override public void onComplete() {}
        });
    }
}
```

## Maven configuration

Artifacts can be found on [Maven Central](https://search.maven.org/) after publication.

```xml
<dependency>
    <groupId>org.moodminds.routes</groupId>
    <artifactId>routes</artifactId>
    <version>${version}</version>
</dependency>
```

## Building from Source

You may need to build from source to use **Routes** (until it is in Maven Central) with Maven and JDK 1.8 at least.

## License
This project is going to be released under version 2.0 of the [Apache License][l].

[l]: https://www.apache.org/licenses/LICENSE-2.0