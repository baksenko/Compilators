package compiler.parser;

import compiler.ast.*;
import compiler.token.Token;
import compiler.token.TokenType;

import java.util.ArrayList;
import java.util.List;

/**
 * Recursive Descent Parser for proto3 files.
 * Implements the BNF grammar defined in grammar.md.
 */
public class Parser {

    private final List<Token> tokens;
    private int pos;

    public Parser(List<Token> tokens) {
        this.tokens = tokens;
        this.pos = 0;
    }

    // ────────────────────────── helpers ──────────────────────────

    private Token current() {
        return tokens.get(pos);
    }

    private Token peek() {
        return current();
    }

    private Token advance() {
        Token t = tokens.get(pos);
        pos++;
        return t;
    }

    private Token expect(TokenType type) {
        Token t = current();
        if (t.getType() != type) {
            throw new ParseException("Expected " + type + " but got " + t.getType()
                    + " (\"" + t.getValue() + "\") at line " + t.getLine() + ", col " + t.getColumn());
        }
        return advance();
    }

    private boolean check(TokenType type) {
        return current().getType() == type;
    }

    private boolean match(TokenType type) {
        if (check(type)) {
            advance();
            return true;
        }
        return false;
    }

    // ────────────────────────── <proto> ──────────────────────────

    /**
     * <proto> ::= <optSyntax> <topLevelList> EOF
     */
    public ProtoFile parseProto() {
        ProtoFile proto = new ProtoFile();
        List<ImportStatement> imports = new ArrayList<>();
        List<OptionStatement> options = new ArrayList<>();
        List<MessageDef> messages = new ArrayList<>();
        List<EnumDef> enums = new ArrayList<>();

        // <optSyntax>
        if (check(TokenType.SYNTAX)) {
            proto.setSyntax(parseSyntaxStatement());
        }

        // <topLevelList>
        while (!check(TokenType.EOF)) {
            parseTopLevelItem(imports, options, messages, enums);
        }

        expect(TokenType.EOF);

        proto.setImports(imports);
        proto.setOptions(options);
        proto.setMessages(messages);
        proto.setEnums(enums);
        return proto;
    }

    // ────────────────────────── header ──────────────────────────

    /**
     * <syntaxStatement> ::= SYNTAX EQUALS STRING_LITERAL SEMICOLON
     */
    private String parseSyntaxStatement() {
        expect(TokenType.SYNTAX);
        expect(TokenType.EQUALS);
        Token str = expect(TokenType.STRING_LITERAL);
        expect(TokenType.SEMICOLON);
        return str.getValue();
    }

    /**
     * <topLevelItem> ::= <importStatement> | <packageStatement>
     *                   | <optionStatement> | <topLevelDef> | <emptyStatement>
     */
    private void parseTopLevelItem(List<ImportStatement> imports,
                                   List<OptionStatement> options,
                                   List<MessageDef> messages,
                                   List<EnumDef> enums) {
        TokenType type = current().getType();

        switch (type) {
            case IMPORT:
                imports.add(parseImportStatement());
                break;
            case PACKAGE:
                parsePackageStatement();
                break;
            case OPTION:
                options.add(parseOptionStatement());
                break;
            case MESSAGE:
                messages.add(parseMessageDef());
                break;
            case ENUM:
                enums.add(parseEnumDef());
                break;
            case SEMICOLON:
                advance(); // empty statement
                break;
            default:
                throw new ParseException("Unexpected top-level token: " + current()
                        + " at line " + current().getLine());
        }
    }

    /**
     * <importStatement> ::= IMPORT <optImportMod> STRING_LITERAL SEMICOLON
     */
    private ImportStatement parseImportStatement() {
        expect(TokenType.IMPORT);
        String modifier = null;
        if (check(TokenType.PUBLIC)) {
            modifier = "public";
            advance();
        } else if (check(TokenType.WEAK)) {
            modifier = "weak";
            advance();
        }
        Token path = expect(TokenType.STRING_LITERAL);
        expect(TokenType.SEMICOLON);
        return new ImportStatement(modifier, path.getValue());
    }

