package Greedy;/*
 *
 * https://leetcode.com/problems/minimum-cost-of-buying-candies-with-discount/
 *
 * # LC 2144. Minimum Cost of Buying Candies With Discount
 *
 *   Q.  A shop is selling candies at a discount. For every two candies sold, the shop gives a third candy for free.
 *
 *      The customer can choose any candy to take away for free as long as the cost of the chosen candy is less than or
 *      equal to the minimum cost of the two candies bought.
 *
 *      For example, if there are 4 candies with costs 1, 2, 3, and 4, and the customer buys candies with costs 2 and 3,
 *      they can take the candy with cost 1 for free, but not the candy with cost 4.
 *
 *      Given a 0-indexed integer array cost, where cost[i] denotes the cost of the ith candy, return the minimum cost of
 *      buying all the candies.
 *
 *    Ex.
 *      Input: cost = [6,5,7,9,2,2]
 *      Output: 23
 *      Explanation: The way in which we can get the minimum cost is described below:
 *              - Buy candies with costs 9 and 7
 *              - Take the candy with cost 6 for free
 *              - We buy candies with costs 5 and 2
 *              - Take the last remaining candy with cost 2 for free
 *              Hence, the minimum cost to buy all candies is 9 + 7 + 5 + 2 = 23.
 *
 *  Constraints:
 *      1 <= cost.length <= 100
 *      1 <= cost[i] <= 100
 */

import java.util.Arrays;
import java.util.Scanner;

public class G13_Minimum_Cost_of_Buying_Candies_With_Discount {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter cost of candies: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] cost = new int[n];
        for (int i = 0; i < n; i++) {
            cost[i] = Integer.parseInt(s[i]);
        }

        System.out.println("Minimum expense to buy all candies: ");
        System.out.println(minimumCost(cost));
    }

    /// Solution
    static int minimumCost(int[] cost) {
        int n = cost.length;
        int minCost = 0;

        Arrays.sort(cost);

        for (int i = n - 1; i >= 0; i -= 3) {
            int prev = (i - 1) < 0 ? 0 : cost[i - 1];
            minCost += cost[i] + prev;
        }

        return minCost;
    }
}
