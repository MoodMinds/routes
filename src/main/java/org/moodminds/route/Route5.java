package org.moodminds.route;

/**
 * Route definition function by the {@link Flow} and 5 argument values which returns the routing result.
 *
 * @param <$F> the type of the flow definition interface
 * @param <I1> the type of the input argument 1
 * @param <I2> the type of the input argument 2
 * @param <I3> the type of the input argument 3
 * @param <I4> the type of the input argument 4
 * @param <I5> the type of the input argument 5
 * @param <$R> the type of the route definition result
 */
@FunctionalInterface
public interface Route5<$F extends Flow<?, ?>, I1, I2, I3, I4, I5, $R extends Routing<?>> {

    /**
     * Define the route by the specified flow definition object and argument values.
     *
     * @param flow   the specified flow definition object
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @return a route definition result by the flow definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    $R route($F flow, Value<I1> value1, Value<I2> value2, Value<I3> value3, Value<I4> value4, Value<I5> value5);
}
