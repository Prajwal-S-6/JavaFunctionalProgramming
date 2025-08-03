package com.java.functional.programming;

import java.util.stream.LongStream;

public class Example11 {

    public static void main(String[] args) {

        long duration =0L;

        for(int i=0; i< 50;i++) {
            long start1 = System.currentTimeMillis();
            LongStream.range(0,1000000000).sum();
            duration += (System.currentTimeMillis()- start1);
        }

        System.out.println("Average =" + (duration/50));




        long duration2 =0L;

        for(int i=0; i< 50;i++) {
            long start1 = System.currentTimeMillis();
            LongStream.range(0,1000000000).parallel().sum();
            duration2 += (System.currentTimeMillis()- start1);
        }

        System.out.println("Average =" + (duration2/50));

    }
}
