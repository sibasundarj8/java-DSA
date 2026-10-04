package Contest.weekly_522;/*
 *
 * https://leetcode.com/contest/weekly-contest-522/problems/maximum-alternating-subarray-sum-with-one-deletion/
 *
 * # Q3. Maximum Alternating Subarray Sum With One Deletion
 *
 *   Q. You are given an integer array nums.
 *      You may delete at most one element from nums, then choose a subarray of the resulting array.
 *      Return the maximum possible alternating sum of the chosen subarray.
 *
 *      The alternating sum of an array is the sum of its elements at even indices minus the sum of its elements at
 *      odd indices. The chosen subarray is reindexed starting from 0 before calculating its alternating sum.
 *
 *    Ex.
 *      Input : nums = [10, -5, -100]
 *      Output: 110
 *      Explanation:
 *              Delete nums[1] = -5 to obtain [10,-100], then select the entire resulting array.
 *              Its alternating sum is 10 - (-100) = 110, which is the maximum possible.
 *
 *  Constraints:
 *        ◦ 1 <= nums.length <= 10⁵
 *        ◦ -10⁵ <= nums[i] <= 10⁵
 */

import java.util.Arrays;

public class Q3_Maximum_Alternating_Subarray_Sum_With_One_Deletion {

    /// Solution
    private static final long INF = Long.MIN_VALUE >> 1;

    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[][][][] dp = new long[2][2][2][n];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    Arrays.fill(dp[i][j][k], INF);
                }
            }
        }

        return solve(0, 0, 0, 0, nums, n, dp);
    }

    private long solve(int del, int status, int opr, int idx, int[] arr, int n, long[][][][] dp) {
        // base case
        if (idx == n) return (status == 1) ? 0 : INF;
        if (dp[del][status][opr][idx] != INF) return dp[del][status][opr][idx];

        // recursive work
        long pick = INF;
        long skip = INF;
        long stop = INF;
        long delete = INF;
        int val = (opr == 0) ? arr[idx] : -arr[idx];

        if (status == 0) {
            skip = solve(0, 0, 0, idx + 1, arr, n, dp);
        } else {
            if (del == 0) {
                delete = solve(1, 1, opr, idx + 1, arr, n, dp);
            }
            stop = 0;
        }

        pick = val + solve(del, 1, opr ^ 1, idx + 1, arr, n, dp);

        return dp[del][status][opr][idx] = Math.max(pick, Math.max(skip, Math.max(stop, delete)));
    }
}