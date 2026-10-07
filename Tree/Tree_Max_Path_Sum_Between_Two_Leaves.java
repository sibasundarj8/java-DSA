package Tree;/*
 *
 * https://www.geeksforgeeks.org/problems/maximum-path-sum/1
 *
 * # Max Path Sum Between Two Leaves
 *
 *   Q. Given the root of a binary tree, where each node contains an integer value, find the maximum possible path
 *      sum between any two leaf nodes. If the tree has fewer than two leaf nodes, return -1.
 *
 *    Ex.
 *      Input : root = [3, 4, 5, -10, 4, N, N]              3
 *                                                         / \
 *                                                        4   5
 *                                                       / \
 *                                                    -10   4
 *      Output: 16
 *      Explanation:
 *              The leaf nodes are -10, 4 (right child of 4), and 5.
 *              Possible paths between leaf nodes are:
 *              -10 -> 4 -> 3 -> 5 = -10 + 4 + 3 + 5 = 2
 *              -10 -> 4 -> 4 = -10 + 4 + 4 = -2
 *              4 -> 4 -> 3 -> 5 = 4 + 4 + 3 + 5 = 16
 *              Hence, the maximum path sum is obtained from the path 4 -> 4 -> 3 -> 5, giving 16.
 *
 *  Constraints:
 *        ◦ 0 ≤ size of binary tree ≤ 10⁴
 *        ◦ -10³ ≤ node.data ≤ 10³
 */

public class Tree_Max_Path_Sum_Between_Two_Leaves {

    /// Structure
    private static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    /// main Method
    public static void main(String[] args) {
        Node[] nodes = {
                new Node(3),
                new Node(4),
                new Node(5),
                new Node(-10),
                new Node(4),
        };

        nodes[0].left = nodes[1];
        nodes[0].right = nodes[2];

        nodes[1].left = nodes[3];
        nodes[1].right = nodes[4];

        System.out.print("""
                            Tree:    3
                                    / \\
                                   4   5
                                  / \\
                               -10   4
                            Maximum possible path sum between any two leaf nodes:
                            """);
        System.out.println(maxPathSum(nodes[0]));
    }

    /// Solution
    private static int pathSum;

    static int maxPathSum(Node root) {
        // potd.code.hub
        pathSum = Integer.MIN_VALUE;
        solve(root);

        return (pathSum == Integer.MIN_VALUE) ? -1 : pathSum;
    }

    private static int solve(Node root) {
        // base case
        if (root == null) return Integer.MIN_VALUE;
        if (root.left == null && root.right == null) {
            return root.data;
        }

        // recursive case
        int left = solve(root.left);
        int right = solve(root.right);

        // self work
        if (left != Integer.MIN_VALUE && right != Integer.MIN_VALUE) {
            pathSum = Math.max(pathSum, left + right + root.data);
        }

        return Math.max(left, right) + root.data;
    }
}
