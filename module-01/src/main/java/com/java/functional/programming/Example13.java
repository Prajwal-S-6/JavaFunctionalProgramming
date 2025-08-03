package com.java.functional.programming;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Example13 {

    public static void main(String[] args) throws IOException {

        List<String> ata = Files.lines(Paths.get("D:\\dev\\FunctionalProgramming\\JavaFunctionalProgramming\\module-01\\src\\main\\java\\com\\java\\functional\\programming\\text\\TextFile.txt"))
                    .toList().stream().map(s -> s.split(" ")).flatMap(Arrays::stream).distinct().sorted(Comparator.comparing(String::length).thenComparing(Comparator.reverseOrder())).toList();
        System.out.println(ata);

        Files.list(Paths.get("."))
                .filter(Files::isDirectory)
                .forEach(System.out::println);



    }
}
