package Tree;/*
 *
 * https://www.geeksforgeeks.org/problems/k-sum-paths/1
 *
 * # K Sum Paths
 *
 *   Q. Given the root of a binary tree and an integer k, determine the number of downward-only paths where the sum of the
 *      node values in the path equals k.
 *
 *      Note: A path can start and end at any node within the tree but must always move downward (from parent to child).
 *    Ex.
 *      Input:
 *              root = [8, 4, 5, 3, 2, N, 2, 3, -2, N, 1]
 *              k = 7
 *                                              8
 *                                             / \
 *                                            4   5
 *                                           / \   \
 *                                          3   2   2
 *                                         / \   \
 *                                        3  -2   1
 *      Output: 3
 *      Explanation:
 *              The following paths sum to k
 *              Path 1: 4 + 3 = 7
 *                                        4
 *                                       /
 *                                      3
 *              Path 2: 4 + 2 + 1 = 7
 *                                      4
 *                                       \
 *                                        2
 *                                         \
 *                                          1
 *              Path 3: 5 + 2 = 7
 *                                      5
 *                                       \
 *                                        2
 *
 *  Constraints:
 *      1 ≤ number of nodes ≤ 10⁴
 *      -100 ≤ node value ≤ 100
 *      -10⁹ ≤ k ≤ 10⁹
 */

import javax.swing.*;
import java.util.HashMap;

public class Tree_K_Sum_Paths {

    /// Structure
    private static class Node {
        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
        }
    }

    /// main Method
    public static void main(String[] args) {
        Node[] nodes = {
                new Node(8),
                new Node(4),
                new Node(5),
                new Node(3),
                new Node(2),
                new Node(2),
                new Node(3),
                new Node(-2),
                new Node(1),
        };

        nodes[0].left = nodes[1];
        nodes[0].right = nodes[2];

        nodes[1].left = nodes[3];
        nodes[1].right = nodes[4];

        nodes[2].right = nodes[5];

        nodes[3].left = nodes[6];
        nodes[3].right = nodes[7];

        nodes[4].right = nodes[8];

        int k = 7;

        System.out.println("Number of paths with sum " + k + " : ");
        System.out.println(countAllPaths(nodes[0], k));
    }

    /// Solution
    static int countAllPaths(Node root, int k) {
        int[] count = new int[1];
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        countPaths(root, k, 0, map, count);

        return count[0];
    }

    private static void countPaths(Node root, int k, int sum, HashMap<Integer, Integer> map, int[] count) {
        // base case
        if (root == null) return;

        // self work
        int prefix = sum + root.data;
        count[0] += map.getOrDefault(prefix - k, 0);
        map.put(prefix, map.getOrDefault(prefix, 0) + 1);

        // recursive case
        countPaths(root.left, k, prefix, map, count);
        countPaths(root.right, k, prefix, map, count);

        // backtrack
        if (map.get(prefix) > 1) map.put(prefix, map.get(prefix) - 1);
        else map.remove(prefix);
    }
}
