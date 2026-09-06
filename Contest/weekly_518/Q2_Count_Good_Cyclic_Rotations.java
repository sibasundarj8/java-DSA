package Contest.weekly_518;/*
 *
 * https://leetcode.com/contest/weekly-contest-518/problems/count-good-cyclic-rotations/
 *
 * # Q2_Count_Good_Cyclic_Rotations. Count Good Cyclic Rotations
 *
 *   Q. You are given an integer array nums of even length n.
 *
 *      A cyclic rotation of nums is obtained by choosing a prefix of nums whose length is between 0 and n - 1
 *      (inclusive), and moving it to the end of the array while preserving the order of all elements.
 *
 *      A cyclic rotation is good if the sum of its first n / 2 elements is strictly greater than the sum of its
 *      last n / 2 elements.
 *
 *      Return the number of cyclic rotations of nums that are good.
 *
 *      A prefix of an array is a subarray that starts from the beginning of the array and extends to any point within it.
 *
 *      A subarray is a contiguous sequence of elements within an array, which may be empty.
 *
 *    Ex.
 *      Input : nums = [1, 2, 3, 4, 5, 6]
 *      Output: 3
 *      Explanation:
 *              The cyclic rotations of nums are:
 *                           +---------------------+------------------+-----------------+
 *                           |   Cyclic rotation   |  Sum of first    |  Sum of last    |
 *                           |                     |  n/2 elements    |  n/2 elements   |
 *                           +---------------------+------------------+-----------------+
 *                           | [1, 2, 3, 4, 5, 6]  |  1 + 2 + 3 = 6   |  4 + 5 + 6 = 15 |
 *                           +---------------------+------------------+-----------------+
 *                           | [2, 3, 4, 5, 6, 1]  |  2 + 3 + 4 = 9   |  5 + 6 + 1 = 12 |
 *                           +---------------------+------------------+-----------------+
 *                           | [3, 4, 5, 6, 1, 2]  |  3 + 4 + 5 = 12  |  6 + 1 + 2 = 9  |
 *                           +---------------------+------------------+-----------------+
 *                           | [4, 5, 6, 1, 2, 3]  |  4 + 5 + 6 = 15  |  1 + 2 + 3 = 6  |
 *                           +---------------------+------------------+-----------------+
 *                           | [5, 6, 1, 2, 3, 4]  |  5 + 6 + 1 = 12  |  2 + 3 + 4 = 9  |
 *                           +---------------------+------------------+-----------------+
 *                           | [6, 1, 2, 3, 4, 5]  |  6 + 1 + 2 = 9   |  3 + 4 + 5 = 12 |
 *                           +---------------------+------------------+-----------------+
 *              The first half has a greater sum than the second half for 3 rotations. Thus, the answer is 3.
 *
 *  Constraints:
 *        ◦ 2 <= n == nums.length <= 10⁵
 *        ◦ 1 <= nums[i] <= 10⁹
 *        ◦ n is even.
 */

public class Q2_Count_Good_Cyclic_Rotations {

    /// Solution
    public int countGoodRotations(int[] nums) {
        int x, n = nums.length;
        int half = n >> 1;
        long first = 0;
        long last = 0;

        for (int i = 0; i < n; i++) {
            if (i < half) first += nums[i];
            else last += nums[i];
        }

        int count = (first > last) ? 1 : 0;

        for (int i = 0; i < n - 1; i++) {
            x = (i + half) % n;

            first += nums[x];
            first -= nums[i];

            last += nums[i];
            last -= nums[x];

            if (first > last) count++;
        }

        return count;
    }
}