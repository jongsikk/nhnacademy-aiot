package com.nhnacademy.mart;

import java.util.ArrayList;

public class FoodStand {

    private final ArrayList<Food> foods = new ArrayList<>();

    // TODO 01 매대에 물건을 추가하는 메서드를 구현하세요
    public void add(Food food) {
        foods.add(food);
    }

    // TODO 02 매대에 있는 특정 물건을 골라서 반환하는 메서드 구현하세요
    public Food getFood(Food food) {
        foods.remove(food);
        return food;
    }
}
