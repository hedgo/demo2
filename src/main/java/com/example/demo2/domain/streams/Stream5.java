package com.example.demo2.domain.streams;

import com.example.demo2.domain.model.Customer;
import com.example.demo2.domain.model.Employee;
import org.springframework.util.comparator.Comparators;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Stream5 {

    public static void main(String[] args) {
        test4();
    }

    private static List<Customer> customerList = Arrays.asList(
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
        customerList.stream().map(function1).collect(Collectors.toList()).forEach(System.out::println);

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


}
