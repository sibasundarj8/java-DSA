package Heap;/*
 *
 * https://www.geeksforgeeks.org/problems/is-binary-tree-heap/1
 *
 * # Is Binary Tree Heap
 *
 *   Q. You are given a binary tree, and the task is to determine whether it satisfies the properties of a
 *      max-heap.
 *
 *      A binary tree is considered a max-heap if it satisfies the following conditions:
 *
 *          1. Completeness: Every level of the tree, except possibly the last, is filled, and all nodes are
 *                    as far left as possible.
 *          2. Max-Heap Property: The value of each node is greater than or equal to the values of its
 *                    children.
 *    Ex.
 *      Input: root[] = [97, 46, 37, 12, 3, 7, 31, N, 2, 4]
 *                                 (97)
 *                                /   \
 *                             (46)   (37)
 *                            /  \     / \
 *                         (12) (3)  (7) (31)
 *                              / \
 *                            (2) (4)
 *      Output: false
 *      Explanation: The tree is not complete and does not follow the Max-Heap Property, hence it is not a
 *                   max-heap.
 */

import java.util.LinkedList;
import java.util.Queue;

public class Heap_01_Is_Binary_Tree_Heap {

    /// Structure
    private static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    /// main Method
    public static void main(String[] args) {
        Node[] root = {new Node(97),
                new Node(46),
                new Node(37),
                new Node(12),
                new Node(3),
                new Node(7),
                new Node(31),
                null,
                new Node(2),
                new Node(4)};

        root[0].left = root[1];
        root[0].right = root[2];

        root[1].left = root[3];
        root[1].right = root[4];

        root[2].left = root[5];
        root[2].right = root[6];

        root[4].left = root[8];
        root[4].right = root[9];

        System.out.println("""
                Tree: \s
                         (97)
                        /   \\
                     (46)   (37)
                    /  \\     / \\
                 (12) (3)  (7) (31)
                      / \\
                    (2) (4)
                """);

        System.out.println("is max heap: " + isHeap(root[0]));
    }

    /// Solution
    static boolean isHeap(Node root) {
        // potd.code.hub
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        boolean flag = false;

        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node == null) {
                flag = true;
                continue;
            } else if (flag) {
                return false;
            }
            q.add(node.left);
            q.add(node.right);
            int l = (node.left != null) ? node.left.data : Integer.MIN_VALUE;
            int r = (node.right != null) ? node.right.data : Integer.MIN_VALUE;
            if ((node.data < l || node.data < r)) {
                return false;
            }
        }

        return true;
    }
}
