package Tree;/*
 *
 * https://www.geeksforgeeks.org/problems/size-of-binary-tree/1
 *
 * # Size of Binary Tree
 *
 *   Q. Given the root of a binary tree, return the size of the tree. The size of a binary tree is the total number of
 *      nodes in the tree.
 *    Ex.
 *      Input :           5
 *                       / \
 *                      1   6
 *                     /   / \
 *                    3   7   4
 *      Output: 6
 *      Explanation: There are 6 nodes in the given binary tree, so its size is 6.
 *
 *  Constraints:
 *          1 ≤ number of nodes ≤ 10⁵
 *          1 ≤ node.data ≤ 10⁵
 */

public class Tree_Size_of_Binary_Tree {

    /// Structure
    private static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
        }
    }

    /// main Method
    public static void main(String[] args) {
        Node[] nodes = {
                new Node(5),
                new Node(1),
                new Node(6),
                new Node(3),
                new Node(7),
                new Node(4)
        };

        nodes[0].left = nodes[1];
        nodes[0].right = nodes[2];

        nodes[1].left = nodes[3];

        nodes[2].left = nodes[4];
        nodes[2].right = nodes[5];

        System.out.println("""
                Input:    5
                         / \\
                        1   6
                       /   / \\
                      3   7   4
                """);
        System.out.println("Size : " + getSize(nodes[0]));
    }

    /// Solution
    static int getSize(Node root) {
        // potd.code.hub
        if (root == null) return 0;
      
        // recursive work
        int l = getSize(root.left);
        int r = getSize(root.right);

        // self work
        return l + r + 1;
    }
}
