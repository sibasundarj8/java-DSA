package Contest.weekly_514;/*
 *
 * https://leetcode.com/contest/weekly-contest-514/problems/weighted-sum-of-a-tree/
 *
 * # Q2. Weighted Sum of a Tree
 *
 *   Q. You are given an integer array parent of length n representing a rooted tree with nodes labeled from 0 to n - 1.
 *
 *      The tree is rooted at node 0, so parent[0] = -1. For each node i where 1 <= i <= n - 1, parent[i] denotes the
 *      parent of node i.
 *
 *      You are also given an integer array nums of length n, where nums[i] denotes the value of node i.
 *
 *      The weight of a node i at depth d is nums[i] * (h - d + 1), where h is the height of the tree.
 *
 *      Return the sum of the weights of all nodes in the tree.
 *
 *      The depth of a node is the number of nodes on the path from the root to that node, inclusive, with the root
 *      having depth 1.
 *
 *      The height of the tree is the maximum depth among all nodes in the tree.
 *
 *    Ex.                0
 *                     / | \
 *                    1  2  3
 *                      / \
 *                     4   5
 *      Input : parent = [-1, 0, 0, 0, 2, 2], nums = [5, 2, 3, 1, 4, 6]
 *      Output: 37
 *      Explanation:
 *              The height of the tree is 3.
 *                                       +=======+=========+=========+========================+
 *                                    --|| Node  | nums[i] |Depth (d)|         Weight         ||--
 *                                       +=======+=========+=========+========================+
 *                                       |   0   |    5    |    1    |  5 * (3 - 1 + 1) = 15  |
 *                                       +-------+---------+---------+------------------------+
 *                                       |   1   |    2    |    2    |  2 * (3 - 2 + 1) = 4   |
 *                                       +-------+---------+---------+------------------------+
 *                                       |   2   |    3    |    2    |  3 * (3 - 2 + 1) = 6   |
 *                                       +-------+---------+---------+------------------------+
 *                                       |   3   |    1    |    2    |  1 * (3 - 2 + 1) = 2   |
 *                                       +-------+---------+---------+------------------------+
 *                                       |   4   |    4    |    3    |  4 * (3 - 3 + 1) = 4   |
 *                                       +-------+---------+---------+------------------------+
 *                                       |   5   |    6    |    3    |  6 * (3 - 3 + 1) = 6   |
 *                                       +-------+---------+---------+------------------------+
 *              The sum of all node weights is 15 + 4 + 6 + 2 + 4 + 6 = 37.
 *
 *  Constraints:
 *        ◦ 1 <= n <= 10⁵
 *        ◦ n == parent.length == nums.length
 *        ◦ parent[0] == -1
 *        ◦ 0 <= parent[i] <= n - 1 for all i in [1, n - 1]
 *        ◦ 1 <= nums[i] <= 10⁶
 *        ◦ The input is generated such that the array parent represents a valid tree rooted at node 0.
 */

import java.util.Arrays;

public class Q2_Weighted_Sum_of_a_Tree {

    /// Solution
    public long weightedSum(int[] parent, int[] nums) {
        int n = parent.length;

        if (n == 1) return nums[0];

        parent[0] = 0;

        int[] depth = new int[n];
        int height = 0;
        Arrays.fill(depth, 1);

        for (int i = 1; i < n; i++) {
            if (depth[i] == 1) {
                dfs(i, parent, depth);
                height = Math.max(height, depth[i]);
            }
        }

        long res = 0;
        for (int i = 0; i < n; i++) {
            res += (nums[i] * (height - depth[i] + 1L));
        }

        return res;
    }

    private void dfs(int src, int[] parent, int[] depth) {
        // base case
        if (src == 0) return;
        if (depth[src] > 1) return;

        // recursive work
        dfs(parent[src], parent, depth);

        depth[src] += depth[parent[src]];
    }
}