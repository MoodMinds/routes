package org.moodminds.route;

/**
 * Route definition function by the {@link Flow} and argument value level 2.
 *
 * @param <I> the type of the input argument
 * @param <E> the type of possible exception
 * @param <$R> the type of the route definition result
 */
@FunctionalInterface
public interface Route1Level2<I, E extends Exception, $R extends Routing<?>>
        extends Route1Level1<I, E, $R> {}
