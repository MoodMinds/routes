package org.moodminds.route;

/**
 * Action route definition function by the {@link Flow}.
 *
 * @param <E> the type of possible exception
 */
@FunctionalInterface
public interface Action<E extends Exception>
        extends RouteLevel3<E, Flowing<?>> {}
