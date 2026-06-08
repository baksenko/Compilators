import compiler.ast.ProtoFile;
import compiler.codegen.JavaCodeGenerator;
import compiler.parser.ASTBuilder;
import compiler.parser.Proto3Lexer;
import compiler.parser.Proto3Parser;
import org.antlr.v4.runtime.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

/**
 * Protobuf proto3 → Java Compiler
 *
 * Usage: java Main <input.proto> [output_directory]
 *
 * Reads a .proto file, lexes and parses it with ANTLR4,
 * builds an AST, and generates corresponding Java source files.
 */
public class Main {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("╔══════════════════════════════════════════════════════╗");
            System.out.println("║     Protobuf proto3 → Java Compiler                 ║");
            System.out.println("║     Authors: Mikhail Danilau, Roman Chmirou          ║");
            System.out.println("╚══════════════════════════════════════════════════════╝");
            System.out.println();
            System.out.println("Usage: java Main <input.proto> [output_directory]");
            System.out.println();
            System.out.println("  <input.proto>       Path to the .proto file to compile");
            System.out.println("  [output_directory]  Directory for generated .java files (default: ./output)");
            System.exit(1);
        }

        String inputFile = args[0];
        String outputDir = args.length >= 2 ? args[1] : "output";

        try {
            // ── 1. Read source ──
            String source = new String(Files.readAllBytes(Paths.get(inputFile)), StandardCharsets.UTF_8);
            System.out.println("[1/4] Read input file: " + inputFile + " (" + source.length() + " chars)");

            // ── 2. Lexical analysis (ANTLR4) ──
            CharStream input = CharStreams.fromString(source);
            Proto3Lexer lexer = new Proto3Lexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            tokens.fill(); // materialize all tokens for counting
            System.out.println("[2/4] Lexical analysis complete: " + tokens.getTokens().size() + " tokens");

            // Print tokens for debugging
            System.out.println("─── Tokens ───");
            for (Token t : tokens.getTokens()) {
                System.out.println("  " + tokenToString(t, lexer));
            }
            System.out.println();

            // ── 3. Parsing (ANTLR4) ──
            Proto3Parser parser = new Proto3Parser(tokens);

            // Custom error listener to fail fast on syntax errors
            parser.removeErrorListeners();
            parser.addErrorListener(new BaseErrorListener() {
                @Override
                public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                                        int line, int charPositionInLine,
                                        String msg, RecognitionException e) {
                    throw new RuntimeException("Parse error at line " + line + ":" + charPositionInLine + " — " + msg);
                }
            });

            lexer.reset();
            tokens.seek(0);

            Proto3Parser.ProtoContext tree = parser.proto();

            // ── Build AST from parse tree ──
            ASTBuilder builder = new ASTBuilder();
            ProtoFile protoFile = builder.visitProto(tree);

            System.out.println("[3/4] Parsing complete: "
                    + (protoFile.getMessages() != null ? protoFile.getMessages().size() : 0) + " message(s), "
                    + (protoFile.getEnums() != null ? protoFile.getEnums().size() : 0) + " enum(s)");

            // ── 4. Code generation ──
            JavaCodeGenerator codegen = new JavaCodeGenerator();
            Map<String, String> generatedFiles = codegen.generate(protoFile);

            Path outPath = Paths.get(outputDir);
            Files.createDirectories(outPath);

            for (Map.Entry<String, String> entry : generatedFiles.entrySet()) {
                Path filePath = outPath.resolve(entry.getKey());
                Files.write(filePath, entry.getValue().getBytes(StandardCharsets.UTF_8));
                System.out.println("[4/4] Generated: " + filePath);
            }

            System.out.println();
            System.out.println("═══ Compilation successful! ═══");
            System.out.println("Output directory: " + outPath.toAbsolutePath());

            // Print generated code to console
            System.out.println();
            for (Map.Entry<String, String> entry : generatedFiles.entrySet()) {
                System.out.println("─── " + entry.getKey() + " ───");
                System.out.println(entry.getValue());
            }

        } catch (IOException e) {
            System.err.println("Error reading/writing file: " + e.getMessage());
            System.exit(2);
        } catch (Exception e) {
            System.err.println("Compilation error: " + e.getMessage());
            e.printStackTrace();
            System.exit(3);
        }
    }

    /**
     * Format an ANTLR token for debug printing, similar to the old Token.toString().
     */
    private static String tokenToString(Token t, Proto3Lexer lexer) {
        String typeName = lexer.getVocabulary().getSymbolicName(t.getType());
        if (typeName == null) typeName = lexer.getVocabulary().getDisplayName(t.getType());
        String text = t.getText().replace("\n", "\\n").replace("\r", "\\r");
        return String.format("Token{%s, \"%s\", line=%d, col=%d}",
                typeName, text, t.getLine(), t.getCharPositionInLine() + 1);
    }
}
