package DP;/*
 *
 * https://www.geeksforgeeks.org/problems/cut-matrix/1
 *
 * # Cut Matrix
 *
 *   Q. Given a matrix of 0s and 1s and an integer k, divide the matrix into k pieces such that each piece has at least
 *      one 1 in it.
 *
 *      A cut can be made in the following way:
 *        ◦ Choose a direction: vertical or horizontal.
 *        ◦ Choose an index to cut the matrix into two pieces.
 *        ◦ If the cut is horizontal, only the bottom part can be cut further.
 *        ◦ If the cut is vertical, only the right part can be cut further.
 *
 *      Return the number of different ways to divide the matrix modulo 1e9 + 7.
 *
 *    Ex.
 *      Input : matrix = [[1, 0, 0],
 *                        [1, 1, 1],
 *                        [0, 0, 0]],
 *              k = 3
 *      Output: 3
 *      Explanation: There are 3 valid ways to divide the matrix into 3 pieces each having at least one 1 - horizontal
 *                   cut after row 0 then vertical cut after col 0 on bottom, horizontal cut after row 0 then vertical
 *                   cut after col 1 on bottom, and vertical cut after col 0 then vertical cut after col 1 on the right
 *                   part.
 *
 *  Constraints:
 *      1 <= n, m, k <= 200
 */

import java.util.Arrays;
import java.util.Scanner;

public class Dynamic_Programming_Cut_Matrix {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the dimensions of the matrix:");
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] mat = new int[n][m];

        System.out.println("Enter elements: (only binary elements are allowed)");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = sc.nextInt();

                if (mat[i][j] != 0 && mat[i][j] != 1)
                    throw new IllegalArgumentException("Invalid input");
            }
        }

        System.out.print("k: ");
        int k = sc.nextInt();

        System.out.println("Number of ways to cut the matrix: ");
        System.out.println(findWays(mat, k));
    }

    /// Solution
    private static final int MOD = (int) (1e9 + 7);

    static int findWays(int[][] matrix, int k) {
        // potd.code.hub
        int n = matrix.length;
        int m = matrix[0].length;
        int[][][] dp = new int[k + 1][n][m];

        // precomputing sub-matrix sums
        for (int i = 0; i < n; i++) {
            for (int j = m - 2; j >= 0; j--) {
                matrix[i][j] += matrix[i][j + 1];
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] += matrix[i + 1][j];
            }
        }

        // initializing dp[][][]
        for (int[][] a : dp) {
            for (int[] b : a) {
                Arrays.fill(b, -1);
            }
        }

        return solve(k, 0, 0, n, m, matrix, dp);
    }

    private static int solve(int k, int i, int j, int n, int m, int[][] mat, int[][][] dp) {
        // base case
        if (i == n || j == m) return 0;
        if (k == 1) return (mat[i][j] > 0) ? 1 : 0;
        if (dp[k][i][j] != -1) return dp[k][i][j];

        // recursive case
        int res = 0;
        for (int r = i; r < n - 1; r++) {
            if (mat[i][j] > mat[r + 1][j] && mat[r + 1][j] > 0) {
                res = (res + solve(k - 1, r + 1, j, n, m, mat, dp)) % MOD;
            }
        }
        for (int c = j; c < m - 1; c++) {
            if (mat[i][j] > mat[i][c + 1] && mat[i][c + 1] > 0) {
                res = (res + solve(k - 1, i, c + 1, n, m, mat, dp)) % MOD;
            }
        }

        return dp[k][i][j] = res;
    }
}
