package compiler.parser;

import compiler.ast.*;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Visitor that walks the ANTLR4 parse tree produced by Proto3Parser
 * and constructs the existing AST node hierarchy.
 *
 * This is the bridge between ANTLR-generated parse tree and
 * the project's AST classes (ProtoFile, MessageDef, FieldDef, etc.).
 * The JavaCodeGenerator continues to consume the same AST — no changes needed there.
 */
public class ASTBuilder extends Proto3BaseVisitor<Object> {

    // ────────────────────────── proto file ──────────────────────────

    @Override
    public ProtoFile visitProto(Proto3Parser.ProtoContext ctx) {
        ProtoFile proto = new ProtoFile();
        List<ImportStatement> imports = new ArrayList<>();
        List<OptionStatement> options = new ArrayList<>();
        List<MessageDef> messages = new ArrayList<>();
        List<EnumDef> enums = new ArrayList<>();

        // Syntax
        if (ctx.syntaxStatement() != null) {
            proto.setSyntax(visitSyntaxStatement(ctx.syntaxStatement()));
        }

        // Top-level items
        for (Proto3Parser.TopLevelItemContext item : ctx.topLevelItem()) {
            if (item.importStatement() != null) {
                imports.add(visitImportStatement(item.importStatement()));
            } else if (item.packageStatement() != null) {
                String pkg = visitPackageStatement(item.packageStatement());
                proto.setPackageName(pkg);
            } else if (item.optionStatement() != null) {
                options.add(visitOptionStatement(item.optionStatement()));
            } else if (item.messageDef() != null) {
                messages.add(visitMessageDef(item.messageDef()));
            } else if (item.enumDef() != null) {
                enums.add(visitEnumDef(item.enumDef()));
            }
            // emptyStatement — skip
        }

        proto.setImports(imports);
        proto.setOptions(options);
        proto.setMessages(messages);
        proto.setEnums(enums);
        return proto;
    }

    // ────────────────────────── header ──────────────────────────

    @Override
    public String visitSyntaxStatement(Proto3Parser.SyntaxStatementContext ctx) {
        return stripQuotes(ctx.STRING_LITERAL().getText());
    }

    public String visitPackageStatement(Proto3Parser.PackageStatementContext ctx) {
        return ctx.fullIdent().getText();
    }

    @Override
    public ImportStatement visitImportStatement(Proto3Parser.ImportStatementContext ctx) {
        String modifier = null;
        if (ctx.importModifier() != null) {
            modifier = ctx.importModifier().getText();
        }
        String path = stripQuotes(ctx.STRING_LITERAL().getText());
        return new ImportStatement(modifier, path);
    }

    @Override
    public OptionStatement visitOptionStatement(Proto3Parser.OptionStatementContext ctx) {
        String name = ctx.optionName().getText();
        String value = extractConstant(ctx.constant());
        return new OptionStatement(name, value);
    }

    // ────────────────────────── message ──────────────────────────

    @Override
    public MessageDef visitMessageDef(Proto3Parser.MessageDefContext ctx) {
        String name = ctx.IDENTIFIER().getText();
        MessageDef msg = new MessageDef(name);

        List<FieldDef> fields = new ArrayList<>();
        List<MessageDef> nestedMessages = new ArrayList<>();
        List<EnumDef> nestedEnums = new ArrayList<>();
        List<OneofDef> oneofs = new ArrayList<>();
        List<MapFieldDef> mapFields = new ArrayList<>();
        List<OptionStatement> options = new ArrayList<>();
        List<ReservedDef> reserveds = new ArrayList<>();

        for (Proto3Parser.MessageBodyItemContext item : ctx.messageBody().messageBodyItem()) {
            if (item.field() != null) {
                fields.add(visitField(item.field()));
            } else if (item.messageDef() != null) {
                nestedMessages.add(visitMessageDef(item.messageDef()));
            } else if (item.enumDef() != null) {
                nestedEnums.add(visitEnumDef(item.enumDef()));
            } else if (item.oneofDef() != null) {
                oneofs.add(visitOneofDef(item.oneofDef()));
            } else if (item.mapField() != null) {
                mapFields.add(visitMapField(item.mapField()));
            } else if (item.optionStatement() != null) {
                options.add(visitOptionStatement(item.optionStatement()));
            } else if (item.reserved() != null) {
                reserveds.add(visitReserved(item.reserved()));
            }
            // emptyStatement — skip
        }

        msg.setFields(fields);
        msg.setNestedMessages(nestedMessages);
        msg.setNestedEnums(nestedEnums);
        msg.setOneofs(oneofs);
        msg.setMapFields(mapFields);
        msg.setOptions(options);
        msg.setReserveds(reserveds);
        return msg;
    }

    // ────────────────────────── fields ──────────────────────────

    @Override
    public FieldDef visitField(Proto3Parser.FieldContext ctx) {
        String modifier = null;
        if (ctx.fieldModifier() != null) {
            modifier = ctx.fieldModifier().getText();
        }
        String type = extractType(ctx.type_());
        String name = ctx.IDENTIFIER().getText();
        int number = parseFieldNumber(ctx.fieldNumber());
        return new FieldDef(modifier, type, name, number);
    }

    // ────────────────────────── map ──────────────────────────

    @Override
    public MapFieldDef visitMapField(Proto3Parser.MapFieldContext ctx) {
        String keyType = ctx.keyType().getText();
        String valueType = extractType(ctx.type_());
        String name = ctx.IDENTIFIER().getText();
        int number = parseFieldNumber(ctx.fieldNumber());
        return new MapFieldDef(keyType, valueType, name, number);
    }

    // ────────────────────────── oneof ──────────────────────────

