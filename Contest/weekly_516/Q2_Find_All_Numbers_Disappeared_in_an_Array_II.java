package Contest.weekly_516;/*
 *
 * https://leetcode.com/contest/weekly-contest-516/problems/find-all-numbers-disappeared-in-an-array-ii/
 *
 * # Q2. Find All Numbers Disappeared in an Array II
 *
 *   Q. You are given an integer array nums and two integers lower and upper.
 *
 *      A missing integer is an integer in the inclusive range [lower, upper] that does not appear in nums.
 *
 *      Return a 2D integer array where each element is of the form [start, end], representing a contiguous range of
 *      missing integers. Return the ranges in increasing order. If there are no missing integers, return an empty
 *      array.
 *
 *      Note: Consecutive missing integers should be grouped into a single range.
 *
 *    Ex.
 *      Input : nums = [3, 9, 7], lower = 1, upper = 12
 *      Output: [[1, 2], [4, 6], [8, 8], [10, 12]]
 *      Explanation:
 *              ◦ The missing integers are [1, 2, 4, 5, 6, 8, 10, 11, 12].
 *              ◦ Grouping the missing integers into the minimum number of contiguous ranges,
 *                we get [1, 2], [4, 6], [8, 8], and [10, 12].
 *              ◦ Therefore, the answer is [[1, 2], [4, 6], [8, 8], [10, 12]].
 *
 *  Constraints:
 *        ◦ 1 <= nums.length <= 10⁵
 *        ◦ 1 <= nums[i] <= 10⁵
 *        ◦ 1 <= lower <= upper <= 10⁵
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q2_Find_All_Numbers_Disappeared_in_an_Array_II {

    /// Solution
    public List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        int nextExpected = lower;

        for (int num : nums) {
            if (num < nextExpected) continue;

            if (num == nextExpected) {
                nextExpected++;
            } else {
                if (num > upper) break;
                res.add(List.of(nextExpected, num - 1));
                nextExpected = num + 1;
            }
        }

        if (nextExpected <= upper) {
            res.add(List.of(nextExpected, upper));
        }

        return res;
    }
}