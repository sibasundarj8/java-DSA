package DP;/*
 *
 * https://leetcode.com/problems/climbing-stairs-ii/
 *
 * # LC. 3693. Climbing Stairs II
 *
 *   Q. You are climbing a staircase with n + 1 steps, numbered from 0 to n. You are also given a 1-indexed integer
 *      array costs of length n, where costs[i] is the cost of step i.
 *
 *      From step i, you can jump only to step i + 1, i + 2, or i + 3. The cost of jumping from step i to step j is
 *      defined as: costs[j] + (j - i)²
 *
 *      You start from step 0 with cost = 0.
 *
 *      Return the minimum total cost to reach step n.
 *
 *    Ex.
 *      Input:  n = 4
 *              costs = [1, 2, 3, 4];
 *      Output: 13
 *      Explanation:
 *              One optimal path is 0 → 1 → 2 → 4
 *           +---------+-------------------------------+------+
 *           |  Jump   |       Cost Calculation        | Cost |
 *           +=========+===============================+======+
 *           |  0 → 1  |  costs[1] + (1 - 0)2 = 1 + 1  |  2   |
 *           +---------+-------------------------------+------+
 *           |  1 → 2  |  costs[2] + (2 - 1)2 = 2 + 1  |  3   |
 *           +---------+-------------------------------+------+
 *           |  2 → 4  |  costs[4] + (4 - 2)2 = 4 + 4  |  8   |
 *           +---------+-------------------------------+------+
 *              Thus, the minimum total cost is 2 + 3 + 8 = 13
 *
 *  Constraints:
 *        ◦ 1 <= n == costs.length <= 10⁵
 *        ◦ 1 <= costs[i] <= 10⁴
 */

import java.util.Arrays;
import java.util.Scanner;

public class Dynamic_Programming_Climbing_Stairs_II {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("n : ");
        int n = sc.nextInt();

        int[] costs = new int[n];

        System.out.print("costs: ");
        for (int i = 0; i < n; i++) {
            costs[i] = sc.nextInt();
        }

        System.out.println("minimum total cost to reach step n: ");
        System.out.println(climbStairs(n, costs));
    }

    /// Solution
/*
-------------------------------------------------------memoization-------------------------------------------------------
TC : O(n)
SC : O(n)
*/
    static int memoization(int n, int[] costs) {
        // potd.coe.hub
        long[] dp = new long[n + 1];
        Arrays.fill(dp, -1);

        long a = 1 + solve(0, n, costs, dp);
        long b = 4 + solve(1, n, costs, dp);
        long c = 9 + solve(2, n, costs, dp);

        return (int) Math.min(a, Math.min(b, c));
    }

    private static long solve(int i, int n, int[] costs, long[] dp) {
        // base case
        if (i >= n - 1) return costs[n - 1];
        if (dp[i] != -1) return dp[i];

        // recursive case
        long n1 = 1 + solve(i + 1, n, costs, dp);
        long n2 = 4 + solve(i + 2, n, costs, dp);
        long n3 = 9 + solve(i + 3, n, costs, dp);

        // self work
        return dp[i] = costs[i] + Math.min(n1, Math.min(n2, n3));
    }

/*
-----------------------------------------------------space-optimized-----------------------------------------------------
TC : O(n)
SC : O(1)
*/
    static int climbStairs(int n, int[] costs) {
        // potd.coe.hub

        long p3 = 0;
        long p2 = 0;
        long p1 = 0;

        for (int i = 0; i < n; i++) {
            long c = costs[i] + Math.min(1 + p1, Math.min(4 + p2, 9 + p3));
            p3 = p2;
            p2 = p1;
            p1 = c;
        }

        return (int) p1;
    }
}
