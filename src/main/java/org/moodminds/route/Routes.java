package org.moodminds.route;

import org.moodminds.emission.Emittable;

/**
 * Routes definitions' materialization interface.
 */
public interface Routes {

    /**
     * Materialize the specified streaming route and return the {@link Emittable} execution object.
     *
     * @param route the specified streaming route
     * @param <V>   the type of the emitting values
     * @param <E>   the type of possible exception that might be thrown
     * @return the {@link Emittable} execution object
     */
    <V, E extends Exception> Emittable<V, E> stream(Route<? super Flow<?, E>, ? extends Emitting<? extends V>> route);

    /**
     * Materialize the specified streaming route and return the {@link Emittable} execution object.
     *
     * @param thrown the specified possible exception type
     * @param route  the specified streaming route
     * @param <V>    the type of the emitting values
     * @param <E>    the type of possible exception that might be thrown
     * @return the {@link Emittable} execution object
     */
    <V, E extends Exception> Emittable<V, E> stream(Class<E> thrown, Route<? super Flow<?, E>, ? extends Emitting<? extends V>> route);

    /**
     * Materialize the specified action route and return the {@link Emittable} execution object.
     *
     * @param route the specified action route
     * @param <E>   the type of possible exception that might be thrown
     * @return the {@link Emittable} execution object
     */
    <E extends Exception> Emittable<Void, E> action(Route<? super Flow<?, E>, ? extends Flowing<?>> route);

    /**
     * Materialize the specified action route and return the {@link Emittable} execution object.
     *
     * @param thrown the specified possible exception type
     * @param route  the specified action route
     * @param <E>    the type of possible exception that might be thrown
     * @return the {@link Emittable} execution object
     */
    <E extends Exception> Emittable<Void, E> action(Class<E> thrown, Route<? super Flow<?, E>, ? extends Flowing<?>> route);

    /**
     * Materialize the specified streaming route with the given value and return the {@link Emittable} execution object.
     *
     * @param route the specified streaming route
     * @param value the specified argument value
     * @param <I>   the type of the specified argument value
     * @param <V>   the type of the emitting values
     * @param <E>   the type of possible exception that might be thrown
     * @return the {@link Emittable} execution object
     */
    <I, V, E extends Exception> Emittable<V, E> stream(Route1<? super Flow<?, E>, I, ? extends Emitting<? extends V>> route, I value);

    /**
     * Materialize the specified streaming route with the given value and return the {@link Emittable} execution object.
     *
     * @param thrown the specified possible exception type
     * @param route the specified streaming route
     * @param value the specified argument value
     * @param <I>   the type of the specified argument value
     * @param <V>   the type of the emitting values
     * @param <E>   the type of possible exception that might be thrown
     * @return the {@link Emittable} execution object
     */
    <I, V, E extends Exception> Emittable<V, E> stream(Class<E> thrown, Route1<? super Flow<?, E>, I, ? extends Emitting<? extends V>> route, I value);

    /**
     * Materialize the specified action route with the given value and return the {@link Emittable} execution object.
     *
     * @param route the specified action route
     * @param value the specified argument value
     * @param <I>   the type of the specified argument value
     * @param <E>   the type of possible exception that might be thrown
     * @return the {@link Emittable} execution object
     */
    <I, E extends Exception> Emittable<Void, E> action(Route1<? super Flow<?, E>, I, ? extends Flowing<?>> route, I value);

    /**
     * Materialize the specified action route with the given value and return the {@link Emittable} execution object.
     *
     * @param thrown the specified possible exception type
     * @param route the specified action route
     * @param value the specified argument value
     * @param <I>   the type of the specified argument value
     * @param <E>   the type of possible exception that might be thrown
     * @return the {@link Emittable} execution object
     */
    <I, E extends Exception> Emittable<Void, E> action(Class<E> thrown, Route1<? super Flow<?, E>, I, ? extends Flowing<?>> route, I value);

