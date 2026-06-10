# protobuf-3-java

## Zespół
Mikhail Danilau — danilovmv@student.agh.edu.pl
Roman Chmirou — rchmirou@student.agh.edu.pl

## Założenia programu
Translator deklaracji struktur danych zapisanych w formacie **Protocol Buffers (składnia proto3)** do kodu źródłowego w języku **Java**.
Użytkownik podaje plik `.proto`, a program wykonuje pełny pipeline kompilatorski: lekser → parser → AST → generacja kodu Java.

## Ogólne cele programu
Program umożliwia automatyczne generowanie klas Java (z polami, getterami, setterami, `toString`, `equals`, `hashCode`) na podstawie deklaratywnych opisów struktur w pliku `.proto`.

## Rodzaj translatora
Kompilator (translator kod źródłowy → kod źródłowy). Tłumaczy deklaratywny kod `.proto` na postać obiektową ze ścisłym systemem typów w języku Java.

## Planowany wynik działania programu
Plik lub zestaw plików z wygenerowanym kodem źródłowym `.java`, z bezbłędnie odwzorowaną strukturą wiadomości, paczek i enumów z początkowego pliku `.proto`.

## Planowany język implementacji
Java (wersja 17).

## Generator parsera
ANTLR4 (wersja 4.13.2).

## Wspierane konstrukcje — przykłady

```protobuf
// Deklaracja składni i pakietu
syntax = "proto3";
package com.example;

// Enum na najwyższym poziomie
enum PhoneType {
  PHONE_TYPE_UNSPECIFIED = 0;
  MOBILE = 1;
  HOME = 2;
  WORK = 3;
}

// Prosta wiadomość z polem referencyjnym
message PhoneNumber {
  string number = 1;
  PhoneType type = 2;
}

// Złożona wiadomość: repeated, optional, nested message/enum, map, oneof, reserved
message Person {
  string name = 1;
  int32 id = 2;
  string email = 3;
  repeated PhoneNumber phones = 4;
  optional string nickname = 5;

  enum Visibility {
    PUBLIC = 0;
    PRIVATE = 1;
    FRIENDS_ONLY = 2;
  }

  Visibility visibility = 6;

  message Address {
    string street = 1;
    string city = 2;
    string state = 3;
    string zip_code = 4;
  }

  Address home_address = 7;
  map<string, string> attributes = 8;

  oneof contact_method {
    string phone = 9;
    string email_address = 10;
  }

  reserved 100, 200 to 300;
  reserved "old_field", "deprecated_field";
}

// Wiadomość z polem repeated innego typu
message AddressBook {
  repeated Person people = 1;
}
```

---

## Opis tokenów
Tokeny są podzielone na sześć kategorii: słowa kluczowe (top-level, modyfikatory pól, modyfikatory importu, typy skalarne), literały/identyfikatory, symbole/operatory oraz tokeny pomijane.
Wszystkie słowa kluczowe są case-sensitive.
Białe znaki, komentarze liniowe (`//`) i blokowe (`/* */`) są pomijane.

### Słowa kluczowe — najwyższy poziom

| Token | Wzorzec | Opis |
|-------|---------|------|
| `SYNTAX` | `syntax` | Deklaracja wersji składni |
| `IMPORT` | `import` | Import zewnętrznego pliku `.proto` |
| `PACKAGE` | `package` | Deklaracja pakietu |
| `OPTION` | `option` | Opcja kompilatora |
| `MESSAGE` | `message` | Definicja wiadomości (struktury) |
| `ENUM` | `enum` | Definicja typu wyliczeniowego |

### Słowa kluczowe — modyfikatory pól

| Token | Wzorzec | Opis |
|-------|---------|------|
| `REPEATED` | `repeated` | Pole powtarzalne (lista) |
| `OPTIONAL` | `optional` | Pole opcjonalne |
| `ONEOF` | `oneof` | Grupa pól wzajemnie wykluczających się |
| `MAP` | `map` | Pole mapowe |
| `RESERVED` | `reserved` | Zarezerwowane numery/nazwy pól |
| `TO` | `to` | Zakres w `reserved` |
| `MAX` | `max` | Maksymalna wartość zakresu |

