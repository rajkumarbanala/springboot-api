package com.example.demo.task;

import java.util.*;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "ball", "cat", "apple", "microservice", "abcdefghijklm", "ab", "a");

        // count how many times each word appears (preserve original order)
        Map<String, Long> countMap = null;
        countMap = list.stream().collect(Collectors.groupingBy(w -> w, LinkedHashMap::new, Collectors.counting()));
        System.out.println(countMap);

        // Find the longest word that contains only unique characters (i.e., no repeated letters)
        String highestLengthString = null;

        highestLengthString = list.stream()
                .filter(w -> w.chars().distinct().count() == w.length())
                .distinct()
                .sorted(Comparator.comparing(String::length).reversed())
                .findFirst().get();
        System.out.println("highestLengthString:" + highestLengthString);

        // Find the length of that longest unique-character word
        long longestLength = 0;
        longestLength = list.stream()
                .filter(w -> w.chars().distinct().count() == w.length())
                .distinct()
                .sorted(Comparator.comparing(String::length).reversed())
                .findFirst().get().length();
        System.out.println("longestLength:" + longestLength);
    }
}
