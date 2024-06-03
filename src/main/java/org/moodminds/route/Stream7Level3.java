package org.moodminds.route;

/**
 * Streaming route definition function by the {@link Flow} and 7 argument values level 3.
 *
 * @param <I1> the type of the input argument 1
 * @param <I2> the type of the input argument 2
 * @param <I3> the type of the input argument 3
 * @param <I4> the type of the input argument 4
 * @param <I5> the type of the input argument 5
 * @param <I6> the type of the input argument 6
 * @param <I7> the type of the input argument 7
 * @param <V>  the type of the emitting values
 * @param <E>  the type of possible exception
 */
@FunctionalInterface
public interface Stream7Level3<I1, I2, I3, I4, I5, I6, I7, V, E extends Exception>
        extends Route7Level3<I1, I2, I3, I4, I5, I6, I7, E, Emitting<? extends V>>, Stream7Level2<I1, I2, I3, I4, I5, I6, I7, V, E> {}
