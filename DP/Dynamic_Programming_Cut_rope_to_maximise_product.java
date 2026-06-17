package DP;/*
 *
 * https://www.geeksforgeeks.org/problems/max-rope-cutting1312/1
 *
 * # Cut rope to maximize product
 *
 *   Q. Given a rope of length n meters, cut it into multiple smaller ropes such that the product of their lengths is
 *      maximized. At least one cut is mandatory.
 *
 *    Ex.
 *      Input : n = 5
 *      Output: 6
 *      Explanation: Maximum obtainable product is 2 * 3 = 6.
 *
 *  Constraints:
 *      2 ≤ n ≤ 58
 */

import java.util.Arrays;
import java.util.Scanner;

public class Dynamic_Programming_Cut_rope_to_maximise_product {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter rope length: ");
        int n = sc.nextInt();

        System.out.println("Max possible cost after cutting: ");
        System.out.println(maxProduct(n));
    }

    /// Solution
/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯-memoization-⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(n²)
SC : O(n)
*/
    static int memoization(int n) {
        // potd.code.hub
        if (n <= 3) return n - 1;
        int[] dp = new int[n + 1];

        Arrays.fill(dp, -1);

        return solve(n, dp);
    }

    private static int solve(int n, int[] dp) {
        // base case
        if (n == 1) return 1;
        if (dp[n] != -1) return dp[n];

        // recursive case
        int max = 0;

        for (int i = 1; i <= n / 2; i++) {
            int l = solve(i, dp);
            int r = solve(n - i, dp);
            max = Math.max(max, l * r);
        }

        return dp[n] = Math.max(max, n);
    }

/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯-mathematical-approach-⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(log n)
SC : O(1)
*/
    static int maxProduct(int n) {
        if (n <= 3) return n - 1;

        int count3 = n / 3;
        int mod3 = n % 3;

        if (mod3 == 1) return (int) Math.pow(3, count3 - 1) * 4;
        return (int) Math.pow(3, count3) * Math.max(mod3, 1);
    }
}
