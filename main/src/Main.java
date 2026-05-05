import compiler.ast.ProtoFile;
import compiler.codegen.JavaCodeGenerator;
import compiler.lexer.Lexer;
import compiler.parser.Parser;
import compiler.token.Token;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

/**
 * Protobuf proto3 → Java Compiler
 *
 * Usage: java Main <input.proto> [output_directory]
 *
 * Reads a .proto file, lexes, parses, and generates corresponding Java source files.
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

            // ── 2. Lexical analysis ──
            Lexer lexer = new Lexer(source);
            List<Token> tokens = lexer.tokenize();
            System.out.println("[2/4] Lexical analysis complete: " + tokens.size() + " tokens");

            // Print tokens for debugging
            System.out.println("─── Tokens ───");
            for (Token t : tokens) {
                System.out.println("  " + t);
            }
            System.out.println();

            // ── 3. Parsing ──
            Parser parser = new Parser(tokens);
            ProtoFile protoFile = parser.parseProto();
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
}
