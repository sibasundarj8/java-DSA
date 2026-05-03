package Contest.weekly_500;/*
 *
 * https://leetcode.com/problems/count-indices-with-opposite-parity/
 *
 * # Q1. Count Indices With Opposite Parity
 *
 *   Q. You are given an integer array nums of length n.
 *
 *      The score of an index i is defined as the number of indices j such that:
 *        ◦ i < j < n, and
 *        ◦ nums[i] and nums[j] have different parity (one is even and the other is odd).
 *
 *      Return an integer array answer of length n, where answer[i] is the score of index i.
 *
 *    Ex.
 *      Input : nums = [1,2,3,4]
 *      Output: [2,1,1,0]
 *      Explanation:
 *            ◦ nums[0] = 1, which is odd. Thus, the indices j = 1 and j = 3 satisfy the conditions, so the score of index 0 is 2.
 *            ◦ nums[1] = 2, which is even. Thus, the index j = 2 satisfies the conditions, so the score of index 1 is 1.
 *            ◦ nums[2] = 3, which is odd. Thus, the index j = 3 satisfies the conditions, so the score of index 2 is 1.
 *            ◦ nums[3] = 4, which is even. Thus, no index satisfies the conditions, so the score of index 3 is 0.
 *
 *          Thus, the answer = [2, 1, 1, 0].
 *
 *  Constraints:
 *          1 <= nums.length <= 100
 *          1 <= nums[i] <= 100
 */

public class Q1_Count_Indices_With_Opposite_Parity {

    /// Solution
    public int[] countOppositeParity(int[] nums) {
        int n = nums.length;
        int oddCount = 0;
        int evenCount = 0;
        int[] ans = new int[n];

        for(int i = n - 1; i >= 0; i--) {
            if ((nums[i] & 1) == 1) {
                ans[i] = evenCount;
                oddCount++;
            } else {
                ans[i] = oddCount;
                evenCount++;
            }
        }

        return ans;
    }
}
