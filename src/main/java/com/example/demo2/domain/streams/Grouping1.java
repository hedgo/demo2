package com.example.demo2.domain.streams;

import com.example.demo2.domain.model.Customer;
import com.example.demo2.domain.model.Wiek;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Grouping1 {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        //grupuje po wieku
        Map<Integer, List<Customer>> map1 = Stream4.customerList.stream()
                .collect(Collectors.groupingBy(Customer::getAge));//ta wersja groupingBy przyjmuje ze drugi argument to toList(), shorthand
//                .collect(Collectors.groupingBy(Customer::getAge, Collectors.toSet()));
        System.out.println("map1 = " + map1);

        //grupuje po wieku i zlicza liczbe wystapien
        Map<Integer, Long> map2 = Stream4.customerList.stream()
                .collect(Collectors.groupingBy(
                        Customer::getAge,
                        Collectors.counting()));
        System.out.println("map2 = " + map2);

        //w ramach kazdego nazwiska znajduje najstarszego maxBy (lub najmlodszego minBy)
        Map<String, Customer> map3 = Stream4.customerList.stream()
                .collect(Collectors.groupingBy(
                        Customer::getName,
                        Collectors.collectingAndThen(//jak dodam tego warpera to moge wykonac jeszcze np Optional::get, bez tego zwracalby Optionale
                                Collectors.maxBy(Comparator.comparing(Customer::getAge)),
                                Optional::get)
                ));
//                      Collectors.minBy(Comparator.comparing(Customer::getAge))));
        System.out.println("map3 = " + map3);

        //grupuje po nazwie i odfiltrowywuje starszych niz 30 lat
        Map<String, List<Customer>> map4 = Stream4.customerList.stream()
                .collect(Collectors.groupingBy(
                        Customer::getName,
                        Collectors.filtering(customer -> customer.getAge() < 30, Collectors.toList()))
                );
        System.out.println("map4 = " + map4);

        //super, grupuje po wieku ale wedlug podanych zakresow, kluczem mapy bedzie rozdzielajacy enum
        Map<Wiek, List<Customer>> map5 = Stream4.customerList.stream()
                .collect(Collectors.groupingBy(customer -> {
                    if (customer.getAge() <= 20) return Wiek.YOUNG;
                    else if (customer.getAge() <= 40) return Wiek.NORMAL;
                    else return Wiek.OLD;
                }));
        System.out.println("map5 = " + map5);

        //grupuje po nazwie,a potem przemapowywuje kazdy elemeny grupy, na Age
        Map<String, List<Integer>> map6 = Stream4.customerList.stream().collect(Collectors.groupingBy(
                Customer::getName,
                Collectors.mapping(Customer::getAge, Collectors.toList())));
        System.out.println("map6 = " + map6);

        //podwoje grupownie i jeszcze przemapowanie w grupach Customer na nazwe - respect
        Map<String, Map<Wiek, List<String>>> map7 = Stream4.customerList.stream().collect(
                Collectors.groupingBy(
                        Customer::getName,
                        Collectors.groupingBy(customer -> {
                            if (customer.getAge() <= 20) return Wiek.YOUNG;
                            else if (customer.getAge() <= 40) return Wiek.NORMAL;
                            else return Wiek.OLD;
                        }, Collectors.mapping(Customer::getName, Collectors.toList()))));
        System.out.println("map7 = " + map7);

        //grupuje po nazwie i potem sumuje liczbe lat Customerow w obrebie grupy
        Map<String, Integer> map8 = Stream4.customerList.stream().collect(
                Collectors.groupingBy(
                        Customer::getName,
                        Collectors.summingInt(Customer::getAge)
                ));
        System.out.println("map8 = " + map8);
    }
}
