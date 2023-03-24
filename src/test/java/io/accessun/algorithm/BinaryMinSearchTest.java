package io.accessun.algorithm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Xin Sun
 * @date 2023-03-24
 */
public class BinaryMinSearchTest {
    
    private BinaryMinSearch binaryMinSearch;
    
    @BeforeEach
    public void init() {
        binaryMinSearch = new BinaryMinSearch();
    }
    
    @Test
    public void testCommonCases() {
        int[] arr = new int[]{9, 8, 6, 7, 12, 15, 20}; // 2
        assertEquals(2, binaryMinSearch.locate(arr));

        arr = new int[]{51, 30, 28, 20, 16, 15, 16}; // 5
        assertEquals(5, binaryMinSearch.locate(arr));

        arr = new int[]{1, 1, 1, 0, 1, 1, 1}; // 3
        assertEquals(3, binaryMinSearch.locate(arr));
    }

    @Test
    public void testCornerCases() {
        int[] arr = new int[]{1, 2, 3, 4}; // 0;
        assertEquals(0, binaryMinSearch.locate(arr));

        arr = new int[]{9, 8, 7, 5, 2}; // 4
        assertEquals(4, binaryMinSearch.locate(arr));

        arr = new int[]{ 5, 5, 5, 5, 5 }; // 0
        assertEquals(0, binaryMinSearch.locate(arr));

        arr = new int[]{5};
        assertEquals(0, binaryMinSearch.locate(arr));
    }
}
