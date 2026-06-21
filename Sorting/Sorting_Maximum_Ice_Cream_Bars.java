package Sorting;/*
 *
 * https://leetcode.com/problems/maximum-ice-cream-bars/https://leetcode.com/problems/maximum-ice-cream-bars/
 *
 * # LC. 1833. Maximum Ice Cream Bars
 *
 *   Q. It is a sweltering summer day, and a boy wants to buy some ice cream bars. At the store, there are n ice cream
 *      bars. You are given an array costs of length n, where costs[i] is the price of the ith ice cream bar in coins.
 *      The boy initially has coins to spend, and he wants to buy as many ice-cream bars as possible.
 *
 *      Note: The boy can buy the ice cream bars in any order.
 *
 *      Return the maximum number of ice cream bars the boy can buy with coins.
 *
 *      You must solve the problem by counting sort.
 *
 *    Ex.
 *      Input : costs = [1, 3, 2, 4, 1], coins = 7
 *      Output: 4
 *      Explanation: The boy can buy ice cream bars at indices 0,1,2,4 for a total price of 1 + 3 + 2 + 1 = 7.
 *
 *  Constraints:
 *      costs.length == n
 *      1 <= n <= 10⁵
 *      1 <= costs[i] <= 10⁵
 *      1 <= coins <= 10⁸
 */

import java.util.Scanner;

public class Sorting_Maximum_Ice_Cream_Bars {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter costs: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] costs = new int[n];
        for (int i = 0; i < n; i++) {
            costs[i] = Integer.parseInt(s[i]);
        }

        System.out.println("Enter coins I have: ");
        int coins = sc.nextInt();

        System.out.println("Maximum ice-cream we can get: ");
        System.out.println(maxIceCream(costs, coins));
    }

    /// Solution
    static int maxIceCream(int[] costs, int coins) {
        // potd.code.hub
        int n = costs.length;
        int count = 0;
        int maxCost = costs[0];
        int minCost = costs[0];

        for (int i = 1; i < n; i++) {
            maxCost = Math.max(maxCost, costs[i]);
            minCost = Math.min(minCost, costs[i]);
        }

        int len = (maxCost - minCost) + 1;
        int[] freq = new int[len];

        for (int ele : costs) {
            freq[ele - minCost]++;
        }

        for (int i = 0; i < len; i++) {
            int cost = i + minCost;

            if (freq[i] == 0) continue;
            if (cost > coins) break;

            int pick = Math.min(coins / cost, freq[i]);
            coins -= pick * cost;
            count += pick;
        }

        return count;
    }
}
