package DP;/*
 *
 * https://www.geeksforgeeks.org/problems/count-binary-strings1944/1
 *
 * # k Times Appearing Adjacent Two 1's
 *
 *   Q. Given two integers n and k, count the number of binary strings of length n where adjacent 1 appear k times.
 *      Since the answer can be huge, return it modulo 10⁹+7.
 *
 *    Ex.
 *      Input : n = 5, k = 2
 *      Output: 6
 *      Explanation: Possible strings are "00111", "10111", "01110", "11100", "11101" and "11011".
 *
 *  Constraints:
 *      1 ≤ n, k ≤ 10³
 */

import java.util.Scanner;

public class Dynamic_Programming_k_Times_Appearing_Adjacent_Two_1s {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("n: ");
        int n = sc.nextInt();

        System.out.print("k: ");
        int k = sc.nextInt();

        System.out.println("Number of n length binary strings where adjacent 1 appear k times: ");
        System.out.println(countStrings(n, k));
    }

    /// Solution
    private static final int MOD = (int) (1e9 + 7);

    static int countStrings(int n, int k) {
        // potd.code.hub
        if (k >= n) return 0;
        int[][][] dp = new int[n][k + 1][2];

        for (int[][] a : dp) {
            for (int[] b : a) {
                b[0] = b[1] = -1;
            }
        }

        return solve(0, k, 0, n, dp);
    }

    private static int solve(int idx, int k, int prev, int n, int[][][] dp) {
        // base case
        if (k == 0 && idx == n) return 1;
        if (k < 0 || idx == n) return 0;
        if (dp[idx][k][prev] != -1) return dp[idx][k][prev];

        // recursive case
        int putOne = solve(idx + 1, (prev == 1) ? k - 1 : k, 1, n, dp);
        int putZero = solve(idx + 1, k, 0, n, dp);

        // self work
        return dp[idx][k][prev] = (putOne + putZero) % MOD;
    }
}
