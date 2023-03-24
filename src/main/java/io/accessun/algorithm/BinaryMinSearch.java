package io.accessun.algorithm;


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
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array should not be null or empty");
        }
        if (arr.length == 1) {
            return 0;
        }

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
            if (arr[lo] <= arr[hi]) {
                hi = mid;
            } else {
                lo = mid;
            }
        }

        return arr[lo] <= arr[hi] ? lo : hi;
    }
}
