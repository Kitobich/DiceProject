package opgave02;

import examples.RollTwoDice;

public class Craps {
    public static void main(String[] args) {
        playCraps();
    }

    public static void playCraps() {
        int comeOutRoll = RollTwoDice.rollDie() + RollTwoDice.rollDie();
        System.out.println("du slog: " + comeOutRoll);
        if (comeOutRoll == 7 || comeOutRoll == 11) {
            System.out.println("du vandt på dit come out roll :)");
        } else if (comeOutRoll == 2 || comeOutRoll == 3 || comeOutRoll == 12) {
            System.out.println("du tabte på dit come out roll :(");
        } else {
            System.out.println("dit come out roll er " + comeOutRoll);
            // == true er unødvendigt.
            if (rollforPoint(comeOutRoll) == true) {
                System.out.println("du kastede dit come out roll, du vandt! :)");

            } else {
                System.out.println("du kastede 7, du tabte :(");
            }

        }
    }

    public static boolean rollforPoint(int point) {
        int nyRul = 0;
        while (true) {
            nyRul = RollTwoDice.rollDie() + RollTwoDice.rollDie();
            System.out.println("dit nye rul er " + nyRul);
            if (point == nyRul) {
                return true;
            } else if (nyRul == 7) {
                return false;
            }

        }
    }
}