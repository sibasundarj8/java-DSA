package Recursion;/*
 *
 * https://www.geeksforgeeks.org/problems/sum-string3151/1
 *
 * # Sum-string
 *
 *   Q. Given a string s consisting of digits, determine whether it can be classified as a sum-string.
 *
 *      A sum-string is a string that can be split into two or more non-empty substrings such that:
 *      ◆ The rightmost substring is equal to the sum of the two substrings immediately before it (interpreted
 *        as integers).
 *      ◆ This condition must apply recursively to the substrings before it.
 *      ◆ The rightmost substring (and any number in the sum) must not contain leading zeroes, unless the number
 *        is exactly '0'.
 *    Ex.
 *      Input : s = "1111112223"
 *      Output: true
 *      Explanation: Split the string as {"1", "111", "112", "223"}, where:
 *                   112 = 1 + 111 and 223 = 111 + 112. Hence, it follows the sum-string rule.
 */

import java.util.Scanner;

public class Recursion_50_Sum_string {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number: ");
        String s = sc.next();

        System.out.println("Sum String : " + isSumString(s));
    }

    /// Solution
    static boolean isSumString(String s) {
        // potd.code.hub
        int n = s.length();
        String s1 = "";

        // Trying all possible combination of s1 and s2
        for (int i = 0;i < n-2;i++){
            s1 += s.charAt(i);
            String s2 = "";

            for (int j = i+1;i + j + 1 < n; j++){
                s2 += s.charAt(j);

                // recursive call to find s3
                if (f(s, s1, s2, n, i+1, j-i, j+1)) {
                    return true;
                }
            }
        }

        return false;
    }

    // recursive call to find s3 according to s1 and s2 (s3 = s1 + s2)
    private static boolean f(String str, String s1, String s2, int n, int l1, int l2, int idx) {
        if (idx == n) return true;

        String s3 = sum(s1, s2, l1, l2);
        int l3 = s3.length();

        System.out.println("Hello");

        if (l1 + l2 + l3 <= n && check(str, s3, idx, n, l3)) {
            return f(str, s2, s3, n, l2, l3, idx + l3);
        }

        return false;
    }

    // matching two strings
    private static boolean check(String txt, String pat, int idx, int n, int m) {
        for (int i = 0;i < m;i++) {
            if (i+idx < n && pat.charAt(i) != txt.charAt(i + idx)){
                return false;
            }
        }
        return true;
    }

    // adding two numbers in form of string
    private static String sum(String s1, String s2, int l1, int l2) {
        if (l1 > l2) return sum(s2, s1, l2, l1);

        StringBuilder sum = new StringBuilder();
        int k = l2-l1;
        int i = l2-1;
        int carry = 0;

        while (i >= 0) {
            int d1 = (i < k) ? 0 : s1.charAt(i-k) - '0';
            int d2 = s2.charAt(i) - '0';
            int val = d1 + d2 + carry;
            sum.append(val % 10);
            carry = val / 10;
            i--;
        }
        if (carry > 0) sum.append(carry);

        return sum.reverse().toString();
    }
}
