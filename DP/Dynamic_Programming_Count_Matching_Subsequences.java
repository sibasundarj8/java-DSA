package DP;/*
 *
 * https://www.geeksforgeeks.org/problems/find-number-of-times-a-string-occurs-as-a-subsequence3020/1
 *
 * # Count Matching Subsequences
 *
 *   Q. Given two strings, s1 and s2, count the number of subsequences of string s1 equal to string s2.
 *      Return the total count modulo 1e⁹ + 7.
 *
 *    Ex.
 *      Input : s1 = "geeksforgeeks", s2 = "gks"
 *      Output: 4
 *      Explanation: We can pick characters from s1 as a subsequence from indices [0, 3, 4], [0, 3, 12], [0, 11, 12]
 *                   and [8, 11, 12]. So total 4 subsequences of s1 that are equal to s2.
 *
 *  Constraints:
 *      1 ≤ s1.size(), s2.size() ≤ 10³
 */

import java.util.Arrays;
import java.util.Scanner;

public class Dynamic_Programming_Count_Matching_Subsequences {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("String-1 : ");
        String s1 = sc.next();

        System.out.print("String-2 : ");
        String s2 = sc.next();

        System.out.println("Number of subsequences of string s1 equal to string s2: ");
        System.out.println(countWays(s1, s2));
    }

    /// Solution
    private static final int MOD = (int) (1e9 + 7);

    static int countWays(String s1, String s2) {
        // potd.code.hub
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n][m];

        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        return solve(0, 0, n, m, s1, s2, dp);
    }

    private static int solve(int idx1, int idx2, int n, int m, String s1, String s2, int[][] dp) {
        // base case
        if (idx2 == m) return 1;
        if (idx1 == n) return 0;
        if (dp[idx1][idx2] != -1) return dp[idx1][idx2];

        // recursive case
        int pick = (s1.charAt(idx1) == s2.charAt(idx2)) ? solve(idx1 + 1, idx2 + 1, n, m, s1, s2, dp) : 0;
        int notPick = solve(idx1 + 1, idx2, n, m, s1, s2, dp);

        return dp[idx1][idx2] = (pick + notPick) % MOD;
    }
}
