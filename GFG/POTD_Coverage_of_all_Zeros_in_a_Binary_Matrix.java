package GFG;/*
 *
 * https://www.geeksforgeeks.org/problems/coverage-of-all-zeros-in-a-binary-matrix4024/1
 *
 * # Coverage of all Zeros in a Binary Matrix
 *
 *   Q. Given a binary matrix mat[][] containing only 0s and 1s, find the total coverage of all 0's. The coverage of a
 *      particular 0 cell is defined by checking 1's in its four directions (left, right, up, and down). For each direction,
 *      if there is at least one 1 anywhere between the 0 and the boundary of the matrix, the coverage increases by one.
 *
 *      Return the sum of the coverage values for all 0 cells in the matrix.
 *
 *    Ex.
 *      Input : mat[][] = [[1, 1, 1, 0],
 *                         [1, 0, 0, 1]]
 *      Output: 8
 *      Explanation: Coverage of first zero is 2.
 *                   Coverages of other two zeros is 3 Total coverage = 2 + 3 + 3 = 8
 *
 *  Constraints:
 *      1 ≤ matrix.size, matrix[0].size ≤ 100
 */

import java.util.Scanner;

public class POTD_Coverage_of_all_Zeros_in_a_Binary_Matrix {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter dimension of matrix: ");
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] matrix = new int[n][m];

        System.out.println("Enter matrix elements: either 0 or 1");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
                if (matrix[i][j] != 0 && matrix[i][j] != 1) {
                    throw new IllegalArgumentException("input must be a binary matrix");
                }
            }
        }

        System.out.println("Sum of coverage values: ");
        System.out.println(findCoverage(matrix));
    }

    /// Solution
/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯-brute-force-⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(n×m × (n+m))
SC : O(1)
*/
    static int approach_1(int[][] mat) {
        // potd.code.hub
        int n = mat.length;
        int m = mat[0].length;
        int totalCoverage = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    totalCoverage += countCoverage(i, j, n, m, mat);
                }
            }
        }

        return totalCoverage;
    }

    private static int countCoverage(int i, int j, int n, int m, int[][] mat) {
        int a, b, c, d;
        a = b = c = d = 0;

        // vertically
        for (int len = 1; len < n; len++) {
            int up = i - len;
            int dw = i + len;

            if (up >= 0) a = Math.max(a, mat[up][j]);
            if (dw < n) b = Math.max(b, mat[dw][j]);

            if ((up < 0 && dw >= n) || (a == 1 && b == 1)) {
                break;
            }
        }

        // horizontally
        for (int len = 1; len < m; len++) {
            int l = j - len;
            int r = j + len;

            if (l >= 0) c = Math.max(c, mat[i][l]);
            if (r < m) d = Math.max(d, mat[i][r]);

            if ((l < 0 && r >= m) || (c == 1 && d == 1)) {
                break;
            }
        }

        return a + b + c + d;
    }

/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯-pre-calculation-⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(n × m)
SC : O(n + m)
*/
    static int approach_2(int[][] mat) {
        // potd.code.hub
        int n = mat.length;
        int m = mat[0].length;
        int totalCoverage = 0;

        int[] top = new int[m];
        int[] bottom = new int[m];
        int[] left = new int[n];
        int[] right = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    bottom[j]++;
                    right[i]++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    top[j]++;
                    bottom[j]--;
                    left[i]++;
                    right[i]--;
                } else {
                    if (top[j] > 0) totalCoverage++;
                    if (bottom[j] > 0) totalCoverage++;
                    if (left[i] > 0) totalCoverage++;
                    if (right[i] > 0) totalCoverage++;
                }
            }
        }

        return totalCoverage;
    }

/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯-space-optimized-⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(n × m)
SC : O(1)
*/
    static int findCoverage(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int totalCoverage = 0;

        // calculating vertically
        for (int[] row : mat) {
            boolean leftOne = false;
            boolean rightOne = false;

            for (int i = 0; i < m; i++) {
                if (row[i] == 1) leftOne = true;
                else if (leftOne) totalCoverage++;

                if (row[m - 1 - i] == 1) rightOne = true;
                else if (rightOne) totalCoverage++;
            }
        }

        // calculate horizontally
        for (int j = 0; j < m; j++) {
            boolean topOne = false;
            boolean bottomOne = false;

            for (int i = 0; i < n; i++) {
                if (mat[i][j] == 1) topOne = true;
                else if (topOne) totalCoverage++;

                if (mat[n - 1 - i][j] == 1) bottomOne = true;
                else if (bottomOne) totalCoverage++;
            }
        }

        return totalCoverage;
    }
}
