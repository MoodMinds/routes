package org.moodminds.route;

/**
 * Flowing result definition object by the {@link Flow}.
 *
 * @param <$F> the type of the flow definition interface
 */
public interface Flowing<$F extends Flow<?, ?>> extends Routing<$F> {}
