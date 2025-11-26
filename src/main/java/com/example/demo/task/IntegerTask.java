package com.example.demo.task;

import java.util.Arrays;
import java.util.stream.Collectors;

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
        int j = 0;
        for (int i = 0; i < v.length; i++) {
            if (v[i] != 0) {
                v[j] = v[i];
                j++;
            }
        }
        while (j < v.length) {
            v[j] = 0;
            j++;
        }
        System.out.println("zeros at last:" + Arrays.stream(v).boxed().collect(Collectors.toList()));



    }
}
