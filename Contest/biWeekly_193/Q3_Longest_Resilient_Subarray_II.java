package Contest.biWeekly_193;/*
 *
 * https://leetcode.com/contest/biweekly-contest-193/problems/longest-resilient-subarray-ii/
 *
 * # Q2. Longest Resilient Subarray I
 *
 *   Q. You are given an integer array nums and an integer k.
 *
 *      A subarray is resilient if, for every position in it, deleting the element at that position leaves
 *      the remaining elements with a sum divisible by k.
 *
 *      For a subarray of length 1, the remaining sum is 0, which is divisible by k.
 *
 *      Return the length of the longest resilient subarray.
 *
 *      A subarray is a contiguous non-empty sequence of elements within an array.
 *
 *    Ex.
 *      Input : nums = [2, 4, 6, 3], k = 2
 *      Output: 3
 *      Explanation:
 *              The subarray [2, 4, 6] sums to 12. Deleting 2, 4, or 6 leaves a sum of 10, 8, or 6,
 *              respectively, each of which is divisible by 2. Therefore, the answer is 3.
 *
 *  Constraints:
 *        ◦ 1 <= nums.length <= 10⁵
 *        ◦ 1 <= nums[i] <= 10⁵
 *        ◦ 1 <= k <= 10⁵
 */

public class Q3_Longest_Resilient_Subarray_II {

    /// Solution
    public int resilientSubarray(int[] nums, int k) {
        int n = nums.length;
        int max = 1;
        int l = 0;

        for (int r = 1; r < n; r++) {
            int rem1 = nums[r - 1] % k;
            int rem2 = nums[r] % k;

            if (rem1 == rem2) {
                int len = r - l + 1;

                if (rem1 == 0 || (rem1 * (len - 1L)) % k == 0) {
                    max = Math.max(max, len);
                }
            } else {
                l = r;
            }
        }

        return max;
    }
}