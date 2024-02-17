package com.jonathanschram.vttconverter.lib.vtt.css;

/***
 * An error thrown when attempting to get a concrete value from a relative CSS
 * property.
 */
public class UnresolvedPropertyException extends RuntimeException {

    private static final long serialVersionUID = -7228449062136786064L;

    public UnresolvedPropertyException() {
    }

    public UnresolvedPropertyException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public UnresolvedPropertyException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnresolvedPropertyException(String message) {
        super(message);
    }

    public UnresolvedPropertyException(Throwable cause) {
        super(cause);
    }

}
