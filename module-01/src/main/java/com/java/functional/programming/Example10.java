package com.java.functional.programming;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Example10 {

    public static void main(String[] args) {
        /// Collectors.joining
        List<String> courses = List.of("Spring", "SpringBoot", "API", "Angular", "Docker", "Azure" , "AWS","PCF");
        List<Integer> numbers = List.of(1,2,3,4,5);

        Optional<String> course = courses.stream().peek(System.out::println).filter(c -> c.length() >5).peek(System.out::println).map(String::toUpperCase).findFirst();
        System.out.println(course);

        System.out.println(numbers.stream().peek(System.out::println).filter(n-> n>2).peek(System.out::println).findFirst());
    }
}
