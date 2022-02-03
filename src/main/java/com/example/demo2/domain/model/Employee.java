package com.example.demo2.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@Builder
@AllArgsConstructor(staticName = "of")
@Getter
@ToString
public class Employee {
    private String name;
    private Integer age;
    private BigDecimal salary;
    private String role;
}
