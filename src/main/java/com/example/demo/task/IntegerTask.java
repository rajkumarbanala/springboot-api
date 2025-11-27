package com.example.demo.task;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntegerTask {

    public static void main(String[] args) {
        int[] v = {1, 2, 3, 4, 5};
        int r = 2;

        // right rotate by with r positions
        int n = v.length;
        if (r > n) {
            r = r % n;
        }
        int[] output = new int[n];
        for (int i = 0; i < v.length; i++) {
            output[(i + r) % n] = v[i];
        }
        System.out.print("\nright rotate: ");
        for (int i : output) {
            System.out.print(i + ", ");
        }

        // left rotate by with r positions
        output = new int[n];
        for (int i = 0; i < v.length; i++) {
            output[i] = v[(i + r) % n];
        }
        System.out.print("\nleft rotate: ");
        for (int i : output) {
            System.out.print(i + ", ");
        }

        // find missing no in array
        v = new int[]{1, 2, 4, 5};
        int max = Arrays.stream(v).max().getAsInt();
        int expectedSum = max * (max + 1) / 2;
        int actualSum = Arrays.stream(v).sum();
        int missing = expectedSum - actualSum;
        System.out.println("\nmissing:" + missing);

        // First missing positive integer
        // output: 2
        v = new int[]{3, 4, -1, 1};
        max = Arrays.stream(v).max().getAsInt();
        expectedSum = max * (max + 1) / 2;
        actualSum = Arrays.stream(v).sum();
        missing = expectedSum - actualSum;
        System.out.println("\nmissing:" + missing);

        // Move zeros to end
        // output: [1, 3, 12, 0, 0]
        v = new int[]{0, 1, 0, 3, 12};
        int index = 0;
        for (int i = 0; i < v.length; i++) {
            if (v[i] != 0) {
                v[index] = v[i];
                index++;
            }
        }
        while (index < v.length) {
            v[index] = 0;
            index++;
        }
        System.out.println("zeros at last:" + Arrays.stream(v).boxed().collect(Collectors.toList()));

        // 2nd larget no
        v = new int[]{0, 1, 0, 3, 12};
        int secondLargetNo = 0;
        secondLargetNo = Arrays.stream(v).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.println("secondLargetNo:" + secondLargetNo);

        // remove duplicates
        v = new int[]{1, 1, 2, 2, 3, 4, 4};
        output = Arrays.stream(v).distinct().toArray();
        System.out.println("removed duplicates:" + Arrays.stream(output).boxed().collect(Collectors.toList()));

        // Two-sum pair input: arr=[1,5,7,-1, 5], target=6 Output: (1,5), (7,-1), should not display duplicate pairs like (1,5), (1, 5)
        v = new int[]{1, 5, 7, -1, 5};
        int target = 6;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < v.length; i++) {
            for (int j = i + 1; j < v.length; j++) {
                if (target == (v[i] + v[j])) {
                    List<Integer> values = new ArrayList<>();
                    values.add(v[i]);
                    values.add(v[j]);
                    list.add(values);
                }
            }
        }
        Set<String> uniquePairs = new HashSet<>();
        Set<Integer> seen = new HashSet<>();
        for (int value : v) {
            int compliment = target - value;
            if (seen.contains(compliment)) {
                int min = Math.min(compliment, value);
                max = Math.max(compliment, value);
                String key = min + ":" + max;
                if (!uniquePairs.contains(key)) {
                    System.out.println(compliment + ", " + value);
                    uniquePairs.add(key);
                }
            }
            seen.add(value);
        }

        // Merge two sorted arrays
        int[] v1 = {1, 3, 5};
        int[] v2 = {2, 4, 6};
        // output: [1,2,3,4,5,6]
        output = new int[v1.length + v2.length];
        output = Stream.of(v1, v2).flatMapToInt(arr -> IntStream.of(arr)).sorted().toArray();
        System.out.println("merged two arrays:" + Arrays.stream(output).boxed().collect(Collectors.toList()));




    }
}
