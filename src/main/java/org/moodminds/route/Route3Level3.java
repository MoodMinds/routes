package org.moodminds.route;

/**
 * Route definition function by the {@link Flow} and 3 argument values level 3.
 *
 * @param <I1> the type of the input argument 1
 * @param <I2> the type of the input argument 2
 * @param <I3> the type of the input argument 3
 * @param <E>  the type of possible exception
 * @param <$R> the type of the route definition result
 */
@FunctionalInterface
public interface Route3Level3<I1, I2, I3, E extends Exception, $R extends Routing<?>>
        extends Route3Level2<I1, I2, I3, E, $R> {}
