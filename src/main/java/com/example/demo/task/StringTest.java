package com.example.demo.task;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StringTest {
    public static void main(String[] args) {
        String input = "abcbb123410";

        // output: a:1, b:3, c:1
        Map<Character, Long> charsCountMap = new HashMap<>();
        charsCountMap = input.chars().mapToObj(c -> (char) c)
                .filter(c -> Character.isAlphabetic(c)).collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        System.out.println("charsCountMap:" + charsCountMap);

        // output: a1b3c1
        String charsCount = "";
        for (Map.Entry<Character, Long> e : charsCountMap.entrySet()) {
            charsCount += e.getKey() + "" + e.getValue();
        }
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

        input = "ababab";
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

        // Palindrome check
        input = "madam";

        // Anagram check Input: "listen", "silent"
        input1 = "listen";
        input2 = "silent";

        // First non-repeating Input: "swiss", output: w
        input = "swiss";

        // reverse word: apple ball cat to cat ball apple
        input = "apple ball cat";


    }
}
