package org.moodminds.route;

/**
 * Route definition block by 2 argument values.
 *
 * @param <I1> the type of the input argument 1
 * @param <I2> the type of the input argument 2
 * @param <$R> the type of the route definition result
 */
@FunctionalInterface
public interface Block2<I1, I2, $R extends Routing<?>> {

    /**
     * Define the route block by the specified argument value.
     *
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @return a route block definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    $R block(Value<I1> value1, Value<I2> value2);
}
