package com.java.functional.programming.generics.inheritance;

import java.util.ArrayList;
import java.util.List;


public class GenericInheritance {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("A");
        names.add("B");
        names.add("C");
        names.add("D");
        printListElements(names);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        printListElements(numbers);


    }

    private static void printListElements(List<?> names) {
        names.stream().forEach(System.out::println);
    }
}

