package com.nhnacademy.mart;

import java.util.ArrayList;

public class Basket {
    private final ArrayList<Food> foods = new ArrayList<>();

    // TODO 01 장바구니에 물건을 담는 메서드를 작성하세요.
    public void add(Food food) {
        foods.add(food);
    }

    // TODO 02 장바구니에 있는 물건들을 반환하는 메서드를 작성하세요.
    public ArrayList<Food> getFoods() {
        return foods;
    }
}