    /**
     * Materialize the specified streaming route with the given values and return the {@link Emittable} execution object.
     *
     * @param route  the specified streaming route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 1
     * @param <I1>   the type of the specified argument value 1
     * @param <I2>   the type of the specified argument value 1
     * @param <V>    the type of the emitting values
     * @param <E>    the type of possible exception that might be thrown
     * @return the {@link Emittable} execution object
     */
    <I1, I2, V, E extends Exception> Emittable<V, E> stream(Route2<? super Flow<?, E>, I1, I2, ? extends Emitting<? extends V>> route, I1 value1, I2 value2);
    
    /**
     * Materialize the specified streaming route with the given values and return the {@link Emittable} execution object.
     *
     * @param thrown the specified possible exception type
     * @param route  the specified streaming route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 1
     * @param <I1>   the type of the specified argument value 1
     * @param <I2>   the type of the specified argument value 1
     * @param <V>    the type of the emitting values
     * @param <E>    the type of possible exception that might be thrown
     * @return the {@link Emittable} execution object
     */
    <I1, I2, V, E extends Exception> Emittable<V, E> stream(Class<E> thrown, Route2<? super Flow<?, E>, I1, I2, ? extends Emitting<? extends V>> route, I1 value1, I2 value2);

    /**
     * Materialize the specified action route with the given value and return the {@link Emittable} execution object.
     *
     * @param route  the specified action route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param <I1>   the type of the specified argument value 1
     * @param <I2>   the type of the specified argument value 2
     * @param <E>    the type of possible exception that might be thrown
     * @return the {@link Emittable} execution object
     */
    <I1, I2, E extends Exception> Emittable<Void, E> action(Route2<? super Flow<?, E>, I1, I2, ? extends Flowing<?>> route, I1 value1, I2 value2);
    
    /**
     * Materialize the specified action route with the given value and return the {@link Emittable} execution object.
     *
     * @param thrown the specified possible exception type
     * @param route  the specified action route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param <I1>   the type of the specified argument value 1
     * @param <I2>   the type of the specified argument value 2
     * @param <E>    the type of possible exception that might be thrown
     * @return the {@link Emittable} execution object
     */
    <I1, I2, E extends Exception> Emittable<Void, E> action(Class<E> thrown, Route2<? super Flow<?, E>, I1, I2, ? extends Flowing<?>> route, I1 value1, I2 value2);

    /**
     * Materialize the specified streaming route with the given values and return the {@link Emittable} execution object.
     *
     * @param route  the specified streaming route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param <I1>   the type of the specified argument value 1
     * @param <I2>   the type of the specified argument value 2
     * @param <I3>   the type of the specified argument value 3
     * @param <V>    the type of the emitting values
     * @param <E>    the type of possible exception that might be thrown
     * @return the {@link Emittable} execution object
     */
    <I1, I2, I3, V, E extends Exception> Emittable<V, E> stream(Route3<? super Flow<?, E>, I1, I2, I3, ? extends Emitting<? extends V>> route, I1 value1, I2 value2, I3 value3);
    
    /**
     * Materialize the specified streaming route with the given values and return the {@link Emittable} execution object.
     *
     * @param thrown the specified possible exception type
     * @param route  the specified streaming route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param <I1>   the type of the specified argument value 1
     * @param <I2>   the type of the specified argument value 2
     * @param <I3>   the type of the specified argument value 3
     * @param <V>    the type of the emitting values
     * @param <E>    the type of possible exception that might be thrown
     * @return the {@link Emittable} execution object
     */
    <I1, I2, I3, V, E extends Exception> Emittable<V, E> stream(Class<E> thrown, Route3<? super Flow<?, E>, I1, I2, I3, ? extends Emitting<? extends V>> route, I1 value1, I2 value2, I3 value3);

