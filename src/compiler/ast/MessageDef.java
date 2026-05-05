package compiler.ast;

import java.util.List;

/**
 * Represents a message definition with fields, nested messages, enums, oneofs, maps, etc.
 */
public class MessageDef {
    private String name;
    private List<FieldDef> fields;
    private List<MessageDef> nestedMessages;
    private List<EnumDef> nestedEnums;
    private List<OneofDef> oneofs;
    private List<MapFieldDef> mapFields;
    private List<OptionStatement> options;
    private List<ReservedDef> reserveds;

    public MessageDef(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    public List<FieldDef> getFields() { return fields; }
    public void setFields(List<FieldDef> fields) { this.fields = fields; }

    public List<MessageDef> getNestedMessages() { return nestedMessages; }
    public void setNestedMessages(List<MessageDef> nestedMessages) { this.nestedMessages = nestedMessages; }

    public List<EnumDef> getNestedEnums() { return nestedEnums; }
    public void setNestedEnums(List<EnumDef> nestedEnums) { this.nestedEnums = nestedEnums; }

    public List<OneofDef> getOneofs() { return oneofs; }
    public void setOneofs(List<OneofDef> oneofs) { this.oneofs = oneofs; }

    public List<MapFieldDef> getMapFields() { return mapFields; }
    public void setMapFields(List<MapFieldDef> mapFields) { this.mapFields = mapFields; }

    public List<OptionStatement> getOptions() { return options; }
    public void setOptions(List<OptionStatement> options) { this.options = options; }

    public List<ReservedDef> getReserveds() { return reserveds; }
    public void setReserveds(List<ReservedDef> reserveds) { this.reserveds = reserveds; }
}
