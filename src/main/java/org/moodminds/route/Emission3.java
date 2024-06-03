package org.moodminds.route;

import org.moodminds.emission.Emittable;
import org.moodminds.function.Evaluable3Throwing1;

/**
 * Represents an operation supplying an {@link Emittable} of result values by 3 input arguments.
 *
 * @param <I1> the type of the input 1
 * @param <I2> the type of the input 2
 * @param <I3> the type of the input 3
 * @param <V>  the type of the result values
 * @param <E>  the type of possible exception that might be thrown
 */
@FunctionalInterface
public interface Emission3<I1, I2, I3, V, E extends Exception>
        extends Evaluable3Throwing1<I1, I2, I3, Emittable<V, E>, E> {}
