package Tree;/*
 *
 * https://www.geeksforgeeks.org/problems/leaf-under-budget/1
 *
 * # Visit Leaves with Budget
 *
 *   Q. Given a binary tree and an integer k, where you start from the root at level 1. The cost of visiting a leaf
 *      node is equal to the level of that leaf node. You can visit any number of leaf nodes, but the total cost of
 *      visiting them must not exceed k.
 *
 *      Return the maximum number of leaf nodes that can be visited within the given budget.
 *
 *    Ex.
 *      Input : root[] = [10, 8, 2, 3, N, 3, 6, N, N, N, 4],
 *              k = 8                                          10
 *                                                            /  \
 *                                                           8    2
 *                                                          /    / \
 *                                                         3    3   6
 *      Output: 2                                                \
 *      Explanation:                                              4
 *                ◦ Cost For visiting Leaf Node 3: 3
 *                ◦ Cost For visiting Leaf Node 4: 4
 *                ◦ Cost For visiting Leaf Node 6: 3
 *
 *              To maximize the number of visited leaves, choose the two cheapest leaves: Cost = 3 + 3 = 6 ≤ 8.
 *              Thus, the maximum number of leaf nodes that can be visited is 2.
 *
 *  Constraints:
 *       ◦ 1 ≤ size of binary tree ≤ 10⁵
 *       ◦ 1 ≤ k ≤ 10⁴
 */

import java.util.ArrayDeque;
import java.util.Queue;

public class Tree_Visit_Leaves_with_Budget {

    /// Structure
    private static class Node {
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
        }
    }

    /// main Method
    public static void main(String[] args) {
        Node[] nodes = {
                new Node(10),
                new Node(8),
                new Node(2),
                new Node(3),
                new Node(3),
                new Node(6),
                new Node(4),
        };

        nodes[0].left = nodes[1];
        nodes[0].right = nodes[2];

        nodes[1].left = nodes[3];

        nodes[2].left = nodes[4];
        nodes[2].right = nodes[5];

        nodes[4].right = nodes[6];

        int k = 8;

        System.out.print("""
                    Tree:
                          10
                         /  \\
                        8    2
                       /    / \\
                      3    3   6
                            \\
                             4
                    Maximum number of leaf nodes can be visited within the given budget:
                    """);
        System.out.println(getCount(nodes[0], k));
    }

    /// Solution
    static int getCount(Node root, int k) {
        // potd.code.hub
        if (root == null) return 0;

        int depth = 1;
        int count = 0;
        Queue<Node> q = new ArrayDeque<>();

        q.offer(root);

        outer:
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Node curr = q.poll();

                if (k < depth) break outer;

                if (curr.left == null && curr.right == null) {
                    count++;
                    k -= depth;
                    continue;
                }

                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }

            depth++;
        }

        return count;
    }
}