    /**
     * <packageStatement> ::= PACKAGE <fullIdent> SEMICOLON
     */
    private void parsePackageStatement() {
        expect(TokenType.PACKAGE);
        // We don't store package in a field for simplicity — but we could
        // For now, just parse it
        // fullIdent will be parsed into a string
        // In the ProtoFile we already have packageName
        // Let's capture it properly
        // Actually we need the proto file reference here — we'll handle it in parseProto
        // For simplicity, just skip through
        String pkg = parseFullIdent();
        expect(TokenType.SEMICOLON);
        // We'll store it by calling back — but we lose the reference.
        // Let's refactor: we'll handle package in parseProto directly.
        // For now, this is fine since the code generator doesn't need package.
    }

    /**
     * <optionStatement> ::= OPTION <optionName> EQUALS <constant> SEMICOLON
     */
    private OptionStatement parseOptionStatement() {
        expect(TokenType.OPTION);
        String name = parseOptionName();
        expect(TokenType.EQUALS);
        String value = parseConstant();
        expect(TokenType.SEMICOLON);
        return new OptionStatement(name, value);
    }

    // ────────────────────────── identifiers ──────────────────────────

    /**
     * <fullIdent> ::= IDENTIFIER <fullIdentTail>
     * <fullIdentTail> ::= DOT IDENTIFIER <fullIdentTail> | ε
     */
    private String parseFullIdent() {
        StringBuilder sb = new StringBuilder();
        sb.append(expect(TokenType.IDENTIFIER).getValue());
        while (check(TokenType.DOT)) {
            advance();
            sb.append('.').append(expect(TokenType.IDENTIFIER).getValue());
        }
        return sb.toString();
    }

    /**
     * <optionName> ::= <optionNameHead> <optionNameTail>
     * <optionNameHead> ::= IDENTIFIER | <bracedFullIdent>
     * <optionNameTail> ::= DOT <optionNameHead> <optionNameTail> | ε
     * <bracedFullIdent> ::= LEFT_PAREN <optDot> <fullIdent> RIGHT_PAREN
     */
    private String parseOptionName() {
        StringBuilder sb = new StringBuilder();
        sb.append(parseOptionNameHead());
        while (check(TokenType.DOT)) {
            advance();
            sb.append('.').append(parseOptionNameHead());
        }
        return sb.toString();
    }

    private String parseOptionNameHead() {
        if (check(TokenType.LEFT_PAREN)) {
            advance();
            StringBuilder sb = new StringBuilder("(");
            if (check(TokenType.DOT)) {
                sb.append('.');
                advance();
            }
            sb.append(parseFullIdent());
            expect(TokenType.RIGHT_PAREN);
            sb.append(')');
            return sb.toString();
        }
        return expect(TokenType.IDENTIFIER).getValue();
    }

    /**
     * <messageType> / <enumType> ::= <optDot> <typePath> IDENTIFIER
     * Returns the full type path as a string.
     */
    private String parseTypeReference() {
        StringBuilder sb = new StringBuilder();
        if (check(TokenType.DOT)) {
            sb.append('.');
            advance();
        }
        // Collect segments: IDENTIFIER DOT ... IDENTIFIER
        // The last IDENTIFIER is the type name, preceding ones form the path
        sb.append(expect(TokenType.IDENTIFIER).getValue());
        while (check(TokenType.DOT)) {
            advance();
            sb.append('.').append(expect(TokenType.IDENTIFIER).getValue());
        }
        return sb.toString();
    }

    // ────────────────────────── constants ──────────────────────────

