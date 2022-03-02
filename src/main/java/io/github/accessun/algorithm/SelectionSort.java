package io.github.accessun.algorithm;

import io.github.accessun.util.DSAUtils;

public class SelectionSort implements SortOperation {

    public void sort(int[] a) {
        if (a == null || a.length == 1)
            return;

        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[i]) {
                    DSAUtils.exch(a, i, j);
                }
            }
        }        
    }
    
}