package org.moodminds.route;

/**
 * Streaming route definition function by the {@link Flow} and argument values.
 *
 * @param <I1> the type of the input argument 1
 * @param <I2> the type of the input argument 2
 * @param <V> the type of the emitting values
 * @param <E> the type of possible exception
 */
@FunctionalInterface
public interface Stream2<I1, I2, V, E extends Exception>
        extends Route2Level3<I1, I2, E, Emitting<? extends V>> {}
