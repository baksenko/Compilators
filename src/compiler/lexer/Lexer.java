package compiler.lexer;

import compiler.token.Token;
import compiler.token.TokenType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hand-written lexer (scanner) for proto3 files.
 * Implemented as a state machine with buffering, as specified in the project docs.
 */
public class Lexer {

    private final String source;
    private int pos;
    private int line;
    private int column;

    private static final Map<String, TokenType> KEYWORDS = new HashMap<>();

    static {
        // Top-level
        KEYWORDS.put("syntax",   TokenType.SYNTAX);
        KEYWORDS.put("import",   TokenType.IMPORT);
        KEYWORDS.put("package",  TokenType.PACKAGE);
        KEYWORDS.put("option",   TokenType.OPTION);
        KEYWORDS.put("message",  TokenType.MESSAGE);
        KEYWORDS.put("enum",     TokenType.ENUM);

        // Field modifiers
        KEYWORDS.put("repeated", TokenType.REPEATED);
        KEYWORDS.put("optional", TokenType.OPTIONAL);
        KEYWORDS.put("oneof",    TokenType.ONEOF);
        KEYWORDS.put("map",      TokenType.MAP);
        KEYWORDS.put("reserved", TokenType.RESERVED);
        KEYWORDS.put("to",       TokenType.TO);
        KEYWORDS.put("max",      TokenType.MAX);

        // Import modifiers
        KEYWORDS.put("public",   TokenType.PUBLIC);
        KEYWORDS.put("weak",     TokenType.WEAK);

        // Scalar types
        KEYWORDS.put("double",   TokenType.DOUBLE);
        KEYWORDS.put("float",    TokenType.FLOAT);
        KEYWORDS.put("int32",    TokenType.INT32);
        KEYWORDS.put("int64",    TokenType.INT64);
        KEYWORDS.put("uint32",   TokenType.UINT32);
        KEYWORDS.put("uint64",   TokenType.UINT64);
        KEYWORDS.put("sint32",   TokenType.SINT32);
        KEYWORDS.put("sint64",   TokenType.SINT64);
        KEYWORDS.put("fixed32",  TokenType.FIXED32);
        KEYWORDS.put("fixed64",  TokenType.FIXED64);
        KEYWORDS.put("sfixed32", TokenType.SFIXED32);
        KEYWORDS.put("sfixed64", TokenType.SFIXED64);
        KEYWORDS.put("bool",     TokenType.BOOL);
        KEYWORDS.put("string",   TokenType.STRING);
        KEYWORDS.put("bytes",    TokenType.BYTES);

        // Boolean literals
        KEYWORDS.put("true",     TokenType.TRUE);
        KEYWORDS.put("false",    TokenType.FALSE);

        // Special identifiers treated as keywords
        KEYWORDS.put("inf",      TokenType.FLOAT_LITERAL);
        KEYWORDS.put("nan",      TokenType.FLOAT_LITERAL);
    }

    public Lexer(String source) {
        this.source = source;
        this.pos = 0;
        this.line = 1;
        this.column = 1;
    }

    /**
     * Tokenize the entire source and return a list of tokens ending with EOF.
     */
    public List<Token> tokenize() {
        List<Token> tokens = new ArrayList<>();
        while (true) {
            Token t = nextToken();
            tokens.add(t);
            if (t.getType() == TokenType.EOF) break;
        }
        return tokens;
    }

