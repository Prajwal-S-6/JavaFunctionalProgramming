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


    }


}
