package net.jvw;


/**
 * Simplified version of an error class, in real life this is the place to add error codes or
 * elaborate descriptions
 */
public class ValidationError {

    String message;

    public ValidationError(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ValidationError{" +
                "message='" + message + '\'' +
                '}';
    }
}