    private Token nextToken() {
        skipWhitespaceAndComments();

        if (pos >= source.length()) {
            return new Token(TokenType.EOF, "", line, column);
        }

        char c = source.charAt(pos);
        int startLine = line;
        int startCol = column;

        // ── Single-character symbols ──
        switch (c) {
            case '{': advance(); return new Token(TokenType.LEFT_BRACE,    "{", startLine, startCol);
            case '}': advance(); return new Token(TokenType.RIGHT_BRACE,   "}", startLine, startCol);
            case '(': advance(); return new Token(TokenType.LEFT_PAREN,    "(", startLine, startCol);
            case ')': advance(); return new Token(TokenType.RIGHT_PAREN,   ")", startLine, startCol);
            case '[': advance(); return new Token(TokenType.LEFT_BRACKET,  "[", startLine, startCol);
            case ']': advance(); return new Token(TokenType.RIGHT_BRACKET, "]", startLine, startCol);
            case '<': advance(); return new Token(TokenType.LEFT_ANGLE,    "<", startLine, startCol);
            case '>': advance(); return new Token(TokenType.RIGHT_ANGLE,   ">", startLine, startCol);
            case ';': advance(); return new Token(TokenType.SEMICOLON,     ";", startLine, startCol);
            case ',': advance(); return new Token(TokenType.COMMA,         ",", startLine, startCol);
            case '=': advance(); return new Token(TokenType.EQUALS,        "=", startLine, startCol);
            case '-': advance(); return new Token(TokenType.MINUS,         "-", startLine, startCol);
            case '+': advance(); return new Token(TokenType.PLUS,          "+", startLine, startCol);
        }

        // ── Dot — could be start of a float like .5 ──
        if (c == '.') {
            if (pos + 1 < source.length() && Character.isDigit(source.charAt(pos + 1))) {
                return readFloatStartingWithDot(startLine, startCol);
            }
            advance();
            return new Token(TokenType.DOT, ".", startLine, startCol);
        }

        // ── String literals ──
        if (c == '"' || c == '\'') {
            return readStringLiteral(c, startLine, startCol);
        }

        // ── Number literals ──
        if (Character.isDigit(c)) {
            return readNumberLiteral(startLine, startCol);
        }

        // ── Identifiers & keywords ──
        if (Character.isLetter(c) || c == '_') {
            return readIdentifierOrKeyword(startLine, startCol);
        }

        // Unknown character — skip it and report error
        advance();
        throw new LexerException("Unexpected character '" + c + "' at line " + startLine + ", col " + startCol);
    }

    // ────────────────────────── helpers ──────────────────────────

    private void skipWhitespaceAndComments() {
        while (pos < source.length()) {
            char c = source.charAt(pos);

            // Whitespace
            if (c == ' ' || c == '\t' || c == '\r') {
                advance();
                continue;
            }
            if (c == '\n') {
                pos++;
                line++;
                column = 1;
                continue;
            }

            // Line comment
            if (c == '/' && pos + 1 < source.length() && source.charAt(pos + 1) == '/') {
                while (pos < source.length() && source.charAt(pos) != '\n') {
                    advance();
                }
                continue;
            }

            // Block comment
            if (c == '/' && pos + 1 < source.length() && source.charAt(pos + 1) == '*') {
                advance(); // /
                advance(); // *
                while (pos < source.length()) {
                    if (source.charAt(pos) == '\n') {
                        pos++;
                        line++;
                        column = 1;
                    } else if (source.charAt(pos) == '*' && pos + 1 < source.length() && source.charAt(pos + 1) == '/') {
                        advance(); // *
                        advance(); // /
                        break;
                    } else {
                        advance();
                    }
                }
                continue;
            }

            break;
        }
    }

    private void advance() {
        pos++;
        column++;
    }

    private char peek() {
        return pos < source.length() ? source.charAt(pos) : '\0';
    }

    private Token readStringLiteral(char quote, int startLine, int startCol) {
        advance(); // opening quote
        StringBuilder sb = new StringBuilder();
        while (pos < source.length() && source.charAt(pos) != quote) {
            if (source.charAt(pos) == '\\') {
                advance(); // backslash
                if (pos < source.length()) {
                    char esc = source.charAt(pos);
                    switch (esc) {
                        case 'n':  sb.append('\n'); break;
                        case 't':  sb.append('\t'); break;
                        case 'r':  sb.append('\r'); break;
                        case '\\': sb.append('\\'); break;
                        case '\'': sb.append('\''); break;
                        case '"':  sb.append('"');  break;
                        default:   sb.append(esc);  break;
                    }
                    advance();
                }
            } else if (source.charAt(pos) == '\n') {
                throw new LexerException("Unterminated string literal at line " + startLine);
            } else {
                sb.append(source.charAt(pos));
                advance();
            }
        }
        if (pos >= source.length()) {
            throw new LexerException("Unterminated string literal at line " + startLine);
        }
        advance(); // closing quote
        return new Token(TokenType.STRING_LITERAL, sb.toString(), startLine, startCol);
    }

