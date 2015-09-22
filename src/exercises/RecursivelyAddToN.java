package exercises;

/**
 * Add 1 to a given integer N (N >= 1) recursively.
 * Example:
 * $ java RecursivelyAddToN 100
 * 5050
 *
 * @author Xin Sun
 */
public class RecursivelyAddToN {

    public static int addToN(int n) {
        if (n == 0) return 0;
        return n + addToN(n-1);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        assert n >= 1;
        System.out.println(addToN(n));
    }
}

