package main;

public class DiceCalculator {
    public static int addDice(Dice d1, Dice d2) {
        return d1.getNumber() + d2.getNumber();
    }

    public static int subDice(Dice d1, Dice d2) {
        return Math.abs(d1.getNumber() - d2.getNumber());
    }

    public static int mulDice(Dice d1, Dice d2) {
        return d1.getNumber() * d2.getNumber();
    }

    public static int divDice(Dice d1, Dice d2) {
        return d1.getNumber() / d2.getNumber();
    }

    public static boolean isOdd(Dice d1) {
        return d1.getNumber() % 2 == 1;
    }

    public static boolean isEven(Dice d1) {
        return !isOdd(d1);
    }
}
