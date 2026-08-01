package LeetCode;/*
 *
 * https://leetcode.com/problems/predict-the-winner/
 *
 * # LC. 486. Predict the Winner
 *
 *   Q. You are given an integer array nums. Two players are playing a game with this array: player 1 and player 2.
 *
 *      Player 1 and player 2 take turns, with player 1 starting first. Both players start the game with a score of 0.
 *      At each turn, the player takes one of the numbers from either end of the array
 *      (i.e., nums[0] or nums[nums.length - 1]) which reduces the size of the array by 1. The player adds the chosen
 *      number to their score. The game ends when there are no more elements in the array.
 *
 *      Return true if Player 1 can win the game. If the scores of both players are equal, then player 1 is still the winner, and you should also return true. You may assume that both players are playing optimally.
 *
 *    Ex.
 *      Input : nums = [1, 5, 233, 7]
 *      Output: true
 *      Explanation: Player 1 first chooses 1. Then player 2 has to choose between 5 and 7. No matter which number
 *                   player 2 choose, player 1 can choose 233.
 *
 *                   Finally, player 1 has more score (234) than player 2 (12), so you need to return True representing
 *                   player1 can win.
 *
 *  Constraints:
 *      1 <= nums.length <= 20
 *      0 <= nums[i] <= 10⁷
 */

import java.util.Arrays;
import java.util.Scanner;

public class LeetCode_486_Predict_the_Winner {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("int[] nums: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.println("Player-1 win: " + predictTheWinner(arr));
    }

    /// Solution
    static boolean predictTheWinner(int[] nums) {
        // If the final difference is >= 0, Player 1 wins or ties
        int n = nums.length;
        int[][] dp = new int[n][n];

        for (int[] x : dp) {
            Arrays.fill(x, -1);
        }

        return solve(0, n - 1, nums, dp) >= 0;
    }

    private static int solve(int i, int j, int[] nums, int[][] dp) {
        // base case
        if (i > j) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        // recursive work
        int takeLeft = nums[i] - solve(i + 1, j, nums, dp);
        int takeRight = nums[j] - solve(i, j - 1, nums, dp);

        // self work
        return dp[i][j] = Math.max(takeLeft, takeRight);
    }
}
