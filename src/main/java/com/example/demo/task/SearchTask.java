package com.example.demo.task;

import java.util.Arrays;

public class SearchTask {

    public static void main(String[] args) {
        int[] v = {1, 5, 3, 4, 2};

        // linear search
        int search = 2;
        boolean flag = false;
        for (int i : v) {
            if (i == search) {
                flag = true;
            }
        }
        if (flag) {
            System.out.println("linear search found: " + search);
        } else {
            System.out.println("linear search not found: " + search);
        }

        // binary search
        v = new int[]{1, 5, 3, 4, 2};
        search = 2;
        flag = false;

        // 1, 2, 3, 4, 5
        Arrays.sort(v);
        int left = 0;
        int right = v.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (search == v[mid]) {
                flag = true;
                break;
            } else if (search < v[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (flag) {
            System.out.println("binary search found: " + search);
        } else {
            System.out.println("binary search not found: " + search);
        }
    }
}
