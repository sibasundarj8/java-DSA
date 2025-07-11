package DP;/*
 *
 * https://www.geeksforgeeks.org/problems/consecutive-1s-not-allowed1912/1
 *
 * # Consecutive 1's not allowed
 *   Q. Given a positive integer n, count all possible distinct binary strings of length n such that there are
 *      no consecutive 1’s.
 *   Ex.
 *      Input : n = 3
 *      Output: 5
 *      Explanation: 5 strings are ("000", "001", "010", "100", "101").
 */

import java.util.Arrays;
import java.util.Scanner;

public class Dynamic_Programming_Consecutive_1s_not_allowed {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of binary string: ");
        int n = sc.nextInt();

        System.out.println("Number of possibilities without consecutive 1 : ");
        System.out.println(countStrings(n));

    }

    /// Solution
/*
-------------------------------------------------------Brute-Force-------------------------------------------------------
TC : O(2ⁿ)
SC : O(n)
*/
    static int bruteForceCountStrings(int n) {
        // potd.code.hub
        if (n == 0 || n == 1) return n + 1;

        int set1 = bruteForceCountStrings(n-2);
        int set0 = bruteForceCountStrings(n-1);

        return set0 + set1;
    }
/*
-------------------------------------------------------Top-Down-DP-------------------------------------------------------
TC : O(n)
SC : O(n + n)
*/
    static int topDownCountStrings(int n) {
        // potd.code.hub
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return f(n, dp);
    }
    private static int f (int n, int[] dp) {
        // base case
        if (n == 0 || n == 1) return n + 1;
        if (dp[n] != -1) return dp[n];

        int set1 = f(n-2, dp);
        int set0 = f(n-1, dp);

        return dp[n] = set0 + set1;
    }
/*
------------------------------------------------------Bottom-Up-DP-------------------------------------------------------
TC : O(n)
SC : O(n)
*/
    static int bottomUpCountStrings(int n) {
        // potd.code.hub
        int[] dp = new int[n+1];

        dp[0] = 1;
        dp[1] = 2;

        for (int i = 2;i <= n;i++)
            dp[i] = dp[i-1] + dp[i-2];

        return dp[n];
    }
/*
----------------------------------------------Space-Optimized-Bottom-Up-DP-----------------------------------------------
TC : O(n)
SC : O(1)
*/
    static int spaceOptimizedCountStrings(int n) {
        // potd.code.hub
        int cur_2 = 1;
        int cur_1 = 2;
        int cur = 2; // for length 1 answer will be 2

        for (int i = 2;i <= n;i++) {
            cur = cur_1 + cur_2;
            cur_2 = cur_1;
            cur_1 = cur;
        }

        return cur;
    }
/*
--------------------------------------------------Matrix-Exponentiation--------------------------------------------------
TC : O(log n)
SC : O(log n)
*/
    static int countStrings(int n) {
        // potd.code.hub
        int[][] unitMat = {{1, 1}, {1, 0}};
        int[][] power = matPower(unitMat, n+1);
        int[][] ans = matrixMultiplication(power, new int[][]{{1}, {0}});

        return ans[0][0];
    }
    private static int[][] matPower (int[][] mat, int p) {
        // base case
        if (p == 0) {
            int n = mat.length;
            int m = mat[0].length;
            int[][] ans = new int[n][m];
            for (int i = 0;i < n;i++)
                for (int j = 0;j < m;j++)
                    ans[i][j] = (i == j) ? 1 : 0;
            return ans;
        }

        // recursive work
        int[][] subProblem = matPower(mat, p/2);

        // self work
        int[][] ans = matrixMultiplication(subProblem, subProblem);
        if (p % 2 == 1) ans = matrixMultiplication(ans, mat);

        return ans;
    }
    private static int[][] matrixMultiplication (int[][] mat1, int[][] mat2) {
        int r1 = mat1.length;
        int r2 = mat2.length;
        int c1 = mat1[0].length;
        int c2 = mat2[0].length;

        if (c1 != r2) return new int[0][0];

        int[][] ans = new int[r1][c2];

        for (int i = 0;i < r1;i++) {
            for (int j = 0;j < c2;j++) {
                for (int x = 0; x < c1; x++) {
                    ans[i][j] += mat1[i][x] * mat2[x][j];
                }
            }
        }

        return ans;
    }
}
