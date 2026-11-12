package Tree;/*
 *
 * https://www.geeksforgeeks.org/problems/find-the-closest-element-in-bst/1
 *
 * # Closest in BST
 *
 *   Q. Given root of a Binary Search Tree (BST) and an integer k, find the minimum absolute difference between
 *      k and the value of any node in the BST.
 *
 *    Ex.
 *      Input: root = [10, 2, 11, 1, 5, N, N, N, N, 3, 6, N, 4], k = 13
 *                                                                                 10
 *                                                                                /  \
 *                                                                               2   11
 *                                                                              / \
 *                                                                             1   5
 *                                                                                / \
 *                                                                               3   6
 *                                                                                \
 *                                                                                 4
 *      Output: 2
 *      Explanation: The node with value 11 is closest to k = 13.
 *                   So, the minimum absolute difference is |11 - 13| = 2.
 *
 *
 */

public class Tree_Closest_in_BST {

    /// Structure
    private static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    /// main Method
    public static void main(String[] args) {
        Node[] nodes = {
                new Node(10),
                new Node(2),
                new Node(11),
                new Node(1),
                new Node(5),
                new Node(3),
                new Node(6),
                new Node(4),
        };

        nodes[0].left = nodes[1];
        nodes[0].right = nodes[2];

        nodes[1].left = nodes[3];
        nodes[1].right = nodes[4];

        nodes[4].left = nodes[5];
        nodes[4].right = nodes[6];

        nodes[5].right = nodes[7];

        System.out.print("""
                Given tree:
                          10
                         /  \\
                        2   11
                       / \\
                      1   5
                         / \\
                        3   6
                         \\
                          4
                Minimum absolute difference for k = 13
                """);
        System.out.println(minDiff(nodes[0], 13));
    }

    /// Solution
    static int minDiff(Node root, int k) {
        // base case
        if (root == null) return Integer.MAX_VALUE;
        if (root.data == k) return 0;

        // recursive work
        if (root.data > k) {
            return Math.min(root.data - k, minDiff(root.left, k));
        } else {
            return Math.min(k - root.data, minDiff(root.right, k));
        }
    }
}
