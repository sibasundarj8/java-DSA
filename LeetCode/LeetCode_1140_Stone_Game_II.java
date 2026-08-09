package LeetCode;/*
 *
 * https://leetcode.com/problems/stone-game-ii/
 *
 * # LC. 1140. Stone Game II
 *
 *   Q. Alice and Bob continue their games with piles of stones. There are a number of piles arranged in a row, and each
 *      pile has a positive integer number of stones piles[i]. The objective of the game is to end with the most stones.
 *
 *      Alice and Bob take turns, with Alice starting first.
 *
 *      On each player's turn, that player can take all the stones in the first X remaining piles, where 1 <= X <= 2M.
 *      Then, we set M = max(M, X). Initially, M = 1.
 *
 *      The game continues until all the stones have been taken.
 *
 *      Assuming Alice and Bob play optimally, return the maximum number of stones Alice can get.
 *
 *    Ex.
 *      Input : piles = [2, 7, 9, 4, 4]
 *      Output: 10
 *      Explanation:
 *              If Alice takes one pile at the beginning, Bob takes two piles, then Alice takes 2 piles again. Alice can
 *              get 2 + 4 + 4 = 10 stones in total.
 *
 *              If Alice takes two piles at the beginning, then Bob can take all three piles left. In this case, Alice
 *              get 2 + 7 = 9 stones in total.
 *
 *              So we return 10 since it's larger.
 *
 *  Constraints:
 *        ◦ 1 <= piles.length <= 100
 *        ◦ 1 <= piles[i] <= 10⁴
 */

import java.util.Arrays;
import java.util.Scanner;

public class LeetCode_1140_Stone_Game_II {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("int[] piles: ");
        String[] piles = sc.nextLine().split(" ");

        int n = piles.length;
        int[] pile = new int[n];
        for (int i = 0; i < n; i++) {
            pile[i] = Integer.parseInt(piles[i]);
        }

        System.out.println("Number of stones Alice can get if both will play optimally: ");
        System.out.println(stoneGameII(pile));
    }

    /// Solution
    static int stoneGameII(int[] piles) {
        // potd.code.hub
        int n = piles.length;

        int[] suffix = new int[n];
        suffix[n - 1] = piles[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffix[i] += (piles[i] + suffix[i + 1]);
        }

        int[][] dp = new int[n][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, 1, n, suffix, dp);
    }

    private static int solve(int i, int m, int n, int[] suffix, int[][] dp) {
        // base case
        if (i >= n) return 0;
        if ((n - i) < (m << 1)) return suffix[i];
        if (dp[i][m] != -1) return dp[i][m];

        // recursive work
        int stones = 0;
        int limit = m << 1;

        for (int x = 1; x <= limit; x++) {
            int bob = solve(i + x, Math.max(x, m), n, suffix, dp);
            int alice = suffix[i] - bob;
            stones = Math.max(stones, alice);
        }

        return dp[i][m] = stones;
    }
}
