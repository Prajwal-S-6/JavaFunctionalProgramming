package com.java.functional.programming;

import java.util.*;
import java.util.stream.Collectors;

public class Example15 {


    public static void main(String[] args) {

        String sentence = """
                I am learning Streams API in JAVA
               """;

        System.out.println(Arrays.stream(sentence.split(" "))
                .collect(Collectors.groupingBy(String::length))
                .entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getKey))
                .get()
                .getValue()
                .getFirst());
    }
}
