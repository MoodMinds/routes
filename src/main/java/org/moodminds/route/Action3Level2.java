package org.moodminds.route;

/**
 * Action route definition function by the {@link Flow} and 3 argument values level 2.
 *
 * @param <I1> the type of the input argument 1
 * @param <I2> the type of the input argument 2
 * @param <I3> the type of the input argument 3
 * @param <E>  the type of possible exception
 */
@FunctionalInterface
public interface Action3Level2<I1, I2, I3, E extends Exception>
        extends Route3Level2<I1, I2, I3, E, Flowing<?>>, Action3Level1<I1, I2, I3, E> {}
