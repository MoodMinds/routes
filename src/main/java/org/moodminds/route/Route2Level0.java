package org.moodminds.route;

/**
 * Route definition function by the {@link Flow} and 2 argument values level 0.
 *
 * @param <I1> the type of the input argument 1
 * @param <I2> the type of the input argument 2
 * @param <E> the type of possible exception
 * @param <$R> the type of the route definition result
 */
@FunctionalInterface
public interface Route2Level0<I1, I2, E extends Exception, $R extends Routing<?>>
        extends Route2<Flow<?, E>, I1, I2, $R> {}
