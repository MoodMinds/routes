package org.moodminds.route;

/**
 * Streaming route definition function by the {@link Flow} and 3 argument values.
 *
 * @param <I1> the type of the input argument 1
 * @param <I2> the type of the input argument 2
 * @param <I3> the type of the input argument 3
 * @param <V>  the type of the emitting values
 * @param <E>  the type of possible exception
 */
@FunctionalInterface
public interface Stream3<I1, I2, I3, V, E extends Exception>
        extends Stream3Level3<I1, I2, I3, V, E> {}