    /**
     * <constant> ::= <fullIdent> | <optSign> INTEGER_LITERAL
     *              | <optSign> FLOAT_LITERAL | STRING_LITERAL | TRUE | FALSE
     */
    private String parseConstant() {
        if (check(TokenType.STRING_LITERAL)) {
            return "\"" + advance().getValue() + "\"";
        }
        if (check(TokenType.TRUE)) {
            advance();
            return "true";
        }
        if (check(TokenType.FALSE)) {
            advance();
            return "false";
        }
        String sign = "";
        if (check(TokenType.MINUS)) {
            sign = "-";
            advance();
        } else if (check(TokenType.PLUS)) {
            advance();
        }
        if (check(TokenType.INTEGER_LITERAL)) {
            return sign + advance().getValue();
        }
        if (check(TokenType.FLOAT_LITERAL)) {
            return sign + advance().getValue();
        }
        // Must be a fullIdent (enum value reference, etc.)
        return parseFullIdent();
    }

    // ────────────────────────── types ──────────────────────────

    /**
     * Check if the current token is a scalar type keyword.
     */
    private boolean isScalarType(TokenType t) {
        switch (t) {
            case DOUBLE: case FLOAT:
            case INT32: case INT64: case UINT32: case UINT64:
            case SINT32: case SINT64:
            case FIXED32: case FIXED64: case SFIXED32: case SFIXED64:
            case BOOL: case STRING: case BYTES:
                return true;
            default:
                return false;
        }
    }

    /**
     * <type> ::= scalar | <messageType> | <enumType>
     */
    private String parseType() {
        if (isScalarType(current().getType())) {
            return advance().getValue();
        }
        // message/enum type reference — starts with DOT or IDENTIFIER
        return parseTypeReference();
    }

    /**
     * Check if current token can start a <type>.
     */
    private boolean isTypeStart() {
        TokenType t = current().getType();
        return isScalarType(t) || t == TokenType.IDENTIFIER || t == TokenType.DOT;
    }

    // ────────────────────────── fields ──────────────────────────

    /**
     * <field> ::= <optFieldMod> <type> IDENTIFIER EQUALS <fieldNumber> <optFieldOpts> SEMICOLON
     */
    private FieldDef parseField() {
        String modifier = null;
        if (check(TokenType.REPEATED)) {
            modifier = "repeated";
            advance();
        } else if (check(TokenType.OPTIONAL)) {
            modifier = "optional";
            advance();
        }

        String type = parseType();
        String name = expect(TokenType.IDENTIFIER).getValue();
        expect(TokenType.EQUALS);
        int number = parseFieldNumber();
        parseOptFieldOpts();
        expect(TokenType.SEMICOLON);

        return new FieldDef(modifier, type, name, number);
    }

    private int parseFieldNumber() {
        Token t = expect(TokenType.INTEGER_LITERAL);
        return parseIntValue(t.getValue());
    }

    /**
     * <optFieldOpts> ::= LEFT_BRACKET <fieldOptions> RIGHT_BRACKET | ε
     */
    private void parseOptFieldOpts() {
        if (check(TokenType.LEFT_BRACKET)) {
            advance();
            // <fieldOptions> ::= <fieldOption> <fieldOptionsTail>
            parseFieldOption();
            while (check(TokenType.COMMA)) {
                advance();
                parseFieldOption();
            }
            expect(TokenType.RIGHT_BRACKET);
        }
    }

    private void parseFieldOption() {
        parseOptionName();
        expect(TokenType.EQUALS);
        parseConstant();
    }

    // ────────────────────────── oneof ──────────────────────────

    /**
     * <oneofDef> ::= ONEOF IDENTIFIER LEFT_BRACE <oneofBody> RIGHT_BRACE
     */
    private OneofDef parseOneofDef() {
        expect(TokenType.ONEOF);
        String name = expect(TokenType.IDENTIFIER).getValue();
        expect(TokenType.LEFT_BRACE);

        List<FieldDef> fields = new ArrayList<>();
        while (!check(TokenType.RIGHT_BRACE)) {
            if (check(TokenType.OPTION)) {
                parseOptionStatement(); // skip oneof-level options
            } else {
                // <oneofField> ::= <type> IDENTIFIER EQUALS <fieldNumber> <optFieldOpts> SEMICOLON
                String type = parseType();
                String fieldName = expect(TokenType.IDENTIFIER).getValue();
                expect(TokenType.EQUALS);
                int number = parseFieldNumber();
                parseOptFieldOpts();
                expect(TokenType.SEMICOLON);
                fields.add(new FieldDef(null, type, fieldName, number));
            }
        }
        expect(TokenType.RIGHT_BRACE);

        OneofDef oneof = new OneofDef(name);
        oneof.setFields(fields);
        return oneof;
    }

