package compiler.token;

/**
 * All lexical token types for proto3 syntax.
 * Based on token_documentation.md
 */
public enum TokenType {

    // ── Symbols & Operators ──
    LEFT_BRACE,        // {
    RIGHT_BRACE,       // }
    LEFT_PAREN,        // (
    RIGHT_PAREN,       // )
    LEFT_BRACKET,      // [
    RIGHT_BRACKET,     // ]
    LEFT_ANGLE,        // <
    RIGHT_ANGLE,       // >
    SEMICOLON,         // ;
    COMMA,             // ,
    DOT,               // .
    EQUALS,            // =
    MINUS,             // -
    PLUS,              // +

    // ── Keywords — Top-Level ──
    SYNTAX,
    IMPORT,
    PACKAGE,
    OPTION,
    MESSAGE,
    ENUM,

    // ── Keywords — Field Modifiers ──
    REPEATED,
    OPTIONAL,
    ONEOF,
    MAP,
    RESERVED,
    TO,
    MAX,

    // ── Keywords — Import Modifiers ──
    PUBLIC,
    WEAK,

    // ── Keywords — Scalar Types ──
    DOUBLE,
    FLOAT,
    INT32,
    INT64,
    UINT32,
    UINT64,
    SINT32,
    SINT64,
    FIXED32,
    FIXED64,
    SFIXED32,
    SFIXED64,
    BOOL,
    STRING,
    BYTES,

    // ── Keywords — Boolean Literals ──
    TRUE,
    FALSE,

    // ── Literals & Identifiers ──
    IDENTIFIER,
    INTEGER_LITERAL,
    FLOAT_LITERAL,
    STRING_LITERAL,

    // ── Special ──
    EOF
}
