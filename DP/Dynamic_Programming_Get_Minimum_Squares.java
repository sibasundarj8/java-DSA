package DP;/*
 *
 * https://www.geeksforgeeks.org/problems/get-minimum-squares0538/1
 *
 * # Get Minimum Squares
 *
 *   Q. Given a positive integer n, find the minimum number of perfect squares (square of an integer) that sum up to n.
 *
 *      Note: Every positive integer can be expressed as a sum of square numbers since 1 is a perfect square, and any
 *            number can be represented as 1*1 + 1*1 + 1*1 + ....
 *    Ex.
 *      Input : n = 100
 *      Output: 1
 *      Explanation: 10 * 10 = 100
 *
 *   Constraints:
 *       1 ≤ n ≤ 10⁴
 */

import java.util.Arrays;
import java.util.Scanner;

public class Dynamic_Programming_Get_Minimum_Squares {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Number: ");
        int n = sc.nextInt();

        System.out.println("Minimum number of perfect squares sum up to n:  ");
        System.out.println(minSquares(n));
    }

    /// Solution
    static int minSquares(int n) {
        int sqrt = (int) Math.sqrt(n);
        int[][] dp = new int[sqrt + 1][n + 1];

        for (int[] a : dp) Arrays.fill(a, -1);

        return f(sqrt, n, dp);
    }

    // helper method
    private static int f(int i, int n, int[][] dp) {
        // base case
        if (n == 0) return 0;
        if (i == 0) return Integer.MAX_VALUE;
        if (dp[i][n] != -1) return dp[i][n];

        int pick = (i * i <= n) ? f(i, n - i * i, dp) + 1 : Integer.MAX_VALUE;
        int notPick = f(i - 1, n, dp);

        return dp[i][n] = Math.min(pick, notPick);
    }
}
