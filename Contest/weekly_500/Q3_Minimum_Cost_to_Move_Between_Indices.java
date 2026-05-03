package Contest.weekly_500;/*
 *
 * https://leetcode.com/problems/minimum-cost-to-move-between-indices/
 *
 * # Q3. Minimum Cost to Move Between Indices
 *
 *   Q. You are given an integer array nums where nums is strictly increasing.
 *
 *      For each index x, let closest(x) be the adjacent index such that abs(nums[x] - nums[y]) is minimized. If both adjacent
 *      indices exist and give the same difference, choose the smaller index.
 *
 *      From any index x, you can move in two ways:
 *        ◦ To any index y with cost abs(nums[x] - nums[y]), or
 *        ◦ To closest(x) with cost 1.
 *
 *      You are also given a 2D integer array queries, where each queries[i] = [li, ri].
 *
 *      For each query, calculate the minimum total cost to move from index li to index ri.
 *
 *      Return an integer array ans, where ans[i] is the answer for the ith query.
 *
 *      An array is said to be strictly increasing if each element is strictly greater than its previous one.
 *
 *      The absolute difference between two values x and y is defined as abs(x - y).
 *
 *    Ex.
 *      Input : nums = [-5,-2,3], queries = [[0,2],[2,0],[1,2]]
 *      Output: [6,2,5]
 *      Explanation:
 *              The closest indices are [1, 0, 1] respectively.
 *
 *              For [0, 2], the path 0 → 1 → 2 uses the closest move from index 0 to 1 with cost 1 and a move from index 1
 *              to 2 with cost |-2 - 3| = 5, giving total 1 + 5 = 6.
 *
 *              For [2, 0], the path 2 → 1 → 0 uses two closest moves from index 2 to 1 and from index 1 to 0, each with
 *              cost 1, giving total 2.
 *
 *              For [1, 2], the direct move from index 1 to index 2 has cost |-2 - 3| = 5, which is optimal.
 *
 *              Thus, ans = [6, 2, 5].
 *
 *  Constraints:
 *          2 <= nums.length <= 10⁵
 *          -10⁹ <= nums[i] <= 10⁹
 *          nums is strictly increasing
 *          1 <= queries.length <= 10⁵
 *          queries[i] = [li, ri]
 *          0 <= li, ri < nums.length
 */

public class Q3_Minimum_Cost_to_Move_Between_Indices {

    /// Solution
    public int[] minCost(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;

        int[] closet = new int[n];
        int[] costLeft = new int[n];
        int[] costRight = new int[n];
        int[] res = new int[m];

        for (int i = 1; i < n - 1; i++) {
            int left = nums[i] - nums[i - 1];
            int right = nums[i + 1] - nums[i];
            closet[i] = (left > right) ? i + 1 : i - 1;
        }
        closet[0] = 1;
        closet[n - 1] = n - 2;

        // cost calculation
        for (int i = 0; i < n - 1; i++) {
            if (closet[i] == i + 1) costRight[i + 1] = 1;
            else costRight[i + 1] = nums[i + 1] - nums[i];
        }

        for (int i = n - 1; i > 0; i--) {
            if (closet[i] == i - 1) costLeft[i - 1] = 1;
            else costLeft[i - 1] = nums[i] - nums[i - 1];
        }

        // prefix
        for (int i = 1; i < n; i++) {
            costRight[i] += costRight[i - 1];
        }

        for (int i = n - 2; i >= 0; i--) {
            costLeft[i] += costLeft[i + 1];
        }

        // queries
        for (int i = 0; i < m; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            if (l < r) {
                res[i] = costRight[r] - costRight[l];
            } else {
                res[i] = costLeft[r] - costLeft[l];
            }
        }

        return res;
    }
}
