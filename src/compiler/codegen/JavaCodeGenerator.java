package compiler.codegen;

import compiler.ast.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Generates Java source code from the proto3 AST.
 * Each top-level message and enum becomes a separate Java class.
 */
public class JavaCodeGenerator {

    private static final Map<String, String> SCALAR_TYPE_MAP = new HashMap<>();

    static {
        SCALAR_TYPE_MAP.put("double",   "double");
        SCALAR_TYPE_MAP.put("float",    "float");
        SCALAR_TYPE_MAP.put("int32",    "int");
        SCALAR_TYPE_MAP.put("int64",    "long");
        SCALAR_TYPE_MAP.put("uint32",   "int");
        SCALAR_TYPE_MAP.put("uint64",   "long");
        SCALAR_TYPE_MAP.put("sint32",   "int");
        SCALAR_TYPE_MAP.put("sint64",   "long");
        SCALAR_TYPE_MAP.put("fixed32",  "int");
        SCALAR_TYPE_MAP.put("fixed64",  "long");
        SCALAR_TYPE_MAP.put("sfixed32", "int");
        SCALAR_TYPE_MAP.put("sfixed64", "long");
        SCALAR_TYPE_MAP.put("bool",     "boolean");
        SCALAR_TYPE_MAP.put("string",   "String");
        SCALAR_TYPE_MAP.put("bytes",    "byte[]");
    }

    private static final Map<String, String> BOXED_TYPE_MAP = new HashMap<>();

    static {
        BOXED_TYPE_MAP.put("double",   "Double");
        BOXED_TYPE_MAP.put("float",    "Float");
        BOXED_TYPE_MAP.put("int32",    "Integer");
        BOXED_TYPE_MAP.put("int64",    "Long");
        BOXED_TYPE_MAP.put("uint32",   "Integer");
        BOXED_TYPE_MAP.put("uint64",   "Long");
        BOXED_TYPE_MAP.put("sint32",   "Integer");
        BOXED_TYPE_MAP.put("sint64",   "Long");
        BOXED_TYPE_MAP.put("fixed32",  "Integer");
        BOXED_TYPE_MAP.put("fixed64",  "Long");
        BOXED_TYPE_MAP.put("sfixed32", "Integer");
        BOXED_TYPE_MAP.put("sfixed64", "Long");
        BOXED_TYPE_MAP.put("bool",     "Boolean");
        BOXED_TYPE_MAP.put("string",   "String");
        BOXED_TYPE_MAP.put("bytes",    "byte[]");
    }

    private String packageName;

    /**
     * Generate Java code for the entire proto file.
     * Returns a map of filename → Java source code.
     */
    public Map<String, String> generate(ProtoFile proto) {
        this.packageName = proto.getPackageName();
        Map<String, String> files = new HashMap<>();

        // Generate a class for each top-level message
        if (proto.getMessages() != null) {
            for (MessageDef msg : proto.getMessages()) {
                String code = generateMessageClass(msg, 0);
                files.put(msg.getName() + ".java", code);
            }
        }

        // Generate a class for each top-level enum
        if (proto.getEnums() != null) {
            for (EnumDef enumDef : proto.getEnums()) {
                String code = generateTopLevelEnum(enumDef);
                files.put(enumDef.getName() + ".java", code);
            }
        }

        return files;
    }

    // ────────────────────────── message ──────────────────────────

