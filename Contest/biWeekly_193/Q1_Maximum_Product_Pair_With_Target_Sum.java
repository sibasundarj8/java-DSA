package Contest.biWeekly_193;/*
 *
 * https://leetcode.com/contest/biweekly-contest-193/problems/maximum-product-pair-with-target-sum/
 *
 * # Q1. Maximum Product Pair With Target Sum
 *
 *   Q. You are given an integer array nums and an integer target.
 *
 *      A pair of distinct indices (i, j) is valid if:
 *        ◦ nums[i] + nums[j] == target
 *        ◦ nums[i] > nums[j]
 *
 *      Return a valid pair [i, j] whose product nums[i] * nums[j] is maximum among all valid pairs.
 *      If no valid pair exists, return [-1, -1].
 *
 *      If multiple valid pairs achieve the maximum product, you may return any of them.
 *
 *    Ex.
 *      Input : nums = [1,2,3,4], target = 5
 *      Output: [2,1]
 *      Explanation:
 *              There are 2 valid pairs:
 *                           +-----+--------+-------+-------+-----+-------+
 *                           | No. | (i, j) |nums[i]|nums[j]| Sum |Product|
 *                           +=====+========+=======+=======+=====+=======+
 *                           |  1  | (3, 0) |   4   |   1   |  5  |   4   |
 *                           +-----+--------+-------+-------+-----+-------+
 *                           |  2  | (2, 1) |   3   |   2   |  5  |   6   |
 *                           +-----+--------+-------+-------+-----+-------+
 *
 *              Both pairs sum to 5 and satisfy nums[i] > nums[j]. The second pair has the larger product,
 *              3 * 2 = 6, so the answer is [2, 1].
 *
 *  Constraints:
 *        ◦ 2 <= nums.length <= 100
 *        ◦ -100 <= nums[i], target <= 100
 */

public class Q1_Maximum_Product_Pair_With_Target_Sum {

    /// Solution
    public int[] maxProductPair(int[] nums, int target) {
        int n = nums.length;
        int[] res = {-1, -1};
        long maxProduct = Long.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || nums[i] <= nums[j]) continue;

                if (nums[i] + nums[j] == target) {
                    long product = (long) nums[i] * nums[j];
                    if (product > maxProduct) {
                        maxProduct = product;
                        res[0] = i;
                        res[1] = j;
                    }
                }
            }
        }

        return res;
    }
}
