package Deloitte_Mock;/*
 *
 * # Remove_Duplicacy (easy)
 *
 *   Q. Given a string, you can perform the below-mentioned operation till the duplicacy of the string is
 *      not removed. A string is said to contain duplicacy if any two adjacent characters are the same.
 *
 *      A duplicate removal consists of choosing two adjacent and equal letters and removing them.
 *
 *      You can repeatedly make duplicate removals on the given string until you no longer can.
 *
 *      Print the string after removing the duplicacy of the string.
 *   Ex.
 *      input : abcddcbz
 *      output: az
 *
 *  Constraints:
 *      1 <= n <= 10⁵
 */

import java.util.Scanner;

public class Q01_Remove_Duplicacy {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        String ans = removeDuplicate(s);
        System.out.println(ans);
    }

    /// Solution
    static String removeDuplicate(String s) {
        // potd.code.hub
        int n = s.length();
        if (n == 0 || n == 1) return s;

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int len = ans.length();

            if (len > 0) {
                if (ans.charAt(len - 1) == s.charAt(i)) {
                    ans.deleteCharAt(len - 1);
                } else ans.append(s.charAt(i));
            } else ans.append(s.charAt(i));
        }

        return ans.toString();
    }
}
