package org.moodminds.route;

import org.moodminds.elemental.Tuple1;
import org.moodminds.elemental.Tuple2;
import org.moodminds.elemental.Tuple3;
import org.moodminds.elemental.Tuple4;
import org.moodminds.elemental.Tuple5;
import org.moodminds.elemental.Tuple6;
import org.moodminds.elemental.Tuple7;
import org.moodminds.elemental.Tuple8;
import org.moodminds.emission.Emittable;
import org.moodminds.emission.Resource;
import org.moodminds.function.*;

import java.util.Comparator;
import java.util.stream.BaseStream;
import java.util.stream.Collector;

/**
 * The flow definition interface.
 *
 * @param <$F> the type of the flow definition interface
 * @param <E>  the type of possible exception
 */
public interface Flow<$F extends Flow<?, E>, E extends Exception> extends Flowing<$F> {

    /**
     * Complete route definition without any emission.
     *
     * @param <V> the type of the emitting value
     * @return route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> Emitting<V> escape();

    /**
     * Complete route definition as such that emits a value specified by the definition object.
     *
     * @param value the specified value definition object
     * @param <V>   the type of the emitting value
     * @return emitting result definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> Emitting<V> expect(Value<? extends V> value);

    /**
     * Complete route definition as such that emits an exception specified by the definition object.
     *
     * @param exception the specified exception definition object
     * @param <$R>      the type of the route definition result
     * @return route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <$R extends Routing<?>> $R except(ValueLevel1<? extends E> exception);

    /**
     * Complete route definition as such that emits an exception specified by the definition object.
     *
     * @param exception the specified exception definition object
     * @param <$R>      the type of the route definition result
     * @return route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <$R extends Routing<?>> $R except(ValueLevel2<? extends RuntimeException> exception);

    /**
     * Complete route definition as such that emits an exception specified by the definition object.
     *
     * @param exception the specified exception definition object
     * @param <$R>      the type of the route definition result
     * @return route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <$R extends Routing<?>> $R except(ValueLevel3<E> exception);

    /**
     * Add the specified {@link Resource} refusal to the flow.
     *
     * @param resource the specified {@link Resource} value
     * @param <H>      the type of unexpected exception that might be thrown
     * @return the flow definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <H extends Exception> CatchingAction<$F, H, E> refuse(ValueLevel0<? extends Resource<?, ? extends H>> resource);

    /**
     * Add the specified {@link Resource} refusal to the flow.
     *
     * @param resource the specified {@link Resource} value
     * @return the flow definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    ExpectingAction<$F, E> refuse(ValueLevel1<? extends Resource<?, ? extends E>> resource);

    /**
     * Add the specified {@link Resource} refusal to the flow.
     *
     * @param resource the specified {@link Resource} value
     * @return the flow definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    ExpectingAction<$F, E> refuse(ValueLevel2<? extends Resource<?, ? extends RuntimeException>> resource);

    /**
     * Add the specified {@link Resource} refusal to the flow.
     *
     * @param resource the specified {@link Resource} value
     * @return the flow definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    ExpectingAction<$F, E> refuse(ValueLevel3<? extends Resource<?, E>> resource);


    /**
     * Complete route definition as such that emits chars of the specified array.
     *
     * @param chars the specified chars array
     * @return emitting result definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    Emitting<Character> source(char[] chars);

    /**
     * Complete route definition as such that emits bytes of the specified array.
     *
     * @param bytes the specified bytes array
     * @return emitting result definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    Emitting<Byte> source(byte[] bytes);

    /**
     * Complete route definition as such that emits shorts of the specified array.
     *
     * @param shorts the specified shorts array
     * @return emitting result definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    Emitting<Short> source(short[] shorts);

    /**
     * Complete route definition as such that emits ints of the specified array.
     *
     * @param ints the specified ints array
     * @return emitting result definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    Emitting<Integer> source(int[] ints);

    /**
     * Complete route definition as such that emits longs of the specified array.
     *
     * @param longs the specified longs array
     * @return emitting result definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    Emitting<Long> source(long[] longs);

    /**
     * Complete route definition as such that emits floats of the specified array.
     *
     * @param floats the specified floats array
     * @return emitting result definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    Emitting<Float> source(float[] floats);

    /**
     * Complete route definition as such that emits doubles of the specified array.
     *
     * @param doubles the specified doubles array
     * @return emitting result definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    Emitting<Double> source(double[] doubles);

    /**
     * Complete route definition as such that emits booleans of the specified array.
     *
     * @param booleans the specified booleans array
     * @return emitting result definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    Emitting<Boolean> source(boolean[] booleans);

    /**
     * Complete route definition as such that emits values of the specified array.
     *
     * @param values the specified values array
     * @param <V>    the type of the emitting values
     * @return emitting result definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> Emitting<V> source(V[] values);

    /**
     * Complete route definition as such that emits the specified values.
     *
     * @param value1 the specified value 1
     * @param value2 the specified value 2
     * @param <V>    the type of the emitting values
     * @return emitting result definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> Emitting<V> source(V value1, V value2);

    /**
     * Complete route definition as such that emits the specified values.
     *
     * @param value1 the specified value 1
     * @param value2 the specified value 2
     * @param value3 the specified value 3
     * @param <V>    the type of the emitting values
     * @return emitting result definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> Emitting<V> source(V value1, V value2, V value3);

    /**
     * Complete route definition as such that emits the specified values.
     *
     * @param value1 the specified value 1
     * @param value2 the specified value 2
     * @param value3 the specified value 3
     * @param value4 the specified value 4
     * @param <V>    the type of the emitting values
     * @return emitting result definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> Emitting<V> source(V value1, V value2, V value3, V value4);

    /**
     * Complete route definition as such that emits the specified values.
     *
     * @param value1 the specified value 1
     * @param value2 the specified value 2
     * @param value3 the specified value 3
     * @param value4 the specified value 4
     * @param value5 the specified value 5
     * @param <V>    the type of the emitting values
     * @return emitting result definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> Emitting<V> source(V value1, V value2, V value3, V value4, V value5);

    /**
     * Complete route definition as such that emits the specified values.
     *
     * @param value1 the specified value 1
     * @param value2 the specified value 2
     * @param value3 the specified value 3
     * @param value4 the specified value 4
     * @param value5 the specified value 5
     * @param value6 the specified value 6
     * @param <V>    the type of the emitting values
     * @return emitting result definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> Emitting<V> source(V value1, V value2, V value3, V value4, V value5, V value6);

    /**
     * Complete route definition as such that emits the specified values.
     *
     * @param value1 the specified value 1
     * @param value2 the specified value 2
     * @param value3 the specified value 3
     * @param value4 the specified value 4
     * @param value5 the specified value 5
     * @param value6 the specified value 6
     * @param value7 the specified value 7
     * @param <V>    the type of the emitting values
     * @return emitting result definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> Emitting<V> source(V value1, V value2, V value3, V value4, V value5, V value6, V value7);

    /**
     * Complete route definition as such that emits the specified values.
     *
     * @param value1 the specified value 1
     * @param value2 the specified value 2
     * @param value3 the specified value 3
     * @param value4 the specified value 4
     * @param value5 the specified value 5
     * @param value6 the specified value 6
     * @param value7 the specified value 7
     * @param value8 the specified value 8
     * @param <V>    the type of the emitting values
     * @return emitting result definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> Emitting<V> source(V value1, V value2, V value3, V value4, V value5, V value6, V value7, V value8);

    /**
     * Complete route definition as such that emits the specified values.
     *
     * @param value1 the specified value 1
     * @param value2 the specified value 2
     * @param value3 the specified value 3
     * @param value4 the specified value 4
     * @param value5 the specified value 5
     * @param value6 the specified value 6
     * @param value7 the specified value 7
     * @param value8 the specified value 8
     * @param values the specified values
     * @param <V>    the type of the emitting values
     * @return emitting result definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    @SuppressWarnings("unchecked")
    <V> Emitting<V> source(V value1, V value2, V value3, V value4, V value5, V value6, V value7, V value8, V... values);

    /**
     * Complete route definition as such that emits values infinitely generated
     * by the specified {@link Evaluable} supplier.
     *
     * @param supplier the specified {@link Evaluable} supplier
     * @param <V>      the type of the emitting values
     * @return emitting result definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> Emitting<V> repeat(EvaluableThrowing1<? extends V, ? extends E> supplier);

    /**
     * Complete route definition as such that emits values generated
     * by the specified {@link Evaluable} supplier the specified number of times.
     *
     * @param supplier the specified {@link Evaluable} supplier
     * @param times    the specified number of times to generate values
     * @param <V>      the type of the emitting values
     * @return emitting result definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> Emitting<V> repeat(EvaluableThrowing1<? extends V, ? extends E> supplier, long times);

    /**
     * Complete route definition as such that emits values produced by iterative application
     * of the {@link Evaluable1Throwing1} function to a previous value seed.
     *
     * @param seed     the initial value
     * @param function the {@link Evaluable1Throwing1} function to be applied to the previous value
     * @param <V>      the type of the emitting values
     * @return emitting result definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> Emitting<V> repeat(V seed, Evaluable1Throwing1<? super V, ? extends V, ? extends E> function);

    /**
     * Complete route definition as such that emits values produced by iterative application
     * of the {@link Evaluable1Throwing1} function to a previous value seed while the seed is accepted
     * by the specified {@link Testable1Throwing1} predicate.
     *
     * @param seed      the initial value
     * @param function  the {@link Evaluable1Throwing1} function to be applied to the previous value
     * @param predicate the specified {@link Testable1Throwing1} predicate
     * @param <V>       the type of the emitting values
     * @return emitting result definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> Emitting<V> repeat(V seed, Evaluable1Throwing1<? super V, ? extends V, ? extends E> function, Testable1Throwing1<? super V, ? extends E> predicate);


    /**
     * Add the specified {@link Executable} execution to the flow.
     *
     * @param execution the specified {@link Executable} execution
     * @return the flow definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    ExpectingAction<$F, E> effect(ExecutableThrowing1<? extends E> execution);

    /**
     * Add the execution of the {@link Emittable} specified by the definition object to the flow.
     *
     * @param route the specified {@link Emittable} definition object
     * @param <H>   the type of unexpected exception that might be thrown
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <H extends Exception> CatchingAction<$F, H, E> action(ValueLevel0<? extends Emittable<?, ? extends H>> route);

    /**
     * Add the execution of the {@link Emittable} specified by the definition object to the flow.
     *
     * @param route the specified {@link Emittable} definition object
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    ExpectingAction<$F, E> action(ValueLevel1<? extends Emittable<?, ? extends E>> route);

    /**
     * Add the execution of the {@link Emittable} specified by the definition object to the flow.
     *
     * @param route the specified {@link Emittable} definition object
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    ExpectingAction<$F, E> action(ValueLevel2<? extends Emittable<?, ? extends RuntimeException>> route);

    /**
     * Add the execution of the {@link Emittable} specified by the definition object to the flow.
     *
     * @param route the specified {@link Emittable} definition object
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    ExpectingAction<$F, E> action(ValueLevel3<? extends Emittable<?, E>> route);


    /**
     * Complete route definition as such that emits a value from the specified {@link Evaluable} supplier.
     *
     * @param supplier the specified value {@link Evaluable} supplier
     * @param <V>      the type of the emitting value
     * @return emitting result definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<V, E> supply(EvaluableThrowing1<? extends V, ? extends E> supplier);

    /**
     * Continue route definition in the given handler of a value from the specified {@link Evaluable} supplier.
     *
     * @param supplier the specified value {@link Evaluable} supplier
     * @param handler  the given value handling route
     * @param <V>      the type of the emitting value
     * @param <$R>     the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R supply(EvaluableThrowing1<? extends V, ? extends E> supplier, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits values from the supplying {@link BaseStream} source.
     *
     * @param source the supplying {@link BaseStream} source
     * @param <V>    the type of the emitting value
     * @return emitting result definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<V, E> source(Value<? extends Iterable<V>> source);

    /**
     * Complete route definition as such that emits values from the supplying {@link BaseStream} source.
     *
     * @param source the supplying {@link BaseStream} source
     * @param <V>    the type of the emitting value
     * @return emitting result definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<V, E> source(EvaluableThrowing1<? extends BaseStream<V, ?>, ? extends E> source);

    /**
     * Continue route definition in the given handler of values from the supplying {@link BaseStream} source.
     *
     * @param source  the supplying values {@link BaseStream} source
     * @param handler the given values handling route
     * @param <V>     the type of the emitting value
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R source(EvaluableThrowing1<? extends BaseStream<V, ?>, ? extends E> source, Block1<? super V, ? extends Routing<? extends $R>> handler);


    /**
     * Add the execution of the specified route to the flow.
     *
     * @param route the specified route definition
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    ExpectingAction<$F, E> action(Block<? extends Flowing<?>> route);

    /**
     * Add the execution of the specified route to the flow.
     *
     * @param route the specified route definition
     * @param <H>   the type of unexpected exception that might be thrown
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <H extends Exception> CatchingAction<$F, H, E> action(RouteLevel0<? extends H, ?> route);

    /**
     * Add the execution of the specified route to the flow.
     *
     * @param route the specified route definition
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    ExpectingAction<$F, E> action(RouteLevel1<? extends E, ?> route);

    /**
     * Add the execution of the specified route to the flow.
     *
     * @param route the specified route definition
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    ExpectingAction<$F, E> action(RouteLevel2<? extends RuntimeException, ?> route);

    /**
     * Add the execution of the specified route to the flow.
     *
     * @param route the specified route definition
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    ExpectingAction<$F, E> action(RouteLevel3<E, ?> route);

    /**
     * Complete route definition as such that emits values defined in the specified streaming route.
     *
     * @param stream the specified streaming route
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<V, E> stream(Block<? extends Emitting<? extends V>> stream);

    /**
     * Continue route definition in the given handler of the values defined in the specified streaming route.
     *
     * @param stream  the specified streaming route
     * @param handler the given values handling route
     * @param <O>     the type of the source emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <O, $R extends Routing<?>> $R stream(Block<? extends Emitting<? extends O>> stream, Block1<? super O, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits values defined in the specified streaming route.
     *
     * @param stream the specified streaming route
     * @param <V>    the type of the emitting values
     * @param <H>    the type of unexpected exception that might be thrown
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, H extends Exception> CatchingStream<V, H, E> stream(RouteLevel0<? extends H, ? extends Emitting<? extends V>> stream);

    /**
     * Complete route definition as such that emits values defined in the specified streaming route.
     *
     * @param stream the specified streaming route
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<V, E> stream(RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream);

    /**
     * Continue route definition in the given handler of the values defined in the specified streaming route.
     *
     * @param stream  the specified streaming route
     * @param handler the given values handling route
     * @param <O>     the type of the source emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <O, $R extends Routing<?>> $R stream(RouteLevel1<? extends E, ? extends Emitting<? extends O>> stream, Block1<? super O, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits values defined in the specified streaming route.
     *
     * @param stream the specified streaming route
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<V, E> stream(RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream);

    /**
     * Continue route definition in the given handler of the values defined in the specified streaming route.
     *
     * @param stream  the specified streaming route
     * @param handler the given values handling route
     * @param <O>     the type of the source emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <O, $R extends Routing<?>> $R stream(RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends O>> stream, Block1<? super O, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits values defined in the specified streaming route.
     *
     * @param stream the specified streaming route
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<V, E> stream(RouteLevel3<E, ? extends Emitting<? extends V>> stream);

    /**
     * Continue route definition in the given handler of the values defined in the specified streaming route.
     *
     * @param stream  the specified streaming route
     * @param handler the given values handling route
     * @param <O>     the type of the source emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <O, $R extends Routing<?>> $R stream(RouteLevel3<E, ? extends Emitting<? extends O>> stream, Block1<? super O, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits values of the {@link Emittable} specified by the definition object.
     *
     * @param stream the specified {@link Emittable} definition object
     * @param <V>    the type of the emitting values
     * @param <H>    the type of unexpected exception that might be thrown
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, H extends Exception> CatchingStream<V, H, E> stream(ValueLevel0<? extends Emittable<? extends V, ? extends H>> stream);

    /**
     * Complete route definition as such that emits values of the {@link Emittable} specified by the definition object.
     *
     * @param stream the specified {@link Emittable} definition object
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<V, E> stream(ValueLevel1<? extends Emittable<? extends V, ? extends E>> stream);

    /**
     * Continue route definition in the given handler of values of the {@link Emittable} specified by the definition object.
     *
     * @param stream  the specified {@link Emittable} definition object
     * @param handler the given values handling route
     * @param <O>     the type of the source emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <O, $R extends Routing<?>> $R stream(ValueLevel1<? extends Emittable<? extends O, ? extends E>> stream, Block1<? super O, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits values of the {@link Emittable} specified by the definition object.
     *
     * @param stream the specified {@link Emittable} definition object
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<V, E> stream(ValueLevel2<? extends Emittable<? extends V, ? extends RuntimeException>> stream);

    /**
     * Continue route definition in the given handler of values of the {@link Emittable} specified by the definition object.
     *
     * @param stream  the specified {@link Emittable} definition object
     * @param handler the given values handling route
     * @param <O>     the type of the source emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <O, $R extends Routing<?>> $R stream(ValueLevel2<? extends Emittable<? extends O, ? extends RuntimeException>> stream, Block1<? super O, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits values of the {@link Emittable} specified by the definition object.
     *
     * @param stream the specified {@link Emittable} definition object
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<V, E> stream(ValueLevel3<? extends Emittable<? extends V, E>> stream);

    /**
     * Continue route definition in the given handler of values of the {@link Emittable} specified by the definition object.
     *
     * @param stream  the specified {@link Emittable} definition object
     * @param handler the given values handling route
     * @param <O>     the type of the source emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <O, $R extends Routing<?>> $R stream(ValueLevel3<? extends Emittable<? extends O, E>> stream, Block1<? super O, ? extends Routing<? extends $R>> handler);

    /**
     * Continue route definition in the given handler of values of the {@link Resource} specified by the definition object.
     *
     * @param stream  the specified {@link Resource} definition object
     * @param handler the given values handling route
     * @param <O>     the type of the source emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <O, $R extends Routing<?>> $R handle(ValueLevel2<? extends Resource<? extends O, ? extends E>> stream, Block1<? super O, ? extends Routing<? extends $R>> handler);

    /**
     * Continue route definition in the given handler of values of the {@link Resource} specified by the definition object.
     *
     * @param stream  the specified {@link Resource} definition object
     * @param handler the given values handling route
     * @param <O>     the type of the source emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <O, $R extends Routing<?>> $R handle(ValueLevel3<? extends Resource<? extends O, ? extends RuntimeException>> stream, Block1<? super O, ? extends Routing<? extends $R>> handler);

    /**
     * Continue route definition in the given handler of values of the {@link Resource} specified by the definition object.
     *
     * @param stream  the specified {@link Resource} definition object
     * @param handler the given values handling route
     * @param <O>     the type of the source emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <O, $R extends Routing<?>> $R handle(Value<? extends Resource<? extends O, E>> stream, Block1<? super O, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that sorts and emits {@link Comparable} values
     * defined in the specified streaming route.
     *
     * @param stream the specified streaming route
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V extends Comparable<V>> ExpectingStream<V, E> sort(Block<? extends Emitting<? extends V>> stream);

    /**
     * Continue route definition in the given handler of sorted {@link Comparable} values
     * defined in the specified streaming route.
     *
     * @param stream  the specified streaming route
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V extends Comparable<V>, $R extends Routing<?>> $R sort(Block<? extends Emitting<? extends V>> stream, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that sorts and emits {@link Comparable} values
     * defined in the specified streaming route.
     *
     * @param stream the specified streaming route
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V extends Comparable<V>> ExpectingStream<V, E> sort(RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream);

    /**
     * Continue route definition in the given handler of sorted {@link Comparable} values
     * defined in the specified streaming route.
     *
     * @param stream  the specified streaming route
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V extends Comparable<V>, $R extends Routing<?>> $R sort(RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that sorts and emits {@link Comparable} values
     * defined in the specified streaming route.
     *
     * @param stream the specified streaming route
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V extends Comparable<V>> ExpectingStream<V, E> sort(RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream);

    /**
     * Continue route definition in the given handler of sorted {@link Comparable} values
     * defined in the specified streaming route.
     *
     * @param stream  the specified streaming route
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V extends Comparable<V>, $R extends Routing<?>> $R sort(RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that sorts and emits {@link Comparable} values
     * defined in the specified streaming route.
     *
     * @param stream the specified streaming route
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V extends Comparable<V>> ExpectingStream<V, E> sort(RouteLevel3<E, ? extends Emitting<? extends V>> stream);

    /**
     * Continue route definition in the given handler of sorted {@link Comparable} values
     * defined in the specified streaming route.
     *
     * @param stream  the specified streaming route
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V extends Comparable<V>, $R extends Routing<?>> $R sort(RouteLevel3<E, ? extends Emitting<? extends V>> stream, Block1<? super V, ? extends Routing<? extends $R>> handler);


    /**
     * Complete route definition as such that sorts with the given {@link Comparator} and emits values
     * defined in the specified streaming route.
     *
     * @param stream     the specified streaming route
     * @param comparator the given values {@link Comparator}
     * @param <V>        the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<V, E> sort(Block<? extends Emitting<? extends V>> stream, Comparator<? super V> comparator);

    /**
     * Continue route definition in the given handler of sorted with the given {@link Comparator} values
     * defined in the specified streaming route.
     *
     * @param stream     the specified streaming route
     * @param comparator the given values {@link Comparator}
     * @param handler    the given values handling route
     * @param <V>        the type of the emitting values
     * @param <$R>       the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R sort(Block<? extends Emitting<? extends V>> stream, Comparator<? super V> comparator, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that sorts with the given {@link Comparator} and emits values
     * defined in the specified streaming route.
     *
     * @param stream     the specified streaming route
     * @param comparator the given values {@link Comparator}
     * @param <V>        the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<V, E> sort(RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream, Comparator<? super V> comparator);

    /**
     * Continue route definition in the given handler of sorted with the given {@link Comparator} values
     * defined in the specified streaming route.
     *
     * @param stream     the specified streaming route
     * @param comparator the given values {@link Comparator}
     * @param handler    the given values handling route
     * @param <V>        the type of the emitting values
     * @param <$R>       the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R sort(RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream, Comparator<? super V> comparator, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that sorts with the given {@link Comparator} and emits values
     * defined in the specified streaming route.
     *
     * @param stream     the specified streaming route
     * @param comparator the given values {@link Comparator}
     * @param <V>        the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<V, E> sort(RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream, Comparator<? super V> comparator);

    /**
     * Continue route definition in the given handler of sorted with the given {@link Comparator} values
     * defined in the specified streaming route.
     *
     * @param stream     the specified streaming route
     * @param comparator the given values {@link Comparator}
     * @param handler    the given values handling route
     * @param <V>        the type of the emitting values
     * @param <$R>       the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R sort(RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream, Comparator<? super V> comparator, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that sorts with the given {@link Comparator} and emits values
     * defined in the specified streaming route.
     *
     * @param stream     the specified streaming route
     * @param comparator the given values {@link Comparator}
     * @param <V>        the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<V, E> sort(RouteLevel3<E, ? extends Emitting<? extends V>> stream, Comparator<? super V> comparator);

    /**
     * Continue route definition in the given handler of sorted with the given {@link Comparator} values
     * defined in the specified streaming route.
     *
     * @param stream     the specified streaming route
     * @param comparator the given values {@link Comparator}
     * @param handler    the given values handling route
     * @param <V>        the type of the emitting values
     * @param <$R>       the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R sort(RouteLevel3<E, ? extends Emitting<? extends V>> stream, Comparator<? super V> comparator, Block1<? super V, ? extends Routing<? extends $R>> handler);


    /**
     * Complete route definition as such that emits only uniques of values
     * defined in the specified streaming route.
     *
     * @param stream the specified streaming route
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<V, E> unique(Block<? extends Emitting<? extends V>> stream);

    /**
     * Complete route definition as such that emits only uniques of values
     * defined in the specified streaming route, as compared by a value returned with the specified {@link Evaluable1Throwing1}.
     *
     * @param stream      the specified streaming route
     * @param keySelector the specified comparing value function
     * @param <V>         the type of the emitting values
     * @param <K>         the type of the value to compare for uniqueness
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, K> ExpectingStream<V, E> unique(Block<? extends Emitting<? extends V>> stream, Evaluable1Throwing1<? super V, ? extends K, ? extends E> keySelector);

    /**
     * Complete route definition as such that emits only uniques of values
     * defined in the specified streaming route.
     *
     * @param stream the specified streaming route
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<V, E> unique(RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream);

    /**
     * Complete route definition as such that emits only uniques of values
     * defined in the specified streaming route, as compared by a value returned with the specified {@link Evaluable1Throwing1}.
     *
     * @param stream      the specified streaming route
     * @param keySelector the specified comparing value function
     * @param <V>         the type of the emitting values
     * @param <K>         the type of the value to compare for uniqueness
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, K> ExpectingStream<V, E> unique(RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream, Evaluable1Throwing1<? super V, ? extends K, ? extends E> keySelector);

    /**
     * Complete route definition as such that emits only uniques of values
     * defined in the specified streaming route.
     *
     * @param stream the specified streaming route
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<V, E> unique(RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream);

    /**
     * Complete route definition as such that emits only uniques of values
     * defined in the specified streaming route, as compared by a value returned with the specified {@link Evaluable1Throwing1}.
     *
     * @param stream      the specified streaming route
     * @param keySelector the specified comparing value function
     * @param <V>         the type of the emitting values
     * @param <K>         the type of the value to compare for uniqueness
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, K> ExpectingStream<V, E> unique(RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream, Evaluable1Throwing1<? super V, ? extends K, ? extends E> keySelector);

    /**
     * Complete route definition as such that emits only uniques of values
     * defined in the specified streaming route.
     *
     * @param stream the specified streaming route
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<V, E> unique(RouteLevel3<E, ? extends Emitting<? extends V>> stream);

    /**
     * Complete route definition as such that emits only uniques of values
     * defined in the specified streaming route, as compared by a value returned with the specified {@link Evaluable1Throwing1}.
     *
     * @param stream      the specified streaming route
     * @param keySelector the specified comparing value function
     * @param <V>         the type of the emitting values
     * @param <K>         the type of the value to compare for uniqueness
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, K> ExpectingStream<V, E> unique(RouteLevel3<E, ? extends Emitting<? extends V>> stream, Evaluable1Throwing1<? super V, ? extends K, ? extends E> keySelector);


    /**
     * Complete route definition as such that emits values defined with the specified streaming route
     * and filtered with the given {@link Testable1Throwing1}.
     *
     * @param stream the specified streaming route
     * @param filter the given {@link Testable1Throwing1} filter
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<V, E> filter(Block<? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> filter);

    /**
     * Continue route definition in the given handler of values defined in the specified streaming route
     * and filtered with the given {@link Testable1Throwing1}.
     *
     * @param stream  the specified streaming route
     * @param filter  the given {@link Testable1Throwing1} filter
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R filter(Block<? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> filter, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits values defined with the specified streaming route
     * and filtered with the given {@link Testable1Throwing1}.
     *
     * @param stream the specified streaming route
     * @param filter the given {@link Testable1Throwing1} filter
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<V, E> filter(RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> filter);

    /**
     * Continue route definition in the given handler of values defined in the specified streaming route
     * and filtered with the given {@link Testable1Throwing1}.
     *
     * @param stream  the specified streaming route
     * @param filter  the given {@link Testable1Throwing1} filter
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R filter(RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> filter, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits values defined with the specified streaming route
     * and filtered with the given {@link Testable1Throwing1}.
     *
     * @param stream the specified streaming route
     * @param filter the given {@link Testable1Throwing1} filter
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<V, E> filter(RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> filter);

    /**
     * Continue route definition in the given handler of values defined in the specified streaming route
     * and filtered with the given {@link Testable1Throwing1}.
     *
     * @param stream  the specified streaming route
     * @param filter  the given {@link Testable1Throwing1} filter
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R filter(RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> filter, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits values defined with the specified streaming route
     * and filtered with the given {@link Testable1Throwing1}.
     *
     * @param stream the specified streaming route
     * @param filter the given {@link Testable1Throwing1} filter
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<V, E> filter(RouteLevel3<E, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> filter);

    /**
     * Continue route definition in the given handler of values defined in the specified streaming route
     * and filtered with the given {@link Testable1Throwing1}.
     *
     * @param stream  the specified streaming route
     * @param filter  the given {@link Testable1Throwing1} filter
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R filter(RouteLevel3<E, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> filter, Block1<? super V, ? extends Routing<? extends $R>> handler);


    /**
     * Complete route definition as such that converts with the given {@link Evaluable1Throwing1} values
     * defined in the specified streaming route.
     *
     * @param stream    the specified streaming route
     * @param converter the given {@link Evaluable1Throwing1} converter
     * @param <O>       the type of the source emitting values
     * @param <V>       the type of the target emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <O, V> ExpectingStream<V, E> map(Block<? extends Emitting<? extends O>> stream, Evaluable1Throwing1<? super O, ? extends V, ? extends E> converter);

    /**
     * Continue route definition in the given handler of converted with the given {@link Evaluable1Throwing1} values
     * defined in the specified streaming route.
     *
     * @param stream    the specified streaming route
     * @param converter the given {@link Evaluable1Throwing1} converter
     * @param handler   the given values handling route
     * @param <O>       the type of the source emitting values
     * @param <V>       the type of the target emitting values
     * @param <$R>      the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <O, V, $R extends Routing<?>> $R map(Block<? extends Emitting<? extends O>> stream, Evaluable1Throwing1<? super O, ? extends V, ? extends E> converter, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that converts with the given {@link Evaluable1Throwing1} values
     * defined in the specified streaming route.
     *
     * @param stream    the specified streaming route
     * @param converter the given {@link Evaluable1Throwing1} converter
     * @param <O>       the type of the source emitting values
     * @param <V>       the type of the target emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <O, V> ExpectingStream<V, E> map(RouteLevel1<? extends E, ? extends Emitting<? extends O>> stream, Evaluable1Throwing1<? super O, ? extends V, ? extends E> converter);

    /**
     * Continue route definition in the given handler of converted with the given {@link Evaluable1Throwing1} values
     * defined in the specified streaming route.
     *
     * @param stream    the specified streaming route
     * @param converter the given {@link Evaluable1Throwing1} converter
     * @param handler   the given values handling route
     * @param <O>       the type of the source emitting values
     * @param <V>       the type of the target emitting values
     * @param <$R>      the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <O, V, $R extends Routing<?>> $R map(RouteLevel1<? extends E, ? extends Emitting<? extends O>> stream, Evaluable1Throwing1<? super O, ? extends V, ? extends E> converter, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that converts with the given {@link Evaluable1Throwing1} values
     * defined in the specified streaming route.
     *
     * @param stream    the specified streaming route
     * @param converter the given {@link Evaluable1Throwing1} converter
     * @param <O>       the type of the source emitting values
     * @param <V>       the type of the target emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <O, V> ExpectingStream<V, E> map(RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends O>> stream, Evaluable1Throwing1<? super O, ? extends V, ? extends E> converter);

    /**
     * Continue route definition in the given handler of converted with the given {@link Evaluable1Throwing1} values
     * defined in the specified streaming route.
     *
     * @param stream    the specified streaming route
     * @param converter the given {@link Evaluable1Throwing1} converter
     * @param handler   the given values handling route
     * @param <O>       the type of the source emitting values
     * @param <V>       the type of the target emitting values
     * @param <$R>      the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <O, V, $R extends Routing<?>> $R map(RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends O>> stream, Evaluable1Throwing1<? super O, ? extends V, ? extends E> converter, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that converts with the given {@link Evaluable1Throwing1} values
     * defined in the specified streaming route.
     *
     * @param stream    the specified streaming route
     * @param converter the given {@link Evaluable1Throwing1} converter
     * @param <O>       the type of the source emitting values
     * @param <V>       the type of the target emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <O, V> ExpectingStream<V, E> map(RouteLevel3<E, ? extends Emitting<? extends O>> stream, Evaluable1Throwing1<? super O, ? extends V, ? extends E> converter);

    /**
     * Continue route definition in the given handler of converted with the given {@link Evaluable1Throwing1} values
     * defined in the specified streaming route.
     *
     * @param stream    the specified streaming route
     * @param converter the given {@link Evaluable1Throwing1} converter
     * @param handler   the given values handling route
     * @param <O>       the type of the source emitting values
     * @param <V>       the type of the target emitting values
     * @param <$R>      the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <O, V, $R extends Routing<?>> $R map(RouteLevel3<E, ? extends Emitting<? extends O>> stream, Evaluable1Throwing1<? super O, ? extends V, ? extends E> converter, Block1<? super V, ? extends Routing<? extends $R>> handler);


    /**
     * Complete route definition as such that emits first of values
     * defined in the specified streaming route.
     *
     * @param stream the specified streaming route
     * @param <V>    the type of the target emitting value
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<V, E> first(Block<? extends Emitting<? extends V>> stream);

    /**
     * Continue route definition in the given handler of first of values
     * defined in the specified streaming route.
     *
     * @param stream  the specified streaming route
     * @param handler the given values handling route
     * @param <V>     the type of the emitting value
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R first(Block<? extends Emitting<? extends V>> stream, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits first of values
     * defined in the specified streaming route.
     *
     * @param stream the specified streaming route
     * @param <V>    the type of the emitting value
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<V, E> first(RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream);

    /**
     * Continue route definition in the given handler of first of values
     * defined in the specified streaming route.
     *
     * @param stream  the specified streaming route
     * @param handler the given values handling route
     * @param <V>     the type of the emitting value
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R first(RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits first of values
     * defined in the specified streaming route.
     *
     * @param stream the specified streaming route
     * @param <V>    the type of the emitting value
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<V, E> first(RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream);

    /**
     * Continue route definition in the given handler of first of values
     * defined in the specified streaming route.
     *
     * @param stream  the specified streaming route
     * @param handler the given values handling route
     * @param <V>     the type of the emitting value
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R first(RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits first of values
     * defined in the specified streaming route.
     *
     * @param stream the specified streaming route
     * @param <V>    the type of the emitting value
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<V, E> first(RouteLevel3<E, ? extends Emitting<? extends V>> stream);

    /**
     * Continue route definition in the given handler of first of values
     * defined in the specified streaming route.
     *
     * @param stream  the specified streaming route
     * @param handler the given values handling route
     * @param <V>     the type of the emitting value
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R first(RouteLevel3<E, ? extends Emitting<? extends V>> stream, Block1<? super V, ? extends Routing<? extends $R>> handler);


    /**
     * Complete route definition as such that emits the given number of values
     * defined in the specified streaming route.
     *
     * @param number the given number of values to emit
     * @param stream the specified streaming route
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<V, E> take(long number, Block<? extends Emitting<? extends V>> stream);

    /**
     * Continue route definition in the given handler for the given number of values
     * defined in the specified streaming route.
     *
     * @param number  the given number of values to emit
     * @param stream  the specified streaming route
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R take(long number, Block<? extends Emitting<? extends V>> stream, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the given number of values
     * defined in the specified streaming route.
     *
     * @param number the given number of values to emit
     * @param stream the specified streaming route
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<V, E> take(long number, RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream);

    /**
     * Continue route definition in the given handler for the given number of values
     * defined in the specified streaming route.
     *
     * @param number  the given number of values to emit
     * @param stream  the specified streaming route
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R take(long number, RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the given number of values
     * defined in the specified streaming route.
     *
     * @param number the given number of values to emit
     * @param stream the specified streaming route
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<V, E> take(long number, RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream);

    /**
     * Continue route definition in the given handler for the given number of values
     * defined in the specified streaming route.
     *
     * @param number  the given number of values to emit
     * @param stream  the specified streaming route
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R take(long number, RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the given number of values
     * defined in the specified streaming route.
     *
     * @param number the given number of values to emit
     * @param stream the specified streaming route
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<V, E> take(long number, RouteLevel3<E, ? extends Emitting<? extends V>> stream);

    /**
     * Continue route definition in the given handler for the given number of values
     * defined in the specified streaming route.
     *
     * @param number  the given number of values to emit
     * @param stream  the specified streaming route
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R take(long number, RouteLevel3<E, ? extends Emitting<? extends V>> stream, Block1<? super V, ? extends Routing<? extends $R>> handler);


    /**
     * Complete route definition as such that emits values defined in the specified streaming route
     * while matching the provided {@link Testable1Throwing1} predicate.
     *
     * @param stream    the specified streaming route
     * @param predicate the provided {@link Testable1Throwing1} predicate
     * @param <V>       the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<V, E> take(Block<? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate);

    /**
     * Continue route definition in the given handler for the values defined in the specified streaming route
     * while matching the provided {@link Testable1Throwing1} predicate.
     *
     * @param stream    the specified streaming route
     * @param predicate the provided {@link Testable1Throwing1} predicate
     * @param handler   the given values handling route
     * @param <V>       the type of the emitting values
     * @param <$R>      the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R take(Block<? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits values defined in the specified streaming route
     * while matching the provided {@link Testable1Throwing1} predicate.
     *
     * @param stream    the specified streaming route
     * @param predicate the provided {@link Testable1Throwing1} predicate
     * @param <V>       the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<V, E> take(RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate);

    /**
     * Continue route definition in the given handler for the values defined in the specified streaming route
     * while matching the provided {@link Testable1Throwing1} predicate.
     *
     * @param stream    the specified streaming route
     * @param predicate the provided {@link Testable1Throwing1} predicate
     * @param handler   the given values handling route
     * @param <V>       the type of the emitting values
     * @param <$R>      the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R take(RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits values defined in the specified streaming route
     * while matching the provided {@link Testable1Throwing1} predicate.
     *
     * @param stream    the specified streaming route
     * @param predicate the provided {@link Testable1Throwing1} predicate
     * @param <V>       the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<V, E> take(RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate);

    /**
     * Continue route definition in the given handler for the values defined in the specified streaming route
     * while matching the provided {@link Testable1Throwing1} predicate.
     *
     * @param stream    the specified streaming route
     * @param predicate the provided {@link Testable1Throwing1} predicate
     * @param handler   the given values handling route
     * @param <V>       the type of the emitting values
     * @param <$R>      the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R take(RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits values defined in the specified streaming route
     * while matching the provided {@link Testable1Throwing1} predicate.
     *
     * @param stream    the specified streaming route
     * @param predicate the provided {@link Testable1Throwing1} predicate
     * @param <V>       the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<V, E> take(RouteLevel3<E, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate);

    /**
     * Continue route definition in the given handler for the values defined in the specified streaming route
     * while matching the provided {@link Testable1Throwing1} predicate.
     *
     * @param stream    the specified streaming route
     * @param predicate the provided {@link Testable1Throwing1} predicate
     * @param handler   the given values handling route
     * @param <V>       the type of the emitting values
     * @param <$R>      the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R take(RouteLevel3<E, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate, Block1<? super V, ? extends Routing<? extends $R>> handler);


    /**
     * Complete route definition as such that skips the given number of values
     * defined in the specified streaming route.
     *
     * @param number the given number of values to skip
     * @param stream the specified streaming route
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<V, E> skip(long number, Block<? extends Emitting<? extends V>> stream);

    /**
     * Continue route definition in the given handler of the remaining after skipping the given number of values
     * defined in the specified streaming route.
     *
     * @param number  the given number of values to skip
     * @param stream  the specified streaming route
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R skip(long number, Block<? extends Emitting<? extends V>> stream, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that skips the given number of values
     * defined in the specified streaming route.
     *
     * @param number the given number of values to skip
     * @param stream the specified streaming route
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<V, E> skip(long number, RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream);

    /**
     * Continue route definition in the given handler of the remaining after skipping the given number of values
     * defined in the specified streaming route.
     *
     * @param number  the given number of values to skip
     * @param stream  the specified streaming route
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R skip(long number, RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that skips the given number of values
     * defined in the specified streaming route.
     *
     * @param number the given number of values to skip
     * @param stream the specified streaming route
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<V, E> skip(long number, RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream);

    /**
     * Continue route definition in the given handler of the remaining after skipping the given number of values
     * defined in the specified streaming route.
     *
     * @param number  the given number of values to skip
     * @param stream  the specified streaming route
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R skip(long number, RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that skips the given number of values
     * defined in the specified streaming route.
     *
     * @param number the given number of values to skip
     * @param stream the specified streaming route
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<V, E> skip(long number, RouteLevel3<E, ? extends Emitting<? extends V>> stream);

    /**
     * Continue route definition in the given handler of the remaining after skipping the given number of values
     * defined in the specified streaming route.
     *
     * @param number  the given number of values to skip
     * @param stream  the specified streaming route
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R skip(long number, RouteLevel3<E, ? extends Emitting<? extends V>> stream, Block1<? super V, ? extends Routing<? extends $R>> handler);


    /**
     * Complete route definition as such that skips values defined in the specified streaming route
     * while matching the provided {@link Testable1Throwing1} predicate.
     *
     * @param stream    the specified streaming route
     * @param predicate the provided {@link Testable1Throwing1} predicate
     * @param <V>       the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<V, E> skip(Block<? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate);

    /**
     * Continue route definition in the provided handler with the remaining values, skipping those determined
     * by the given {@link Testable1Throwing1} predicate, as defined in the specified streaming route.
     *
     * @param stream    the specified streaming route
     * @param predicate the provided {@link Testable1Throwing1} predicate
     * @param handler   the given values handling route
     * @param <V>       the type of the emitting values
     * @param <$R>      the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R skip(Block<? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that skips values defined in the specified streaming route
     * while matching the provided {@link Testable1Throwing1} predicate.
     *
     * @param stream    the specified streaming route
     * @param predicate the provided {@link Testable1Throwing1} predicate
     * @param <V>       the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<V, E> skip(RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate);

    /**
     * Continue route definition in the provided handler with the remaining values, skipping those determined
     * by the given {@link Testable1Throwing1} predicate, as defined in the specified streaming route.
     *
     * @param stream    the specified streaming route
     * @param predicate the provided {@link Testable1Throwing1} predicate
     * @param handler   the given values handling route
     * @param <V>       the type of the emitting values
     * @param <$R>      the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R skip(RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that skips values defined in the specified streaming route
     * while matching the provided {@link Testable1Throwing1} predicate.
     *
     * @param stream    the specified streaming route
     * @param predicate the provided {@link Testable1Throwing1} predicate
     * @param <V>       the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<V, E> skip(RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate);

    /**
     * Continue route definition in the provided handler with the remaining values, skipping those determined
     * by the given {@link Testable1Throwing1} predicate, as defined in the specified streaming route.
     *
     * @param stream    the specified streaming route
     * @param predicate the provided {@link Testable1Throwing1} predicate
     * @param handler   the given values handling route
     * @param <V>       the type of the emitting values
     * @param <$R>      the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R skip(RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that skips values defined in the specified streaming route
     * while matching the provided {@link Testable1Throwing1} predicate.
     *
     * @param stream    the specified streaming route
     * @param predicate the provided {@link Testable1Throwing1} predicate
     * @param <V>       the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<V, E> skip(RouteLevel3<E, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate);

    /**
     * Continue route definition in the provided handler with the remaining values, skipping those determined
     * by the given {@link Testable1Throwing1} predicate, as defined in the specified streaming route.
     *
     * @param stream    the specified streaming route
     * @param predicate the provided {@link Testable1Throwing1} predicate
     * @param handler   the given values handling route
     * @param <V>       the type of the emitting values
     * @param <$R>      the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R skip(RouteLevel3<E, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate, Block1<? super V, ? extends Routing<? extends $R>> handler);


    /**
     * Complete route definition as such that emits the boolean result of testing for {@code true}
     * with the given {@link Testable} of all the values defined in the specified streaming route.
     *
     * @param stream    the specified streaming route
     * @param predicate the given values {@link Testable1Throwing1} predicate
     * @param <V>       the type of the source emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<Boolean, E> all(Block<? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate);

    /**
     * Continue route definition in the given handler of the boolean result of testing for {@code true}
     * with the given {@link Testable} of all the values defined in the specified streaming route.
     *
     * @param stream    the specified streaming route
     * @param predicate the given values {@link Testable1Throwing1} predicate
     * @param handler   the given values handling route
     * @param <V>       the type of the emitting values
     * @param <$R>      the type of the route definition result
     * @return handling route definition result
     */
    <V, $R extends Routing<?>> $R all(Block<? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate, Block1<? super Boolean, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the boolean result of testing for {@code true}
     * with the given {@link Testable} of all the values defined in the specified streaming route.
     *
     * @param stream    the specified streaming route
     * @param predicate the given values {@link Testable1Throwing1} predicate
     * @param <V>       the type of the source emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<Boolean, E> all(RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate);

    /**
     * Continue route definition in the given handler of the boolean result of testing for {@code true}
     * with the given {@link Testable} of all the values defined in the specified streaming route.
     *
     * @param stream    the specified streaming route
     * @param predicate the given values {@link Testable1Throwing1} predicate
     * @param handler   the given values handling route
     * @param <V>       the type of the emitting values
     * @param <$R>      the type of the route definition result
     * @return handling route definition result
     */
    <V, $R extends Routing<?>> $R all(RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate, Block1<? super Boolean, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the boolean result of testing for {@code true}
     * with the given {@link Testable} of all the values defined in the specified streaming route.
     *
     * @param stream    the specified streaming route
     * @param predicate the given values {@link Testable1Throwing1} predicate
     * @param <V>       the type of the source emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<Boolean, E> all(RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate);

    /**
     * Continue route definition in the given handler of the boolean result of testing for {@code true}
     * with the given {@link Testable} of all the values defined in the specified streaming route.
     *
     * @param stream    the specified streaming route
     * @param predicate the given values {@link Testable1Throwing1} predicate
     * @param handler   the given values handling route
     * @param <V>       the type of the emitting values
     * @param <$R>      the type of the route definition result
     * @return handling route definition result
     */
    <V, $R extends Routing<?>> $R all(RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate, Block1<? super Boolean, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the boolean result of testing for {@code true}
     * with the given {@link Testable} of all the values defined in the specified streaming route.
     *
     * @param stream    the specified streaming route
     * @param predicate the given values {@link Testable1Throwing1} predicate
     * @param <V>       the type of the source emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<Boolean, E> all(RouteLevel3<E, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate);

    /**
     * Continue route definition in the given handler of the boolean result of testing for {@code true}
     * with the given {@link Testable} of all the values defined in the specified streaming route.
     *
     * @param stream    the specified streaming route
     * @param predicate the given values {@link Testable1Throwing1} predicate
     * @param handler   the given values handling route
     * @param <V>       the type of the emitting values
     * @param <$R>      the type of the route definition result
     * @return handling route definition result
     */
    <V, $R extends Routing<?>> $R all(RouteLevel3<E, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate, Block1<? super Boolean, ? extends Routing<? extends $R>> handler);


    /**
     * Complete route definition as such that emits the boolean result of testing for {@code true}
     * with the given {@link Testable} of any of the values defined in the specified streaming route.
     *
     * @param stream    the specified streaming route
     * @param predicate the given values {@link Testable1Throwing1} predicate
     * @param <V>       the type of the source emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<Boolean, E> any(Block<? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate);

    /**
     * Continue route definition in the given handler of the boolean result of testing for {@code true}
     * with the given {@link Testable} of any the values defined in the specified streaming route.
     *
     * @param stream    the specified streaming route
     * @param predicate the given values {@link Testable1Throwing1} predicate
     * @param handler   the given values handling route
     * @param <V>       the type of the emitting values
     * @param <$R>      the type of the route definition result
     * @return handling route definition result
     */
    <V, $R extends Routing<?>> $R any(Block<? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate, Block1<? super Boolean, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the boolean result of testing for {@code true}
     * with the given {@link Testable} of any of the values defined in the specified streaming route.
     *
     * @param stream    the specified streaming route
     * @param predicate the given values {@link Testable1Throwing1} predicate
     * @param <V>       the type of the source emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<Boolean, E> any(RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate);

    /**
     * Continue route definition in the given handler of the boolean result of testing for {@code true}
     * with the given {@link Testable} of any the values defined in the specified streaming route.
     *
     * @param stream    the specified streaming route
     * @param predicate the given values {@link Testable1Throwing1} predicate
     * @param handler   the given values handling route
     * @param <V>       the type of the emitting values
     * @param <$R>      the type of the route definition result
     * @return handling route definition result
     */
    <V, $R extends Routing<?>> $R any(RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate, Block1<? super Boolean, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the boolean result of testing for {@code true}
     * with the given {@link Testable} of any of the values defined in the specified streaming route.
     *
     * @param stream    the specified streaming route
     * @param predicate the given values {@link Testable1Throwing1} predicate
     * @param <V>       the type of the source emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<Boolean, E> any(RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate);

    /**
     * Continue route definition in the given handler of the boolean result of testing for {@code true}
     * with the given {@link Testable} of any the values defined in the specified streaming route.
     *
     * @param stream    the specified streaming route
     * @param predicate the given values {@link Testable1Throwing1} predicate
     * @param handler   the given values handling route
     * @param <V>       the type of the emitting values
     * @param <$R>      the type of the route definition result
     * @return handling route definition result
     */
    <V, $R extends Routing<?>> $R any(RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate, Block1<? super Boolean, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the boolean result of testing for {@code true}
     * with the given {@link Testable} of any of the values defined in the specified streaming route.
     *
     * @param stream    the specified streaming route
     * @param predicate the given values {@link Testable1Throwing1} predicate
     * @param <V>       the type of the source emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<Boolean, E> any(RouteLevel3<E, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate);

    /**
     * Continue route definition in the given handler of the boolean result of testing for {@code true}
     * with the given {@link Testable} of any the values defined in the specified streaming route.
     *
     * @param stream    the specified streaming route
     * @param predicate the given values {@link Testable1Throwing1} predicate
     * @param handler   the given values handling route
     * @param <V>       the type of the emitting values
     * @param <$R>      the type of the route definition result
     * @return handling route definition result
     */
    <V, $R extends Routing<?>> $R any(RouteLevel3<E, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate, Block1<? super Boolean, ? extends Routing<? extends $R>> handler);


    /**
     * Complete route definition as such that emits the boolean result of testing for {@code false}
     * with the given {@link Testable} of all the values defined in the specified streaming route.
     *
     * @param stream    the specified streaming route
     * @param predicate the given values {@link Testable1Throwing1} predicate
     * @param <V>       the type of the source emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<Boolean, E> none(Block<? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate);

    /**
     * Continue route definition in the given handler of the boolean result of testing for {@code false}
     * with the given {@link Testable} of all the values defined in the specified streaming route.
     *
     * @param stream    the specified streaming route
     * @param predicate the given values {@link Testable1Throwing1} predicate
     * @param handler   the given values handling route
     * @param <V>       the type of the emitting values
     * @param <$R>      the type of the route definition result
     * @return handling route definition result
     */
    <V, $R extends Routing<?>> $R none(Block<? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate, Block1<? super Boolean, ? extends Routing<? extends $R>> handler);


    /**
     * Complete route definition as such that emits the boolean result of testing for {@code false}
     * with the given {@link Testable} of all the values defined in the specified streaming route.
     *
     * @param stream    the specified streaming route
     * @param predicate the given values {@link Testable1Throwing1} predicate
     * @param <V>       the type of the source emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<Boolean, E> none(RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate);

    /**
     * Continue route definition in the given handler of the boolean result of testing for {@code false}
     * with the given {@link Testable} of all the values defined in the specified streaming route.
     *
     * @param stream    the specified streaming route
     * @param predicate the given values {@link Testable1Throwing1} predicate
     * @param handler   the given values handling route
     * @param <V>       the type of the emitting values
     * @param <$R>      the type of the route definition result
     * @return handling route definition result
     */
    <V, $R extends Routing<?>> $R none(RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate, Block1<? super Boolean, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the boolean result of testing for {@code false}
     * with the given {@link Testable} of all the values defined in the specified streaming route.
     *
     * @param stream    the specified streaming route
     * @param predicate the given values {@link Testable1Throwing1} predicate
     * @param <V>       the type of the source emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<Boolean, E> none(RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate);

    /**
     * Continue route definition in the given handler of the boolean result of testing for {@code false}
     * with the given {@link Testable} of all the values defined in the specified streaming route.
     *
     * @param stream    the specified streaming route
     * @param predicate the given values {@link Testable1Throwing1} predicate
     * @param handler   the given values handling route
     * @param <V>       the type of the emitting values
     * @param <$R>      the type of the route definition result
     * @return handling route definition result
     */
    <V, $R extends Routing<?>> $R none(RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate, Block1<? super Boolean, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the boolean result of testing for {@code false}
     * with the given {@link Testable} of all the values defined in the specified streaming route.
     *
     * @param stream    the specified streaming route
     * @param predicate the given values {@link Testable1Throwing1} predicate
     * @param <V>       the type of the source emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<Boolean, E> none(RouteLevel3<E, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate);

    /**
     * Continue route definition in the given handler of the boolean result of testing for {@code false}
     * with the given {@link Testable} of all the values defined in the specified streaming route.
     *
     * @param stream    the specified streaming route
     * @param predicate the given values {@link Testable1Throwing1} predicate
     * @param handler   the given values handling route
     * @param <V>       the type of the emitting values
     * @param <$R>      the type of the route definition result
     * @return handling route definition result
     */
    <V, $R extends Routing<?>> $R none(RouteLevel3<E, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate, Block1<? super Boolean, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the minimum of the {@link Comparable} values
     * defined in the specified streaming route.
     *
     * @param stream the specified streaming route
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V extends Comparable<V>> ExpectingStream<V, E> min(Block<? extends Emitting<? extends V>> stream);

    /**
     * Continue route definition in the given handler of the minimum of the {@link Comparable} values
     * defined in the specified streaming route.
     *
     * @param stream  the specified streaming route
     * @param handler the given minimum value handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V extends Comparable<V>, $R extends Routing<?>> $R min(Block<? extends Emitting<? extends V>> stream, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the minimum of the {@link Comparable} values
     * defined in the specified streaming route.
     *
     * @param stream the specified streaming route
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V extends Comparable<V>> ExpectingStream<V, E> min(RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream);

    /**
     * Continue route definition in the given handler of the minimum of the {@link Comparable} values
     * defined in the specified streaming route.
     *
     * @param stream  the specified streaming route
     * @param handler the given minimum value handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V extends Comparable<V>, $R extends Routing<?>> $R min(RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the minimum of the {@link Comparable} values
     * defined in the specified streaming route.
     *
     * @param stream the specified streaming route
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V extends Comparable<V>> ExpectingStream<V, E> min(RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream);

    /**
     * Continue route definition in the given handler of the minimum of the {@link Comparable} values
     * defined in the specified streaming route.
     *
     * @param stream  the specified streaming route
     * @param handler the given minimum value handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V extends Comparable<V>, $R extends Routing<?>> $R min(RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the minimum of the {@link Comparable} values
     * defined in the specified streaming route.
     *
     * @param stream the specified streaming route
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V extends Comparable<V>> ExpectingStream<V, E> min(RouteLevel3<E, ? extends Emitting<? extends V>> stream);

    /**
     * Continue route definition in the given handler of the minimum of the {@link Comparable} values
     * defined in the specified streaming route.
     *
     * @param stream  the specified streaming route
     * @param handler the given minimum value handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V extends Comparable<V>, $R extends Routing<?>> $R min(RouteLevel3<E, ? extends Emitting<? extends V>> stream, Block1<? super V, ? extends Routing<? extends $R>> handler);


    /**
     * Complete route definition as such that emits the minimum of the values
     * defined in the specified streaming route using the specified {@link Comparator}.
     *
     * @param stream     the specified streaming route
     * @param comparator the specified {@link Comparator}
     * @param <V>        the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<V, E> min(Block<? extends Emitting<? extends V>> stream, Comparator<? super V> comparator);

    /**
     * Continue route definition in the given handler of the minimum of the values
     * defined in the specified streaming route using the specified {@link Comparator}.
     *
     * @param stream     the specified streaming route
     * @param comparator the specified {@link Comparator}
     * @param handler    the given minimum value handling route
     * @param <V>        the type of the emitting values
     * @param <$R>       the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R min(Block<? extends Emitting<? extends V>> stream, Comparator<? super V> comparator, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the minimum of the values
     * defined in the specified streaming route using the specified {@link Comparator}.
     *
     * @param stream     the specified streaming route
     * @param comparator the specified {@link Comparator}
     * @param <V>        the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<V, E> min(RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream, Comparator<? super V> comparator);

    /**
     * Continue route definition in the given handler of the minimum of the values
     * defined in the specified streaming route using the specified {@link Comparator}.
     *
     * @param stream     the specified streaming route
     * @param comparator the specified {@link Comparator}
     * @param handler    the given minimum value handling route
     * @param <V>        the type of the emitting values
     * @param <$R>       the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R min(RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream, Comparator<? super V> comparator, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the minimum of the values
     * defined in the specified streaming route using the specified {@link Comparator}.
     *
     * @param stream     the specified streaming route
     * @param comparator the specified {@link Comparator}
     * @param <V>        the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<V, E> min(RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream, Comparator<? super V> comparator);

    /**
     * Continue route definition in the given handler of the minimum of the values
     * defined in the specified streaming route using the specified {@link Comparator}.
     *
     * @param stream     the specified streaming route
     * @param comparator the specified {@link Comparator}
     * @param handler    the given minimum value handling route
     * @param <V>        the type of the emitting values
     * @param <$R>       the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R min(RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream, Comparator<? super V> comparator, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the minimum of the values
     * defined in the specified streaming route using the specified {@link Comparator}.
     *
     * @param stream     the specified streaming route
     * @param comparator the specified {@link Comparator}
     * @param <V>        the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<V, E> min(RouteLevel3<E, ? extends Emitting<? extends V>> stream, Comparator<? super V> comparator);

    /**
     * Continue route definition in the given handler of the minimum of the values
     * defined in the specified streaming route using the specified {@link Comparator}.
     *
     * @param stream     the specified streaming route
     * @param comparator the specified {@link Comparator}
     * @param handler    the given minimum value handling route
     * @param <V>        the type of the emitting values
     * @param <$R>       the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R min(RouteLevel3<E, ? extends Emitting<? extends V>> stream, Comparator<? super V> comparator, Block1<? super V, ? extends Routing<? extends $R>> handler);


    /**
     * Complete route definition as such that emits the maximum of the {@link Comparable} values
     * defined in the specified streaming route.
     *
     * @param stream the specified streaming route
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V extends Comparable<V>> ExpectingStream<V, E> max(Block<? extends Emitting<? extends V>> stream);

    /**
     * Continue route definition in the given handler of the maximum of the {@link Comparable} values
     * defined in the specified streaming route.
     *
     * @param stream  the specified streaming route
     * @param handler the given maximum value handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V extends Comparable<V>, $R extends Routing<?>> $R max(Block<? extends Emitting<? extends V>> stream, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the maximum of the {@link Comparable} values
     * defined in the specified streaming route.
     *
     * @param stream the specified streaming route
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V extends Comparable<V>> ExpectingStream<V, E> max(RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream);

    /**
     * Continue route definition in the given handler of the maximum of the {@link Comparable} values
     * defined in the specified streaming route.
     *
     * @param stream  the specified streaming route
     * @param handler the given maximum value handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V extends Comparable<V>, $R extends Routing<?>> $R max(RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the maximum of the {@link Comparable} values
     * defined in the specified streaming route.
     *
     * @param stream the specified streaming route
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V extends Comparable<V>> ExpectingStream<V, E> max(RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream);

    /**
     * Continue route definition in the given handler of the maximum of the {@link Comparable} values
     * defined in the specified streaming route.
     *
     * @param stream  the specified streaming route
     * @param handler the given maximum value handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V extends Comparable<V>, $R extends Routing<?>> $R max(RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the maximum of the {@link Comparable} values
     * defined in the specified streaming route.
     *
     * @param stream the specified streaming route
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V extends Comparable<V>> ExpectingStream<V, E> max(RouteLevel3<E, ? extends Emitting<? extends V>> stream);

    /**
     * Continue route definition in the given handler of the maximum of the {@link Comparable} values
     * defined in the specified streaming route.
     *
     * @param stream  the specified streaming route
     * @param handler the given maximum value handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V extends Comparable<V>, $R extends Routing<?>> $R max(RouteLevel3<E, ? extends Emitting<? extends V>> stream, Block1<? super V, ? extends Routing<? extends $R>> handler);


    /**
     * Complete route definition as such that emits the maximum of the values
     * defined in the specified streaming route using the specified {@link Comparator}.
     *
     * @param stream     the specified streaming route
     * @param comparator the specified {@link Comparator}
     * @param <V>        the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<V, E> max(Block<? extends Emitting<? extends V>> stream, Comparator<? super V> comparator);

    /**
     * Continue route definition in the given handler of the maximum of the values
     * defined in the specified streaming route using the specified {@link Comparator}.
     *
     * @param stream     the specified streaming route
     * @param comparator the specified {@link Comparator}
     * @param handler    the given maximum value handling route
     * @param <V>        the type of the emitting values
     * @param <$R>       the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R max(Block<? extends Emitting<? extends V>> stream, Comparator<? super V> comparator, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the maximum of the values
     * defined in the specified streaming route using the specified {@link Comparator}.
     *
     * @param stream     the specified streaming route
     * @param comparator the specified {@link Comparator}
     * @param <V>        the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<V, E> max(RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream, Comparator<? super V> comparator);

    /**
     * Continue route definition in the given handler of the maximum of the values
     * defined in the specified streaming route using the specified {@link Comparator}.
     *
     * @param stream     the specified streaming route
     * @param comparator the specified {@link Comparator}
     * @param handler    the given maximum value handling route
     * @param <V>        the type of the emitting values
     * @param <$R>       the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R max(RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream, Comparator<? super V> comparator, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the maximum of the values
     * defined in the specified streaming route using the specified {@link Comparator}.
     *
     * @param stream     the specified streaming route
     * @param comparator the specified {@link Comparator}
     * @param <V>        the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<V, E> max(RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream, Comparator<? super V> comparator);

    /**
     * Continue route definition in the given handler of the maximum of the values
     * defined in the specified streaming route using the specified {@link Comparator}.
     *
     * @param stream     the specified streaming route
     * @param comparator the specified {@link Comparator}
     * @param handler    the given maximum value handling route
     * @param <V>        the type of the emitting values
     * @param <$R>       the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R max(RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream, Comparator<? super V> comparator, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the maximum of the values
     * defined in the specified streaming route using the specified {@link Comparator}.
     *
     * @param stream     the specified streaming route
     * @param comparator the specified {@link Comparator}
     * @param <V>        the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<V, E> max(RouteLevel3<E, ? extends Emitting<? extends V>> stream, Comparator<? super V> comparator);

    /**
     * Continue route definition in the given handler of the maximum of the values
     * defined in the specified streaming route using the specified {@link Comparator}.
     *
     * @param stream     the specified streaming route
     * @param comparator the specified {@link Comparator}
     * @param handler    the given maximum value handling route
     * @param <V>        the type of the emitting values
     * @param <$R>       the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R max(RouteLevel3<E, ? extends Emitting<? extends V>> stream, Comparator<? super V> comparator, Block1<? super V, ? extends Routing<? extends $R>> handler);


    /**
     * Complete route definition as such that emits the reduction operation result of the values
     * defined in the specified streaming route using the specified combination function.
     *
     * @param <V>         the type of the emitting values
     * @param stream      the specified streaming route
     * @param accumulator two values combination function
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<V, E> reduce(Block<? extends Emitting<? extends V>> stream, Evaluable2<? super V, ? super V, ? extends V> accumulator);

    /**
     * Continue route definition in the given handler of the reduction operation result of the values
     * defined in the specified streaming route using the specified combination function.
     *
     * @param <V>         the type of the emitting values
     * @param <$R>        the type of the route definition result
     * @param stream      the specified streaming route
     * @param accumulator two values combination function
     * @param handler     the given reduction value handling route
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R reduce(Block<? extends Emitting<? extends V>> stream, Evaluable2<? super V, ? super V, ? extends V> accumulator, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the reduction operation result of the values
     * defined in the specified streaming route using the specified combination function.
     *
     * @param <V>         the type of the emitting values
     * @param stream      the specified streaming route
     * @param accumulator two values combination function
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<V, E> reduce(RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream, Evaluable2<? super V, ? super V, ? extends V> accumulator);

    /**
     * Continue route definition in the given handler of the reduction operation result of the values
     * defined in the specified streaming route using the specified combination function.
     *
     * @param <V>         the type of the emitting values
     * @param <$R>        the type of the route definition result
     * @param stream      the specified streaming route
     * @param accumulator two values combination function
     * @param handler     the given reduction value handling route
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R reduce(RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream, Evaluable2<? super V, ? super V, ? extends V> accumulator, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the reduction operation result of the values
     * defined in the specified streaming route using the specified combination function.
     *
     * @param <V>         the type of the emitting values
     * @param stream      the specified streaming route
     * @param accumulator two values combination function
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<V, E> reduce(RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream, Evaluable2<? super V, ? super V, ? extends V> accumulator);

    /**
     * Continue route definition in the given handler of the reduction operation result of the values
     * defined in the specified streaming route using the specified combination function.
     *
     * @param <V>         the type of the emitting values
     * @param <$R>        the type of the route definition result
     * @param stream      the specified streaming route
     * @param accumulator two values combination function
     * @param handler     the given reduction value handling route
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R reduce(RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream, Evaluable2<? super V, ? super V, ? extends V> accumulator, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the reduction operation result of the values
     * defined in the specified streaming route using the specified combination function.
     *
     * @param <V>         the type of the emitting values
     * @param stream      the specified streaming route
     * @param accumulator two values combination function
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<V, E> reduce(RouteLevel3<E, ? extends Emitting<? extends V>> stream, Evaluable2<? super V, ? super V, ? extends V> accumulator);

    /**
     * Continue route definition in the given handler of the reduction operation result of the values
     * defined in the specified streaming route using the specified combination function.
     *
     * @param <V>         the type of the emitting values
     * @param <$R>        the type of the route definition result
     * @param stream      the specified streaming route
     * @param accumulator two values combination function
     * @param handler     the given reduction value handling route
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R reduce(RouteLevel3<E, ? extends Emitting<? extends V>> stream, Evaluable2<? super V, ? super V, ? extends V> accumulator, Block1<? super V, ? extends Routing<? extends $R>> handler);


    /**
     * Complete route definition as such that emits the reduction operation result of the values
     * defined in the specified streaming route using the specified initial value and the combination function.
     *
     * @param <O>         the type of the source emitting values
     * @param <V>         the type of the target emitting values
     * @param initial     the specified source initial value
     * @param stream      the specified streaming route
     * @param accumulator two values combination function
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <O, V> ExpectingStream<V, E> reduce(V initial, Block<? extends Emitting<? extends O>> stream, Evaluable2<? super V, ? super O, ? extends V> accumulator);

    /**
     * Continue route definition in the given handler of the reduction operation result of the values
     * defined in the specified streaming route using the specified initial value and the combination function.
     *
     * @param initial     the specified source initial value
     * @param stream      the specified streaming route
     * @param accumulator two values combination function
     * @param handler     the given reduction value handling route
     * @param <O>         the type of the source emitting values
     * @param <V>         the type of the target emitting values
     * @param <$R>        the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <O, V, $R extends Routing<?>> $R reduce(V initial, Block<? extends Emitting<? extends O>> stream, Evaluable2<? super V, ? super O, ? extends V> accumulator, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the reduction operation result of the values
     * defined in the specified streaming route using the specified initial value and the combination function.
     *
     * @param initial     the specified source initial value
     * @param stream      the specified streaming route
     * @param accumulator two values combination function
     * @param <O>         the type of the source emitting values
     * @param <V>         the type of the target emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <O, V> ExpectingStream<V, E> reduce(V initial, RouteLevel1<? extends E, ? extends Emitting<? extends O>> stream, Evaluable2<? super V, ? super O, ? extends V> accumulator);

    /**
     * Continue route definition in the given handler of the reduction operation result of the values
     * defined in the specified streaming route using the specified initial value and the combination function.
     *
     * @param initial     the specified source initial value
     * @param stream      the specified streaming route
     * @param accumulator two values combination function
     * @param handler     the given reduction value handling route
     * @param <O>         the type of the source emitting values
     * @param <V>         the type of the target emitting values
     * @param <$R>        the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <O, V, $R extends Routing<?>> $R reduce(V initial, RouteLevel1<? extends E, ? extends Emitting<? extends O>> stream, Evaluable2<? super V, ? super O, ? extends V> accumulator, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the reduction operation result of the values
     * defined in the specified streaming route using the specified initial value and the combination function.
     *
     * @param initial     the specified source initial value
     * @param stream      the specified streaming route
     * @param accumulator two values combination function
     * @param <O>         the type of the source emitting values
     * @param <V>         the type of the target emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <O, V> ExpectingStream<V, E> reduce(V initial, RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends O>> stream, Evaluable2<? super V, ? super O, ? extends V> accumulator);

    /**
     * Continue route definition in the given handler of the reduction operation result of the values
     * defined in the specified streaming route using the specified initial value and the combination function.
     *
     * @param initial     the specified source initial value
     * @param stream      the specified streaming route
     * @param accumulator two values combination function
     * @param handler     the given reduction value handling route
     * @param <O>         the type of the source emitting values
     * @param <V>         the type of the target emitting values
     * @param <$R>        the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <O, V, $R extends Routing<?>> $R reduce(V initial, RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends O>> stream, Evaluable2<? super V, ? super O, ? extends V> accumulator, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the reduction operation result of the values
     * defined in the specified streaming route using the specified initial value and the combination function.
     *
     * @param initial     the specified source initial value
     * @param stream      the specified streaming route
     * @param accumulator two values combination function
     * @param <O>         the type of the source emitting values
     * @param <V>         the type of the target emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <O, V> ExpectingStream<V, E> reduce(V initial, RouteLevel3<E, ? extends Emitting<? extends O>> stream, Evaluable2<? super V, ? super O, ? extends V> accumulator);

    /**
     * Continue route definition in the given handler of the reduction operation result of the values
     * defined in the specified streaming route using the specified initial value and the combination function.
     *
     * @param initial     the specified source initial value
     * @param stream      the specified streaming route
     * @param accumulator two values combination function
     * @param handler     the given reduction value handling route
     * @param <O>         the type of the source emitting values
     * @param <V>         the type of the target emitting values
     * @param <$R>        the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <O, V, $R extends Routing<?>> $R reduce(V initial, RouteLevel3<E, ? extends Emitting<? extends O>> stream, Evaluable2<? super V, ? super O, ? extends V> accumulator, Block1<? super V, ? extends Routing<? extends $R>> handler);


    /**
     * Complete route definition as such that emits the reduction operation result of the values
     * defined in the specified streaming route using the specified {@link Collector} function.
     *
     * @param stream    the specified streaming route
     * @param collector the specified {@link Collector}
     * @param <O>       the type of the source emitting values
     * @param <V>       the type of the target emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <O, V> ExpectingStream<V, E> collect(Block<? extends Emitting<? extends O>> stream, Collector<? super O, ?, ? extends V> collector);

    /**
     * Continue route definition in the given handler of the reduction operation result of the values
     * defined in the specified streaming route using the specified {@link Collector} function.
     *
     * @param stream    the specified streaming route
     * @param collector the specified {@link Collector}
     * @param handler   the given reduction value handling route
     * @param <O>       the type of the source emitting values
     * @param <V>       the type of the target emitting values
     * @param <$R>      the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <O, V, $R extends Routing<?>> $R collect(Block<? extends Emitting<? extends O>> stream, Collector<? super O, ?, ? extends V> collector, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the reduction operation result of the values
     * defined in the specified streaming route using the specified {@link Collector} function.
     *
     * @param stream    the specified streaming route
     * @param collector the specified {@link Collector}
     * @param <O>       the type of the source emitting values
     * @param <V>       the type of the target emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <O, V> ExpectingStream<V, E> collect(RouteLevel1<? extends E, ? extends Emitting<? extends O>> stream, Collector<? super O, ?, ? extends V> collector);

    /**
     * Continue route definition in the given handler of the reduction operation result of the values
     * defined in the specified streaming route using the specified {@link Collector} function.
     *
     * @param stream    the specified streaming route
     * @param collector the specified {@link Collector}
     * @param handler   the given reduction value handling route
     * @param <O>       the type of the source emitting values
     * @param <V>       the type of the target emitting values
     * @param <$R>      the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <O, V, $R extends Routing<?>> $R collect(RouteLevel1<? extends E, ? extends Emitting<? extends O>> stream, Collector<? super O, ?, ? extends V> collector, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the reduction operation result of the values
     * defined in the specified streaming route using the specified {@link Collector} function.
     *
     * @param stream    the specified streaming route
     * @param collector the specified {@link Collector}
     * @param <O>       the type of the source emitting values
     * @param <V>       the type of the target emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <O, V> ExpectingStream<V, E> collect(RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends O>> stream, Collector<? super O, ?, ? extends V> collector);

    /**
     * Continue route definition in the given handler of the reduction operation result of the values
     * defined in the specified streaming route using the specified {@link Collector} function.
     *
     * @param stream    the specified streaming route
     * @param collector the specified {@link Collector}
     * @param handler   the given reduction value handling route
     * @param <O>       the type of the source emitting values
     * @param <V>       the type of the target emitting values
     * @param <$R>      the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <O, V, $R extends Routing<?>> $R collect(RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends O>> stream, Collector<? super O, ?, ? extends V> collector, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the reduction operation result of the values
     * defined in the specified streaming route using the specified {@link Collector} function.
     *
     * @param stream    the specified streaming route
     * @param collector the specified {@link Collector}
     * @param <O>       the type of the source emitting values
     * @param <V>       the type of the target emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <O, V> ExpectingStream<V, E> collect(RouteLevel3<E, ? extends Emitting<? extends O>> stream, Collector<? super O, ?, ? extends V> collector);

    /**
     * Continue route definition in the given handler of the reduction operation result of the values
     * defined in the specified streaming route using the specified {@link Collector} function.
     *
     * @param stream    the specified streaming route
     * @param collector the specified {@link Collector}
     * @param handler   the given reduction value handling route
     * @param <O>       the type of the source emitting values
     * @param <V>       the type of the target emitting values
     * @param <$R>      the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <O, V, $R extends Routing<?>> $R collect(RouteLevel3<E, ? extends Emitting<? extends O>> stream, Collector<? super O, ?, ? extends V> collector, Block1<? super V, ? extends Routing<? extends $R>> handler);


    /**
     * Complete route definition as such that emits the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param <V>     the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<V, E> concat(Block<? extends Emitting<? extends V>> stream1, Block<? extends Emitting<? extends V>> stream2);

    /**
     * Continue route definition in the given handler of the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R concat(Block<? extends Emitting<? extends V>> stream1, Block<? extends Emitting<? extends V>> stream2, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param <V>     the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<V, E> concat(Block<? extends Emitting<? extends V>> stream1, RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream2);

    /**
     * Continue route definition in the given handler of the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R concat(Block<? extends Emitting<? extends V>> stream1, RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream2, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param <V>     the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<V, E> concat(Block<? extends Emitting<? extends V>> stream1, RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream2);

    /**
     * Continue route definition in the given handler of the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R concat(Block<? extends Emitting<? extends V>> stream1, RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream2, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param <V>     the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<V, E> concat(Block<? extends Emitting<? extends V>> stream1, RouteLevel3<E, ? extends Emitting<? extends V>> stream2);

    /**
     * Continue route definition in the given handler of the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R concat(Block<? extends Emitting<? extends V>> stream1, RouteLevel3<E, ? extends Emitting<? extends V>> stream2, Block1<? super V, ? extends Routing<? extends $R>> handler);


    /**
     * Complete route definition as such that emits the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param <V>     the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<V, E> concat(RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream1, Block<? extends Emitting<? extends V>> stream2);

    /**
     * Continue route definition in the given handler of the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R concat(RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream1, Block<? extends Emitting<? extends V>> stream2, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param <V>     the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<V, E> concat(RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream1, RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream2);

    /**
     * Continue route definition in the given handler of the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R concat(RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream1, RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream2, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param <V>     the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<V, E> concat(RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream1, RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream2);

    /**
     * Continue route definition in the given handler of the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R concat(RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream1, RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream2, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param <V>     the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<V, E> concat(RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream1, RouteLevel3<E, ? extends Emitting<? extends V>> stream2);

    /**
     * Continue route definition in the given handler of the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R concat(RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream1, RouteLevel3<E, ? extends Emitting<? extends V>> stream2, Block1<? super V, ? extends Routing<? extends $R>> handler);


    /**
     * Complete route definition as such that emits the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param <V>     the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<V, E> concat(RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream1, Block<? extends Emitting<? extends V>> stream2);

    /**
     * Continue route definition in the given handler of the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R concat(RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream1, Block<? extends Emitting<? extends V>> stream2, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param <V>     the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<V, E> concat(RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream1, RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream2);

    /**
     * Continue route definition in the given handler of the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R concat(RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream1, RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream2, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param <V>     the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<V, E> concat(RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream1, RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream2);

    /**
     * Continue route definition in the given handler of the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R concat(RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream1, RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream2, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param <V>     the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<V, E> concat(RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream1, RouteLevel3<E, ? extends Emitting<? extends V>> stream2);

    /**
     * Continue route definition in the given handler of the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R concat(RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream1, RouteLevel3<E, ? extends Emitting<? extends V>> stream2, Block1<? super V, ? extends Routing<? extends $R>> handler);


    /**
     * Complete route definition as such that emits the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param <V>     the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<V, E> concat(RouteLevel3<E, ? extends Emitting<? extends V>> stream1, Block<? extends Emitting<? extends V>> stream2);

    /**
     * Continue route definition in the given handler of the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R concat(RouteLevel3<E, ? extends Emitting<? extends V>> stream1, Block<? extends Emitting<? extends V>> stream2, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param <V>     the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<V, E> concat(RouteLevel3<E, ? extends Emitting<? extends V>> stream1, RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream2);

    /**
     * Continue route definition in the given handler of the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R concat(RouteLevel3<E, ? extends Emitting<? extends V>> stream1, RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream2, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param <V>     the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<V, E> concat(RouteLevel3<E, ? extends Emitting<? extends V>> stream1, RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream2);

    /**
     * Continue route definition in the given handler of the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R concat(RouteLevel3<E, ? extends Emitting<? extends V>> stream1, RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream2, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param <V>     the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<V, E> concat(RouteLevel3<E, ? extends Emitting<? extends V>> stream1, RouteLevel3<E, ? extends Emitting<? extends V>> stream2);

    /**
     * Continue route definition in the given handler of the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R concat(RouteLevel3<E, ? extends Emitting<? extends V>> stream1, RouteLevel3<E, ? extends Emitting<? extends V>> stream2, Block1<? super V, ? extends Routing<? extends $R>> handler);


    /**
     * Add optionally the execution of the specified route to the flow
     * depending on the specified boolean result flag match.
     *
     * @param predicate the specified boolean result value
     * @param route     the specified route definition
     * @return the action choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    ChoosingAction<$F, E> either(Value<Boolean> predicate, ActionBlock route);

    /**
     * Add optionally the execution of the specified route to the flow
     * depending on the specified boolean result flag match.
     *
     * @param predicate the specified boolean result value
     * @param route     the specified route definition
     * @return the action choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    ChoosingAction<$F, E> either(Value<Boolean> predicate, ActionLevel1<? extends E> route);

    /**
     * Add optionally the execution of the specified route to the flow
     * depending on the specified boolean result flag match.
     *
     * @param predicate the specified boolean result value
     * @param route     the specified route definition
     * @return the action choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    ChoosingAction<$F, E> either(Value<Boolean> predicate, ActionLevel2<? extends RuntimeException> route);

    /**
     * Add optionally the execution of the specified route to the flow
     * depending on the specified boolean result flag match.
     *
     * @param predicate the specified boolean result value
     * @param route     the specified route definition
     * @return the action choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    ChoosingAction<$F, E> either(Value<Boolean> predicate, ActionLevel3<E> route);

    /**
     * Complete route definition as such that emits optionally values defined in the specified streaming route
     * depending on the specified boolean result flag match.
     *
     * @param predicate the specified boolean result value
     * @param route     the specified route definition
     * @param <V>       the type of the emitting values
     * @return the streaming choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ChoosingStream<V, E> either(Value<Boolean> predicate, StreamBlock<V> route);

    /**
     * Complete route definition as such that emits optionally values defined in the specified streaming route
     * depending on the specified boolean result flag match.
     *
     * @param predicate the specified boolean result value
     * @param route     the specified route definition
     * @param <V>       the type of the emitting values
     * @return the streaming choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ChoosingStream<V, E> either(Value<Boolean> predicate, StreamLevel1<V, ? extends E> route);

    /**
     * Complete route definition as such that emits optionally values defined in the specified streaming route
     * depending on the specified boolean result flag match.
     *
     * @param predicate the specified boolean result value
     * @param route     the specified route definition
     * @param <V>       the type of the emitting values
     * @return the streaming choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ChoosingStream<V, E> either(Value<Boolean> predicate, StreamLevel2<V, ? extends RuntimeException> route);

    /**
     * Complete route definition as such that emits optionally values defined in the specified streaming route
     * depending on the specified boolean result flag match.
     *
     * @param predicate the specified boolean result value
     * @param route     the specified route definition
     * @param <V>       the type of the emitting values
     * @return the streaming choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ChoosingStream<V, E> either(Value<Boolean> predicate, StreamLevel3<V, E> route);

    /**
     * Add optionally the execution of the specified route to the flow
     * depending on the specified {@link Testable} match.
     *
     * @param predicate the specified {@link Testable}
     * @param route     the specified route definition
     * @return the action choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    ChoosingAction<$F, E> either(TestableThrowing1<? extends E> predicate, ActionBlock route);

    /**
     * Add optionally the execution of the specified route to the flow
     * depending on the specified {@link Testable} match.
     *
     * @param predicate the specified {@link Testable}
     * @param route     the specified route definition
     * @return the action choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    ChoosingAction<$F, E> either(TestableThrowing1<? extends E> predicate, ActionLevel1<? extends E> route);

    /**
     * Add optionally the execution of the specified route to the flow
     * depending on the specified {@link Testable} match.
     *
     * @param predicate the specified {@link Testable}
     * @param route     the specified route definition
     * @return the action choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    ChoosingAction<$F, E> either(TestableThrowing1<? extends E> predicate, ActionLevel2<? extends RuntimeException> route);

    /**
     * Add optionally the execution of the specified route to the flow
     * depending on the specified {@link Testable} match.
     *
     * @param predicate the specified {@link Testable}
     * @param route     the specified route definition
     * @return the action choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    ChoosingAction<$F, E> either(TestableThrowing1<? extends E> predicate, ActionLevel3<E> route);

    /**
     * Complete route definition as such that emits optionally value defined in the specified streaming route
     * depending on the specified {@link Testable} match.
     *
     * @param predicate the specified {@link Testable}
     * @param route     the specified route definition
     * @param <V>       the type of the emitting values
     * @return the streaming choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ChoosingStream<V, E> either(TestableThrowing1<? extends E> predicate, StreamBlock<V> route);

    /**
     * Complete route definition as such that emits optionally value defined in the specified streaming route
     * depending on the specified {@link Testable} match.
     *
     * @param predicate the specified {@link Testable}
     * @param route     the specified route definition
     * @param <V>       the type of the emitting values
     * @return the streaming choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ChoosingStream<V, E> either(TestableThrowing1<? extends E> predicate, StreamLevel1<V, ? extends E> route);

    /**
     * Complete route definition as such that emits optionally value defined in the specified streaming route
     * depending on the specified {@link Testable} match.
     *
     * @param predicate the specified {@link Testable}
     * @param route     the specified route definition
     * @param <V>       the type of the emitting values
     * @return the streaming choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ChoosingStream<V, E> either(TestableThrowing1<? extends E> predicate, StreamLevel2<V, ? extends RuntimeException> route);

    /**
     * Complete route definition as such that emits optionally value defined in the specified streaming route
     * depending on the specified {@link Testable} match.
     *
     * @param predicate the specified {@link Testable}
     * @param route     the specified route definition
     * @param <V>       the type of the emitting values
     * @return the streaming choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ChoosingStream<V, E> either(TestableThrowing1<? extends E> predicate, StreamLevel3<V, E> route);


    /**
     * Add the specified {@link Executable1} execution by the specified argument value to the flow.
     *
     * @param value     the specified argument value
     * @param execution the specified {@link Executable1} execution
     * @param <I>       the type of the argument
     * @return the flow definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I> ExpectingAction<$F, E> effect(Value<? extends I> value, Executable1Throwing1<? super I, ? extends E> execution);


    /**
     * Complete route definition as such that emits a value from the specified {@link Evaluable1Throwing1}
     * by the specified argument value.
     *
     * @param value    the specified argument value
     * @param supplier the specified value {@link Evaluable1Throwing1} supplier
     * @param <I>      the type of the argument
     * @param <V>      the type of the emitting value
     * @return emitting result definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I, V> ExpectingStream<V, E> supply(Value<? extends I> value, Evaluable1Throwing1<? super I, ? extends V, ? extends E> supplier);

    /**
     * Continue route definition in the given handler of the value from the specified {@link Evaluable1Throwing1} supplier
     * by the specified argument value.
     *
     * @param value    the specified argument value
     * @param supplier the specified value {@link Evaluable1Throwing1} supplier
     * @param handler  the given value handling route
     * @param <I>      the type of the argument
     * @param <V>      the type of the emitting value
     * @param <$R>     the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <I, V, $R extends Routing<?>> $R supply(Value<? extends I> value, Evaluable1Throwing1<? super I, ? extends V, ? extends E> supplier, Block1<? super V, ? extends Routing<? extends $R>> handler);


    /**
     * Complete route definition as such that emits values from the supplying {@link BaseStream} source
     * by the specified argument value.
     *
     * @param value  the specified argument value
     * @param source the supplying {@link BaseStream} source
     * @param <I>    the type of the argument
     * @param <V>    the type of the emitting values
     * @return emitting result definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I, V> ExpectingStream<V, E> source(Value<? extends I> value, Evaluable1Throwing1<? super I, ? extends BaseStream<V, ?>, ? extends E> source);

    /**
     * Continue route definition in the given handler of values from the supplying {@link BaseStream} source
     * by the specified argument value.
     *
     * @param value   the specified argument value
     * @param source  the supplying {@link BaseStream} source
     * @param handler the given value handling route
     * @param <I>     the type of the argument
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <I, V, $R extends Routing<?>> $R source(Value<? extends I> value, Evaluable1Throwing1<? super I, ? extends BaseStream<V, ?>, ? extends E> source, Block1<? super V, ? extends Routing<? extends $R>> handler);


    /**
     * Add the execution of the specified route by the specified argument value to the flow.
     *
     * @param route the specified route definition
     * @param value the specified argument value
     * @param <I>   the type of the argument
     * @param <H>   the type of unexpected exception that might be thrown
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I, H extends Exception> CatchingAction<$F, H, E> action(Route1Level0<? super I, ? extends H, ?> route, Value<? extends I> value);

    /**
     * Add the execution of the specified route by the specified argument value to the flow.
     *
     * @param route the specified route definition
     * @param value the specified argument value
     * @param <I>   the type of the argument
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I> ExpectingAction<$F, E> action(Route1Level1<? super I, ? extends E, ?> route, Value<? extends I> value);

    /**
     * Add the execution of the specified route by the specified argument value to the flow.
     *
     * @param route the specified route definition
     * @param value the specified argument value
     * @param <I>   the type of the argument
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I> ExpectingAction<$F, E> action(Route1Level2<? super I, ? extends RuntimeException, ?> route, Value<? extends I> value);

    /**
     * Add the execution of the specified route by the specified argument value to the flow.
     *
     * @param route the specified route definition
     * @param value the specified argument value
     * @param <I>   the type of the argument
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I> ExpectingAction<$F, E> action(Route1Level3<? super I, E, ?> route, Value<? extends I> value);


    /**
     * Add the execution of the {@link Emittable} specified by the definition object
     * by the specified argument to the flow.
     *
     * @param route the specified {@link Emittable} definition object
     * @param value the specified argument value
     * @param <I>   the type of the argument
     * @param <H>   the type of unexpected exception that might be thrown
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I, H extends Exception> CatchingAction<$F, H, E> action(ValueLevel0<? extends Evaluable1Throwing1<? super I, ? extends Emittable<?, ? extends H>, ? extends H>> route, Value<? extends I> value);

    /**
     * Add the execution of the {@link Emittable} specified by the definition object
     * by the specified argument to the flow.
     *
     * @param route the specified {@link Emittable} definition object
     * @param value the specified argument value
     * @param <I>   the type of the argument
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I> ExpectingAction<$F, E> action(ValueLevel1<? extends Evaluable1Throwing1<? super I, ? extends Emittable<?, ? extends E>, ? extends E>> route, Value<? extends I> value);

    /**
     * Add the execution of the {@link Emittable} specified by the definition object
     * by the specified argument to the flow.
     *
     * @param route the specified {@link Emittable} definition object
     * @param value the specified argument value
     * @param <I>   the type of the argument
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I> ExpectingAction<$F, E> action(ValueLevel2<? extends Evaluable1Throwing1<? super I, ? extends Emittable<?, ? extends RuntimeException>, ? extends RuntimeException>> route, Value<? extends I> value);

    /**
     * Add the execution of the {@link Emittable} specified by the definition object
     * by the specified argument to the flow.
     *
     * @param route the specified {@link Emittable} definition object
     * @param value the specified argument value
     * @param <I>   the type of the argument
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I> ExpectingAction<$F, E> action(ValueLevel3<? extends Evaluable1Throwing1<? super I, ? extends Emittable<?, E>, E>> route, Value<? extends I> value);


    /**
     * Complete route definition as such that emits values defined
     * in the specified streaming route by the specified argument.
     *
     * @param stream the specified streaming route
     * @param value  the specified argument value
     * @param <I>    the type of the argument
     * @param <V>    the type of the emitting values
     * @param <H>    the type of unexpected exception that might be thrown
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I, V, H extends Exception> CatchingStream<V, H, E> stream(Route1Level0<? super I, ? extends H, ? extends Emitting<? extends V>> stream, Value<? extends I> value);

    /**
     * Complete route definition as such that emits values defined
     * in the specified streaming route by the specified argument.
     *
     * @param stream the specified streaming route
     * @param value  the specified argument value
     * @param <I>    the type of the argument
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I, V> ExpectingStream<V, E> stream(Route1Level1<? super I, ? extends E, ? extends Emitting<? extends V>> stream, Value<? extends I> value);

    /**
     * Complete route definition as such that emits values defined
     * in the specified streaming route by the specified argument.
     *
     * @param stream the specified streaming route
     * @param value  the specified argument value
     * @param <I>    the type of the argument
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I, V> ExpectingStream<V, E> stream(Route1Level2<? super I, ? extends RuntimeException, ? extends Emitting<? extends V>> stream, Value<? extends I> value);

    /**
     * Complete route definition as such that emits values defined
     * in the specified streaming route by the specified argument.
     *
     * @param stream the specified streaming route
     * @param value  the specified argument value
     * @param <I>    the type of the argument
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I, V> ExpectingStream<V, E> stream(Route1Level3<? super I, E, ? extends Emitting<? extends V>> stream, Value<? extends I> value);


    /**
     * Complete route definition as such that emits values of the {@link Emittable} specified
     * by the definition object by the specified argument.
     *
     * @param stream the specified {@link Emittable} definition object
     * @param value  the specified argument value
     * @param <I>    the type of the argument
     * @param <V>    the type of the emitting values
     * @param <H>    the type of unexpected exception that might be thrown
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I, V, H extends Exception> CatchingStream<V, H, E> stream(ValueLevel0<? extends Evaluable1Throwing1<? super I, ? extends Emittable<? extends V, ? extends H>, ? extends H>> stream, Value<? extends I> value);

    /**
     * Complete route definition as such that emits values of the {@link Emittable} specified
     * by the definition object by the specified argument.
     *
     * @param stream the specified {@link Emittable} definition object
     * @param value  the specified argument value
     * @param <I>    the type of the argument
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I, V> ExpectingStream<V, E> stream(ValueLevel1<? extends Evaluable1Throwing1<? super I, ? extends Emittable<? extends V, ? extends E>, ? extends E>> stream, Value<? extends I> value);

    /**
     * Complete route definition as such that emits values of the {@link Emittable} specified
     * by the definition object by the specified argument.
     *
     * @param stream the specified {@link Emittable} definition object
     * @param value  the specified argument value
     * @param <I>    the type of the argument
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I, V> ExpectingStream<V, E> stream(ValueLevel2<? extends Evaluable1Throwing1<? super I, ? extends Emittable<? extends V, ? extends RuntimeException>, ? extends RuntimeException>> stream, Value<? extends I> value);

    /**
     * Complete route definition as such that emits values of the {@link Emittable} specified
     * by the definition object by the specified argument.
     *
     * @param stream the specified {@link Emittable} definition object
     * @param value  the specified argument value
     * @param <I>    the type of the argument
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I, V> ExpectingStream<V, E> stream(ValueLevel3<? extends Evaluable1Throwing1<? super I, ? extends Emittable<? extends V, E>, E>> stream, Value<? extends I> value);

    /**
     * Add optionally the execution of the specified route to the flow
     * depending on the specified value match using the specified {@link Testable1Throwing1}.
     *
     * @param value     the specified argument value
     * @param predicate the specified {@link Testable1Throwing1}
     * @param route     the specified route definition
     * @param <I>       the type of the argument
     * @return the action choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I> ChoosingAction<$F, E> either(Value<? extends I> value, Testable1Throwing1<? super I, ? extends E> predicate, ActionBlock route);

    /**
     * Add optionally the execution of the specified route to the flow
     * depending on the specified value match using the specified {@link Testable1Throwing1}.
     *
     * @param value     the specified argument value
     * @param predicate the specified {@link Testable1Throwing1}
     * @param route     the specified route definition
     * @param <I>       the type of the argument
     * @return the action choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I> ChoosingAction<$F, E> either(Value<? extends I> value, Testable1Throwing1<? super I, ? extends E> predicate, ActionLevel1<? extends E> route);

    /**
     * Add optionally the execution of the specified route to the flow
     * depending on the specified value match using the specified {@link Testable1Throwing1}.
     *
     * @param value     the specified argument value
     * @param predicate the specified {@link Testable1Throwing1}
     * @param route     the specified route definition
     * @param <I>       the type of the argument
     * @return the action choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I> ChoosingAction<$F, E> either(Value<? extends I> value, Testable1Throwing1<? super I, ? extends E> predicate, ActionLevel2<? extends RuntimeException> route);

    /**
     * Add optionally the execution of the specified route to the flow
     * depending on the specified value match using the specified {@link Testable1Throwing1}.
     *
     * @param value     the specified argument value
     * @param predicate the specified {@link Testable1Throwing1}
     * @param route     the specified route definition
     * @param <I>       the type of the argument
     * @return the action choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I> ChoosingAction<$F, E> either(Value<? extends I> value, Testable1Throwing1<? super I, ? extends E> predicate, ActionLevel3<E> route);

    /**
     * Complete route definition as such that emits optionally value defined in the specified streaming route
     * depending on the specified value match using the specified {@link Testable1Throwing1}.
     *
     * @param value     the specified argument value
     * @param predicate the specified {@link Testable1Throwing1}
     * @param route     the specified route definition
     * @param <I>       the type of the argument
     * @param <V>       the type of the emitting values
     * @return the streaming choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I, V> ChoosingStream<V, E> either(Value<? extends I> value, Testable1Throwing1<? super I, ? extends E> predicate, StreamBlock<V> route);

    /**
     * Complete route definition as such that emits optionally value defined in the specified streaming route
     * depending on the specified value match using the specified {@link Testable1Throwing1}.
     *
     * @param value     the specified argument value
     * @param predicate the specified {@link Testable1Throwing1}
     * @param route     the specified route definition
     * @param <I>       the type of the argument
     * @param <V>       the type of the emitting values
     * @return the streaming choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I, V> ChoosingStream<V, E> either(Value<? extends I> value, Testable1Throwing1<? super I, ? extends E> predicate, StreamLevel1<V, ? extends E> route);

    /**
     * Complete route definition as such that emits optionally value defined in the specified streaming route
     * depending on the specified value match using the specified {@link Testable1Throwing1}.
     *
     * @param value     the specified argument value
     * @param predicate the specified {@link Testable1Throwing1}
     * @param route     the specified route definition
     * @param <I>       the type of the argument
     * @param <V>       the type of the emitting values
     * @return the streaming choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I, V> ChoosingStream<V, E> either(Value<? extends I> value, Testable1Throwing1<? super I, ? extends E> predicate, StreamLevel2<V, ? extends RuntimeException> route);

    /**
     * Complete route definition as such that emits optionally value defined in the specified streaming route
     * depending on the specified value match using the specified {@link Testable1Throwing1}.
     *
     * @param value     the specified argument value
     * @param predicate the specified {@link Testable1Throwing1}
     * @param route     the specified route definition
     * @param <I>       the type of the argument
     * @param <V>       the type of the emitting values
     * @return the streaming choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I, V> ChoosingStream<V, E> either(Value<? extends I> value, Testable1Throwing1<? super I, ? extends E> predicate, StreamLevel3<V, E> route);


    /**
     * Continue route definition in the given handler of the unpacked value of the specified {@link Tuple1} value.
     *
     * @param tuple   the specified {@link Tuple1} value
     * @param handler the specified handling route
     * @param <I>     the type of value 1 of the tuple
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <I, $R extends Routing<?>> $R expand(Value<? extends Tuple1<? extends I>> tuple, Block1<? super I, ? extends Routing<? extends $R>> handler);


    /**
     * Add the specified {@link Executable2} execution by the specified argument values to the flow.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param execution the specified {@link Executable2} execution
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @return the flow definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2> ExpectingAction<$F, E> effect(Value<? extends I1> value1, Value<? extends I2> value2, Executable2Throwing1<? super I1, ? super I2, ? extends E> execution);


    /**
     * Complete route definition as such that emits the value from the specified {@link Evaluable2}
     * by the specified argument values.
     *
     * @param value1   the specified argument value 1
     * @param value2   the specified argument value 2
     * @param supplier the specified value {@link Evaluable2} supplier
     * @param <I1>     the type of argument 1
     * @param <I2>     the type of argument 2
     * @param <V>      the type of the emitting value
     * @return emitting result definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, V> ExpectingStream<V, E> supply(Value<? extends I1> value1, Value<? extends I2> value2, Evaluable2Throwing1<? super I1, ? super I2, ? extends V, ? extends E> supplier);

    /**
     * Continue route definition in the given handler of the value from the specified {@link Evaluable2} supplier
     * by the specified argument values.
     *
     * @param value1   the specified argument value 1
     * @param value2   the specified argument value 2
     * @param supplier the specified value {@link Evaluable2} supplier
     * @param handler  the given value handling route
     * @param <I1>     the type of argument 1
     * @param <I2>     the type of argument 2
     * @param <V>      the type of the emitting value
     * @param <$R>     the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, V, $R extends Routing<?>> $R supply(Value<? extends I1> value1, Value<? extends I2> value2, Evaluable2Throwing1<? super I1, ? super I2, ? extends V, ? extends E> supplier, Block1<? super V, ? extends Routing<? extends $R>> handler);


    /**
     * Complete route definition as such that emits values from the supplying {@link BaseStream} source
     * by the specified argument values.
     *
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param source the supplying {@link BaseStream} source
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <V>    the type of the emitting values
     * @return emitting result definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, V> ExpectingStream<V, E> source(Value<? extends I1> value1, Value<? extends I2> value2, Evaluable2Throwing1<? super I1, ? super I2, ? extends BaseStream<V, ?>, ? extends E> source);

    /**
     * Continue route definition in the given handler of values from the supplying {@link BaseStream} source
     * by the specified argument values.
     *
     * @param value1  the specified argument value 1
     * @param value2  the specified argument value 2
     * @param source  the supplying {@link BaseStream} source
     * @param handler the given value handling route
     * @param <I1>    the type of argument 1
     * @param <I2>    the type of argument 2
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, V, $R extends Routing<?>> $R source(Value<? extends I1> value1, Value<? extends I2> value2, Evaluable2Throwing1<? super I1, ? super I2, ? extends BaseStream<V, ?>, ? extends E> source, Block1<? super V, ? extends Routing<? extends $R>> handler);


    /**
     * Add the execution of the specified route by the specified argument values to the flow.
     *
     * @param route  the specified route definition
     * @param value1 the specified value 1
     * @param value2 the specified value 2
     * @param <I1>   the type of the route argument 1
     * @param <I2>   the type of the route argument 2
     * @param <H>    the type of unexpected exception that might be thrown
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, H extends Exception> CatchingAction<$F, H, E> action(Route2Level0<? super I1, ? super I2, ? extends H, ?> route, Value<? extends I1> value1, Value<? extends I2> value2);

    /**
     * Add the execution of the specified route by the specified argument values to the flow.
     *
     * @param route  the specified route definition
     * @param value1 the specified value 1
     * @param value2 the specified value 2
     * @param <I1>   the type of the route argument 1
     * @param <I2>   the type of the route argument 2
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2> ExpectingAction<$F, E> action(Route2Level1<? super I1, ? super I2, ? extends E, ?> route, Value<? extends I1> value1, Value<? extends I2> value2);

    /**
     * Add the execution of the specified route by the specified argument values to the flow.
     *
     * @param route  the specified route definition
     * @param value1 the specified value 1
     * @param value2 the specified value 2
     * @param <I1>   the type of the route argument 1
     * @param <I2>   the type of the route argument 2
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2> ExpectingAction<$F, E> action(Route2Level2<? super I1, ? super I2, ? extends RuntimeException, ?> route, Value<? extends I1> value1, Value<? extends I2> value2);

    /**
     * Add the execution of the specified route by the specified argument values to the flow.
     *
     * @param route  the specified route definition
     * @param value1 the specified value 1
     * @param value2 the specified value 2
     * @param <I1>   the type of the route argument 1
     * @param <I2>   the type of the route argument 2
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2> ExpectingAction<$F, E> action(Route2Level3<? super I1, ? super I2, E, ?> route, Value<? extends I1> value1, Value<? extends I2> value2);


    /**
     * Add the execution of the {@link Emittable} specified by the definition object
     * by the specified arguments to the flow.
     *
     * @param route  the specified {@link Emittable} definition object
     * @param value1 the specified argument value
     * @param value2 the specified argument value
     * @param <I1>   the type of the route argument 1
     * @param <I2>   the type of the route argument 2
     * @param <H>    the type of unexpected exception that might be thrown
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, H extends Exception> CatchingAction<$F, H, E> action(ValueLevel0<? extends Evaluable2Throwing1<? super I1, ? super I2, ? extends Emittable<?, ? extends H>, ? extends H>> route, Value<? extends I1> value1, Value<? extends I2> value2);


    /**
     * Add the execution of the {@link Emittable} specified by the definition object
     * by the specified arguments to the flow.
     *
     * @param route  the specified {@link Emittable} definition object
     * @param value1 the specified argument value
     * @param value2 the specified argument value
     * @param <I1>   the type of the route argument 1
     * @param <I2>   the type of the route argument 2
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2> ExpectingAction<$F, E> action(ValueLevel1<? extends Evaluable2Throwing1<? super I1, ? super I2, ? extends Emittable<?, ? extends E>, ? extends E>> route, Value<? extends I1> value1, Value<? extends I2> value2);

    /**
     * Add the execution of the {@link Emittable} specified by the definition object
     * by the specified arguments to the flow.
     *
     * @param route  the specified {@link Emittable} definition object
     * @param value1 the specified argument value
     * @param value2 the specified argument value
     * @param <I1>   the type of the route argument 1
     * @param <I2>   the type of the route argument 2
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2> ExpectingAction<$F, E> action(ValueLevel2<? extends Evaluable2Throwing1<? super I1, ? super I2, ? extends Emittable<?, ? extends RuntimeException>, ? extends RuntimeException>> route, Value<? extends I1> value1, Value<? extends I2> value2);

    /**
     * Add the execution of the {@link Emittable} specified by the definition object
     * by the specified arguments to the flow.
     *
     * @param route  the specified {@link Emittable} definition object
     * @param value1 the specified argument value
     * @param value2 the specified argument value
     * @param <I1>   the type of the route argument 1
     * @param <I2>   the type of the route argument 2
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2> ExpectingAction<$F, E> action(ValueLevel3<? extends Evaluable2Throwing1<? super I1, ? super I2, ? extends Emittable<?, E>, E>> route, Value<? extends I1> value1, Value<? extends I2> value2);


    /**
     * Complete route definition as such that emits values defined
     * in the specified streaming route by the specified arguments.
     *
     * @param stream the specified streaming route
     * @param value1 the specified value 1
     * @param value2 the specified value 2
     * @param <I1>   the type of the route argument 1
     * @param <I2>   the type of the route argument 2
     * @param <V>    the type of the emitting values
     * @param <H>    the type of unexpected exception that might be thrown
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, V, H extends Exception> CatchingStream<V, H, E> stream(Route2Level0<? super I1, ? super I2, ? extends H, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2);

    /**
     * Complete route definition as such that emits values defined
     * in the specified streaming route by the specified arguments.
     *
     * @param stream the specified streaming route
     * @param value1 the specified value 1
     * @param value2 the specified value 2
     * @param <I1>   the type of the route argument 1
     * @param <I2>   the type of the route argument 2
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, V> ExpectingStream<V, E> stream(Route2Level1<? super I1, ? super I2, ? extends E, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2);

    /**
     * Complete route definition as such that emits values defined
     * in the specified streaming route by the specified arguments.
     *
     * @param stream the specified streaming route
     * @param value1 the specified value 1
     * @param value2 the specified value 2
     * @param <I1>   the type of the route argument 1
     * @param <I2>   the type of the route argument 2
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, V> ExpectingStream<V, E> stream(Route2Level2<? super I1, ? super I2, ? extends RuntimeException, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2);

    /**
     * Complete route definition as such that emits values defined
     * in the specified streaming route by the specified arguments.
     *
     * @param stream the specified streaming route
     * @param value1 the specified value 1
     * @param value2 the specified value 2
     * @param <I1>   the type of the route argument 1
     * @param <I2>   the type of the route argument 2
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, V> ExpectingStream<V, E> stream(Route2Level3<? super I1, ? super I2, E, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2);

    /**
     * Complete route definition as such that emits values of the {@link Emittable} specified
     * by the definition object by the specified arguments.
     *
     * @param stream the specified {@link Emittable} definition object
     * @param value1 the specified value 1
     * @param value2 the specified value 2
     * @param <I1>   the type of the route argument 1
     * @param <I2>   the type of the route argument 2
     * @param <V>    the type of the emitting values
     * @param <H>    the type of unexpected exception that might be thrown
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, V, H extends Exception> CatchingStream<V, H, E> stream(ValueLevel0<? extends Evaluable2Throwing1<? super I1, ? super I2, ? extends Emittable<? extends V, ? extends H>, ? extends H>> stream, Value<? extends I1> value1, Value<? extends I2> value2);

    /**
     * Complete route definition as such that emits values of the {@link Emittable} specified
     * by the definition object by the specified arguments.
     *
     * @param stream the specified {@link Emittable} definition object
     * @param value1 the specified value 1
     * @param value2 the specified value 2
     * @param <I1>   the type of the route argument 1
     * @param <I2>   the type of the route argument 2
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, V> ExpectingStream<V, E> stream(ValueLevel1<? extends Evaluable2Throwing1<? super I1, ? super I2, ? extends Emittable<? extends V, ? extends E>, ? extends E>> stream, Value<? extends I1> value1, Value<? extends I2> value2);

    /**
     * Complete route definition as such that emits values of the {@link Emittable} specified
     * by the definition object by the specified arguments.
     *
     * @param stream the specified {@link Emittable} definition object
     * @param value1 the specified value 1
     * @param value2 the specified value 2
     * @param <I1>   the type of the route argument 1
     * @param <I2>   the type of the route argument 2
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, V> ExpectingStream<V, E> stream(ValueLevel2<? extends Evaluable2Throwing1<? super I1, ? super I2, ? extends Emittable<? extends V, ? extends RuntimeException>, ? extends RuntimeException>> stream, Value<? extends I1> value1, Value<? extends I2> value2);

    /**
     * Complete route definition as such that emits values of the {@link Emittable} specified
     * by the definition object by the specified arguments.
     *
     * @param stream the specified {@link Emittable} definition object
     * @param value1 the specified value 1
     * @param value2 the specified value 2
     * @param <I1>   the type of the route argument 1
     * @param <I2>   the type of the route argument 2
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, V> ExpectingStream<V, E> stream(ValueLevel3<? extends Evaluable2Throwing1<? super I1, ? super I2, ? extends Emittable<? extends V, E>, E>> stream, Value<? extends I1> value1, Value<? extends I2> value2);

    /**
     * Add optionally the execution of the specified route to the flow
     * depending on the specified values match using the specified {@link Testable2Throwing1}.
     *
     * @param value1    the specified value 1
     * @param value2    the specified value 2
     * @param predicate the specified {@link Testable2Throwing1}
     * @param route     the specified route definition
     * @param <I1>      the type of the input value 1 to check
     * @param <I2>      the type of the input value 2 to check
     * @return the action choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2> ChoosingAction<$F, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Testable2Throwing1<? super I1, ? super I2, ? extends E> predicate, ActionBlock route);

    /**
     * Add optionally the execution of the specified route to the flow
     * depending on the specified values match using the specified {@link Testable2Throwing1}.
     *
     * @param value1    the specified value 1
     * @param value2    the specified value 2
     * @param predicate the specified {@link Testable2Throwing1}
     * @param route     the specified route definition
     * @param <I1>      the type of the input value 1 to check
     * @param <I2>      the type of the input value 2 to check
     * @return the action choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2> ChoosingAction<$F, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Testable2Throwing1<? super I1, ? super I2, ? extends E> predicate, ActionLevel1<? extends E> route);

    /**
     * Add optionally the execution of the specified route to the flow
     * depending on the specified values match using the specified {@link Testable2Throwing1}.
     *
     * @param value1    the specified value 1
     * @param value2    the specified value 2
     * @param predicate the specified {@link Testable2Throwing1}
     * @param route     the specified route definition
     * @param <I1>      the type of the input value 1 to check
     * @param <I2>      the type of the input value 2 to check
     * @return the action choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2> ChoosingAction<$F, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Testable2Throwing1<? super I1, ? super I2, ? extends E> predicate, ActionLevel2<? extends RuntimeException> route);

    /**
     * Add optionally the execution of the specified route to the flow
     * depending on the specified values match using the specified {@link Testable2Throwing1}.
     *
     * @param value1    the specified value 1
     * @param value2    the specified value 2
     * @param predicate the specified {@link Testable2Throwing1}
     * @param route     the specified route definition
     * @param <I1>      the type of the input value 1 to check
     * @param <I2>      the type of the input value 2 to check
     * @return the action choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2> ChoosingAction<$F, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Testable2Throwing1<? super I1, ? super I2, ? extends E> predicate, ActionLevel3<E> route);

    /**
     * Complete route definition as such that emits optionally value defined in the specified streaming route
     * depending on the specified values match using the specified {@link Testable2Throwing1}.
     *
     * @param value1    the specified value 1
     * @param value2    the specified value 2
     * @param predicate the specified {@link Testable2Throwing1}
     * @param route     the specified route definition
     * @param <I1>      the type of the input value 1 to check
     * @param <I2>      the type of the input value 2 to check
     * @param <V>       the type of the emitting values
     * @return the streaming choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, V> ChoosingStream<V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Testable2Throwing1<? super I1, ? super I2, ? extends E> predicate, StreamBlock<V> route);

    /**
     * Complete route definition as such that emits optionally value defined in the specified streaming route
     * depending on the specified values match using the specified {@link Testable2Throwing1}.
     *
     * @param value1    the specified value 1
     * @param value2    the specified value 2
     * @param predicate the specified {@link Testable2Throwing1}
     * @param route     the specified route definition
     * @param <I1>      the type of the input value 1 to check
     * @param <I2>      the type of the input value 2 to check
     * @param <V>       the type of the emitting values
     * @return the streaming choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, V> ChoosingStream<V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Testable2Throwing1<? super I1, ? super I2, ? extends E> predicate, StreamLevel1<V, ? extends E> route);

    /**
     * Complete route definition as such that emits optionally value defined in the specified streaming route
     * depending on the specified values match using the specified {@link Testable2Throwing1}.
     *
     * @param value1    the specified value 1
     * @param value2    the specified value 2
     * @param predicate the specified {@link Testable2Throwing1}
     * @param route     the specified route definition
     * @param <I1>      the type of the input value 1 to check
     * @param <I2>      the type of the input value 2 to check
     * @param <V>       the type of the emitting values
     * @return the streaming choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, V> ChoosingStream<V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Testable2Throwing1<? super I1, ? super I2, ? extends E> predicate, StreamLevel2<V, ? extends RuntimeException> route);

    /**
     * Complete route definition as such that emits optionally value defined in the specified streaming route
     * depending on the specified values match using the specified {@link Testable2Throwing1}.
     *
     * @param value1    the specified value 1
     * @param value2    the specified value 2
     * @param predicate the specified {@link Testable2Throwing1}
     * @param route     the specified route definition
     * @param <I1>      the type of the input value 1 to check
     * @param <I2>      the type of the input value 2 to check
     * @param <V>       the type of the emitting values
     * @return the streaming choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, V> ChoosingStream<V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Testable2Throwing1<? super I1, ? super I2, ? extends E> predicate, StreamLevel3<V, E> route);


    /**
     * Continue route definition in the given handler of the unpacked values of the specified {@link Tuple2} value.
     *
     * @param tuple   the specified {@link Tuple2} value
     * @param handler the specified handling route
     * @param <I1>    the type of value 1 of the tuple
     * @param <I2>    the type of value 2 of the tuple
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, $R extends Routing<?>> $R expand(Value<? extends Tuple2<? extends I1, ? extends I2>> tuple, Block2<? super I1, ? super I2, ? extends Routing<? extends $R>> handler);


    /**
     * Add the specified {@link Executable3} execution by the specified argument values to the flow.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param execution the specified {@link Executable3} execution
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @return the flow definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3> ExpectingAction<$F, E> effect(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Executable3Throwing1<? super I1, ? super I2, ? super I3, ? extends E> execution);

    /**
     * Complete route definition as such that emits the value from the specified {@link Evaluable3}
     * by the specified argument values.
     *
     * @param value1   the specified argument value 1
     * @param value2   the specified argument value 2
     * @param value3   the specified argument value 3
     * @param supplier the specified value {@link Evaluable3} supplier
     * @param <I1>     the type of argument 1
     * @param <I2>     the type of argument 2
     * @param <I3>     the type of argument 3
     * @param <V>      the type of the emitting value
     * @return emitting result definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, V> ExpectingStream<V, E> supply(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Evaluable3Throwing1<? super I1, ? super I2, ? super I3, ? extends V, ? extends E> supplier);

    /**
     * Continue route definition in the given handler of the value from the specified {@link Evaluable3} supplier
     * by the specified argument values.
     *
     * @param value1   the specified argument value 1
     * @param value2   the specified argument value 2
     * @param value3   the specified argument value 3
     * @param supplier the specified value {@link Evaluable3} supplier
     * @param handler  the given value handling route
     * @param <I1>     the type of argument 1
     * @param <I2>     the type of argument 2
     * @param <I3>     the type of argument 3
     * @param <V>      the type of the emitting value
     * @param <$R>     the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, V, $R extends Routing<?>> $R supply(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Evaluable3Throwing1<? super I1, ? super I2, ? super I3, ? extends V, ? extends E> supplier, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits values from the supplying {@link BaseStream} source
     * by the specified argument values.
     *
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param source the supplying {@link BaseStream} source
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <V>    the type of the emitting values
     * @return emitting result definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, V> ExpectingStream<V, E> source(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Evaluable3Throwing1<? super I1, ? super I2, ? super I3, ? extends BaseStream<V, ?>, ? extends E> source);

    /**
     * Continue route definition in the given handler of values from the supplying {@link BaseStream} source
     * by the specified argument values.
     *
     * @param value1  the specified argument value 1
     * @param value2  the specified argument value 2
     * @param value3  the specified argument value 3
     * @param source  the supplying {@link BaseStream} source
     * @param handler the given value handling route
     * @param <I1>    the type of argument 1
     * @param <I2>    the type of argument 2
     * @param <I3>    the type of argument 3
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, V, $R extends Routing<?>> $R source(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Evaluable3Throwing1<? super I1, ? super I2, ? super I3, ? extends BaseStream<V, ?>, ? extends E> source, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Add the execution of the specified route by the specified argument values to the flow.
     *
     * @param route  the specified route definition
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <H>    the type of unexpected exception that might be thrown
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, H extends Exception> CatchingAction<$F, H, E> action(Route3Level0<? super I1, ? super I2, ? super I3, ? extends H, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3);

    /**
     * Add the execution of the specified route by the specified argument values to the flow.
     *
     * @param route  the specified route definition
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3> ExpectingAction<$F, E> action(Route3Level1<? super I1, ? super I2, ? super I3, ? extends E, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3);

    /**
     * Add the execution of the specified route by the specified argument values to the flow.
     *
     * @param route  the specified route definition
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3> ExpectingAction<$F, E> action(Route3Level2<? super I1, ? super I2, ? super I3, ? extends RuntimeException, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3);

    /**
     * Add the execution of the specified route by the specified argument values to the flow.
     *
     * @param route  the specified route definition
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3> ExpectingAction<$F, E> action(Route3Level3<? super I1, ? super I2, ? super I3, E, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3);

    /**
     * Add the execution of the {@link Emittable} specified by the definition object
     * by the specified arguments to the flow.
     *
     * @param route  the specified {@link Emittable} definition object
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <H>    the type of unexpected exception that might be thrown
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, H extends Exception> CatchingAction<$F, H, E> action(ValueLevel0<? extends Evaluable3Throwing1<? super I1, ? super I2, ? super I3, ? extends Emittable<?, ? extends H>, ? extends H>> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3);

    /**
     * Add the execution of the {@link Emittable} specified by the definition object
     * by the specified arguments to the flow.
     *
     * @param route  the specified {@link Emittable} definition object
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3> ExpectingAction<$F, E> action(ValueLevel1<? extends Evaluable3Throwing1<? super I1, ? super I2, ? super I3, ? extends Emittable<?, ? extends E>, ? extends E>> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3);

    /**
     * Add the execution of the {@link Emittable} specified by the definition object
     * by the specified arguments to the flow.
     *
     * @param route  the specified {@link Emittable} definition object
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3> ExpectingAction<$F, E> action(ValueLevel2<? extends Evaluable3Throwing1<? super I1, ? super I2, ? super I3, ? extends Emittable<?, ? extends RuntimeException>, ? extends RuntimeException>> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3);

    /**
     * Add the execution of the {@link Emittable} specified by the definition object
     * by the specified arguments to the flow.
     *
     * @param route  the specified {@link Emittable} definition object
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3> ExpectingAction<$F, E> action(ValueLevel3<? extends Evaluable3Throwing1<? super I1, ? super I2, ? super I3, ? extends Emittable<?, E>, E>> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3);

    /**
     * Complete route definition as such that emits values defined
     * in the specified streaming route by the specified arguments.
     *
     * @param stream the specified streaming route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <V>    the type of the emitting values
     * @param <H>    the type of unexpected exception that might be thrown
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, V, H extends Exception> CatchingStream<V, H, E> stream(Route3Level0<? super I1, ? super I2, ? super I3, ? extends H, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3);

    /**
     * Complete route definition as such that emits values defined
     * in the specified streaming route by the specified arguments.
     *
     * @param stream the specified streaming route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, V> ExpectingStream<V, E> stream(Route3Level1<? super I1, ? super I2, ? super I3, ? extends E, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3);

    /**
     * Complete route definition as such that emits values defined
     * in the specified streaming route by the specified arguments.
     *
     * @param stream the specified streaming route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, V> ExpectingStream<V, E> stream(Route3Level2<? super I1, ? super I2, ? super I3, ? extends RuntimeException, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3);

    /**
     * Complete route definition as such that emits values defined
     * in the specified streaming route by the specified arguments.
     *
     * @param stream the specified streaming route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, V> ExpectingStream<V, E> stream(Route3Level3<? super I1, ? super I2, ? super I3, E, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3);


    /**
     * Complete route definition as such that emits values of the {@link Emittable} specified
     * by the definition object by the specified arguments.
     *
     * @param stream the specified {@link Emittable} definition object
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <V>    the type of the emitting values
     * @param <H>    the type of unexpected exception that might be thrown
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, V, H extends Exception> CatchingStream<V, H, E> stream(ValueLevel0<? extends Evaluable3Throwing1<? super I1, ? super I2, ? super I3, ? extends Emittable<? extends V, ? extends H>, ? extends H>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3);

    /**
     * Complete route definition as such that emits values of the {@link Emittable} specified
     * by the definition object by the specified arguments.
     *
     * @param stream the specified {@link Emittable} definition object
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, V> ExpectingStream<V, E> stream(ValueLevel1<? extends Evaluable3Throwing1<? super I1, ? super I2, ? super I3, ? extends Emittable<? extends V, ? extends E>, ? extends E>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3);

    /**
     * Complete route definition as such that emits values of the {@link Emittable} specified
     * by the definition object by the specified arguments.
     *
     * @param stream the specified {@link Emittable} definition object
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, V> ExpectingStream<V, E> stream(ValueLevel2<? extends Evaluable3Throwing1<? super I1, ? super I2, ? super I3, ? extends Emittable<? extends V, ? extends RuntimeException>, ? extends RuntimeException>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3);

    /**
     * Complete route definition as such that emits values of the {@link Emittable} specified
     * by the definition object by the specified arguments.
     *
     * @param stream the specified {@link Emittable} definition object
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, V> ExpectingStream<V, E> stream(ValueLevel3<? extends Evaluable3Throwing1<? super I1, ? super I2, ? super I3, ? extends Emittable<? extends V, E>, E>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3);


    /**
     * Add optionally the execution of the specified route to the flow
     * depending on the specified values match using the specified {@link Testable3Throwing1}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param predicate the specified {@link Testable3Throwing1}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @return the action choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3> ChoosingAction<$F, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Testable3Throwing1<? super I1, ? super I2, ? super I3, ? extends E> predicate, ActionBlock route);

    /**
     * Add optionally the execution of the specified route to the flow
     * depending on the specified values match using the specified {@link Testable3Throwing1}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param predicate the specified {@link Testable3Throwing1}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @return the action choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3> ChoosingAction<$F, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Testable3Throwing1<? super I1, ? super I2, ? super I3, ? extends E> predicate, ActionLevel1<? extends E> route);

    /**
     * Add optionally the execution of the specified route to the flow
     * depending on the specified values match using the specified {@link Testable3Throwing1}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param predicate the specified {@link Testable3Throwing1}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @return the action choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3> ChoosingAction<$F, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Testable3Throwing1<? super I1, ? super I2, ? super I3, ? extends E> predicate, ActionLevel2<? extends RuntimeException> route);

    /**
     * Add optionally the execution of the specified route to the flow
     * depending on the specified values match using the specified {@link Testable3Throwing1}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param predicate the specified {@link Testable3Throwing1}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @return the action choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3> ChoosingAction<$F, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Testable3Throwing1<? super I1, ? super I2, ? super I3, ? extends E> predicate, ActionLevel3<E> route);

    /**
     * Complete route definition as such that emits optionally value defined in the specified streaming route
     * depending on the specified values match using the specified {@link Testable3Throwing1}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param predicate the specified {@link Testable3Throwing1}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <V>       the type of the emitting values
     * @return the streaming choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, V> ChoosingStream<V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Testable3Throwing1<? super I1, ? super I2, ? super I3, ? extends E> predicate, StreamBlock<V> route);

    /**
     * Complete route definition as such that emits optionally value defined in the specified streaming route
     * depending on the specified values match using the specified {@link Testable3Throwing1}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param predicate the specified {@link Testable3Throwing1}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <V>       the type of the emitting values
     * @return the streaming choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, V> ChoosingStream<V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Testable3Throwing1<? super I1, ? super I2, ? super I3, ? extends E> predicate, StreamLevel1<V, ? extends E> route);

    /**
     * Complete route definition as such that emits optionally value defined in the specified streaming route
     * depending on the specified values match using the specified {@link Testable3Throwing1}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param predicate the specified {@link Testable3Throwing1}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <V>       the type of the emitting values
     * @return the streaming choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, V> ChoosingStream<V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Testable3Throwing1<? super I1, ? super I2, ? super I3, ? extends E> predicate, StreamLevel2<V, ? extends RuntimeException> route);

    /**
     * Complete route definition as such that emits optionally value defined in the specified streaming route
     * depending on the specified values match using the specified {@link Testable3Throwing1}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param predicate the specified {@link Testable3Throwing1}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <V>       the type of the emitting values
     * @return the streaming choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, V> ChoosingStream<V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Testable3Throwing1<? super I1, ? super I2, ? super I3, ? extends E> predicate, StreamLevel3<V, E> route);


    /**
     * Continue route definition in the given handler of the unpacked values of the specified {@link Tuple3} value.
     *
     * @param tuple   the specified {@link Tuple3} value
     * @param handler the specified handling route
     * @param <I1>    the type of value 1 of the tuple
     * @param <I2>    the type of value 2 of the tuple
     * @param <I3>    the type of value 3 of the tuple
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, $R extends Routing<?>> $R expand(Value<? extends Tuple3<? extends I1, ? extends I2, ? extends I3>> tuple, Block3<? super I1, ? super I2, ? super I3, ? extends Routing<? extends $R>> handler);

    /**
     * Add the specified {@link Executable4} execution by the specified argument values to the flow.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param execution the specified {@link Executable4} execution
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @return the flow definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4> ExpectingAction<$F, E> effect(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Executable4Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? extends E> execution);

    /**
     * Complete route definition as such that emits the value from the specified {@link Evaluable4}
     * by the specified argument values.
     *
     * @param value1   the specified argument value 1
     * @param value2   the specified argument value 2
     * @param value3   the specified argument value 3
     * @param value4   the specified argument value 4
     * @param supplier the specified value {@link Evaluable4} supplier
     * @param <I1>     the type of argument 1
     * @param <I2>     the type of argument 2
     * @param <I3>     the type of argument 3
     * @param <I4>     the type of argument 4
     * @param <V>      the type of the emitting value
     * @return emitting result definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, V> ExpectingStream<V, E> supply(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Evaluable4Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? extends V, ? extends E> supplier);

    /**
     * Continue route definition in the given handler of the value from the specified {@link Evaluable4} supplier
     * by the specified argument values.
     *
     * @param value1   the specified argument value 1
     * @param value2   the specified argument value 2
     * @param value3   the specified argument value 3
     * @param value4   the specified argument value 4
     * @param supplier the specified value {@link Evaluable4} supplier
     * @param handler  the given value handling route
     * @param <I1>     the type of argument 1
     * @param <I2>     the type of argument 2
     * @param <I3>     the type of argument 3
     * @param <I4>     the type of argument 4
     * @param <V>      the type of the emitting value
     * @param <$R>     the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, V, $R extends Routing<?>> $R supply(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Evaluable4Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? extends V, ? extends E> supplier, Block1<? super V, ? extends Routing<? extends $R>> handler);


    /**
     * Complete route definition as such that emits values from the supplying {@link BaseStream} source
     * by the specified argument values.
     *
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param source the supplying {@link BaseStream} source
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <V>    the type of the emitting values
     * @return emitting result definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, V> ExpectingStream<V, E> source(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Evaluable4Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? extends BaseStream<V, ?>, ? extends E> source);

    /**
     * Continue route definition in the given handler of values from the supplying {@link BaseStream} source
     * by the specified argument values.
     *
     * @param value1  the specified argument value 1
     * @param value2  the specified argument value 2
     * @param value3  the specified argument value 3
     * @param value4  the specified argument value 4
     * @param source  the supplying {@link BaseStream} source
     * @param handler the given value handling route
     * @param <I1>    the type of argument 1
     * @param <I2>    the type of argument 2
     * @param <I3>    the type of argument 3
     * @param <I4>    the type of argument 4
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, V, $R extends Routing<?>> $R source(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Evaluable4Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? extends BaseStream<V, ?>, ? extends E> source, Block1<? super V, ? extends Routing<? extends $R>> handler);


    /**
     * Add the execution of the specified route by the specified argument values to the flow.
     *
     * @param route  the specified route definition
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <H>    the type of unexpected exception that might be thrown
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, H extends Exception> CatchingAction<$F, H, E> action(Route4Level0<? super I1, ? super I2, ? super I3, ? super I4, ? extends H, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4);

    /**
     * Add the execution of the specified route by the specified argument values to the flow.
     *
     * @param route  the specified route definition
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4> ExpectingAction<$F, E> action(Route4Level1<? super I1, ? super I2, ? super I3, ? super I4, ? extends E, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4);

    /**
     * Add the execution of the specified route by the specified argument values to the flow.
     *
     * @param route  the specified route definition
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4> ExpectingAction<$F, E> action(Route4Level2<? super I1, ? super I2, ? super I3, ? super I4, ? extends RuntimeException, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4);

    /**
     * Add the execution of the specified route by the specified argument values to the flow.
     *
     * @param route  the specified route definition
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4> ExpectingAction<$F, E> action(Route4Level3<? super I1, ? super I2, ? super I3, ? super I4, E, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4);

    /**
     * Add the execution of the {@link Emittable} specified by the definition object
     * by the specified arguments to the flow.
     *
     * @param route  the specified {@link Emittable} definition object
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <H>    the type of unexpected exception that might be thrown
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, H extends Exception> CatchingAction<$F, H, E> action(ValueLevel0<? extends Evaluable4Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? extends Emittable<?, ? extends H>, ? extends H>> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4);

    /**
     * Add the execution of the {@link Emittable} specified by the definition object
     * by the specified arguments to the flow.
     *
     * @param route  the specified {@link Emittable} definition object
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4> ExpectingAction<$F, E> action(ValueLevel1<? extends Evaluable4Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? extends Emittable<?, ? extends E>, ? extends E>> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4);

    /**
     * Add the execution of the {@link Emittable} specified by the definition object
     * by the specified arguments to the flow.
     *
     * @param route  the specified {@link Emittable} definition object
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4> ExpectingAction<$F, E> action(ValueLevel2<? extends Evaluable4Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? extends Emittable<?, ? extends RuntimeException>, ? extends RuntimeException>> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4);

    /**
     * Add the execution of the {@link Emittable} specified by the definition object
     * by the specified arguments to the flow.
     *
     * @param route  the specified {@link Emittable} definition object
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4> ExpectingAction<$F, E> action(ValueLevel3<? extends Evaluable4Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? extends Emittable<?, E>, E>> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4);


    /**
     * Complete route definition as such that emits values defined
     * in the specified streaming route by the specified arguments.
     *
     * @param stream the specified streaming route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <V>    the type of the emitting values
     * @param <H>    the type of unexpected exception that might be thrown
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, V, H extends Exception> CatchingStream<V, H, E> stream(Route4Level0<? super I1, ? super I2, ? super I3, ? super I4, ? extends H, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4);

    /**
     * Complete route definition as such that emits values defined
     * in the specified streaming route by the specified arguments.
     *
     * @param stream the specified streaming route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, V> ExpectingStream<V, E> stream(Route4Level1<? super I1, ? super I2, ? super I3, ? super I4, ? extends E, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4);

    /**
     * Complete route definition as such that emits values defined
     * in the specified streaming route by the specified arguments.
     *
     * @param stream the specified streaming route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, V> ExpectingStream<V, E> stream(Route4Level2<? super I1, ? super I2, ? super I3, ? super I4, ? extends RuntimeException, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4);

    /**
     * Complete route definition as such that emits values defined
     * in the specified streaming route by the specified arguments.
     *
     * @param stream the specified streaming route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, V> ExpectingStream<V, E> stream(Route4Level3<? super I1, ? super I2, ? super I3, ? super I4, E, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4);


    /**
     * Complete route definition as such that emits values of the {@link Emittable} specified
     * by the definition object by the specified arguments.
     *
     * @param stream the specified {@link Emittable} definition object
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <V>    the type of the emitting values
     * @param <H>    the type of unexpected exception that might be thrown
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, V, H extends Exception> CatchingStream<V, H, E> stream(ValueLevel0<? extends Evaluable4Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? extends Emittable<? extends V, ? extends H>, ? extends H>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4);

    /**
     * Complete route definition as such that emits values of the {@link Emittable} specified
     * by the definition object by the specified arguments.
     *
     * @param stream the specified {@link Emittable} definition object
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, V> ExpectingStream<V, E> stream(ValueLevel1<? extends Evaluable4Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? extends Emittable<? extends V, ? extends E>, ? extends E>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4);

    /**
     * Complete route definition as such that emits values of the {@link Emittable} specified
     * by the definition object by the specified arguments.
     *
     * @param stream the specified {@link Emittable} definition object
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, V> ExpectingStream<V, E> stream(ValueLevel2<? extends Evaluable4Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? extends Emittable<? extends V, ? extends RuntimeException>, ? extends RuntimeException>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4);

    /**
     * Complete route definition as such that emits values of the {@link Emittable} specified
     * by the definition object by the specified arguments.
     *
     * @param stream the specified {@link Emittable} definition object
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, V> ExpectingStream<V, E> stream(ValueLevel3<? extends Evaluable4Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? extends Emittable<? extends V, E>, E>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4);


    /**
     * Add optionally the execution of the specified route to the flow
     * depending on the specified values match using the specified {@link Testable4Throwing1}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param predicate the specified {@link Testable4Throwing1}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @return the action choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4> ChoosingAction<$F, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Testable4Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? extends E> predicate, ActionBlock route);

    /**
     * Add optionally the execution of the specified route to the flow
     * depending on the specified values match using the specified {@link Testable4Throwing1}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param predicate the specified {@link Testable4Throwing1}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @return the action choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4> ChoosingAction<$F, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Testable4Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? extends E> predicate, ActionLevel1<? extends E> route);

    /**
     * Add optionally the execution of the specified route to the flow
     * depending on the specified values match using the specified {@link Testable4Throwing1}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param predicate the specified {@link Testable4Throwing1}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @return the action choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4> ChoosingAction<$F, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Testable4Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? extends E> predicate, ActionLevel2<? extends RuntimeException> route);

    /**
     * Add optionally the execution of the specified route to the flow
     * depending on the specified values match using the specified {@link Testable4Throwing1}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param predicate the specified {@link Testable4Throwing1}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @return the action choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4> ChoosingAction<$F, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Testable4Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? extends E> predicate, ActionLevel3<E> route);

    /**
     * Complete route definition as such that emits optionally value defined in the specified streaming route
     * depending on the specified values match using the specified {@link Testable4Throwing1}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param predicate the specified {@link Testable4Throwing1}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @param <V>       the type of the emitting values
     * @return the streaming choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, V> ChoosingStream<V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Testable4Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? extends E> predicate, StreamBlock<V> route);

    /**
     * Complete route definition as such that emits optionally value defined in the specified streaming route
     * depending on the specified values match using the specified {@link Testable4Throwing1}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param predicate the specified {@link Testable4Throwing1}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @param <V>       the type of the emitting values
     * @return the streaming choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, V> ChoosingStream<V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Testable4Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? extends E> predicate, StreamLevel1<V, ? extends E> route);

    /**
     * Complete route definition as such that emits optionally value defined in the specified streaming route
     * depending on the specified values match using the specified {@link Testable4Throwing1}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param predicate the specified {@link Testable4Throwing1}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @param <V>       the type of the emitting values
     * @return the streaming choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, V> ChoosingStream<V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Testable4Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? extends E> predicate, StreamLevel2<V, ? extends RuntimeException> route);

    /**
     * Complete route definition as such that emits optionally value defined in the specified streaming route
     * depending on the specified values match using the specified {@link Testable4Throwing1}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param predicate the specified {@link Testable4Throwing1}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @param <V>       the type of the emitting values
     * @return the streaming choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, V> ChoosingStream<V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Testable4Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? extends E> predicate, StreamLevel3<V, E> route);


    /**
     * Continue route definition in the given handler of the unpacked values of the specified {@link Tuple4} value.
     *
     * @param tuple   the specified {@link Tuple4} value
     * @param handler the specified handling route
     * @param <I1>    the type of value 1 of the tuple
     * @param <I2>    the type of value 2 of the tuple
     * @param <I3>    the type of value 3 of the tuple
     * @param <I4>    the type of value 4 of the tuple
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, $R extends Routing<?>> $R expand(Value<? extends Tuple4<? extends I1, ? extends I2, ? extends I3, ? extends I4>> tuple, Block4<? super I1, ? super I2, ? super I3, ? super I4, ? extends Routing<? extends $R>> handler);

    /**
     * Add the specified {@link Executable5} execution by the specified argument values to the flow.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param value5    the specified argument value 5
     * @param execution the specified {@link Executable5} execution
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @param <I5>      the type of argument 5
     * @return the flow definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5> ExpectingAction<$F, E> effect(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Executable5Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends E> execution);

    /**
     * Complete route definition as such that emits the value from the specified {@link Evaluable5}
     * by the specified argument values.
     *
     * @param value1   the specified argument value 1
     * @param value2   the specified argument value 2
     * @param value3   the specified argument value 3
     * @param value4   the specified argument value 4
     * @param value5   the specified argument value 5
     * @param supplier the specified value {@link Evaluable5} supplier
     * @param <I1>     the type of argument 1
     * @param <I2>     the type of argument 2
     * @param <I3>     the type of argument 3
     * @param <I4>     the type of argument 4
     * @param <I5>     the type of argument 5
     * @param <V>      the type of the emitting value
     * @return emitting result definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, V> ExpectingStream<V, E> supply(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Evaluable5Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends V, ? extends E> supplier);

    /**
     * Continue route definition in the given handler of the value from the specified {@link Evaluable5} supplier
     * by the specified argument values.
     *
     * @param value1   the specified argument value 1
     * @param value2   the specified argument value 2
     * @param value3   the specified argument value 3
     * @param value4   the specified argument value 4
     * @param value5   the specified argument value 5
     * @param supplier the specified value {@link Evaluable5} supplier
     * @param handler  the given value handling route
     * @param <I1>     the type of argument 1
     * @param <I2>     the type of argument 2
     * @param <I3>     the type of argument 3
     * @param <I4>     the type of argument 4
     * @param <I5>     the type of argument 5
     * @param <V>      the type of the emitting value
     * @param <$R>     the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, V, $R extends Routing<?>> $R supply(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Evaluable5Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends V, ? extends E> supplier, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits values from the supplying {@link BaseStream} source
     * by the specified argument values.
     *
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param source the supplying {@link BaseStream} source
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <V>    the type of the emitting values
     * @return emitting result definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, V> ExpectingStream<V, E> source(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Evaluable5Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends BaseStream<V, ?>, ? extends E> source);

    /**
     * Continue route definition in the given handler of values from the supplying {@link BaseStream} source
     * by the specified argument values.
     *
     * @param value1  the specified argument value 1
     * @param value2  the specified argument value 2
     * @param value3  the specified argument value 3
     * @param value4  the specified argument value 4
     * @param value5  the specified argument value 5
     * @param source  the supplying {@link BaseStream} source
     * @param handler the given value handling route
     * @param <I1>    the type of argument 1
     * @param <I2>    the type of argument 2
     * @param <I3>    the type of argument 3
     * @param <I4>    the type of argument 4
     * @param <I5>    the type of argument 5
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, V, $R extends Routing<?>> $R source(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Evaluable5Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends BaseStream<V, ?>, ? extends E> source, Block1<? super V, ? extends Routing<? extends $R>> handler);


    /**
     * Add the execution of the specified route by the specified argument values to the flow.
     *
     * @param route  the specified route definition
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <H>    the type of unexpected exception that might be thrown
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, H extends Exception> CatchingAction<$F, H, E> action(Route5Level0<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends H, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5);

    /**
     * Add the execution of the specified route by the specified argument values to the flow.
     *
     * @param route  the specified route definition
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5> ExpectingAction<$F, E> action(Route5Level1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends E, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5);

    /**
     * Add the execution of the specified route by the specified argument values to the flow.
     *
     * @param route  the specified route definition
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5> ExpectingAction<$F, E> action(Route5Level2<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends RuntimeException, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5);

    /**
     * Add the execution of the specified route by the specified argument values to the flow.
     *
     * @param route  the specified route definition
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5> ExpectingAction<$F, E> action(Route5Level3<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, E, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5);

    /**
     * Add the execution of the {@link Emittable} specified by the definition object
     * by the specified arguments to the flow.
     *
     * @param route  the specified {@link Emittable} definition object
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <H>    the type of unexpected exception that might be thrown
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, H extends Exception> CatchingAction<$F, H, E> action(ValueLevel0<? extends Evaluable5Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends Emittable<?, ? extends H>, ? extends H>> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5);

    /**
     * Add the execution of the {@link Emittable} specified by the definition object
     * by the specified arguments to the flow.
     *
     * @param route  the specified {@link Emittable} definition object
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5> ExpectingAction<$F, E> action(ValueLevel1<? extends Evaluable5Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends Emittable<?, ? extends E>, ? extends E>> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5);

    /**
     * Add the execution of the {@link Emittable} specified by the definition object
     * by the specified arguments to the flow.
     *
     * @param route  the specified {@link Emittable} definition object
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5> ExpectingAction<$F, E> action(ValueLevel2<? extends Evaluable5Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends Emittable<?, ? extends RuntimeException>, ? extends RuntimeException>> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5);

    /**
     * Add the execution of the {@link Emittable} specified by the definition object
     * by the specified arguments to the flow.
     *
     * @param route  the specified {@link Emittable} definition object
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5> ExpectingAction<$F, E> action(ValueLevel3<? extends Evaluable5Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends Emittable<?, E>, E>> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5);


    /**
     * Complete route definition as such that emits values defined
     * in the specified streaming route by the specified arguments.
     *
     * @param stream the specified streaming route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <V>    the type of the emitting values
     * @param <H>    the type of unexpected exception that might be thrown
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, V, H extends Exception> CatchingStream<V, H, E> stream(Route5Level0<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends H, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5);

    /**
     * Complete route definition as such that emits values defined
     * in the specified streaming route by the specified arguments.
     *
     * @param stream the specified streaming route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, V> ExpectingStream<V, E> stream(Route5Level1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends E, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5);

    /**
     * Complete route definition as such that emits values defined
     * in the specified streaming route by the specified arguments.
     *
     * @param stream the specified streaming route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, V> ExpectingStream<V, E> stream(Route5Level2<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends RuntimeException, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5);

    /**
     * Complete route definition as such that emits values defined
     * in the specified streaming route by the specified arguments.
     *
     * @param stream the specified streaming route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, V> ExpectingStream<V, E> stream(Route5Level3<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, E, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5);


    /**
     * Complete route definition as such that emits values of the {@link Emittable} specified
     * by the definition object by the specified arguments.
     *
     * @param stream the specified {@link Emittable} definition object
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <V>    the type of the emitting values
     * @param <H>    the type of unexpected exception that might be thrown
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, V, H extends Exception> CatchingStream<V, H, E> stream(ValueLevel0<? extends Evaluable5Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends Emittable<? extends V, ? extends H>, ? extends H>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5);

    /**
     * Complete route definition as such that emits values of the {@link Emittable} specified
     * by the definition object by the specified arguments.
     *
     * @param stream the specified {@link Emittable} definition object
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, V> ExpectingStream<V, E> stream(ValueLevel1<? extends Evaluable5Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends Emittable<? extends V, ? extends E>, ? extends E>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5);

    /**
     * Complete route definition as such that emits values of the {@link Emittable} specified
     * by the definition object by the specified arguments.
     *
     * @param stream the specified {@link Emittable} definition object
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, V> ExpectingStream<V, E> stream(ValueLevel2<? extends Evaluable5Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends Emittable<? extends V, ? extends RuntimeException>, ? extends RuntimeException>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5);

    /**
     * Complete route definition as such that emits values of the {@link Emittable} specified
     * by the definition object by the specified arguments.
     *
     * @param stream the specified {@link Emittable} definition object
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, V> ExpectingStream<V, E> stream(ValueLevel3<? extends Evaluable5Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends Emittable<? extends V, E>, E>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5);


    /**
     * Add optionally the execution of the specified route to the flow
     * depending on the specified values match using the specified {@link Testable5Throwing1}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param value5    the specified argument value 5
     * @param predicate the specified {@link Testable5Throwing1}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @param <I5>      the type of argument 5
     * @return the action choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5> ChoosingAction<$F, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Testable5Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends E> predicate, ActionBlock route);

    /**
     * Add optionally the execution of the specified route to the flow
     * depending on the specified values match using the specified {@link Testable5Throwing1}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param value5    the specified argument value 5
     * @param predicate the specified {@link Testable5Throwing1}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @param <I5>      the type of argument 5
     * @return the action choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5> ChoosingAction<$F, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Testable5Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends E> predicate, ActionLevel1<? extends E> route);

    /**
     * Add optionally the execution of the specified route to the flow
     * depending on the specified values match using the specified {@link Testable5Throwing1}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param value5    the specified argument value 5
     * @param predicate the specified {@link Testable5Throwing1}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @param <I5>      the type of argument 5
     * @return the action choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5> ChoosingAction<$F, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Testable5Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends E> predicate, ActionLevel2<? extends RuntimeException> route);

    /**
     * Add optionally the execution of the specified route to the flow
     * depending on the specified values match using the specified {@link Testable5Throwing1}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param value5    the specified argument value 5
     * @param predicate the specified {@link Testable5Throwing1}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @param <I5>      the type of argument 5
     * @return the action choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5> ChoosingAction<$F, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Testable5Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends E> predicate, ActionLevel3<E> route);

    /**
     * Complete route definition as such that emits optionally value defined in the specified streaming route
     * depending on the specified values match using the specified {@link Testable5Throwing1}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param value5    the specified argument value 5
     * @param predicate the specified {@link Testable5Throwing1}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @param <I5>      the type of argument 5
     * @param <V>       the type of the emitting values
     * @return the streaming choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, V> ChoosingStream<V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Testable5Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends E> predicate, StreamBlock<V> route);

    /**
     * Complete route definition as such that emits optionally value defined in the specified streaming route
     * depending on the specified values match using the specified {@link Testable5Throwing1}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param value5    the specified argument value 5
     * @param predicate the specified {@link Testable5Throwing1}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @param <I5>      the type of argument 5
     * @param <V>       the type of the emitting values
     * @return the streaming choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, V> ChoosingStream<V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Testable5Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends E> predicate, StreamLevel1<V, ? extends E> route);

    /**
     * Complete route definition as such that emits optionally value defined in the specified streaming route
     * depending on the specified values match using the specified {@link Testable5Throwing1}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param value5    the specified argument value 5
     * @param predicate the specified {@link Testable5Throwing1}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @param <I5>      the type of argument 5
     * @param <V>       the type of the emitting values
     * @return the streaming choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, V> ChoosingStream<V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Testable5Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends E> predicate, StreamLevel2<V, ? extends RuntimeException> route);

    /**
     * Complete route definition as such that emits optionally value defined in the specified streaming route
     * depending on the specified values match using the specified {@link Testable5Throwing1}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param value5    the specified argument value 5
     * @param predicate the specified {@link Testable5Throwing1}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @param <I5>      the type of argument 5
     * @param <V>       the type of the emitting values
     * @return the streaming choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, V> ChoosingStream<V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Testable5Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends E> predicate, StreamLevel3<V, E> route);


    /**
     * Continue route definition in the given handler of the unpacked values of the specified {@link Tuple5} value.
     *
     * @param tuple   the specified {@link Tuple5} value
     * @param handler the specified handling route
     * @param <I1>    the type of value 1 of the tuple
     * @param <I2>    the type of value 2 of the tuple
     * @param <I3>    the type of value 3 of the tuple
     * @param <I4>    the type of value 4 of the tuple
     * @param <I5>    the type of value 5 of the tuple
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, $R extends Routing<?>> $R expand(Value<? extends Tuple5<? extends I1, ? extends I2, ? extends I3, ? extends I4, ? extends I5>> tuple, Block5<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends Routing<? extends $R>> handler);

    /**
     * Add the specified {@link Executable6} execution by the specified argument values to the flow.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param value5    the specified argument value 5
     * @param value6    the specified argument value 6
     * @param execution the specified {@link Executable6} execution
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @param <I5>      the type of argument 5
     * @param <I6>      the type of argument 6
     * @return the flow definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6> ExpectingAction<$F, E> effect(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Executable6Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends E> execution);

    /**
     * Complete route definition as such that emits the value from the specified {@link Evaluable6Throwing1}
     * by the specified argument values.
     *
     * @param value1   the specified argument value 1
     * @param value2   the specified argument value 2
     * @param value3   the specified argument value 3
     * @param value4   the specified argument value 4
     * @param value5   the specified argument value 5
     * @param value6   the specified argument value 6
     * @param supplier the specified value {@link Evaluable6Throwing1} supplier
     * @param <I1>     the type of argument 1
     * @param <I2>     the type of argument 2
     * @param <I3>     the type of argument 3
     * @param <I4>     the type of argument 4
     * @param <I5>     the type of argument 5
     * @param <I6>     the type of argument 6
     * @param <V>      the type of the emitting value
     * @return emitting result definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, V> ExpectingStream<V, E> supply(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Evaluable6Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends V, ? extends E> supplier);

    /**
     * Continue route definition in the given handler of the value from the specified {@link Evaluable6Throwing1} supplier
     * by the specified argument values.
     *
     * @param value1   the specified argument value 1
     * @param value2   the specified argument value 2
     * @param value3   the specified argument value 3
     * @param value4   the specified argument value 4
     * @param value5   the specified argument value 5
     * @param value6   the specified argument value 6
     * @param supplier the specified value {@link Evaluable6Throwing1} supplier
     * @param handler  the given value handling route
     * @param <I1>     the type of argument 1
     * @param <I2>     the type of argument 2
     * @param <I3>     the type of argument 3
     * @param <I4>     the type of argument 4
     * @param <I5>     the type of argument 5
     * @param <I6>     the type of argument 6
     * @param <V>      the type of the emitting value
     * @param <$R>     the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, V, $R extends Routing<?>> $R supply(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Evaluable6Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends V, ? extends E> supplier, Block1<? super V, ? extends Routing<? extends $R>> handler);


    /**
     * Complete route definition as such that emits values from the supplying {@link BaseStream} source
     * by the specified argument values.
     *
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param source the supplying {@link BaseStream} source
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @param <V>    the type of the emitting values
     * @return emitting result definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, V> ExpectingStream<V, E> source(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Evaluable6Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends BaseStream<V, ?>, ? extends E> source);

    /**
     * Continue route definition in the given handler of values from the supplying {@link BaseStream} source
     * by the specified argument values.
     *
     * @param value1  the specified argument value 1
     * @param value2  the specified argument value 2
     * @param value3  the specified argument value 3
     * @param value4  the specified argument value 4
     * @param value5  the specified argument value 5
     * @param value6  the specified argument value 6
     * @param source  the supplying {@link BaseStream} source
     * @param handler the given value handling route
     * @param <I1>    the type of argument 1
     * @param <I2>    the type of argument 2
     * @param <I3>    the type of argument 3
     * @param <I4>    the type of argument 4
     * @param <I5>    the type of argument 5
     * @param <I6>    the type of argument 6
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, V, $R extends Routing<?>> $R source(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Evaluable6Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends BaseStream<V, ?>, ? extends E> source, Block1<? super V, ? extends Routing<? extends $R>> handler);


    /**
     * Add the execution of the specified route by the specified argument values to the flow.
     *
     * @param route  the specified route definition
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @param <H>    the type of unexpected exception that might be thrown
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, H extends Exception> CatchingAction<$F, H, E> action(Route6Level0<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends H, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6);

    /**
     * Add the execution of the specified route by the specified argument values to the flow.
     *
     * @param route  the specified route definition
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6> ExpectingAction<$F, E> action(Route6Level1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends E, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6);

    /**
     * Add the execution of the specified route by the specified argument values to the flow.
     *
     * @param route  the specified route definition
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6> ExpectingAction<$F, E> action(Route6Level2<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends RuntimeException, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6);

    /**
     * Add the execution of the specified route by the specified argument values to the flow.
     *
     * @param route  the specified route definition
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6> ExpectingAction<$F, E> action(Route6Level3<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, E, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6);

    /**
     * Add the execution of the {@link Emittable} specified by the definition object
     * by the specified arguments to the flow.
     *
     * @param route  the specified {@link Emittable} definition object
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @param <H>    the type of unexpected exception that might be thrown
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, H extends Exception> CatchingAction<$F, H, E> action(ValueLevel0<? extends Evaluable6Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends Emittable<?, ? extends H>, ? extends H>> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6);

    /**
     * Add the execution of the {@link Emittable} specified by the definition object
     * by the specified arguments to the flow.
     *
     * @param route  the specified {@link Emittable} definition object
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6> ExpectingAction<$F, E> action(ValueLevel1<? extends Evaluable6Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends Emittable<?, ? extends E>, ? extends E>> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6);

    /**
     * Add the execution of the {@link Emittable} specified by the definition object
     * by the specified arguments to the flow.
     *
     * @param route  the specified {@link Emittable} definition object
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6> ExpectingAction<$F, E> action(ValueLevel2<? extends Evaluable6Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends Emittable<?, ? extends RuntimeException>, ? extends RuntimeException>> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6);

    /**
     * Add the execution of the {@link Emittable} specified by the definition object
     * by the specified arguments to the flow.
     *
     * @param route  the specified {@link Emittable} definition object
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6> ExpectingAction<$F, E> action(ValueLevel3<? extends Evaluable6Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends Emittable<?, E>, E>> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6);


    /**
     * Complete route definition as such that emits values defined
     * in the specified streaming route by the specified arguments.
     *
     * @param stream the specified streaming route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @param <V>    the type of the emitting values
     * @param <H>    the type of unexpected exception that might be thrown
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, V, H extends Exception> CatchingStream<V, H, E> stream(Route6Level0<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends H, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6);

    /**
     * Complete route definition as such that emits values defined
     * in the specified streaming route by the specified arguments.
     *
     * @param stream the specified streaming route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, V> ExpectingStream<V, E> stream(Route6Level1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends E, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6);

    /**
     * Complete route definition as such that emits values defined
     * in the specified streaming route by the specified arguments.
     *
     * @param stream the specified streaming route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, V> ExpectingStream<V, E> stream(Route6Level2<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends RuntimeException, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6);

    /**
     * Complete route definition as such that emits values defined
     * in the specified streaming route by the specified arguments.
     *
     * @param stream the specified streaming route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, V> ExpectingStream<V, E> stream(Route6Level3<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, E, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6);


    /**
     * Complete route definition as such that emits values of the {@link Emittable} specified
     * by the definition object by the specified arguments.
     *
     * @param stream the specified {@link Emittable} definition object
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @param <V>    the type of the emitting values
     * @param <H>    the type of unexpected exception that might be thrown
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, V, H extends Exception> CatchingStream<V, H, E> stream(ValueLevel0<? extends Evaluable6Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends Emittable<? extends V, ? extends H>, ? extends H>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6);

    /**
     * Complete route definition as such that emits values of the {@link Emittable} specified
     * by the definition object by the specified arguments.
     *
     * @param stream the specified {@link Emittable} definition object
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, V> ExpectingStream<V, E> stream(ValueLevel1<? extends Evaluable6Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends Emittable<? extends V, ? extends E>, ? extends E>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6);

    /**
     * Complete route definition as such that emits values of the {@link Emittable} specified
     * by the definition object by the specified arguments.
     *
     * @param stream the specified {@link Emittable} definition object
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, V> ExpectingStream<V, E> stream(ValueLevel2<? extends Evaluable6Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends Emittable<? extends V, ? extends RuntimeException>, ? extends RuntimeException>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6);

    /**
     * Complete route definition as such that emits values of the {@link Emittable} specified
     * by the definition object by the specified arguments.
     *
     * @param stream the specified {@link Emittable} definition object
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, V> ExpectingStream<V, E> stream(ValueLevel3<? extends Evaluable6Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends Emittable<? extends V, E>, E>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6);


    /**
     * Add optionally the execution of the specified route to the flow
     * depending on the specified values match using the specified {@link Testable6Throwing1}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param value5    the specified argument value 5
     * @param value6    the specified argument value 6
     * @param predicate the specified {@link Testable6Throwing1}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @param <I5>      the type of argument 5
     * @param <I6>      the type of argument 6
     * @return the action choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6> ChoosingAction<$F, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Testable6Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends E> predicate, ActionBlock route);

    /**
     * Add optionally the execution of the specified route to the flow
     * depending on the specified values match using the specified {@link Testable6Throwing1}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param value5    the specified argument value 5
     * @param value6    the specified argument value 6
     * @param predicate the specified {@link Testable6Throwing1}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @param <I5>      the type of argument 5
     * @param <I6>      the type of argument 6
     * @return the action choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6> ChoosingAction<$F, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Testable6Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends E> predicate, ActionLevel1<? extends E> route);

    /**
     * Add optionally the execution of the specified route to the flow
     * depending on the specified values match using the specified {@link Testable6Throwing1}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param value5    the specified argument value 5
     * @param value6    the specified argument value 6
     * @param predicate the specified {@link Testable6Throwing1}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @param <I5>      the type of argument 5
     * @param <I6>      the type of argument 6
     * @return the action choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6> ChoosingAction<$F, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Testable6Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends E> predicate, ActionLevel2<? extends RuntimeException> route);

    /**
     * Add optionally the execution of the specified route to the flow
     * depending on the specified values match using the specified {@link Testable6Throwing1}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param value5    the specified argument value 5
     * @param value6    the specified argument value 6
     * @param predicate the specified {@link Testable6Throwing1}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @param <I5>      the type of argument 5
     * @param <I6>      the type of argument 6
     * @return the action choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6> ChoosingAction<$F, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Testable6Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends E> predicate, ActionLevel3<E> route);

    /**
     * Complete route definition as such that emits optionally value defined in the specified streaming route
     * depending on the specified values match using the specified {@link Testable6Throwing1}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param value5    the specified argument value 5
     * @param value6    the specified argument value 6
     * @param predicate the specified {@link Testable6Throwing1}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @param <I5>      the type of argument 5
     * @param <I6>      the type of argument 6
     * @param <V>       the type of the emitting values
     * @return the streaming choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, V> ChoosingStream<V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Testable6Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends E> predicate, StreamBlock<V> route);

    /**
     * Complete route definition as such that emits optionally value defined in the specified streaming route
     * depending on the specified values match using the specified {@link Testable6Throwing1}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param value5    the specified argument value 5
     * @param value6    the specified argument value 6
     * @param predicate the specified {@link Testable6Throwing1}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @param <I5>      the type of argument 5
     * @param <I6>      the type of argument 6
     * @param <V>       the type of the emitting values
     * @return the streaming choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, V> ChoosingStream<V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Testable6Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends E> predicate, StreamLevel1<V, ? extends E> route);

    /**
     * Complete route definition as such that emits optionally value defined in the specified streaming route
     * depending on the specified values match using the specified {@link Testable6Throwing1}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param value5    the specified argument value 5
     * @param value6    the specified argument value 6
     * @param predicate the specified {@link Testable6Throwing1}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @param <I5>      the type of argument 5
     * @param <I6>      the type of argument 6
     * @param <V>       the type of the emitting values
     * @return the streaming choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, V> ChoosingStream<V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Testable6Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends E> predicate, StreamLevel2<V, ? extends RuntimeException> route);

    /**
     * Complete route definition as such that emits optionally value defined in the specified streaming route
     * depending on the specified values match using the specified {@link Testable6Throwing1}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param value5    the specified argument value 5
     * @param value6    the specified argument value 6
     * @param predicate the specified {@link Testable6Throwing1}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @param <I5>      the type of argument 5
     * @param <I6>      the type of argument 6
     * @param <V>       the type of the emitting values
     * @return the streaming choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, V> ChoosingStream<V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Testable6Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends E> predicate, StreamLevel3<V, E> route);


    /**
     * Continue route definition in the given handler of the unpacked values of the specified {@link Tuple6} value.
     *
     * @param tuple   the specified {@link Tuple6} value
     * @param handler the specified handling route
     * @param <I1>    the type of value 1 of the tuple
     * @param <I2>    the type of value 2 of the tuple
     * @param <I3>    the type of value 3 of the tuple
     * @param <I4>    the type of value 4 of the tuple
     * @param <I5>    the type of value 5 of the tuple
     * @param <I6>    the type of value 6 of the tuple
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, $R extends Routing<?>> $R expand(Value<? extends Tuple6<? extends I1, ? extends I2, ? extends I3, ? extends I4, ? extends I5, ? extends I6>> tuple, Block6<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends Routing<? extends $R>> handler);

    /**
     * Add the specified {@link Executable7} execution by the specified argument values to the flow.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param value5    the specified argument value 5
     * @param value6    the specified argument value 6
     * @param value7    the specified argument value 7
     * @param execution the specified {@link Executable7} execution
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @param <I5>      the type of argument 5
     * @param <I6>      the type of argument 6
     * @param <I7>      the type of argument 7
     * @return the flow definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7> ExpectingAction<$F, E> effect(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Executable7Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends E> execution);

    /**
     * Complete route definition as such that emits the value from the specified {@link Evaluable7}
     * by the specified argument values.
     *
     * @param value1   the specified argument value 1
     * @param value2   the specified argument value 2
     * @param value3   the specified argument value 3
     * @param value4   the specified argument value 4
     * @param value5   the specified argument value 5
     * @param value6   the specified argument value 6
     * @param value7   the specified argument value 7
     * @param supplier the specified value {@link Evaluable7} supplier
     * @param <I1>     the type of argument 1
     * @param <I2>     the type of argument 2
     * @param <I3>     the type of argument 3
     * @param <I4>     the type of argument 4
     * @param <I5>     the type of argument 5
     * @param <I6>     the type of argument 6
     * @param <I7>     the type of argument 7
     * @param <V>      the type of the emitting value
     * @return emitting result definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7, V> ExpectingStream<V, E> supply(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Evaluable7Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends V, ? extends E> supplier);

    /**
     * Continue route definition in the given handler of the value from the specified {@link Evaluable7} supplier
     * by the specified argument values.
     *
     * @param value1   the specified argument value 1
     * @param value2   the specified argument value 2
     * @param value3   the specified argument value 3
     * @param value4   the specified argument value 4
     * @param value5   the specified argument value 5
     * @param value6   the specified argument value 6
     * @param value7   the specified argument value 7
     * @param supplier the specified value {@link Evaluable7} supplier
     * @param handler  the given value handling route
     * @param <I1>     the type of argument 1
     * @param <I2>     the type of argument 2
     * @param <I3>     the type of argument 3
     * @param <I4>     the type of argument 4
     * @param <I5>     the type of argument 5
     * @param <I6>     the type of argument 6
     * @param <I7>     the type of argument 7
     * @param <V>      the type of the emitting value
     * @param <$R>     the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7, V, $R extends Routing<?>> $R supply(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Evaluable7Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends V, ? extends E> supplier, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits values from the supplying {@link BaseStream} source
     * by the specified argument values.
     *
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param value7 the specified argument value 7
     * @param source the supplying {@link BaseStream} source
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @param <I7>   the type of argument 7
     * @param <V>    the type of the emitting values
     * @return emitting result definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7, V> ExpectingStream<V, E> source(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Evaluable7Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends BaseStream<V, ?>, ? extends E> source);

    /**
     * Continue route definition in the given handler of values from the supplying {@link BaseStream} source
     * by the specified argument values.
     *
     * @param value1  the specified argument value 1
     * @param value2  the specified argument value 2
     * @param value3  the specified argument value 3
     * @param value4  the specified argument value 4
     * @param value5  the specified argument value 5
     * @param value6  the specified argument value 6
     * @param value7  the specified argument value 7
     * @param source  the supplying {@link BaseStream} source
     * @param handler the given value handling route
     * @param <I1>    the type of argument 1
     * @param <I2>    the type of argument 2
     * @param <I3>    the type of argument 3
     * @param <I4>    the type of argument 4
     * @param <I5>    the type of argument 5
     * @param <I6>    the type of argument 6
     * @param <I7>    the type of argument 7
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7, V, $R extends Routing<?>> $R source(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Evaluable7Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends BaseStream<V, ?>, ? extends E> source, Block1<? super V, ? extends Routing<? extends $R>> handler);


    /**
     * Add the execution of the specified route by the specified argument values to the flow.
     *
     * @param route  the specified route definition
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param value7 the specified argument value 7
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @param <I7>   the type of argument 7
     * @param <H>    the type of unexpected exception that might be thrown
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7, H extends Exception> CatchingAction<$F, H, E> action(Route7Level0<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends H, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7);

    /**
     * Add the execution of the specified route by the specified argument values to the flow.
     *
     * @param route  the specified route definition
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param value7 the specified argument value 7
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @param <I7>   the type of argument 7
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7> ExpectingAction<$F, E> action(Route7Level1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends E, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7);

    /**
     * Add the execution of the specified route by the specified argument values to the flow.
     *
     * @param route  the specified route definition
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param value7 the specified argument value 7
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @param <I7>   the type of argument 7
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7> ExpectingAction<$F, E> action(Route7Level2<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends RuntimeException, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7);

    /**
     * Add the execution of the specified route by the specified argument values to the flow.
     *
     * @param route  the specified route definition
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param value7 the specified argument value 7
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @param <I7>   the type of argument 7
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7> ExpectingAction<$F, E> action(Route7Level3<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, E, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7);

    /**
     * Add the execution of the {@link Emittable} specified by the definition object
     * by the specified arguments to the flow.
     *
     * @param route  the specified {@link Emittable} definition object
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param value7 the specified argument value 7
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @param <I7>   the type of argument 7
     * @param <H>    the type of unexpected exception that might be thrown
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7, H extends Exception> CatchingAction<$F, H, E> action(ValueLevel0<? extends Evaluable7Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends Emittable<?, ? extends H>, ? extends H>> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7);

    /**
     * Add the execution of the {@link Emittable} specified by the definition object
     * by the specified arguments to the flow.
     *
     * @param route  the specified {@link Emittable} definition object
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param value7 the specified argument value 7
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @param <I7>   the type of argument 7
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7> ExpectingAction<$F, E> action(ValueLevel1<? extends Evaluable7Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends Emittable<?, ? extends E>, ? extends E>> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7);

    /**
     * Add the execution of the {@link Emittable} specified by the definition object
     * by the specified arguments to the flow.
     *
     * @param route  the specified {@link Emittable} definition object
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param value7 the specified argument value 7
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @param <I7>   the type of argument 7
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7> ExpectingAction<$F, E> action(ValueLevel2<? extends Evaluable7Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends Emittable<?, ? extends RuntimeException>, ? extends RuntimeException>> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7);

    /**
     * Add the execution of the {@link Emittable} specified by the definition object
     * by the specified arguments to the flow.
     *
     * @param route  the specified {@link Emittable} definition object
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param value7 the specified argument value 7
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @param <I7>   the type of argument 7
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7> ExpectingAction<$F, E> action(ValueLevel3<? extends Evaluable7Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends Emittable<?, E>, E>> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7);


    /**
     * Complete route definition as such that emits values defined
     * in the specified streaming route by the specified arguments.
     *
     * @param stream the specified streaming route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param value7 the specified argument value 7
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @param <I7>   the type of argument 7
     * @param <V>    the type of the emitting values
     * @param <H>    the type of unexpected exception that might be thrown
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7, V, H extends Exception> CatchingStream<V, H, E> stream(Route7Level0<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends H, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7);

    /**
     * Complete route definition as such that emits values defined
     * in the specified streaming route by the specified arguments.
     *
     * @param stream the specified streaming route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param value7 the specified argument value 7
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @param <I7>   the type of argument 7
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7, V> ExpectingStream<V, E> stream(Route7Level1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends E, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7);

    /**
     * Complete route definition as such that emits values defined
     * in the specified streaming route by the specified arguments.
     *
     * @param stream the specified streaming route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param value7 the specified argument value 7
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @param <I7>   the type of argument 7
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7, V> ExpectingStream<V, E> stream(Route7Level2<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends RuntimeException, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7);

    /**
     * Complete route definition as such that emits values defined
     * in the specified streaming route by the specified arguments.
     *
     * @param stream the specified streaming route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param value7 the specified argument value 7
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @param <I7>   the type of argument 7
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7, V> ExpectingStream<V, E> stream(Route7Level3<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, E, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7);


    /**
     * Complete route definition as such that emits values of the {@link Emittable} specified
     * by the definition object by the specified arguments.
     *
     * @param stream the specified {@link Emittable} definition object
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param value7 the specified argument value 7
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @param <I7>   the type of argument 7
     * @param <V>    the type of the emitting values
     * @param <H>    the type of unexpected exception that might be thrown
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7, V, H extends Exception> CatchingStream<V, H, E> stream(ValueLevel0<? extends Evaluable7Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends Emittable<? extends V, ? extends H>, ? extends H>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7);

    /**
     * Complete route definition as such that emits values of the {@link Emittable} specified
     * by the definition object by the specified arguments.
     *
     * @param stream the specified {@link Emittable} definition object
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param value7 the specified argument value 7
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @param <I7>   the type of argument 7
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7, V> ExpectingStream<V, E> stream(ValueLevel1<? extends Evaluable7Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends Emittable<? extends V, ? extends E>, ? extends E>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7);

    /**
     * Complete route definition as such that emits values of the {@link Emittable} specified
     * by the definition object by the specified arguments.
     *
     * @param stream the specified {@link Emittable} definition object
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param value7 the specified argument value 7
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @param <I7>   the type of argument 7
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7, V> ExpectingStream<V, E> stream(ValueLevel2<? extends Evaluable7Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends Emittable<? extends V, ? extends RuntimeException>, ? extends RuntimeException>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7);

    /**
     * Complete route definition as such that emits values of the {@link Emittable} specified
     * by the definition object by the specified arguments.
     *
     * @param stream the specified {@link Emittable} definition object
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param value7 the specified argument value 7
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @param <I7>   the type of argument 7
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7, V> ExpectingStream<V, E> stream(ValueLevel3<? extends Evaluable7Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends Emittable<? extends V, E>, E>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7);


    /**
     * Add optionally the execution of the specified route to the flow
     * depending on the specified values match using the specified {@link Testable7Throwing1}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param value5    the specified argument value 5
     * @param value6    the specified argument value 6
     * @param value7    the specified argument value 7
     * @param predicate the specified {@link Testable7Throwing1}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @param <I5>      the type of argument 5
     * @param <I6>      the type of argument 6
     * @param <I7>      the type of argument 7
     * @return the action choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7> ChoosingAction<$F, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Testable7Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends E> predicate, ActionBlock route);

    /**
     * Add optionally the execution of the specified route to the flow
     * depending on the specified values match using the specified {@link Testable7Throwing1}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param value5    the specified argument value 5
     * @param value6    the specified argument value 6
     * @param value7    the specified argument value 7
     * @param predicate the specified {@link Testable7Throwing1}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @param <I5>      the type of argument 5
     * @param <I6>      the type of argument 6
     * @param <I7>      the type of argument 7
     * @return the action choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7> ChoosingAction<$F, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Testable7Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends E> predicate, ActionLevel1<? extends E> route);

    /**
     * Add optionally the execution of the specified route to the flow
     * depending on the specified values match using the specified {@link Testable7Throwing1}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param value5    the specified argument value 5
     * @param value6    the specified argument value 6
     * @param value7    the specified argument value 7
     * @param predicate the specified {@link Testable7Throwing1}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @param <I5>      the type of argument 5
     * @param <I6>      the type of argument 6
     * @param <I7>      the type of argument 7
     * @return the action choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7> ChoosingAction<$F, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Testable7Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends E> predicate, ActionLevel2<? extends RuntimeException> route);

    /**
     * Add optionally the execution of the specified route to the flow
     * depending on the specified values match using the specified {@link Testable7Throwing1}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param value5    the specified argument value 5
     * @param value6    the specified argument value 6
     * @param value7    the specified argument value 7
     * @param predicate the specified {@link Testable7Throwing1}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @param <I5>      the type of argument 5
     * @param <I6>      the type of argument 6
     * @param <I7>      the type of argument 7
     * @return the action choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7> ChoosingAction<$F, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Testable7Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends E> predicate, ActionLevel3<E> route);

    /**
     * Complete route definition as such that emits optionally value defined in the specified streaming route
     * depending on the specified values match using the specified {@link Testable7Throwing1}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param value5    the specified argument value 5
     * @param value6    the specified argument value 6
     * @param value7    the specified argument value 7
     * @param predicate the specified {@link Testable7Throwing1}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @param <I5>      the type of argument 5
     * @param <I6>      the type of argument 6
     * @param <I7>      the type of argument 7
     * @param <V>       the type of the emitting values
     * @return the streaming choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7, V> ChoosingStream<V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Testable7Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends E> predicate, StreamBlock<V> route);

    /**
     * Complete route definition as such that emits optionally value defined in the specified streaming route
     * depending on the specified values match using the specified {@link Testable7Throwing1}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param value5    the specified argument value 5
     * @param value6    the specified argument value 6
     * @param value7    the specified argument value 7
     * @param predicate the specified {@link Testable7Throwing1}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @param <I5>      the type of argument 5
     * @param <I6>      the type of argument 6
     * @param <I7>      the type of argument 7
     * @param <V>       the type of the emitting values
     * @return the streaming choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7, V> ChoosingStream<V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Testable7Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends E> predicate, StreamLevel1<V, ? extends E> route);

    /**
     * Complete route definition as such that emits optionally value defined in the specified streaming route
     * depending on the specified values match using the specified {@link Testable7Throwing1}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param value5    the specified argument value 5
     * @param value6    the specified argument value 6
     * @param value7    the specified argument value 7
     * @param predicate the specified {@link Testable7Throwing1}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @param <I5>      the type of argument 5
     * @param <I6>      the type of argument 6
     * @param <I7>      the type of argument 7
     * @param <V>       the type of the emitting values
     * @return the streaming choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7, V> ChoosingStream<V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Testable7Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends E> predicate, StreamLevel2<V, ? extends RuntimeException> route);

    /**
     * Complete route definition as such that emits optionally value defined in the specified streaming route
     * depending on the specified values match using the specified {@link Testable7Throwing1}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param value5    the specified argument value 5
     * @param value6    the specified argument value 6
     * @param value7    the specified argument value 7
     * @param predicate the specified {@link Testable7Throwing1}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @param <I5>      the type of argument 5
     * @param <I6>      the type of argument 6
     * @param <I7>      the type of argument 7
     * @param <V>       the type of the emitting values
     * @return the streaming choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7, V> ChoosingStream<V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Testable7Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends E> predicate, StreamLevel3<V, E> route);


    /**
     * Continue route definition in the given handler of the unpacked values of the specified {@link Tuple7} value.
     *
     * @param tuple   the specified {@link Tuple7} value
     * @param handler the specified handling route
     * @param <I1>    the type of value 1 of the tuple
     * @param <I2>    the type of value 2 of the tuple
     * @param <I3>    the type of value 3 of the tuple
     * @param <I4>    the type of value 4 of the tuple
     * @param <I5>    the type of value 5 of the tuple
     * @param <I6>    the type of value 6 of the tuple
     * @param <I7>    the type of value 7 of the tuple
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7, $R extends Routing<?>> $R expand(Value<? extends Tuple7<? extends I1, ? extends I2, ? extends I3, ? extends I4, ? extends I5, ? extends I6, ? extends I7>> tuple, Block7<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends Routing<? extends $R>> handler);

    /**
     * Add the specified {@link Executable8} execution by the specified argument values to the flow.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param value5    the specified argument value 5
     * @param value6    the specified argument value 6
     * @param value7    the specified argument value 7
     * @param value8    the specified argument value 8
     * @param execution the specified {@link Executable8} execution
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @param <I5>      the type of argument 5
     * @param <I6>      the type of argument 6
     * @param <I7>      the type of argument 7
     * @param <I8>      the type of argument 8
     * @return the flow definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7, I8> ExpectingAction<$F, E> effect(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8, Executable8Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends E> execution);


    /**
     * Complete route definition as such that emits the value from the specified {@link Evaluable8}
     * by the specified argument values.
     *
     * @param value1   the specified argument value 1
     * @param value2   the specified argument value 2
     * @param value3   the specified argument value 3
     * @param value4   the specified argument value 4
     * @param value5   the specified argument value 5
     * @param value6   the specified argument value 6
     * @param value7   the specified argument value 7
     * @param value8   the specified argument value 8
     * @param supplier the specified value {@link Evaluable8} supplier
     * @param <I1>     the type of argument 1
     * @param <I2>     the type of argument 2
     * @param <I3>     the type of argument 3
     * @param <I4>     the type of argument 4
     * @param <I5>     the type of argument 5
     * @param <I6>     the type of argument 6
     * @param <I7>     the type of argument 7
     * @param <I8>     the type of argument 8
     * @param <V>      the type of the emitting value
     * @return emitting result definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7, I8, V> ExpectingStream<V, E> supply(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8, Evaluable8Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends V, ? extends E> supplier);

    /**
     * Continue route definition in the given handler of the value from the specified {@link Evaluable8} supplier
     * by the specified argument values.
     *
     * @param value1   the specified argument value 1
     * @param value2   the specified argument value 2
     * @param value3   the specified argument value 3
     * @param value4   the specified argument value 4
     * @param value5   the specified argument value 5
     * @param value6   the specified argument value 6
     * @param value7   the specified argument value 7
     * @param value8   the specified argument value 8
     * @param supplier the specified value {@link Evaluable8} supplier
     * @param handler  the given value handling route
     * @param <I1>     the type of argument 1
     * @param <I2>     the type of argument 2
     * @param <I3>     the type of argument 3
     * @param <I4>     the type of argument 4
     * @param <I5>     the type of argument 5
     * @param <I6>     the type of argument 6
     * @param <I7>     the type of argument 7
     * @param <I8>     the type of argument 8
     * @param <V>      the type of the emitting value
     * @param <$R>     the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7, I8, V, $R extends Routing<?>> $R supply(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8, Evaluable8Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends V, ? extends E> supplier, Block1<? super V, ? extends Routing<? extends $R>> handler);


    /**
     * Complete route definition as such that emits values from the supplying {@link BaseStream} source
     * by the specified argument values.
     *
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param value7 the specified argument value 7
     * @param value8 the specified argument value 8
     * @param source the supplying {@link BaseStream} source
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @param <I7>   the type of argument 7
     * @param <I8>   the type of argument 8
     * @param <V>    the type of the emitting values
     * @return emitting result definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7, I8, V> ExpectingStream<V, E> source(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8, Evaluable8Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends BaseStream<V, ?>, ? extends E> source);

    /**
     * Continue route definition in the given handler of values from the supplying {@link BaseStream} source
     * by the specified argument values.
     *
     * @param value1  the specified argument value 1
     * @param value2  the specified argument value 2
     * @param value3  the specified argument value 3
     * @param value4  the specified argument value 4
     * @param value5  the specified argument value 5
     * @param value6  the specified argument value 6
     * @param value7  the specified argument value 7
     * @param value8  the specified argument value 8
     * @param source  the supplying {@link BaseStream} source
     * @param handler the given value handling route
     * @param <I1>    the type of argument 1
     * @param <I2>    the type of argument 2
     * @param <I3>    the type of argument 3
     * @param <I4>    the type of argument 4
     * @param <I5>    the type of argument 5
     * @param <I6>    the type of argument 6
     * @param <I7>    the type of argument 7
     * @param <I8>    the type of argument 8
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7, I8, V, $R extends Routing<?>> $R source(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8, Evaluable8Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends BaseStream<V, ?>, ? extends E> source, Block1<? super V, ? extends Routing<? extends $R>> handler);


    /**
     * Add the execution of the specified route by the specified argument values to the flow.
     *
     * @param route  the specified route definition
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param value7 the specified argument value 7
     * @param value8 the specified argument value 8
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @param <I7>   the type of argument 7
     * @param <I8>   the type of argument 8
     * @param <H>    the type of unexpected exception that might be thrown
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7, I8, H extends Exception> CatchingAction<$F, H, E> action(Route8Level0<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends H, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8);

    /**
     * Add the execution of the specified route by the specified argument values to the flow.
     *
     * @param route  the specified route definition
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param value7 the specified argument value 7
     * @param value8 the specified argument value 8
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @param <I7>   the type of argument 7
     * @param <I8>   the type of argument 8
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7, I8> ExpectingAction<$F, E> action(Route8Level1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends E, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8);

    /**
     * Add the execution of the specified route by the specified argument values to the flow.
     *
     * @param route  the specified route definition
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param value7 the specified argument value 7
     * @param value8 the specified argument value 8
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @param <I7>   the type of argument 7
     * @param <I8>   the type of argument 8
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7, I8> ExpectingAction<$F, E> action(Route8Level2<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends RuntimeException, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8);

    /**
     * Add the execution of the specified route by the specified argument values to the flow.
     *
     * @param route  the specified route definition
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param value7 the specified argument value 7
     * @param value8 the specified argument value 8
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @param <I7>   the type of argument 7
     * @param <I8>   the type of argument 8
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7, I8> ExpectingAction<$F, E> action(Route8Level3<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, E, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8);

    /**
     * Add the execution of the {@link Emittable} specified by the definition object
     * by the specified arguments to the flow.
     *
     * @param route  the specified {@link Emittable} definition object
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param value7 the specified argument value 7
     * @param value8 the specified argument value 8
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @param <I7>   the type of argument 7
     * @param <I8>   the type of argument 8
     * @param <H>    the type of unexpected exception that might be thrown
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7, I8, H extends Exception> CatchingAction<$F, H, E> action(ValueLevel0<? extends Evaluable8Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends Emittable<?, ? extends H>, ? extends H>> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8);

    /**
     * Add the execution of the {@link Emittable} specified by the definition object
     * by the specified arguments to the flow.
     *
     * @param route  the specified {@link Emittable} definition object
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param value7 the specified argument value 7
     * @param value8 the specified argument value 8
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @param <I7>   the type of argument 7
     * @param <I8>   the type of argument 8
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7, I8> ExpectingAction<$F, E> action(ValueLevel1<? extends Evaluable8Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends Emittable<?, ? extends E>, ? extends E>> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8);

    /**
     * Add the execution of the {@link Emittable} specified by the definition object
     * by the specified arguments to the flow.
     *
     * @param route  the specified {@link Emittable} definition object
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param value7 the specified argument value 7
     * @param value8 the specified argument value 8
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @param <I7>   the type of argument 7
     * @param <I8>   the type of argument 8
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7, I8> ExpectingAction<$F, E> action(ValueLevel2<? extends Evaluable8Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends Emittable<?, ? extends RuntimeException>, ? extends RuntimeException>> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8);

    /**
     * Add the execution of the {@link Emittable} specified by the definition object
     * by the specified arguments to the flow.
     *
     * @param route  the specified {@link Emittable} definition object
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param value7 the specified argument value 7
     * @param value8 the specified argument value 8
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @param <I7>   the type of argument 7
     * @param <I8>   the type of argument 8
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7, I8> ExpectingAction<$F, E> action(ValueLevel3<? extends Evaluable8Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends Emittable<?, E>, E>> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8);


    /**
     * Complete route definition as such that emits values defined
     * in the specified streaming route by the specified arguments.
     *
     * @param stream the specified streaming route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param value7 the specified argument value 7
     * @param value8 the specified argument value 8
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @param <I7>   the type of argument 7
     * @param <I8>   the type of argument 8
     * @param <V>    the type of the emitting values
     * @param <H>    the type of unexpected exception that might be thrown
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7, I8, V, H extends Exception> CatchingStream<V, H, E> stream(Route8Level0<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends H, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8);

    /**
     * Complete route definition as such that emits values defined
     * in the specified streaming route by the specified arguments.
     *
     * @param stream the specified streaming route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param value7 the specified argument value 7
     * @param value8 the specified argument value 8
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @param <I7>   the type of argument 7
     * @param <I8>   the type of argument 8
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7, I8, V> ExpectingStream<V, E> stream(Route8Level1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends E, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8);

    /**
     * Complete route definition as such that emits values defined
     * in the specified streaming route by the specified arguments.
     *
     * @param stream the specified streaming route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param value7 the specified argument value 7
     * @param value8 the specified argument value 8
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @param <I7>   the type of argument 7
     * @param <I8>   the type of argument 8
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7, I8, V> ExpectingStream<V, E> stream(Route8Level2<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends RuntimeException, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8);

    /**
     * Complete route definition as such that emits values defined
     * in the specified streaming route by the specified arguments.
     *
     * @param stream the specified streaming route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param value7 the specified argument value 7
     * @param value8 the specified argument value 8
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @param <I7>   the type of argument 7
     * @param <I8>   the type of argument 8
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7, I8, V> ExpectingStream<V, E> stream(Route8Level3<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, E, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8);


    /**
     * Complete route definition as such that emits values of the {@link Emittable} specified
     * by the definition object by the specified arguments.
     *
     * @param stream the specified {@link Emittable} definition object
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param value7 the specified argument value 7
     * @param value8 the specified argument value 8
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @param <I7>   the type of argument 7
     * @param <I8>   the type of argument 8
     * @param <V>    the type of the emitting values
     * @param <H>    the type of unexpected exception that might be thrown
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7, I8, V, H extends Exception> CatchingStream<V, H, E> stream(ValueLevel0<? extends Evaluable8Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends Emittable<? extends V, ? extends H>, ? extends H>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8);

    /**
     * Complete route definition as such that emits values of the {@link Emittable} specified
     * by the definition object by the specified arguments.
     *
     * @param stream the specified {@link Emittable} definition object
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param value7 the specified argument value 7
     * @param value8 the specified argument value 8
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @param <I7>   the type of argument 7
     * @param <I8>   the type of argument 8
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7, I8, V> ExpectingStream<V, E> stream(ValueLevel1<? extends Evaluable8Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends Emittable<? extends V, ? extends E>, ? extends E>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8);

    /**
     * Complete route definition as such that emits values of the {@link Emittable} specified
     * by the definition object by the specified arguments.
     *
     * @param stream the specified {@link Emittable} definition object
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param value7 the specified argument value 7
     * @param value8 the specified argument value 8
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @param <I7>   the type of argument 7
     * @param <I8>   the type of argument 8
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7, I8, V> ExpectingStream<V, E> stream(ValueLevel2<? extends Evaluable8Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends Emittable<? extends V, ? extends RuntimeException>, ? extends RuntimeException>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8);

    /**
     * Complete route definition as such that emits values of the {@link Emittable} specified
     * by the definition object by the specified arguments.
     *
     * @param stream the specified {@link Emittable} definition object
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param value7 the specified argument value 7
     * @param value8 the specified argument value 8
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @param <I7>   the type of argument 7
     * @param <I8>   the type of argument 8
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7, I8, V> ExpectingStream<V, E> stream(ValueLevel3<? extends Evaluable8Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends Emittable<? extends V, E>, E>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8);


    /**
     * Add optionally the execution of the specified route to the flow
     * depending on the specified values match using the specified {@link Testable8Throwing1}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param value5    the specified argument value 5
     * @param value6    the specified argument value 6
     * @param value7    the specified argument value 7
     * @param value8    the specified argument value 8
     * @param predicate the specified {@link Testable8Throwing1}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @param <I5>      the type of argument 5
     * @param <I6>      the type of argument 6
     * @param <I7>      the type of argument 7
     * @param <I8>      the type of argument 8
     * @return the action choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7, I8> ChoosingAction<$F, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8, Testable8Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends E> predicate, ActionBlock route);

    /**
     * Add optionally the execution of the specified route to the flow
     * depending on the specified values match using the specified {@link Testable8Throwing1}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param value5    the specified argument value 5
     * @param value6    the specified argument value 6
     * @param value7    the specified argument value 7
     * @param value8    the specified argument value 8
     * @param predicate the specified {@link Testable8Throwing1}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @param <I5>      the type of argument 5
     * @param <I6>      the type of argument 6
     * @param <I7>      the type of argument 7
     * @param <I8>      the type of argument 8
     * @return the action choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7, I8> ChoosingAction<$F, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8, Testable8Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends E> predicate, ActionLevel1<? extends E> route);

    /**
     * Add optionally the execution of the specified route to the flow
     * depending on the specified values match using the specified {@link Testable8Throwing1}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param value5    the specified argument value 5
     * @param value6    the specified argument value 6
     * @param value7    the specified argument value 7
     * @param value8    the specified argument value 8
     * @param predicate the specified {@link Testable8Throwing1}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @param <I5>      the type of argument 5
     * @param <I6>      the type of argument 6
     * @param <I7>      the type of argument 7
     * @param <I8>      the type of argument 8
     * @return the action choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7, I8> ChoosingAction<$F, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8, Testable8Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends E> predicate, ActionLevel2<? extends RuntimeException> route);

    /**
     * Add optionally the execution of the specified route to the flow
     * depending on the specified values match using the specified {@link Testable8Throwing1}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param value5    the specified argument value 5
     * @param value6    the specified argument value 6
     * @param value7    the specified argument value 7
     * @param value8    the specified argument value 8
     * @param predicate the specified {@link Testable8Throwing1}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @param <I5>      the type of argument 5
     * @param <I6>      the type of argument 6
     * @param <I7>      the type of argument 7
     * @param <I8>      the type of argument 8
     * @return the action choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7, I8> ChoosingAction<$F, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8, Testable8Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends E> predicate, ActionLevel3<E> route);

    /**
     * Complete route definition as such that emits optionally value defined in the specified streaming route
     * depending on the specified values match using the specified {@link Testable8Throwing1}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param value5    the specified argument value 5
     * @param value6    the specified argument value 6
     * @param value7    the specified argument value 7
     * @param value8    the specified argument value 8
     * @param predicate the specified {@link Testable8Throwing1}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @param <I5>      the type of argument 5
     * @param <I6>      the type of argument 6
     * @param <I7>      the type of argument 7
     * @param <I8>      the type of argument 8
     * @param <V>       the type of the emitting values
     * @return the streaming choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7, I8, V> ChoosingStream<V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8, Testable8Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends E> predicate, StreamBlock<V> route);

    /**
     * Complete route definition as such that emits optionally value defined in the specified streaming route
     * depending on the specified values match using the specified {@link Testable8Throwing1}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param value5    the specified argument value 5
     * @param value6    the specified argument value 6
     * @param value7    the specified argument value 7
     * @param value8    the specified argument value 8
     * @param predicate the specified {@link Testable8Throwing1}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @param <I5>      the type of argument 5
     * @param <I6>      the type of argument 6
     * @param <I7>      the type of argument 7
     * @param <I8>      the type of argument 8
     * @param <V>       the type of the emitting values
     * @return the streaming choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7, I8, V> ChoosingStream<V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8, Testable8Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends E> predicate, StreamLevel1<V, ? extends E> route);

    /**
     * Complete route definition as such that emits optionally value defined in the specified streaming route
     * depending on the specified values match using the specified {@link Testable8Throwing1}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param value5    the specified argument value 5
     * @param value6    the specified argument value 6
     * @param value7    the specified argument value 7
     * @param value8    the specified argument value 8
     * @param predicate the specified {@link Testable8Throwing1}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @param <I5>      the type of argument 5
     * @param <I6>      the type of argument 6
     * @param <I7>      the type of argument 7
     * @param <I8>      the type of argument 8
     * @param <V>       the type of the emitting values
     * @return the streaming choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7, I8, V> ChoosingStream<V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8, Testable8Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends E> predicate, StreamLevel2<V, ? extends RuntimeException> route);

    /**
     * Complete route definition as such that emits optionally value defined in the specified streaming route
     * depending on the specified values match using the specified {@link Testable8Throwing1}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param value5    the specified argument value 5
     * @param value6    the specified argument value 6
     * @param value7    the specified argument value 7
     * @param value8    the specified argument value 8
     * @param predicate the specified {@link Testable8Throwing1}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @param <I5>      the type of argument 5
     * @param <I6>      the type of argument 6
     * @param <I7>      the type of argument 7
     * @param <I8>      the type of argument 8
     * @param <V>       the type of the emitting values
     * @return the streaming choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7, I8, V> ChoosingStream<V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8, Testable8Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends E> predicate, StreamLevel3<V, E> route);

    /**
     * Continue route definition in the given handler of the unpacked values of the specified {@link Tuple8} value.
     *
     * @param tuple   the specified {@link Tuple8} value
     * @param handler the specified handling route
     * @param <I1>    the type of value 1 of the tuple
     * @param <I2>    the type of value 2 of the tuple
     * @param <I3>    the type of value 3 of the tuple
     * @param <I4>    the type of value 4 of the tuple
     * @param <I5>    the type of value 5 of the tuple
     * @param <I6>    the type of value 6 of the tuple
     * @param <I7>    the type of value 7 of the tuple
     * @param <I8>    the type of value 8 of the tuple
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7, I8, $R extends Routing<?>> $R expand(Value<? extends Tuple8<? extends I1, ? extends I2, ? extends I3, ? extends I4, ? extends I5, ? extends I6, ? extends I7, ? extends I8>> tuple, Block8<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends Routing<? extends $R>> handler);


    /**
     * A streaming result following execution definition.
     *
     * @param <V> the type of the emitting values
     * @param <E> the type of possible exception that might be thrown
     */
    interface Following<V, E extends Exception> extends Emitting<V> {

        /**
         * Add the execution of the specified route after the streaming completion.
         *
         * @param route the specified route to execute after the streaming completion
         * @return the streaming result definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        Emitting<V> follow(Block<? extends Flowing<?>> route);

        /**
         * Add the execution of the specified route after the streaming completion.
         *
         * @param route the specified route to execute after the streaming completion
         * @return the streaming result definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        Emitting<V> follow(RouteLevel1<? extends E, ?> route);

        /**
         * Add the execution of the specified route after the streaming completion.
         *
         * @param route the specified route to execute after the streaming completion
         * @return the streaming result definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        Emitting<V> follow(RouteLevel2<? extends RuntimeException, ?> route);

        /**
         * Add the execution of the specified route after the streaming completion.
         *
         * @param route the specified route to execute after the streaming completion
         * @return the streaming result definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        Emitting<V> follow(RouteLevel3<E, ?> route);
    }

    /**
     * Throwing expected exception route attempt definition object.
     *
     * @param <$A> the type of the route attempt definition object
     * @param <$R> the type of the route definition result
     * @param <E>  the type of possible exception
     */
    interface Expecting<$A extends Expecting<$A, $R, E>, $R extends Routing<?>, E extends Exception> {

        /**
         * Define the number of retries after route execution failures.
         *
         * @param retries the number of retries
         * @return attempt definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        $A repair(long retries);

        /**
         * Define the specified route for exceptions of the specified type.
         *
         * @param type  the specified exception type
         * @param route the specified exception route
         * @return attempt definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        $A caught(Class<? extends Throwable> type, Block<? extends Routing<? extends $R>> route);

        /**
         * Define the specified handling route for exceptions of the specified type.
         *
         * @param type  the specified exception type
         * @param route the specified exception handling route
         * @param <C>   the type of the exception to handle
         * @return attempt definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <C extends Throwable> $A caught(Class<? extends C> type, Block1<? super C, ? extends Routing<? extends $R>> route);

        /**
         * Define the specified handling route for exceptions of the specified type.
         *
         * @param type  the specified exception type
         * @param route the specified exception handling route
         * @param <C>   the type of the exception to handle
         * @return attempt definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <C extends Throwable> $A caught(Class<? extends C> type, Route1Level1<? super C, ? extends E, ? extends $R> route);

        /**
         * Define the specified handling route for exceptions of the specified type.
         *
         * @param type  the specified exception type
         * @param route the specified exception handling route
         * @param <C>   the type of the exception to handle
         * @return attempt definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <C extends Throwable> $A caught(Class<? extends C> type, Route1Level2<? super C, ? extends RuntimeException, ? extends $R> route);

        /**
         * Define the specified handling route for exceptions of the specified type.
         *
         * @param type  the specified exception type
         * @param route the specified exception handling route
         * @param <C>   the type of the exception to handle
         * @return attempt definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <C extends Throwable> $A caught(Class<? extends C> type, Route1Level3<? super C, E, ? extends $R> route);
    }

    /**
     * Throwing expected exception action attempt definition object.
     *
     * @param <$F> the type of the flow definition interface
     * @param <E>  the type of possible exception
     */
    interface ExpectingAction<$F extends Flow<?, E>, E extends Exception>
            extends Expecting<ExpectingAction<$F, E>, Flowing<?>, E>, Flow<$F, E> {
    }

    /**
     * Throwing expected exception stream attempt definition object.
     *
     * @param <V> the type of the emitting values
     * @param <E> the type of possible exception that might be thrown
     */
    interface ExpectingStream<V, E extends Exception>
            extends Expecting<ExpectingStream<V, E>, Emitting<? extends V>, E>, Following<V, E> {
    }


    /**
     * Throwing the unexpected exception route attempt definition object.
     *
     * @param <$A> the type of the throwing expected exception attempt definition object
     * @param <$R> the type of the route definition result
     * @param <H>  the type of possible unexpected exception that might be thrown
     * @param <E>  the type of possible expected exception that might be thrown
     */
    interface Catching<$A extends Expecting<$A, $R, E>, $R extends Routing<?>, H extends Exception, E extends Exception> {

        /**
         * Define the specified route for caught exception.
         *
         * @param route the specified exception route
         * @return attempt definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        $A caught(Block<? extends Routing<? extends $R>> route);

        /**
         * Define the specified handling route for caught exception.
         *
         * @param route the specified exception handling route
         * @return attempt definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        $A caught(Block1<? super H, ? extends Routing<? extends $R>> route);

        /**
         * Define the specified handling route for caught exception.
         *
         * @param route the specified exception handling route
         * @return attempt definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        $A caught(Route1Level1<? super H, ? extends E, ? extends $R> route);

        /**
         * Define the specified handling route for caught exception.
         *
         * @param route the specified exception handling route
         * @return attempt definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        $A caught(Route1Level2<? super H, ? extends RuntimeException, ? extends $R> route);

        /**
         * Define the specified handling route for caught exception.
         *
         * @param route the specified exception handling route
         * @return attempt definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        $A caught(Route1Level3<? super H, E, ? extends $R> route);
    }

    /**
     * Throwing the unexpected exception action attempt definition object.
     *
     * @param <$F> the type of the flow definition interface
     * @param <H>  the type of possible unexpected exception that might be thrown
     * @param <E>  the type of possible expected exception that might be thrown
     */
    interface CatchingAction<$F extends Flow<?, E>, H extends Exception, E extends Exception>
            extends Catching<ExpectingAction<$F, E>, Flowing<?>, H, E> {
    }

    /**
     * Throwing the unexpected exception stream attempt definition object.
     *
     * @param <V> the type of the emitting values
     * @param <H> the type of possible unexpected exception that might be thrown
     * @param <E> the type of possible expected exception that might be thrown
     */
    interface CatchingStream<V, H extends Exception, E extends Exception>
            extends Catching<ExpectingStream<V, E>, Emitting<? extends V>, H, E> {
    }


    /**
     * Route conditional definition object.
     *
     * @param <$C> the type of the route conditional definition object
     * @param <$E> the type of the conditional route definition result
     * @param <$R> the type of the route definition result
     * @param <E>  the type of possible exception
     */
    interface Choosing<$C extends Choosing<$C, $E, $R, E>, $E extends Routing<?>, $R extends Routing<?>, E extends Exception> {

        /**
         * Complete conditional definition specifying the route to execute if no previous cases' conditions match.
         *
         * @param route the specified route definition
         * @return the conditional route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        $E option(Block<? extends Routing<? extends $R>> route);

        /**
         * Complete conditional definition specifying the route to execute if no previous cases' conditions match.
         *
         * @param route the specified route definition
         * @return the conditional route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        $E option(RouteLevel1<? extends E, ? extends Routing<? extends $R>> route);

        /**
         * Complete conditional definition specifying the route to execute if no previous cases' conditions match.
         *
         * @param route the specified route definition
         * @return the conditional route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        $E option(RouteLevel2<? extends RuntimeException, ? extends Routing<? extends $R>> route);

        /**
         * Complete conditional definition specifying the route to execute if no previous cases' conditions match.
         *
         * @param route the specified route definition
         * @return the conditional route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        $E option(RouteLevel3<E, ? extends Routing<? extends $R>> route);

        /**
         * Add the specified route conditional execution depending on the specified boolean result flag match.
         *
         * @param predicate the specified boolean result value
         * @param route     the specified conditional route definition
         * @return conditional route definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        $C option(Value<Boolean> predicate, Block<? extends Routing<? extends $R>> route);

        /**
         * Add the specified route conditional execution depending on the specified boolean result flag match.
         *
         * @param predicate the specified boolean result value
         * @param route     the specified conditional route definition
         * @return conditional route definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        $C option(Value<Boolean> predicate, RouteLevel1<? extends E, ? extends Routing<? extends $R>> route);

        /**
         * Add the specified route conditional execution depending on the specified boolean result flag match.
         *
         * @param predicate the specified boolean result value
         * @param route     the specified conditional route definition
         * @return conditional route definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        $C option(Value<Boolean> predicate, RouteLevel2<? extends RuntimeException, ? extends Routing<? extends $R>> route);

        /**
         * Add the specified route conditional execution depending on the specified boolean result flag match.
         *
         * @param predicate the specified boolean result value
         * @param route     the specified conditional route definition
         * @return conditional route definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        $C option(Value<Boolean> predicate, RouteLevel3<E, ? extends Routing<? extends $R>> route);

        /**
         * Add the specified route conditional execution depending on the specified {@link Testable} match.
         *
         * @param predicate the specified {@link Testable}
         * @param route     the specified route definition
         * @return conditional route definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        $C option(TestableThrowing1<? extends E> predicate, Block<? extends Routing<? extends $R>> route);

        /**
         * Add the specified route conditional execution depending on the specified {@link Testable} match.
         *
         * @param predicate the specified {@link Testable}
         * @param route     the specified route definition
         * @return conditional route definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        $C option(TestableThrowing1<? extends E> predicate, RouteLevel1<? extends E, ? extends Routing<? extends $R>> route);

        /**
         * Add the specified route conditional execution depending on the specified {@link Testable} match.
         *
         * @param predicate the specified {@link Testable}
         * @param route     the specified route definition
         * @return conditional route definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        $C option(TestableThrowing1<? extends E> predicate, RouteLevel2<? extends RuntimeException, ? extends Routing<? extends $R>> route);

        /**
         * Add the specified route conditional execution depending on the specified {@link Testable} match.
         *
         * @param predicate the specified {@link Testable}
         * @param route     the specified route definition
         * @return conditional route definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        $C option(TestableThrowing1<? extends E> predicate, RouteLevel3<E, ? extends Routing<? extends $R>> route);

        /**
         * Add the specified route conditional execution depending on the specified
         * value match using the specified {@link Testable}.
         *
         * @param value     the specified value
         * @param predicate the specified {@link Testable}
         * @param route     the specified route definition
         * @param <I>       the type of the argument
         * @return conditional route definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <I> $C option(Value<? extends I> value, Testable1Throwing1<? super I, ? extends E> predicate, Block<? extends Routing<? extends $R>> route);

        /**
         * Add the specified route conditional execution depending on the specified
         * value match using the specified {@link Testable}.
         *
         * @param value     the specified value
         * @param predicate the specified {@link Testable}
         * @param route     the specified route definition
         * @param <I>       the type of the argument
         * @return conditional route definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <I> $C option(Value<? extends I> value, Testable1Throwing1<? super I, ? extends E> predicate, RouteLevel1<? extends E, ? extends Routing<? extends $R>> route);

        /**
         * Add the specified route conditional execution depending on the specified
         * value match using the specified {@link Testable}.
         *
         * @param value     the specified value
         * @param predicate the specified {@link Testable}
         * @param route     the specified route definition
         * @param <I>       the type of the argument
         * @return conditional route definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <I> $C option(Value<? extends I> value, Testable1Throwing1<? super I, ? extends E> predicate, RouteLevel2<? extends RuntimeException, ? extends Routing<? extends $R>> route);

        /**
         * Add the specified route conditional execution depending on the specified
         * value match using the specified {@link Testable}.
         *
         * @param value     the specified value
         * @param predicate the specified {@link Testable}
         * @param route     the specified route definition
         * @param <I>       the type of the argument
         * @return conditional route definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <I> $C option(Value<? extends I> value, Testable1Throwing1<? super I, ? extends E> predicate, RouteLevel3<E, ? extends Routing<? extends $R>> route);

        /**
         * Add the specified route conditional execution depending on the specified
         * values match using the specified {@link Testable2Throwing1}.
         *
         * @param value1    the specified argument value 1
         * @param value2    the specified argument value 2
         * @param predicate the specified {@link Testable2Throwing1}
         * @param route     the specified route definition
         * @param <I1>      the type of argument 1
         * @param <I2>      the type of argument 2
         * @return conditional route definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <I1, I2> $C option(Value<? extends I1> value1, Value<? extends I2> value2, Testable2Throwing1<? super I1, ? super I2, ? extends E> predicate, Block<? extends Routing<? extends $R>> route);

        /**
         * Add the specified route conditional execution depending on the specified
         * values match using the specified {@link Testable2Throwing1}.
         *
         * @param value1    the specified argument value 1
         * @param value2    the specified argument value 2
         * @param predicate the specified {@link Testable2Throwing1}
         * @param route     the specified route definition
         * @param <I1>      the type of argument 1
         * @param <I2>      the type of argument 2
         * @return conditional route definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <I1, I2> $C option(Value<? extends I1> value1, Value<? extends I2> value2, Testable2Throwing1<? super I1, ? super I2, ? extends E> predicate, RouteLevel1<? extends E, ? extends Routing<? extends $R>> route);

        /**
         * Add the specified route conditional execution depending on the specified
         * values match using the specified {@link Testable2Throwing1}.
         *
         * @param value1    the specified argument value 1
         * @param value2    the specified argument value 2
         * @param predicate the specified {@link Testable2Throwing1}
         * @param route     the specified route definition
         * @param <I1>      the type of argument 1
         * @param <I2>      the type of argument 2
         * @return conditional route definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <I1, I2> $C option(Value<? extends I1> value1, Value<? extends I2> value2, Testable2Throwing1<? super I1, ? super I2, ? extends E> predicate, RouteLevel2<? extends RuntimeException, ? extends Routing<? extends $R>> route);

        /**
         * Add the specified route conditional execution depending on the specified
         * values match using the specified {@link Testable2Throwing1}.
         *
         * @param value1    the specified argument value 1
         * @param value2    the specified argument value 2
         * @param predicate the specified {@link Testable2Throwing1}
         * @param route     the specified route definition
         * @param <I1>      the type of argument 1
         * @param <I2>      the type of argument 2
         * @return conditional route definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <I1, I2> $C option(Value<? extends I1> value1, Value<? extends I2> value2, Testable2Throwing1<? super I1, ? super I2, ? extends E> predicate, RouteLevel3<E, ? extends Routing<? extends $R>> route);

        /**
         * Add the specified route conditional execution depending on the specified
         * values match using the specified {@link Testable3Throwing1}.
         *
         * @param value1    the specified argument value 1
         * @param value2    the specified argument value 2
         * @param value3    the specified argument value 3
         * @param predicate the specified {@link Testable3Throwing1}
         * @param route     the specified route definition
         * @param <I1>      the type of argument 1
         * @param <I2>      the type of argument 2
         * @param <I3>      the type of argument 3
         * @return conditional route definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <I1, I2, I3> $C option(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Testable3Throwing1<? super I1, ? super I2, ? super I3, ? extends E> predicate, Block<? extends Routing<? extends $R>> route);

        /**
         * Add the specified route conditional execution depending on the specified
         * values match using the specified {@link Testable3Throwing1}.
         *
         * @param value1    the specified argument value 1
         * @param value2    the specified argument value 2
         * @param value3    the specified argument value 3
         * @param predicate the specified {@link Testable3Throwing1}
         * @param route     the specified route definition
         * @param <I1>      the type of argument 1
         * @param <I2>      the type of argument 2
         * @param <I3>      the type of argument 3
         * @return conditional route definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <I1, I2, I3> $C option(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Testable3Throwing1<? super I1, ? super I2, ? super I3, ? extends E> predicate, RouteLevel1<? extends E, ? extends Routing<? extends $R>> route);

        /**
         * Add the specified route conditional execution depending on the specified
         * values match using the specified {@link Testable3Throwing1}.
         *
         * @param value1    the specified argument value 1
         * @param value2    the specified argument value 2
         * @param value3    the specified argument value 3
         * @param predicate the specified {@link Testable3Throwing1}
         * @param route     the specified route definition
         * @param <I1>      the type of argument 1
         * @param <I2>      the type of argument 2
         * @param <I3>      the type of argument 3
         * @return conditional route definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <I1, I2, I3> $C option(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Testable3Throwing1<? super I1, ? super I2, ? super I3, ? extends E> predicate, RouteLevel2<? extends RuntimeException, ? extends Routing<? extends $R>> route);

        /**
         * Add the specified route conditional execution depending on the specified
         * values match using the specified {@link Testable3Throwing1}.
         *
         * @param value1    the specified argument value 1
         * @param value2    the specified argument value 2
         * @param value3    the specified argument value 3
         * @param predicate the specified {@link Testable3Throwing1}
         * @param route     the specified route definition
         * @param <I1>      the type of argument 1
         * @param <I2>      the type of argument 2
         * @param <I3>      the type of argument 3
         * @return conditional route definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <I1, I2, I3> $C option(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Testable3Throwing1<? super I1, ? super I2, ? super I3, ? extends E> predicate, RouteLevel3<E, ? extends Routing<? extends $R>> route);

        /**
         * Add the specified route conditional execution depending on the specified
         * values match using the specified {@link Testable4Throwing1}.
         *
         * @param value1    the specified argument value 1
         * @param value2    the specified argument value 2
         * @param value3    the specified argument value 3
         * @param value4    the specified argument value 4
         * @param predicate the specified {@link Testable4Throwing1}
         * @param route     the specified route definition
         * @param <I1>      the type of argument 1
         * @param <I2>      the type of argument 2
         * @param <I3>      the type of argument 3
         * @param <I4>      the type of argument 4
         * @return conditional route definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <I1, I2, I3, I4> $C option(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Testable4Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? extends E> predicate, Block<? extends Routing<? extends $R>> route);

        /**
         * Add the specified route conditional execution depending on the specified
         * values match using the specified {@link Testable4Throwing1}.
         *
         * @param value1    the specified argument value 1
         * @param value2    the specified argument value 2
         * @param value3    the specified argument value 3
         * @param value4    the specified argument value 4
         * @param predicate the specified {@link Testable4Throwing1}
         * @param route     the specified route definition
         * @param <I1>      the type of argument 1
         * @param <I2>      the type of argument 2
         * @param <I3>      the type of argument 3
         * @param <I4>      the type of argument 4
         * @return conditional route definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <I1, I2, I3, I4> $C option(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Testable4Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? extends E> predicate, RouteLevel1<? extends E, ? extends Routing<? extends $R>> route);

        /**
         * Add the specified route conditional execution depending on the specified
         * values match using the specified {@link Testable4Throwing1}.
         *
         * @param value1    the specified argument value 1
         * @param value2    the specified argument value 2
         * @param value3    the specified argument value 3
         * @param value4    the specified argument value 4
         * @param predicate the specified {@link Testable4Throwing1}
         * @param route     the specified route definition
         * @param <I1>      the type of argument 1
         * @param <I2>      the type of argument 2
         * @param <I3>      the type of argument 3
         * @param <I4>      the type of argument 4
         * @return conditional route definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <I1, I2, I3, I4> $C option(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Testable4Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? extends E> predicate, RouteLevel2<? extends RuntimeException, ? extends Routing<? extends $R>> route);

        /**
         * Add the specified route conditional execution depending on the specified
         * values match using the specified {@link Testable4Throwing1}.
         *
         * @param value1    the specified argument value 1
         * @param value2    the specified argument value 2
         * @param value3    the specified argument value 3
         * @param value4    the specified argument value 4
         * @param predicate the specified {@link Testable4Throwing1}
         * @param route     the specified route definition
         * @param <I1>      the type of argument 1
         * @param <I2>      the type of argument 2
         * @param <I3>      the type of argument 3
         * @param <I4>      the type of argument 4
         * @return conditional route definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <I1, I2, I3, I4> $C option(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Testable4Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? extends E> predicate, RouteLevel3<E, ? extends Routing<? extends $R>> route);

        /**
         * Add the specified route conditional execution depending on the specified
         * values match using the specified {@link Testable5Throwing1}.
         *
         * @param value1    the specified argument value 1
         * @param value2    the specified argument value 2
         * @param value3    the specified argument value 3
         * @param value4    the specified argument value 4
         * @param value5    the specified argument value 5
         * @param predicate the specified {@link Testable5Throwing1}
         * @param route     the specified route definition
         * @param <I1>      the type of argument 1
         * @param <I2>      the type of argument 2
         * @param <I3>      the type of argument 3
         * @param <I4>      the type of argument 4
         * @param <I5>      the type of argument 5
         * @return conditional route definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <I1, I2, I3, I4, I5> $C option(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Testable5Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends E> predicate, Block<? extends Routing<? extends $R>> route);

        /**
         * Add the specified route conditional execution depending on the specified
         * values match using the specified {@link Testable5Throwing1}.
         *
         * @param value1    the specified argument value 1
         * @param value2    the specified argument value 2
         * @param value3    the specified argument value 3
         * @param value4    the specified argument value 4
         * @param value5    the specified argument value 5
         * @param predicate the specified {@link Testable5Throwing1}
         * @param route     the specified route definition
         * @param <I1>      the type of argument 1
         * @param <I2>      the type of argument 2
         * @param <I3>      the type of argument 3
         * @param <I4>      the type of argument 4
         * @param <I5>      the type of argument 5
         * @return conditional route definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <I1, I2, I3, I4, I5> $C option(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Testable5Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends E> predicate, RouteLevel1<? extends E, ? extends Routing<? extends $R>> route);

        /**
         * Add the specified route conditional execution depending on the specified
         * values match using the specified {@link Testable5Throwing1}.
         *
         * @param value1    the specified argument value 1
         * @param value2    the specified argument value 2
         * @param value3    the specified argument value 3
         * @param value4    the specified argument value 4
         * @param value5    the specified argument value 5
         * @param predicate the specified {@link Testable5Throwing1}
         * @param route     the specified route definition
         * @param <I1>      the type of argument 1
         * @param <I2>      the type of argument 2
         * @param <I3>      the type of argument 3
         * @param <I4>      the type of argument 4
         * @param <I5>      the type of argument 5
         * @return conditional route definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <I1, I2, I3, I4, I5> $C option(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Testable5Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends E> predicate, RouteLevel2<? extends RuntimeException, ? extends Routing<? extends $R>> route);

        /**
         * Add the specified route conditional execution depending on the specified
         * values match using the specified {@link Testable5Throwing1}.
         *
         * @param value1    the specified argument value 1
         * @param value2    the specified argument value 2
         * @param value3    the specified argument value 3
         * @param value4    the specified argument value 4
         * @param value5    the specified argument value 5
         * @param predicate the specified {@link Testable5Throwing1}
         * @param route     the specified route definition
         * @param <I1>      the type of argument 1
         * @param <I2>      the type of argument 2
         * @param <I3>      the type of argument 3
         * @param <I4>      the type of argument 4
         * @param <I5>      the type of argument 5
         * @return conditional route definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <I1, I2, I3, I4, I5> $C option(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Testable5Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends E> predicate, RouteLevel3<E, ? extends Routing<? extends $R>> route);

        /**
         * Add the specified route conditional execution depending on the specified
         * values match using the specified {@link Testable6Throwing1}.
         *
         * @param value1    the specified argument value 1
         * @param value2    the specified argument value 2
         * @param value3    the specified argument value 3
         * @param value4    the specified argument value 4
         * @param value5    the specified argument value 5
         * @param value6    the specified argument value 6
         * @param predicate the specified {@link Testable6Throwing1}
         * @param route     the specified route definition
         * @param <I1>      the type of argument 1
         * @param <I2>      the type of argument 2
         * @param <I3>      the type of argument 3
         * @param <I4>      the type of argument 4
         * @param <I5>      the type of argument 5
         * @param <I6>      the type of argument 6
         * @return conditional route definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <I1, I2, I3, I4, I5, I6> $C option(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Testable6Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends E> predicate, Block<? extends Routing<? extends $R>> route);

        /**
         * Add the specified route conditional execution depending on the specified
         * values match using the specified {@link Testable6Throwing1}.
         *
         * @param value1    the specified argument value 1
         * @param value2    the specified argument value 2
         * @param value3    the specified argument value 3
         * @param value4    the specified argument value 4
         * @param value5    the specified argument value 5
         * @param value6    the specified argument value 6
         * @param predicate the specified {@link Testable6Throwing1}
         * @param route     the specified route definition
         * @param <I1>      the type of argument 1
         * @param <I2>      the type of argument 2
         * @param <I3>      the type of argument 3
         * @param <I4>      the type of argument 4
         * @param <I5>      the type of argument 5
         * @param <I6>      the type of argument 6
         * @return conditional route definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <I1, I2, I3, I4, I5, I6> $C option(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Testable6Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends E> predicate, RouteLevel1<? extends E, ? extends Routing<? extends $R>> route);

        /**
         * Add the specified route conditional execution depending on the specified
         * values match using the specified {@link Testable6Throwing1}.
         *
         * @param value1    the specified argument value 1
         * @param value2    the specified argument value 2
         * @param value3    the specified argument value 3
         * @param value4    the specified argument value 4
         * @param value5    the specified argument value 5
         * @param value6    the specified argument value 6
         * @param predicate the specified {@link Testable6Throwing1}
         * @param route     the specified route definition
         * @param <I1>      the type of argument 1
         * @param <I2>      the type of argument 2
         * @param <I3>      the type of argument 3
         * @param <I4>      the type of argument 4
         * @param <I5>      the type of argument 5
         * @param <I6>      the type of argument 6
         * @return conditional route definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <I1, I2, I3, I4, I5, I6> $C option(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Testable6Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends E> predicate, RouteLevel2<? extends RuntimeException, ? extends Routing<? extends $R>> route);

        /**
         * Add the specified route conditional execution depending on the specified
         * values match using the specified {@link Testable6Throwing1}.
         *
         * @param value1    the specified argument value 1
         * @param value2    the specified argument value 2
         * @param value3    the specified argument value 3
         * @param value4    the specified argument value 4
         * @param value5    the specified argument value 5
         * @param value6    the specified argument value 6
         * @param predicate the specified {@link Testable6Throwing1}
         * @param route     the specified route definition
         * @param <I1>      the type of argument 1
         * @param <I2>      the type of argument 2
         * @param <I3>      the type of argument 3
         * @param <I4>      the type of argument 4
         * @param <I5>      the type of argument 5
         * @param <I6>      the type of argument 6
         * @return conditional route definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <I1, I2, I3, I4, I5, I6> $C option(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Testable6Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends E> predicate, RouteLevel3<E, ? extends Routing<? extends $R>> route);

        /**
         * Add the specified route conditional execution depending on the specified
         * values match using the specified {@link Testable7Throwing1}.
         *
         * @param value1    the specified argument value 1
         * @param value2    the specified argument value 2
         * @param value3    the specified argument value 3
         * @param value4    the specified argument value 4
         * @param value5    the specified argument value 5
         * @param value6    the specified argument value 6
         * @param value7    the specified argument value 7
         * @param predicate the specified {@link Testable7Throwing1}
         * @param route     the specified route definition
         * @param <I1>      the type of argument 1
         * @param <I2>      the type of argument 2
         * @param <I3>      the type of argument 3
         * @param <I4>      the type of argument 4
         * @param <I5>      the type of argument 5
         * @param <I6>      the type of argument 6
         * @param <I7>      the type of argument 7
         * @return conditional route definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <I1, I2, I3, I4, I5, I6, I7> $C option(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Testable7Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends E> predicate, Block<? extends Routing<? extends $R>> route);

        /**
         * Add the specified route conditional execution depending on the specified
         * values match using the specified {@link Testable7Throwing1}.
         *
         * @param value1    the specified argument value 1
         * @param value2    the specified argument value 2
         * @param value3    the specified argument value 3
         * @param value4    the specified argument value 4
         * @param value5    the specified argument value 5
         * @param value6    the specified argument value 6
         * @param value7    the specified argument value 7
         * @param predicate the specified {@link Testable7Throwing1}
         * @param route     the specified route definition
         * @param <I1>      the type of argument 1
         * @param <I2>      the type of argument 2
         * @param <I3>      the type of argument 3
         * @param <I4>      the type of argument 4
         * @param <I5>      the type of argument 5
         * @param <I6>      the type of argument 6
         * @param <I7>      the type of argument 7
         * @return conditional route definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <I1, I2, I3, I4, I5, I6, I7> $C option(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Testable7Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends E> predicate, RouteLevel1<? extends E, ? extends Routing<? extends $R>> route);

        /**
         * Add the specified route conditional execution depending on the specified
         * values match using the specified {@link Testable7Throwing1}.
         *
         * @param value1    the specified argument value 1
         * @param value2    the specified argument value 2
         * @param value3    the specified argument value 3
         * @param value4    the specified argument value 4
         * @param value5    the specified argument value 5
         * @param value6    the specified argument value 6
         * @param value7    the specified argument value 7
         * @param predicate the specified {@link Testable7Throwing1}
         * @param route     the specified route definition
         * @param <I1>      the type of argument 1
         * @param <I2>      the type of argument 2
         * @param <I3>      the type of argument 3
         * @param <I4>      the type of argument 4
         * @param <I5>      the type of argument 5
         * @param <I6>      the type of argument 6
         * @param <I7>      the type of argument 7
         * @return conditional route definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <I1, I2, I3, I4, I5, I6, I7> $C option(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Testable7Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends E> predicate, RouteLevel2<? extends RuntimeException, ? extends Routing<? extends $R>> route);

        /**
         * Add the specified route conditional execution depending on the specified
         * values match using the specified {@link Testable7Throwing1}.
         *
         * @param value1    the specified argument value 1
         * @param value2    the specified argument value 2
         * @param value3    the specified argument value 3
         * @param value4    the specified argument value 4
         * @param value5    the specified argument value 5
         * @param value6    the specified argument value 6
         * @param value7    the specified argument value 7
         * @param predicate the specified {@link Testable7Throwing1}
         * @param route     the specified route definition
         * @param <I1>      the type of argument 1
         * @param <I2>      the type of argument 2
         * @param <I3>      the type of argument 3
         * @param <I4>      the type of argument 4
         * @param <I5>      the type of argument 5
         * @param <I6>      the type of argument 6
         * @param <I7>      the type of argument 7
         * @return conditional route definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <I1, I2, I3, I4, I5, I6, I7> $C option(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Testable7Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends E> predicate, RouteLevel3<E, ? extends Routing<? extends $R>> route);

        /**
         * Add the specified route conditional execution depending on the specified
         * values match using the specified {@link Testable8Throwing1}.
         *
         * @param value1    the specified argument value 1
         * @param value2    the specified argument value 2
         * @param value3    the specified argument value 3
         * @param value4    the specified argument value 4
         * @param value5    the specified argument value 5
         * @param value6    the specified argument value 6
         * @param value7    the specified argument value 7
         * @param value8    the specified argument value 8
         * @param predicate the specified {@link Testable8Throwing1}
         * @param route     the specified route definition
         * @param <I1>      the type of argument 1
         * @param <I2>      the type of argument 2
         * @param <I3>      the type of argument 3
         * @param <I4>      the type of argument 4
         * @param <I5>      the type of argument 5
         * @param <I6>      the type of argument 6
         * @param <I7>      the type of argument 7
         * @param <I8>      the type of argument 8
         * @return conditional route definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <I1, I2, I3, I4, I5, I6, I7, I8> $C option(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8, Testable8Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends E> predicate, Block<? extends Routing<? extends $R>> route);

        /**
         * Add the specified route conditional execution depending on the specified
         * values match using the specified {@link Testable8Throwing1}.
         *
         * @param value1    the specified argument value 1
         * @param value2    the specified argument value 2
         * @param value3    the specified argument value 3
         * @param value4    the specified argument value 4
         * @param value5    the specified argument value 5
         * @param value6    the specified argument value 6
         * @param value7    the specified argument value 7
         * @param value8    the specified argument value 8
         * @param predicate the specified {@link Testable8Throwing1}
         * @param route     the specified route definition
         * @param <I1>      the type of argument 1
         * @param <I2>      the type of argument 2
         * @param <I3>      the type of argument 3
         * @param <I4>      the type of argument 4
         * @param <I5>      the type of argument 5
         * @param <I6>      the type of argument 6
         * @param <I7>      the type of argument 7
         * @param <I8>      the type of argument 8
         * @return conditional route definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <I1, I2, I3, I4, I5, I6, I7, I8> $C option(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8, Testable8Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends E> predicate, RouteLevel1<? extends E, ? extends Routing<? extends $R>> route);

        /**
         * Add the specified route conditional execution depending on the specified
         * values match using the specified {@link Testable8Throwing1}.
         *
         * @param value1    the specified argument value 1
         * @param value2    the specified argument value 2
         * @param value3    the specified argument value 3
         * @param value4    the specified argument value 4
         * @param value5    the specified argument value 5
         * @param value6    the specified argument value 6
         * @param value7    the specified argument value 7
         * @param value8    the specified argument value 8
         * @param predicate the specified {@link Testable8Throwing1}
         * @param route     the specified route definition
         * @param <I1>      the type of argument 1
         * @param <I2>      the type of argument 2
         * @param <I3>      the type of argument 3
         * @param <I4>      the type of argument 4
         * @param <I5>      the type of argument 5
         * @param <I6>      the type of argument 6
         * @param <I7>      the type of argument 7
         * @param <I8>      the type of argument 8
         * @return conditional route definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <I1, I2, I3, I4, I5, I6, I7, I8> $C option(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8, Testable8Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends E> predicate, RouteLevel2<? extends RuntimeException, ? extends Routing<? extends $R>> route);

        /**
         * Add the specified route conditional execution depending on the specified
         * values match using the specified {@link Testable8Throwing1}.
         *
         * @param value1    the specified argument value 1
         * @param value2    the specified argument value 2
         * @param value3    the specified argument value 3
         * @param value4    the specified argument value 4
         * @param value5    the specified argument value 5
         * @param value6    the specified argument value 6
         * @param value7    the specified argument value 7
         * @param value8    the specified argument value 8
         * @param predicate the specified {@link Testable8Throwing1}
         * @param route     the specified route definition
         * @param <I1>      the type of argument 1
         * @param <I2>      the type of argument 2
         * @param <I3>      the type of argument 3
         * @param <I4>      the type of argument 4
         * @param <I5>      the type of argument 5
         * @param <I6>      the type of argument 6
         * @param <I7>      the type of argument 7
         * @param <I8>      the type of argument 8
         * @return conditional route definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <I1, I2, I3, I4, I5, I6, I7, I8> $C option(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8, Testable8Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends E> predicate, RouteLevel3<E, ? extends Routing<? extends $R>> route);
    }

    /**
     * Action choice definition object.
     *
     * @param <$F> the type of the flow definition interface
     * @param <E>  the type of possible exception
     */
    interface ChoosingAction<$F extends Flow<?, E>, E extends Exception>
            extends Choosing<ChoosingAction<$F, E>, Flow<$F, E>, Flowing<?>, E>, Flow<$F, E> {
    }

    /**
     * Stream choice definition object.
     *
     * @param <V> the type of the emitting values
     * @param <E> the type of possible exception that might be thrown
     */
    interface ChoosingStream<V, E extends Exception>
            extends Choosing<ChoosingStream<V, E>, Emitting<V>, Emitting<? extends V>, E> {
    }
}
