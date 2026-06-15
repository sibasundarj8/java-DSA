package DP;/*
 *
 * https://www.geeksforgeeks.org/problems/minimum-cost-to-fill-given-weight-in-a-bag1956/1
 *
 * # Minimum Cost to Fill Given Weight
 *
 *   Q. Given a bag of size w kg, and you are provided costs of packets different weights of oranges in array cost[], find
 *      the minimum total cost to buy exactly w kg oranges
 *
 *        ◦ The cost of 1 kg orange is present at index 0 and in general arr[i] has cost of (i+1) kg orange.
 *        ◦ cost[i] = -1 means that 'i+1' kg packet of orange is unavailable.
 *        ◦ If it is not possible to buy exactly w kg oranges then return -1. It may be assumed that there is an infinite
 *          supply of all available packet types.
 *
 *    Ex.
 *      Input : cost[] = [20, 10, 4, 50, 100], w = 5
 *      Output: 14
 *      Explanation: The minimum cost is 14 by purchasing a 2kg packet for 10 and a 3kg packet for 4.
 *
 *  Constraints:
 *      1 ≤ cost.size(), w ≤ 2 * 10³
 *      1 ≤ cost[i] ≤ 10⁵
 */

import java.util.Arrays;
import java.util.Scanner;

public class Dynamic_Programming_Minimum_Cost_to_Fill_Given_Weight {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter cost of oranges: (index + 1 is the weight)");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] cost = new int[n];
        for (int i = 0; i < n; i++) {
            cost[i] = Integer.parseInt(s[i]);
        }

        System.out.println("Weight of oranges you need: ");
        int w = sc.nextInt();

        System.out.println("Minimum cost: ");
        System.out.println(minimumCost(cost, w));
    }

    /// Solution
/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯-Memoization-⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(n * w)
SC : O(w) + recursive call stack
*/
    static int memoization(int[] cost, int w) {
        // potd.code.hub
        int[] dp = new int[w + 1];
        Arrays.fill(dp, -1);

        int res = solve(w, cost, dp);
        return (res == Integer.MAX_VALUE) ? -1 : res;
    }

    private static int solve(int w, int[] cost, int[] dp) {
        // base case
        if (w == 0) return 0;
        if (dp[w] != -1) return dp[w];

        // recursive work
        int ub = Math.min(cost.length, w);
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < ub; i++) {
            if (cost[i] != -1) {
                int pick = solve(w - (i + 1), cost, dp);
                if (pick == Integer.MAX_VALUE) continue;
                min = Math.min(min, pick + cost[i]);
            }
        }

        return dp[w] = min;
    }

/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯--tabulation--⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : (n * w)
SC : (w)
*/
    static int minimumCost(int[] cost, int wg) {
        // potd.code.hub
        int[] dp = new int[wg + 1];

        for (int w = 1; w <= wg; w++) {
            int ub = Math.min(cost.length, w);
            int min = Integer.MAX_VALUE;

            for (int i = 0; i < ub; i++) {
                if (cost[i] != -1) {
                    int pick = dp[w - (i + 1)];
                    if (pick == Integer.MAX_VALUE) continue;
                    min = Math.min(min, pick + cost[i]);
                }
            }

            dp[w] = min;
        }

        return (dp[wg] == Integer.MAX_VALUE) ? -1 : dp[wg];
    }
}
