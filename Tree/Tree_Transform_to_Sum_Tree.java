package Tree;/*
 *
 * https://www.geeksforgeeks.org/problems/transform-to-sum-tree/1
 *
 * # Transform to Sum Tree
 *
 *   Q. Given a root of a binary tree with n nodes, where each node may contain positive or negative values, convert it into
 *      a tree such that each node’s new value is equal to the sum of all values in its left and right subtrees (based on
 *      the original tree). For leaf nodes, update their values to 0.
 *
 *    Ex.
 *      Input : root = [10, -2, 6, 8, -4, 7, 5]      10
 *                                                  /  \
 *                                                -2    6
 *                                                / \   / \
 *                                               8  -4 7   5
 *      Output:            20
 *                        /  \
 *                       4    12
 *                      / \   / \
 *                     0   0 0   0
 *      Explanation:
 *            ◦ Leaf nodes update: The leaf nodes 8, -4, 7, 5 are changed to 0 since they have no children.
 *            ◦ Update internal nodes: Left child: 8 + (-4) = 4
 *            ◦ Right child: 7 + 5 = 12
 *            ◦ Update root node: Root = sum of left and right subtree values = 4 + 12 = 20
 *
 *                  20
 *                /    \            Where:
 *               4      12          4  = 8 + (-4)
 *             /  \    /  \         12 = 7 + 5
 *            0    0  0    0        20 = 4 + (-2) + 12 + 6
 *
 *  Constraints:
 *      1 ≤ n ≤ 10⁴
 */

import java.util.LinkedList;
import java.util.Queue;

public class Tree_Transform_to_Sum_Tree {

    /// Structure
    private static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }

        static void printLevelOrder(Node root) {
            if (root == null) return;

            Queue<Node> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                int size = queue.size();

                for (int i = 0; i < size; i++) {
                    Node node = queue.poll();
                    String s = (node == null) ? "N " : String.valueOf(node.data) + " ";
                    System.out.print(s);

                    if (node != null) {
                        queue.add(node.left);
                        queue.add(node.right);
                    }
                }

                System.out.println();
            }

            System.out.println();
        }
    }

    /// main Method
    public static void main(String[] args) {

        // Create all nodes
        Node[] nodes = {
                new Node(10),   // 0
                new Node(-2),   // 1
                new Node(6),    // 2
                new Node(8),    // 3
                new Node(-4),   // 4
                new Node(7),    // 5
                new Node(5)     // 6
        };

        // Build tree connections
        nodes[0].left = nodes[1];
        nodes[0].right = nodes[2];

        nodes[1].left = nodes[3];
        nodes[1].right = nodes[4];

        nodes[2].left = nodes[5];
        nodes[2].right = nodes[6];

        System.out.print("""
                Given tree:
                                    10
                                   /  \\
                                 -2    6
                                / \\    / \\
                               8  -4  7   5
                
                Level order traversal of this tree:
                """);
        Node.printLevelOrder(nodes[0]);

        toSumTree(nodes[0]);

        System.out.println("Level order traversal of sum tree:");
        Node.printLevelOrder(nodes[0]);
    }

    /// Solution
    static void toSumTree(Node root) {
        // potd.code.hub
        solve(root);
    }

    private static int solve(Node root) {
        // base case
        if (root == null) return 0;

        // recursive work
        int leftSum = solve(root.left);
        int rightSum = solve(root.right);

        // self work
        int temp = leftSum + rightSum + root.data;
        root.data = leftSum + rightSum;
        return temp;
    }
}
