package compiler.ast;

/**
 * Represents a single enum value: NAME = number;
 */
public class EnumValue {
    private String name;
    private int number;

    public EnumValue(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() { return name; }
    public int getNumber()  { return number; }
}
