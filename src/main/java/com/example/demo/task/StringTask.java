package com.example.demo.task;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StringTask {
    public static void main(String[] args) {
        String paragraph = "abcbb123410";

        // output: chars: 3, no: 4
        Map<Character, Long> charsCountMap = new HashMap<>();
        charsCountMap = paragraph.chars().mapToObj(c -> (char) c).filter(c -> Character.isAlphabetic(c)).collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        System.out.println("charsCountMap:" + charsCountMap);

        // output: a1b3c2
        String charsCount = charsCountMap.entrySet().stream().map(e -> e.getKey() + "" + e.getValue()).collect(Collectors.joining());
        System.out.println("charsCount:" + charsCount);

        // output: true: 5, flase: 6
        Map<Boolean, Long> charsAndDigitCountMap = new HashMap<>();
        Predicate<Character> predicate = (c) -> Character.isAlphabetic(c);
        charsAndDigitCountMap = paragraph.chars().mapToObj(c -> (char) c).collect(Collectors.partitioningBy((c) -> predicate.test(c), Collectors.counting()));
        System.out.println("charsAndDigitCountMap:" + charsAndDigitCountMap);

        // check anagram or not
        String input1 = "listen";
        String input2 = "silent";

        char[] v1 = input1.toCharArray();
        char[] v2 = input2.toCharArray();

        boolean anagram = true;

        if (input1.length() != input2.length()) {
            anagram = false;
        }

        Arrays.sort(v1);
        Arrays.sort(v2);
        anagram = Arrays.equals(v1, v2);
        // or
        v1 = input1.toCharArray();
        v2 = input2.toCharArray();

        for (int i = 0; i < v1.length; i++) {

            boolean found = false;

            for (int j = 0; j < v2.length; j++) {
                if (v1[i] == v2[j]) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                anagram = false;
                break;
            }
        }

        for (int i = 0; i < v2.length; i++) {

            boolean found = false;

            for (int j = 0; j < v1.length; j++) {
                if (v2[i] == v1[j]) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                anagram = false;
                break;
            }
        }

        if (anagram) {
            System.out.println("anagram");
        } else {
            System.out.println("not anagram");
        }

        String input = "ababab";
        // output: abab
        // prefix:[a, ab, aba, ababa, abab]
        // suffix:[ab, b, bab, babab, abab]
        // find max length string with has common elements from prefix words & suffix words
        // String maxLengthString = ?
        Set<String> prefix = new HashSet<>();
        Set<String> suffix = new HashSet<>();
        int i = 1;
        int j = input.length() - 1;
        for (int k = 1; k < input.length(); k++) {
            String pr = input.substring(0, i);
            String sf = input.substring(j, input.length());
            prefix.add(pr);
            suffix.add(sf);
            i++;
            j--;
        }
        System.out.println("prefix:" + prefix);
        System.out.println("suffix:" + suffix);
        String maxElement = null;
        int l = 1;
        for (String sf : suffix) {
            if (!prefix.add(sf)) {
                if (maxElement == null) {
                    maxElement = sf;
                }
                if (sf.length() > maxElement.length()) {
                    maxElement = sf;
                }
            }
        }
        System.out.println("maxElement:" + maxElement);


    }
}
