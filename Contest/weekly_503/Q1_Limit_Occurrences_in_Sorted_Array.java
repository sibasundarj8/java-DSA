package Contest.weekly_503;/*
 *
 * https://leetcode.com/contest/weekly-contest-503/problems/limit-occurrences-in-sorted-array/
 *
 * # Q1. Limit Occurrences in Sorted Array©leetcode
 *
 *   Q. You are given a sorted integer array nums and an integer k.
 *
 *      Return an array such that each distinct element appears at most k times, while preserving the relative order of the
 *      elements in nums.
 *
 *      Note: If a distinct element appears at least k times, then it must appear exactly k times in the resulting array.
 *
 *    Ex.
 *      Input: nums = [1,1,1,2,2,3], k = 2
 *      Output: [1,1,2,2,3]
 *      Explanation:
 *              Each element can appear at most 2 times.
 *                ◦ The element 1 appears 3 times, so only 2 occurrences are kept.
 *                ◦ The element 2 appears 2 times, so both occurrences are kept.
 *                ◦ The element 3 appears 1 time, so it is kept.
 *              Thus, the resulting array is [1, 1, 2, 2, 3].
 *
 *  Constraints:
 *          1 <= nums.length <= 100
 *          1 <= nums[i] <= 100
 *          nums is sorted in non-decreasing order.
 *          1 <= k <= nums.length
 */

import java.util.ArrayList;
import java.util.List;

public class Q1_Limit_Occurrences_in_Sorted_Array {

    /// Solution
    public int[] limitOccurrences(int[] nums, int k) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();

        list.add(nums[0]);
        int count = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1]) {
                count = 0;
            }
            if (count >= k) {
                continue;
            }

            list.add(nums[i]);
            count++;
        }

        int len = list.size();
        int[] res = new int[len];

        for (int i = 0; i < len; i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}
