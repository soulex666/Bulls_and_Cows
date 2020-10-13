package bullscows;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the length of the secret code:");
        String tryDigits = scanner.next();

        int digits = 0;
        if (tryDigits.matches("\\d+") && tryDigits.length() < 10) {
            digits = Integer.parseInt(tryDigits);
            if (digits <= 0) {
                System.out.println("Error: \"" + tryDigits + "\" isn't a valid number.");
                System.exit(0);
            }
        } else {
            System.out.println("Error: \"" + tryDigits + "\" isn't a valid number.");
            System.exit(0);
        }
        int numberOfSymbols = 0;
        System.out.println("Input the number of possible symbols in the code:");
        String tryNumberOfSymbols = scanner.next();

        if (tryNumberOfSymbols.matches("\\d+")) {
            numberOfSymbols = Integer.parseInt(tryNumberOfSymbols);
            if (numberOfSymbols > 36) {
                System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
                System.exit(0);
            }
            if (digits > numberOfSymbols) {
                System.out.printf("Error: it's not possible to generate a code with a length of %d with %d unique symbols.", digits, numberOfSymbols);
                System.exit(0);
            }
        } else  {
            System.out.println("Error: \"" + tryNumberOfSymbols + " isn't a valid number.");
            System.exit(0);
        }

        System.out.println("The secret is prepared: " + SymbolCount.countOfSymbols(numberOfSymbols, digits));


        String secretCode = null;

        //generate secret number
        if (digits >= 0 && digits < 37) {
            System.out.println("Okay, let's start a game!");
            secretCode = RandomNumber.setNumber(numberOfSymbols, digits);

        } else {
            System.out.println("error");
        }
        System.out.println(secretCode);
        int count = 1;

        //find bulls and cows matches
        char [] secretNumber = secretCode.toCharArray();
        while (secretCode.length() > 0) {
            System.out.println("Turn " + count + ":");
            int cow = 0;
            int bull = 0;
            String turnNumber = scanner.next();



            char [] number = turnNumber.toCharArray();

            for (int i = 0; i < number.length; i++) {
                if (secretNumber[i] == number[i]) {
                    bull++;
                }
            }
            for (int i = 0; i < number.length; i++) {
                for (int j = i +1 ; j < number.length; j++) {
                    if (i != j) {
                        if (secretNumber[i] == number[j]) {
                            cow++;
                        }
                    }
                }
            }
            count++;
            if (secretCode.equals(turnNumber)) {
                System.out.println("Grade: " + bull + " bulls");
                System.out.println("Congratulations! You guessed the secret code.");
                break;
            }
            if (cow == 0 && bull == 0) {
                System.out.println("Grade: None");
            } else if (cow == 0){
                if (bull == 1) {
                    System.out.println("Grade: " + bull + " bull");
                } else {
                    System.out.println("Grade: " + bull + " bulls");
                }

            } else if (bull == 0){
                if (cow == 1) {
                    System.out.println("Grade: " + cow + " cow");
                } else {
                    System.out.println("Grade: " + cow + " cows");
                }

            } else {
                if (bull == 1 && cow == 1) {
                    System.out.println("Grade: " + bull + " bull and " + cow + " cow");
                } else if (bull == 1) {
                    System.out.println("Grade: " + bull + " bull and " + cow + " cows");
                } else if (cow == 1) {
                    System.out.println("Grade: " + bull + " bulls and " + cow + " cow");
                } else {
                    System.out.println("Grade: " + bull + " bulls and " + cow + " cows");
                }

            }
        }







    }
}
