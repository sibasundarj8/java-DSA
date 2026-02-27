package PrefixSum;/*
 *
 * https://www.geeksforgeeks.org/problems/number-of-submatrix-have-sum-k/1
 *
 * # Number of submatrix have sum X
 *
 *   Q. Given a matrix mat[][] of size n × m and an integer x, find the number of square submatrices whose sum of elements
 *      is equal to x.
 *
 *      Ex.
 *        Input : mat[][] = [[ 2,   4, 7, 8, 10],
 *                           [ 3,   1, 1, 1,  1],
 *                           [ 9,  11, 1, 2,  1],
 *                           [12, -17, 1, 1,  1]],
 *                x = 10
 *        Output: 3
 *        Explanation: The sub-squares whose sum of elements = 10, are colored in the matrix.
 *
 *  Constraints:
 *          1 ≤ n, m ≤ 100
 *         -10³ ≤ mat[i] ≤ 10³
 *         -10⁹ ≤ x ≤ 10⁹
 */

import java.util.Scanner;

public class Q09_Number_of_submatrix_have_sum_X {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter dimension of matrix: ");
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] mat = new int[n][m];

        System.out.println("Enter matrix elements: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter x: ");
        int x = sc.nextInt();

        System.out.println("number of submatrix which sum is " + x + " is: ");
        System.out.println(countSquare(mat, x));
    }

    /// Solution
    static int countSquare(int[][] mat, int x) {
        // potd.code.hub
        int n = mat.length;
        int m = mat[0].length;
        int count = 0;
        int[][] prefixMat = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                int a = (i > 0) ? prefixMat[i - 1][j] : 0;
                int b = (j > 0) ? prefixMat[i][j - 1] : 0;
                int c = (i > 0 && j > 0) ? prefixMat[i - 1][j - 1] : 0;

                prefixMat[i][j] = mat[i][j] + a + b - c;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                int i1 = i;
                int j1 = j;

                while (i1 < n && j1 < m) {
                    int a = (j > 0) ? prefixMat[i1][j - 1] : 0;
                    int b = (i > 0) ? prefixMat[i - 1][j1] : 0;
                    int c = (i > 0 && j > 0) ? prefixMat[i - 1][j - 1] : 0;

                    if (prefixMat[i1][j1] - a - b + c == x) count++;

                    i1++;
                    j1++;
                }

            }
        }

        return count;
    }
}
