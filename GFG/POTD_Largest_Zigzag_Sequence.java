package GFG;/*
 *
 * https://www.geeksforgeeks.org/problems/largest-zigzag-sequence5416/1
 *
 * # Largest Zigzag Sequence
 *
 *   Q. Given a square matrix mat[][] of size n × n. A zigzag sequence starts from the top and ends at the bottom. Two
 *      consecutive elements of sequence cannot belong to the same column.
 *
 *      Return the maximum sum of such a zigzag sequence.
 *
 *    Ex.
 *      Input : mat[][] = [[ 1, 2,  4],
 *                         [ 3, 9,  6],
 *                         [11, 3, 15]]
 *      Output: 28
 *      Explanation:
 *              One optimal zigzag sequence is: 4 -> 9 -> 15, where the sum = 4 + 9 + 15 = 28.
 *
 *  Constraints:
 *        1 ≤ n ≤ 100
 *        1 ≤ mat[i][j] ≤ 1000
 */

import java.util.Arrays;
import java.util.Scanner;

public class POTD_Largest_Zigzag_Sequence {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of squire matrix: ");
        int n = sc.nextInt();

        int[][] mat = new int[n][n];

        System.out.println("Enter elements: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        System.out.println("Maximum sum of a zigzag sequence: ");
        System.out.println(zigzagSequence(mat));
    }

    /// Solution
    static int zigzagSequence(int[][] mat) {
        // potd.code.hub
        int n = mat.length;
        int[][] dp = new int[n][n + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, n, n, mat, dp);
    }

    private static int solve(int r, int prvCol, int n, int[][] mat, int[][] dp) {
        // base case
        if (r >= n) return 0;
        if (dp[r][prvCol] != -1) return dp[r][prvCol];

        // recursive work
        int max = 0;

        for (int j = 0; j < n; j++) {
            if (j != prvCol) {
                max = Math.max(max, mat[r][j] + solve(r + 1, j, n, mat, dp));
            }
        }

        return dp[r][prvCol] = max;
    }
}
