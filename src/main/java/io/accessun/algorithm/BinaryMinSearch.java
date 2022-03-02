package io.accessun.algorithm;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinaryMinSearch {

    /*-
     * Question: If the elements in array decrease first and then increase,
     * locate the minimum value using binary search.
     *
     * Key observations:
     * 1. Any values in between must be no larger than the values at two boundaries.
     * 2. Binary search requires to tackle the problem by shrinking the array by
     *    half every step. So the key question how to define the new boundaries.
     * 3. According to the first observation, the new boundaries should be the two
     *    smaller ones in value among the old boundaries and the middle position.
     * 4. When lo and hi are next to each other, select the position of the smaller.
     */

    public int locate(int[] arr) {
        if (arr == null || arr.length == 0)
            throw new IllegalArgumentException("Array should not be null or empty");
        if (arr.length == 1) return 0;

        int lo = 0, hi = arr.length - 1;
        int mid;

        /*
         * lo and hi can never come across (lo >= hi is true). The termination
         * condition is satisfied when lo and hi are adjacent to each other.
         */
        while (lo != hi - 1) {

            mid = (lo + hi) / 2;

            /*
             * Evict the largest one in value .The remaining two are the new
             * boundaries.
             */
            if (arr[lo] <= arr[hi])
                hi = mid;
            else
                lo = mid;
        }

        return arr[lo] <= arr[hi] ? lo : hi;
    }

    @Test
    public void test() {
        int[] arr1 = { 9, 8, 6, 7, 12, 15, 20 }; // 2
        int[] arr2 = { 1, 2, 3, 4 }; // 0;
        int[] arr3 = { 9, 8, 7, 5, 2 }; // 4
        int[] arr4 = { 51, 30, 28, 20, 16, 15, 16 }; // 5
        int[] arr5 = { 1, 1, 1, 0, 1, 1, 1 }; // 3
        int[] arr6 = { 5, 5, 5, 5, 5 }; // 0

        Assertions.assertEquals(2, locate(arr1));
        Assertions.assertEquals(0, locate(arr2));
        Assertions.assertEquals(4, locate(arr3));
        Assertions.assertEquals(5, locate(arr4));
        Assertions.assertEquals(3, locate(arr5));
        Assertions.assertEquals(0, locate(arr6));
    }
}
