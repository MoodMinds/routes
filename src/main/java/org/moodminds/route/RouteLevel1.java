package org.moodminds.route;

/**
 * Route definition function by the {@link Flow} level 1.
 *
 * @param <E> the type of possible exception
 */
@FunctionalInterface
public interface RouteLevel1<E extends Exception, $R extends Routing<?>>
        extends RouteLevel0<E, $R> {}
