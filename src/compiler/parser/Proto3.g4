/**
 * Combined ANTLR4 grammar for Protocol Buffers proto3 syntax.
 *
 * Based on: https://protobuf.dev/reference/protobuf/proto3-spec/
 * and the project's docs/grammar.md BNF specification.
 *
 * Generates both lexer and parser in the compiler.parser package.
 */
grammar Proto3;

// ══════════════════════════════════════════════════════════════
//  Parser Rules
// ══════════════════════════════════════════════════════════════

// ────────────────────────── proto file ──────────────────────────

proto
    : syntaxStatement? topLevelItem* EOF
    ;

topLevelItem
    : importStatement
    | packageStatement
    | optionStatement
    | messageDef
    | enumDef
    | emptyStatement
    ;

emptyStatement
    : SEMI
    ;

// ────────────────────────── header ──────────────────────────

syntaxStatement
    : SYNTAX EQ STRING_LITERAL SEMI
    ;

importStatement
    : IMPORT importModifier? STRING_LITERAL SEMI
    ;

importModifier
    : PUBLIC
    | WEAK
    ;

packageStatement
    : PACKAGE fullIdent SEMI
    ;

optionStatement
    : OPTION optionName EQ constant SEMI
    ;

// ────────────────────────── identifiers ──────────────────────────

fullIdent
    : IDENTIFIER (DOT IDENTIFIER)*
    ;

optionName
    : optionNamePart (DOT optionNamePart)*
    ;

optionNamePart
    : IDENTIFIER
    | LPAREN DOT? fullIdent RPAREN
    ;

// Type reference: optional leading dot, then dotted identifiers
typeReference
    : DOT? IDENTIFIER (DOT IDENTIFIER)*
    ;

// ────────────────────────── constants ──────────────────────────

constant
    : fullIdent
    | (MINUS | PLUS)? INTEGER_LITERAL
    | (MINUS | PLUS)? FLOAT_LITERAL
    | STRING_LITERAL
    | TRUE
    | FALSE
    ;

// ────────────────────────── types ──────────────────────────

type_
    : scalarType
    | typeReference
    ;

scalarType
    : DOUBLE | FLOAT
    | INT32  | INT64  | UINT32  | UINT64
    | SINT32 | SINT64
    | FIXED32 | FIXED64 | SFIXED32 | SFIXED64
    | BOOL   | STRING  | BYTES
    ;

keyType
    : INT32  | INT64  | UINT32  | UINT64
    | SINT32 | SINT64
    | FIXED32 | FIXED64 | SFIXED32 | SFIXED64
    | BOOL   | STRING
    ;

fieldNumber
    : INTEGER_LITERAL
    ;

// ────────────────────────── fields ──────────────────────────

field
    : fieldModifier? type_ IDENTIFIER EQ fieldNumber fieldOptions? SEMI
    ;

fieldModifier
    : REPEATED
    | OPTIONAL
    ;

fieldOptions
    : LBRACKET fieldOption (COMMA fieldOption)* RBRACKET
    ;

fieldOption
    : optionName EQ constant
    ;

// ────────────────────────── oneof ──────────────────────────

oneofDef
    : ONEOF IDENTIFIER LBRACE oneofItem* RBRACE
    ;

oneofItem
    : optionStatement
    | oneofField
    | emptyStatement
    ;

oneofField
    : type_ IDENTIFIER EQ fieldNumber fieldOptions? SEMI
    ;

// ────────────────────────── map ──────────────────────────

mapField
    : MAP LANGLE keyType COMMA type_ RANGLE
      IDENTIFIER EQ fieldNumber fieldOptions? SEMI
    ;

// ────────────────────────── reserved ──────────────────────────

reserved
    : RESERVED (ranges | fieldNames) SEMI
    ;

ranges
    : range_ (COMMA range_)*
    ;

range_
    : INTEGER_LITERAL (TO (INTEGER_LITERAL | MAX))?
    ;

fieldNames
    : STRING_LITERAL (COMMA STRING_LITERAL)*
    ;

// ────────────────────────── message ──────────────────────────

messageDef
    : MESSAGE IDENTIFIER messageBody
    ;

messageBody
    : LBRACE messageBodyItem* RBRACE
    ;

