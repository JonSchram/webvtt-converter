package com.jonathanschram.vttconverter.lib.vtt.parsing;

public class TimeCodeParseException extends Exception {

    /**
     * Generated version UID.
     */
    private static final long serialVersionUID = 1218586389725029113L;

    public TimeCodeParseException() {
        super();
    }

    public TimeCodeParseException(String message) {
        super(message);
    }

    public TimeCodeParseException(Throwable cause) {
        super(cause);
    }

    public TimeCodeParseException(String message, Throwable cause) {
        super(message, cause);
    }
}
