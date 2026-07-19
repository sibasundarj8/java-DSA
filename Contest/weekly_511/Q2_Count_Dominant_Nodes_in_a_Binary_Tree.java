package Contest.weekly_511;/*
 *
 * https://leetcode.com/contest/weekly-contest-511/problems/count-dominant-nodes-in-a-binary-tree/
 *
 * # Q2. Count Dominant Nodes in a Binary Tree
 *
 *   Q. You are given the root of a complete binary tree.
 *
 *      A node x is called dominant if its value is equal to the maximum value among all nodes in the subtree rooted
 *      at x.
 *
 *      Return the number of dominant nodes in the tree.
 *
 *    Ex.
 *      Input : root = [5,3,8,2,4,7,1]
 *      Output: 5
 *      Explanation:
 *              The leaf nodes with values 2, 4, 7, and 1 are dominant.
 *              The node with value 8 is dominant because its value is the maximum value in its subtree [8, 7, 1].
 *              Thus, the answer is 5.
 *
 *  Constraints:
 *        ◦ The number of nodes in the tree is in the range [1, 10⁵].
 *        ◦ 1 <= Node.val <= 10⁹
 *        ◦ The tree is guaranteed to be a complete binary tree.©leetcode
 */

public class Q2_Count_Dominant_Nodes_in_a_Binary_Tree {

    /// Structure
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /// Solution
    static int countDominantNodes(TreeNode root) {
        int[] count = new int[1];
        solve(root, count);

        return count[0];
    }

    private static int solve(TreeNode root, int[] count) {
        if (root == null) return Integer.MIN_VALUE;

        int left = solve(root.left, count);
        int right = solve(root.right, count);

        if (left <= root.val && right <= root.val) {
            count[0]++;
        }

        return Math.max(left, Math.max(root.val, right));
    }
}