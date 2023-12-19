package org.moodminds.route;

/**
 * Route definition block.
 *
 * @param <$R> the type of the route definition result
 */
@FunctionalInterface
public interface Block<$R extends Routing<?>> {

    /**
     * Define the route block.
     *
     * @return a route block definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    $R block();
}
