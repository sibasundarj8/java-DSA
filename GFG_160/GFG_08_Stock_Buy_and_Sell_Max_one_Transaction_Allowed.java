package GFG_160;/*
 * https://www.geeksforgeeks.org/problems/buy-stock-2/1
 *
 * # Stock Buy and Sell – Max one Transaction Allowed
 *
 *   Q. Given an array prices[] of length n, representing the prices of the stocks on different days.
 *      The task is to find the maximum profit possible by buying and selling the stocks on different
 *      days when at most one transaction is allowed. Here one transaction means 1 buy + 1 Sell. If it
 *      is not possible to make a profit then return 0.
 *
 *      Note: Stock must be bought before being sold.
 *    Ex.
 *      Input : prices[] = [7, 10, 1, 3, 6, 9, 2]
 *      Output: 8
 *      Explanation: You can buy the stock on day 2 at price = 1 and sell it on day 5 at price = 9.
 *                   Hence, the profit is 8.
 */
import java.util.Scanner;

public class GFG_08_Stock_Buy_and_Sell_Max_one_Transaction_Allowed {

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

        System.out.println(maximumProfit(arr));
    }

    /// Solution
    static int maximumProfit(int[]prices) {
        // potd.code.hub
        int profit = 0;
        int min = Integer.MAX_VALUE;

        for (int i : prices){
            min = Math.min(min, i);
            profit = Math.max(profit, (i-min));
        }

        return profit;
    }
}