    @Override
    public OneofDef visitOneofDef(Proto3Parser.OneofDefContext ctx) {
        String name = ctx.IDENTIFIER().getText();
        OneofDef oneof = new OneofDef(name);
        List<FieldDef> fields = new ArrayList<>();

        for (Proto3Parser.OneofItemContext item : ctx.oneofItem()) {
            if (item.oneofField() != null) {
                Proto3Parser.OneofFieldContext fc = item.oneofField();
                String type = extractType(fc.type_());
                String fieldName = fc.IDENTIFIER().getText();
                int number = parseFieldNumber(fc.fieldNumber());
                fields.add(new FieldDef(null, type, fieldName, number));
            }
            // optionStatement inside oneof — skip (not stored in AST)
        }

        oneof.setFields(fields);
        return oneof;
    }

    // ────────────────────────── enum ──────────────────────────

    @Override
    public EnumDef visitEnumDef(Proto3Parser.EnumDefContext ctx) {
        String name = ctx.IDENTIFIER().getText();
        EnumDef enumDef = new EnumDef(name);

        List<EnumValue> values = new ArrayList<>();
        List<OptionStatement> options = new ArrayList<>();
        List<ReservedDef> reserveds = new ArrayList<>();

        for (Proto3Parser.EnumBodyItemContext item : ctx.enumBody().enumBodyItem()) {
            if (item.enumField() != null) {
                values.add(visitEnumField(item.enumField()));
            } else if (item.optionStatement() != null) {
                options.add(visitOptionStatement(item.optionStatement()));
            } else if (item.reserved() != null) {
                reserveds.add(visitReserved(item.reserved()));
            }
            // emptyStatement — skip
        }

        enumDef.setValues(values);
        enumDef.setOptions(options);
        enumDef.setReserveds(reserveds);
        return enumDef;
    }

    @Override
    public EnumValue visitEnumField(Proto3Parser.EnumFieldContext ctx) {
        String name = ctx.IDENTIFIER().getText();
        int sign = (ctx.MINUS() != null) ? -1 : 1;
        int number = sign * parseIntLiteral(ctx.INTEGER_LITERAL().getText());
        return new EnumValue(name, number);
    }

    // ────────────────────────── reserved ──────────────────────────

    @Override
    public ReservedDef visitReserved(Proto3Parser.ReservedContext ctx) {
        ReservedDef reserved = new ReservedDef();

        if (ctx.fieldNames() != null) {
            List<String> names = new ArrayList<>();
            for (TerminalNode str : ctx.fieldNames().STRING_LITERAL()) {
                names.add(stripQuotes(str.getText()));
            }
            reserved.setFieldNames(names);
        } else if (ctx.ranges() != null) {
            List<ReservedDef.Range> ranges = new ArrayList<>();
            for (Proto3Parser.Range_Context rc : ctx.ranges().range_()) {
                ranges.add(visitRange_(rc));
            }
            reserved.setRanges(ranges);
        }

        return reserved;
    }

    @Override
    public ReservedDef.Range visitRange_(Proto3Parser.Range_Context ctx) {
        List<TerminalNode> intLiterals = ctx.INTEGER_LITERAL();
        int start = parseIntLiteral(intLiterals.get(0).getText());
        int end = -1; // single value

        if (ctx.TO() != null) {
            if (ctx.MAX() != null) {
                end = Integer.MAX_VALUE;
            } else if (intLiterals.size() > 1) {
                end = parseIntLiteral(intLiterals.get(1).getText());
            }
        }

        return new ReservedDef.Range(start, end);
    }

    // ────────────────────────── utility ──────────────────────────

    /**
     * Extract the type string from a type_ context.
     * For scalar types, returns the keyword text (e.g. "int32", "string").
     * For message/enum references, returns the dotted name (e.g. "Person.Address").
     */
    private String extractType(Proto3Parser.Type_Context ctx) {
        if (ctx.scalarType() != null) {
            return ctx.scalarType().getText();
        }
        // typeReference: optional leading dot + dotted identifiers
        return ctx.typeReference().getText();
    }

    /**
     * Extract a constant value as a string, matching the old parser's behavior.
     */
    private String extractConstant(Proto3Parser.ConstantContext ctx) {
        if (ctx.STRING_LITERAL() != null) {
            return "\"" + stripQuotes(ctx.STRING_LITERAL().getText()) + "\"";
        }
        if (ctx.TRUE() != null) return "true";
        if (ctx.FALSE() != null) return "false";
        if (ctx.INTEGER_LITERAL() != null) {
            String sign = "";
            if (ctx.MINUS() != null) sign = "-";
            return sign + ctx.INTEGER_LITERAL().getText();
        }
        if (ctx.FLOAT_LITERAL() != null) {
            String sign = "";
            if (ctx.MINUS() != null) sign = "-";
            return sign + ctx.FLOAT_LITERAL().getText();
        }
        // fullIdent (enum value reference)
        return ctx.fullIdent().getText();
    }

    private int parseFieldNumber(Proto3Parser.FieldNumberContext ctx) {
        return parseIntLiteral(ctx.INTEGER_LITERAL().getText());
    }

    /**
     * Parse an integer literal supporting decimal, hex (0x), and octal (0) prefixes.
     */
    private int parseIntLiteral(String s) {
        if (s.startsWith("0x") || s.startsWith("0X")) {
            return Integer.parseInt(s.substring(2), 16);
        }
        if (s.length() > 1 && s.startsWith("0")) {
            return Integer.parseInt(s, 8);
        }
        return Integer.parseInt(s);
    }

    /**
     * Remove surrounding quotes from a string literal token.
     */
    private String stripQuotes(String s) {
        if (s.length() >= 2) {
            return s.substring(1, s.length() - 1);
        }
        return s;
    }
}
