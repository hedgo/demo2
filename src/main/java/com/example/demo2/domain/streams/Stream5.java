package com.example.demo2.domain.streams;

import com.example.demo2.domain.model.Customer;
import com.example.demo2.domain.model.Employee;
import org.springframework.util.comparator.Comparators;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Stream5 {

    public static void main(String[] args) {
        test5();
    }

    public static List<Customer> customerList = Arrays.asList(
            Customer.of("Andrzej", 40),
            Customer.of("Bartek", 35),
            Customer.of("Wojtek", 55),
            Customer.of("Mirek", 25),
            Customer.of("Bolek", 35));

    private static void test1() {
        customerList.stream().sorted((o1, o2) -> o2.getAge().compareTo(o1.getAge())).forEach(System.out::println);
    }

    private static void test3() {
        test2(s -> s.length());
        test2(String::length);

        Function<Customer, Employee> function1 = customer -> Employee.of(customer.getName(), customer.getAge(), null, null);
        customerList.stream().map(function1).collect(Collectors.toUnmodifiableList()).forEach(System.out::println);

    }

    private static void test2(Function<String, Integer> myFunction) {
        Integer result = myFunction.apply("Ala ma kota");
        System.out.println("result = " + result);
    }

    private static void test4() {

        //1. sort collection with lambda
        customerList.sort((o1, o2) -> o1.getAge().compareTo(o2.getAge()));
        //2. sort collection with helper from Comparator
        customerList.sort(Comparator.comparing(Customer::getAge).reversed());
        customerList.sort(Comparator.comparing(Customer::getName).reversed().thenComparing(Customer::getAge));

        customerList.forEach(System.out::println);

    }

    private static void test5() {
        IntSummaryStatistics intSummaryStatistics = customerList.stream()
                .mapToInt(Customer::getAge)
//                .sum()
//                .average()
//                .max()
//                .min()
//                .count()
                .summaryStatistics();

        System.out.println("intSummaryStatistics = " + intSummaryStatistics);

        int sumLat = customerList.stream()
                .mapToInt(Customer::getAge)
                .reduce(0, (left, right) -> left + right);
        System.out.println("sumLat = " + sumLat);

        OptionalInt sumLat2 = customerList.stream()
                .mapToInt(Customer::getAge)
                .reduce(Integer::sum);
//                .reduce(Integer::max);
//                .reduce(Integer::min);

        System.out.println("sumLat2 = " + sumLat2.orElse(0));

        //najlepsze, robimy mapToInt i jedziemy bezposrednio z funkcja np MAX
        OptionalInt sumLat3 = customerList.stream()
                .mapToInt(Customer::getAge)
                .max();
//                .count()
//                .min()
//                .sum();

        System.out.println("sumLat3 = " + sumLat3.orElse(0));

    }


}
