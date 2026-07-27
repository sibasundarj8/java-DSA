package Tree;/*
 *
 * https://www.geeksforgeeks.org/problems/construct-a-full-binary-tree--170648/1
 *
 * # Construct a Full Binary Tree
 *
 *   Q. Given two arrays pre[] and preMirror[] of size n containing unique elements, where pre[] represents the preorder
 *      traversal of a full binary tree and preMirror[] represents the preorder traversal of its mirror tree, construct
 *      the original full binary tree using these traversals.
 *
 *      Note: A general binary tree cannot be uniquely constructed using these two traversals. However, a full binary
 *            tree can be constructed uniquely from the given traversals without any ambiguity.
 *
 *    Ex.
 *      Input : pre[] = [1, 2, 4, 5, 3, 6, 7],
 *              preMirror[] = [1, 3, 7, 6, 2, 5, 4]
 *      Output: [1, 2, 4, 5, 3, 6, 7]
 *      Explanation: The tree will look like
 *                                               1
 *                                             /   \
 *                                            2     3
 *                                           / \   / \
 *                                          4   5 6   7
 *  Constraints:
 *        ◦ 1 ≤ pre.size() ≤ 10⁵
 *        ◦ 0 ≤ pre[i] ≤ 10⁹
 *        ◦ 1 ≤ preMirror.size() ≤ 10⁵
 *        ◦ 0 ≤ preMirror[i] ≤ 10⁹
 */

import java.util.HashMap;
import java.util.Map;

public class Tree_Construct_a_Full_Binary_Tree {

    /// Structure
    private static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }

        static void preOrder(Node root) {
            if (root == null) return;
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }

        static void preMirror(Node root) {
            if (root == null) return;
            System.out.print(root.data + " ");
            preMirror(root.right);
            preMirror(root.left);
        }
    }

    /// main Method
    public static void main(String[] args) {
        int[] preOrder = {1, 2, 4, 5, 3, 6, 7};
        int[] preMirror = {1, 3, 7, 6, 2, 5, 4};
        Node root = constructBinaryTree(preOrder, preMirror);

        System.out.print("Pre-order of constructed tree: ");
        Node.preOrder(root);
        System.out.println();
        System.out.print("Pre-Mirror of constructed tree: ");
        Node.preMirror(root);
        System.out.println();
    }

    /// Solution
    static Node constructBinaryTree(int[] pre, int[] preMirror) {
        // potd.code.hub
        int n = pre.length;
        Map<Integer, Integer> preMirrorIdx = new HashMap<>();

        for (int i = 0; i < n; i++) {
            preMirrorIdx.put(preMirror[i], i);
        }

        return build(0, n - 1, pre, preMirrorIdx);
    }

    private static Node build(int i, int j, int[] pre, Map<Integer, Integer> preMirrorIdx) {
        // base case
        if (i == j) {
            return new Node(pre[i]);
        }

        // recursive case
        int m = j - (preMirrorIdx.get(pre[i + 1]) - preMirrorIdx.get(pre[i]) - 1) + 1;
        Node left = build(i + 1, m - 1, pre, preMirrorIdx);
        Node right = build(m, j, pre, preMirrorIdx);

        // self work
        Node root = new Node(pre[i]);
        root.left = left;
        root.right = right;
        return root;
    }
}