### Słowa kluczowe — modyfikatory importu

| Token | Wzorzec | Opis |
|-------|---------|------|
| `PUBLIC` | `public` | Import publiczny |
| `WEAK` | `weak` | Import słaby |

### Słowa kluczowe — typy skalarne

| Token | Wzorzec | Opis |
|-------|---------|------|
| `DOUBLE` | `double` | Zmiennoprzecinkowy 64-bit |
| `FLOAT` | `float` | Zmiennoprzecinkowy 32-bit |
| `INT32` | `int32` | Liczba całkowita 32-bit ze znakiem |
| `INT64` | `int64` | Liczba całkowita 64-bit ze znakiem |
| `UINT32` | `uint32` | Liczba całkowita 32-bit bez znaku |
| `UINT64` | `uint64` | Liczba całkowita 64-bit bez znaku |
| `SINT32` | `sint32` | ZigZag 32-bit ze znakiem |
| `SINT64` | `sint64` | ZigZag 64-bit ze znakiem |
| `FIXED32` | `fixed32` | Stałoprzecinkowy 32-bit bez znaku |
| `FIXED64` | `fixed64` | Stałoprzecinkowy 64-bit bez znaku |
| `SFIXED32` | `sfixed32` | Stałoprzecinkowy 32-bit ze znakiem |
| `SFIXED64` | `sfixed64` | Stałoprzecinkowy 64-bit ze znakiem |
| `BOOL` | `bool` | Wartość logiczna |
| `STRING` | `string` | Łańcuch znaków UTF-8 |
| `BYTES` | `bytes` | Surowe bajty |

### Słowa kluczowe — literały logiczne

| Token | Wzorzec | Opis |
|-------|---------|------|
| `TRUE` | `true` | Wartość logiczna prawda |
| `FALSE` | `false` | Wartość logiczna fałsz |

### Literały i identyfikatory

| Token | Wzorzec (regex) | Przykłady | Opis |
|-------|-----------------|-----------|------|
| `IDENTIFIER` | `[a-zA-Z_][a-zA-Z0-9_]*` | `name`, `my_field` | Nazwa pola, wiadomości, enuma |
| `INTEGER_LITERAL` | `0[xX][0-9a-fA-F]+` \| `0[0-7]*` \| `[1-9][0-9]*` | `42`, `0xFF`, `077` | Liczba: dziesiętna, hex, ósemkowa |
| `FLOAT_LITERAL` | `[0-9]+'.'[0-9]*` \| `'.'[0-9]+` \| `inf` \| `nan` | `3.14`, `.5`, `inf` | Liczba zmiennoprzecinkowa |
| `STRING_LITERAL` | `"..."` lub `'...'` z obsługą `\`-escape | `"hello"`, `'world'` | Łańcuch znaków |

### Symbole i operatory

| Token | Leksem | Opis |
|-------|--------|------|
| `LBRACE` | `{` | Nawias klamrowy otwierający |
| `RBRACE` | `}` | Nawias klamrowy zamykający |
| `LPAREN` | `(` | Nawias okrągły otwierający |
| `RPAREN` | `)` | Nawias okrągły zamykający |
| `LBRACKET` | `[` | Nawias kwadratowy otwierający |
| `RBRACKET` | `]` | Nawias kwadratowy zamykający |
| `LANGLE` | `<` | Nawias kątowy otwierający |
| `RANGLE` | `>` | Nawias kątowy zamykający |
| `SEMI` | `;` | Średnik |
| `COMMA` | `,` | Przecinek |
| `DOT` | `.` | Separator segmentów ścieżki |
| `EQ` | `=` | Przypisanie numeru pola |
| `MINUS` | `-` | Minus / negacja |
| `PLUS` | `+` | Plus |

### Tokeny pomijane

| Token | Wzorzec | Opis |
|-------|---------|------|
| `WS` | `[ \t\r\n]+` | Białe znaki — pomijane |
| `LINE_COMMENT` | `'//' ~[\r\n]*` | Komentarz liniowy — pomijany |
| `BLOCK_COMMENT` | `'/*' .*? '*/'` | Komentarz blokowy — pomijany |

---

## Gramatyka w notacji ANTLR4
Pełny plik gramatyki: `src/compiler/parser/Proto3.g4`

Poniżej opis struktury gramatyki z komentarzem do kluczowych decyzji.

### Reguły parsera

```antlr
grammar Proto3;

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

