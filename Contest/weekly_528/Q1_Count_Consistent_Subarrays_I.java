package Contest.weekly_528;/*
 *
 * https://leetcode.com/contest/weekly-contest-528/problems/count-consistent-subarrays-i/
 *
 * # Q1. Count Consistent Subarrays I
 *
 *   Q. You are given an integer array nums.
 *
 *      A subarray is called consistent if the bitwise AND of all its elements is equal to the minimum value of the
 *      subarray.
 *
 *      Return the number of consistent subarrays in nums.
 *
 *      A subarray is a contiguous, non-empty sequence of elements within an array.
 *
 *    Ex.
 *      Input : nums = [5, 3, 1, 2]
 *      Output: 6
 *      Explanation:
 *              The following subarrays are consistent:
 *           +--------------+------------+-------------------+---------------+
 *           |   Subarray   | Values     |    Bitwise AND    | Minimum Value |
 *           *==============*============*===================*===============*
 *           |  nums[0..0]  |   [5]      |         5         |       5       |
 *           +--------------+------------+-------------------+---------------+
 *           |  nums[1..1]  |   [3]      |         3         |       3       |
 *           +--------------+------------+-------------------+---------------+
 *           |  nums[2..2]  |   [1]      |         1         |       1       |
 *           +--------------+------------+-------------------+---------------+
 *           |  nums[3..3]  |   [2]      |         2         |       2       |
 *           +--------------+------------+-------------------+---------------+
 *           |  nums[1..2]  |  [3, 1]    |    3 AND 1 = 1    |       1       |
 *           +--------------+------------+-------------------+---------------+
 *           |  nums[0..2]  |  [5, 3, 1] | 5 AND 3 AND 1 = 1 |       1       |
 *           +--------------+------------+-------------------+---------------+
 *              Therefore, the number of consistent subarrays is 6.
 *
 *  Constraints:
 *        ◦ 1 <= nums.length <= 100
 *        ◦ 0 <= nums[i] <= 100
 */

public class Q1_Count_Consistent_Subarrays_I {

    /// Solution
    public int countConsistent(int[] nums) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int min = nums[i];
            int and = nums[i];

            for (int j = i; j < n; j++) {
                min = Math.min(min, nums[j]);
                and &= nums[j];
                if (and == min) count++;
            }
        }

        return count;
    }
}
