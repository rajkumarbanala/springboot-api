package com.example.demo.task;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AllCollectionOperationsTest {

    public static void main(String[] args) {
        int[] intv1 = {1, 2, 3, 4, 5, 6};
        int[] intv2 = {6, 7, 7, 8, 9, 10};
        int[] intv3 = {10, 11, 12, 13, 13, 14};
        display("v1", intv1);
        display("v2", intv2);
        display("v3", intv3);

        // merge two arrays
        int[] intm2 = null;
        long[] longm2 = null;
        double[] doublem2 = null;
        List<Integer> listm2 = null;

        intm2 = Stream.of(intv1, intv2, intv3).flatMapToInt(v -> Arrays.stream(v)).distinct().toArray();
        longm2 = Stream.of(intv1, intv2, intv3).flatMapToInt(v -> Arrays.stream(v)).mapToLong(v -> (long) v).toArray();
        doublem2 = Stream.of(intv1, intv2, intv3).flatMapToInt(v -> Arrays.stream(v)).mapToDouble(v -> (long) v).toArray();

        display("intm2", intm2);
        display("longm2", longm2);
        display("doublem2", doublem2);

        // merge/more three arrays
        int[] intm3 = null;
        long[] longm3 = null;
        double[] doublem3 = null;
        List<Integer> listm3 = null;

        display("intm2", intm2);
        display("longm2", longm2);
        display("doublem2", doublem2);

        // find common values
        int[] common = null;
        List<Integer> commonList = new ArrayList<>();

        Set<Integer> set1 = Stream.of(intv1).flatMap(v -> Arrays.stream(v).boxed()).collect(Collectors.toSet());
        Set<Integer> set2 = Stream.of(intv2).flatMap(v -> Arrays.stream(v).boxed()).collect(Collectors.toSet());
        Set<Integer> set3 = Stream.of(intv3).flatMap(v -> Arrays.stream(v).boxed()).collect(Collectors.toSet());
        for (int s2 : set2) {
            if (!set1.add(s2)) {
                commonList.add(s2);
            }
        }
        common = commonList.stream().mapToInt(Integer::intValue).toArray();
        display("common", common);
        display("commonList", commonList);

        // fetch uncommon values
        int[] intUnCommon = null;
        List<Integer> unCommonList = null;

        set1 = Stream.of(intv1).flatMap(v -> Arrays.stream(v).boxed()).collect(Collectors.toSet());
        set2 = Stream.of(intv2).flatMap(v -> Arrays.stream(v).boxed()).collect(Collectors.toSet());

        Set<Integer> unCommon1 = new HashSet<>(set1);
        unCommon1.removeAll(set2);

        Set<Integer> unCommon2 = new HashSet<>(set2);
        unCommon2.removeAll(set1);

        unCommonList = Stream.concat(unCommon1.stream(), unCommon2.stream()).collect(Collectors.toList());
        display("unCommonList", unCommonList);

        // merge three arrays, sort, without duplicates
        List<Integer> mergeValues = null;
        mergeValues = Stream.of(intv1, intv2, intv3).flatMapToInt(arr -> Arrays.stream(arr))
                .boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        display("mergeValues", mergeValues);

        // find total duplicates across arrays
        intv1 = new int[]{1, 2, 3, 4, 5, 6};
        intv2 = new int[]{6, 7, 7, 8, 9, 10};
        intv3 = new int[]{10, 11, 12, 13, 13, 14};
        List<Integer> duplicates = Stream.of(intv1, intv2, intv3).flatMapToInt(v -> Arrays.stream(v)).boxed()
                .collect(Collectors.groupingBy(v -> v, Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .map(e -> e.getKey())
                .collect(Collectors.toList());
        ;
        display("duplicates", duplicates);

        // find missing element
        int[] elements = {1, 7, 2, 4, 5, 6};
        int max = Arrays.stream(elements).max().getAsInt();
        int expectedSum = max * (max + 1) / 2;
        int actualSum = Arrays.stream(elements).sum();
        int missing = expectedSum - actualSum;
        display("elements", elements);
        System.out.println("missing: " + missing);

        //    Find the First Missing Positive Integer
        //    Problem:
        //    Given an unsorted array, find the smallest missing positive integer.
        //    Input: [3, 4, -1, 1]
        //    Output: 2
        elements = new int[]{4, 4, -1, 1};
        int min = Arrays.stream(elements).min().getAsInt();
        max = Arrays.stream(elements).max().getAsInt();
        expectedSum = (max * (max + 1) / 2) - ((min - 1) * min / 2);
        actualSum = Arrays.stream(elements).sum();
        missing = expectedSum - actualSum;
        System.out.println("missing: " + missing);

        //    Find Pairs in an Array That Sum to a Target Value
        //    Problem:
        //    Given an array of integers and a target sum, return all unique pairs that add up to the target.
        //    Input: [1, 5, 7, -1, 5], Target = 6
        //    Output: [(1, 5), (7, -1)]
        int[] v = new int[]{1, 5, 7, -1, 5};
        Integer target = 6;
        List<List<Integer>> pairs = new ArrayList<>();
        for (int i = 0; i < v.length; i++) {
            for (int j = i + 1; j < v.length; j++) {
                int sum = v[i] + v[j];
                if (sum == target) {
                    pairs.add(List.of(v[i], v[j]));
                }
            }
        }
        System.out.println("pairs:" + pairs);
    }

    public static void display(String msg, double[] v) {
        System.out.println(msg + ":" + Arrays.stream(v).boxed().collect(Collectors.toList()));
    }

    public static void display(String msg, long[] v) {
        System.out.println(msg + ":" + Arrays.stream(v).boxed().collect(Collectors.toList()));
    }

    public static void display(String msg, int[] v) {
        System.out.println(msg + ":" + Arrays.stream(v).boxed().collect(Collectors.toList()));
    }

    public static void display(String msg, Set<Integer> list) {
        System.out.println(msg + ":" + list);
    }

    public static void display(String msg, List<Integer> list) {
        System.out.println(msg + ":" + list);
    }
}
