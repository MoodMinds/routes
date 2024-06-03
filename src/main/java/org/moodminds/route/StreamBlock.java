package org.moodminds.route;

/**
 * Streaming block definition function.
 *
 * @param <V> the type of the emitting values
 */
@FunctionalInterface
public interface StreamBlock<V> extends Block<Emitting<? extends V>> {}
