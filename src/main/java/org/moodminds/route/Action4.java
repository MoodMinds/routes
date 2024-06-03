package org.moodminds.route;

/**
 * Action route definition function by the {@link Flow} and 4 argument values.
 *
 * @param <I1> the type of the input argument 1
 * @param <I2> the type of the input argument 2
 * @param <I3> the type of the input argument 3
 * @param <I4> the type of the input argument 4
 * @param <E>  the type of possible exception
 */
@FunctionalInterface
public interface Action4<I1, I2, I3, I4, E extends Exception>
        extends Action4Level3<I1, I2, I3, I4, E> {}
