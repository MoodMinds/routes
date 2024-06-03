package org.moodminds.route;

/**
 * Action route definition function by the {@link Flow} and 2 argument values level 1.
 *
 * @param <I1> the type of the input argument 1
 * @param <I2> the type of the input argument 2
 * @param <E> the type of possible exception
 */
@FunctionalInterface
public interface Action2Level1<I1, I2, E extends Exception>
        extends Route2Level1<I1, I2, E, Flowing<?>> {}
