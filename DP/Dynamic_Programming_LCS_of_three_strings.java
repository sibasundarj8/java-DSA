package DP;/*
 *
 * https://www.geeksforgeeks.org/problems/lcs-of-three-strings0028/1
 * 
 * # LCS of three strings
 * 
 *   Q. Given three strings s1, s2, and s3 containing uppercase letters, lowercase letters, and digits, find the 
 *      length of longest common sub-sequence in all three given strings.
 *    Ex.
 *      Input : s1 = "geeks" 
 *              s2 = "geeksfor"
 *              s3 = "geeksforgeeks"
 *      Output: 5
 *      Explanation: "geeks"is the longest common subsequence with length 5.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Dynamic_Programming_LCS_of_three_strings {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("word 1 : ");
        String s1 = sc.next();

        System.out.print("word 2 : ");
        String s2 = sc.next();

        System.out.print("word 3 : ");
        String s3 = sc.next();

        System.out.println("LCS : " + lcsOf3(s1, s2, s3));
    }

    /// Solution
    static int lcsOf3(String s1, String s2, String s3) {
        // potd.code.hub
        int m = s1.length();
        int n = s2.length();
        int o = s3.length();

        int[][][] dp = new int[m][n][o];

        for (int[][] i : dp) {
            for (int[] j : i) {
                Arrays.fill(j, -1);
            }
        }

        return f(s1, s2, s3, m - 1, n - 1, o - 1, dp);
    }

    private static int f(String s1, String s2, String s3, int i, int j, int k, int[][][] dp) {
        if (i < 0 || j < 0 || k < 0)
            return 0;
        if (dp[i][j][k] != -1) return dp[i][j][k];

        // recursive work & self work
        if (s1.charAt(i) == s2.charAt(j) && s1.charAt(i) == s3.charAt(k))
            return 1 + f(s1, s2, s3, i - 1, j - 1, k - 1, dp);
        else {
            int a = f(s1, s2, s3, i - 1, j, k, dp);
            int b = f(s1, s2, s3, i, j - 1, k, dp);
            int c = f(s1, s2, s3, i, j, k - 1, dp);
            int d = f(s1, s2, s3, i - 1, j - 1, k, dp);
            int e = f(s1, s2, s3, i - 1, j, k - 1, dp);
            int f = f(s1, s2, s3, i, j - 1, k - 1, dp);
            return dp[i][j][k] = max6(a, b, c, d, e, f);
        }
    }
    
    private static int max6(int a, int b, int c, int d, int e, int f) {
        return Math.max(a, Math.max(b, Math.max(c, Math.max(d, Math.max(e, f)))));
    }
}
