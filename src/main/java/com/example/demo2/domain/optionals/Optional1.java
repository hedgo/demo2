package com.example.demo2.domain.optionals;

import com.example.demo2.domain.streams.Stream5;

public class Optional1 {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        Stream5.customerList.stream()
                .findAny()
                .ifPresent(customer -> System.out.println(String.format("Znalazlem %s", customer)));

        Stream5.customerList.forEach(System.out::println);
    }
}
