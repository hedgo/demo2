package com.example.demo2.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//https://geek.justjoin.it/zastosowanie-stream-api-z-java-8-przyklady?gclid=CjwKCAiAl-6PBhBCEiwAc2GOVNwxmcUKv0vAlbWSGeu5_vIxmEK6zqFMLNsTXJul1_p5YGQfTRd1MBoC5KIQAvD_BwE
public class Test1 {

    public static void main(String[] args) {
        test2();
    }

    static void test1() {//find name that starts with given letter
        Stream<String> namesStream = Stream.of("John", "Marry", "George", "Paul", "Alice", "Ann");
        namesStream.filter(e -> e.startsWith("M"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);
        //output:Mary
    }

    static void test2() {//letters count
        String input = "aaabbbcccdbb";

        Stream<Character> characterStream = input.chars().mapToObj(value -> (char) value);
        Map<Character, Long> resultMap = characterStream.collect(Collectors.groupingBy(character -> character, Collectors.counting()));
        resultMap.forEach((oneChar, countOfChar) -> System.out.print(oneChar.toString() + countOfChar));

        //here in on command:)
        input.chars().mapToObj(value -> (char) value)
                .collect(Collectors.groupingBy(character -> character, Collectors.counting()))
                .forEach((oneChar, countOfChar) -> System.out.print(oneChar.toString() + countOfChar));

        //output: a3b5c3d1
    }

    static void test3() {


    }
}
