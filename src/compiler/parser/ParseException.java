package compiler.parser;

/**
 * Exception thrown when the parser encounters a syntax error.
 */
public class ParseException extends RuntimeException {
    public ParseException(String message) {
        super(message);
    }
}
