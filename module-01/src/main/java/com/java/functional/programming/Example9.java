package com.java.functional.programming;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Example9 {

    public static void main(String[] args) {
        /// Collectors.joining
        List<String> courses = List.of("Spring", "SpringBoot", "API", "Angular", "Docker", "Azure" , "AWS","PCF");
        List<String> courses1 = List.of("Spring", "SpringBoot", "API", "Angular", "Docker", "Azure");

        System.out.println(courses.stream().reduce((c1, c2) -> c1 +","+c2).get());
        System.out.println(courses.stream().collect(Collectors.joining(",")));
        Optional<Integer> sum = courses.stream().map(c -> c.split("")).toList().stream().map(strArr -> strArr.length).peek(System.out::println).reduce(Integer::sum);
        System.out.println(sum);


        /// flatMap
        List<List<Integer>> ListList = List.of(List.of(1,2,3),List.of(4,5,6));
        System.out.println(ListList.stream().flatMap(Collection::stream).collect(Collectors.toList()));

        Optional<Integer> sum1 = courses.stream().flatMap(course -> Arrays.stream(course.split(""))).map(String::length).reduce(Integer::sum);
        System.out.println(sum1);

        System.out.println(courses.stream().flatMap(course -> Arrays.stream(course.split(""))).toList());

        List<List<String>> comined = courses.stream().flatMap(c ->courses1.stream().filter(l1 -> l1.length() == c.length() && !l1.equals(c)).map(c1 -> List.of(c,c1))).collect(Collectors.toList());
        System.out.println(comined);

    }
}
