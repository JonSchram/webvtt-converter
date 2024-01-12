package com.jonathanschram.vttconverter.lib.vtt.parsing;

/***
 * An exception thrown when parsing a VTT object from a stream. Thrown when the
 * stream cannot be interpreted as a VTT file.
 */
public class IncorrectFormatException extends Exception {

    /**
     * Generated serial version UID.
     */
    private static final long serialVersionUID = -8564614409794432742L;

    public IncorrectFormatException() {
        super();
    }

    public IncorrectFormatException(String message) {
        super(message);
    }

    public IncorrectFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectFormatException(Throwable cause) {
        super(cause);
    }
}
