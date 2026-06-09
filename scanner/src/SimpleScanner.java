public class SimpleScanner {
    static class Token {
        String code;
        String value;
        int column;

        Token(String code, String value, int column) {
            this.code = code;
            this.value = value;
            this.column = column;
        }

        @Override
        public String toString() {
            return String.format("Kolumna %2d | Para: (%-7s , %s)", column, code, value);
        }
    }

    private final String input;
    private int pos = 0;
    private char currentChar;

    public SimpleScanner(String input) {
        this.input = input;
        this.currentChar = !input.isEmpty() ? input.charAt(0) : '\0';
    }

    private void advance() {
        pos++;
        if (pos < input.length()) {
            currentChar = input.charAt(pos);
        } else {
            currentChar = '\0';
        }
    }

    private void skipWhitespace() {
        while (currentChar != '\0' && Character.isWhitespace(currentChar)) {
            advance();
        }
    }

    public Token nextToken() {
        skipWhitespace();

        int startColumn = pos + 1;

        if (currentChar == '\0') {
            return new Token("EOF", "null", startColumn);
        }

        if (Character.isDigit(currentChar)) {
            StringBuilder sb = new StringBuilder();
            while (Character.isDigit(currentChar)) {
                sb.append(currentChar);
                advance();
            }
            return new Token("INT", sb.toString(), startColumn);
        }

        if (Character.isLetter(currentChar)) {
            StringBuilder sb = new StringBuilder();
            while (Character.isLetterOrDigit(currentChar)) {
                sb.append(currentChar);
                advance();
            }
            return new Token("ID", sb.toString(), startColumn);
        }

        char c = currentChar;
        switch (c) {
            case '+': advance(); return new Token("PLUS", "+", startColumn);
            case '-': advance(); return new Token("MINUS", "-", startColumn);
            case '*': advance(); return new Token("MULT", "*", startColumn);
            case '/': advance(); return new Token("DIV", "/", startColumn);
            case '(': advance(); return new Token("LPAREN", "(", startColumn);
            case ')': advance(); return new Token("RPAREN", ")", startColumn);
        }

        advance();
        return new Token("ERROR", "Nieznany znak: '" + c + "'", startColumn);
    }

    public static void main(String[] args) {
        String text = "wynik = (120 + 5) * x / 2 # error";
        System.out.println("Analizowane wyrażenie: " + text + "\n");

        SimpleScanner scanner = new SimpleScanner(text);
        Token token;

        do {
            token = scanner.nextToken();

            if (token.code.equals("ERROR")) {
                System.err.println("!!! BŁĄD w kolumnie " + token.column + ": " + token.value);
            } else if (!token.code.equals("EOF")) {
                System.out.println(token);
            }

        } while (!token.code.equals("EOF"));
    }
}