    /**
     * Materialize the specified action route with the given values and return the {@link Emittable} execution object.
     *
     * @param route  the specified action route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param <I1>   the type of the specified argument value 1
     * @param <I2>   the type of the specified argument value 2
     * @param <I3>   the type of the specified argument value 3
     * @param <E>    the type of possible exception that might be thrown
     * @return the {@link Emittable} execution object
     */
    <I1, I2, I3, E extends Exception> Emittable<Void, E> action(Route3<? super Flow<?, E>, I1, I2, I3, ? extends Flowing<?>> route, I1 value1, I2 value2, I3 value3);

    /**
     * Materialize the specified action route with the given values and return the {@link Emittable} execution object.
     *
     * @param thrown the specified possible exception type
     * @param route  the specified action route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param <I1>   the type of the specified argument value 1
     * @param <I2>   the type of the specified argument value 2
     * @param <I3>   the type of the specified argument value 3
     * @param <E>    the type of possible exception that might be thrown
     * @return the {@link Emittable} execution object
     */
    <I1, I2, I3, E extends Exception> Emittable<Void, E> action(Class<E> thrown, Route3<? super Flow<?, E>, I1, I2, I3, ? extends Flowing<?>> route, I1 value1, I2 value2, I3 value3);

    /**
     * Materialize the specified streaming route with the given values and return the {@link Emittable} execution object.
     *
     * @param route  the specified streaming route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param <I1>   the type of the specified argument value 1
     * @param <I2>   the type of the specified argument value 2
     * @param <I3>   the type of the specified argument value 3
     * @param <I4>   the type of the specified argument value 4
     * @param <V>    the type of the emitting values
     * @param <E>    the type of possible exception that might be thrown
     * @return the {@link Emittable} execution object
     */
    <I1, I2, I3, I4, V, E extends Exception> Emittable<V, E> stream(Route4<? super Flow<?, E>, I1, I2, I3, I4, ? extends Emitting<? extends V>> route, I1 value1, I2 value2, I3 value3, I4 value4);

    /**
     * Materialize the specified streaming route with the given values and return the {@link Emittable} execution object.
     *
     * @param thrown the specified possible exception type
     * @param route  the specified streaming route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param <I1>   the type of the specified argument value 1
     * @param <I2>   the type of the specified argument value 2
     * @param <I3>   the type of the specified argument value 3
     * @param <I4>   the type of the specified argument value 4
     * @param <V>    the type of the emitting values
     * @param <E>    the type of possible exception that might be thrown
     * @return the {@link Emittable} execution object
     */
    <I1, I2, I3, I4, V, E extends Exception> Emittable<V, E> stream(Class<E> thrown, Route4<? super Flow<?, E>, I1, I2, I3, I4, ? extends Emitting<? extends V>> route, I1 value1, I2 value2, I3 value3, I4 value4);

    /**
     * Materialize the specified action route with the given values and return the {@link Emittable} execution object.
     *
     * @param route  the specified action route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param <I1>   the type of the specified argument value 1
     * @param <I2>   the type of the specified argument value 2
     * @param <I3>   the type of the specified argument value 3
     * @param <I4>   the type of the specified argument value 4
     * @param <E>    the type of possible exception that might be thrown
     * @return the {@link Emittable} execution object
     */
    <I1, I2, I3, I4, E extends Exception> Emittable<Void, E> action(Route4<? super Flow<?, E>, I1, I2, I3, I4, ? extends Flowing<?>> route, I1 value1, I2 value2, I3 value3, I4 value4);
    
    /**
     * Materialize the specified action route with the given values and return the {@link Emittable} execution object.
     *
     * @param thrown the specified possible exception type
     * @param route  the specified action route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param <I1>   the type of the specified argument value 1
     * @param <I2>   the type of the specified argument value 2
     * @param <I3>   the type of the specified argument value 3
     * @param <I4>   the type of the specified argument value 4
     * @param <E>    the type of possible exception that might be thrown
     * @return the {@link Emittable} execution object
     */
    <I1, I2, I3, I4, E extends Exception> Emittable<Void, E> action(Class<E> thrown, Route4<? super Flow<?, E>, I1, I2, I3, I4, ? extends Flowing<?>> route, I1 value1, I2 value2, I3 value3, I4 value4);

