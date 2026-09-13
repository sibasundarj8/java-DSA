package Contest.weekly_519;/*
 *
 * https://leetcode.com/contest/weekly-contest-519/problems/cyclically-shift-rows-and-columns/
 *
 * # Q1. Cyclically Shift Rows and Columns
 *
 *   Q. You are given an integer n, a 2D integer array grid of size n x n, and two integer arrays rowShift and colShift,
 *      each of length n, where:
 *        ◦ rowShift[i] represents the number of positions to cyclically shift the ith row of grid to the left.
 *        ◦ colShift[j] represents the number of positions to cyclically shift the jth column of grid upward.
 *
 *      First, cyclically shift each row according to rowShift, then cyclically shift each column of the resulting grid
 *      according to colShift.
 *
 *      Return the resulting grid after performing all the shifts.
 *
 *      A cyclic left shift of a row by k positions moves the element at column j to column (j - k + n) % n. All other
 *      rows remain unchanged.
 *
 *      A cyclic upward shift of a column by k positions moves the element at row i to row (i - k + n) % n. All other
 *      columns remain unchanged.
 *
 *    Ex.
 *      Input : n = 2,
 *              grid = [[1, 2],
 *                      [3, 4]],
 *              rowShift = [1, 0],
 *              colShift = [0, 1]
 *      Output: [[2, 4],
 *               [3, 1]]
 *      Explanation:
 *              The grid changes as follows:
 *             +----+----+          +----+----+         +----+----+         +----+----+         +----+----+
 *             | 1  |  2 |  row[0]  | 2  |  1 |  row[1] | 2  |  1 |  col[0] | 2  |  1 |  col[1] | 2  |  4 |
 *             +----+----+   --->   +----+----+  --->   +----+----+   --->  +----+----+  --->   +----+----+
 *             | 3  |  4 |          | 3  |  4 |         | 3  |  4 |         | 3  |  4 |         | 3  |  1 |
 *             +----+----+          +----+----+         +----+----+         +----+----+         +----+----+
 *
 *  Constraints:
 *        ◦ 1 <= n == grid.length == grid[i].length <= 10
 *        ◦ 1 <= grid[i][j] <= 100
 *        ◦ rowShift.length == colShift.length == n
 *        ◦ 0 <= rowShift[i], colShift[i] < n
 */

public class Q1_Cyclically_Shift_Rows_and_Columns {

    /// Solution
    public int[][] cyclicShift(int n, int[][] grid, int[] rowShift, int[] colShift) {
        int[][] temp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int r = (i + colShift[j]) % n;
                int c = (j + rowShift[r]) % n;
                temp[i][j] = grid[r][c];
            }
        }

        return temp;
    }
}
