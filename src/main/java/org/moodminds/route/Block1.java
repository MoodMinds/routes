package org.moodminds.route;

/**
 * Route definition block by the argument value.
 *
 * @param <I> the type of the input argument
 * @param <$R> the type of the route definition result
 */
@FunctionalInterface
public interface Block1<I, $R extends Routing<?>> {

    /**
     * Define the route block by the specified argument value.
     *
     * @param value the specified argument value
     * @return a route block definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    $R block(Value<I> value);
}