    /**
     * Materialize the specified streaming route with the given values and return the {@link Emittable} execution object.
     *
     * @param route  the specified streaming route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param <I1>   the type of the specified argument value 1
     * @param <I2>   the type of the specified argument value 2
     * @param <I3>   the type of the specified argument value 3
     * @param <I4>   the type of the specified argument value 4
     * @param <I5>   the type of the specified argument value 5
     * @param <V>    the type of the emitting values
     * @param <E>    the type of possible exception that might be thrown
     * @return the {@link Emittable} execution object
     */
    <I1, I2, I3, I4, I5, V, E extends Exception> Emittable<V, E> stream(Route5<? super Flow<?, E>, I1, I2, I3, I4, I5, ? extends Emitting<? extends V>> route, I1 value1, I2 value2, I3 value3, I4 value4, I5 value5);
    
    /**
     * Materialize the specified streaming route with the given values and return the {@link Emittable} execution object.
     *
     * @param thrown the specified possible exception type
     * @param route  the specified streaming route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param <I1>   the type of the specified argument value 1
     * @param <I2>   the type of the specified argument value 2
     * @param <I3>   the type of the specified argument value 3
     * @param <I4>   the type of the specified argument value 4
     * @param <I5>   the type of the specified argument value 5
     * @param <V>    the type of the emitting values
     * @param <E>    the type of possible exception that might be thrown
     * @return the {@link Emittable} execution object
     */
    <I1, I2, I3, I4, I5, V, E extends Exception> Emittable<V, E> stream(Class<E> thrown, Route5<? super Flow<?, E>, I1, I2, I3, I4, I5, ? extends Emitting<? extends V>> route, I1 value1, I2 value2, I3 value3, I4 value4, I5 value5);

    /**
     * Materialize the specified action route with the given values and return the {@link Emittable} execution object.
     *
     * @param route  the specified action route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param <I1>   the type of the specified argument value 1
     * @param <I2>   the type of the specified argument value 2
     * @param <I3>   the type of the specified argument value 3
     * @param <I4>   the type of the specified argument value 4
     * @param <I5>   the type of the specified argument value 5
     * @param <E>    the type of possible exception that might be thrown
     * @return the {@link Emittable} execution object
     */
    <I1, I2, I3, I4, I5, E extends Exception> Emittable<Void, E> action(Route5<? super Flow<?, E>, I1, I2, I3, I4, I5, ? extends Flowing<?>> route, I1 value1, I2 value2, I3 value3, I4 value4, I5 value5);
    
    /**
     * Materialize the specified action route with the given values and return the {@link Emittable} execution object.
     *
     * @param thrown the specified possible exception type
     * @param route  the specified action route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param <I1>   the type of the specified argument value 1
     * @param <I2>   the type of the specified argument value 2
     * @param <I3>   the type of the specified argument value 3
     * @param <I4>   the type of the specified argument value 4
     * @param <I5>   the type of the specified argument value 5
     * @param <E>    the type of possible exception that might be thrown
     * @return the {@link Emittable} execution object
     */
    <I1, I2, I3, I4, I5, E extends Exception> Emittable<Void, E> action(Class<E> thrown, Route5<? super Flow<?, E>, I1, I2, I3, I4, I5, ? extends Flowing<?>> route, I1 value1, I2 value2, I3 value3, I4 value4, I5 value5);

    /**
     * Materialize the specified streaming route with the given values and return the {@link Emittable} execution object.
     *
     * @param route  the specified streaming route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param <I1>   the type of the specified argument value 1
     * @param <I2>   the type of the specified argument value 2
     * @param <I3>   the type of the specified argument value 3
     * @param <I4>   the type of the specified argument value 4
     * @param <I5>   the type of the specified argument value 5
     * @param <I6>   the type of the specified argument value 6
     * @param <V>    the type of the emitting values
     * @param <E>    the type of possible exception that might be thrown
     * @return the {@link Emittable} execution object
     */
    <I1, I2, I3, I4, I5, I6, V, E extends Exception> Emittable<V, E> stream(Route6<? super Flow<?, E>, I1, I2, I3, I4, I5, I6, ? extends Emitting<? extends V>> route, I1 value1, I2 value2, I3 value3, I4 value4, I5 value5, I6 value6);
    
