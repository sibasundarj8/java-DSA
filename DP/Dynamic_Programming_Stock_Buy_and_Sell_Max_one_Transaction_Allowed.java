package DP;/*
 *
 * https://www.geeksforgeeks.org/problems/buy-stock-2/1
 *
 * # Stock Buy and Sell – Max one Transaction Allowed
 *
 *   Q. Given an array prices[] of length n, representing the prices of the stocks on different days.
 *      The task is to find the maximum profit possible by buying and selling the stocks on different
 *      days when at most, one transaction is allowed. Here one transaction means 1 buy + 1 Sell. If
 *      it is impossible to make a profit, then return 0.
 *
 *      Note: Stock must be bought before being sold.
 *   Ex.
 *      Input : prices[] = [7, 10, 1, 3, 6, 9, 2]
 *      Output: 8
 *      Explanation: You can buy the stock on day 2 at price = 1 and sell it on day 5 at price = 9.
 *                   Hence, the profit is 8.
 */
import java.util.Scanner;

public class Dynamic_Programming_Stock_Buy_and_Sell_Max_one_Transaction_Allowed {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Number of days: ");
        int n = sc.nextInt();

        int[]arr = new int[n];

        System.out.println("Stock price on ith day: ");
        for (int i = 0;i < n;i++)
            arr[i] = sc.nextInt();

        System.out.println("max profit: " + maximumProfit(arr));
    }

    /// Solution
    static int maximumProfit(int[] prices) {
        // potd.code.hub
        int n = prices.length;
        int ans = 0, min = prices[0];

        for (int i = 1;i < n;i++){
            ans = Math.max(ans, prices[i] - min);
            min = Math.min(min, prices[i]);
        }

        return ans;
    }
}
