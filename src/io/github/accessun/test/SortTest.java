package io.github.accessun.test;

import java.util.Objects;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

import io.github.accessun.algorithm.MergeSort;
import io.github.accessun.algorithm.SortOperation;

public class SortTest {

    public void testSort(SortOperation so) {
        Random random = new Random();

        // run 100 random tests
        for (int i = 0; i < 100; i++) {
            int len = random.nextInt(50) + 1; // random length: [1, 50]
            int[] arr = new int[len];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = random.nextInt(100); // [0, 100) for each integer
            }
            so.sort(arr);
            Assert.assertTrue(isSorted(arr));
        }

    }

    // sorted in ascending order
    private boolean isSorted(int[] arr) {
        Objects.requireNonNull(arr);
        boolean result = true;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] < arr[i]) {
                result = false;
                break;
            }
        }

        return result;
    }

    @Test
    public void testMergeSort() {
        testSort(new MergeSort());
    }

}