// ── nagłówek ──

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

// ── identyfikatory ──

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

typeReference
    : DOT? IDENTIFIER (DOT IDENTIFIER)*
    ;

// ── stałe i typy ──

constant
    : fullIdent
    | (MINUS | PLUS)? INTEGER_LITERAL
    | (MINUS | PLUS)? FLOAT_LITERAL
    | STRING_LITERAL
    | TRUE
    | FALSE
    ;

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

// ── pola ──

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

// ── oneof ──

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

// ── map ──

mapField
    : MAP LANGLE keyType COMMA type_ RANGLE
      IDENTIFIER EQ fieldNumber fieldOptions? SEMI
    ;

// ── reserved ──

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

// ── message ──

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

// ── enum ──

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
```

### Reguły leksera

```antlr
// Słowa kluczowe (case-sensitive, przed IDENTIFIER)
SYNTAX   : 'syntax';    IMPORT   : 'import';
PACKAGE  : 'package';   OPTION   : 'option';
MESSAGE  : 'message';   ENUM     : 'enum';

REPEATED : 'repeated';  OPTIONAL : 'optional';
ONEOF    : 'oneof';     MAP      : 'map';
RESERVED : 'reserved';  TO       : 'to';
MAX      : 'max';       PUBLIC   : 'public';
WEAK     : 'weak';

// Typy skalarne
DOUBLE : 'double';  FLOAT  : 'float';
INT32  : 'int32';   INT64  : 'int64';
UINT32 : 'uint32';  UINT64 : 'uint64';
SINT32 : 'sint32';  SINT64 : 'sint64';
FIXED32  : 'fixed32';  FIXED64  : 'fixed64';
SFIXED32 : 'sfixed32'; SFIXED64 : 'sfixed64';
BOOL   : 'bool';    STRING : 'string';   BYTES : 'bytes';

TRUE  : 'true';  FALSE : 'false';

// Symbole
LBRACE : '{';  RBRACE : '}';  LPAREN : '(';  RPAREN : ')';
LBRACKET : '[';  RBRACKET : ']';  LANGLE : '<';  RANGLE : '>';
SEMI : ';';  COMMA : ',';  DOT : '.';  EQ : '=';
MINUS : '-';  PLUS : '+';

