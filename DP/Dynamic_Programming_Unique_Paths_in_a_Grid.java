package DP;/*
 *
 * https://www.geeksforgeeks.org/problems/unique-paths-in-a-grid--170647/1
 *
 * # Unique Paths in a Grid
 *
 *   Q. You are given a 2d list grid[][] of size n x m consisting of values 0 and 1. A value of 0 means that you
 *      can enter that cell and 1 implies that entry to that cell is not allowed.
 *
 *      You start at the upper-left corner of the grid (1, 1) and you have to reach the bottom-right corner (n, m)
 *      such that you can only move in the right or down direction from every cell. Your task is to calculate the
 *      total number of ways of reaching the target.
 *
 *      Note: The first (1, 1) and last (n, m) cell of the grid can also be 1.
 *            It is guaranteed that the total number of ways will fit within a 32-bit integer.
 *    Ex.
 *      Input : n = 3, m = 3,
 *              grid[][] = [[0, 0, 0],
 *                          [0, 1, 0],
 *                          [0, 0, 0]]
 *      Output: 2
 *      Explanation: There are two ways to reach the bottom-right corner:]
 *                   1. Right -> Right -> Down -> Down]
 *                   2. Down -> Down -> Right -> Right
 */

import java.util.Arrays;
import java.util.Scanner;

public class Dynamic_Programming_Unique_Paths_in_a_Grid {

/// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter dimension: ");
        int r = sc.nextByte();
        int c = sc.nextByte();

        int[][] grid = new int[r][c];

        System.out.println("Enter Binary matrix elements: ");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                grid[i][j] = sc.nextByte();
            }
        }

        System.out.println("Number of unique paths: " + uniquePaths(grid));
    }

/// Solution
/***************************************************<--Memoization-->***************************************************/
// TC : O(n * m)
// SC : O(n * m * 2)
    static int memo(int[][] grid) {
        // potd.code.hub
        int n = grid.length;
        int m = grid[0].length;

        if (grid[0][0] == 1 || grid[n - 1][m - 1] == 1) {
            return 0;
        }

        int[][] dp = new int[n + 1][m + 1];
        for (int[] i : dp)
            Arrays.fill(i, -1);

        return f(grid, 1, 1, n, m, dp);
    }

    private static int f(int[][] grid, int i, int j, int n, int m, int[][] dp) {
        // base case
        if (i == n+1 || j == m+1 || grid[i-1][j-1] == 1) return 0;
        if (i == n && j == m) return 1;
        if (dp[i][j] != -1) return dp[i][j];

        // recursive work
        int right = f(grid, i, j + 1, n, m, dp);
        int down = f(grid, i + 1, j, n, m, dp);

        // self work
        return dp[i][j] = right + down;
    }

/****************************************************<--Tabulation-->****************************************************/
// TC : O(n * m)
// SC : O(n * m)
    static int tab(int[][] grid) {
        // potd.code.hub
        int n = grid.length;
        int m = grid[0].length;

        if (grid[0][0] == 1 || grid[n - 1][m - 1] == 1) {
            return 0;
        }

        int[][] dp = new int[n + 1][m + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {

                if (grid[i][j] == 1) continue;

                if (i == n - 1 && j == m - 1) {
                    dp[i][j] = 1;
                } else {
                    int right = dp[i][j + 1];
                    int down = dp[i + 1][j];
                    dp[i][j] = right + down;
                }
            }
        }

        return dp[0][0];
    }

/**************************************************<--Space-Optimized->**************************************************/
// TC : O(n * m)
// SC : O(m)
    static int uniquePaths(int[][] grid) {
        // potd.code.hub
        int n = grid.length;
        int m = grid[0].length;

        if (grid[0][0] == 1 || grid[n - 1][m - 1] == 1) {
            return 0;
        }

        int[] curr = new int[m + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {

                if (grid[i][j] == 1) {
                    curr[j] = 0;
                } else if (i == n - 1 && j == m - 1) {
                    curr[j] = 1;
                } else {
                    int right = curr[j + 1];
                    int down = curr[j];
                    curr[j] = right + down;
                }
            }
        }

        return curr[0];
    }
}
