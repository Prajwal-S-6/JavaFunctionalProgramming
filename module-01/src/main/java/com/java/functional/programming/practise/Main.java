package com.java.functional.programming.practise;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Main {

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Predicate<Integer> isEven = (val) -> val % 2 == 0;
        integerList.stream().filter(isEven).forEach(System.out::println);

        System.out.println("------------------------------------------------------------------");
        UnaryOperator<Integer> square = (val) -> val * val;
        integerList.stream().map(square).forEach(System.out::println);

        System.out.println("------------------------------------------------------------------");
        BinaryOperator<Integer> sumOfNums = (a,b) -> a + b;
        System.out.println(integerList.stream().reduce(0, sumOfNums));
        System.out.println(integerList.stream().reduce(0, Integer::sum));

        System.out.println("------------------------------------------------------------------");
        System.out.println(integerList.stream().filter(isEven).count());

        System.out.println("------------------------------------------------------------------");
        Predicate<Integer> isAllPositive = (val) -> val >= 0;
        System.out.println(integerList.stream().allMatch(isAllPositive));

        System.out.println("------------------------------------------------------------------");
        System.out.println(integerList.stream().filter(val -> val > 5).findFirst());


        System.out.println("------------------------------------------------------------------");
        System.out.println(integerList.stream().collect(groupingBy( Function.identity(), mapping(val -> val * 2, toList()))));
        System.out.println(integerList.stream().collect(groupingBy( val -> val % 2, Collectors.toMap(Integer::valueOf, (val) -> val * 2))));


        System.out.println("------------------------------------------------------------------");
        List<String> l1 = Arrays.asList("a", "b", "c");
        List<String> l2 = Arrays.asList("d", "e","f");
        List<String> l3 = Stream.concat(l1.stream(), l2.stream()).toList();
        System.out.println(l3);

        System.out.println("------------------------------------------------------------------");
        String test = "abracadabra";
        System.out.println(test.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(val -> val, Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() == 1).map(Map.Entry::getKey).findFirst());
        System.out.println(Arrays.stream(test.split(""))
                .collect(groupingBy(val -> val, counting()))
                .entrySet().stream().filter(e -> e.getValue() == 1).map(Map.Entry::getKey).findFirst());

        System.out.println("------------------------------------------------------------------");
        Map<String, Integer> unsortedMap = new HashMap<>();
        unsortedMap.put("banana", 2);
        unsortedMap.put("apple", 5);
        unsortedMap.put("cherry", 1);

        Map <String, Integer> sortedMap = unsortedMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println(sortedMap);


        System.out.println("------------------------------------------------------------------");
        List<String> words = List.of("apple", "banana", "cherry", "date", "eggplant", "fig");

        System.out.println(words.stream().collect(Collectors.groupingBy(val -> val.charAt(0))));



    }


}
