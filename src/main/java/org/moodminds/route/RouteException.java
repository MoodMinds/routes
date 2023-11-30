package org.moodminds.route;

/**
 * An exception that indicates an error in a route definition.
 */
public class RouteException extends RuntimeException {

    private static final long serialVersionUID = -6564210515301570294L;

    /**
     * Construct the object with the given message.
     *
     * @param message the given message
     */
    public RouteException(String message) {
        super(message);
    }

    /**
     * Construct the object with the given message and cause exception.
     *
     * @param message the given message
     * @param cause the given cause exception
     */
    public RouteException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Construct the object with the given cause exception.
     *
     * @param cause the given cause exception
     */
    public RouteException(Throwable cause) {
        super(cause);
    }
}
