package compiler.lexer;

/**
 * Exception thrown when the lexer encounters an invalid character or token.
 */
public class LexerException extends RuntimeException {
    public LexerException(String message) {
        super(message);
    }
}
