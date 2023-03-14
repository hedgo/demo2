package com.example.demo2.test1;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test1 {

    //Number of pairs in Array	Write java function which calculates number of pairs in array.
    // Pair is when two numbers added together, result is zero.

    private static List<Integer> integerList = Stream.of(1, 2, -1, 1).toList();
    private static Stream<Integer> integerStremList = Stream.of(1, 2, -1, 1, -2, 2, -2, -2, -1, 5);
    private static IntStream integerIntStremList = IntStream.of(1, 2, -1, 1);
    private static int[] integerArray = {1, 2, -1, 1};


    public static void main(String[] args) {
        test2();
    }


    private static void test2() {
        //0. check if table is not empty or null
        //1. get 1st element than

//        Map<Integer, Long> allInMap = integerStremList.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//        System.out.println("allInMap = " + allInMap);

        Long wynik = 0L;
        Map<Boolean, Map<Integer, Long>> partitioned = integerStremList.collect(Collectors.partitioningBy(intKey -> intKey > 0,
                Collectors.groupingBy(Function.identity(), Collectors.counting())));
        System.out.println("partitioned = " + partitioned);

        for (Entry<Integer, Long> onePositiveEntry : partitioned.get(true).entrySet()) {

            if(partitioned.get(false).containsKey(-onePositiveEntry.getKey())) {
                Long positiveCount = onePositiveEntry.getValue();
                Long negativeCount = partitioned.get(false).get(-onePositiveEntry.getKey());
                wynik += positiveCount < negativeCount ? positiveCount : negativeCount;
            }

        }

        System.out.println("wynik = " + wynik);

//        Map<Boolean, Set<Integer>> partitioned = integerStremList.collect(Collectors.partitioningBy(intKey -> intKey > 0, Collectors.toSet()));

//        Set<Integer> integers = partitioned.get(true);
//        System.out.println("integers = " + integers);
//
//
//        Set<Integer> onlyPairs = partitioned.get(true).stream().filter(x -> partitioned.get(false).contains(-x)).collect(Collectors.toSet());
//        System.out.println("onlyPairs = " + onlyPairs);


//        Long numerOfPairForGivenKey = 0L;
//
//        Set<Entry<Integer, Long>> positiveOnly = allInMap.entrySet().stream().filter(e -> e.getKey() > 0).collect(Collectors.toSet());
//        System.out.println("positiveOnly = " + positiveOnly);
//
//        for (Entry<Integer, Long> e : positiveOnly) {
//            Integer negativeKey = -e.getKey();
//            if (allInMap.containsKey(negativeKey)) {
//                Long positiveValue = e.getValue();
//                Long negativeValue = allInMap.get(negativeKey);
//                numerOfPairForGivenKey = negativeValue < positiveValue ? negativeValue : positiveValue;
//                wynik += numerOfPairForGivenKey;
//                System.out.println("numerOfPairForGivenKey = " + numerOfPairForGivenKey);
//            }
//        }
//
//        System.out.println("wynik = " + wynik);
//
//        List<Entry<Integer, Long>> onlyPossitive = allInMap.entrySet().stream().filter(x -> x.getKey() > 0).collect(Collectors.toList());


    }


    private static void test1() {
        //0. check if table is not empty or null
        //1. get 1st element than

        Map<Integer, Long> allInMap = integerStremList.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(allInMap);

        Long wynik = 0L;
        Long numerOfPairForGivenKey = 0L;

        Set<Entry<Integer, Long>> positiveOnly = allInMap.entrySet().stream().filter(e -> e.getKey() > 0).collect(Collectors.toSet());
        System.out.println("positiveOnly = " + positiveOnly);

        for (Entry<Integer, Long> e : positiveOnly) {
            Integer negativeKey = -e.getKey();
            if (allInMap.containsKey(negativeKey)) {
                Long positiveValue = e.getValue();
                Long negativeValue = allInMap.get(negativeKey);
                numerOfPairForGivenKey = negativeValue < positiveValue ? negativeValue : positiveValue;
                wynik += numerOfPairForGivenKey;
                System.out.println("numerOfPairForGivenKey = " + numerOfPairForGivenKey);
            }
        }

        System.out.println("wynik = " + wynik);

        List<Entry<Integer, Long>> onlyPossitive = allInMap.entrySet().stream().filter(x -> x.getKey() > 0).collect(Collectors.toList());

//        onlyPossitive.stream().reduce(0,(left, right) -> left.getValue() + right.getValue()));

    }
}
