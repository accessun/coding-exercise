package io.github.accessun.algorithm;

/**
 * Problem: 3
 * Page: 38
 * Date:
 *
 * Search for a integer in a given 2D matrix. The entries in both the rows and
 * columns of the matrix are arranged in ascending order.
 *
 * @author Xin Sun
 */
public class SearchInAscendingMatrix {

    public static boolean searchNumberInMatrix (int[][] a, int num) {
        int maxRow = a.length - 1;
        int maxColumn = a[0].length - 1;

        int column = maxColumn;
        int row = 0;

        while (column >= 0 && row <= maxRow) {
            if (a[row][column] > num)
                column--;
            else if (a[row][column] < num)
                row++;
            else // (a[row][column] == num)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] a = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 }, { 6, 8, 11, 15 } };
        System.out.println(searchNumberInMatrix(a, 7));
        System.out.println(searchNumberInMatrix(a, 5));
    }
}
