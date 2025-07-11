package DP;/*
 *
 * https://www.geeksforgeeks.org/problems/trail-of-ones3242/1
 *
 * # Trail of ones
 *
 *   Q. Given an integer n, the task is to count the number of binary strings of length n that contains at least
 *      one pair of consecutive 1's.
 *      Note: A binary string is a sequence made up of only 0's and 1's.
 *   Ex.
 *      Input : n = 3
 *      Output: 3
 *      Explanation: There are 8 strings of length 3, the strings are 000, 001, 010, 011, 100, 101, 110 and 111.
 *                   The strings with consecutive 1's are 011, 110 and 111.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Dynamic_Programming_Trail_of_ones {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Length of Binary String: ");
        int n = sc.nextInt();

        System.out.println("Number of possibilities with consecutive 1's : ");
        System.out.println(countConsec(n));
    }

    /// Solution
/*
--------------------------------------------------Top-Down--Memoization--------------------------------------------------
TC : O(n)
SC : O(n)
*/
    static int memoCountConsec(int n) {
        // potd.code.hub
        int total = 1 << n;
        int[] dp = new int[n+1];

        Arrays.fill(dp, -1);

        int withoutCons = withoutCons1 (n, dp);

        return total - withoutCons;
    }
    private static int withoutCons1 (int i, int[]dp) {
        // base case
        if (i == 0 || i == 1) return i + 1;
        if (dp[i] != -1) return dp[i];

        // recursive work
        int ans = 0;
        ans += withoutCons1(i-2, dp);
        ans += withoutCons1(i-1, dp);

        return dp[i] = ans;
    }
/*
--------------------------------------------------Bottom-Up--Tabulation--------------------------------------------------
TC : O(n)
SC : O(n)
*/
    static int tabCountConsec(int n) {
        // potd.code.hub
        int total = 1 << n;
        int[] dp = new int[n+1];

        dp[0] = 1;
        dp[1] = 2;

        for (int i = 2;i <= n;i++)
            dp[i] = dp[i-1] + dp[i-2];

        return total - dp[n];
    }
/*
------------------------------------------------Bottom-Up--Space-Optimized-----------------------------------------------
TC : O(n)
SC : O(1)
*/
    static int spaceOptimizedCountConsec(int n) {
        // potd.code.hub
        int total = 1 << n;

        int cur_2 = 1;
        int cur_1 = 2;
        int cur = 0;

        for (int i = 2;i <= n;i++) {
            cur = cur_1 + cur_2;
            cur_2 = cur_1;
            cur_1 = cur;
        }

        return total - cur;
    }
/*
--------------------------------------------------Matrix-Exponentiation--------------------------------------------------
TC : O(log n)
SC : O(log n)
*/
    static int countConsec(int n) {
        // potd.code.hub
        int total = 1 << n;
        int noConsecutive1 = noCons1(n);

        return total - noConsecutive1;
    }
    private static int noCons1(int n) {
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
