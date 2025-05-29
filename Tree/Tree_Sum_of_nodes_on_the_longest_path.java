package Tree;/*
 *
 * https://www.geeksforgeeks.org/problems/sum-of-the-longest-bloodline-of-a-tree/1
 *
 * # Sum of nodes on the longest path
 *
 *   Q. Given a binary tree root[], you need to find the sum of the nodes on the longest path from the root to
 *      any leaf node. If two or more paths have the same length, the path with the maximum sum of node values
 *      should be considered.
 *   Ex.
 *      Input : root[] = [4, 2, 5, 7, 1, 2, 3, N, N, 6, N]
 *      Output: 13
 *      Explanation:               <4>
 *                                /   \
 *                              <2>    5
 *                              /\     /\
 *                             7 <1>  2  3
 *                                /
 *                              <6>
 *                  The highlighted nodes (4, 2, 1, 6) above are part of the longest root to leaf path having
 *                  sum = (4 + 2 + 1 + 6) = 13
 */

public class Tree_Sum_of_nodes_on_the_longest_path {

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
                new Node(4),
                new Node(2),
                new Node(5),
                new Node(7),
                new Node(1),
                new Node(2),
                new Node(3),
                new Node(6),
        };

        nodes[0].left = nodes[1];
        nodes[0].right = nodes[2];

        nodes[1].left = nodes[3];
        nodes[1].right = nodes[4];

        nodes[2].left = nodes[5];
        nodes[2].right = nodes[6];

        nodes[4].left = nodes[7];

        System.out.println("Sum of longest path: " + sumOfLongRootToLeafPath(nodes[0]));
    }

    /// Solution
    static int sumOfLongRootToLeafPath(Node root) {
        // potd.code.hub
        Pair ans = f(root);

        return ans.sum;
    }

    private static class Pair {
        int height;
        int sum;

        Pair(int height, int sum) {
            this.height = height;
            this.sum = sum;
        }
    }

    private static Pair f(Node root) {
        // base case
        if (root == null) return new Pair(0, 0);

        // recursive work
        Pair left = f(root.left);
        Pair right = f(root.right);

        // self work
        int sum, height;
        if (left.height == right.height) {
            height = left.height;
            sum = Math.max(left.sum, right.sum);
        } else if (left.height < right.height) {
            height = right.height;
            sum = right.sum;
        } else {
            height = left.height;
            sum = left.sum;
        }

        return new Pair(height + 1, sum + root.data);
    }
}
