package com.example.demo2.domain.streams;

import com.example.demo2.domain.model.Customer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Stream4 {

    private static List<Customer> customerList = Arrays.asList(
            Customer.of("Andrzej", 40),
            Customer.of("Bartek", 35),
            Customer.of("Wojtek", 55),
            Customer.of("Mirek", 25),
            Customer.of("Bolek", 35));

    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        //1. lambda bezposrednio
        customerList.stream().filter(customer -> customer.getAge() > 40)
                .forEach(System.out::println);
        //2. zwykla metoda, zwracajaca lambde:)
        customerList.stream().filter(posortuj())
                .forEach(System.out::println);
        //3. metoda o sygnaturze jak potrzebna lambda, wiec mozemy zapisac jako method reference
        customerList.stream().filter(Stream4::sortowanie)
                .forEach(System.out::println);

        Predicate<Customer> kolejneSortowanie = customer -> customer.getAge() > 20;
        //4. zmienna, ktora trzyma lambde
        customerList.stream().filter(kolejneSortowanie)
                .forEach(System.out::println);

    }

    private static Predicate<Customer> posortuj() {
        return customer -> customer.getAge() > 20;
    }

    private static boolean sortowanie(Customer customer) {
        return customer.getAge() > 35;
    }


}
