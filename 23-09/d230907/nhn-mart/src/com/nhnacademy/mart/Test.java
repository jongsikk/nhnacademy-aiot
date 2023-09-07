package com.nhnacademy.mart;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String listString = sc.nextLine();
        String[] list = listString.split(" ");
        // String[] name = new String[list.length / 2];
        // String[] amount = new String[list.length / 2];
        // int index1 = 0;
        // int index2 = 0;
        // for (int i = 0; i < list.length; i++) {
        // if (i % 2 == 0) {
        // name[index1] = list[i];
        // index1++;
        // } else {
        // amount[index2] = list[i];
        // index2++;
        // }
        // }
        for (int i = 0; i < list.length; i += 2) {
            System.out.println(list[i] + list[i + 1]);
        }
    }
}
