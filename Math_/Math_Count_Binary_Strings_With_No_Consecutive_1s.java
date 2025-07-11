package Math_;/*
 *
 * https://www.geeksforgeeks.org/problems/count-binary-strings-with-no-consecutive-1s/1
 *
 * # Count Binary Strings With No Consecutive 1s
 *
 *   Q. Given an integer N. Your task is to find the number of binary strings of length N having no consecutive
 *      1s.
 *      As the number can be large, return the answer modulo 10^9+7.
 *    Ex.
 *      Input : N = 3
 *      Output: 5
 *      Explanation: All the binary strings of length 3 having no consecutive 1s are "000", "001", "101", "100"
 *                   and "010".
 */

import java.util.Scanner;

public class Math_Count_Binary_Strings_With_No_Consecutive_1s {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter length of binary number: ");
        long n = sc.nextLong();

        System.out.println("Number of possibilities without any consecutive 1 : ");
        System.out.println(countStrings(n));
    }

    /// Solution
    static final int mod = (int) 1e9 + 7;

    static int countStrings(long n) {
        // potd.code.hub
        long[][] unitMat = {{1, 1}, {1, 0}};
        long[][] power = matPower(unitMat, n + 1);
        long[][] ans = matrixMultiplication(power, new long[][]{{1}, {0}});

        return (int) ans[0][0];
    }

    private static long[][] matPower(long[][] mat, long p) {
        // base case
        if (p == 0) {
            int n = mat.length;
            int m = mat[0].length;
            long[][] ans = new long[n][m];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    ans[i][j] = (i == j) ? 1 : 0;
            return ans;
        }

        // recursive work
        long[][] subProblem = matPower(mat, p / 2);

        // self work
        long[][] ans = matrixMultiplication(subProblem, subProblem);
        if (p % 2 == 1) ans = matrixMultiplication(ans, mat);

        return ans;
    }

    private static long[][] matrixMultiplication(long[][] mat1, long[][] mat2) {
        int r1 = mat1.length;
        int r2 = mat2.length;
        int c1 = mat1[0].length;
        int c2 = mat2[0].length;

        if (c1 != r2) return new long[0][0];

        long[][] ans = new long[r1][c2];

        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int x = 0; x < c1; x++) {
                    ans[i][j] += (mat1[i][x] * mat2[x][j]) % mod;
                    ans[i][j] %= mod;
                }
            }
        }

        return ans;
    }
}
