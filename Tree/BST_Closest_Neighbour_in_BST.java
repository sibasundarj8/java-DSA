package Tree;/*
 *
 * https://www.geeksforgeeks.org/problems/closest-neighbor-in-bst/1
 *
 * # Closest Neighbour in BST
 *
 *   Q. Given the root of a binary search tree and a number k, find the greatest number in the binary search tree
 *      that is less than or equal to k.
 *    Ex.
 *      Input : root = [10, 7, 15, 2, 8, 11, 16]
 *              k = 14
 *                             10
 *                            /  \
 *                           7    15
 *                          / \   / \
 *                         2   8 11 16
 *      Output: 11
 *      Explanation: The greatest element in the tree which is less than or equal to 14, is 11.
 */

public class BST_Closest_Neighbour_in_BST {

    /// Structure
    private static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    /// main Method
    public static void main(String[] args) {
        Node[] nodes = {
                new Node(10),
                new Node(7),
                new Node(15),
                new Node(2),
                new Node(8),
                new Node(11),
                new Node(16),
        };

        nodes[0].left = nodes[1];
        nodes[0].right = nodes[2];

        nodes[1].left = nodes[3];
        nodes[1].right = nodes[4];

        nodes[2].left = nodes[5];
        nodes[2].right = nodes[6];

        int k = 14;

        System.out.println("Max Fork: " + findMaxFork(nodes[0], k));
    }

    /// Solution
    static int findMaxFork(Node root, int k) {
        // potd.code.hub
        int ans = -1;

        Node temp = root;

        while (temp != null) {
            int data = temp.data;

            if (data == k) {
                return data;
            } else if (data < k) {
                ans = Math.max(ans, data);
                temp = temp.right;
            } else temp = temp.left;
        }

        return ans;
    }
}
