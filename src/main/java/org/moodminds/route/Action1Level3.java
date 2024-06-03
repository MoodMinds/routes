package org.moodminds.route;

/**
 * Action route definition function by the {@link Flow} and argument value level 3.
 *
 * @param <I> the type of the input argument
 * @param <E> the type of possible exception
 */
@FunctionalInterface
public interface Action1Level3<I, E extends Exception>
        extends Route1Level3<I, E, Flowing<?>>, Action1Level2<I, E> {}
