package org.moodminds.route;

/**
 * Route definition function by the {@link Flow} and 2 argument values which returns the routing result.
 *
 * @param <$F> the type of the flow definition interface
 * @param <I1> the type of the input argument 1
 * @param <I2> the type of the input argument 2
 * @param <$R> the type of the route definition result
 */
@FunctionalInterface
public interface Route2<$F extends Flow<?, ?>, I1, I2, $R extends Routing<?>> {

    /**
     * Define the route by the specified flow definition object and argument values.
     *
     * @param flow the specified flow definition object
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @return a route definition result by the flow definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    $R route($F flow, Value<I1> value1, Value<I2> value2);
}
