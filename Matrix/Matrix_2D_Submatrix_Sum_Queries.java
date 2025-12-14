package Matrix;/*
 *
 * https://www.geeksforgeeks.org/problems/2d-submatrix-sum-queries/1
 *
 * # 2D Submatrix Sum Queries
 *
 *   Q. Given a 2D array matrix[][] and an array queries[][], your task is to answer a series of submatrix sum queries.
 *
 *      Each query is represented as a list [r1, c1, r2, c2], where:
 *        ➠ (r1, c1) is the top-left coordinate of the submatrix
 *        ➠ (r2, c2) is the bottom-right coordinate of the submatrix (both inclusive)
 *        ➠ Your task is to return a list of integers, the sum of elements within the specified submatrix for each query.
 *    Ex.
 *      Input : mat[][] = [[1, 1, 1],   queries[][] = [[1, 1, 2, 2],
 *                         [1, 1, 1],                  [0, 0, 2, 2],
 *                         [1, 1, 1]]                  [0, 2, 2, 2]]
 *      Output: [4, 9, 3]
 *      Explanation:
 *              Query 1 selects submatrix [[1, 1], [1, 1]] → sum = 4.
 *              Query 2 selects submatrix [[1, 1, 1], [1, 1, 1], [1, 1, 1]] → sum = 9.
 *              Query 3 selects submatrix [[1], [1], [1]] → sum = 3.
 *
 *  Constraints:
 *          1 ≤ n × m, q ≤ 10⁵
 *          0 ≤ mat[i][j] ≤ 10⁴
 *          0 ≤ r1 ≤ r2 ≤ n - 1
 *          0 ≤ c1 ≤ c2 ≤ m - 1
 */

import java.util.ArrayList;

public class Matrix_2D_Submatrix_Sum_Queries {

    /// main Method
    public static void main(String[] args) {
        int[][] mat = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };
        int[][] queries = {
                {1, 1, 2, 2},
                {0, 0, 2, 2},
                {0, 2, 2, 2},
        };

        System.out.println("Sum of submatrices: " + prefixSum2D(mat, queries));
    }

    /// Solution
    static ArrayList<Integer> prefixSum2D(int[][] mat, int[][] queries) {
        // potd.code.hub
        int n = mat.length;
        int m = mat[0].length;
        ArrayList<Integer> list = new ArrayList<>();

        prefixSumMatrix(mat, n, m);

        for (int[] query : queries) {
            int r1 = query[0];
            int c1 = query[1];
            int r2 = query[2];
            int c2 = query[3];

            int total = mat[r2][c2];
            int leftSubMat = (c1 > 0) ? mat[r2][c1 - 1] : 0;
            int rightSubMat = (r1 > 0) ? mat[r1 - 1][c2] : 0;
            int overlap = (r1 > 0 && c1 > 0) ? mat[r1 - 1][c1 - 1] : 0;

            int sum = total - leftSubMat - rightSubMat + overlap;
            list.add(sum);
        }

        return list;
    }

    private static void prefixSumMatrix(int[][] mat, int n, int m) {
        // prefix-sum for rows
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                mat[i][j] += mat[i][j - 1];
            }
        }
        // prefix-sum for columns
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] += mat[i - 1][j];
            }
        }
    }
}
