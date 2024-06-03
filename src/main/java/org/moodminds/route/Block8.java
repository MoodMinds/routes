package org.moodminds.route;

/**
 * Route definition block by 8 argument values.
 *
 * @param <I1> the type of the input argument 1
 * @param <I2> the type of the input argument 2
 * @param <I3> the type of the input argument 3
 * @param <I4> the type of the input argument 4
 * @param <I5> the type of the input argument 5
 * @param <I6> the type of the input argument 6
 * @param <I7> the type of the input argument 7
 * @param <I8> the type of the input argument 8
 * @param <$R> the type of the route definition result
 */
@FunctionalInterface
public interface Block8<I1, I2, I3, I4, I5, I6, I7, I8, $R extends Routing<?>> {

    /**
     * Define the route block by the specified argument value.
     *
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param value7 the specified argument value 7
     * @param value8 the specified argument value 8
     * @return a route block definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    $R block(Value<I1> value1, Value<I2> value2, Value<I3> value3, Value<I4> value4, Value<I5> value5, Value<I6> value6, Value<I7> value7, Value<I8> value8);
}
