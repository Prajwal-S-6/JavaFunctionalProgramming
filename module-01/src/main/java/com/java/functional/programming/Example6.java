package com.java.functional.programming;

import java.util.List;
import java.util.Random;
import java.util.function.*;

public class Example6 {
    public static void main(String[] args) {

        List<String> courses = List.of("Spring", "SpringBoot", "API", "Angular", "Docker", "Azure");
        courses.stream().map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));
        courses.stream().map(String::toUpperCase).forEach(System.out::println);

        Supplier<String> s = String::new;
    }




}