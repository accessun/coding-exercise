package io.accessun.algorithm.string;

/**
 * Problem: 4
 * Page: 44
 * Date: 2015-09-05
 *
 * Convert every occurrence of space in a given String to "%20".
 *
 * @author Xin Sun
 */
public class ConvertSpaces {

    public static String convertSpaces(String s) {
        char[] ch = s.toCharArray();
        int originalLength = s.length();
        int numberOfSpace = 0;

        for (int i = 0; i < originalLength; i++)
            if (ch[i] == ' ')
                numberOfSpace++;

        int newLength = numberOfSpace * 2 + originalLength;
        char[] chNew = new char[newLength];
        for (int i = originalLength - 1, j = newLength - 1; i >=0; i--) {
            if (ch[i] == ' ') {
                chNew[j--] = '0';
                chNew[j--] = '2';
                chNew[j--] = '%';
            } else {
                chNew[j--] = ch[i];
            }
        }
        return new String(chNew);
    }

    public static void main(String[] args) {
        String s = "hello world this is a Java program!";
        System.out.println(s);
        System.out.println(convertSpaces(s));
    }
}
