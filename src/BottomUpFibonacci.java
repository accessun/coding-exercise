/**
 * Problem: 9
 * Page: 73
 * Date: 2015-08-26
 *
 * A bottom-up implementation of a method that calculates Fibonacci value of a
 * given integer. The integer must be no smaller than 0.
 *
 * Example:
 * $ java BottomUpFibonacci 10
 * 55
 *
 * @author Xin Sun
 */
public class BottomUpFibonacci {

	static int fib(int n) {
		assert n >= 0;

		int fibOne = 0;
		int fibTwo = 1;

		if (n == 0)
			return fibOne;
		if (n == 1)
			return fibTwo;

		int result = 0;
		for (int i = 2; i <= n; i++) {
			result = fibOne + fibTwo;
			fibOne = fibTwo;
			fibTwo = result;
		}
		return result;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		System.out.println(fib(n));
	}
}
