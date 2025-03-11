package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/min-cost-climbing-stairs/1
 *
 * # Min Cost Climbing Stairs 
 *
 *   Q. Given an array of integer's cost[] where cost[i] is the cost of the ith step on a staircase.
 *      Once the cost is paid, you can either climb one or two steps. Return the minimum cost to
 *      reach the top of the floor.
 *
 *      Assume 0-based Indexing. You can either start from the step with index 0, or the step with
 *      index 1.
 *   Ex.
 *      Input : cost[] = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 *      Output: 6
 *      Explanation: Cheapest option is to start on cost[0], and only step on 1's, skipping cost[3].
 *                   ans = arr[0] + arr[2] + arr[4] + arr[6] + arr[7] + arr[9] = 6
 */
import java.util.Arrays;
import java.util.Scanner;

public class GFG_118_Min_Cost_Climbing_Stairs {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Elements: ");
        for (int i = 0;i < n;i++)
            arr[i] = sc.nextInt();

        System.out.println(minCostClimbingStairs(arr));
    }

    /// Solution
    static int minCostClimbingStairs(int[] cost) {
        // potd.code.hub
        int n = cost.length;
        int[] dp = new int[n];
        return Math.min(fun(cost, dp, 0), fun(cost, dp, 1));
    }
    private static int fun(int[]cost, int[]dp, int i){
        if (i >= cost.length) return 0;
        if (dp[i] != 0) return dp[i];

        int prev1 = cost[i] + fun(cost, dp, i+1);
        int prev2 = cost[i] + fun(cost, dp, i+2);
        dp[i] = Math.min(prev1, prev2);

        return dp[i];
    }
}
