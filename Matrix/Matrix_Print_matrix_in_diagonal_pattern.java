package Matrix;/*
 *
 * https://www.geeksforgeeks.org/problems/print-matrix-in-diagonal-pattern/1
 *
 * # Print matrix in diagonal pattern
 *
 *   Q. Given a square matrix mat[][] of n*n size, the task is to determine the diagonal pattern which is a linear arrangement
 *      of the elements of the matrix as depicted in the following example:
 *                                                                          +---+---+---+
 *                                                                          | 1 → 2   3 |
 *                                                                          |   ↙︎  ↗︎ ↓ |
 *                                                                          | 4   5   6 |
 *                                                                          | ↓ ↗︎  ↙︎   |
 *    Ex.                                                                   | 7   8 → 9 |
 *      Input : n = 3                                                       +---+---+---+
 *              mat[][] = {{1, 2, 3},
 *                         {4, 5, 6},
 *                         {7, 8, 9}}
 *      Output: {1, 2, 4, 7, 5, 3, 6, 8, 9}
 *      Explanation:
 *              Starting from (0, 0): 1,
 *              Move to the right to (0, 1): 2,
 *              Move diagonally down to (1, 0): 4,
 *              Move diagonally down to (2, 0): 7,
 *              Move diagonally up to (1, 1): 5,
 *              Move diagonally up to (0, 2): 3,
 *              Move to the right to (1, 2): 6,
 *              Move diagonally up to (2, 1): 8,
 *              Move diagonally up to (2, 2): 9
 *              There for the output is {1, 2, 4, 7, 5, 3, 6, 8, 9}.
 *
 *  Constraints:
 *          1 <= n <= 100
 *          -100 <= elements of matrix <= 100
 */

import java.util.Arrays;
import java.util.Scanner;

public class Matrix_Print_matrix_in_diagonal_pattern {

    /// Main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of square matrix: ");
        int n = sc.nextInt();

        int[][] mat = new int[n][n];

        System.out.println("Enter the elements of matrix: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        System.out.println("Diagonal patters: ");
        System.out.println(Arrays.toString(matrixDiagonally(mat)));
    }

    /// Solution
    static int[] matrixDiagonally(int[][] mat) {
        // potd.code.hub
        int n = mat.length;
        int m = n + n - 1;
        int idx = 0;
        int[] ans = new int[n * n];

        int row = 0;
        int col = 0;

        for (int i = 0; i < m; i++) {
            boolean even = (i & 1) == 0;

            int startI = (even) ? row : col;
            int startJ = (even) ? col : row;
            int endI = startJ;
            int endJ = startI;

            while (startI != endI && startJ != endJ) {

                ans[idx++] = mat[startI][startJ];

                if (even) {
                    startI--;
                    startJ++;
                } else {
                    startI++;
                    startJ--;
                }
            }
            ans[idx++] = mat[startI][startJ];

            if (row == n - 1) col++;
            else row++;
        }

        return ans;
    }
}
