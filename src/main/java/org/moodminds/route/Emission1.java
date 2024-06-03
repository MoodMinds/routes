package org.moodminds.route;

import org.moodminds.emission.Emittable;
import org.moodminds.function.Evaluable1Throwing1;

/**
 * Represents an operation supplying an {@link Emittable} of result values by an input argument.
 *
 * @param <I> the type of the input
 * @param <V> the type of the result values
 * @param <E> the type of possible exception that might be thrown
 */
@FunctionalInterface
public interface Emission1<I, V, E extends Exception>
        extends Evaluable1Throwing1<I, Emittable<V, E>, E> {}
