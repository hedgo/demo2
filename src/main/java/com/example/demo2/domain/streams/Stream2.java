package com.example.demo2.domain.streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//PS
public class Stream2 {

    public static void main(String[] args) {
        test1();
        test2();
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
        Stream<Integer> input = Stream.of(2, 4, 5, 6, 7, 8, 10, 2, 1, 4);
        String output = input
                .sorted(Collections.reverseOrder())
                .map(Objects::toString)
                .collect(Collectors.joining(", "));

        int[] resultInts = Arrays.stream(numbers).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();
        System.out.println("resultInts = " + resultInts);

        System.out.println("sortedNumbers = " + output);
//        numbersList.stream().forEach(System.out::print);
//        numberList2.stream().forEach(System.out::print);
//        numbersStream.forEach(System.out::print);

    }

    static void test2() {//letters count
//        Stream<Character> characterStream = input.chars().mapToObj(value -> (char) value);
//        Map<Character, Long> resultMap = characterStream.collect(Collectors.groupingBy(character -> character, Collectors.counting()));
//        resultMap.forEach((oneChar, countOfChar) -> System.out.print(oneChar.toString() + countOfChar));

        //here in on command:)
//        input.chars().mapToObj(value -> (char) value)
//                .collect(Collectors.groupingBy(character -> character, Collectors.counting()))
//                .forEach((oneChar, countOfChar) -> System.out.print(oneChar.toString() + countOfChar));

        String input = "aaabbbcccdbb";
        String output = input.chars().mapToObj(value -> (char) value)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .map(characterLongEntry -> String.format("%s%s", characterLongEntry.getKey(), characterLongEntry.getValue()))
                .collect(Collectors.joining());

        System.out.println("collect = " + output);

        //output: a3b5c3d1
    }

}
