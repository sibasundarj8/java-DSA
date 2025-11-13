package DP;/*
 *
 * https://www.geeksforgeeks.org/problems/interleaved-strings/1
 *
 * # Interleaved Strings
 *
 *   Q. Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2. Interleaving of two
 *      strings s1 and s2 is a way to mix their characters to form a new string s3, while maintaining the relative
 *      order of characters from s1 and s2. Conditions for interleaving:
 *
 *          ➢ Characters from s1 must appear in the same order in s3 as they are in s1.
 *          ➢ Characters from s2 must appear in the same order in s3 as they are in s2.
 *          ➢ The length of s3 must be equal to the combined length of s1 and s2.
 *
 *    Ex.
 *      Input : s1 = "AAB", s2 = "AAC", s3 = "AAAABC"
 *      Output: true
 *      Explanation: The string "AAAABC" has all characters of the other two strings and in the same order.
 *
 *  Constraints:
 *        1 ≤ s1.length, s2.length ≤ 300
 *        1 ≤ s3.length ≤ 600
 */

import java.util.Scanner;

public class Dynamic_Programming_Interleaved_Strings {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("String-1 : ");
        String s1 = sc.next();

        System.out.print("String-2 : ");
        String s2 = sc.next();

        System.out.print("String-3 : ");
        String s3 = sc.next();

        System.out.println("is string-3 formed by an interleaving of string-1 and string-2");
        System.out.println(isInterleave(s1, s2, s3));
    }

    /// Solution
    public static boolean isInterleave(String s1, String s2, String s3) {
        // potd.code.hub
        int n1 = s1.length() - 1;
        int n2 = s2.length() - 1;
        int n3 = s3.length() - 1;
        /*
           Here we just need only 2D DP not 3D because i + j == k (always)
           so only i and j are unique or k never be unique for i and j.
        */
        Boolean[][] dp = new Boolean[n1 + 2][n2 + 2];

        return f(n1, n2, n3, s1, s2, s3, dp);
    }

    private static boolean f(int i, int j, int k, String s1, String s2, String s3, Boolean[][] dp) {
        // base case
        if (i < 0 && j < 0) return true;
        if (dp[i + 1][j + 1] != null) return dp[i + 1][j + 1];

        // recursive work
        boolean ans = false;

        if (i >= 0 && s1.charAt(i) == s3.charAt(k)) ans = f(i - 1, j, k - 1, s1, s2, s3, dp);
        if (j >= 0 && !ans && s2.charAt(j) == s3.charAt(k)) ans = f(i, j - 1, k - 1, s1, s2, s3, dp);

        // self work
        return dp[i + 1][j + 1] = ans;
    }
}
