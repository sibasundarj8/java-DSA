package DP;/*
 *
 * https://www.geeksforgeeks.org/problems/maximum-sum-problem2211/1
 *
 * # Maximum Sum Problem
 *
 *   Q. Given a number n, find its maximum sum value with 3 recursive breaks described below.
 *
 *        ◦ Break into three parts n/2, n/3, and n/4 (consider only the integer part or floor value).
 *        ◦ Each number obtained in this process can be divided further recursively.
 *        ◦ At every step,  we can take the max of current value of n or the max value obtained with recursive process.
 *        ◦ It is possible that we don't divide the number at all and choose it as final answer.
 *
 *    Ex.
 *      Input : n = 24
 *      Output: 27
 *      Explanation: Break n = 24 in three parts [24/2, 24/3, 24/4] = [12, 8, 6], now current sum is = (12 + 8 + 6) = 26.
 *                   But recursively breaking 12 would produce value 13. So our maximum sum is 13 + 8 + 6 = 27.
 *
 *  Constraints:
 *          0  ≤ n  ≤ 10⁶
 */

import java.util.Arrays;
import java.util.Scanner;

public class Dynamic_Programming_Maximum_Sum_Problem {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("n : ");
        int n = sc.nextInt();

        System.out.println("maximum sum value according to given condition: ");
        System.out.println(maxSum(n));
    }

    /// Solution
/*
☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒-brute-force-☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒
TC : O(n¹˙⁰⁸)
SC : O(log n) --> recursive stack space
*/
    static int bruteForce(int n) {
        // base case
        int a = n/2;
        int b = n/3;
        int c = n/4;

        if (a + b + c <= n) return n;

        // recursive work
        return bruteForce(a) + bruteForce(b) + bruteForce(c);
    }

/*
☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑-memoization-☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑
TC : O(n)
SC : O(n) + (log n) --> recursive stack space
*/
    static int memoization(int n) {
        // potd.code.hub
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return solve(n, dp);
    }

    private static int solve(int n, int[] dp) {
        // base case
        int a = n/2;
        int b = n/3;
        int c = n/4;

        if (dp[n] != -1) return dp[n];
        if (a + b + c <= n) return n;

        // recursive work
        return dp[n] = solve(a, dp) + solve(b, dp) + solve(c, dp);
    }

/*
☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑-tabulation-☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑
TC : O(n)
SC : O(n)
*/
    static int maxSum(int n) {
        // potd.code.hub
        int[] dp = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            dp[i] = Math.max(i, dp[i / 2] + dp[i / 3] + dp[i / 4]);
        }

        return dp[n];
    }
}
