package com.example.demo.task;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StringTest {
    public static void main(String[] args) {
        String paragraph = "abcbb123410";

        // output: chars: 3, no: 4
        Map<Character, Long> charsCountMap = new HashMap<>();
        System.out.println("charsCountMap:" + charsCountMap);

        // output: a1b3c2
        String charsCount = "";
        System.out.println("charsCount:" + charsCount);

        // output: true: 5, flase: 6
        Map<Boolean, Long> charsAndDigitCountMap = new HashMap<>();
        System.out.println("charsAndDigitCountMap:" + charsAndDigitCountMap);

        // check anagram or not
        String input1 = "listen";
        String input2 = "silent";
        boolean anagram = false;

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
