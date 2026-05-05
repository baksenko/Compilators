package compiler.ast;

/**
 * Represents: option name = value;
 */
public class OptionStatement {
    private String name;
    private String value;

    public OptionStatement(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName()  { return name; }
    public String getValue() { return value; }
}
