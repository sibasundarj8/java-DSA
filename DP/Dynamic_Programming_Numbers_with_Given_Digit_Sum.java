package DP;/*
 *
 * https://www.geeksforgeeks.org/problems/count-of-n-digit-numbers-whose-sum-of-digits-equals-to-given-sum0733/1
 *
 * # Numbers with Given Digit Sum
 *
 *   Q. Given two integers n and sum, determine the number of n-digit positive integers whose digits add up to sum.
 *
 *        ◦ An n-digit number cannot have leading zeros; that is, the first digit must be between 1 and 9.
 *        ◦ If there exist no n digit number with sum of digits equal to given sum, return -1.
 *
 *    Ex.
 *      Input : n = 2, sum = 10
 *      Output: 9
 *      Explanation: The 2-digit numbers whose digits add up to 10 are: 19, 28, 37, 46, 55, 64, 73, 82, 91.
 *
 *  Constraints:
 *         1 ≤ n ≤ 9
 *         1 ≤ sum ≤ 81
 */

import java.util.Scanner;

public class Dynamic_Programming_Numbers_with_Given_Digit_Sum {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("n : ");
        int n = sc.nextInt();
        if (n < 1 || n > 9) throw new IllegalArgumentException("Invalid input");

        System.out.print("sum : ");
        int sum = sc.nextInt();
        if (sum < 1 || sum > 81) throw new IllegalArgumentException("Invalid input");

        System.out.println("Number of " + n + "-digit positive integers whose digits add up to sum");
        System.out.println(countWays(n, sum));
    }

    /// Solution
    static int countWays(int n, int sum) {
        // potd.code.hub
        if (9 * n < sum) return -1;
        int[][][] dp = new int[n + 1][sum + 1][2];

        for (int[][] a : dp) {
            for (int[] b : a) {
                b[0] = b[1] = -1;
            }
        }

        return solve(n, sum, 1, dp);
    }

    private static int solve(int n, int sum, int startFrom, int[][][] dp) {
        // base case
        if (n == 0) return (sum == 0) ? 1 : 0;
        if (sum == 0) return 1;
        if (dp[n][sum][startFrom] != -1) return dp[n][sum][startFrom];

        // recursive work
        int count = 0;
        for (int i = startFrom; i <= 9; i++) {
            if (i <= sum) {
                count += solve(n - 1, sum - i, 0, dp);
            }
        }

        return dp[n][sum][startFrom] = count;
    }
}
