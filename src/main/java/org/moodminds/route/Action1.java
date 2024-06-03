package org.moodminds.route;

/**
 * Action route definition function by the {@link Flow} and argument value.
 *
 * @param <I> the type of the input argument
 * @param <E> the type of possible exception
 */
@FunctionalInterface
public interface Action1<I, E extends Exception>
        extends Action1Level3<I, E> {}
