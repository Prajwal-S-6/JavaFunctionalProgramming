package com.java.functional.programming;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Example8 {

    public static void main(String[] args) {
        System.out.println(Stream.of(1,2,3,4,5).reduce(Integer::sum));

        int[] intArr = {1,2,3,4,5};
        System.out.println(Arrays.stream(intArr).sum());
        System.out.println(Arrays.stream(intArr).average());
        System.out.println(Arrays.stream(intArr).max());
        System.out.println(Arrays.stream(intArr).min());

        // IntStream.range(1,10).forEach(System.out::println);
        IntUnaryOperator iu = (val) -> val*2;
        IntStream.iterate(5, iu).limit(5).forEach(System.out::println);

        IntPredicate ip = (val) -> val < 60;
        IntStream.iterate(5,ip, iu).forEach(System.out::println);

        IntUnaryOperator iu1 = (val) -> val+2;
        System.out.println(IntStream.iterate(2, value -> value < 10 , iu1).filter(v->v%2==0).peek(System.out::println).sum());


        IntUnaryOperator iu2 = (val) -> val*2;
        System.out.println(IntStream.iterate(2, iu2).limit(10).peek(System.out::println).sum());

        System.out.println(IntStream.iterate(2, iu2).limit(10).mapToObj(Integer::valueOf).collect(Collectors.toList()));
        System.out.println(IntStream.iterate(2, iu2).limit(10).boxed().collect(Collectors.toList()));

        System.out.println(LongStream.iterate(1L, (value -> value+1L)).limit(60L).mapToObj(BigInteger::valueOf).reduce((BigInteger::multiply)));
    }
}
