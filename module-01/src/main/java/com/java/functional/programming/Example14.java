package com.java.functional.programming;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class Example14 {

    public static void main(String[] args) throws IOException {
        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    System.out.println(Thread.currentThread().getName() +":"+i);
                }
            }
        };




        ///
        Runnable runnable1 = () -> {
            IntStream.range(0,10000).forEach(i -> System.out.println(Thread.currentThread().getName() + ":" +i));
        };


        Thread thread0 = new Thread(runnable1);
        Thread thread1 = new Thread(runnable1);
        thread0.start();
        thread1.start();
    }
}
