package com.java.functional.programming;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Example4 {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(6,5,4,3,2,1,2,4,6);
        List<String> courses = List.of("Spring", "SpringBoot", "API", "Angular", "Docker", "Azure");

        printSumOfSquares(numbers);
        System.out.println("............");
        printSumOfCubes(numbers);
        System.out.println("............");
        printSumOfEvenNums(numbers);
        System.out.println("............");
        printDistinctNumbers(numbers);
        System.out.println("............");
        printSortedNumbers(numbers);
        System.out.println("............");
        printsortedCourses(courses);
        System.out.println("............");
        printDouledlist(numbers);
        System.out.println("............");
        printEachCoursesLengthList(courses);
        System.out.println("............");
        Stream.of("ABCD").forEach(System.out::println);

       
    }

    private static void printEachCoursesLengthList(List<String> courses) {
        List<Integer> len = courses.stream().sorted().map(c-> c.length()).collect(Collectors.toList());
        System.out.println(len);
    }


    private static void printDouledlist(List<Integer> numbers) {
        Function<Integer, Integer> douleFunc = n-> n*2;
        List<Integer> list = numbers.stream().map(douleFunc).collect(Collectors.toList());
        System.out.println(list);
    }

    private static void printsortedCourses(List<String> courses) {
        courses.stream().sorted().forEach(System.out::println);
//        courses.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        //courses.stream().sorted(Comparator.comparing(str -> str.length())).forEach(System.out::println);
        //courses.stream().sorted(Example4::comparator).forEach(System.out::println);
    }

    private static int comparator(String s1, String s2) {
        if(s1.length() > s2.length()) return 1;
        else if(s1.length() < s2.length()) return -1;
        else return 0;
    }



    private static void printSortedNumbers(List<Integer> numbers) {
        Consumer<Integer> sysOut = (x) -> System.out.println(x);
        numbers.stream().sorted().distinct().forEach(sysOut);
        List<Integer> sortedNums = numbers.stream().sorted().toList();
        System.out.println(sortedNums);
    }

    private static void printDistinctNumbers(List<Integer> numbers) {
        numbers.stream().distinct().forEach(System.out::println);
    }

    private static void printSumOfEvenNums(List<Integer> numbers) {
        System.out.println(numbers.stream().filter(Example1::isEven).reduce(Example3::sum));
    }

    private static void printSumOfCubes(List<Integer> numbers) {
        System.out.println(numbers.stream().map(num -> num*num*num).reduce(Integer::sum));
    }

    private static void printSumOfSquares(List<Integer> numbers) {
        //System.out.println(numbers.stream().map(num -> num*num).reduce(Integer::sum));
        System.out.println(numbers.stream().reduce(0,(x,y) -> {
            return x + y*y;
        }));
    }


}