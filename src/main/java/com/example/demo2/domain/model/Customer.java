package com.example.demo2.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@AllArgsConstructor(staticName = "of")
@Getter
@ToString
public class Customer {
    private String name;
    private Integer age;
}
