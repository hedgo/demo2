package com.example.demo2.api;

import com.example.demo2.api.dto.TestResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestApi {

    @GetMapping("/api/test1")
    @ResponseBody
    public TestResponse test() {
        System.out.println("Rest called!");
        return TestResponse.builder().name("Andrzej").age(40).role("IT guy").build();
    }

    @GetMapping("/api/test2")
    @ResponseBody
    public String getFoos(@RequestParam String id) {
        return "ID: " + id;
    }
}
