package GFG_160.Bonus_Problems;/*
 *
 * https://www.geeksforgeeks.org/problems/distribute-candies-in-a-binary-tree/1
 *
 * # Distribute candies in a binary tree
 *
 *   Q. You are given a binary tree with n nodes, where each node contains a certain number of candies,
 *      and the total number of candies across all nodes is n. In one move, we can select two adjacent
 *      nodes and transfer one candy from one node to the other. The transfer can occur between a parent
 *      and child in either direction.
 *
 *      The task is to determine the minimum number of moves required to ensure that every node in the tree
 *      has exactly one candy.
 *
 *      Note: The testcases are framed such that it is always possible to achieve a configuration in which
 *            every node has exactly one candy, after some moves.
 *    Ex.
 *      Input :                 3
 *                            /   \
 *                          0       0
 *                        /  \     / \
 *                       0    0   0   2
 *                           /
 *                          3
 *      Output: 8
 *
 *      Constraints:
 *          1 <= n <= 104
 *          0 <= Node->data <= n
 *          The sum of all Node->data is equal to n
 */

public class Tree_04_Distribute_candies_in_a_binary_tree {

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
                new Node(0),
                new Node(0),
                new Node(0),
                new Node(0),
                new Node(0),
                new Node(2),
                new Node(3),
        };

        nodes[0].left = nodes[1];
        nodes[0].right = nodes[2];

        nodes[1].left = nodes[3];
        nodes[1].right = nodes[4];

        nodes[2].left = nodes[5];
        nodes[2].right = nodes[6];

        nodes[4].left = nodes[7];

        System.out.println("Minimum move: " + distributeCandy(nodes[0]));
    }

    /// Solution
    static int distributeCandy(Node root) {
        // potd.code.hub
        Node temp = new Node(0);
        int[] mov = {0};

        f(root, temp, mov);

        return mov[0];
    }

    private static void f(Node cur, Node per, int[] mov) {
        // base case
        if (cur == null) return;

        // recursive work
        f(cur.left, cur, mov);
        f(cur.right, cur, mov);

        // self work
        if (cur.data < 1) {
            mov[0] += (1 - cur.data);
            per.data -= (1 - cur.data);
            cur.data = 1;
        }
        if (cur.data > 1) {
            mov[0] += cur.data - 1;
            per.data += cur.data - 1;
            cur.data = 1;
        }
    }
}
