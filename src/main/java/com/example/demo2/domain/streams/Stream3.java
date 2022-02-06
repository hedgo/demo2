package com.example.demo2.domain.streams;

import com.example.demo2.domain.model.Customer;
import com.example.demo2.domain.model.Employee;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//Moje testy
public class Stream3 {

    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        List<Employee> employeeList = Arrays.asList(
                Employee.of("Andy", 40, BigDecimal.valueOf(1000), "Tech Lead"),
                Employee.of("Roy", 26, BigDecimal.valueOf(500), "Developer"),
                Employee.of("MAry", 34, BigDecimal.valueOf(800), "Scrum Master")
        );
        employeeList.stream()
                .filter(employee -> employee.getAge() > 5)
                .map(employee -> Customer.of(employee.getName(), employee.getAge()))
                .sorted(Comparator.comparing(Customer::getAge).reversed().thenComparing(Customer::getName))
//                .findFirst().ifPresent(System.out::println);
//                .anyMatch(customer -> customer.getName().startsWith("R"));
                .forEach(System.out::println);

    }
}
