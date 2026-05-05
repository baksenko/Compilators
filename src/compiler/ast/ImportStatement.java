package compiler.ast;

/**
 * Represents an import statement: import [public|weak] "path";
 */
public class ImportStatement {
    private String modifier; // "public", "weak", or null
    private String path;

    public ImportStatement(String modifier, String path) {
        this.modifier = modifier;
        this.path = path;
    }

    public String getModifier() { return modifier; }
    public String getPath()     { return path; }
}
