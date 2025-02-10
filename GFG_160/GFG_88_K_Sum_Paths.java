package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/k-sum-paths/1
 *
 * # K Sum Paths
 *
 *   Q. Given a binary tree and an integer k, determine the number of downward-only paths where the sum of
 *      the node values in the path equals k. A path can start and end at any node within the tree but must
 *      always move downward (from parent to child).
 *    Ex.
 *      Input : k = 7
 *                       8
 *                      / \
 *                     4   5
 *                    / \   \
 *                   3   2   2
 *                  / \   \
 *                 3  -2   1
 *      Output: 3
 *      Explanation: The following paths sum to k
 *                       8
 *                      / \
 *                    (4)   5
 *                    / \   \
 *                  (3)   2   2
 *                  / \   \
 *                 3  -2   1
 *
 *                       8
 *                      / \
 *                    (4)  5
 *                    / \   \
 *                   3  (2)  2
 *                  / \   \
 *                 3  -2  (1)
 *
 *                       8
 *                      / \
 *                     4  (5)
 *                    / \   \
 *                   3   2  (2)
 *                  / \   \
 *                 3  -2   1
 */

import java.util.HashMap;

public class GFG_88_K_Sum_Paths {

    /// Structure
    private static class Node{
        int data;
        Node left, right;
        Node(int data){
            this.data = data;
        }
    }

    /// main Method
    public static void main(String[] args) {
        Node[] node = {new Node(8),
                       new Node(4),
                       new Node(5),
                       new Node(3),
                       new Node(2),
                       new Node(2),
                       new Node(3),
                       new Node(-2),
                       new Node(1)};
        node[0].left = node[1];
        node[0].right = node[2];

        node[1].left = node[3];
        node[1].right = node[4];

        node[2].right = node[5];

        node[3].left = node[6];
        node[3].right = node[7];

        node[4].right = node[8];

        int k = 7;

        System.out.println(sumK(node[0], k));
    }

    /// Solution
    static int sumK(Node root, int k) {
        // potd.code.hub
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int[] ans = {0};
        find(root, k, map, 0, ans);

        return ans[0];
    }
    private static void find(Node root, int k, HashMap<Integer, Integer> map, int sum, int[]ans){
        // base case
        if (root == null) return;
        // self work
        sum += root.data;
        if (map.containsKey(sum - k)) ans[0] += map.get(sum-k);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        // recursive work
        find(root.left, k, map, sum, ans);
        find(root.right, k, map, sum, ans);
        // backtracking
        if (map.get(sum) > 1) map.put(sum, map.get(sum) - 1);
        else map.remove(sum);
    }
}
