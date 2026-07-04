package Contest.biWeekly_186;/*
 *
 * https://leetcode.com/contest/biweekly-contest-186/problems/unique-middle-element/
 *
 * # Q1. Unique Middle Element
 *
 *   Q. You are given an integer array nums of odd length n. Return true if the middle element of nums appears exactly
 *      once in the array otherwise return false.
 *
 *    Ex.
 *      Input : nums = [1, 2, 3]
 *      Output: true
 *      Explanation:
 *              The middle element of nums is 2, which appears exactly once.
 *              Thus, the answer is true.
 *
 *  Constraints:
 *        ◦ 1 <= n == nums.length <= 100
 *        ◦ n is odd.
 *        ◦ 1 <= nums[i] <= 100
 */

public class Q1_Unique_Middle_Element {

    /// Solution
    public boolean isMiddleElementUnique(int[] nums) {
        int midValue = nums[nums.length / 2];
        int count = 0;

        for (int ele : nums) {
            if (ele == midValue) count++;
        }

        return count == 1;
    }
}
