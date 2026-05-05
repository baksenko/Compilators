package compiler.ast;

/**
 * Represents a single field in a message:
 *   [repeated|optional] type name = number [options];
 */
public class FieldDef {
    private String modifier;   // "repeated", "optional", or null
    private String type;       // scalar type or message/enum type reference
    private String name;
    private int number;

    public FieldDef(String modifier, String type, String name, int number) {
        this.modifier = modifier;
        this.type = type;
        this.name = name;
        this.number = number;
    }

    public String getModifier() { return modifier; }
    public String getType()     { return type; }
    public String getName()     { return name; }
    public int getNumber()      { return number; }
}
