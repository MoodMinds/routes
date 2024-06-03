package org.moodminds.route;

/**
 * Action route definition function by the {@link Flow} and 5 argument values level 2.
 *
 * @param <I1> the type of the input argument 1
 * @param <I2> the type of the input argument 2
 * @param <I3> the type of the input argument 3
 * @param <I4> the type of the input argument 4
 * @param <I5> the type of the input argument 5
 * @param <E>  the type of possible exception
 */
@FunctionalInterface
public interface Action5Level2<I1, I2, I3, I4, I5, E extends Exception>
        extends Route5Level2<I1, I2, I3, I4, I5, E, Flowing<?>>, Action5Level1<I1, I2, I3, I4, I5, E> {}