// Literały
STRING_LITERAL : '"'  ( '\\' . | ~["\\] )* '"'
               | '\'' ( '\\' . | ~['\\] )* '\'' ;
FLOAT_LITERAL  : [0-9]+ '.' [0-9]* ([eE] [+-]? [0-9]+)?
               | [0-9]+ [eE] [+-]? [0-9]+
               | '.' [0-9]+ ([eE] [+-]? [0-9]+)?
               | 'inf' | 'nan' ;
INTEGER_LITERAL : '0' [xX] [0-9a-fA-F]+
                | '0' [0-7]*
                | [1-9] [0-9]* ;
IDENTIFIER : [a-zA-Z_] [a-zA-Z0-9_]* ;

// Pomijane
LINE_COMMENT  : '//' ~[\r\n]* -> skip ;
BLOCK_COMMENT : '/*' .*? '*/' -> skip ;
WS            : [ \t\r\n]+    -> skip ;
```

---

## Instalacja i uruchomienie

### Wymagania
- Java ≥ 17
- Maven ≥ 3.8

### Budowanie

```bash
# Sklonuj repozytorium i zbuduj projekt
mvn clean compile

# Plugin ANTLR4 automatycznie wygeneruje lexer/parser z gramatyki Proto3.g4
```

### Uruchomienie

```bash
# Kompilacja pliku .proto → pliki .java (domyślny katalog wyjściowy: output)
mvn exec:java -Dexec.args="test/example.proto"

# Kompilacja z podaniem katalogu wyjściowego
mvn exec:java -Dexec.args="test/example.proto test/output_antlr"
```

### Pomoc

```bash
# Bez argumentów — wyświetla pomoc
mvn exec:java
```

```
╔══════════════════════════════════════════════════════╗
║     Protobuf proto3 → Java Compiler                 ║
║     Authors: Mikhail Danilau, Roman Chmirou          ║
╚══════════════════════════════════════════════════════╝

Usage: java Main <input.proto> [output_directory]

  <input.proto>       Path to the .proto file to compile
  [output_directory]  Directory for generated .java files (default: ./output)
```

## Przykład wyjścia

Dla pliku `test/example.proto`:

```protobuf
syntax = "proto3";

package com.example;

enum PhoneType {
  PHONE_TYPE_UNSPECIFIED = 0;
  MOBILE = 1;
  HOME = 2;
  WORK = 3;
}

message PhoneNumber {
  string number = 1;
  PhoneType type = 2;
}

message Person {
  string name = 1;
  int32 id = 2;
  string email = 3;
  repeated PhoneNumber phones = 4;
  optional string nickname = 5;

  enum Visibility {
    PUBLIC = 0;
    PRIVATE = 1;
    FRIENDS_ONLY = 2;
  }

  Visibility visibility = 6;

  message Address {
    string street = 1;
    string city = 2;
    string state = 3;
    string zip_code = 4;
  }

  Address home_address = 7;
  map<string, string> attributes = 8;

  oneof contact_method {
    string phone = 9;
    string email_address = 10;
  }

  reserved 100, 200 to 300;
  reserved "old_field", "deprecated_field";
}

message AddressBook {
  repeated Person people = 1;
}
```

Kompilator generuje **4 pliki `.java`** w katalogu wyjściowym:

### `PhoneType.java` — enum najwyższego poziomu

```java
package com.example;

public enum PhoneType {
    PHONE_TYPE_UNSPECIFIED(0),
    MOBILE(1),
    HOME(2),
    WORK(3);

    private final int number;

    PhoneType(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public static PhoneType forNumber(int value) {
        for (PhoneType e : values()) {
            if (e.number == value) return e;
        }
        return null;
    }
}
```

### `PhoneNumber.java` — prosta wiadomość z polem referencyjnym

```java
package com.example;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Objects;

public class PhoneNumber {

    private String number;
    private PhoneType type;

    public PhoneNumber() {}

    public String getNumber() { return this.number; }
    public void setNumber(String number) { this.number = number; }

    public PhoneType getType() { return this.type; }
    public void setType(PhoneType type) { this.type = type; }

    @Override
    public String toString() {
        return "PhoneNumber{" +
            "number=" + number + ", " +
            "type=" + type +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNumber that = (PhoneNumber) o;
        return Objects.equals(number, that.number) &&
            Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, type);
    }
}
```

### `Person.java` — złożona wiadomość (nested enum, nested message, map, oneof)

```java
package com.example;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import com.example.PhoneNumber;

public class Person {

    public enum Visibility {
        PUBLIC(0),
        PRIVATE(1),
        FRIENDS_ONLY(2);

        private final int number;

        Visibility(int number) { this.number = number; }
        public int getNumber() { return number; }

        public static Visibility forNumber(int value) {
            for (Visibility e : values()) {
                if (e.number == value) return e;
            }
            return null;
        }
    }

    public static class Address {
        private String street;
        private String city;
        private String state;
        private String zip_code;

        public Address() {}

        public String getStreet() { return this.street; }
        public void setStreet(String street) { this.street = street; }

        public String getCity() { return this.city; }
        public void setCity(String city) { this.city = city; }

        public String getState() { return this.state; }
        public void setState(String state) { this.state = state; }

        public String getZip_code() { return this.zip_code; }
        public void setZip_code(String zip_code) { this.zip_code = zip_code; }

        @Override
        public String toString() { /* ... */ }

        @Override
        public boolean equals(Object o) { /* ... */ }

        @Override
        public int hashCode() { return Objects.hash(street, city, state, zip_code); }
    }

    private String name;
    private int id;
    private String email;
    private List<PhoneNumber> phones;
    private String nickname;
    private Visibility visibility;
    private Address home_address;
    private Map<String, String> attributes = new HashMap<>();

    // ── oneof contact_method ──
    public enum Contact_methodCase {
        CONTACT_METHOD_NOT_SET, PHONE, EMAIL_ADDRESS,
    }

    private Contact_methodCase contact_methodCase = Contact_methodCase.CONTACT_METHOD_NOT_SET;
    private String phone;
    private String email_address;

    public Person() {}

    // gettery, settery, toString, equals, hashCode …
}
```

### `AddressBook.java` — wiadomość z polem `repeated` innego typu

```java
package com.example;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Objects;

public class AddressBook {

    private List<Person> people;

    public AddressBook() {}

    public List<Person> getPeople() { return this.people; }
    public void setPeople(List<Person> people) { this.people = people; }

    @Override
    public String toString() {
        return "AddressBook{" +
            "people=" + people +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressBook that = (AddressBook) o;
        return Objects.equals(people, that.people);
    }

    @Override
    public int hashCode() {
        return Objects.hash(people);
    }
}
```

---

## Przykłady diagnostyki błędów

Poniższe komendy celowo zawierają błędy i pokazują diagnostykę na poziomie parsera.

```bash
# Błąd: brakujący średnik po deklaracji syntax
# syntax = "proto3"    ← brak ;
mvn exec:java -Dexec.args="test/error_example.proto"

# Błąd: brak '=' między nazwą pola a numerem
# int32 id 2;          ← brak =

# Błąd: brak zamykającego nawiasu klamrowego '}'
# message IncompleteMessage { ... ← brak }

# Błąd: identyfikator zamiast numeru pola
# string value = abc;  ← oczekiwano INTEGER_LITERAL

# Błąd: nieoczekiwany token na najwyższym poziomie
# 123illegal_top_level ← parser oczekuje message, enum, import, ...
```

Przykładowy format błędu:

```
Parse error at line 14:19 — missing ';' at 'package'
```

## Struktura projektu

```
Compilators/
├── pom.xml                                  # Konfiguracja Maven + ANTLR4 plugin
├── src/
│   └── compiler/
│       ├── parser/
│       │   ├── Proto3.g4                    # Gramatyka ANTLR4 (combined)
│       │   └── ASTBuilder.java              # Visitor: Parse Tree → AST
│       ├── ast/
│       │   ├── ProtoFile.java               # Węzeł AST: cały plik proto
│       │   ├── MessageDef.java              # Węzeł AST: message
│       │   ├── FieldDef.java                # Węzeł AST: pole
│       │   ├── EnumDef.java                 # Węzeł AST: enum
│       │   ├── EnumValue.java               # Węzeł AST: wartość enum
│       │   ├── MapFieldDef.java             # Węzeł AST: pole map
│       │   ├── OneofDef.java                # Węzeł AST: oneof
│       │   ├── ImportStatement.java         # Węzeł AST: import
│       │   ├── OptionStatement.java         # Węzeł AST: option
│       │   └── ReservedDef.java             # Węzeł AST: reserved
│       └── codegen/
│           └── JavaCodeGenerator.java       # Generator kodu Java z AST
├── main/
│   └── src/
│       └── Main.java                        # Punkt wejścia programu
└── test/
    ├── example.proto                        # Przykładowy plik .proto (poprawny)
    ├── error_example.proto                  # Plik z celowymi błędami składni
    ├── output/                              # Wygenerowane pliki .java (stary parser)
    └── output_antlr/                        # Wygenerowane pliki .java (ANTLR4)
```

## Użyte technologie

| Komponent | Technologia |
|-----------|------------|
| Generator parsera | ANTLR4 (4.13.2) |
| Język implementacji | Java 17 |
| System budowania | Maven |
| Wzorzec budowy AST | Visitor (ANTLR4 BaseVisitor) |

---

> Na podstawie [Protocol Buffers Language Specification (Proto3)](https://protobuf.dev/reference/protobuf/proto3-spec/).
> Powyższa gramatyka i zestaw tokenów pokrywają pełną składnię proto3 wymaganą do translacji na klasy Java.
