package org.moodminds.route;

/**
 * Streaming route definition function by the {@link Flow} and argument value.
 *
 * @param <I> the type of the input argument
 * @param <V> the type of the emitting values
 * @param <E> the type of possible exception
 */
@FunctionalInterface
public interface Stream1<I, V, E extends Exception>
        extends Stream1Level3<I, V, E> {}
