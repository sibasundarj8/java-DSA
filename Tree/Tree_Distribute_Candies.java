package Tree;/*
 *
 * https://www.geeksforgeeks.org/problems/distribute-candies-in-a-binary-tree/1
 *
 * # Distribute Candies
 *
 *   Q. You are given the root of a binary tree with n nodes, where each node contains a certain number of candies, and the
 *      total number of candies across all nodes is n. In one move, you can select any two adjacent nodes and transfer one
 *      candy from one node to the other. The transfer can occur between a parent and child in either direction.
 *
 *      The task is to determine the minimum number of moves required to ensure that every node in the tree has exactly one
 *      candy.
 *
 *      Note: The testcases are framed such that it is always possible to achieve a configuration in which every node has
 *            exactly one candy, after some moves.
 *    Ex.
 *      Input : root = [2, 0, 0, N, N, 3, 0]
 *                                               2
 *                                              / \
 *                                             0   0
 *                                                / \
 *                                               3   0
 *      Output: 4
 *      Explanation:
 *              Move 1 candy from root to left child
 *              Move 1 candy from root->right->left node to root->right node
 *              Move 1 candy from root->right node to root->right->right node
 *              Move 1 candy from root->right->left node to root->right node
 *              so, total 4 moves required.
 *
 *  Constraints:
 *          1 ≤ n ≤ 3 * 10³
 *          0 ≤ Node.data ≤ n
 *          The sum of all Node.data = n
 */

public class Tree_Distribute_Candies {

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
                new Node(2),
                new Node(0),
                new Node(0),
                new Node(3),
                new Node(0)
        };

        nodes[0].left = nodes[1];
        nodes[0].right = nodes[2];

        nodes[2].left = nodes[3];
        nodes[2].right = nodes[4];

        System.out.println("The minimum number of moves required to ensure that every node in the tree has exactly one candy is :");
        System.out.println(distCandy(nodes[0]));
    }

    /// Solution
    static int distCandy(Node root) {
        int[] moves = new int[1];

        dfs(root, moves);

        return moves[0];
    }

    private static int dfs(Node root, int[] moves) {
        // base case
        if (root == null) return 0;

        // recursive work
        int leftBalance = dfs(root.left, moves);    // cost to balance left side
        int rightBalance = dfs(root.right, moves);  // cost to balance right side

        // self work
        int move = root.data + leftBalance + rightBalance - 1;
        moves[0] += Math.abs(move);

        return move;
    }
}
