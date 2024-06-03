package org.moodminds.route;

/**
 * Streaming route definition function by the {@link Flow}.
 *
 * @param <V> the type of the emitting values
 * @param <E> the type of possible exception
 */
@FunctionalInterface
public interface Stream<V, E extends Exception>
        extends StreamLevel3<V, E> {}
