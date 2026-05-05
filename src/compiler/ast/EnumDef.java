package compiler.ast;

import java.util.List;

/**
 * Represents an enum definition.
 */
public class EnumDef {
    private String name;
    private List<EnumValue> values;
    private List<OptionStatement> options;
    private List<ReservedDef> reserveds;

    public EnumDef(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    public List<EnumValue> getValues() { return values; }
    public void setValues(List<EnumValue> values) { this.values = values; }

    public List<OptionStatement> getOptions() { return options; }
    public void setOptions(List<OptionStatement> options) { this.options = options; }

    public List<ReservedDef> getReserveds() { return reserveds; }
    public void setReserveds(List<ReservedDef> reserveds) { this.reserveds = reserveds; }
}
