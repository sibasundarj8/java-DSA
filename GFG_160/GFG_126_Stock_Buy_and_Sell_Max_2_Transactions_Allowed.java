package GFG_160;/*
 * 
 * https://www.geeksforgeeks.org/problems/buy-and-sell-a-share-at-most-twice/0
 * 
 * # Stock Buy and Sell – Max 2 Transactions Allowed
 * 
 *   Q. In daily share trading, a trader buys shares and sells them on the same day. If the trader 
 *      is allowed to make at most 2 transactions in a day, find out the maximum profit that a share 
 *      trader could have made.
 * 
 *      You are given an array of prices[] representing stock prices throughout the day. Note that 
 *      the second transaction can only start after the first one is complete (buy->sell->buy->sell).
 *   Ex.
 *      Input: prices[] = [10, 22, 5, 75, 65, 80]
 *      Output: 87
 *      Explanation: 
 *             Trader will buy at 10 and sell at 22. 
 *             Profit earned in the 1st transaction = 22-10 = 12. 
 *             Then he buys at 5 and sells at 80. 
 *             Profit earned in the 2nd transaction = 80-5 = 75. 
 *             Total profit earned = 12 + 75 = 87. 
 */
import java.util.Scanner;

public class GFG_126_Stock_Buy_and_Sell_Max_2_Transactions_Allowed {
    
    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Number of days: ");
        int n = sc.nextInt();

        int[]arr = new int[n];

        System.out.println("Stock price on ith day: ");
        for (int i = 0;i < n;i++)
            arr[i] = sc.nextInt();

        System.out.println("max profit: " + maxProfit(arr));
    }
    
    /// Solution
    static int maxProfit(int[] prices) {
        // potd.code.hub
        int n = prices.length;
        int[][]dp = new int[5][n];
        for (int i = 0;i <= 4;i++)
            for (int j = 0;j < n;j++)
                dp[i][j] = -1;

        return fun(0, prices, n, dp, 4, 0);
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
