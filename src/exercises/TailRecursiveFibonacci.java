package exercises;

/**
 * This class contains a method that use tail recursion to calculate the
 * Fibonacci number of a given integer.
 *
 * @author Xin Sun
 */
public class TailRecursiveFibonacci {
    public static int tailRecFib(int n) {
        return tailRecFib(0, 1, n);
    }

    private static int tailRecFib(int a, int b, int n) {
        return n == 0 ? b : tailRecFib(b, a+b, n-1);
    }

    // unit test
    public static void main(String[] args) {
        System.out.println("Testing TailRecursiveFibonacci...");
        int N = 10;
        for (int i = 0; i < N; i++)
            System.out.format("%4d", i);
        System.out.println();

        for (int i = 0; i < N; i++)
            System.out.format("%4d", tailRecFib(i));
        System.out.println();
    }
}
