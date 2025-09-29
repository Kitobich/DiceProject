package opgave03;

import examples.RollTwoDice;

import java.util.Scanner;

public class Pigs {
    private static Scanner sc = new Scanner(System.in);
    private static int spiller1Point = 0;
    private static int spiller2Point = 0;
    private static int kast = 0;
    private static int pointMax;
    private static double countKast1 = 0;
    private static double countTur1 = 0;
    private static double countKast2 = 0;
    private static double countTur2 = 0;
    private static double antalKast = 0;

    public static void main(String[] args) {
        System.out.println("velkommen til 100, vil du spille (ja/nej)?");
        String startSpil = sc.nextLine();
        System.out.println("hvor mange point vil du spille til?");
        pointMax = sc.nextInt();
        sc.nextLine();
        while (!startSpil.equals("nej")) {
            System.out.println("=====================================================");
            spillerTur();
            startSpil = sc.nextLine();
            System.out.println("=====================================================");
            System.out.println("Tak for at spille 100");
            System.out.println("=====================================================");
        }
        sc.close();
    }

    public static int playPig(int spiller) {
        kast = 0;
        int sum = 0;
        String answer = "";
        System.out.println("tryk enter for at kaste");
        answer = sc.nextLine();
        while (!answer.equals("nej") && kast != 1) {
            kast = RollTwoDice.rollDie();
            sum += kast;
            antalKast++;
            if (kast != 1) {
                System.out.println("du slog: " + kast);
                System.out.println("vil du kaste igen? (ja/nej)");
                answer = sc.nextLine();
            } else {
                sum = 0;
                System.out.println("du slog 1, næste spillers tur");
            }
        }
        return sum;
    }

    public static void spillerTur() {
        int spiller = 1;
        while (spiller1Point < pointMax && spiller2Point < pointMax) {
            if (spiller % 2 == 1) {
                System.out.println("spiller 1´s tur");
                int point = playPig(1);
                updaterePoint(1, point);
                updatereKast(1);
                System.out.println("spiller 1 har " + spiller1Point + " point");
                System.out.println("du kster i gennemsnit " + countKast1 / countTur1 + " kast pr runde");
                System.out.println("=====================================================");
            } else {
                System.out.println("spiller 2´s tur");
                int point = playPig(2);
                updaterePoint(2, point);
                updatereKast(2);
                System.out.println("spiller 2 har " + spiller2Point + " point");
                System.out.println("du kster i gennemsnit " + countKast2 / countTur2 + " kast pr runde");
                System.out.println("=====================================================");
            }
            spiller++;
        }
        if (spiller1Point >= pointMax) {
            System.out.println("Tillykke spiller 1, du vandt! :)");
        } else if (spiller2Point >= pointMax) {
            System.out.println("Tillykke spiller 2, du vandt! :)");
        }
        spiller1Point = 0;
        spiller2Point = 0;
    }

    public static void updaterePoint(int spiller, int point) {
        if (spiller == 1) {
            spiller1Point += point;

        } else {
            spiller2Point += point;
        }

    }

    public static void updatereKast(int spiller) {


        if (spiller == 1) {
            countTur1++;
            countKast1 += antalKast;
        } else {
            countTur2++;
            countKast2 += antalKast;
        }
        antalKast = 0;
    }

}


