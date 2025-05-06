package Tree;/*
 *
 * https://www.geeksforgeeks.org/problems/root-to-leaf-paths/1
 *
 * # Root to Leaf Paths
 *
 *   Q. Given a Binary Tree, you need to find all the possible paths from the root node to all the
 *      leaf nodes of the binary tree.
 *
 *      Note: The paths should be returned such that paths from the left subtree of any node are
 *            listed first, followed by paths from the right subtree.
 *    Ex.
 *      Input: root[] = [1, 2, 3, 4, 5, N, N]
 *                      (1)
 *                      / \
 *                    (2) (3)
 *                    / \
 *                  (4) (5)
 *      Output: [[1, 2, 4], [1, 2, 5], [1, 3]]
 *      Explanation: All the possible paths from root node to leaf nodes are:
 *                   1 -> 2 -> 4, 1 -> 2 -> 5 and 1 -> 3
 */

import java.util.ArrayList;
import java.util.Stack;

public class Tree_Root_to_Leaf_Paths {

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

        Node[] nodes = {new Node(1),
                        new Node(2),
                        new Node(3),
                        new Node(4),
                        new Node(5)};

        nodes[0].left = nodes[1];
        nodes[0].right = nodes[2];

        nodes[1].left = nodes[3];
        nodes[1].right = nodes[4];

        System.out.println("""
                        (1)
                        / \\
                      (2) (3)
                      / \\
                    (4) (5)
                """);

        System.out.println(Paths(nodes[0]));
    }

    /// Solution
    static ArrayList<ArrayList<Integer>> Paths(Node root) {
        // potd.code.hub
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        solve(root, ans, new Stack<>());

        return ans;
    }
    // helper
    private static void solve(Node root, ArrayList<ArrayList<Integer>> ans, Stack<Integer> stack) {
        if (root == null) return;
        // adding to the path
        stack.push(root.data);
        // leaf node
        if (root.left == null && root.right == null) {
            ans.add(new ArrayList<>(stack));
        } else { // non-leaf node
            solve(root.left, ans, stack);
            solve(root.right, ans, stack);
        }
        // removing from the path using backtracking
        stack.pop();
    }
}
