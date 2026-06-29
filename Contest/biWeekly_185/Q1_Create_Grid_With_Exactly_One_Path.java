package Contest.biWeekly_185;/*
 *
 * https://leetcode.com/contest/biweekly-contest-185/problems/create-grid-with-exactly-one-path/
 *
 * # Q1. Create Grid With Exactly One Path
 *
 *   Q. You are given two integers m and n, representing the number of rows and columns of a grid.
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
 *      Return any grid such that there is exactly one valid path from the top-left cell to the bottom-right cell.
 *
 *    Ex.
 *      Input : m = 2, n = 3
 *      Output: ["..#",
 *               "#.."]
 *      Explanation:
 *              The only valid path is: (0,0) → (0,1) → (1,1) → (1,2)
 *
 *  Constraints:
 *      1 <= m, n <= 25
 */

public class Q1_Create_Grid_With_Exactly_One_Path {

    /// Solution
    public String[] createGrid(int m, int n) {
        String[] res = new String[m];

        for (int i = 0; i < m; i++) {
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < n; j++) {
                if (i == 0 || j == n - 1) sb.append(".");
                else sb.append("#");
            }

            res[i] = sb.toString();
        }

        return res;
    }
}
