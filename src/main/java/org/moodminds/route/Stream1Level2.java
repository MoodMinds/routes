package org.moodminds.route;

/**
 * Streaming route definition function by the {@link Flow} and argument value level 2.
 *
 * @param <I> the type of the input argument
 * @param <V> the type of the emitting values
 * @param <E> the type of possible exception
 */
@FunctionalInterface
public interface Stream1Level2<I, V, E extends Exception>
        extends Route1Level2<I, E, Emitting<? extends V>>, Stream1Level1<I, V, E> {}