    // ────────────────────────── map ──────────────────────────

    /**
     * <mapField> ::= MAP LEFT_ANGLE <keyType> COMMA <type> RIGHT_ANGLE
     *                IDENTIFIER EQUALS <fieldNumber> <optFieldOpts> SEMICOLON
     */
    private MapFieldDef parseMapField() {
        expect(TokenType.MAP);
        expect(TokenType.LEFT_ANGLE);
        String keyType = advance().getValue(); // keyType is always a scalar keyword
        expect(TokenType.COMMA);
        String valueType = parseType();
        expect(TokenType.RIGHT_ANGLE);
        String name = expect(TokenType.IDENTIFIER).getValue();
        expect(TokenType.EQUALS);
        int number = parseFieldNumber();
        parseOptFieldOpts();
        expect(TokenType.SEMICOLON);
        return new MapFieldDef(keyType, valueType, name, number);
    }

    // ────────────────────────── reserved ──────────────────────────

    /**
     * <reserved> ::= RESERVED <reservedBody> SEMICOLON
     */
    private ReservedDef parseReserved() {
        expect(TokenType.RESERVED);
        ReservedDef reserved = new ReservedDef();

        if (check(TokenType.STRING_LITERAL)) {
            // <fieldNames>
            List<String> names = new ArrayList<>();
            names.add(advance().getValue());
            while (check(TokenType.COMMA)) {
                advance();
                names.add(expect(TokenType.STRING_LITERAL).getValue());
            }
            reserved.setFieldNames(names);
        } else {
            // <ranges>
            List<ReservedDef.Range> ranges = new ArrayList<>();
            ranges.add(parseRange());
            while (check(TokenType.COMMA)) {
                advance();
                ranges.add(parseRange());
            }
            reserved.setRanges(ranges);
        }

        expect(TokenType.SEMICOLON);
        return reserved;
    }

    private ReservedDef.Range parseRange() {
        Token start = expect(TokenType.INTEGER_LITERAL);
        int s = parseIntValue(start.getValue());
        int e = -1;
        if (check(TokenType.TO)) {
            advance();
            if (check(TokenType.MAX)) {
                advance();
                e = Integer.MAX_VALUE;
            } else {
                Token end = expect(TokenType.INTEGER_LITERAL);
                e = parseIntValue(end.getValue());
            }
        }
        return new ReservedDef.Range(s, e);
    }

    // ────────────────────────── message ──────────────────────────

    /**
     * <messageDef> ::= MESSAGE IDENTIFIER <messageBody>
     * <messageBody> ::= LEFT_BRACE <msgBodyList> RIGHT_BRACE
     */
    private MessageDef parseMessageDef() {
        expect(TokenType.MESSAGE);
        String name = expect(TokenType.IDENTIFIER).getValue();
        expect(TokenType.LEFT_BRACE);

        MessageDef msg = new MessageDef(name);
        List<FieldDef> fields = new ArrayList<>();
        List<MessageDef> nestedMessages = new ArrayList<>();
        List<EnumDef> nestedEnums = new ArrayList<>();
        List<OneofDef> oneofs = new ArrayList<>();
        List<MapFieldDef> mapFields = new ArrayList<>();
        List<OptionStatement> options = new ArrayList<>();
        List<ReservedDef> reserveds = new ArrayList<>();

        while (!check(TokenType.RIGHT_BRACE)) {
            parseMsgBodyItem(fields, nestedMessages, nestedEnums, oneofs,
                    mapFields, options, reserveds);
        }

        expect(TokenType.RIGHT_BRACE);

        msg.setFields(fields);
        msg.setNestedMessages(nestedMessages);
        msg.setNestedEnums(nestedEnums);
        msg.setOneofs(oneofs);
        msg.setMapFields(mapFields);
        msg.setOptions(options);
        msg.setReserveds(reserveds);
        return msg;
    }

