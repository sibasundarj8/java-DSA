package GFG_160.Bonus_Problems;/*
 *
 * https://www.geeksforgeeks.org/problems/symmetric-tree/1
 *
 * # Symmetric Tree
 *
 *   Q. Given the root of a binary tree, check whether it is symmetric, i.e., whether the tree is a mirror
 *      image of itself.
 *
 *      A binary tree is symmetric if the left subtree is a mirror reflection of the right subtree.
 *
 *      Examples:
 *          Input: root[] = [1, 2, 2, 3, 4, 4, 3]
 *                                                          [1]
 *                                                         /   \
 *                                                      [2]    [2]
 *                                                     /  \    / \
 *                                                  [3]  [4] [4] [3]
 *          Output: True
 *          Explanation: As the left and right half of the above tree is mirror image, tree is symmetric.
 */

public class Tree_01_Symmetric_Tree {

    /// Structure
    private static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    /// main Method
    public static void main(String[] args) {
        Node[] nodes = {
                new Node(1),
                new Node(2),
                new Node(2),
                new Node(3),
                new Node(4),
                new Node(4),
                new Node(3),
        };

        nodes[0].left = nodes[1];
        nodes[0].right = nodes[2];

        nodes[1].left = nodes[3];
        nodes[1].right = nodes[4];

        nodes[2].left = nodes[5];
        nodes[2].right = nodes[6];

        System.out.println("Symmetric tree: " + isSymmetric(nodes[0]));
    }

    /// Solution
    static boolean isSymmetric(Node root) {
        if (root == null) return true;
        return f(root.left, root.right);
    }

    private static boolean f(Node root1, Node root2) {
        // base case
        if (root1 == root2) return true;
        if (root1 == null || root2 == null || root1.data != root2.data) return false;

        // recursive work
        return f(root1.left, root2.right) && f(root1.right, root2.left);
    }
}
