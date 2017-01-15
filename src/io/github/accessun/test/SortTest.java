package io.github.accessun.test;

import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Test;

import io.github.accessun.algorithm.SelectionSort;
import io.github.accessun.algorithm.SortOperation;

public class SortTest {
    
    public void testSort(Class<? extends SortOperation> so) {
        int[] arr = new int[] { 1, 5, 2, 6, 9, 8 };
        try {
            Method sortMethod = so.getDeclaredMethod("sort", int[].class);
            SortOperation soInstance = so.newInstance();
            int[] original = arr.clone();
            sortMethod.invoke(soInstance, arr);
            Assert.assertArrayEquals(original, arr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testSelectionSort() {
        testSort(SelectionSort.class);
    }
    
}
