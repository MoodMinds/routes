package org.moodminds.route;

/**
 * Action route definition function by the {@link Flow} level 2.
 *
 * @param <E> the type of possible exception
 */
@FunctionalInterface
public interface ActionLevel2<E extends Exception>
        extends RouteLevel2<E, Flowing<?>>, ActionLevel1<E> {}
