package org.moodminds.route;

/**
 * Action route definition function by the {@link Flow} level 3.
 *
 * @param <E> the type of possible exception
 */
@FunctionalInterface
public interface ActionLevel3<E extends Exception>
        extends RouteLevel3<E, Flowing<?>>, ActionLevel2<E> {}
