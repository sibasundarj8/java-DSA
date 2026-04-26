package Contest.weekly_499;/*
 *
 * https://leetcode.com/contest/weekly-contest-499/problems/minimum-operations-to-make-array-non-decreasing/
 *
 * # Q3. Minimum Operations to Make Array Non-Decreasing
 *
 *   Q. You are given an integer array nums of length n.
 *
 *      In one operation, you may choose any subarray nums[l...r] and increase each element in that subarray by x, where x
 *      is any positive integer.
 *
 *      Return the minimum possible sum of the values of x across all operations required to make the array non-decreasing.
 *
 *      An array is non-decreasing if nums[i] <= nums[i + 1] for all 0 <= i < n - 1.
 *
 *      A subarray is a contiguous non-empty sequence of elements within an array.
 *
 *      Note: Please do not copy the description during the contest to maintain the integrity of your submissions.
 *
 *    Ex.
 *      Input : nums = [5,1,2,3]
 *      Output: 4
 *      Explanation:
 *          One optimal set of operations:
 *          Choose subarray [1..3] and add x = 4 resulting in [5, 5, 6, 7]
 *          The array becomes non-decreasing, and the total sum of chosen x values is 4.
 *          Note: Please do not copy the description during the contest to maintain the integrity of your submissions.
 *
 *  Constraints:
 *      1 <= n == nums.length <= 10⁵
 *      1 <= nums[i] <= 10⁹
 */

public class Q3_Minimum_Operations_to_Make_Array_Non_Decreasing {

    /// Solution
    public long minOperations(int[] nums) {
        int n = nums.length;
        long minOps = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i - 1] > nums[i]) {
                minOps += (nums[i - 1] - nums[i]);
            }
        }

        return minOps;
    }
}
