package DP;/*
 *
 * https://www.geeksforgeeks.org/problems/buy-stock-with-cooldown/1
 *
 * # Stock Buy and Sell with Cooldown
 *
 *   Q. Given an array arr[], where the ith element of arr[] represents the price of a stock on the ith day (all prices
 *      are non-negative integers). Find the maximum profit you can make by buying and selling stocks such that after
 *      selling a stock, you cannot buy again on the next day (i.e., there is a one-day cooldown).
 *
 *    Ex.
 *      Input :  arr[] = [3, 1, 6, 1, 2, 4]
 *      Output: 7
 *      Explanation: You first buy on day 2 and sell on day 3 then cool down, then again you buy on day 5 and then sell
 *                   on day 6. Clearly, the total profit earned is (6-1) + (4-2) = 7, which is the maximum achievable
 *                   profit.
 *
 *  Constraint:
 *      1 ≤ arr.size() ≤ 10⁵
 *      1 ≤ arr[i] ≤ 10⁴
 */

import java.util.Scanner;

public class Dynamic_Programming_Stock_Buy_and_Sell_with_Cooldown {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter stock prices: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

        System.out.println("Max profit: " + maxProfit(arr));
    }

    /// Solution
/*
〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄~Memoization~〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄
TC : O(n)
SC : O(n) + recursive call stack
*/
    static int memoization(int[] arr) {
        // potd.code.hub
        int n = arr.length;
        int[][] dp = new int[n][2];

        for (int i = 0; i < n; i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }

        return f(0, n, arr, 0, dp);
    }

    // helper method
    private static int f(int i, int n, int[] arr, int bought, int[][] dp) {
        // base case
        if (i >= n) return 0;
        if (dp[i][bought] != -1) return dp[i][bought];

        // recursive work
        int profit = 0;

        if (bought == 0) {  // If I don't have any stock then I have two options Buy or Not-buy
            int buy = -arr[i] + f(i + 1, n, arr, 1, dp);
            int notBuy = f(i + 1, n, arr, 0, dp);

            profit = Math.max(buy, notBuy);

        } else {    // If I already bought then I have to choose option between Sell or Not-sell.
            int sell = arr[i] + f(i + 2, n, arr, 0, dp);
            int notSell = f(i + 1, n, arr, 1, dp);

            profit = Math.max(sell,notSell);
        }

        return dp[i][bought] = profit;
    }

/*
〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄~Tabulation~〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄
TC : O(n)
SC : O(n)
*/
    static int tabulation(int[] arr) {
        // potd.code.hub
        int n = arr.length;
        int[][] dp = new int[n + 2][2];

        for (int idx = n - 1; idx >= 0; idx--) {

            // If I don't have any stock then I have two options Buy or Not-buy
            dp[idx][0] = Math.max(-arr[idx] + dp[idx + 1][1], dp[idx + 1][0]);

            // If I already bought then I have to choose option between Sell or Not-sell.
            dp[idx][1] = Math.max(arr[idx] + dp[idx + 2][0],dp[idx + 1][1]);
        }

        return dp[0][0];
    }

/*
〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄~Space-Optimized~〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄〄
TC : O(n)
SC : O(1)
*/
    static int maxProfit(int[] arr) {
        // potd.code.hub
        int n = arr.length;
        int[] dp = new int[2];
        int[] dp1 = new int[2];
        int[] dp2 = new int[2];

        for (int idx = n - 1; idx >= 0; idx--) {

            // If I don't have any stock then I have two options Buy or Not-buy
            dp[0] = Math.max(-arr[idx] + dp1[1], dp1[0]);

            // If I already bought then I have to choose option between Sell or Not-sell.
            dp[1] = Math.max(arr[idx] + dp2[0],dp1[1]);

            dp2 = dp1.clone();
            dp1 = dp.clone();
        }

        return dp[0];
    }
}
