package org.moodminds.route;

/**
 * Route definition function by the {@link Flow} level 2.
 *
 * @param <E> the type of possible exception
 */
@FunctionalInterface
public interface RouteLevel2<E extends Exception, $R extends Routing<?>>
        extends RouteLevel1<E, $R> {}
