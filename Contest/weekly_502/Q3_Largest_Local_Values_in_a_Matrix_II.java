package Contest.weekly_502;/*
 *
 * https://leetcode.com/contest/weekly-contest-502/problems/largest-local-values-in-a-matrix-ii/
 *
 * # Q3. Largest Local Values in a Matrix II
 *
 *   Q. You are given an n x m integer matrix mat containing non-negative integers.
 *
 *      A non-zero cell (row, col) checks the cells near it as follows:
 *        ◦ Let x = mat[row][col].
 *        ◦ Consider every cell within x rows and x columns of (row, col).
 *        ◦ Ignore cells that are outside the mat.
 *        ◦ Ignore the cells where both the row distance and column distance are exactly x.
 *
 *      The cell (row, col) is a local maximum if it is non-zero and no considered cell has a value greater than x.
 *
 *      Return an integer denoting the number of local maximums in matrix.
 *
 *    Ex.
 *      Input : mat = [[1, 0, 1],
 *                        [0, 1, 0],
 *                        [1, 0, 1]]
 *      Output: 5
 *      Explanation:
 *                ◦ For a cell with value 1, the considered cells are the cell itself and its 4-directionally adjacent
 *                  cells that are inside the matrix.
 *
 *                ◦ Each of the five cells with value 1 only considers cells with values 0 or 1, so all five of them are
 *                  local maximums.
 *
 *  Constraints:
 *          1 <= n == mat.length <= 200
 *          1 <= m == mat[i].length <= 200
 *          0 <= mat[i][j] <= 200
 */

import java.util.ArrayList;
import java.util.List;

public class Q3_Largest_Local_Values_in_a_Matrix_II {

    /// Solution
    public int countLocalMaximums(int[][] matrix) {
        // potd.code.hub
        int n = matrix.length;
        int m = matrix[0].length;
        int count = 0;
        List<List<int[]>> positions = new ArrayList<>();

        for (int i = 0; i <= 200; i++) {
            positions.add(new ArrayList<>());
        }

        // eliminating all the zeros.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int val = matrix[i][j];

                if (val > 0) {
                    positions.get(val).add(new int[]{i, j});
                }
            }
        }

        // traversing all the non-zero elements and chack only the greater non-zero elements.
        for (int val = 1; val <= 200; val++) {

            // getting all the position where the val exists and checking for local maximum.
            for (int[] pos : positions.get(val)) {
                int r = pos[0];
                int c = pos[1];
                boolean isLocalMax = true;

                // checking if any greater element appears in range.
                outer:
                for (int greater = val + 1; greater <= 200; greater++) {

                    for (int[] cell : positions.get(greater)) {
                        int nr = cell[0];
                        int nc = cell[1];

                        int dr = Math.abs(nr - r); // distance of r from nr
                        int dc = Math.abs(nc - c); // distance of c from nc

                        // smaller means that position is in range
                        if (dr <= val && dc <= val) {

                            // eliminating corners
                            if (dr == val && dc == val) {
                                continue;
                            }

                            isLocalMax = false;
                            break outer;
                        }
                    }

                }

                if (isLocalMax) {
                    count++;
                }
            }
        }

        return count;
    }
}
