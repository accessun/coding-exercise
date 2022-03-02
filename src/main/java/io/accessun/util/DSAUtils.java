package io.accessun.util;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

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

    /**
     * Generates a random integer no smaller than <code>min</code> and no larger
     * than <code>max</code>.
     * 
     * @param min
     *            lower bound (inclusive)
     * @param max
     *            higher bound (inclusive)
     * @return
     */
    public static int randomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    /**
     * Generates an integer array of length <code>len</code>. The elements are
     * no smaller than <code>min</code> and no larger than <code>max</code>. If
     * <code>len</code> is smaller than 1, an empty int array will be returned.
     * 
     * @param len
     *            length of the generated array
     * @param min
     *            lower bound of the elements (inclusive)
     * @param max
     *            higher bound of the elements (inclusive)
     * @return
     */
    public static int[] randomIntArr(int len, int min, int max) {
        if (len <= 0) {
            return new int[] {};
        }

        int[] result = new int[len];

        for (int i = 0; i < len; i++) {
            result[i] = randomInt(min, max);
        }

        return result;
    }

    /**
     * Generates an integer array of random length. The possible length values
     * are randomly distributed between 1 and <code>maxLength</code>. The
     * elements are no smaller than <code>min</code> and no larger than
     * <code>max</code>. If <code>maxLength</code> is smaller than 1, an array
     * of length 1 will be returned.
     * 
     * @param maxLength
     *            the maximum possible length the generated array can have
     * @param min
     *            lower bound of the elements (inclusive)
     * @param max
     *            higher bound of the elements (inclusive)
     * @return
     */
    public static int[] randomLengthIntArr(int maxLength, int min, int max) {
        if (maxLength <= 1) {
            return randomIntArr(1, min, max);
        }
        return randomIntArr(randomInt(1, maxLength), min, max);
    }

}
