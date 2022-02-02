package com.example.demo2.api.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TestResponse {
    String name;
    Integer age;
    String role;
}
