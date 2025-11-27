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
        int iIndex = 1;
        int jIndex = input.length() - 1;
        for (int k = 1; k < input.length(); k++) {
            String pr = input.substring(0, iIndex);
            String sf = input.substring(jIndex, input.length());
            prefix.add(pr);
            suffix.add(sf);
            iIndex++;
            jIndex--;
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

        // using two pointer concept
        boolean isPalindrom = true;
        int left = 0;
        int right = input.length() - 1;
        while (left < right) {
            if (input.charAt(left) != input.charAt(right)) {
                isPalindrom = false;
                break;
            }
            left++;
            right--;
        }
        if (isPalindrom) {
            System.out.println("palindrom:" + input);
        } else {
            System.out.println("not palindrom:" + input);
        }

        // or using StringBuilder
        int mid = input.length() / 2;
        String leftWord = input.substring(0, mid);
        String rightWord = new StringBuffer(input.substring(mid + 1, input.length())).reverse().toString();
        if (leftWord.equals(rightWord)) {
            System.out.println("palindrom:" + input);
        } else {
            System.out.println("not palindrom:" + input);
        }

        // Anagram check Input: "listen", "silent"
        input1 = "listen";
        input2 = "silent";
        char[] ch1 = input1.toCharArray();
        char[] ch2 = input2.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        if (input1.length() == input2.length() && Arrays.equals(ch1, ch2)) {
            System.out.println("anagram: " + input1 + " : " + input2);
        } else {
            System.out.println("not anagram: " + input1 + " : " + input2);
        }

        // First non-repeating Input: "swiss", output: w
        input = "swiss";
        int[] output = new int[256];
        Character nonRepChar = null;

        for (char ch : input.toCharArray()) {
            output[ch]++;
        }
        for (char ch : input.toCharArray()) {
            if (output[ch] == 1) {
                nonRepChar = ch;
                break;
            }
        }
        System.out.println("non repeating char:" + nonRepChar);

        // reverse word: apple ball cat to cat ball apple
        input = "apple ball cat";
        String[] words = input.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            sb.append(" ");
        }
        System.out.println("reverse word: " + sb.toString());


    }
}
