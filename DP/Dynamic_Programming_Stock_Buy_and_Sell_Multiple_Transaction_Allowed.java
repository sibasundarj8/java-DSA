package DP;/*
 * https://www.geeksforgeeks.org/problems/stock-buy-and-sell2615/1
 *
 * # Stock Buy and Sell – Multiple Transaction Allowed
 *
 *   Q. The cost of stock on each day is given in an array price[]. Each day you may decide to either
 *      buy or sell the stock at price[i], you can even buy and sell the stock on the same day. Find
 *      the maximum profit that you can get.
 *
 *      Note: A stock can only be sold if it has been bought previously and multiple stocks cannot be
 *            held on any given day.
 *    Ex.
 *      Input: prices[] = [100, 180, 260, 310, 40, 535, 695]
 *      Output: 865
 *      Explanation: Buy the stock on day 0 and sell it on day 3 => 310 – 100 = 210. Buy the stock on
 *                   day 4 and sell it on day 6 => 695 – 40 = 655. Maximum Profit = 210 + 655 = 865.
 */
import java.util.Scanner;

public class Dynamic_Programming_Stock_Buy_and_Sell_Multiple_Transaction_Allowed {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int[]arr = new int[n];

        System.out.println("Elements: ");
        for (int i = 0;i < n;i++){
            arr[i] = sc.nextInt();
        }

        System.out.println("Maximum profit: ");
        System.out.println(maximumProfit(arr));
    }

    /// Solution
    static int maximumProfit(int[]prices) {
        // potd.code.hub
        int n = prices.length;
        if (n == 1)return 0;
        int profit = 0;

        for (int i = 1;i < n;i++)
            if (prices[i-1] < prices[i])
                profit += (prices[i] - prices[i-1]);
        
        return profit;
    }

/// Recursion and memoization.
/// TC:O(N*2) SC:O(N*2)+O(N)
    /*static int maximumProfit(int[]prices) {
        // potd.code.hub
        int n = prices.length;
        int[][]dp = new int[2][n];
        for (int i = 0;i < n;i++)
            dp[0][i] = dp[1][i] = -1;

        return fun(0, 0, prices, n, dp);
    }
    private static int fun(int buy, int idx, int[]arr, int n, int[][]dp){
        // base case
        if (idx == n) return 0;
        if (dp[buy][idx] != -1) return dp[buy][idx];

        int profit;
        if (buy == 0)
            profit = Math.max(-arr[idx] + fun(1, idx+1, arr, n, dp),
                                          fun(0, idx+1, arr, n, dp));
        else
            profit = Math.max(arr[idx] + fun(0, idx+1, arr, n, dp),
                                         fun(1, idx+1, arr, n, dp));
                                       
        dp[buy][idx] = profit;
        return dp[buy][idx];
    }*/
}
