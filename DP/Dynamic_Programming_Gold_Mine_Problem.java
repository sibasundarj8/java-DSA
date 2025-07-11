package DP;/*
 *
 * https://www.geeksforgeeks.org/problems/gold-mine-problem2608/1
 *
 * # Gold Mine Problem
 *
 *   Q. Given a gold mine called mat[][]. Each field in this mine contains a positive integer which is the amount
 *      of gold in tons. Initially, the miner can start from any row in the first column. From a given cell, the
 *      miner can move -
 *         -> to the cell diagonally up towards the right
 *         -> to the right
 *         -> to the cell diagonally down towards the right
 *         -> Find out the maximum amount of gold that he can collect until he can no longer move.
 *
 *    Ex.
 *      Input : mat[][] = [[1, 3, 3],
 *                         [2, 1, 4],
 *                         [0, 6, 4]]
 *      Output: 12
 *      Explanation: The path is (1, 0) -> (2, 1) -> (2, 2). Total gold collected is 2 + 6 + 4 = 12.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Dynamic_Programming_Gold_Mine_Problem {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("row size: ");
        int n = sc.nextInt();

        System.out.println("col size: ");
        int m = sc.nextInt();

        int[][] arr = new int[n][m];

        System.out.println("Enter Elements: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println("Maximum Gold: " + maxGold(arr));
    }

    /// Solution
    static int maxGold(int[][] mat) {
        // potd.code.hub
        int n = mat.length;
        int m = mat[0].length;
        int ans = 0;
        int[][] dp = new int[n][n];

        for (int[] i : dp)
            Arrays.fill(i, -1);

        for (int i = 0; i < n; i++)
            ans = Math.max(ans, solve(i, 0, n, m, mat, dp));

        return ans;
    }

    private static int solve(int i, int j, int n, int m, int[][] mat, int[][] dp) {
        // base case
        if (i < 0 || i >= n ||
                j < 0 || j >= m) {
            return 0;
        }
        if (dp[i][j] != -1) return dp[i][j];

        // recursive work
        int[] row = {-1, 0, 1};
        int[] col = {1, 1, 1};

        int ans = 0;

        for (int x = 0; x < 3; x++) {
            int r = i + row[x];
            int c = j + col[x];
            ans = Math.max(ans, mat[i][j] + solve(r, c, n, m, mat, dp));
        }

        return dp[i][j] = ans;
    }
}
