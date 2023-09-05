package main;

public class Dice {
    private int number;

    public Dice(int number) {
        if (number > 6 || number < 1) {
            throw new IllegalArgumentException("1 미만 6 초과 주사위는 생서할 수 없습니다.");
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

}
