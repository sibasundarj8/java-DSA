package GFG;/*
 *
 * https://www.geeksforgeeks.org/problems/maximum-difference-between-node-and-its-ancestor/1
 *
 * # Node and Ancestor Max Diff
 *
 *   Q. Given the root of a binary tree, find the maximum difference between an ancestor node A and
 *      its descendant node B, i.e., maximize A - B.
 *
 *    Ex.
 *      Input : root[] = [1, 2, 3, N, N, N, 7]          1
 *                                                     / \
 *                                                    2   3
 *                                                         \
 *                                                          7
 *      Output: -1
 *      Explanation: The maximum difference we can get is -1, which is between 1 and 2.
 *
 *  Constraints:
 *        ◦ 2 ≤ no. of nodes in root ≤ 10⁴
 *        ◦ 0 ≤ root.node->data ≤ 10⁵
 *        ◦ 2 ≤ Number of edges ≤ 10⁴
 */

public class POTD_Node_and_Ancestor_Max_Diff {

    /// Structure
    private static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

    /// main Method
    public static void main(String[] args) {
        Node[] nodes = {
                new Node(1),
                new Node(2),
                new Node(3),
                new Node(7),
        };

        nodes[0].left = nodes[1];
        nodes[0].right = nodes[2];
        nodes[2].right = nodes[3];

        System.out.print("""
                Tree:     1
                         / \\
                        2   3
                             \\
                              7
                Maximum difference between an ancestor and descendant:
                """);
        System.out.println(maxDiff(nodes[0]));
    }

    /// Solution
    private final static int MIN = (Integer.MIN_VALUE >> 1);

    static int maxDiff(Node root) {
        //  potd.code.hub
        return solve(root, MIN);
    }

    private static int solve(Node root, int maxAnc) {
        // base case
        if (root == null) return MIN;

        // recursive work
        int l = solve(root.left, Math.max(maxAnc, root.data));
        int r = solve(root.right, Math.max(maxAnc, root.data));

        // self work
        int diff = maxAnc - root.data;
        return Math.max(diff, Math.max(l, r));
    }
}
