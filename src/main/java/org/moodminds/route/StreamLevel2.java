package org.moodminds.route;

/**
 * Streaming route definition function by the {@link Flow} level 2.
 *
 * @param <V> the type of the emitting values
 * @param <E> the type of possible exception
 */
@FunctionalInterface
public interface StreamLevel2<V, E extends Exception>
        extends RouteLevel2<E, Emitting<? extends V>>, StreamLevel1<V, E> {}
