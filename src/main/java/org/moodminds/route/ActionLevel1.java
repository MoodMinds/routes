package org.moodminds.route;

/**
 * Action route definition function by the {@link Flow} level 1.
 *
 * @param <E> the type of possible exception
 */
@FunctionalInterface
public interface ActionLevel1<E extends Exception>
        extends RouteLevel1<E, Flowing<?>> {}
