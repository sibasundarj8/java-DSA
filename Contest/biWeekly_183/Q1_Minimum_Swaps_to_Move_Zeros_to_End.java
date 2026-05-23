package Contest.biWeekly_183;/*
 *
 * https://leetcode.com/contest/biweekly-contest-183/problems/minimum-swaps-to-move-zeros-to-end/
 *
 * # Q1. Minimum Swaps to Move Zeros to End
 *
 *   Q. You are given an integer array nums. In one operation, you can choose any two distinct indices i and j and swap
 *      nums[i] and nums[j]. Return an integer denoting the minimum number of operations required to move all 0s to the
 *      end of the array.
 *
 *    Ex.
 *      Input : nums = [0, 1, 0, 3, 12]
 *      Output: 2
 *      Explanation:
 *          We perform the following swap operations:
 *            ◦ Swap nums[0] and nums[3], giving nums = [3, 1, 0, 0, 12].
 *            ◦ Swap nums[2] and nums[4], giving nums = [3, 1, 12, 0, 0].
 *            ◦ Thus, the answer is 2.
 *
 *  Constraints:
 *        1 <= nums.length <= 100
 *        0 <= nums[i] <= 100
 */

public class Q1_Minimum_Swaps_to_Move_Zeros_to_End {

    /// Solution
    public int minimumSwaps(int[] nums) {
        int i = 0, j = nums.length - 1;
        int count = 0;

        while (i < j) {

            while (i < j && nums[i] != 0) i++;
            while (i < j && nums[j] == 0) j--;

            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                count++;
            }
        }

        return count;
    }
}
