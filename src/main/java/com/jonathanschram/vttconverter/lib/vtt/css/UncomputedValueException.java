package com.jonathanschram.vttconverter.lib.vtt.css;

/***
 * An exception thrown when a CSS value is specified in relative terms, but a
 * calculated value is requested.
 */
public class UncomputedValueException extends Exception {

    private static final long serialVersionUID = 4376829555238946524L;

    public UncomputedValueException() {
    }

    public UncomputedValueException(String message) {
        super(message);
    }

    public UncomputedValueException(Throwable cause) {
        super(cause);
    }

    public UncomputedValueException(String message, Throwable cause) {
        super(message, cause);
    }

    public UncomputedValueException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
