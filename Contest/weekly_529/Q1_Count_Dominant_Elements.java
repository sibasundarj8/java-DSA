package Contest.weekly_529;/*
 *
 * https://leetcode.com/contest/weekly-contest-529/problems/count-dominant-elements/
 *
 * # Q1. Count Dominant Elements
 *
 *   Q. You are given an integer array nums.
 *
 *      An element in nums is called dominant if it is greater than or equal to the average of its immediate neighbors.
 *
 *      The immediate neighbors of nums[i] are nums[i - 1] and nums[i + 1], when those indices exist.
 *
 *      A single element with no neighbors is considered dominant.
 *
 *      Return the number of dominant elements in nums.
 *
 *    Ex.
 *      Input : nums = [6, 4, 2]
 *      Output: 2
 *      Explanation:
 *              ◦ For nums[0] = 6, its only neighbor is 4. Since 6 > 4, it is dominant.
 *              ◦ For nums[1] = 4, its neighbors are 6 and 2. Their average is (6 + 2) / 2 = 4. Since 4 = 4, it is
 *                dominant.
 *              ◦ For nums[2] = 2, its only neighbor is 4. Since 2 < 4, it is not dominant.
 *              Therefore, the answer is 2.
 *
 *  Constraints:
 *        ◦ 1 <= nums.length <= 100
 *        ◦ 1 <= nums[i] <= 100
 */

public class Q1_Count_Dominant_Elements {

    /// Solution
    public int countDominantElements(int[] nums) {
        int n = nums.length;

        if (n <= 1) return n;

        int count = 0;

        if (nums[0] >= nums[1]) count++;
        if (nums[n - 1] >= nums[n - 2]) count++;

        for (int i = 1; i < n - 1; i++) {
            int nxt = nums[i - 1] + nums[i + 1];

            if (nums[i] << 1 >= nxt) {
                count++;
            }
        }

        return count;
    }
}
