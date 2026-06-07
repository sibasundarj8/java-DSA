package Hashing;/*
 *
 * https://leetcode.com/problems/create-binary-tree-from-descriptions/
 *
 * # LC. 2196. Create Binary Tree From Descriptions
 *
 *   Q. You are given a 2D integer array descriptions where descriptions[i] = [parent-i, child-i, isLeft-i] indicates that
 *      parent-i is the parent of child-i in a binary tree of unique values. Furthermore,
 *
 *        ◦ If isLeft-i == 1, then child-i is the left child of parent-i.
 *        ◦ If isLeft-i == 0, then child-i is the right child of parent-i.
 *
 *      Construct the binary tree described by descriptions and return its root.
 *
 *    Ex.
 *      Input : descriptions = [[20, 15, 1],
 *                              [20, 17, 0],
 *                              [50, 20, 1],
 *                              [50, 80, 0],
 *                              [80, 19, 1]]
 *      Output: [50, 20, 80, 15, 17, 19]
 *      Explanation: The root node is the node with value 50 since it has no parent.
 *                   The resulting binary tree is shown in the diagram.
 *
 *  Constraints:
 *        ◦ 1 <= descriptions.length <= 10⁴
 *        ◦ descriptions[i].length == 3
 *        ◦ 1 <= parent-i, child-i <= 10⁵
 *        ◦ 0 <= isLeft-i <= 1
 *        ◦ The binary tree described by descriptions is valid.
 */

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;

public class Create_Binary_Tree_From_Descriptions {

    /// Structure
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        private void levelOrder() {
            TreeNode node = this;
            Queue<TreeNode> q = new ArrayDeque<>();
            q.add(node);

            while (!q.isEmpty()) {
                int len = q.size();

                for (int i = 0; i < len; i++) {
                    TreeNode cur = q.poll();
                    System.out.print(cur.val + " ");
                    if (cur.left != null) q.offer(cur.left);
                    if (cur.right != null) q.offer(cur.right);
                }

                System.out.println();
            }
        }
    }

    /// main Method
    public static void main(String[] args) {
        int[][] description = {
                {20, 15, 1},
                {20, 17, 0},
                {50, 20, 1},
                {50, 80, 0},
                {80, 19, 1}
        };

        TreeNode root = createBinaryTree(description);
        root.levelOrder();
    }

    /// Solution
    static TreeNode createBinaryTree(int[][] descriptions) {
        // potd.code.hub
        HashMap<Integer, TreeNode> map = new HashMap<>();
        HashSet<Integer> children = new HashSet<>();

        for (int[] description : descriptions) {
            TreeNode parent = map.computeIfAbsent(description[0], TreeNode::new);
            TreeNode child = map.computeIfAbsent(description[1], TreeNode::new);

            if (description[2] == 1) parent.left = child;
            else parent.right = child;

            children.add(description[1]);
        }

        for (Integer key : map.keySet()) {
            if (children.contains(key)) continue;
            return map.get(key);
        }

        return null;
    }
}
