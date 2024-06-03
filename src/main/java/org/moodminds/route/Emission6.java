package org.moodminds.route;

import org.moodminds.emission.Emittable;
import org.moodminds.function.Evaluable6Throwing1;

/**
 * Represents an operation supplying an {@link Emittable} of result values by 6 input arguments.
 *
 * @param <I1> the type of the input 1
 * @param <I2> the type of the input 2
 * @param <I3> the type of the input 3
 * @param <I4> the type of the input 4
 * @param <I5> the type of the input 5
 * @param <I6> the type of the input 6
 * @param <V>  the type of the result values
 * @param <E>  the type of possible exception that might be thrown
 */
@FunctionalInterface
public interface Emission6<I1, I2, I3, I4, I5, I6, V, E extends Exception>
        extends Evaluable6Throwing1<I1, I2, I3, I4, I5, I6, Emittable<V, E>, E> {}
