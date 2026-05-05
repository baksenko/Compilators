package compiler.ast;

/**
 * Represents a map field: map<keyType, valueType> name = number;
 */
public class MapFieldDef {
    private String keyType;
    private String valueType;
    private String name;
    private int number;

    public MapFieldDef(String keyType, String valueType, String name, int number) {
        this.keyType = keyType;
        this.valueType = valueType;
        this.name = name;
        this.number = number;
    }

    public String getKeyType()   { return keyType; }
    public String getValueType() { return valueType; }
    public String getName()      { return name; }
    public int getNumber()       { return number; }
}
