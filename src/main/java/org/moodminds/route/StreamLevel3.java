package org.moodminds.route;

/**
 * Streaming route definition function by the {@link Flow} level 3.
 *
 * @param <V> the type of the emitting values
 * @param <E> the type of possible exception
 */
@FunctionalInterface
public interface StreamLevel3<V, E extends Exception>
        extends RouteLevel3<E, Emitting<? extends V>>, StreamLevel2<V, E> {}
