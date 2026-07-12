package Contest.weekly_510;/*
 *
 * https://leetcode.com/problems/minimum-total-cost-to-process-all-elements/
 *
 * # Q2. Minimum Total Cost to Process All Elements
 *
 *   Q. You are given an integer array nums and an integer k.
 *
 *      Initially, you have k units of resources.
 *
 *      You must process the elements of nums from left to right. To process the ith element, you need nums[i] resources.
 *
 *      If your available resources are less than nums[i], you may perform an operation that increases your available
 *      resources by k. The value of k is fixed and does not change throughout the process. The first such operation
 *      incurs a cost of 1, the second incurs a cost of 2, and so on.
 *
 *      After processing the ith element, your available resources decrease by nums[i].
 *
 *      Return an integer denoting the minimum total cost required to process all elements. Since the answer may be very
 *      large, return it modulo 109 + 7.
 *
 *    Ex.
 *      Input : nums = [1, 2, 3, 4], k = 4
 *      Output: 3
 *      Explanation:
 *            ◦ After processing nums[0], we have 4 - 1 = 3 units of resources left.
 *            ◦ After processing nums[1], we have 3 - 2 = 1 unit of resources left.
 *            ◦ Since nums[2] = 3 and only 1 unit of resources is available, we perform the first operation costing 1.
 *              After processing nums[2], we have 1 + 4 - 3 = 2 units of resources left.
 *            ◦ Since nums[3] = 4 and only 2 units of resources are available, we perform the second operation costing 2,
 *              to have 2 + 4 = 6 units of resources, which is enough to process nums[3].
 *            ◦ Thus, the total cost is 1 + 2 = 3.
 *
 *  Constraints:
 *      ◦ 1 <= nums.length <= 10⁵
 *      ◦ 1 <= nums[i] <= 10⁹
 *      ◦ 1 <= k <= 10⁹
 */

public class Q2_Minimum_Total_Cost_to_Process_All_Elements {

    /// Solution
    private static final int MOD = (int) (1e9 + 7);

    public int minimumCost(int[] nums, int k) {
        long sum = 0;

        for (int ele : nums) {
            sum += ele;
        }

        if (k >= sum) return 0;

        long inc = (sum - 1) / k;
        long t1 = inc % MOD;
        long t2 = (inc + 1) % MOD;

        // modular inverse of 2 is 500000004
        return (int) (((t1 * t2) % MOD * 500000004) % MOD);
    }
}