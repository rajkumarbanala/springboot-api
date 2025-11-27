package com.example.demo.task;

public class SearchTaskTest {

    public static void main(String[] args) {
        int[] v = {1, 5, 3, 4, 2};

        // linear search
        int search = 2;
        boolean flag = false;

        // TODO
        if (flag) {
            System.out.println("linear search found: " + search);
        } else {
            System.out.println("linear search not found: " + search);
        }

        // binary search
        v = new int[]{1, 5, 3, 4, 2};
        search = 2;
        flag = false;

        // TODO
        if (flag) {
            System.out.println("binary search found: " + search);
        } else {
            System.out.println("binary search not found: " + search);
        }
    }
}
