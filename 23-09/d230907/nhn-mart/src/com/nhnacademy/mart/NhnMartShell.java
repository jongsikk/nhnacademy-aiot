package com.nhnacademy.mart;

import java.util.Scanner;

import com.nhnacademy.mart.BuyList.Item;

public class NhnMartShell {

    public static void main(String[] args) {
        NhnMart mart = new NhnMart();
        mart.prepareMart();

        BuyList buyList = inputBuyListFromShell();

        // TODO 본인이름 영어로 변수명 작성!
        // 본인이름을 각자 맞게 영어로 변경
        // 홍길동 학생
        // -> hongGilDong or gilDong
        Customer 본인이름 = new Customer(buyList);

        // 장바구니를 챙긴다.
        본인이름.bring(mart.provideBasket());

        // 식품을 담는다.
        본인이름.pickFoods(mart.getFoodStand());

        // 카운터에서 계산한다.
        본인이름.payTox(mart.getCounter());
    }

    private static BuyList inputBuyListFromShell() {
        // TODO Scanner 입력을 받아 buyList 만들기
        Scanner sc = new Scanner(System.in);
        String listString = sc.nextLine();
        String[] list = listString.split(" ");

        BuyList buyList = new BuyList();
        for (int i = 0; i < list.length; i += 2) {
            buyList.add(new Item(list[i], Integer.parseInt(list[i + 1])));
        }

        return buyList;
    }
}