    private String generateMessageClass(MessageDef msg, int indentLevel) {
        StringBuilder sb = new StringBuilder();
        String indent = indent(indentLevel);

        // Package and imports only for top-level classes
        if (indentLevel == 0) {
            if (packageName != null && !packageName.isEmpty()) {
                sb.append("package ").append(packageName).append(";\n\n");
            }
            sb.append("import java.util.List;\n");
            sb.append("import java.util.ArrayList;\n");
            sb.append("import java.util.Map;\n");
            sb.append("import java.util.HashMap;\n");
            sb.append("import java.util.Objects;\n\n");
        }

        // Class declaration
        if (indentLevel > 0) {
            sb.append(indent).append("public static class ").append(msg.getName()).append(" {\n\n");
        } else {
            sb.append(indent).append("public class ").append(msg.getName()).append(" {\n\n");
        }

        String innerIndent = indent(indentLevel + 1);

        // ── Nested enums ──
        if (msg.getNestedEnums() != null) {
            for (EnumDef nestedEnum : msg.getNestedEnums()) {
                sb.append(generateNestedEnum(nestedEnum, indentLevel + 1));
                sb.append('\n');
            }
        }

        // ── Nested messages ──
        if (msg.getNestedMessages() != null) {
            for (MessageDef nested : msg.getNestedMessages()) {
                sb.append(generateMessageClass(nested, indentLevel + 1));
                sb.append('\n');
            }
        }

        // ── Fields ──
        if (msg.getFields() != null) {
            for (FieldDef field : msg.getFields()) {
                sb.append(innerIndent).append("private ");
                sb.append(javaFieldType(field)).append(' ');
                sb.append(field.getName()).append(";\n");
            }
        }

        // ── Map fields ──
        if (msg.getMapFields() != null) {
            for (MapFieldDef mapField : msg.getMapFields()) {
                String keyJava = boxedType(mapField.getKeyType());
                String valJava = boxedType(mapField.getValueType());
                sb.append(innerIndent).append("private Map<")
                        .append(keyJava).append(", ").append(valJava).append("> ")
                        .append(mapField.getName()).append(" = new HashMap<>();\n");
            }
        }

        // ── Oneof fields ──
        if (msg.getOneofs() != null) {
            for (OneofDef oneof : msg.getOneofs()) {
                // Generate an enum for the oneof case
                sb.append('\n');
                sb.append(innerIndent).append("public enum ")
                        .append(capitalize(oneof.getName())).append("Case {\n");
                sb.append(indent(indentLevel + 2)).append(oneof.getName().toUpperCase()).append("_NOT_SET,\n");
                for (FieldDef f : oneof.getFields()) {
                    sb.append(indent(indentLevel + 2)).append(f.getName().toUpperCase()).append(",\n");
                }
                sb.append(innerIndent).append("}\n\n");

                // Case field
                sb.append(innerIndent).append("private ").append(capitalize(oneof.getName()))
                        .append("Case ").append(oneof.getName()).append("Case = ")
                        .append(capitalize(oneof.getName())).append("Case.")
                        .append(oneof.getName().toUpperCase()).append("_NOT_SET;\n");

                // Individual fields
                for (FieldDef f : oneof.getFields()) {
                    sb.append(innerIndent).append("private ")
                            .append(boxedType(f.getType())).append(' ')
                            .append(f.getName()).append(";\n");
                }
            }
        }

        sb.append('\n');

        // ── Default constructor ──
        sb.append(innerIndent).append("public ").append(msg.getName()).append("() {}\n\n");

        // ── Getters and setters for regular fields ──
        if (msg.getFields() != null) {
            for (FieldDef field : msg.getFields()) {
                String jType = javaFieldType(field);
                String capName = capitalize(field.getName());

                // Getter
                sb.append(innerIndent).append("public ").append(jType)
                        .append(" get").append(capName).append("() {\n");
                sb.append(indent(indentLevel + 2)).append("return this.")
                        .append(field.getName()).append(";\n");
                sb.append(innerIndent).append("}\n\n");

                // Setter
                sb.append(innerIndent).append("public void set").append(capName)
                        .append("(").append(jType).append(' ').append(field.getName()).append(") {\n");
                sb.append(indent(indentLevel + 2)).append("this.").append(field.getName())
                        .append(" = ").append(field.getName()).append(";\n");
                sb.append(innerIndent).append("}\n\n");
            }
        }

        // ── Getters and setters for map fields ──
        if (msg.getMapFields() != null) {
            for (MapFieldDef mapField : msg.getMapFields()) {
                String keyJava = boxedType(mapField.getKeyType());
                String valJava = boxedType(mapField.getValueType());
                String mapType = "Map<" + keyJava + ", " + valJava + ">";
                String capName = capitalize(mapField.getName());

                sb.append(innerIndent).append("public ").append(mapType)
                        .append(" get").append(capName).append("() {\n");
                sb.append(indent(indentLevel + 2)).append("return this.")
                        .append(mapField.getName()).append(";\n");
                sb.append(innerIndent).append("}\n\n");

                sb.append(innerIndent).append("public void set").append(capName)
                        .append("(").append(mapType).append(' ').append(mapField.getName()).append(") {\n");
                sb.append(indent(indentLevel + 2)).append("this.").append(mapField.getName())
                        .append(" = ").append(mapField.getName()).append(";\n");
                sb.append(innerIndent).append("}\n\n");

                // put method
                sb.append(innerIndent).append("public void put").append(capName)
                        .append("(").append(keyJava).append(" key, ")
                        .append(valJava).append(" value) {\n");
                sb.append(indent(indentLevel + 2)).append("this.")
                        .append(mapField.getName()).append(".put(key, value);\n");
                sb.append(innerIndent).append("}\n\n");
            }
        }

        // ── Oneof getters/setters ──
        if (msg.getOneofs() != null) {
            for (OneofDef oneof : msg.getOneofs()) {
                String caseType = capitalize(oneof.getName()) + "Case";
                String capOneof = capitalize(oneof.getName());

                // getCase
                sb.append(innerIndent).append("public ").append(caseType)
                        .append(" get").append(capOneof).append("Case() {\n");
                sb.append(indent(indentLevel + 2)).append("return this.")
                        .append(oneof.getName()).append("Case;\n");
                sb.append(innerIndent).append("}\n\n");

                for (FieldDef f : oneof.getFields()) {
                    String fCap = capitalize(f.getName());
                    String fType = boxedType(f.getType());

                    // Getter
                    sb.append(innerIndent).append("public ").append(fType)
                            .append(" get").append(fCap).append("() {\n");
                    sb.append(indent(indentLevel + 2)).append("return this.")
                            .append(f.getName()).append(";\n");
                    sb.append(innerIndent).append("}\n\n");

                    // Setter — clears other oneof fields
                    sb.append(innerIndent).append("public void set").append(fCap)
                            .append("(").append(fType).append(' ').append(f.getName()).append(") {\n");
                    // Clear all oneof fields
                    for (FieldDef other : oneof.getFields()) {
                        sb.append(indent(indentLevel + 2)).append("this.")
                                .append(other.getName()).append(" = null;\n");
                    }
                    sb.append(indent(indentLevel + 2)).append("this.")
                            .append(f.getName()).append(" = ").append(f.getName()).append(";\n");
                    sb.append(indent(indentLevel + 2)).append("this.")
                            .append(oneof.getName()).append("Case = ")
                            .append(caseType).append('.').append(f.getName().toUpperCase()).append(";\n");
                    sb.append(innerIndent).append("}\n\n");
                }
            }
        }

        // ── toString ──
        sb.append(innerIndent).append("@Override\n");
        sb.append(innerIndent).append("public String toString() {\n");
        sb.append(indent(indentLevel + 2)).append("return \"").append(msg.getName()).append("{\" +\n");

        List<FieldDef> allFields = msg.getFields();
        if (allFields != null) {
            for (int i = 0; i < allFields.size(); i++) {
                FieldDef f = allFields.get(i);
                sb.append(indent(indentLevel + 3)).append("\"").append(f.getName()).append("=\" + ")
                        .append(f.getName());
                if (i < allFields.size() - 1) {
                    sb.append(" + \", \" +\n");
                } else {
                    sb.append(" +\n");
                }
            }
        }

        sb.append(indent(indentLevel + 3)).append("'}';\n");
        sb.append(innerIndent).append("}\n\n");

        // ── equals & hashCode ──
        sb.append(innerIndent).append("@Override\n");
        sb.append(innerIndent).append("public boolean equals(Object o) {\n");
        sb.append(indent(indentLevel + 2)).append("if (this == o) return true;\n");
        sb.append(indent(indentLevel + 2)).append("if (o == null || getClass() != o.getClass()) return false;\n");
        sb.append(indent(indentLevel + 2)).append(msg.getName()).append(" that = (")
                .append(msg.getName()).append(") o;\n");
        sb.append(indent(indentLevel + 2)).append("return ");
        if (allFields != null && !allFields.isEmpty()) {
            for (int i = 0; i < allFields.size(); i++) {
                FieldDef f = allFields.get(i);
                sb.append("Objects.equals(").append(f.getName()).append(", that.").append(f.getName()).append(')');
                if (i < allFields.size() - 1) {
                    sb.append(" &&\n").append(indent(indentLevel + 3));
                }
            }
        } else {
            sb.append("true");
        }
        sb.append(";\n");
        sb.append(innerIndent).append("}\n\n");

        sb.append(innerIndent).append("@Override\n");
        sb.append(innerIndent).append("public int hashCode() {\n");
        sb.append(indent(indentLevel + 2)).append("return Objects.hash(");
        if (allFields != null && !allFields.isEmpty()) {
            for (int i = 0; i < allFields.size(); i++) {
                sb.append(allFields.get(i).getName());
                if (i < allFields.size() - 1) sb.append(", ");
            }
        }
        sb.append(");\n");
        sb.append(innerIndent).append("}\n");

        sb.append(indent).append("}\n");
        return sb.toString();
    }

