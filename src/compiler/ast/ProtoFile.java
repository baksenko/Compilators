package compiler.ast;

import java.util.List;

/**
 * Root AST node representing an entire .proto file.
 */
public class ProtoFile {
    private String syntax;                    // e.g. "proto3"
    private String packageName;               // e.g. "com.example"
    private List<ImportStatement> imports;
    private List<OptionStatement> options;
    private List<MessageDef> messages;
    private List<EnumDef> enums;

    public ProtoFile() {}

    public String getSyntax() { return syntax; }
    public void setSyntax(String syntax) { this.syntax = syntax; }

    public String getPackageName() { return packageName; }
    public void setPackageName(String packageName) { this.packageName = packageName; }

    public List<ImportStatement> getImports() { return imports; }
    public void setImports(List<ImportStatement> imports) { this.imports = imports; }

    public List<OptionStatement> getOptions() { return options; }
    public void setOptions(List<OptionStatement> options) { this.options = options; }

    public List<MessageDef> getMessages() { return messages; }
    public void setMessages(List<MessageDef> messages) { this.messages = messages; }

    public List<EnumDef> getEnums() { return enums; }
    public void setEnums(List<EnumDef> enums) { this.enums = enums; }
}
