# Założenia Projektowe - Kompilator Protobuf do Javy

**Dane studenta(-ów):** Mikhail Danilau, Roman Chmirou
**Dane kontaktowe:** danilovmv@student.agh.edu.pl, 

## Założenia programu

### Ogólne cele programu
Zaprojektowanie i implementacja translatora (kompilatora) transformującego opisy struktur danych napisanych w formacie **Protocol Buffers (składnia proto3)** do jednoznacznie odpowiadającego im kodu źródłowego w języku **Java**. Projekt obejmuje stworzenie kompletnego front-endu kompilatora, poczynając od analizy leksykalnej (skaner). 

### Rodzaj translatora
Kompilator (konwerter kod źródłowy -> kod źródłowy). Tłumaczy deklaratywny kod języka .proto na postać obiektową ze ścisłym systemem typów w języku Java.

### Planowany wynik działania programu
- **Wynik końcowy:** plik lub zestaw plików z wygenerowanym kodem źródłowym `.java`, z bezbłędnie odwzorowaną strukturą wiadomości, paczek i enumów z początkowego pliku `.proto`.

### Planowany język implementacji
Algorytmy kompilatora są implementowane w języku **Java** (wersja standardowa).

### Sposób realizacji skanera/parsera
Skaner zaimplementowano całkowicie od podstaw programistycznych (ręcznie) jako maszynę stanów z odpowiednim buforowaniem w języku Java. Analizator składniowy (parser) będzie prawdopodobnie zaimplementowany w sposób zstępujący (Recursive Descent Parser) jako kontynuacja prac w języku Java.

# Tokens — Protobuf to Java Translator

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
> This token set covers the full proto3 syntax needed for translation to Java classes.
