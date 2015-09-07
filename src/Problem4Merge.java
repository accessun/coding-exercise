import java.util.Arrays;

public class Problem4Merge {
    public static void main(String[] args) {
        int MAX_VALUE = 100;
        int totalLength = Integer.parseInt(args[0]);
        int secondLength = Integer.parseInt(args[1]);
        assert totalLength > 0;
        assert secondLength > 0;
        assert totalLength > secondLength;
        
        int firstLength = totalLength - secondLength;
        
        int[] a1 = new int[totalLength];
        int[] a2 = new int[secondLength];

        for (int i = 0; i < firstLength; i++) 
            a1[i] = (int) (Math.random() * MAX_VALUE);
        Arrays.sort(a1, 0, firstLength);
        printArray(a1, 0, firstLength);

        for (int i = 0; i < secondLength; i++) 
            a2[i] = (int) (Math.random() * MAX_VALUE);
        Arrays.sort(a2);
        printArray(a2);

        mergeTwoArrays(a1, a2);
        printArray(a1);
    }

    public static void mergeTwoArrays(int[] a, int[] b) {
        int j = b.length - 1;
        int i = a.length - b.length - 1;

        for (int k = a.length - 1; k >= 0; k--) {
            if      (i < 0)       a[k] = b[j--];
            else if (j < 0)       a[k] = a[i--];
            else if (a[i] < b[j]) a[k] = b[j--];
            else                  a[k] = a[i--];
        }
    }

    private static void printArray(int[] a) {
        printArray(a, 0, a.length);
    }

    private static void printArray(int[] a, int lo, int hi) {
        // lo -> inclusive, hi -> exclusive
        for (int i = lo; i < hi; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }
}
