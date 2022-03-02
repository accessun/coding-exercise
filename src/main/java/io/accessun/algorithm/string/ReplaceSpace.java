package io.accessun.algorithm.string;

/**
 * Problem: 4
 * Page: 44
 * Date: 2015-07-14
 *
 * Replace every occurrence of space in a given String to "%20".
 *
 * @author Xin Sun
 */
public class ReplaceSpace {
    private String str;

    public ReplaceSpace(String str) {
        this.str = str;
    }

    public String replaceSpace() {
        StringBuilder s = new StringBuilder(str);
        StringBuilder replacedString = new StringBuilder("");

        for (int i = 0; i < str.length(); i++) {
            if (s.charAt(i) == ' ')
                replacedString.append("%20");
            else
                replacedString.append(s.charAt(i));
        }

        return replacedString.toString();
    }

    public static void main(String[] args) {
        String str = "hello world";
        String str1 = " hello world";
        String str2 = "hello world ";
        String str3 = " ";
        String str4 = "hello";

        System.out.println(new ReplaceSpace(str).replaceSpace());
        System.out.println(new ReplaceSpace(str1).replaceSpace());
        System.out.println(new ReplaceSpace(str2).replaceSpace());
        System.out.println(new ReplaceSpace(str3).replaceSpace());
        System.out.println(new ReplaceSpace(str4).replaceSpace());
    }
}
