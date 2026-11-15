package Contest.weekly_528;/*
 *
 * https://leetcode.com/contest/weekly-contest-528/problems/game-of-divisible-sums/
 *
 * # Q3. Game of Divisible Sums
 *
 *   Q. Alice and Bob are playing a game with an integer array nums. Alice goes first.
 *
 *      On each turn, the current player takes and removes either the leftmost element or, if at least two elements
 *      remain, the two leftmost elements.
 *
 *      The sum of the elements taken in that turn determines who plays next:
 *        ◦ If the sum is divisible by 3, the other player plays next.
 *        ◦ Otherwise, the same player plays again.
 *
 *      The score of a player is the sum of the values of all elements that player takes.
 *
 *      Both players play optimally, with each player trying to maximize their own score.
 *
 *      The game ends when all elements have been taken.
 *
 *      Return Alice's score minus Bob's score.
 *
 *    Ex.
 *      Input : nums = [3, 6, 4]
 *      Output: 5
 *      Explanation:
 *              One sequence of optimal turns is as follows:
 *                ◦ Alice takes the two leftmost elements. Their sum is 3 + 6 = 9, which is divisible by 3, so Bob
 *                  plays next. Alice's score is now 9, and the remaining array is [4].
 *
 *                ◦ Bob takes the only remaining element. His score is 4, and the game ends.
 *
 *              Alice's score minus Bob's score is 9 - 4 = 5, so the answer is 5.
 *
 *  Constraints:
 *        ◦ 1 <= nums.length <= 10⁵
 *        ◦ 1 <= nums[i] <= 10⁹
 */

import java.util.Arrays;

public class Q3_Game_of_Divisible_Sums {

    /// Solution
    public long maxDifference(int[] nums) {
        int n = nums.length;
        long[] dp = new long[n];

        Arrays.fill(dp, Long.MIN_VALUE);

        return solve(0, n, nums, dp);
    }

    private long solve(int i, int n, int[] nums, long[] dp) {
        // base case
        if (i >= n) return 0;
        if (dp[i] != Long.MIN_VALUE) return dp[i];

        // recursive work
        long sum1 = nums[i];
        long pick1 = 0;

        if (sum1 % 3 == 0) {
            pick1 = sum1 - solve(i + 1, n, nums, dp);
        } else {
            pick1 = sum1 + solve(i + 1, n, nums, dp);
        }

        long pick2 = Long.MIN_VALUE;

        if (i + 1 < n) {
            long sum2 = nums[i] + nums[i + 1];

            if (sum2 % 3 == 0) {
                pick2 = sum2 - solve(i + 2, n, nums, dp);
            } else {
                pick2 = sum2 + solve(i + 2, n, nums, dp);
            }
        }

        // self work
        return dp[i] = Math.max(pick1, pick2);
    }
}