package com.example.demo2.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

@Builder
@AllArgsConstructor(staticName = "of")
@Getter
@ToString
public class Employee {
    private String name;
    private Integer age;
    private BigDecimal salary;
    private List<Skill> skills;

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", skills=" + skills +
                "}\n";
    }
}
