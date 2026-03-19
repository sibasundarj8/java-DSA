package Tree;/*
 *
 * https://www.geeksforgeeks.org/problems/largest-bst/1
 *
 * # Largest BST
 *
 *   Q. You're given a binary tree. Your task is to find the size of the largest subtree within this binary tree that also
 *      satisfies the properties of a Binary Search Tree (BST). The size of a subtree is defined as the number of nodes it
 *      contains.
 *
 *      Note: A subtree of the binary tree is considered a BST if for every node in that subtree, the left child is less
 *            than the node, and the right child is greater than the node, without any duplicate values in the subtree.
 *    Ex.
 *      Input : root = [5, 2, 4, 1, 3]            5
 *                                               / \
 *                                              /   \
 *                                             2     4
 *                                            / \
 *                                           /   \
 *                                          1     3
 *      Output: 3
 *      Explanation: The following subtree is a BST of size 3            2
 *                                                                      / \
 *                                                                     /   \
 *                                                                    1     3
 *
 *  Constraints:
 *          1 ≤ number of nodes ≤ 10⁵
 *          1 ≤ node.data ≤ 10⁵
 */

import java.util.HashMap;

public class Tree_Largest_BST {

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
                new Node(5),
                new Node(2),
                new Node(4),
                new Node(1),
                new Node(3)
        };

        nodes[0].left = nodes[1];
        nodes[0].right = nodes[2];

        nodes[1].left = nodes[3];
        nodes[1].right = nodes[4];


        Node[] root = {
                new Node(1), // 0
                new Node(3), // 1
                new Node(4), // 2
                new Node(5), // 3
                null,             // 4 (N)
                new Node(2), // 5
                new Node(2), // 6
                new Node(3)  // 7
        };

        System.out.println("Number of nodes in largest BST : ");
        System.out.println(largestBst(nodes[0]));
    }

    /// Solution
/*
✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔-Top-Down-(Memoization)-✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔
TC : O(N)
SC : O(N)
*/
    // Return the size of the largest subtree which is also a BST
    static int memoization(Node root) {
        // potd.code.hub
        int[] maxBstSize = new int[1];
        HashMap<Node, Pair_1> map = new HashMap<>();

        preOrder(root, maxBstSize, map);

        return maxBstSize[0];
    }

    private record Pair_1(boolean isBST, int min, int max, int size) {
    }

    private static void preOrder(Node root, int[] maxSize, HashMap<Node, Pair_1> map) {
        // base case
        if (root == null) return;

        // self work
        Pair_1 pairM = isBST(root, map);

        if (pairM.isBST) {
            maxSize[0] = Math.max(maxSize[0], pairM.size);
        } else {
            // recursive case
            preOrder(root.left, maxSize, map);
            preOrder(root.right, maxSize, map);
        }
    }

    // in-order traversal to check whether it is a BST or not.
    // it returns isBST: true, min: minElement, max: maxElement, size: size of BST is it is valid.
    private static Pair_1 isBST(Node root, HashMap<Node, Pair_1> map) {
        // base case
        if (root == null) return new Pair_1(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        if (root.left == null && root.right == null)
            return map.computeIfAbsent(root, k -> new Pair_1(true, root.data, root.data, 1));
        if (map.containsKey(root)) return map.get(root);

        // recursive case
        Pair_1 left = isBST(root.left, map);
        Pair_1 right = isBST(root.right, map);

        // self work
        Pair_1 pair;
        if (left.isBST && right.isBST && left.max < root.data && root.data < right.min) {
            int min = Math.min(left.min, root.data);
            int max = Math.max(right.max, root.data);
            pair = new Pair_1(true, min, max, left.size + right.size + 1);
        } else pair = new Pair_1(false, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);

        return map.computeIfAbsent(root, k -> pair);
    }

    /*
    ✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔-Bottom-Up-(DP)-✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔
    TC : O(N)
    SC : O(h) --> depth of the tree.
    */
    static int largestBst(Node root) {
        int[] maxBstSize = new int[1];
        postOrder(root, maxBstSize);

        return maxBstSize[0];
    }

    private record Pair(boolean isBST, int min, int max, int size) {
    }

    private static Pair postOrder(Node root, int[] maxSize) {
        // base case
        if (root == null) return new Pair(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);

        // recursive case
        Pair left = postOrder(root.left, maxSize);
        Pair right = postOrder(root.right, maxSize);

        // self work
        if (left.isBST && right.isBST && left.max < root.data && root.data < right.min) {
            int size = left.size + right.size + 1;
            int min = Math.min(root.data, left.min);
            int max = Math.max(root.data, right.max);
            maxSize[0] = Math.max(maxSize[0], size);

            return new Pair(true, min, max, size);
        }

        return new Pair(false, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
    }
}
