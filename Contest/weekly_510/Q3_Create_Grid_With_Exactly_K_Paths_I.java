package Contest.weekly_510;/*
 *
 * https://leetcode.com/problems/create-grid-with-exactly-k-paths-i/
 *
 * # Q3. Create Grid With Exactly K Paths I
 *
 *   Q. You are given three integers m, n, and k.
 *
 *      Construct any m x n grid consisting only of the characters '.' and '#', where:
 *        ◦ '.' represents a free cell.
 *        ◦ '#' represents an obstacle cell.
 *
 *      A valid path is a sequence of free cells that:
 *        ◦ Starts at the top-left cell (0, 0).
 *        ◦ Ends at the bottom-right cell (m - 1, n - 1).
 *        ◦ Moves only:
 *            ⎯ Right, from (i, j) to (i, j + 1), or
 *            ⎯ Down, from (i, j) to (i + 1, j).
 *
 *      Return any grid such that there are exactly k valid paths from the top-left cell to the bottom-right cell.
 *      If no such grid exists, return an empty array.
 *
 *    Ex.
 *      Input : m = 3, n = 3, k = 4
 *      Output: ["..#",
 *               "...",
 *               "#.."]
 *      Explanation:
 *              There are exactly k = 4 valid paths from (0, 0) to (2, 2):
 *                ◦ (0, 0) → (0, 1) → (1, 1) → (1, 2) → (2, 2)
 *                ◦ (0, 0) → (0, 1) → (1, 1) → (2, 1) → (2, 2)
 *                ◦ (0, 0) → (1, 0) → (1, 1) → (1, 2) → (2, 2)
 *                ◦ (0, 0) → (1, 0) → (1, 1) → (2, 1) → (2, 2)
 *
 *  Constraints:
 *        1 <= m, n <= 10
 *        1 <= k <= 4
 */

import java.util.Arrays;

public class Q3_Create_Grid_With_Exactly_K_Paths_I {

    /// Solution
    public String[] createGrid(int n, int m, int k) {
        int[][] waysFrom = new int[n][m];
        int[][] waysTo = new int[n][m];

        for (int[] row : waysTo) {
            Arrays.fill(row, -1);
        }

        int totalWays = solve(n - 1, m - 1, waysTo);

        if (k > totalWays) {
            return new String[0];
        }

        char[][] chars = new char[n][m];
        for (char[] row : chars) {
            Arrays.fill(row, '.');
        }

        if (k == totalWays) {
            return convert(chars, n);
        }

        waysFrom[n - 1][m - 1] = 1;
        k = totalWays - k;

        outer:
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (i == n - 1 && j == m - 1) continue;

                if (i < n - 1) waysFrom[i][j] += waysFrom[i + 1][j];
                if (j < m - 1) waysFrom[i][j] += waysFrom[i][j + 1];

                int waysThroughCell = waysTo[i][j] * waysFrom[i][j];

                if (waysThroughCell == 0) continue;

                if (k >= waysThroughCell) {
                    chars[i][j] = '#';
                    waysFrom[i][j] = 0;
                    k -= waysThroughCell;

                    if (k == 0) break outer;
                }
            }
        }

        return convert(chars, n);
    }

    private int solve(int r, int c, int[][] dp) {
        // base case
        if (r == 0 && c == 0) return dp[r][c] = 1;
        if (dp[r][c] != -1) return dp[r][c];

        // recursive work
        int ways = 0;
        if (r > 0) ways += solve(r - 1, c, dp);
        if (c > 0) ways += solve(r, c - 1, dp);

        return dp[r][c] = ways;
    }

    private String[] convert(char[][] chars, int n) {
        String[] res = new String[n];

        for (int i = 0; i < n; i++)
            res[i] = String.valueOf(chars[i]);

        return res;
    }
}
