package com.java.functional.programming.generics.inheritance;

import java.util.ArrayList;
import java.util.List;

public class GenericUpperBound {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("A");
        names.add("B");
        names.add("C");
        names.add("D");
        // printNumbers(names);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        printNumbers(numbers);

        List<Double> doubles = new ArrayList<>();
        doubles.add(10.0d);
        doubles.add(12.0d);
        printNumbers(doubles);

    }


    private static void printNumbers(List<? extends Number> numbers) {
        numbers.stream().forEach(System.out::println);
        // numbers.add(1);
        Number number =  numbers.get(0);
    }
}

