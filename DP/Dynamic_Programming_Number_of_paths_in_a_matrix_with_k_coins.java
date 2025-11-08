package DP;/*
 *
 * https://www.geeksforgeeks.org/problems/number-of-paths-in-a-matrix-with-k-coins2728/1
 *
 * # Number of paths in a matrix with k coins
 *
 *   Q. You are given a matrix mat[][] of size n x m, where each of its cells contains some coins. Count the number of
 *      ways to collect exactly k coins while moving from the top left cell of the matrix to the bottom right cell.
 *      From a cell (i, j), you can only move to cell (i+1, j) or (i, j+1).
 *
 *      Note: It is guaranteed that the answer will not exceed 32-bit integer limits.
 *
 *    Ex.
 *      Input : k = 12, mat[] = [[1, 2, 3],
 *                               [4, 6, 5],
 *                               [3, 2, 1]]
 *      Output: 2
 *      Explanation: There are 2 possible paths with exactly 12 coins, (1 + 2 + 6 + 2 + 1) and (1 + 2 + 3 + 5 + 1).
 *
 *  Constraints:
 *      1 ≤ k ≤ 100
 *      1 ≤ n, m ≤ 100
 *      0 ≤ mat[i][j] ≤ 200
 */

import java.util.Arrays;
import java.util.Scanner;

public class Dynamic_Programming_Number_of_paths_in_a_matrix_with_k_coins {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("k: ");
        int k = sc.nextInt();

        System.out.println("Enter Dimension: ");
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] mat = new int[n][m];

        System.out.println("Enter Elements: ");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                mat[i][j] = sc.nextInt();

        System.out.println("Number of path to reach bottom right point with k cost: ");
        System.out.println(numberOfPath(mat, k));
    }

    /// Solution
    static int numberOfPath(int[][] mat, int k) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        int[][][] dp = new int[n][m][k+1];

        for(int[][] i : dp)
            for(int[] j : i)
                Arrays.fill(j, -1);

        return f(0, 0, k, n, m, mat, dp);
    }

    // helper method
    private static int f(int i, int j, int k, int n, int m, int[][] mat, int[][][] dp) {
        // base case
        if(i == n-1 && j == m-1 && k == mat[i][j]) return 1;
        if(i >= n || j >= m || k < 0) return 0;
        if(dp[i][j][k] != -1) return dp[i][j][k];

        // recursive work
        int t = k - mat[i][j];
        int down = f(i+1, j, t, n, m, mat, dp);
        int right = f(i, j+1, t, n, m, mat, dp);

        // self work
        return dp[i][j][k] = down + right;
    }
}
