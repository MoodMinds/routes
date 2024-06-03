package org.moodminds.route;

/**
 * Route definition function by the {@link Flow} and argument value which returns the routing result.
 *
 * @param <$F> the type of the flow definition interface
 * @param <I> the type of the input argument
 * @param <$R> the type of the route definition result
 */
@FunctionalInterface
public interface Route1<$F extends Flow<?, ?>, I, $R extends Routing<?>> {

    /**
     * Define the route by the specified flow definition object and argument value.
     *
     * @param flow the specified flow definition object
     * @param value the specified argument value
     * @return a route definition result by the flow definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    $R route($F flow, Value<I> value);
}
