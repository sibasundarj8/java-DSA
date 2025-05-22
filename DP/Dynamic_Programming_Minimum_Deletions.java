package DP;/*
 *
 * https://www.geeksforgeeks.org/problems/minimum-deletitions1648/1
 *
 * # Minimum Deletions
 *
 *   Q. Given a string s, write a program to delete the minimum number of characters from the string so that the
 *      resultant string is a palindrome, while maintaining the order of characters.
 *    Ex.
 *      Input : s = "aebcbda"
 *      Output: 2
 *      Explanation: Remove characters 'e' and 'd'.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Dynamic_Programming_Minimum_Deletions {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the word: ");
        String s = sc.next();

        System.out.println("Minimum Deletion to make Palindrome: " + minDeletions(s));
    }

    /// Solution
    static int minDeletions(String s) {
        // potd.code.hub
        int n = s.length();
        String rev = reverse(s);
        int[][] dp = new int[n + 1][n + 1];

        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        int lcs = LCS(s, rev, n);

        return n - lcs;
    }

    // Reverse String
    private static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    // LCS (Longest common sub-sequence)

/**************************************************<---Memoization--->**************************************************/
// TC: O(n²)
// SC: O(n² + n²)
    private static int LCS(String s1, String s2, int idx1, int idx2, int[][] dp) {
        // base case
        if (idx1 == 0 || idx2 == 0) return 0;
        if (dp[idx1][idx2] != -1) return dp[idx1][idx2];

        // self work & recursive work
        if (s1.charAt(idx1 - 1) == s2.charAt(idx2 - 1)) {
            return dp[idx1][idx2] = 1 + LCS(s1, s2, idx1 - 1, idx2 - 1, dp);
        } else {
            int pickS1 = LCS(s1, s2, idx1 - 1, idx2, dp);
            int pickS2 = LCS(s1, s2, idx1, idx2 - 1, dp);
            return dp[idx1][idx2] = Math.max(pickS1, pickS2);
        }
    }

/***************************************************<---Tabulation--->**************************************************/
// TC: O(n²)
// SC: O(n²)
    private static int LCS(String s1, String s2, int n, int[][] dp) {
        for (int i = 0; i < n; i++) {
            dp[i][0] = dp[0][1] = 0;
        }

        for (int idx1 = 1; idx1 <= n; idx1++) {
            for (int idx2 = 1; idx2 <= n; idx2++) {
                if (s1.charAt(idx1 - 1) == s2.charAt(idx2 - 1)) {
                    dp[idx1][idx2] = 1 + dp[idx1 - 1][idx2 - 1];
                } else {
                    int pickS1 = dp[idx1 - 1][idx2];
                    int pickS2 = dp[idx1][idx2 - 1];
                    dp[idx1][idx2] = Math.max(pickS1, pickS2);
                }
            }
        }

        return dp[n][n];
    }

/*******************************************<---Space-Optimized-Tabulation--->******************************************/
// TC: O(n²)
// SC: O(n)
    private static int LCS(String s1, String s2, int n) {
        int[] curr = new int[n + 1];
        int[] prev = new int[n + 1];

        for (int idx1 = 1; idx1 <= n; idx1++) {
            for (int idx2 = 1; idx2 <= n; idx2++) {
                if (s1.charAt(idx1 - 1) == s2.charAt(idx2 - 1)) {
                    curr[idx2] = 1 + prev[idx2 - 1];
                } else {
                    int pickS1 = prev[idx2];
                    int pickS2 = curr[idx2 - 1];
                    curr[idx2] = Math.max(pickS1, pickS2);
                }
            }
            prev = curr.clone();
        }

        return prev[n];
    }
}
