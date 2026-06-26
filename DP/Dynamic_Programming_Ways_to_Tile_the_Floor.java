package DP;/*
 *
 * https://www.geeksforgeeks.org/problems/count-the-number-of-ways-to-tile-the-floor-of-size-n-x-m-using-1-x-m-size-tiles0509/1
 *
 * # Ways to Tile the Floor
 *
 *   Q. Given a floor of dimensions n × m and an unlimited supply of tiles of size 1 × m, find the total number of ways to
 *      completely tile the floor.
 *
 *      Each tile can be placed in one of the following ways:
 *        ◦ Horizontally, covering 1 row and m columns.
 *        ◦ Vertically, covering m rows and 1 column.
 *        ◦ Count all possible ways to cover the entire floor such that there are no overlaps and no uncovered cells.
 *
 *      Since the number of possible tilings can be very large, return the answer modulo 10⁹+7.
 *      Note: n and m are positive integers, and m ≥ 2.
 *
 *    Ex.
 *      Input : n = 4, m = 4
 *      Output: 2
 *      Explanation: There are exactly two valid ways to tile the floor.
 *
 *  Constraints:
 *          1 ≤ n ≤ 10⁵
 *          2 ≤ m ≤ 10⁵
 */

import java.util.Arrays;
import java.util.Scanner;

public class Dynamic_Programming_Ways_to_Tile_the_Floor {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("n: ");
        int n = sc.nextInt();

        System.out.print("m: ");
        int m = sc.nextInt();

        System.out.println("Total number of ways to completely tile the floor: ");
        System.out.println(countWays(n, m));
    }

    /// Solution
    private static final int MOD = (int) (1e9 + 7);

    static int countWays(int n, int m) {
        // potd.code.hub
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return solve(n, m, dp);
    }

    private static int solve(int n, int m, int[] dp) {
        // base case
        if (n == 0) return 1;
        if (n < 0) return 0;
        if (dp[n] != -1) return dp[n];

        // recursive work
        return dp[n] = (solve(n - m, m, dp) + solve(n - 1, m, dp)) % MOD;
    }
}
