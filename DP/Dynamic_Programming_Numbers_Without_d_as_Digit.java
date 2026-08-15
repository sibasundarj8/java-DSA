package DP;/*
 *
 * https://www.geeksforgeeks.org/problems/count-numbers2004/1
 *
 * # Numbers Without d as Digit
 *
 *   Q. Given a number n, count the numbers from 1 to n that don’t contain digit d in their decimal representation.
 *
 *    Ex.
 *      Input : n = 25, d = 3
 *      Output: 22
 *      Explanation: From 1 to 25, the numbers 3, 13, and 23 contain the digit 3, so the answer is 25 - 3 = 22.
 *
 *  Constraints:
 *        ◦ 0 ≤ n ≤ 10⁹
 *        ◦ 0 ≤ d ≤ 9
 */

import java.util.Scanner;

public class Dynamic_Programming_Numbers_Without_d_as_Digit {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("n: ");
        int n = sc.nextInt();

        System.out.print("d: ");
        int d = sc.nextInt();

        if (d < 0 || d >= 10) throw new IllegalArgumentException("d must be between 0 and 9");

        System.out.println("Count the numbers from 1 to n that don’t contain digit d: ");
        System.out.println(countWithout(n, d));
    }

    /// Solution
    static int countWithout(int n, int d) {
        // potd.code.hub
        int len = 0;
        for (int i = n; i > 0; i /= 10) len++;

        int[][][] dp = new int[len + 1][2][2];

        for (int[][] mat : dp) {
            mat[0][0] = mat[0][1] = mat[1][0] = mat[1][1] = -1;
        }

        return solve(0, 1, 1, d, len, String.valueOf(n), dp);
    }

    private static int solve(int i, int tight, int leadingZero, int d, int len, String num, int[][][] dp) {
        // base case
        if (i == len) return (leadingZero == 1) ? 0 : 1;
        if (dp[i][tight][leadingZero] != -1) return dp[i][tight][leadingZero];

        // recursive work
        int count = 0;
        int limit = (tight == 1) ? num.charAt(i) - '0' : 9;

        for (int j = 0; j <= limit; j++) {

            // don't add d and handle the spacial case of 0.
            if (j == d) {
                if (d != 0) continue;
                else if (leadingZero == 0) continue;
            }

            int newTight = (tight == 1 && j == num.charAt(i) - '0') ? 1 : 0;
            int newLeadingZero = (leadingZero == 1 && j == 0) ? 1 : 0;

            count += solve(i + 1, newTight, newLeadingZero, d, len, num, dp);
        }

        return dp[i][tight][leadingZero] = count;
    }
}
