package bullscows;

public class RandomNumber {
    public static String setNumber(int numberOfSymbols, int length) {
        StringBuilder builder = new StringBuilder();
        if (numberOfSymbols < 11) {
            while (builder.length() < length) {
                int randomNumber = (int) (Math.random() * numberOfSymbols);
                if (!builder.toString().contains(randomNumber + "")) {
                    builder.append(randomNumber);
                }
            }
        } else {
            while (builder.length() < length) {
                int randomNumber = (int) (Math.random() * 10);
                int min = 'a';
                int max = (int)'a' + (numberOfSymbols - 11);
                int randomSymbol = min + (int)(Math.random()*((max - min) + 1));
                if (!builder.toString().contains(randomNumber + "") && !builder.toString().contains(randomSymbol + "")) {
                    if ((int)(Math.random()*2) == 0) {
                        builder.append(randomNumber);
                    } else {
                        builder.append((char)randomSymbol);
                    }

                }
            }
        }
        return builder.toString();
    }
}
