package DP;/*
 *
 * https://www.geeksforgeeks.org/problems/geek-jump/1
 *
 * # Frog Jump
 *
 *   Q. Given an integer array height[] where height[i] represents the height of the i-th stair, a frog starts from the
 *      first stair and wants to reach the last stair. From any stair i, the frog has two options: it can either jump
 *      to the (i+1)th stair or the (i+2)th stair. The cost of a jump is the absolute difference in height between the
 *      two stairs. Determine the minimum total cost required for the frog to reach the last stair.
 *   Ex.
 *      Input: heights[] = [30, 20, 50, 10, 40]
 *      Output: 30
 *      Explanation: Minimum cost will be incurred when frog jumps from stair 0 to 2 then 2 to 4:
 *                   jump from stair 0 to 2: cost = |50 - 30| = 20
 *                   jump from stair 2 to 4: cost = |40 - 50| = 10
 *                   Total Cost = 20 + 10 = 30
 *
 *  Constraints:
 *          1 ≤ height.size() ≤ 10⁵
 *          0 ≤ height[i] ≤ 10⁴
 */

import java.util.Arrays;
import java.util.Scanner;

public class Dynamic_Programming_Frog_Jump {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Array Elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

        System.out.println("Min cost to reach last: " + minCost(arr));
    }

    /// Solution
/*⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯Memoization⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯*/
    static int memoization(int[] height) {
        int n = height.length;
      
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
      
        return fun(0, n, height, dp);
    }

    private static int fun(int i, int n, int[] arr, int[] dp) {
        // base case
        if(i >= n - 1) return 0;
        if(dp[i] != -1) return dp[i];

        // recursive work
        int a = fun(i + 1, n, arr, dp) + Math.abs(arr[i] - arr[i + 1]);
        int b = (i < n - 2) ? fun(i + 2, n, arr, dp) + Math.abs(arr[i] - arr[i + 2]) : Integer.MAX_VALUE;

        // self work
        return dp[i] = Math.min(a, b);
    }

/*⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯Tabulation⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯*/
    static int tabulation(int[] heights) {
        int n = heights.length;

        if (n == 1) return 0;

        int[] dp = new int[n]; // extra dp array to track path cost
        dp[n - 2] = Math.abs(heights[n - 1] - heights[n - 2]);

        for (int i = n - 3; i >= 0; i--) {
            int i1 = dp[i + 1] + Math.abs(heights[i] - heights[i + 1]);
            int i2 = dp[i + 2] + Math.abs(heights[i] - heights[i + 2]);
            dp[i] = Math.min(i1, i2);
        }

        return dp[0];
    }

/*⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯Space-Optimization⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯*/
    static int minCost(int[] heights) {
        int n = heights.length;

        if (n == 1) return 0;

        int prev1 = Math.abs(heights[n - 1] - heights[n - 2]);
        int prev2 = 0; // taking two variables to track path cost instead of extra array. (O(n) -~> O(1))

        for (int i = n - 3; i >= 0; i--) {
            int i1 = prev1 + Math.abs(heights[i] - heights[i + 1]);
            int i2 = prev2 + Math.abs(heights[i] - heights[i + 2]);
            prev2 = prev1;
            prev1 = Math.min(i1, i2);
        }

        return prev1;
    }
}
