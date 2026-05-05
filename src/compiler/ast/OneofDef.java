package compiler.ast;

import java.util.List;

/**
 * Represents a oneof definition inside a message.
 */
public class OneofDef {
    private String name;
    private List<FieldDef> fields;

    public OneofDef(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    public List<FieldDef> getFields() { return fields; }
    public void setFields(List<FieldDef> fields) { this.fields = fields; }
}
