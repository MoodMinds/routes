package org.moodminds.route;

/**
 * Route definition function by the {@link Flow} which returns the routing result.
 *
 * @param <$F> the type of the flow definition interface
 * @param <$R> the type of the route definition result
 */
@FunctionalInterface
public interface Route<$F extends Flow<?, ?>, $R extends Routing<?>> {

    /**
     * Define the route by the specified flow definition object.
     *
     * @param flow the specified flow definition object
     * @return a route definition result by the flow definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    $R route($F flow);
}
