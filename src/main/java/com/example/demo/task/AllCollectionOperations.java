package com.example.demo.task;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AllCollectionOperations {

    public static void main(String[] args) {
        int[] intv1 = {1, 2, 3, 4, 5, 6};
        int[] intv2 = {6, 7, 7, 8, 9, 10};
        int[] intv3 = {10, 11, 12, 13, 13, 14};

        // merge two arrays
        int[] intm2 = Stream.concat(Arrays.stream(intv1).boxed(), Arrays.stream(intv2).boxed()).mapToInt(Integer::intValue).toArray();
        long[] longm2 = Stream.concat(Arrays.stream(intv1).boxed(), Arrays.stream(intv2).boxed()).mapToLong(i -> i.intValue()).toArray();
        double[] doublem2 = Stream.concat(Arrays.stream(intv1).boxed(), Arrays.stream(intv2).boxed()).mapToDouble(i -> i.doubleValue()).toArray();

        intm2 = Stream.of(intv1, intv2).flatMapToInt(arr -> IntStream.of(arr)).toArray();
        longm2 = Stream.of(intv1, intv2).flatMapToInt(arr -> IntStream.of(arr)).mapToLong(i -> i).toArray();
        doublem2 = Stream.of(intv1, intv2).flatMapToInt(arr -> IntStream.of(arr)).mapToDouble(i -> i).toArray();

        // merge three/more arrays
        int[] intm3 = Stream.of(intv1, intv2, intv3).flatMapToInt(arr -> IntStream.of(arr)).toArray();
        long[] longm3 = Stream.of(intv1, intv2, intv3).flatMapToInt(arr -> IntStream.of(arr)).mapToLong(i -> i).toArray();
        double[] doublem3 = Stream.of(intv1, intv2, intv3).flatMapToInt(arr -> IntStream.of(arr)).mapToDouble(i -> i).toArray();

        // merge to list
        List<Integer> intList = new ArrayList<>();
        intList = Stream.of(intv1, intv2, intv3).flatMap(arr -> Arrays.stream(arr).boxed()).collect(Collectors.toList());
        intList = Stream.concat(Arrays.stream(intv1).boxed(), Arrays.stream(intv2).boxed()).collect(Collectors.toList());

        // find common values
        Set<Integer> set1 = Arrays.stream(intv1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(intv2).boxed().collect(Collectors.toSet());
        Set<Integer> common = new HashSet<>();
        for (Integer v : set2) {
            if (!set1.add(v)) {
                common.add(v);
            }
        }
        display("common", common);
        int[] intCommon = common.stream().mapToInt(Integer::intValue).toArray();
        display("intCommon", intCommon);

        // find uncommon values
        set1 = Arrays.stream(intv1).boxed().collect(Collectors.toSet());
        set2 = Arrays.stream(intv2).boxed().collect(Collectors.toSet());
        Set<Integer> uncommon1 = new HashSet<>(set1);
        uncommon1.removeAll(set2);
        Set<Integer> uncommon2 = new HashSet<>(set2);
        uncommon2.removeAll(set1);

        Set<Integer> uncommon = Stream.concat(uncommon1.stream(), uncommon2.stream()).collect(Collectors.toSet());
        display("uncommon", uncommon);
        int[] intUnCommon = uncommon.stream().mapToInt(v -> v.intValue()).toArray();
        display("intUnCommon", intUnCommon);

        // merge three arrays, sort, without duplicates
        int[] mergeArr = Stream.of(intv3, intv2, intv1).flatMapToInt(arr -> IntStream.of(arr)).distinct().sorted().toArray();
        List<Integer> mergeList = Stream.of(intv3, intv2, intv1).flatMap(arr -> IntStream.of(arr).boxed()).distinct().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        display("mergeArr", mergeArr);
        display("mergeList", mergeList);

        // find total duplicates across arrays
        intv1 = new int[]{1, 2, 3, 4, 5, 6};
        intv2 = new int[]{6, 7, 7, 8, 9, 10};
        intv3 = new int[]{10, 11, 12, 13, 13, 14};
        List<Integer> duplicates = Stream.of(intv1, intv2, intv3).flatMap(arr -> Arrays.stream(arr).boxed())
                .collect(Collectors.toList())
                .stream().collect(Collectors.groupingBy(i -> i, Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() > 1).map(e -> e.getKey()).collect(Collectors.toList());
        display("duplicates", duplicates);

        // find missing element
        int[] v = {1, 7, 2, 4, 5, 6};
        int max = Arrays.stream(v).max().getAsInt();
        int expectedSum = max * (max + 1) / 2;
        int actualSum = Arrays.stream(v).reduce(0, Integer::sum);
        int missing = expectedSum - actualSum;
        System.out.println("missing:" + missing);

        // or with random values, may or may starts with 1
        v = new int[]{7, 2, 4, 5, 6, 9, 10};
        int min = Arrays.stream(v).min().getAsInt();
        //not good approach: min = Stream.of(v).flatMap(arr->IntStream.of(arr).boxed()).max(Comparator.reverseOrder()).orElse(0);
        max = Arrays.stream(v).max().getAsInt();
        expectedSum = (max * (max + 1) / 2) - ((min - 1) * min / 2);
        actualSum = Arrays.stream(v).reduce(0, Integer::sum);
        missing = expectedSum - actualSum;
        System.out.println("missing:" + missing);

        Arrays.sort(v);
        int prev = -1;
        for (int i = 0; i < v.length; i++) {

            int current = v[i];

            if (i == 0) {
                prev = current;
                continue;
            }

            int diff = current - prev;
            if (diff > 1) {
                for (int j = 1; j < diff; j++) {
                    System.out.println("for loop | missing:" + (prev + j));
                }
            }
            prev = current;
        }

        //    Find the First Missing Positive Integer
        //    Problem:
        //    Given an unsorted array, find the smallest missing positive integer.
        //    Input: [3, 4, -1, 1]
        //    Output: 2
        List<Integer> list = Arrays.asList(3, 4, -1, 1);
        min = list.stream().mapToInt(i -> i.intValue()).min().orElse(0);
        max = list.stream().mapToInt(i -> i.intValue()).max().orElse(0);
        Integer expected = (max * (max + 1)) / 2 - ((min - 1) * min / 2);
        Integer actual = list.stream().reduce(0, (a, b) -> a + b);
        missing = expected - actual;
        System.out.println("missing: " + missing);

        //    Find Pairs in an Array That Sum to a Target Value
        //    Problem:
        //    Given an array of integers and a target sum, return all unique pairs that add up to the target.
        //    Input: [1, 5, 7, -1, 5], Target = 6
        //    Output: [(1, 5), (7, -1)]
        v = new int[]{1, 5, 7, -1, 5};
        Integer target = 6;
        List<List<Integer>> pairs = new ArrayList<>();
        for (int i = 0; i < v.length; i++) {
            int v1 = v[i];
            for (int j = i + 1; j < v.length; j++) {
                int v2 = v[j];
                int sum = v1 + v2;
                if (sum == target) {
                    pairs.add(List.of(v[i], v[j]));
                }
            }
        }
        System.out.println("pairs" + pairs);
    }

    public static void display(String msg, int[] v) {
        System.out.println(msg + ": " + Arrays.stream(v).boxed().collect(Collectors.toList()));
    }

    public static void display(String msg, Set<Integer> list) {
        System.out.println(msg + ": " + list);
    }

    public static void display(String msg, List<Integer> list) {
        System.out.println(msg + ": " + list);
    }
}
