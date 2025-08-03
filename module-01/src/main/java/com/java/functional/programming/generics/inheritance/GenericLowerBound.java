package com.java.functional.programming.generics.inheritance;

import java.util.ArrayList;
import java.util.List;

public class GenericLowerBound {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();

        // printNumbers(names);

        List<Integer> integers = new ArrayList<>();

        //addNumbers(integers, 10);

        List<Double> doubles = new ArrayList<>();

        //addNumbers(doubles, 12.0d);

        List<Number> numbers = new ArrayList<>();
        addNumbers(numbers, 12.0d);
        addNumbers(numbers, 12);

//        Double i = (Double) numbers.get(0);
//        System.out.println(i);


    }

    private static void addNumbers(List<? super Number> numbers, Number i) {
        numbers.add(i);
    }


}
