package DP;/*
 *
 * https://www.geeksforgeeks.org/problems/adventure-in-a-maze2051/1
 *
 * # Adventure in a Maze
 *
 *   Q. Given a maze represented as an n x n grid, grid[][], using 0-based indexing. Each cell contains one of the
 *      values 1, 2, or 3, which determines the direction(s) you are allowed to move from that cell:
 *        ◦ 1 - you may move Right only.
 *        ◦ 2 - you may move Down only.
 *        ◦ 3 - you may move Right or Down (both directions are available).
 *
 *      You start at the top-left cell (0, 0) (the Entry) and must reach the bottom-right cell (n-1, n-1) (the Exit),
 *      following the movement rule of each cell you pass through. You are never allowed to move outside the
 *      boundaries of the grid.
 *
 *      The Adventure of a path is the sum of the values of all cells visited along that path (including both the entry
 *      and exit cells).
 *
 *      Find the total number of distinct valid paths from Entry to Exit, and among all such paths, the maximum possible
 *      Adventure. Return the answer as [totalPaths, maxAdventure].
 *
 *      Note: Return totalPaths modulo 10⁹ + 7, maxAdventure needs no modulo, as it stays small regardless of grid size.
 *
 *    Ex.
 *      Input : grid[][] = [[1, 1, 3, 2, 1],
 *                          [3, 2, 2, 1, 2],
 *                          [1, 3, 3, 1, 3],
 *                          [1, 2, 3, 1, 2],
 *                          [1, 1, 1, 3, 1]]
 *      Output: [4, 18]
 *      Explanation: There are 4 valid paths from Entry to Exit, with total Adventures 18, 17, 17, and 16 respectively. The maximum among these is 18, so the output is [4, 18].
 *
 *  Constraints:
 *        ◦ 1 ≤ n ≤ 100
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Dynamic_Programming_Adventure_in_a_Maze {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the maze: (square matrix)");
        int n = sc.nextInt();

        int[][] grid = new int[n][n];

        System.out.print("""
                Enter elements:
                    ◦ 1 - you may move Right only.
                    ◦ 2 - you may move Down only.
                    ◦ 3 - you may move Right or Down (both directions are available).
                """);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int x = sc.nextInt();
                if (!(x == 1 || x == 2 || x == 3)) {
                    throw new IllegalArgumentException("Invalid input");
                }
                grid[i][j] = x;
            }
        }

        System.out.print("Answer as [totalPaths, maxAdventure]: ");
        System.out.println(findWays(grid));
    }

    /// Solution
    private static final int MOD = (int) 1e9 + 7;

    static ArrayList<Integer> findWays(int[][] grid) {
        // potd.code.hub
        int n = grid.length;
        long[][][] dp = new long[n][n][];

        long[] res = solve(0, 0, n, grid, dp);
        ArrayList<Integer> ans = new ArrayList<>();

        ans.add((int) res[0]);
        ans.add((int) res[1]);

        return ans;
    }

    private static long[] solve(int i, int j, int n, int[][] grid, long[][][] dp) {
        // base case
        if (i == n - 1 && j == n - 1) return new long[]{1, grid[i][j]};
        if (i == n || j == n) return new long[2];
        if (dp[i][j] != null) return dp[i][j];

        // recursive work
        int val = grid[i][j];
        long[] right = (val == 1 || val == 3) ? solve(i, j + 1, n, grid, dp) : new long[2];
        long[] down = (val == 2 || val == 3) ? solve(i + 1, j, n, grid, dp) : new long[2];
        long max = Math.max(right[1], down[1]);

        return dp[i][j] = new long[]{(right[0] + down[0]) % MOD, (max != 0) ? max + val : 0};
    }
}
