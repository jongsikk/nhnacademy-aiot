package com.nhnacademy.app;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;

public class ApacheCommonsLang {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println(Objects.isNull("asdf"));
        System.out.println(StringUtils.isEmpty("asdf"));
    }
}
