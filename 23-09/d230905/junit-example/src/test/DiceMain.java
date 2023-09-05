package test;

import main.Dice;
import main.DiceCalculator;

public class DiceMain {
    public static void main(String[] args) {
        // int random1 = (int) ((Math.random() * (6 - 1)) + 1);
        // int random2 = (int) ((Math.random() * (6 - 1)) + 1);
        int random1 = 6;
        int random2 = 2;
        Dice first = new Dice(random1);
        Dice second = new Dice(random2);

        System.out.println("주사위 합 = " + DiceCalculator.addDice(first, second));
        assert DiceCalculator.addDice(first, second) == 8;
        System.out.println("주사위 차 = " + DiceCalculator.subDice(first, second));
        assert DiceCalculator.subDice(first, second) == 4;
        System.out.println("주사위 곱 = " + DiceCalculator.mulDice(first, second));
        assert DiceCalculator.mulDice(first, second) == 12;
        System.out.println("주사위 몫 = " + DiceCalculator.divDice(first, second));
        assert DiceCalculator.divDice(first, second) == 3;

        int random3 = (int) ((Math.random() * (6 - 1)) + 1);

        Dice dice = new Dice(random3);

        System.out.println("주사위 눈(" + dice.getNumber() + ")이 홀수인가?? : " + DiceCalculator.isOdd(dice));
        System.out.println("주사위 눈(" + dice.getNumber() + ")이 짝수인가?? : " + DiceCalculator.isEven(dice));
    }
}