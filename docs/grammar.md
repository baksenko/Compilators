# Gramatyka BNF — Protobuf proto3

> Notacja: `::=` definicja, `|` alternatywa, `ε` produkcja pusta.
> Tokeny `token_documentation.md`.
> Źródło: [proto3-spec](https://protobuf.dev/reference/protobuf/proto3-spec/)

---

## Plik proto

```bnf
<proto>            ::= <optSyntax> <topLevelList> EOF

<optSyntax>        ::= <syntaxStatement> | ε

<topLevelList>     ::= <topLevelItem> <topLevelList> | ε

<topLevelItem>     ::= <importStatement>
                     | <packageStatement>
                     | <optionStatement>
                     | <topLevelDef>
                     | <emptyStatement>

<topLevelDef>      ::= <messageDef> | <enumDef>

<emptyStatement>   ::= SEMICOLON
```

## Nagłówek

```bnf
<syntaxStatement>  ::= SYNTAX EQUALS STRING_LITERAL SEMICOLON

<importStatement>  ::= IMPORT <optImportMod> STRING_LITERAL SEMICOLON
<optImportMod>     ::= PUBLIC | WEAK | ε

<packageStatement> ::= PACKAGE <fullIdent> SEMICOLON

<optionStatement>  ::= OPTION <optionName> EQUALS <constant> SEMICOLON
```

## Identyfikatory

```bnf
<fullIdent>        ::= IDENTIFIER <fullIdentTail>
<fullIdentTail>    ::= DOT IDENTIFIER <fullIdentTail> | ε

<messageType>      ::= <optDot> <typePath> IDENTIFIER
<enumType>         ::= <optDot> <typePath> IDENTIFIER
<optDot>           ::= DOT | ε
<typePath>         ::= IDENTIFIER DOT <typePath> | ε

<optionName>       ::= <optionNameHead> <optionNameTail>
<optionNameHead>   ::= IDENTIFIER | <bracedFullIdent>
<optionNameTail>   ::= DOT <optionNameHead> <optionNameTail> | ε
<bracedFullIdent>  ::= LEFT_PAREN <optDot> <fullIdent> RIGHT_PAREN
```

## Stałe i typy

```bnf
<constant>         ::= <fullIdent>
                     | <optSign> INTEGER_LITERAL
                     | <optSign> FLOAT_LITERAL
                     | STRING_LITERAL
                     | TRUE
                     | FALSE
<optSign>          ::= MINUS | PLUS | ε

<type>             ::= DOUBLE | FLOAT | INT32 | INT64 | UINT32 | UINT64
                     | SINT32 | SINT64 | FIXED32 | FIXED64
                     | SFIXED32 | SFIXED64
                     | BOOL | STRING | BYTES
                     | <messageType> | <enumType>

<keyType>          ::= INT32 | INT64 | UINT32 | UINT64 | SINT32 | SINT64
                     | FIXED32 | FIXED64 | SFIXED32 | SFIXED64
                     | BOOL | STRING

<fieldNumber>      ::= INTEGER_LITERAL
```

## Pola

```bnf
<field>            ::= <optFieldMod> <type> IDENTIFIER EQUALS <fieldNumber>
                       <optFieldOpts> SEMICOLON
<optFieldMod>      ::= REPEATED | OPTIONAL | ε
<optFieldOpts>     ::= LEFT_BRACKET <fieldOptions> RIGHT_BRACKET | ε
<fieldOptions>     ::= <fieldOption> <fieldOptionsTail>
<fieldOptionsTail> ::= COMMA <fieldOption> <fieldOptionsTail> | ε
<fieldOption>      ::= <optionName> EQUALS <constant>

<oneofDef>         ::= ONEOF IDENTIFIER LEFT_BRACE <oneofBody> RIGHT_BRACE
<oneofBody>        ::= <oneofItem> <oneofBody> | ε
<oneofItem>        ::= <optionStatement> | <oneofField>
<oneofField>       ::= <type> IDENTIFIER EQUALS <fieldNumber>
                       <optFieldOpts> SEMICOLON

<mapField>         ::= MAP LEFT_ANGLE <keyType> COMMA <type> RIGHT_ANGLE
                       IDENTIFIER EQUALS <fieldNumber>
                       <optFieldOpts> SEMICOLON
```

## Reserved

```bnf
<reserved>         ::= RESERVED <reservedBody> SEMICOLON
<reservedBody>     ::= <ranges> | <fieldNames>
<ranges>           ::= <range> <rangesTail>
<rangesTail>       ::= COMMA <range> <rangesTail> | ε
<range>            ::= INTEGER_LITERAL <optRangeEnd>
<optRangeEnd>      ::= TO <rangeMax> | ε
<rangeMax>         ::= INTEGER_LITERAL | MAX
<fieldNames>       ::= STRING_LITERAL <fieldNamesTail>
<fieldNamesTail>   ::= COMMA STRING_LITERAL <fieldNamesTail> | ε
```

## Message

```bnf
<messageDef>       ::= MESSAGE IDENTIFIER <messageBody>
<messageBody>      ::= LEFT_BRACE <msgBodyList> RIGHT_BRACE
<msgBodyList>      ::= <msgBodyItem> <msgBodyList> | ε
<msgBodyItem>      ::= <field> | <enumDef> | <messageDef>
                     | <optionStatement> | <oneofDef>
                     | <mapField> | <reserved> | <emptyStatement>
```

## Enum

```bnf
<enumDef>          ::= ENUM IDENTIFIER <enumBody>
<enumBody>         ::= LEFT_BRACE <enumBodyList> RIGHT_BRACE
<enumBodyList>     ::= <enumBodyItem> <enumBodyList> | ε
<enumBodyItem>     ::= <optionStatement> | <enumField>
                     | <reserved> | <emptyStatement>
<enumField>        ::= IDENTIFIER EQUALS <optMinus> INTEGER_LITERAL
                       <optEnumValOpts> SEMICOLON
<optMinus>         ::= MINUS | ε
<optEnumValOpts>   ::= LEFT_BRACKET <enumValOptList> RIGHT_BRACKET | ε
<enumValOptList>   ::= <enumValueOption> <enumValOptTail>
<enumValOptTail>   ::= COMMA <enumValueOption> <enumValOptTail> | ε
<enumValueOption>  ::= <optionName> EQUALS <constant>
```