    private Token readNumberLiteral(int startLine, int startCol) {
        StringBuilder sb = new StringBuilder();
        char first = source.charAt(pos);

        // Hex: 0x or 0X
        if (first == '0' && pos + 1 < source.length()
                && (source.charAt(pos + 1) == 'x' || source.charAt(pos + 1) == 'X')) {
            sb.append(first); advance();
            sb.append(source.charAt(pos)); advance();
            while (pos < source.length() && isHexDigit(source.charAt(pos))) {
                sb.append(source.charAt(pos)); advance();
            }
            return new Token(TokenType.INTEGER_LITERAL, sb.toString(), startLine, startCol);
        }

        // Octal: starts with 0, no x
        if (first == '0' && pos + 1 < source.length() && isOctalDigit(source.charAt(pos + 1))) {
            sb.append(first); advance();
            while (pos < source.length() && isOctalDigit(source.charAt(pos))) {
                sb.append(source.charAt(pos)); advance();
            }
            return new Token(TokenType.INTEGER_LITERAL, sb.toString(), startLine, startCol);
        }

        // Decimal / float
        while (pos < source.length() && Character.isDigit(source.charAt(pos))) {
            sb.append(source.charAt(pos)); advance();
        }

        boolean isFloat = false;

        // Fractional part
        if (pos < source.length() && source.charAt(pos) == '.') {
            isFloat = true;
            sb.append('.'); advance();
            while (pos < source.length() && Character.isDigit(source.charAt(pos))) {
                sb.append(source.charAt(pos)); advance();
            }
        }

        // Exponent part
        if (pos < source.length() && (source.charAt(pos) == 'e' || source.charAt(pos) == 'E')) {
            isFloat = true;
            sb.append(source.charAt(pos)); advance();
            if (pos < source.length() && (source.charAt(pos) == '+' || source.charAt(pos) == '-')) {
                sb.append(source.charAt(pos)); advance();
            }
            while (pos < source.length() && Character.isDigit(source.charAt(pos))) {
                sb.append(source.charAt(pos)); advance();
            }
        }

        return new Token(isFloat ? TokenType.FLOAT_LITERAL : TokenType.INTEGER_LITERAL,
                sb.toString(), startLine, startCol);
    }

    private Token readFloatStartingWithDot(int startLine, int startCol) {
        StringBuilder sb = new StringBuilder(".");
        advance(); // dot
        while (pos < source.length() && Character.isDigit(source.charAt(pos))) {
            sb.append(source.charAt(pos)); advance();
        }
        // Exponent
        if (pos < source.length() && (source.charAt(pos) == 'e' || source.charAt(pos) == 'E')) {
            sb.append(source.charAt(pos)); advance();
            if (pos < source.length() && (source.charAt(pos) == '+' || source.charAt(pos) == '-')) {
                sb.append(source.charAt(pos)); advance();
            }
            while (pos < source.length() && Character.isDigit(source.charAt(pos))) {
                sb.append(source.charAt(pos)); advance();
            }
        }
        return new Token(TokenType.FLOAT_LITERAL, sb.toString(), startLine, startCol);
    }

    private Token readIdentifierOrKeyword(int startLine, int startCol) {
        StringBuilder sb = new StringBuilder();
        while (pos < source.length() &&
                (Character.isLetterOrDigit(source.charAt(pos)) || source.charAt(pos) == '_')) {
            sb.append(source.charAt(pos)); advance();
        }
        String word = sb.toString();
        TokenType type = KEYWORDS.getOrDefault(word, TokenType.IDENTIFIER);
        return new Token(type, word, startLine, startCol);
    }

    private boolean isHexDigit(char c) {
        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F');
    }

    private boolean isOctalDigit(char c) {
        return c >= '0' && c <= '7';
    }
}
