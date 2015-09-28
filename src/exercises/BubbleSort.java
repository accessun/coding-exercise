package exercises;

import java.util.Random;

public class BubbleSort {

    public static void sort(int[] a) {
        if (a == null || a.length == 1)
            return;

        boolean hasExch = true;
        while (hasExch) {
            hasExch = false;
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i + 1] < a[i]) {
                    exch(a, i, i + 1);
                    hasExch = true;
                }
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