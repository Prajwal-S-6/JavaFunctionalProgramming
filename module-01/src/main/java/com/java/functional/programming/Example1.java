package com.java.functional.programming;

import java.util.List;

public class Example1 {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 13, 14, 15, 16, 12, 14, 15);
        //printListOfNumbersFromListInStructured(numbers);
        printListOfEvenNumbersFromListInStructured(numbers);

        System.out.println("-----------------------------------------------------------");
        // printListOfNumbersFromListInFunctional(numbers);
        printListOfEvenNumbersFromListInFunctional(numbers);
    }

    private static void printListOfNumbersFromListInFunctional(List<Integer> numbers) {
        //numbers.forEach(number -> System.out.println(number));
        // numbers.forEach(System.out::println);
        numbers.stream().forEach(Example1::printNum);
    }

    private static void printListOfEvenNumbersFromListInFunctional(List<Integer> numbers) {
        // numbers.stream().filter(Main::isEven).forEach(Main::printNum);
        numbers.stream().filter(number -> number % 2 == 0).forEach(Example1::printNum);
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

//    private static Predicate<Integer> isEven(int num) {
//        return Predicate.isEqual(num % 2 == 0);
//    }

    private static void printNum(int number) {
        System.out.println(number);
    }

    private static void printListOfNumbersFromListInStructured(List<Integer> numbers) {
        for(int number: numbers) {
            System.out.println(number);
        }
    }

    private static void printListOfEvenNumbersFromListInStructured(List<Integer> numbers) {
        for(int number: numbers) {
            if(number % 2 == 0) {
                System.out.println(number);
            }

        }
    }
}