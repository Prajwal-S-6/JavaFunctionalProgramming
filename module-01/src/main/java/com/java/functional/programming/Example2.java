package com.java.functional.programming;

import com.sun.tools.javac.Main;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class Example2 {

    public static void main(String[] args) {
        List<Integer> numers = List.of(1,2,3,4,5,6,7,8,9);
        printoddNumbers(numers);

        System.out.println("-----------------------------------------");
        List<String> courses = List.of("Spring", "SpringBoot", "API", "Angular", "Docker", "Azure");
        printAllCourses(courses);

        System.out.println("-----------------------------------------");
        printCoursesContainingWordSpring(courses);

        System.out.println("-----------------------------------------");
        printCoursesWhoseNameisAleastSixLettters(courses);

        System.out.println("-----------------------------------------");
        printSquaresOfNumber(numers);

        System.out.println("-----------------------------------------");
        printSquareOfEvenNumer(numers);

        System.out.println("-----------------------------------------");
        printNumOfCharInCourseName(courses);

    }

    private static void printNumOfCharInCourseName(List<String> courses) {
        //courses.stream().forEach(course -> System.out.println(course.length()));
        // courses.stream().map(String::length).forEach(System.out::println);
        courses.stream().map(course -> course + " " + course.length())
                .forEach(System.out::println);
    }

    private static void printSquareOfEvenNumer(List<Integer> numers) {
        Predicate<Integer> isEven = (x) -> x % 2==0;
        numers.stream().filter(isEven)
                .map(even -> even * even)
                .forEach(System.out::println);
    }

    private static void printSquaresOfNumber(List<Integer> numers) {
//        numers.stream().forEach(num -> System.out.println(num*num));
        numers.stream().map(num -> num * num).forEach(System.out::println);
    }

    private static void printCoursesWhoseNameisAleastSixLettters(List<String> courses) {
        courses.stream().filter(Example2::isAtleastSix).forEach(System.out::println);
    }

    private static boolean isAtleastSix(String course) {
        return course.length() >= 6;
    }

    private static void printCoursesContainingWordSpring(List<String> courses) {
        Predicate<String> sprigWord = (str) -> str.contains("Spring");
        courses.stream().filter(sprigWord)
                .forEach(System.out::println);
    }

    private static void printAllCourses(List<String> courses) {
        courses.forEach(System.out::println);
    }

    private static void printoddNumbers(List<Integer> numers) {
        numers.stream().filter(num -> num % 2 != 0).forEach(System.out::println);
    }
}
