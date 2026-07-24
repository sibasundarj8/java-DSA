package Tree;/*
 *
 * https://www.geeksforgeeks.org/problems/longest-consecutive-sequence-in-binary-tree/1
 *
 * # Longest Consecutive Path in Binary tree
 *
 *   Q. Given the root of a Binary Tree, find the length of the longest path consisting of connected nodes such that
 *      each next node has a value exactly 1 greater than its parent.
 *
 *      The path must move from parent to child only and follow increasing consecutive values.
 *
 *      If no such path exists, return -1.
 *
 *    Ex.
 *      Input : root[] = [1, 2, 3]
 *                                     1
 *                                    / \
 *                                   2   3
 *      Output: 2
 *      Explanation : Longest sequence is 1, 2. So answer for this test case is 2.
 *
 *  Constraints:
 *       ◦ 1 ≤ no. of nodes in root ≤ 10⁵
 *       ◦ 1 ≤ root.node->data ≤ 10⁵
 */

public class Tree_Longest_Consecutive_Path_in_Binary_tree {

    /// Structure
    private static class Node {
        int data;
        Node left;
        Node right;

        Node(int d) {
            data = d;
        }
    }

    /// main Method
    public static void main(String[] args) {
        Node a = new Node(1);
        a.left = new Node(2);
        a.right = new Node(3);

        System.out.print("""
                Tree:
                    1
                   / \\
                  2   3
                Length of the longest path consisting of connected nodes such that
                each next node has a value exactly 1 greater than its parent :
                """);
        System.out.println(longestConsecutive(a));
    }

    /// Solution
    static int longestConsecutive(Node root) {
        // potd.code.hub
        int[] max = new int[]{1};

        if (root != null) {
            solve(root, 1, max);
        }

        return (max[0] == 1) ? -1 : max[0];
    }

    private static void solve(Node root, int count, int[] max) {
        // base case
        max[0] = Math.max(max[0], count);

        if (root.left != null)
            solve(root.left, (root.left.data - root.data == 1) ? count + 1 : 1, max);

        if (root.right != null)
            solve(root.right, (root.right.data - root.data == 1) ? count + 1 : 1, max);
    }
}
