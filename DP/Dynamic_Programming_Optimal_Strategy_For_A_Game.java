package DP;/*
 *
 * https://www.geeksforgeeks.org/problems/optimal-strategy-for-a-game-1587115620/1
 *
 * # Optimal Strategy For A Game
 *
 *   Q. You are given an integer array arr[] of size n(even). The array elements represent n coins of values v1, v2, ....vn.
 *      You play against an opponent in an alternating way. In each turn, a player selects either the first or last coin from
 *      the row, removes it from the row permanently, and receives the coin's value. You need to determine the maximum possible
 *      amount of money you can win if you go first.
 *
 *      Note: Both the players are playing optimally.
 *
 *    Ex.
 *      Input : arr[] = [8, 15, 3, 7]
 *      Output: 22
 *      Explanation: The user collects the maximum value as 22(7 + 15). It is guaranteed that we cannot get more than 22
 *                   by any possible moves.
 *
 *  Constraints:
 *          2 <= n <= 10³
 *          1 <= arr[i] <= 10⁶
 */

import java.util.Arrays;
import java.util.Scanner;

public class Dynamic_Programming_Optimal_Strategy_For_A_Game {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter values of coins: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

        System.out.println("Max amount can win if I go first: ");
        System.out.println(maximumAmount(arr));
    }

    /// Solution
    public static int maximumAmount(int[] arr) {
        // potd.code.hub
        int n = arr.length;
        int[][] dp = new int[n][n];

        for (int[] a : dp)
            Arrays.fill(a, -1);

        return f(0, n - 1, arr, dp);
    }

    private static int f(int i, int j, int[] arr, int[][] dp) {
        // base case
        if (j < i) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        // recursive work
        int pickLeft = arr[i] + Math.min(f(i + 2, j, arr, dp), f(i + 1, j - 1, arr, dp));
        int pickRight = arr[j] + Math.min(f(i + 1, j - 1, arr, dp), f(i, j - 2, arr, dp));

        return dp[i][j] = Math.max(pickLeft, pickRight);
    }
}
