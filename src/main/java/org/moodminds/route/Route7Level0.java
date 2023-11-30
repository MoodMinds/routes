package org.moodminds.route;

/**
 * Route definition function by the {@link Flow} and 7 argument values level 0.
 *
 * @param <I1> the type of the input argument 1
 * @param <I2> the type of the input argument 2
 * @param <I3> the type of the input argument 3
 * @param <I4> the type of the input argument 4
 * @param <I5> the type of the input argument 5
 * @param <I6> the type of the input argument 6
 * @param <I7> the type of the input argument 7
 * @param <E>  the type of possible exception
 * @param <$R> the type of the route definition result
 */
@FunctionalInterface
public interface Route7Level0<I1, I2, I3, I4, I5, I6, I7, E extends Exception, $R extends Routing<?>>
        extends Route7<Flow<?, E>, I1, I2, I3, I4, I5, I6, I7, $R> {}
