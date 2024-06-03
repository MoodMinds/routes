package org.moodminds.route;

import org.moodminds.emission.Emittable;
import org.moodminds.function.Evaluable2Throwing1;

/**
 * Represents an operation supplying an {@link Emittable} of result values by 2 input arguments.
 *
 * @param <I1> the type of the input 1
 * @param <I2> the type of the input 2
 * @param <V> the type of the result values
 * @param <E> the type of possible exception that might be thrown
 */
@FunctionalInterface
public interface Emission2<I1, I2, V, E extends Exception>
        extends Evaluable2Throwing1<I1, I2, Emittable<V, E>, E> {}
