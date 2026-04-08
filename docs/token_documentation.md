# Tokens — gRPC Protobuf to Java Translator

> Lexical tokens recognized by the lexer when parsing `.proto` files (proto3 syntax).

---

## Symbols & Operators

| Name | Definition |
|------|------------|
| `LEFT_BRACE` | `{` |
| `RIGHT_BRACE` | `}` |
| `LEFT_PAREN` | `(` |
| `RIGHT_PAREN` | `)` |
| `LEFT_BRACKET` | `[` |
| `RIGHT_BRACKET` | `]` |
| `LEFT_ANGLE` | `<` |
| `RIGHT_ANGLE` | `>` |
| `SEMICOLON` | `;` |
| `COMMA` | `,` |
| `DOT` | `.` |
| `EQUALS` | `=` |
| `MINUS` | `-` |
| `PLUS` | `+` |
| `SLASH` | `/` |
| `DOUBLE_QUOTE` | `"` |
| `SINGLE_QUOTE` | `'` |

## Keywords — Top-Level

| Name | Definition |
|------|------------|
| `SYNTAX` | `syntax` |
| `IMPORT` | `import` |
| `PACKAGE` | `package` |
| `OPTION` | `option` |
| `MESSAGE` | `message` |
| `ENUM` | `enum` |
| `SERVICE` | `service` |
| `RPC` | `rpc` |
| `RETURNS` | `returns` |
| `STREAM` | `stream` |

## Keywords — Field Modifiers

| Name | Definition |
|------|------------|
| `REPEATED` | `repeated` |
| `OPTIONAL` | `optional` |
| `ONEOF` | `oneof` |
| `MAP` | `map` |
| `RESERVED` | `reserved` |
| `TO` | `to` |
| `MAX` | `max` |

## Keywords — Import Modifiers

| Name | Definition |
|------|------------|
| `PUBLIC` | `public` |
| `WEAK` | `weak` |

## Keywords — Scalar Types

| Name | Definition |
|------|------------|
| `DOUBLE` | `double` |
| `FLOAT` | `float` |
| `INT32` | `int32` |
| `INT64` | `int64` |
| `UINT32` | `uint32` |
| `UINT64` | `uint64` |
| `SINT32` | `sint32` |
| `SINT64` | `sint64` |
| `FIXED32` | `fixed32` |
| `FIXED64` | `fixed64` |
| `SFIXED32` | `sfixed32` |
| `SFIXED64` | `sfixed64` |
| `BOOL` | `bool` |
| `STRING` | `string` |
| `BYTES` | `bytes` |

## Keywords — Boolean Literals

| Name | Definition |
|------|------------|
| `TRUE` | `true` |
| `FALSE` | `false` |

## Literals & Identifiers

| Name | Definition |
|------|------------|
| `IDENTIFIER` | Sequence of letters, digits, or `_`, starting with a letter (`[a-zA-Z][a-zA-Z0-9_]*`) |
| `INTEGER_LITERAL` | Decimal (`[1-9][0-9]*`), octal (`0[0-7]*`), or hex (`0[xX][0-9a-fA-F]+`) integer |
| `FLOAT_LITERAL` | Floating-point number (e.g. `3.14`, `1e-2`, `.5`), or `inf`, `nan` |
| `STRING_LITERAL` | Sequence of characters enclosed in `"..."` or `'...'` with escape support |

## Comments

| Name | Definition |
|------|------------|
| `LINE_COMMENT` | Starts with `//`, extends to end of line |
| `BLOCK_COMMENT` | Enclosed between `/*` and `*/` |

## Special

| Name | Definition |
|------|------------|
| `WHITESPACE` | Spaces, tabs, carriage returns, newlines (skipped by lexer) |
| `EOF` | End of file |

---

> Based on the [Protocol Buffers Language Specification (Proto3)](https://protobuf.dev/reference/protobuf/proto3-spec/).
> This token set covers the full proto3 + gRPC service/rpc syntax needed for translation to Java classes.
