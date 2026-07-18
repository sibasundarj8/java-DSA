package Contest.biWeekly_187;/*
 *
 * https://leetcode.com/contest/biweekly-contest-187/problems/minimum-adjacent-swaps-to-partition-array/
 *
 * # Q3. Minimum Adjacent Swaps to Partition Array
 *
 *   Q. You are given an integer array nums and two integers a and b such that a < b.
 *
 *      An array is called good if it can be split into three contiguous parts, in this order, such that:
 *        ◦ Every element in the first part is less than 'a'.
 *        ◦ Every element in the second part is in the range [a, b] inclusive.
 *        ◦ Every element in the third part is greater than b.
 *
 *      Any of the three parts may be empty.
 *
 *      In one adjacent swap, you may swap two neighboring elements of nums.
 *
 *      Return the minimum number of adjacent swaps required to make nums good. Since the answer may be very large,
 *      return it modulo 1e9 + 7.
 *
 *    Ex.
 *      Input : nums = [1,3,2,4,5,6], a = 3, b = 4
 *      Output: 1
 *      Explanation:
 *              Swap nums[1] and nums[2]. The array becomes [1, 2, 3, 4, 5, 6].
 *              This array is good because it can be split into [1, 2], [3, 4], and [5, 6].
 *
 *  Constraints:
 *       ◦ 1 <= nums.length <= 10⁵
 *       ◦ 1 <= nums[i] <= 10⁹
 *       ◦ 1 <= a < b <= 10⁹
 */

public class Q3_Minimum_Adjacent_Swaps_to_Partition_Array {

    /// Solution
    private static final int MOD = (int) (1e9 + 7);

    public int minAdjacentSwaps(int[] nums, int a, int b) {
        long count1 = 0;
        long count2 = 0;
        long swaps = 0;

        for (int ele : nums) {
            if (a <= ele && ele <= b) {
                count1++;
                swaps = (swaps + count2) % MOD;
            } else if (ele < a) swaps = (swaps + count1 + count2) % MOD;
            else count2++;
        }

        return (int) swaps % MOD;
    }
}