    /**
     * Materialize the specified streaming route with the given values and return the {@link Emittable} execution object.
     *
     * @param thrown the specified possible exception type
     * @param route  the specified streaming route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param <I1>   the type of the specified argument value 1
     * @param <I2>   the type of the specified argument value 2
     * @param <I3>   the type of the specified argument value 3
     * @param <I4>   the type of the specified argument value 4
     * @param <I5>   the type of the specified argument value 5
     * @param <I6>   the type of the specified argument value 6
     * @param <V>    the type of the emitting values
     * @param <E>    the type of possible exception that might be thrown
     * @return the {@link Emittable} execution object
     */
    <I1, I2, I3, I4, I5, I6, V, E extends Exception> Emittable<V, E> stream(Class<E> thrown, Route6<? super Flow<?, E>, I1, I2, I3, I4, I5, I6, ? extends Emitting<? extends V>> route, I1 value1, I2 value2, I3 value3, I4 value4, I5 value5, I6 value6);

    /**
     * Materialize the specified action route with the given values and return the {@link Emittable} execution object.
     *
     * @param route  the specified action route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param <I1>   the type of the specified argument value 1
     * @param <I2>   the type of the specified argument value 2
     * @param <I3>   the type of the specified argument value 3
     * @param <I4>   the type of the specified argument value 4
     * @param <I5>   the type of the specified argument value 5
     * @param <I6>   the type of the specified argument value 6
     * @param <E>    the type of possible exception that might be thrown
     * @return the {@link Emittable} execution object
     */
    <I1, I2, I3, I4, I5, I6, E extends Exception> Emittable<Void, E> action(Route6<? super Flow<?, E>, I1, I2, I3, I4, I5, I6, ? extends Flowing<?>> route, I1 value1, I2 value2, I3 value3, I4 value4, I5 value5, I6 value6);
    
    /**
     * Materialize the specified action route with the given values and return the {@link Emittable} execution object.
     *
     * @param thrown the specified possible exception type
     * @param route  the specified action route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param <I1>   the type of the specified argument value 1
     * @param <I2>   the type of the specified argument value 2
     * @param <I3>   the type of the specified argument value 3
     * @param <I4>   the type of the specified argument value 4
     * @param <I5>   the type of the specified argument value 5
     * @param <I6>   the type of the specified argument value 6
     * @param <E>    the type of possible exception that might be thrown
     * @return the {@link Emittable} execution object
     */
    <I1, I2, I3, I4, I5, I6, E extends Exception> Emittable<Void, E> action(Class<E> thrown, Route6<? super Flow<?, E>, I1, I2, I3, I4, I5, I6, ? extends Flowing<?>> route, I1 value1, I2 value2, I3 value3, I4 value4, I5 value5, I6 value6);

    /**
     * Materialize the specified streaming route with the given values and return the {@link Emittable} execution object.
     *
     * @param route  the specified streaming route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param value7 the specified argument value 7
     * @param <I1>   the type of the specified argument value 1
     * @param <I2>   the type of the specified argument value 2
     * @param <I3>   the type of the specified argument value 3
     * @param <I4>   the type of the specified argument value 4
     * @param <I5>   the type of the specified argument value 5
     * @param <I6>   the type of the specified argument value 6
     * @param <I7>   the type of the specified argument value 7
     * @param <V>    the type of the emitting values
     * @param <E>    the type of possible exception that might be thrown
     * @return the {@link Emittable} execution object
     */
    <I1, I2, I3, I4, I5, I6, I7, V, E extends Exception> Emittable<V, E> stream(Route7<? super Flow<?, E>, I1, I2, I3, I4, I5, I6, I7, ? extends Emitting<? extends V>> route, I1 value1, I2 value2, I3 value3, I4 value4, I5 value5, I6 value6, I7 value7);
    
