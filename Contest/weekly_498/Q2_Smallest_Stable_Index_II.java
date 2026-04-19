package Contest.weekly_498;/*
 *
 * https://leetcode.com/contest/weekly-contest-498/problems/smallest-stable-index-ii/
 *
 * # Q2. Smallest Stable Index II
 *
 *   Q. You are given an integer array nums of length n and an integer k.
 *      For each index i, define its instability score as max(nums[0..i]) - min(nums[i..n - 1]).
 *
 *      In other words:
 *        ◦ max(nums[0..i]) is the largest value among the elements from index 0 to index i.
 *        ◦ min(nums[i..n - 1]) is the smallest value among the elements from index i to index n - 1.
 *        ◦ An index i is called stable if its instability score is less than or equal to k.
 *
 *      Return the smallest stable index. If no such index exists, return -1.
 *
 *    Ex.
 *      Input: nums = [5,0,1,4], k = 3
 *      Output: 3
 *      Explanation:
 *              ◦ At index 0: The maximum in [5] is 5, and the minimum in [5, 0, 1, 4] is 0, so the instability score is 5 - 0 = 5.
 *              ◦ At index 1: The maximum in [5, 0] is 5, and the minimum in [0, 1, 4] is 0, so the instability score is 5 - 0 = 5.
 *              ◦ At index 2: The maximum in [5, 0, 1] is 5, and the minimum in [1, 4] is 1, so the instability score is 5 - 1 = 4.
 *              ◦ At index 3: The maximum in [5, 0, 1, 4] is 5, and the minimum in [4] is 4, so the instability score is 5 - 4 = 1.
 *
 *              This is the first index with an instability score less than or equal to k = 3. Thus, the answer is 3.
 *
 *
 *  Constraints:
 *          1 <= nums.length <= 100
 *          0 <= nums[i] <= 10⁹
 *          0 <= k <= 10⁹
 */

public class Q2_Smallest_Stable_Index_II {

    /// Solution
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] pg = new int[n];
        int[] ns = new int[n];

        pg[0] = nums[0];
        ns[n - 1] = nums[n - 1];

        for (int i = 1; i < n; i++) {
            int j = n - i - 1;
            pg[i] = Math.max(pg[i - 1], nums[i]);
            ns[j] = Math.min(nums[j], ns[j + 1]);
        }

        for (int i = 0; i < n; i++) {
            int score = pg[i] - ns[i];
            if (score <= k) return i;
        }

        return -1;
    }
}