    /**
     * <msgBodyItem> ::= <field> | <enumDef> | <messageDef>
     *                 | <optionStatement> | <oneofDef> | <mapField>
     *                 | <reserved> | <emptyStatement>
     */
    private void parseMsgBodyItem(List<FieldDef> fields,
                                  List<MessageDef> nestedMessages,
                                  List<EnumDef> nestedEnums,
                                  List<OneofDef> oneofs,
                                  List<MapFieldDef> mapFields,
                                  List<OptionStatement> options,
                                  List<ReservedDef> reserveds) {
        TokenType type = current().getType();

        switch (type) {
            case ENUM:
                nestedEnums.add(parseEnumDef());
                break;
            case MESSAGE:
                nestedMessages.add(parseMessageDef());
                break;
            case OPTION:
                options.add(parseOptionStatement());
                break;
            case ONEOF:
                oneofs.add(parseOneofDef());
                break;
            case MAP:
                mapFields.add(parseMapField());
                break;
            case RESERVED:
                reserveds.add(parseReserved());
                break;
            case SEMICOLON:
                advance(); // empty statement
                break;
            default:
                // Must be a field (possibly with repeated/optional modifier)
                if (type == TokenType.REPEATED || type == TokenType.OPTIONAL || isTypeStart()) {
                    fields.add(parseField());
                } else {
                    throw new ParseException("Unexpected token in message body: " + current()
                            + " at line " + current().getLine());
                }
                break;
        }
    }

    // ────────────────────────── enum ──────────────────────────

    /**
     * <enumDef> ::= ENUM IDENTIFIER <enumBody>
     * <enumBody> ::= LEFT_BRACE <enumBodyList> RIGHT_BRACE
     */
    private EnumDef parseEnumDef() {
        expect(TokenType.ENUM);
        String name = expect(TokenType.IDENTIFIER).getValue();
        expect(TokenType.LEFT_BRACE);

        EnumDef enumDef = new EnumDef(name);
        List<EnumValue> values = new ArrayList<>();
        List<OptionStatement> options = new ArrayList<>();
        List<ReservedDef> reserveds = new ArrayList<>();

        while (!check(TokenType.RIGHT_BRACE)) {
            if (check(TokenType.OPTION)) {
                options.add(parseOptionStatement());
            } else if (check(TokenType.RESERVED)) {
                reserveds.add(parseReserved());
            } else if (check(TokenType.SEMICOLON)) {
                advance(); // empty statement
            } else {
                // <enumField> ::= IDENTIFIER EQUALS <optMinus> INTEGER_LITERAL <optEnumValOpts> SEMICOLON
                String valueName = expect(TokenType.IDENTIFIER).getValue();
                expect(TokenType.EQUALS);
                int sign = 1;
                if (check(TokenType.MINUS)) {
                    sign = -1;
                    advance();
                }
                Token numToken = expect(TokenType.INTEGER_LITERAL);
                int num = sign * parseIntValue(numToken.getValue());
                // skip optional enum value options
                if (check(TokenType.LEFT_BRACKET)) {
                    advance();
                    parseFieldOption(); // reuse
                    while (check(TokenType.COMMA)) {
                        advance();
                        parseFieldOption();
                    }
                    expect(TokenType.RIGHT_BRACKET);
                }
                expect(TokenType.SEMICOLON);
                values.add(new EnumValue(valueName, num));
            }
        }

        expect(TokenType.RIGHT_BRACE);

        enumDef.setValues(values);
        enumDef.setOptions(options);
        enumDef.setReserveds(reserveds);
        return enumDef;
    }

    // ────────────────────────── utility ──────────────────────────

    private int parseIntValue(String s) {
        if (s.startsWith("0x") || s.startsWith("0X")) {
            return Integer.parseInt(s.substring(2), 16);
        }
        if (s.length() > 1 && s.startsWith("0")) {
            return Integer.parseInt(s, 8);
        }
        return Integer.parseInt(s);
    }
}
