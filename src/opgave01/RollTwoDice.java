package examples;

import java.util.Scanner;

public class RollTwoDice {
    private static int rollCount = 0;
    private static int sum = 0;
    private static int par = 0;
    private static int maxSum = 0;
    private static int[] count = new int[6];

    public static void main(String[] args) {
        System.out.println("Velkommen til spillet, rul to terninger.");
        printRules();
        System.out.println();

        playTwoDice();

        System.out.println();
        System.out.println("Tak for at spille, rul to terninger.");

    }

    private static void printRules() {
        System.out.println("=====================================================");
        System.out.println("Regler for rul to terninger");
        System.out.println("Spilleren ruller to terninger, så længde man lyster.");
        System.out.println("=====================================================");
    }

    private static int[] playTwoDice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Rul to terninger? ('ja/nej') ");
        String answer = scanner.nextLine();
        int[] array = new int[2];
        while (!answer.equals("nej")) {
            array[0] = rollDie();
            array[1] = rollDie();
            System.out.println("Du rullede: " + array[0] + " og " + array[1]);
            System.out.println();

            updateStatistics(array);

            System.out.print("Rul to terninger? ('ja/nej') ");
            answer = scanner.nextLine();

        }

        printStatistics();
        scanner.close();
        return array;
    }

    public static int rollDie() {
        return (int) (Math.random() * 6 + 1);
    }

    private static void updateStatistics(int[] dice) {
        rollCount++;
        sum += dice[0] + dice[1];
        if (dice[0] == dice[1]) {
            par++;
        }
        int slag = dice[0] + dice[1];
        if (slag > maxSum) {
            maxSum = slag;
        }

        for (int i = 0; i < dice.length; i++) {
            int eyes = dice[i];
            count[eyes - 1]++;
        }
    }

    private static void printStatistics() {
        System.out.println("\nResults:");
        System.out.println("-------");
        System.out.printf("%24s %4d\n", "Antal rul:", rollCount);
        System.out.printf("%24s %4d\n", "Sum af alle rul:", sum);
        System.out.printf("%24s %4d\n", "Antal par rullet:", par);
        System.out.printf("%24s %4d\n", "Største sum rullet:", maxSum);
        for (int i = 1; i <= count.length; i++) {
            System.out.printf("%24s %4d\n", "Antal " + i + "´ere rullet:", count[i - 1]);
        }
    }

}
