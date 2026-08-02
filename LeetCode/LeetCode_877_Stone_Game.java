package LeetCode;/*
 *
 * https://leetcode.com/problems/stone-game/
 *
 * # LC. 877. Stone Game
 *
 *   Q. Alice and Bob play a game with piles of stones. There are an even number of piles arranged in a row, and each
 *      pile has a positive integer number of stones piles[i].
 *
 *      The objective of the game is to end with the most stones. The total number of stones across all the piles is
 *      odd, so there are no ties.
 *
 *      Alice and Bob take turns, with Alice starting first. Each turn, a player takes the entire pile of stones either
 *      from the beginning or from the end of the row. This continues until there are no more piles left, at which point
 *      the person with the most stones wins.
 *
 *      Assuming Alice and Bob play optimally, return true if Alice wins the game, or false if Bob wins.
 *
 *    Ex.
 *      Input : piles = [5, 3, 4, 5]
 *      Output: true
 *      Explanation:
 *              Alice starts first, and can only take the first 5 or the last 5.
 *              Say she takes the first 5, so that the row becomes [3, 4, 5].
 *              If Bob takes 3, then the board is [4, 5], and Alice takes 5 to win with 10 points.
 *              If Bob takes the last 5, then the board is [3, 4], and Alice takes 4 to win with 9 points.
 *              This demonstrated that taking the first 5 was a winning move for Alice, so we return true.
 *
 *  Constraints:
 *        ◦ 2 <= piles.length <= 500
 *        ◦ piles.length is even.
 *        ◦ 1 <= piles[i] <= 500
 *        ◦ sum(piles[i]) is odd.
 */

import java.util.Arrays;
import java.util.Scanner;

public class LeetCode_877_Stone_Game {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("int[] piles: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;

        if ((n & 1) == 1) {
            throw new IllegalArgumentException("number of piles must be even");
        }

        int[] piles = new int[n];
        for (int i = 0; i < n; i++) {
            piles[i] = Integer.parseInt(s[i]);
        }

        System.out.print("Does Alish win: ");
        System.out.println(stoneGame(piles) ? "YSE" : "NO");
    }

    /// Solution
/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯-memoization-⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(n × m)
SC : O(n × m²)
*/
    static boolean approach_1(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];

        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }

        return solve(0, n - 1, piles, dp) > 0;
    }

    private static int solve(int i, int j, int[] nums, int[][] dp) {
        // base case
        if (i > j) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        // recursive case
        int x = nums[i] - solve(i + 1, j, nums, dp);
        int y = nums[j] - solve(i, j - 1, nums, dp);

        // self work
        return dp[i][j] = Math.max(x, y);
    }

/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯--mathematical-way--⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(1)
SC : O(1)
*/
    static boolean stoneGame(int[] piles) {
        /*
            If both are playing optimally then the individual wins who start the game,
            only if there is even number of piles.
        */
        return true;
    }
}
