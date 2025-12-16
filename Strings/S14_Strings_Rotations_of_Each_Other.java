package Strings;/*
 *
 * https://www.geeksforgeeks.org/problems/check-if-strings-are-rotations-of-each-other-or-not-1587115620/1
 *
 * # Strings Rotations of Each Other
 *
 *   Q. You are given two strings s1 and s2, of equal lengths. The task is to check if s2 is a rotated version of the
 *      string s1.
 *
 *      Note: A string is a rotation of another if it can be formed by moving characters from the start to the end (or
 *            vice versa) without rearranging them.
 *    Ex.
 *      Input : s1 = "abcd", s2 = "cdab"
 *      Output: true
 *      Explanation: After 2 right rotations, s1 will become equal to s2.
 *
 *  Constraints:
 *          1 ≤ s1.size(), s2.size() ≤ 10⁵
 *          s1, s2 consists of lowercase English alphabets.
 */

import java.util.Scanner;

public class S14_Strings_Rotations_of_Each_Other {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("S1: ");
        String s1 = sc.next();

        System.out.print("S2: ");
        String s2 = sc.next();

        System.out.print(s1 + " is rotation of " + s2 + " : ");
        System.out.println(areRotations(s1, s2));
    }

    /// Solution
    static boolean areRotations(String s1, String s2) {
        return kmp(s1 + s1, s2);
    }

    // KMP algorithm
    private static boolean kmp(String txt, String pat) {
        int n = txt.length();
        int m = pat.length();
        int[] lps = lps(pat);

        int t = 0;  // pointer to iterate text
        int p = 0;  // pointer to iterate patten

        while(t < n) {
            if(txt.charAt(t) == pat.charAt(p)) {
                t++;
                p++;
            } else if(p > 0) p = lps[p - 1];
            else t++;

            if(p == m) return true;
        }

        return false;
    }

    // longest prefix suffix
    private static int[] lps(String str) {
        int n = str.length();
        int[] lps = new int[n];

        int p = 0;  // prefix
        int s = 1;  // suffix

        while(s < n) {
            if(str.charAt(p) == str.charAt(s)) lps[s++] = ++p;
            else if(p > 0) p = lps[p - 1];
            else s++;
        }

        return lps;
    }
}
