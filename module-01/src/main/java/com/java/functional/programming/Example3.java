package com.java.functional.programming;

import java.util.List;
import java.util.function.BinaryOperator;

public class Example3 {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 13, 14, 15, 16, 12, 14, 15);
        printSumOfNumbers(numbers);
        //printFirstNumber(numbers);
        //printLasNumber(numbers);
        printMaxumber(numbers);
        printMinumber(numbers);
        //sortNumbers(numbers);

        System.out.println("-----------------------------------------------------------");

    }
    private static int min(int a , int b) {
        return Math.min(a, b);
    }

    private static void printMinumber(List<Integer> numbers) {
        System.out.println(numbers.stream().reduce(Example3::min));
        System.out.println(numbers.stream().reduce(Integer::min));
    }

    private static void printMaxumber(List<Integer> numbers) {
        System.out.println(numbers.stream().reduce((x, y) -> {
            if(x > y) return x;
            else return y;
        }));

        System.out.println(numbers.stream().reduce(Integer::max));

    }

    private static void printLasNumber(List<Integer> numbers) {
        System.out.println(numbers.stream().reduce((x,y) -> {
            System.out.println(x + " "+ y);
            return y;
        }));
    }

    private static void printFirstNumber(List<Integer> numbers) {
        System.out.println(numbers.stream().reduce((x,y) -> {
            System.out.println(x + " "+ y);
            return x;
        }));
    }

//    private static void sortNumbers(List<Integer> numbers) {
//        numbers.stream().
//    }

    private static void printSumOfNumbers(List<Integer> numbers) {
       // System.out.println(numbers.stream().reduce(Example3::sum).orElseThrow());
//        System.out.println(numbers.stream().reduce(6,(sum, num) -> {
//            System.out.println(sum + " " +num);
//            return sum + num;
//        }));
        BinaryOperator<Integer> sum = (x, y) -> x + y;
        System.out.println(numbers.stream().reduce(sum));
//        System.out.println(numbers.stream().reduce((x,y) -> Integer.sum(x,y)));
//        System.out.println(numbers.stream().reduce((sum, num) -> {
//            System.out.println(sum + " " +num);
//            return sum + num;
//        }).orElseThrow());
//        System.out.println(numbers.stream().reduce(Integer::sum).orElseThrow());
//        System.out.println(numbers.stream().reduce(6, Integer::sum));
    }

     static Integer sum(int a, int b) {

        System.out.println(a +" " +b);
        return a+b;
    }


}