    /**
     * Materialize the specified streaming route with the given values and return the {@link Emittable} execution object.
     *
     * @param thrown the specified possible exception type
     * @param route  the specified streaming route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param value7 the specified argument value 7
     * @param <I1>   the type of the specified argument value 1
     * @param <I2>   the type of the specified argument value 2
     * @param <I3>   the type of the specified argument value 3
     * @param <I4>   the type of the specified argument value 4
     * @param <I5>   the type of the specified argument value 5
     * @param <I6>   the type of the specified argument value 6
     * @param <I7>   the type of the specified argument value 7
     * @param <V>    the type of the emitting values
     * @param <E>    the type of possible exception that might be thrown
     * @return the {@link Emittable} execution object
     */
    <I1, I2, I3, I4, I5, I6, I7, V, E extends Exception> Emittable<V, E> stream(Class<E> thrown, Route7<? super Flow<?, E>, I1, I2, I3, I4, I5, I6, I7, ? extends Emitting<? extends V>> route, I1 value1, I2 value2, I3 value3, I4 value4, I5 value5, I6 value6, I7 value7);

    /**
     * Materialize the specified action route with the given values and return the {@link Emittable} execution object.
     *
     * @param route  the specified action route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param value7 the specified argument value 7
     * @param <I1>   the type of the specified argument value 1
     * @param <I2>   the type of the specified argument value 2
     * @param <I3>   the type of the specified argument value 3
     * @param <I4>   the type of the specified argument value 4
     * @param <I5>   the type of the specified argument value 5
     * @param <I6>   the type of the specified argument value 6
     * @param <I7>   the type of the specified argument value 7
     * @param <E>    the type of possible exception that might be thrown
     * @return the {@link Emittable} execution object
     */
    <I1, I2, I3, I4, I5, I6, I7, E extends Exception> Emittable<Void, E> action(Route7<? super Flow<?, E>, I1, I2, I3, I4, I5, I6, I7, ? extends Flowing<?>> route, I1 value1, I2 value2, I3 value3, I4 value4, I5 value5, I6 value6, I7 value7);
    
    /**
     * Materialize the specified action route with the given values and return the {@link Emittable} execution object.
     *
     * @param thrown the specified possible exception type
     * @param route  the specified action route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param value7 the specified argument value 7
     * @param <I1>   the type of the specified argument value 1
     * @param <I2>   the type of the specified argument value 2
     * @param <I3>   the type of the specified argument value 3
     * @param <I4>   the type of the specified argument value 4
     * @param <I5>   the type of the specified argument value 5
     * @param <I6>   the type of the specified argument value 6
     * @param <I7>   the type of the specified argument value 7
     * @param <E>    the type of possible exception that might be thrown
     * @return the {@link Emittable} execution object
     */
    <I1, I2, I3, I4, I5, I6, I7, E extends Exception> Emittable<Void, E> action(Class<E> thrown, Route7<? super Flow<?, E>, I1, I2, I3, I4, I5, I6, I7, ? extends Flowing<?>> route, I1 value1, I2 value2, I3 value3, I4 value4, I5 value5, I6 value6, I7 value7);

    /**
     * Materialize the specified streaming route with the given values and return the {@link Emittable} execution object.
     *
     * @param route  the specified streaming route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param value7 the specified argument value 7
     * @param value8 the specified argument value 8
     * @param <I1>   the type of the specified argument value 1
     * @param <I2>   the type of the specified argument value 2
     * @param <I3>   the type of the specified argument value 3
     * @param <I4>   the type of the specified argument value 4
     * @param <I5>   the type of the specified argument value 5
     * @param <I6>   the type of the specified argument value 6
     * @param <I7>   the type of the specified argument value 7
     * @param <I8>   the type of the specified argument value 8
     * @param <V>    the type of the emitting values
     * @param <E>    the type of possible exception that might be thrown
     * @return the {@link Emittable} execution object
     */
    <I1, I2, I3, I4, I5, I6, I7, I8, V, E extends Exception> Emittable<V, E> stream(Route8<? super Flow<?, E>, I1, I2, I3, I4, I5, I6, I7, I8, ? extends Emitting<? extends V>> route, I1 value1, I2 value2, I3 value3, I4 value4, I5 value5, I6 value6, I7 value7, I8 value8);
    
