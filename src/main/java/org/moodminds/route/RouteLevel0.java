package org.moodminds.route;

/**
 * Route definition function by the {@link Flow} level 0.
 *
 * @param <E> the type of possible exception
 */
@FunctionalInterface
public interface RouteLevel0<E extends Exception, $R extends Routing<?>>
        extends Route<Flow<?, E>, $R> {}
