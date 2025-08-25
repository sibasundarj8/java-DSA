package Strings;/*
 *
 * https://www.geeksforgeeks.org/problems/given-two-strings-find-if-first-string-is-a-subsequence-of-second/1
 *
 * # Check if a String is Subsequence of Other
 *
 *   Q. Given two strings s1 and s2. You have to check that s1 is a subsequence of s2 or not.
 *
 *      Note: A subsequence is a sequence that can be derived from another sequence by deleting some elements
 *            without changing the order of the remaining elements.
 *   Ex.
 *      Input : s1 = "gksrek", s2 = "geeksforgeeks"
 *      Output: true
 *      Explanation: If we combine the bold character of "geeksforgeeks", it equals to s1. So s1 is a subsequence
 *                   of s2.
 *   Constraints:
 *        1 ≤ s1.size(), s2.size() ≤ 106
 */

import java.util.Scanner;

public class S13_Check_if_a_String_is_Subsequence_of_Other {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("String-1 : ");
        String s1 = sc.next();
        
        System.out.println("String-2 : ");
        String s2 = sc.next();

        System.out.println("is sub-sequence: " + isSubSeq(s1, s2));
    }

    /// Solution
    /// Solution
    static boolean isSubSeq(String s1, String s2) {
        // potd.code.hub
        int n = s1.length();
        int m = s2.length();
        // s1 always be smaller
        if (n > m) isSubSeq(s2, s1);

        int i = 0, j = 0;
        while (i < n && j < m) if (s1.charAt(i) == s2.charAt(j++)) i++;

        return i == n;
    }
}
