package com.java.functional.programming;

import java.util.List;
import java.util.Random;
import java.util.function.*;

import static java.lang.Math.random;

public class Example5 {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(1,2,3,4,5);

        Predicate<Integer> evenPredicate = n -> n % 2 == 0;
        Predicate<Integer> oddPredicate = n -> n % 2 != 0;
        filterAndprint(numbers, evenPredicate);
        System.out.println("----------------------");
        filterAndprint(numbers, oddPredicate);
        Function<Integer, Integer> doubleNum = (x) -> x * 2;
        UnaryOperator<Integer> doubleUnaryNum = (x) -> x * 2;
        Function<Integer, Integer> tripleNum = (x) -> x * 3;
        Function<Integer, Integer> squareNum = (x) -> x * x;
        System.out.println("----------------------");
        List<Integer> doubleList = getList(numbers, doubleUnaryNum);
        System.out.println(doubleList);
        System.out.println("----------------------");
        List<Integer> TripleList = getList(numbers, tripleNum);
        System.out.println(TripleList);
        System.out.println("----------------------");
        List<Integer> square = getList(numbers, squareNum);
        System.out.println(square);

        /// -------------------------------------------------------------
        /// Supplier
        Supplier<Integer> randomInteger = () -> new Random().nextInt(0,5);
        System.out.println(randomInteger.get());

        ///----------------------------------------------------------------------
        /// BiPredicate
        BiPredicate<Integer, String> biPre = (num, str) -> num == str.length();
        System.out.println(biPre.test(6, "spring"));

        /// -------------------------------------------------------------------------
        /// BiFunction
        BiFunction<Integer, String, String> biFun = (num, str) -> str + num;
        System.out.println(biFun.apply(5, "$"));

        /// ------------------------------------------------------------------------
        /// BiConsumer
        BiConsumer<Integer, String> biCon = (num, str) -> System.out.println(num + " " + str);
        biCon.accept(6, "ABC");

        /// --------------------------------------------------------------------
        IntPredicate intPredicate = (x) -> x % 2 == 0;
        System.out.println(intPredicate.test(2));

    }

    private static List<Integer> getList(List<Integer> numbers, Function<Integer, Integer> icreaseFunc) {
        return numbers.stream().map(icreaseFunc).toList();
    }

    private static void filterAndprint(List<Integer> numbers, Predicate<Integer> predicate) {
        numbers.stream()
                .filter(predicate)
                .forEach(System.out::println);
    }


}