messageBodyItem
    : field
    | enumDef
    | messageDef
    | optionStatement
    | oneofDef
    | mapField
    | reserved
    | emptyStatement
    ;

// ────────────────────────── enum ──────────────────────────

enumDef
    : ENUM IDENTIFIER enumBody
    ;

enumBody
    : LBRACE enumBodyItem* RBRACE
    ;

enumBodyItem
    : optionStatement
    | enumField
    | reserved
    | emptyStatement
    ;

enumField
    : IDENTIFIER EQ MINUS? INTEGER_LITERAL enumValueOptions? SEMI
    ;

enumValueOptions
    : LBRACKET enumValueOption (COMMA enumValueOption)* RBRACKET
    ;

enumValueOption
    : optionName EQ constant
    ;


// ══════════════════════════════════════════════════════════════
//  Lexer Rules
// ══════════════════════════════════════════════════════════════

// ────────────────────────── keywords: top-level ──────────────────────────

SYNTAX   : 'syntax';
IMPORT   : 'import';
PACKAGE  : 'package';
OPTION   : 'option';
MESSAGE  : 'message';
ENUM     : 'enum';

// ────────────────────────── keywords: field modifiers ──────────────────────────

REPEATED : 'repeated';
OPTIONAL : 'optional';
ONEOF    : 'oneof';
MAP      : 'map';
RESERVED : 'reserved';
TO       : 'to';
MAX      : 'max';

// ────────────────────────── keywords: import modifiers ──────────────────────────

PUBLIC   : 'public';
WEAK     : 'weak';

// ────────────────────────── keywords: scalar types ──────────────────────────

DOUBLE   : 'double';
FLOAT    : 'float';
INT32    : 'int32';
INT64    : 'int64';
UINT32   : 'uint32';
UINT64   : 'uint64';
SINT32   : 'sint32';
SINT64   : 'sint64';
FIXED32  : 'fixed32';
FIXED64  : 'fixed64';
SFIXED32 : 'sfixed32';
SFIXED64 : 'sfixed64';
BOOL     : 'bool';
STRING   : 'string';
BYTES    : 'bytes';

// ────────────────────────── keywords: boolean literals ──────────────────────────

TRUE     : 'true';
FALSE    : 'false';

// ────────────────────────── symbols ──────────────────────────

LBRACE   : '{';
RBRACE   : '}';
LPAREN   : '(';
RPAREN   : ')';
LBRACKET : '[';
RBRACKET : ']';
LANGLE   : '<';
RANGLE   : '>';
SEMI     : ';';
COMMA    : ',';
DOT      : '.';
EQ       : '=';
MINUS    : '-';
PLUS     : '+';

// ────────────────────────── literals ──────────────────────────

// String literal: double or single quoted with escape support
STRING_LITERAL
    : '"' ( '\\' . | ~["\\\r\n] )* '"'
    | '\'' ( '\\' . | ~['\\\r\n] )* '\''
    ;

// Float literal: decimal with fractional/exponent part, or inf/nan
FLOAT_LITERAL
    : DECIMALS '.' DECIMALS? EXPONENT?
    | DECIMALS EXPONENT
    | '.' DECIMALS EXPONENT?
    | 'inf'
    | 'nan'
    ;

// Integer literal: hex, octal, or decimal
INTEGER_LITERAL
    : '0' [xX] HEX_DIGIT+
    | '0' OCTAL_DIGIT*
    | [1-9] [0-9]*
    ;

// Identifier: letter or underscore, then alphanumerics/underscores
IDENTIFIER
    : [a-zA-Z_] [a-zA-Z0-9_]*
    ;

// ────────────────────────── skip: whitespace and comments ──────────────────────────

LINE_COMMENT
    : '//' ~[\r\n]* -> skip
    ;

BLOCK_COMMENT
    : '/*' .*? '*/' -> skip
    ;

WS
    : [ \t\r\n]+ -> skip
    ;

// ────────────────────────── fragments ──────────────────────────

fragment DECIMALS    : [0-9]+;
fragment EXPONENT    : [eE] [+-]? [0-9]+;
fragment HEX_DIGIT   : [0-9a-fA-F];
fragment OCTAL_DIGIT : [0-7];
