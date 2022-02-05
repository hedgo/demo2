package com.example.demo2.domain.streams;

import java.util.Collections;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//https://geek.justjoin.it/zastosowanie-stream-api-z-java-8-przyklady?gclid=CjwKCAiAl-6PBhBCEiwAc2GOVNwxmcUKv0vAlbWSGeu5_vIxmEK6zqFMLNsTXJul1_p5YGQfTRd1MBoC5KIQAvD_BwE
public class Stream1 {

    public static void main(String[] args) {
        test3();
    }

    static void test1() {//find name that starts with given letter
        Stream<String> namesStream = Stream.of("John", "Marry", "George", "Paul", "Alice", "Ann");
        namesStream.filter(e -> e.startsWith("M"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);
        //output:Mary
    }

    static void test2() {
        IntStream numbers = IntStream.of(2, 5, 10, 2, 4, 15, 5, 7, 3, 6);
//        numbers.boxed().collect(Collectors.joining());
        //.forEach(System.out::println);
        numbers.boxed().sorted(Collections.reverseOrder()).forEach(System.out::println);
//        IntStream.rangeClosed(1, 6).boxed().collect(Collectors.toList());
//                .forEach(System.out::println);
    }

    static void test3() {
        IntStream numbers = IntStream.of(2, 5, 10, 2, 4, 15, 5, 7, 3, 6);
//        numbers.boxed().collect(Collectors.joining());
        //.forEach(System.out::println);
        numbers.boxed().sorted(Collections.reverseOrder()).forEach(System.out::println);
//        IntStream.rangeClosed(1, 6).boxed().collect(Collectors.toList());
//                .forEach(System.out::println);
    }

}
