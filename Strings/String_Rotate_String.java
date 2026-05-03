package Strings;/*
 *
 * https://leetcode.com/problems/rotate-string/
 *
 * # 796. Rotate String
 *
 *   Q. Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.
 *      A shift on s consists of moving the leftmost character of s to the rightmost position.
 *      For example, if s = "abcde", then it will be "bcdea" after one shift.
 *
 *    Ex.
 *      Input : s = "abcde", goal = "cdeab"
 *      Output: true
 *
 *  Constraints:
 *          1 <= s.length, goal.length <= 100
 *          s and goal consist of lowercase English letters.
 */

import java.util.Scanner;

public class String_Rotate_String {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the String: ");
        String s = sc.next();

        System.out.println("Enter the goal: ");
        String goal = sc.next();

        System.out.println("Is rotated version: ");
        System.out.println(rotateString(s, goal));
    }

    /// solution
    static boolean rotateString(String s, String goal) {
        // potd.code.hub
        s += s;
        return kmp(s, goal);
    }

    // KMP algorithm
    private static boolean kmp(String txt, String pat) {
        int n = txt.length();
        int m = pat.length();
        int[] lps = lps(pat);

        int t = 0;  // pointer to iterate text
        int p = 0;  // pointer to iterate pattern

        while (t < n) {
            if (txt.charAt(t) == pat.charAt(p)) {
                t++;
                p++;
            } else if (p > 0) p = lps[p - 1];
            else t++;

            if (p == m) return true;
        }

        return false;
    }

    // longest prefix suffix
    private static int[] lps(String str) {
        int n = str.length();
        int[] lps = new int[n];

        int p = 0;  // prefix
        int s = 1;  // suffix

        while (s < n) {
            if (str.charAt(p) == str.charAt(s)) lps[s++] = ++p;
            else if (p > 0) p = lps[p - 1];
            else s++;
        }

        return lps;
    }
}
