package Tree;/*
 *
 * https://www.geeksforgeeks.org/problems/check-whether-bst-contains-dead-end/1
 *
 * # BST with Dead End
 *
 *   Q. You are given a Binary Search Tree (BST) containing unique positive integers greater than 0.
 *
 *      Your task is to determine whether the BST contains a dead end.
 *
 *      Note: A dead end is a leaf node in the BST such that no new node can be inserted in the BST at or below
 *            this node while maintaining the BST property and the constraint that all node values must be > 0.
 *    Ex.
 *      Input : root[] = [8, 7, 10, 2, N, 9, 13]                8
 *                                                             / \
 *                                                            7  10
 *                                                           /   / \
 *                                                          2   9   13
 *      Output: true
 *      Explanation: Node 9 is a Dead End in the given BST.
 */

import java.util.HashSet;

public class Tree_BST_with_Dead_End {

    /// Structure
    private static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    /// main Method
    public static void main(String[] args) {
        Node[] nodes = {
                new Node(8),
                new Node(7),
                new Node(10),
                new Node(2),
                new Node(9),
                new Node(13)
        };

        nodes[0].left = nodes[1];
        nodes[0].right = nodes[2];

        nodes[1].left = nodes[3];

        nodes[2].left = nodes[4];
        nodes[2].right = nodes[5];

        System.out.println("Dead End present: " + isDeadEnd(nodes[0]));
    }

    /// Solution
/***************************************************<---using-Set--->***************************************************/
// TC: O(n)
// SC: O(h + h)
    static boolean isDeadEnd1(Node root) {
        // potd.code.hub
        HashSet<Integer> set = new HashSet<>();
        set.add(0);
        return f1(root, set);
    }

    private static boolean f1(Node node, HashSet<Integer> set) {
        // base case
        if (node == null) return false;
        if (node.left == null && node.right == null) {
            return set.contains(node.data - 1) && set.contains(node.data + 1);
        }

        // self work
        set.add(node.data);

        // recursive work
        boolean left = f1(node.left, set);
        boolean right = f1(node.right, set);

        // backtracking
        set.remove(node.data);

        return left || right;
    }

/************************************************<---space-optimized--->************************************************/
// TC: O(n)
// SC: O(h)
    static boolean isDeadEnd(Node root) {
        // potd.code.hub
        return f(root, 1, Integer.MAX_VALUE);
    }

    private static boolean f(Node node, int mini, int maxi) {
        // base case
        if (node == null) return false;
        if (node.left == null && node.right == null) return mini == maxi;

        // recursive work
        return f(node.left, mini, node.data - 1) || f(node.right, node.data + 1, maxi);
    }
}
