package Matrix;/*
 *
 * https://leetcode.com/problems/rotate-image/
 *
 * # 48. Rotate Image
 *
 *   Q. You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 *
 *      You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate
 *      another 2D matrix and do the rotation.
 *
 *    Ex.
 *      Input : matrix = [[5,   1,  9, 11],
 *                        [2,   4,  8, 10],
 *                        [13,  3,  6,  7],
 *                        [15, 14, 12, 16]]
 *      Output: [[15, 13,  2,  5],
 *               [14,  3,  4,  1],
 *               [12,  6,  8,  9],
 *               [16,  7, 10, 11]]                                  +----+----+----+----+        +----+----+----+----+
 *                                                                  |  5 |  1 |  9 | 11 |        | 15 | 13 |  2 |  5 |
 *                                                                  +----+----+----+----+        +----+----+----+----+
 *                                                                  |  2 |  4 |  8 | 10 |  --->  | 14 |  3 |  4 |  1 |
 *                                                                  +----+----+----+----+        +----+----+----+----+
 *                                                                  | 13 |  3 |  6 |  7 |        | 12 |  6 |  8 |  9 |
 *  Constraints:                                                    +----+----+----+----+        +----+----+----+----+
 *          n == matrix.length == matrix[i].length                  | 15 | 14 | 12 | 16 |        | 16 |  7 | 10 | 11 |
 *          1 <= n <= 20                                            +----+----+----+----+        +----+----+----+----+
 *          -1000 <= matrix[i][j] <= 1000
 */

import java.util.Arrays;
import java.util.Scanner;

public class Matrix_Rotate_90d_Clockwise {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Dimensions of Matrix :");
        int r = sc.nextInt();
        int c = sc.nextInt();

        if (r != c) {
            throw new IllegalArgumentException("nly Square matrix are allowed.");
        }
        int[][] mat = new int[r][c];

        System.out.println("Enter Array elements :");
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                mat[i][j] = sc.nextInt();
            }
        }
        System.out.println("The Matrix is rotated by 90 degree :");
        rotate(mat);

        for (int[] row : mat) {
            System.out.println(Arrays.toString(row));
        }
    }

    /// Solution
    static void rotate(int[][] matrix) {
        // potd.code.hub
        transpose(matrix);

        for (int[] row : matrix) {
            reverse(row);
        }
    }

    private static void transpose(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }

    private static void reverse(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - 1 - i];
            arr[n - 1 - i] = temp;
        }
    }
}
