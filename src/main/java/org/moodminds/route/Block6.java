package org.moodminds.route;

/**
 * Route definition block by 6 argument values.
 *
 * @param <I1> the type of the input argument 1
 * @param <I2> the type of the input argument 2
 * @param <I3> the type of the input argument 3
 * @param <I4> the type of the input argument 4
 * @param <I5> the type of the input argument 5
 * @param <I6> the type of the input argument 6
 * @param <$R> the type of the route definition result
 */
@FunctionalInterface
public interface Block6<I1, I2, I3, I4, I5, I6, $R extends Routing<?>> {

    /**
     * Define the route block by the specified argument value.
     *
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @return a route block definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    $R block(Value<I1> value1, Value<I2> value2, Value<I3> value3, Value<I4> value4, Value<I5> value5, Value<I6> value6);
}
