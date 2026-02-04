package com.cc.java.lottery2;
import java.util.Random;
import java.util.Arrays;
import java.awt.Toolkit;   

public class App {

    public static void main(String[] args) {

        Random rand = new Random();
        int min  = 1, max = 49, slots = 6;

        int[] lotteryArray = drawLottoNumbers(rand, min, max, slots);
        int superzahl = drawSuperzahl(rand, min, max);

        Arrays.sort(lotteryArray);

        printResult(lotteryArray, superzahl);
        playSuperzahlSound();
    }

    // Ziehung der 6 Lottozahlen
    private static int[] drawLottoNumbers(Random rand, int min, int max, int slots) {
        int[] lotteryArray = new int[slots];

        for (int indexDrawn = 0; indexDrawn < slots; indexDrawn++) {
            int randomNumber;
            boolean isRepeated;

            do {
                isRepeated = false;
                randomNumber = rand.nextInt((max - min) + 1) + min;

                for (int k = 0; k < indexDrawn; k++) {
                    if (lotteryArray[k] == randomNumber) {
                        isRepeated = true;
                        break;
                    }
                }
            } while (isRepeated);

            lotteryArray[indexDrawn] = randomNumber;
        }

        return lotteryArray;
    }

    // Ziehung der Superzahl
    private static int drawSuperzahl(Random rand, int min, int max) {
        return rand.nextInt(10); // 0 bis 9
    }

    // Ausgabe der Zahlen inkl. Superzahl
    private static void printResult(int[] lotteryArray, int superzahl) {
        System.out.println("The result of the lottery:");
        for (int number : lotteryArray) {
            System.out.print(number + " ");
        }
        System.out.println("\nSuperzahl: " + superzahl);
    }

        private static void playSuperzahlSound() {
        Toolkit.getDefaultToolkit().beep();  
    }
}