    /**
     * Materialize the specified streaming route with the given values and return the {@link Emittable} execution object.
     *
     * @param thrown the specified possible exception type
     * @param route  the specified streaming route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param value7 the specified argument value 7
     * @param value8 the specified argument value 8
     * @param <I1>   the type of the specified argument value 1
     * @param <I2>   the type of the specified argument value 2
     * @param <I3>   the type of the specified argument value 3
     * @param <I4>   the type of the specified argument value 4
     * @param <I5>   the type of the specified argument value 5
     * @param <I6>   the type of the specified argument value 6
     * @param <I7>   the type of the specified argument value 7
     * @param <I8>   the type of the specified argument value 8
     * @param <V>    the type of the emitting values
     * @param <E>    the type of possible exception that might be thrown
     * @return the {@link Emittable} execution object
     */
    <I1, I2, I3, I4, I5, I6, I7, I8, V, E extends Exception> Emittable<V, E> stream(Class<E> thrown, Route8<? super Flow<?, E>, I1, I2, I3, I4, I5, I6, I7, I8, ? extends Emitting<? extends V>> route, I1 value1, I2 value2, I3 value3, I4 value4, I5 value5, I6 value6, I7 value7, I8 value8);

    /**
     * Materialize the specified action route with the given values and return the {@link Emittable} execution object.
     *
     * @param route  the specified action route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param value7 the specified argument value 7
     * @param value8 the specified argument value 8
     * @param <I1>   the type of the specified argument value 1
     * @param <I2>   the type of the specified argument value 2
     * @param <I3>   the type of the specified argument value 3
     * @param <I4>   the type of the specified argument value 4
     * @param <I5>   the type of the specified argument value 5
     * @param <I6>   the type of the specified argument value 6
     * @param <I7>   the type of the specified argument value 7
     * @param <I8>   the type of the specified argument value 8
     * @param <E>    the type of possible exception that might be thrown
     * @return the {@link Emittable} execution object
     */
    <I1, I2, I3, I4, I5, I6, I7, I8, E extends Exception> Emittable<Void, E> action(Route8<? super Flow<?, E>, I1, I2, I3, I4, I5, I6, I7, I8, ? extends Flowing<?>> route, I1 value1, I2 value2, I3 value3, I4 value4, I5 value5, I6 value6, I7 value7, I8 value8);
    
    /**
     * Materialize the specified action route with the given values and return the {@link Emittable} execution object.
     *
     * @param thrown the specified possible exception type
     * @param route  the specified action route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param value7 the specified argument value 7
     * @param value8 the specified argument value 8
     * @param <I1>   the type of the specified argument value 1
     * @param <I2>   the type of the specified argument value 2
     * @param <I3>   the type of the specified argument value 3
     * @param <I4>   the type of the specified argument value 4
     * @param <I5>   the type of the specified argument value 5
     * @param <I6>   the type of the specified argument value 6
     * @param <I7>   the type of the specified argument value 7
     * @param <I8>   the type of the specified argument value 8
     * @param <E>    the type of possible exception that might be thrown
     * @return the {@link Emittable} execution object
     */
    <I1, I2, I3, I4, I5, I6, I7, I8, E extends Exception> Emittable<Void, E> action(Class<E> thrown, Route8<? super Flow<?, E>, I1, I2, I3, I4, I5, I6, I7, I8, ? extends Flowing<?>> route, I1 value1, I2 value2, I3 value3, I4 value4, I5 value5, I6 value6, I7 value7, I8 value8);
}
