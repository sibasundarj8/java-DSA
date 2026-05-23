package Contest.biWeekly_183;/*
 *
 * https://leetcode.com/contest/biweekly-contest-183/problems/minimum-operations-to-make-array-modulo-alternating-i/
 *
 * # Q2. Minimum Operations to Make Array Modulo Alternating I
 *
 *   Q. You are given an integer array nums and an integer k.
 *
 *      In one operation, you can increase or decrease any element of nums by 1.
 *
 *      For every even index i, nums[i] % k == x
 *      For every odd index i, nums[i] % k == y
 *      Return the minimum number of operations required to make nums modulo alternating.
 *
 *    Ex.
 *      Input: nums = [1,4,2,8], k = 3
 *      Output: 2
 *      Explanation:
 *              Let's choose x = 1 for even indices and y = 2 for odd indices.
 *              Perform the following operations:
 *              Increment nums[1] = 4 by 1, giving nums = [1, 5, 2, 8].
 *              Decrement nums[2] = 2 by 1, giving nums = [1, 5, 1, 8].
 *              Now, for even indices, nums[i] % k = 1, and for odd indices, nums[i] % k = 2.
 *              Thus, the total number of operations required is 2.
 *
 *  Constraints:
 *          1 <= nums.length <= 100
 *          1 <= nums[i] <= 10⁹
 *          2 <= k <= 100
 */

public class Q2_Minimum_Operations_to_Make_Array_Modulo_Alternating_I {

    /// Solution
    public int minOperations(int[] nums, int k) {
        int n = nums.length;
        int minOperations = Integer.MAX_VALUE;

        for (int oddTarget = 0; oddTarget < k; oddTarget++) {
            for (int evenTarget = 0; evenTarget < k; evenTarget++) {

                if (oddTarget == evenTarget) continue;

                int operationCount = 0;

                for (int i = 0; i < n; i++) {
                    int val = nums[i] % k;
                    int target = ((i & 1) == 1) ? oddTarget : evenTarget;
                    int diff = Math.abs(val - target);
                    operationCount += Math.min(diff, k - diff);
                }

                minOperations = Math.min(minOperations, operationCount);
            }
        }

        return minOperations;
    }
}
