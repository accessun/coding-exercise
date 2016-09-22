package io.github.accessun.util;

import java.util.Arrays;

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

    public static <T> void printArray(T[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}
