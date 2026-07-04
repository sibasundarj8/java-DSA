package Contest.biWeekly_186;/*
 *
 * https://leetcode.com/contest/biweekly-contest-186/problems/maximum-valid-pair-sum/
 *
 * # Q2. Maximum Valid Pair Sum
 *
 *   Q. You are given an integer array nums of length n and an integer k.
 *
 *      A pair of indices (i, j) is called valid if:
 *        ◦ 0 <= i < j < n
 *        ◦ j - i >= k
 *
 *      Return the maximum value of nums[i] + nums[j] among all valid pairs.
 *
 *    Ex.
 *      Input : nums = [1, 3, 5, 2, 8],
 *              k = 2
 *      Output: 13
 *      Explanation:
 *              The valid pairs are:
 *                ◦ (0, 2): nums[0] + nums[2] = 6
 *                ◦ (0, 3): nums[0] + nums[3] = 3
 *                ◦ (0, 4): nums[0] + nums[4] = 9
 *                ◦ (1, 3): nums[1] + nums[3] = 5
 *                ◦ (1, 4): nums[1] + nums[4] = 11
 *                ◦ (2, 4): nums[2] + nums[4] = 13
 *
 *              Thus, the answer is 13.
 *
 *  Constraints:
 *     ◦ 2 <= n == nums.length <= 10⁵
 *     ◦ 1 <= nums[i] <= 10⁹
 *     ◦ 1 <= k <= n - 1
 */

public class Q2_Maximum_Valid_Pair_Sum {

    /// Solution
    public int maxValidPairSum(int[] nums, int k) {
        int n = nums.length;
        long lMax = Integer.MIN_VALUE;
        long max = 0;

        for (int i = k; i < n; i++) {
            lMax = Math.max(lMax, nums[i - k]);
            max = Math.max(max, lMax + nums[i]);
        }

        return (int) max;
    }
}