package org.moodminds.route;

/**
 * Route definition function by the {@link Flow} level 3.
 *
 * @param <E> the type of possible exception
 */
@FunctionalInterface
public interface RouteLevel3<E extends Exception, $R extends Routing<?>>
        extends RouteLevel2<E, $R> {}
