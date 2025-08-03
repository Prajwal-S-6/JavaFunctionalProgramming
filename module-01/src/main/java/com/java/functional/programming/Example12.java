package com.java.functional.programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Example12 {

    public static void main(String[] args) {

        List<String> courses = Arrays.asList("Spring", "SpringBoot", "API", "Angular", "Docker", "Azure" , "AWS","PCF");
        List<String> modifyablecouses = new ArrayList<>(courses);
        /// creates new list
        System.out.println(modifyablecouses.stream().map(String::toUpperCase).toList());
        System.out.println(modifyablecouses);

        /// replaceAll - will modify original list
        modifyablecouses.replaceAll(String::toUpperCase);
        System.out.println(modifyablecouses);

        modifyablecouses.removeIf(str -> str.length() < 6);
        System.out.println(modifyablecouses);



    }
}
