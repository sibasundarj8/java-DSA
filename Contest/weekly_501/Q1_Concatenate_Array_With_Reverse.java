package Contest.weekly_501;/*
 *
 * https://leetcode.com/contest/weekly-contest-501/problems/concatenate-array-with-reverse/
 *
 * # Q1. Concatenate Array With Reverse
 *
 *   Q. You are given an integer array nums of length n.
 *
 *      Construct a new array ans of length 2 * n such that the first n elements are the same as nums, and the next n elements
 *      are the elements of nums in reverse order.
 *
 *      Formally, for 0 <= i <= n - 1:
 *        ◦ ans[i] = nums[i]
 *        ◦ ans[i + n] = nums[n - i - 1]
 *
 *      Return an integer array ans.
 *
 *    Ex.
 *      Input : nums = [1,2,3]
 *      Output: [1,2,3,3,2,1]
 *      Explanation:
 *              The first n elements of ans are the same as nums.
 *
 *              For the next n = 3 elements, each element is taken from nums in reverse order:
 *                ◦ ans[3] = nums[2] = 3
 *                ◦ ans[4] = nums[1] = 2
 *                ◦ ans[5] = nums[0] = 1
 *              Thus, ans = [1, 2, 3, 3, 2, 1].
 *
 *  Constraints:
 *          1 <= nums.length <= 100
 *          1 <= nums[i] <= 100
 */

public class Q1_Concatenate_Array_With_Reverse {

    /// Solution
    public int[] concatWithReverse(int[] nums) {
        int n = nums.length;
        int m = 2 * n;
        int[] ans = new int[m];

        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];
            ans[m - 1 - i] = nums[i];
        }

        return ans;
    }
}
