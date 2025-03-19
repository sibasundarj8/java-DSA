package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/maximum-profit4657/1
 *
 * # Stock Buy and Sell – Max K Transactions Allowed
 *
 *   Q. In the stock market, a person buys a stock and sells it at some future date. You are given
 *      an array prices[] representing stock prices on different days and a positive integer k,
 *      find out the maximum profit a person can make in at-most k transactions.
 *
 *      A transaction consists of buying and subsequently selling a stock, and new transaction can
 *      start only when the previous transaction has been completed.
 *   Ex.
 *      Input : prices[] = [20, 580, 420, 900]
 *              k = 3
 *      Output: 1040
 *      Explanation:
 *            1st transaction: Buy at 20 and sell at 580.
 *            2nd transaction: Buy at 420 and sell at 900.
 *            Total Profit will be 560 + 480 = 1040.
 */
import java.util.Scanner;

public class GFG_125_Stock_Buy_and_Sell_Max_K_Transactions_Allowed {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Number of days: ");
        int n = sc.nextInt();

        int[]arr = new int[n];

        System.out.println("Stock price on ith day: ");
        for (int i = 0;i < n;i++)
            arr[i] = sc.nextInt();

        System.out.println("Number of Buy allowed: ");
        int k = sc.nextInt();

        System.out.println("max profit: " + maxProfit(arr, k));
    }

    /// Solution
    static int maxProfit(int[] prices, int k) {
        // potd.code.hub
        int n = prices.length;
        int[][]dp = new int[2*k+1][n];
        for (int i = 0;i <= 2*k;i++)
            for (int j = 0;j < n;j++)
                dp[i][j] = -1;

        return fun(0, prices, n, dp, 2*k, 0);
    }
    private static int fun(int idx, int[]arr, int n, int[][]dp, int k, int tranNo){
        // base case
        if (idx == n || k == tranNo) return 0;
        if (dp[tranNo][idx] != -1) return dp[tranNo][idx];

        int profit;
        if (tranNo % 2 == 0)
            profit = Math.max(-arr[idx]+fun(idx+1, arr, n, dp, k, tranNo+1),
                                            fun(idx+1, arr, n, dp, k, tranNo));
        else
            profit = Math.max(arr[idx]+fun(idx+1, arr, n, dp, k, tranNo+1),
                    fun(idx+1, arr, n, dp, k, tranNo));

        dp[tranNo][idx] = profit;
        return profit;
    }
}
