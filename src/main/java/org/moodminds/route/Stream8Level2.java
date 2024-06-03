package org.moodminds.route;

/**
 * Streaming route definition function by the {@link Flow} and 8 argument values level 2.
 *
 * @param <I1> the type of the input argument 1
 * @param <I2> the type of the input argument 2
 * @param <I3> the type of the input argument 3
 * @param <I4> the type of the input argument 4
 * @param <I5> the type of the input argument 5
 * @param <I6> the type of the input argument 6
 * @param <I7> the type of the input argument 7
 * @param <I8> the type of the input argument 8
 * @param <V>  the type of the emitting values
 * @param <E>  the type of possible exception
 */
@FunctionalInterface
public interface Stream8Level2<I1, I2, I3, I4, I5, I6, I7, I8, V, E extends Exception>
        extends Route8Level2<I1, I2, I3, I4, I5, I6, I7, I8, E, Emitting<? extends V>>, Stream8Level1<I1, I2, I3, I4, I5, I6, I7, I8, V, E> {}
