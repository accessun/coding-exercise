package io.github.accessun.algorithm.sort;

public class MergeSort implements IntSort {

        /*
         * 1. allocate space for an auxiliary array
         * 2. sort left (original);
         * 3. sort right (original);
         * 4. merge the sorted halves back to the original array (merge
         *    operation involves copying the sorted subarray to the
         *    auxiliary array and merging back to the original array);
         * 5. assert sorted.
         */

    @Override
    public void sort(int[] a) {
        if (a == null || a.length == 1)
            return;
        int[] aux = new int[a.length];
        sort(a, aux, 0, a.length - 1);
    }

    private void sort(int[] a, int[] aux, int lo, int hi) {
        if (lo >= hi) return;
        int mid = (hi + lo) / 2;

        /*
         * The sort method is just used to recursively get down deep into basic
         * levels. (By "basic level", I mean subarrays of length 1.) Then merge
         * the sorted subarrays back to sorted subarrays of longer length. And
         * finally back to the whole array. Here, in fact, the task of the sort
         * method is just to "dive down", the core operation which makes the
         * entries in order is the merge method.
         */
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    private void merge(int[] a, int[] aux, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;

        /*
         * Note that copying to the auxiliary array must be carried out here in
         * the merge method. This action guarantees that every subarray copied
         * into the auxiliary array is sorted and is ready to merge back to
         * the original array. Copying every entry of the original array to
         * the auxiliary array before sorting will cause problem since it is
         * not guaranteed that each subarray is sorted. (The merge operation
         * relies on the assumption that each subarray to be merged must be
         * in order.)
         */
        for (int l = lo; l <= hi; l++)
            aux[l] = a[l];

        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (aux[i] < aux[j]) a[k] = aux[i++];
            else a[k] = aux[j++];
        }
    }

}