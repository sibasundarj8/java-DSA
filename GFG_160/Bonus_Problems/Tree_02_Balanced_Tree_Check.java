package GFG_160.Bonus_Problems;/*
 *
 * https://www.geeksforgeeks.org/problems/check-for-balanced-tree/1
 *
 * # Balanced Tree Check
 *
 *   Q. Given a binary tree, determine if it is height-balanced. A binary tree is considered height-balanced
 *      if the absolute difference in heights of the left and right subtrees is at most 1 for every node in
 *      the tree.
 *   Ex.
 *      Input : root[] = [10, 20, 30, 40, 60]
 *                                                 [10]
 *                                                /    \
 *                                             [20]    [30]
 *                                            /   \
 *                                         [40]  [60]
 *      Output: true
 *      Explanation: The height difference between the left and right subtrees at all nodes is at most 1.
 *                   Hence, the tree is balanced.
 */

public class Tree_02_Balanced_Tree_Check {

    /// Structure
    private static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
        }
    }

    /// main Method
    public static void main(String[] args) {
        Node[] nodes = {
                new Node(10),
                new Node(20),
                new Node(30),
                new Node(40),
                new Node(60),
        };

        nodes[0].left = nodes[1];
        nodes[0].right = nodes[2];

        nodes[1].left = nodes[3];
        nodes[1].right = nodes[4];

        System.out.println("Is tree balanced: " + isBalanced(nodes[0]));
    }

    ///  Solution
    static boolean isBalanced(Node root) {
        // potd.code.hub
        return chackHeight(root) > 0;
    }

    private static int chackHeight(Node root) {
        // base case
        if (root == null) return 0;

        // recursive work
        int left = chackHeight(root.left);
        int right = chackHeight(root.right);

        // self work
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) return -1;

        return Math.max(left, right) + 1;
    }
}
