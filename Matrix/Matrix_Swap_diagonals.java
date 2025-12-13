package Matrix;/*
 *
 * https://www.geeksforgeeks.org/problems/swap-major-and-minor-diagonals-of-a-square-matrix/1
 *
 * # Swap diagonals
 *
 *   Q. Given a square matrix mat[][], the task is to swap the elements of the major and minor diagonals.
 *
 *      Major Diagonal: Elements that lie from the top-left corner to the bottom-right corner of the matrix (i.e., where
 *                      row index equals column index).
 *
 *      Minor Diagonal: Elements that lie from the top-right corner to the bottom-left corner (i.e., where the sum of row
 *                      and column indices equals n - 1).
 *    Ex.
 *      Input : mat[][] = [[0, 1, 2],
 *                         [3, 4, 5],
 *                         [6, 7, 8]]
 *      Output: [[2, 1, 0],
 *               [3, 4, 5],
 *               [8, 7, 6]]
 *      Explanation: Major Diagonal = [0, 4, 8], Minor Diagonal = [2, 4, 6]. We are required to swap the diagonal elements
 *                   of same row, thus after doing so, major diagonal will become minor and vice versa.
 *
 *  Constraints:
 *          1 ≤ mat.size() ≤ 500
 *          1 ≤ mat[i][j] ≤ 10⁶
 */

import java.util.Scanner;

public class Matrix_Swap_diagonals {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of square matrix: ");
        int n = sc.nextInt();
        int[][] mat = new int[n][n];

        System.out.println("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        swapDiagonal(mat);

        System.out.println("after Reversing diagonals: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    /// Solution
    static void swapDiagonal(int[][] mat) {
        // potd.code.hub
        int n = mat.length;

        for (int i = 0; i < n; i++){
            int temp = mat[i][i];
            mat[i][i] = mat[i][n-1-i];
            mat[i][n-1-i] = temp;
        }
    }
}
