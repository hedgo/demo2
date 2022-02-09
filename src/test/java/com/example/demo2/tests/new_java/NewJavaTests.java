package com.example.demo2.tests.new_java;

import com.example.demo2.domain.model.Customer;
import com.example.demo2.domain.model.Employee;
import com.example.demo2.domain.new_java.Person;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

//Tutaj testuje nowosci w java:)
public class NewJavaTests {

    @Test
    void zmiennyTypuVar() {
        //super - nie muszę pisać jasno TYPU zmiennej, java sama sobie znajdzie co to:) zobacz best practices kiedy uzywac tego..
        var zmienna = Employee.of("andrzej", 40, BigDecimal.valueOf(10000), null);
        System.out.println(zmienna.getSalary());
    }

    @Test
    void rekordy() {
        //super - prościej robię struktury, trzymające tylko dane
        Person person = new Person("Adaś", 6);
        System.out.println("person.age() = " + person.age());
    }

    @Test
    void formatowanieTekstu() {
        //super - nie musze łączyć plusikami tekstów i dodawać jeszcze łamań linijek
        String myJson = """
                     [ {
                        "name": "kamil",
                "age": 33
                        },
                        {
                        "name": "andrzej",
                        "age": 35
                     } ]
                       """;
        System.out.println(myJson);
    }

    @Test
    void inicjowanieKolekcji() {
        List.of(Customer.of("andrzej", 40), Customer.of("bartek", 30));
        Set.of(Customer.of("andrzej", 40), Customer.of("bartek", 30));
        Map.of("andrzej", 40, "bartek", 30);
        Map.ofEntries(Map.entry("andrzej", 40), Map.entry("bartek", 30));
    }
}
