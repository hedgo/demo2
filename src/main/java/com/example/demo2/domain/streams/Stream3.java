package com.example.demo2.domain.streams;

import com.example.demo2.domain.model.Customer;
import com.example.demo2.domain.model.Employee;
import com.example.demo2.domain.model.Skill;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Moje testy
public class Stream3 {

    public static void main(String[] args) {
        test2();
    }

    private static void test1() {
        List<Employee> employeeList = Arrays.asList(
                Employee.of("Andy", 40, BigDecimal.valueOf(1000), List.of(Skill.JAVA, Skill.DOCKER)),
                Employee.of("Roy", 26, BigDecimal.valueOf(500), Arrays.asList(Skill.C, Skill.KUBERNATES, Skill.DESIGN)),
                Employee.of("Mary", 34, BigDecimal.valueOf(800),
                        new ArrayList<>() {{
                            add(Skill.JAVA);
                            add(Skill.DOCKER);
                        }}),
                Employee.of("Jack", 32, BigDecimal.valueOf(800), Stream.of(Skill.DDD, Skill.AWS, Skill.DOCKER).collect(Collectors.toList()))
        );
        employeeList.stream()
                .filter(employee -> employee.getAge() > 5)
                .map(employee -> Customer.of(employee.getName(), employee.getAge()))
                .sorted(Comparator.comparing(Customer::getAge).reversed().thenComparing(Customer::getName))
//                .findFirst().ifPresent(System.out::println);
//                .anyMatch(customer -> customer.getName().startsWith("R"));
                .forEach(System.out::println);

    }

    public static void test2() { //generacja liczb
        String result = Stream.iterate(0, n -> n + 2)
                .limit(100)
                .map(Objects::toString).collect(Collectors.joining(","));
        System.out.println("result = " + result);

        Stream.iterate(0, n -> n < 100, n -> n + 2) //w java9, z predicate, bez limit()
                .map(Objects::toString).collect(Collectors.joining(","));
        ;
        System.out.println("result = " + result);

        Stream.generate(Math::random).limit(10).forEach(System.out::println);
//        IntStream.rangeClosed(1,100).forEach(System.out::println);
    }

}
