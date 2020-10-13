package bullscows;

public class SymbolCount {

    public static String countOfSymbols(int numberOfSymbols, int length) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append("*");
        }
        builder.append(" ");
        if (numberOfSymbols < 11) {
            builder.append("(0-" + (numberOfSymbols - 1) + ").");
        } else {
            builder.append("(0-9, a-" + (char)((int)'a' + (numberOfSymbols - 11)) + ").");
        }

        return builder.toString();
    }
}
