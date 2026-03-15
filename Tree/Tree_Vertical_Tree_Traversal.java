package Tree;/*
 *
 * https://www.geeksforgeeks.org/problems/print-a-binary-tree-in-vertical-order/1
 *
 * # Vertical Tree Traversal
 *
 *   Q. Given the root of a Binary Tree, find the vertical traversal of the tree starting from the leftmost level to the
 *      rightmost level.
 *
 *      Note: If there are multiple nodes passing through a vertical line, then they should be printed as they appear in
 *            level order traversal of the tree.
 *    Ex.
 *      Input : root = [1, 2, 3, 4, 5, 6, 7, N, N, N, 8, N, 9, N, 10, 11, N]
 *
 *                                1
 *                              /   \
 *                             2      3
 *                            / \    / \
 *                           4   5  6   7
 *                                \  \   \
 *                                 8  9   10
 *                                /
 *                               11
 *      Output: [[4],
 *               [2],
 *               [1, 5, 6, 11],
 *               [3, 8, 9],
 *               [7],
 *               [10]]
 *      Explanation: The below image shows the horizontal distances used to print vertical traversal starting from the
 *                   leftmost level to the rightmost level.
 *
 *               Columns: -2 -1  0   1  2  3
 *                         |  |  |   |  |  |
 *                         |     1      |  |
 *                         |   /    \   |  |
 *                            2      3     |
 *                          /  \    /  \   |
 *                         4    5  6    7  |
 *                                \  \   \
 *                                  8 9   10
 *                                /
 *                               11
 *
 *  Constraints:
 *          1 ≤ number of nodes ≤ 10⁵
 *          1 ≤ node -> data ≤ 10⁵
 */

import java.util.*;

public class Tree_Vertical_Tree_Traversal {

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
                new Node(1),
                new Node(2),
                new Node(3),
                new Node(4),
                new Node(5),
                new Node(6),
                new Node(7),
                new Node(8),
                new Node(9),
                new Node(10),
                new Node(11)
        };

        nodes[0].left = nodes[1];
        nodes[0].right = nodes[2];

        nodes[1].left = nodes[3];
        nodes[1].right = nodes[4];

        nodes[2].left = nodes[5];
        nodes[2].right = nodes[6];

        nodes[4].right = nodes[7];

        nodes[5].right = nodes[8];

        nodes[6].right = nodes[9];

        nodes[7].left = nodes[10];

        System.out.println("""
                                1
                              /   \\
                            2       3
                           / \\     / \\
                          4   5   6   7
                               \\   \\   \\
                                8   9   10
                               /
                              11
                
                Vertical order traversal of tree is:
                """);
        System.out.println(verticalOrder(nodes[0]));
    }

    /// Solution
    static ArrayList<ArrayList<Integer>> verticalOrder(Node root) {
        if (root == null) return new ArrayList<>();

        int[] range = new int[2];
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(0, root));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int col = p.col();
            Node curr = p.node();

            map.computeIfAbsent(col, k -> new ArrayList<>()).add(curr.data);
            range[0] = Math.min(range[0], col);
            range[1] = Math.max(range[1], col);

            if (curr.left != null) q.add(new Pair(col - 1, curr.left));
            if (curr.right != null) q.add(new Pair(col + 1, curr.right));
        }

        for (int i = range[0]; i <= range[1]; i++)
            res.add(map.get(i));

        return res;
    }

    private record Pair(int col, Node node) {}
}
