package io.github.accessun.util;

import java.util.Arrays;
import java.util.Random;

/**
 * This class provides some of the static utility methods needed by other
 * packages. <tt>DSAUtils</tt> stands for "Data Structure and Algorithm
 * Utilities"
 * 
 * @author Xin Sun
 */
public class DSAUtils {

    private DSAUtils() {
    }

    /**
     * Print out an array of integers onto stdout. This method prints the array
     * in one line. And each integer in the array is separated by a comma.
     * 
     * @param arr
     */
    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Print out an array of integers within a specified range onto stdout. This
     * method prints the array in one line. And each integer in the array is
     * separated by a comma.
     * 
     * @param arr
     * @param from
     *            the index where the printing started (inclusive)
     * @param to
     *            the index where the printing ended (exclusive)
     */
    public static void printArray(int[] arr, int from, int to) {
        int[] tmp = Arrays.copyOfRange(arr, from, to);
        System.out.println(Arrays.toString(tmp));
    }

    /**
     * Exchange the integers at two different position in an array
     * 
     * @param arr
     *            the array to be operated upon
     * @param i
     *            the index of first integer to be exchanged
     * @param j
     *            the index of second integer to be exchanged
     */
    public static void exch(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Randomly permute an array of integers
     * 
     * @param arr
     */
    public static void shuffle(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int randInt = new Random().nextInt(arr.length - i) + i;
            exch(arr, i, randInt);
        }
    }
}
