package com.github.UlrikeWerner.Stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(5, 7, 2, 9, 0, 2, 3, 3, 4, 5, 6);
        List<Integer> evenNumbers = numbers.stream()
                                            .filter(number -> number % 2 == 0)
                                            .toList();
        System.out.println("Nur gerade Zahlen: " + evenNumbers);
        System.out.println("-------");

        List<Integer> multiNumbers = numbers.stream()
                                            .map(number -> number * 2)
                                            .toList();
        System.out.println("Verdoppelung der Zahlen: " + multiNumbers);
        System.out.println("-------");

        List<Integer> sortNumbers = numbers.stream()
                                            .sorted()
                                            .collect(Collectors.toList());
        System.out.println("Zahlen aufsteigend sortiert: " + sortNumbers);
        System.out.println("-------");

        int sumOfNumbers = numbers.stream()
                                  .reduce(0, Integer::sum);
        System.out.println("Summe aller Zahlen: " + sumOfNumbers);
        System.out.println("-------");

        System.out.println("Jede einzelne Zahl der Liste ausgegeben: ");
        numbers.forEach(number -> System.out.print(number + ", "));
        System.out.println();
        System.out.println("-------");

        System.out.println("Extra: ");
        try {
            Stream<String> data = Files.lines(Path.of("students.csv"));
            List<Student> studentData = data.skip(1)
                                            .map(String::trim)
                                            .filter(line -> !line.isEmpty())
                                            .distinct()
                                            .map(Student::new)
                                            .toList();
            data.close();
            System.out.println(studentData);
        } catch (IOException e) {
            System.err.println("Die Datei konnte nicht eingelesen werden!");
        }
    }
}
