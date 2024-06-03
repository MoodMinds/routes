package org.moodminds.route;

/**
 * Streaming route definition function by the {@link Flow} level 1.
 *
 * @param <V> the type of the emitting values
 * @param <E> the type of possible exception
 */
@FunctionalInterface
public interface StreamLevel1<V, E extends Exception>
        extends RouteLevel1<E, Emitting<? extends V>> {}