    // ────────────────────────── enum ──────────────────────────

    private String generateTopLevelEnum(EnumDef enumDef) {
        StringBuilder sb = new StringBuilder();

        if (packageName != null && !packageName.isEmpty()) {
            sb.append("package ").append(packageName).append(";\n\n");
        }

        sb.append("public enum ").append(enumDef.getName()).append(" {\n");
        appendEnumValues(sb, enumDef, 1);
        sb.append("}\n");
        return sb.toString();
    }

    private String generateNestedEnum(EnumDef enumDef, int indentLevel) {
        StringBuilder sb = new StringBuilder();
        String indent = indent(indentLevel);
        sb.append(indent).append("public enum ").append(enumDef.getName()).append(" {\n");
        appendEnumValues(sb, enumDef, indentLevel + 1);
        sb.append(indent).append("}\n");
        return sb.toString();
    }

    private void appendEnumValues(StringBuilder sb, EnumDef enumDef, int indentLevel) {
        String indent = indent(indentLevel);
        List<EnumValue> values = enumDef.getValues();
        if (values != null) {
            for (int i = 0; i < values.size(); i++) {
                EnumValue ev = values.get(i);
                sb.append(indent).append(ev.getName()).append('(').append(ev.getNumber()).append(')');
                sb.append(i < values.size() - 1 ? ",\n" : ";\n");
            }
        }

        sb.append('\n');
        sb.append(indent).append("private final int number;\n\n");
        sb.append(indent).append(enumDef.getName()).append("(int number) {\n");
        sb.append(indent(indentLevel + 1)).append("this.number = number;\n");
        sb.append(indent).append("}\n\n");
        sb.append(indent).append("public int getNumber() {\n");
        sb.append(indent(indentLevel + 1)).append("return number;\n");
        sb.append(indent).append("}\n\n");

        // forNumber static method
        sb.append(indent).append("public static ").append(enumDef.getName()).append(" forNumber(int value) {\n");
        sb.append(indent(indentLevel + 1)).append("for (").append(enumDef.getName())
                .append(" e : values()) {\n");
        sb.append(indent(indentLevel + 2)).append("if (e.number == value) return e;\n");
        sb.append(indent(indentLevel + 1)).append("}\n");
        sb.append(indent(indentLevel + 1)).append("return null;\n");
        sb.append(indent).append("}\n");
    }

    // ────────────────────────── type mapping ──────────────────────────

    private String javaFieldType(FieldDef field) {
        String baseType = javaType(field.getType());
        if ("repeated".equals(field.getModifier())) {
            return "List<" + boxedType(field.getType()) + ">";
        }
        return baseType;
    }

    private String javaType(String protoType) {
        String mapped = SCALAR_TYPE_MAP.get(protoType);
        if (mapped != null) return mapped;
        // It's a message or enum type reference — use the last segment as the class name
        int lastDot = protoType.lastIndexOf('.');
        return lastDot >= 0 ? protoType.substring(lastDot + 1) : protoType;
    }

    private String boxedType(String protoType) {
        String mapped = BOXED_TYPE_MAP.get(protoType);
        if (mapped != null) return mapped;
        int lastDot = protoType.lastIndexOf('.');
        return lastDot >= 0 ? protoType.substring(lastDot + 1) : protoType;
    }

    // ────────────────────────── utility ──────────────────────────

    private String indent(int level) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < level; i++) sb.append("    ");
        return sb.toString();
    }

    private String capitalize(String s) {
        if (s == null || s.isEmpty()) return s;
        return Character.toUpperCase(s.charAt(0)) + s.substring(1);
    }
}
