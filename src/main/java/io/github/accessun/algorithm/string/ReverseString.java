package io.github.accessun.algorithm.string;

/**
 * This class contains a method that is used to reverse the order of a String.
 *
 * @author Xin Sun
 */
public class ReverseString {
    /**
     * The <tt>reverseString(String str)</tt> method is used to reverse the
     * order of a String. If the string <tt>str</tt> is <tt>null</tt>, then the
     * returned value is also a <tt>null</tt> reference. The method applies a
     * in-place algorithm that has a <tt>O(n)</tt> time complexity, where
     * <tt>n</tt> is the length of the string to be processed.
     */
    public static String reverseString(String str) { if (str == null) return
        null;

        char[] ch = str.toCharArray();
        int i = 0;
        int j = ch.length - 1;
        while (i < j) {
            exch(ch, i++, j--);
        }
        return new String(ch);
    }

    private static void exch(char[] ch, int i, int j) {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }

    public static void main(String[] args) {
        String str = "HelloWorld";
        System.out.println(str);
        System.out.println(reverseString(str));
    }
}
