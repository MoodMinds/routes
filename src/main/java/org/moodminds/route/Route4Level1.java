package org.moodminds.route;

/**
 * Route definition function by the {@link Flow} and 4 argument values level 1.
 *
 * @param <I1> the type of the input argument 1
 * @param <I2> the type of the input argument 2
 * @param <I3> the type of the input argument 3
 * @param <I4> the type of the input argument 4
 * @param <E>  the type of possible exception
 * @param <$R> the type of the route definition result
 */
@FunctionalInterface
public interface Route4Level1<I1, I2, I3, I4, E extends Exception, $R extends Routing<?>>
        extends Route4Level0<I1, I2, I3, I4, E, $R> {}
