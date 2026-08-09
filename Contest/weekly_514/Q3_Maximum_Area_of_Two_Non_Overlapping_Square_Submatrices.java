package Contest.weekly_514;/*
 *
 * https://leetcode.com/contest/weekly-contest-514/problems/maximum-area-of-two-non-overlapping-square-submatrices/
 *
 * # Q3. Maximum Area of Two Non-Overlapping Square Submatrices
 *
 *   Q. You are given a 2D integer matrix mat of size m × n, where:
 *        ◦ mat[r][c] == 1 means the cell at row r and column c is usable.
 *        ◦ mat[r][c] == 0 means it is not usable.
 *
 *      Your task is to find two submatrices that satisfy the following conditions:
 *        ◦ Both submatrices must be squares of the same side length k.
 *        ◦ The two submatrices must not share any cell.
 *        ◦ Each submatrix can only cover cells where mat[r][c] == 1.
 *
 *      Return the maximum possible area of each of the two squares. If it is not possible to choose two such squares,
 *      return 0.
 *
 *    Ex.
 *      Input : mat = [[1, 1, 1, 0],
 *                     [1, 1, 1, 1],
 *                     [0, 0, 1, 1]]
 *      Output: 4
 *      Explanation:
 *              The largest equal non-overlapping squares have side length k = 2 with area 4.
 *                ◦ First square starts at top-left (0, 0) and covers cells (0, 0), (0, 1), (1, 0), and (1, 1).
 *                ◦ Second square starts at top-left (1, 2) and covers cells (1, 2), (1, 3), (2, 2), and (2, 3).
 *
 *              Thus, the answer is 4.
 *
 *  Constraints:
 *        ◦ mat.length == m
 *        ◦ mat[i].length == n
 *        ◦ 1 <= m, n <= 500
 *        ◦ mat[i][j] is either 0 or 1.
 */

public class Q3_Maximum_Area_of_Two_Non_Overlapping_Square_Submatrices {

    /// Solution
    public int maxArea(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                mat[i][j] += mat[i][j - 1];
            }

            if (i > 0) {
                for (int j = 0; j < m; j++) {
                    mat[i][j] += mat[i - 1][j];
                }
            }
        }

        int i = 1;
        int j = Math.max(n, m) >> 1;

        while (i <= j) {
            int mid = i + ((j - i) >> 1);
            if (isPossible(mat, mid, n, m)) {
                i = mid + 1;
            } else j = mid - 1;
        }

        return j * j;
    }

    private static boolean isPossible(int[][] mat, int k, int n, int m) {
        int maxTopRow, minBottomRow, minRightCol, maxLeftCol;
        minBottomRow = minRightCol = Integer.MAX_VALUE;
        maxTopRow = maxLeftCol = Integer.MIN_VALUE;
        int t = k - 1;
        int requiredSum = k * k;

        for (int x2 = t; x2 < n; x2++) {
            for (int y2 = t; y2 < m; y2++) {
                int x1 = x2 - t;
                int y1 = y2 - t;

                int sum = mat[x2][y2];
                if (y1 > 0) sum -= mat[x2][y1 - 1];
                if (x1 > 0) sum -= mat[x1 - 1][y2];
                if (x1 > 0 && y1 > 0) sum += mat[x1 - 1][y1 - 1];

                if (sum == requiredSum) {
                    minBottomRow = Math.min(minBottomRow, x2);
                    minRightCol = Math.min(minRightCol, y2);
                    maxTopRow = Math.max(maxTopRow, x1);
                    maxLeftCol = Math.max(maxLeftCol, y1);
                }
            }
        }

        return (minBottomRow < maxTopRow) || (minRightCol < maxLeftCol);
    }
}