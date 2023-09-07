package com.github.UlrikeWerner.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
                                            .toList();
        System.out.println("Zahlen aufsteigend sortiert: " + sortNumbers);
        System.out.println("-------");

        int sumOfNumbers = numbers.stream()
                                  .reduce(0, Integer::sum);
        System.out.println("Summe aller Zahlen: " + sumOfNumbers);
        System.out.println("-------");

        System.out.println("Jede einzelne Zahl der Liste ausgegeben: ");
        /*List<Integer> copyNumbers = */
        numbers.stream()
                .collect(Collectors.toList())
                .forEach(number -> System.out.print(number + ", "));
        System.out.println();
        System.out.println("-------");
    }
}
