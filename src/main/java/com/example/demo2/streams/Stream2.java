package com.example.demo2.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Zadania z coding PS
public class Stream2 {

    public static void main(String[] args) {
        test1();
    }

    static void test1() {//posortuj odwrotnie listę integerów

        //1
        int[] numbers = {2, 6, 1, 8, 10, 2, 5, 3, 8};

        //2
        List<Integer> numbersList = new ArrayList<>() {{ //same as Arrays.asList()
            add(2);
            add(5);
            add(10);
            add(2);
        }};

        //3
        List<Integer> numberList2 = Arrays.asList(2, 3, 4, 10, 4, 1);

        //4
        Stream<Integer> numbersStream = Stream.of(2, 4, 5, 6, 7, 8, 10, 2, 1, 4);

        //todo: posotruj odwrotnie!!
        String sortedNumbers = Arrays.stream(numbers)
                .boxed()
                .sorted(Collections.reverseOrder())
                .map(Objects::toString)
                .collect(Collectors.joining(", "));
        System.out.println("sortedNumbers = " + sortedNumbers);
//        numbersList.stream().forEach(System.out::print);
//        numberList2.stream().forEach(System.out::print);
//        numbersStream.forEach(System.out::print);

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

}
