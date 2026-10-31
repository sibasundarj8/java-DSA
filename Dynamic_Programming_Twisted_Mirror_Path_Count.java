package DP;/*
 *
 * https://leetcode.com/problems/twisted-mirror-path-count/
 *
 * # LC. 3665. Twisted Mirror Path Count
 *
 *   Q. Given an m x n binary grid[][] where:
 *        ◦ grid[i][j] == 0 represents an empty cell, and
 *        ◦ grid[i][j] == 1 represents a mirror.
 *
 *      A robot starts at the top-left corner of the grid (0, 0) and wants to reach the bottom-right corner
 *      (m - 1, n - 1). It can move only right or down. If the robot attempts to move into a mirror cell, it
 *      is reflected before entering that cell:
 *
 *        ◦ If it tries to move right into a mirror, it is turned down and moved into the cell directly below
 *          the mirror.
 *
 *        ◦ If it tries to move down into a mirror, it is turned right and moved into the cell directly to the
 *          right of the mirror.
 *
 *      If this reflection caused the robot to move outside the grid boundaries, the path is considered invalid
 *      and should not be counted.
 *
 *      Return the number of unique valid paths from (0, 0) to (m - 1, n - 1).
 *
 *      Since the answer may be very large, return it modulo 109 + 7.
 *
 *      Note: If a reflection moves the robot into a mirror cell, the robot is immediately reflected again based
 *            on the direction it used to enter that mirror: if it entered while moving right, it will be turned
 *            down; if it entered while moving down, it will be turned right. This process will continue until
 *            either the last cell is reached, the robot moves out of bounds or the robot moves to a non-mirror
 *            cell.
 *
 *    Ex.
 *      Input : grid = [[0,1,0],[0,0,1],[1,0,0]]
 *      Output: 5
 *      Explanation:
 *                  +---------+-----------------------------------------------------+
 *                  | Number  |                Full Path                            |
 *                  +---------+-----------------------------------------------------+
 *                  |    1	  |  (0, 0) → (0, 1) [M] → (1, 1) → (1, 2) [M] → (2, 2) |
 *                  +---------+-----------------------------------------------------+
 *                  |    2	  |  (0, 0) → (0, 1) [M] → (1, 1) → (2, 1) → (2, 2)     |
 *                  +---------+-----------------------------------------------------+
 *                  |    3	  |  (0, 0) → (1, 0) → (1, 1) → (1, 2) [M] → (2, 2)     |
 *                  +---------+-----------------------------------------------------+
 *                  |    4	  |  (0, 0) → (1, 0) → (1, 1) → (2, 1) → (2, 2)         |
 *                  +---------+-----------------------------------------------------+
 *                  |    5	  |  (0, 0) → (1, 0) → (2, 0) [M] → (2, 1) → (2, 2)     |
 *                  +---------+-----------------------------------------------------+
 *
 *                 [M] indicates the robot attempted to enter a mirror cell and instead reflected.
 *
 *  Constraints:
 *        ◦ m == grid.length
 *        ◦ n == grid[i].length
 *        ◦ 2 <= m, n <= 500
 *        ◦ grid[i][j] is either 0 or 1.
 *        ◦ grid[0][0] == grid[m - 1][n - 1] == 0
 */

import java.util.Scanner;

public class Dynamic_Programming_Twisted_Mirror_Path_Count {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter dimensions of grid: ");
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];

        System.out.println("Enter grid elements: (0 or 1)");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        System.out.println("number of unique valid paths from top-left to bottom-right corner: ");
        System.out.println(uniquePaths(grid));
    }

    /// Solution
/*
--------------------------------------------------bottom-up--tabulation--------------------------------------------------
TC : O(n * m)
SC : O(n * m)
*/
    static int tabulation(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        long mod = (long) 1e9 + 7;

        long[][] dp = new long[n][m];
        dp[n - 1][m - 1] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (i == n - 1 && j == m - 1) continue;

                long right = 0;
                long down = 0;

                if (j + 1 < m) { // right cell
                    // mirror reflecting to down
                    if (grid[i][j + 1] == 1) right = dp[i][j + 1] >>> 32;
                    else right = dp[i][j + 1];
                }

                if (i + 1 < n) { // down cell
                    // mirror reflecting to right cell
                    if (grid[i + 1][j] == 1) down = dp[i + 1][j] & 0XFFFFFFFFL;
                    else down = dp[i + 1][j];
                }

                if (grid[i][j] == 1) {
                    dp[i][j] = (down << 32) | right;
                } else {
                    dp[i][j] = (right + down) % mod;
                }
            }
        }

        return (int) dp[0][0];
    }

/*
---------------------------------------------------space-optimized--DP---------------------------------------------------
TC : O(n * m)
SC : O(2m)
*/
    static int spaceOptimization(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        long mod = (long) 1e9 + 7;

        long[] cur = new long[m];
        long[] nxt = new long[m];

        cur[m - 1] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (i == n - 1 && j == m - 1) continue;

                long right = 0;
                long down = 0;

                if (j + 1 < m) { // right cell
                    // mirror reflecting to down
                    if (grid[i][j + 1] == 1) right = cur[j + 1] >>> 32;
                    else right = cur[j + 1];
                }

                if (i + 1 < n) { // down cell
                    // mirror reflecting to right cell
                    if (grid[i + 1][j] == 1) down = nxt[j] & 0XFFFFFFFFL;
                    else down = nxt[j];
                }

                if (grid[i][j] == 1) {
                    cur[j] = (down << 32) | right;
                } else {
                    cur[j] = (right + down) % mod;
                }
            }

            long[] tmp = cur;
            cur = nxt;
            nxt = tmp;
        }

        return (int) nxt[0];
    }

/*
-----------------------------------------------single-array--Optimization-----------------------------------------------
TC : O(n * m)
SC : O(m)
*/
    static int uniquePaths(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        long mod = (long) 1e9 + 7;

        long[] dp = new long[m];
        dp[m - 1] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (i == n - 1 && j == m - 1) continue;

                long right = 0;
                long down = 0;

                if (j + 1 < m) { // right cell
                    // mirror reflecting to down
                    if (grid[i][j + 1] == 1) right = dp[j + 1] >>> 32;
                    else right = dp[j + 1];
                }

                if (i + 1 < n) { // down cell
                    // mirror reflecting to right cell
                    if (grid[i + 1][j] == 1) down = dp[j] & 0XFFFFFFFFL;
                    else down = dp[j];
                }

                if (grid[i][j] == 1) {
                    dp[j] = (down << 32) | right;
                } else {
                    dp[j] = (right + down) % mod;
                }
            }
        }

        return (int) dp[0];
    }
}
