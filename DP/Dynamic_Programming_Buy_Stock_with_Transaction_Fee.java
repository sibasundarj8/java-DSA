package DP;/*
 *
 * https://www.geeksforgeeks.org/problems/buy-stock-with-transaction-fee/1
 *
 * # Buy Stock with Transaction Fee
 *
 *   Q. You are given an array arr[], in which arr[i] is the price of a given stock on the ith day and an integer k represents
 *      a transaction fee. Find the maximum profit you can achieve. You may complete as many transactions as you like, but you
 *      need to pay the transaction fee for each transaction.
 *
 *      Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 *    Ex.
 *      Input : arr[] = [6, 1, 7, 2, 8, 4], k = 2
 *      Output: 8
 *      Explanation:
 *              Buy the stock on day 2 and sell it on day 3 => 7 – 1 -2 = 4
 *              Buy the stock on day 4 and sell it on day 5 => 8 – 2 - 2 = 4
 *              Maximum Profit  = 4 + 4 = 8
 *
 *  Constraint:
 *          1 ≤ arr.size() ≤ 10⁶
 *          1 ≤ arr[i] ≤ 10⁶
 *          0 ≤ k ≤ 10⁶
 */

import java.util.Scanner;

public class Dynamic_Programming_Buy_Stock_with_Transaction_Fee {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter prices: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.println("Enter the transaction fee: ");
        int k = sc.nextInt();

        System.out.println("Maximum profit: ");
        System.out.println(maxProfit(arr, k));
    }

    /// Solution
/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯(Memoization)⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(n * 2)  ≈ O(n)
SC : O(n * 2) + O(n recursion stack) ≈ O(n)
*/
    static int memoization(int[] arr, int k) {
        // potd.code.hub
        int n = arr.length;
        int[][] dp = new int[n][2];

        for (int i = 0; i < n; i++) {
            dp[i][0] = dp[i][1] = -1;
        }

        return f(0, 0, k, arr.length, arr, dp);
    }

    private static int f(int idx, int bought, int k, int n, int[] arr, int[][] dp) {
        // base case
        if (idx >= n) return 0;
        if (dp[idx][bought] != -1) return dp[idx][bought];

        // recursive case
        int profit;
        if (bought == 1) {
            int sell = arr[idx] - k + f(idx + 1, 0, k, n, arr, dp);
            int notSell = f(idx + 1, 1, k, n, arr, dp);
            profit = Math.max(sell, notSell);
        } else {
            int buy = -arr[idx] + f(idx + 1, 1, k, n, arr, dp);
            int notBuy = f(idx + 1, 0, k, n, arr, dp);
            profit = Math.max(buy, notBuy);
        }

        return dp[idx][bought] = profit;
    }

/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯(Tabulation)⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(n * 2) ≈ O(n)
SC : O(n * 2) ≈ O(n)
*/
    static int tabulation(int[] arr, int k) {
        int n = arr.length;
        int[][] dp = new int[n + 1][2];

        // no need to add base case because that is already zero.

        for (int idx = n - 1; idx >= 0; idx--) {
            dp[idx][0] = Math.max(-arr[idx] + dp[idx + 1][1], dp[idx + 1][0]);
            dp[idx][1] = Math.max(arr[idx] - k + dp[idx + 1][0], dp[idx + 1][1]);
        }

        return dp[0][0];
    }

/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯(Space-Optimized)⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(n)
SC : O(1)
*/
    static int maxProfit(int[] arr, int k) {
        int n = arr.length;
        int[] next = new int[2];
        int[] curr = new int[2];

        // no need to add base case because that is already zero.

        for (int idx = n - 1; idx >= 0; idx--) {
            curr[0] = Math.max(-arr[idx] + next[1], next[0]);
            curr[1] = Math.max(arr[idx] - k + next[0], next[1]);

            next[0] = curr[0];
            next[1] = curr[1];
        }

        return next[0];
    }
}
