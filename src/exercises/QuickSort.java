package exercises;

import java.util.Random;

public class QuickSort {

        /*
         * 1. random shuffle;
         * 2. partition;
         * 3. sort left;
         * 4. sort right;
         * 5. assert sorted.
         */

    public static void sort(int[] a) {
        if (a == null || a.length == 1)
            return;
        shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int lo, int hi) {
        if (lo >= hi)
            return;
        int mid = partition(a, lo, hi);
        sort(a, lo, mid - 1);
        sort(a, mid + 1, hi);
    }

    private static int partition(int[] a, int lo, int hi) {
        int i = lo, j = hi + 1, val = a[lo];
        while (true) {
            while (a[++i] <= val)
                if (i == hi)
                    break;
            while (a[--j] > val)
                if (j == lo)
                    break;
            if (i >= j)
                break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private static void shuffle(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int randInt = new Random().nextInt(a.length - i) + i;
            exch(a, i, randInt);
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
        // shuffle(original);
        sort(original);
        printArray(original);
    }
}