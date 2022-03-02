package io.github.accessun.algorithm.sort;

import java.util.Random;

public class InsertionSort {

    public static void sort(int[] a) {
        if (a == null || a.length == 1)
            return;

        for (int i = 1; i < a.length; ++i) {
            for (int j = i; j > 0 && a[j - 1] > a[j]; j--) {
                exch(a, j - 1, j);
            }
        }
    }

    private static void exch(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void printArray(int[] a) {
        for (int val : a) {
            System.out.format("%d  ", val);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] original = new int[10];
        for (int i = 0; i < original.length; i++) {
            original[i] = new Random().nextInt(50);
        }
        printArray(original);
        sort(original);
        printArray(original);
    }
}