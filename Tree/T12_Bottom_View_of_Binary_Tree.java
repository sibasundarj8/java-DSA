package Tree;/*
 *
 * https://www.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1
 *
 * # Bottom View of Binary Tree
 *
 *   Q. You are given the root of a binary tree, and your task is to return its bottom view. The bottom view
 *      of a binary tree is the set of nodes visible when the tree is viewed from the bottom.
 *
 *      Note: If there are multiple bottom-most nodes for a horizontal distance from the root, then the latter
 *            one in the level order traversal is considered.
 *    Ex.
 *      Input : root = [20, 8, 22, 5, 3, 4, 25, N, N, 10, 14, N, N, 28, N]
 *                                                                                     20
 *                                                                                   /    \
 *                                                                                 8        22
 *                                                                               /   \     /   \
 *                                                                              5     3   4     25
 *                                                                                   / \         \
 *                                                                                 10  14         28
 *      Output: [5, 10, 4, 28, 25]
 *      Explanation: The Green nodes represent the bottom view of below binary tree.
 *                                                                                     20(0)
 *                                                                                   /       \
 *                                                                              8(-1)         22(1)
 *                                                                             /     \       /     \
 *                                                                         5(-2)    3(0)   4(0)    25(2)
 *                                                                                 /   \             \
 *                                                                             10(-1) 14(1)          28(1)
 *  Constraints:
 *      1 ≤ number of nodes ≤ 10⁵
 *      1 ≤ node->data ≤ 10⁵
 */


import java.util.*;

public class T12_Bottom_View_of_Binary_Tree {

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
                new Node(20),
                new Node(8),
                new Node(22),
                new Node(5),
                new Node(3),
                new Node(4),
                new Node(25),
                new Node(10),
                new Node(14),
                new Node(28),
        };

        nodes[0].left = nodes[1];
        nodes[0].right = nodes[2];

        nodes[1].left = nodes[3];
        nodes[1].right = nodes[4];

        nodes[2].left = nodes[5];
        nodes[2].right = nodes[6];

        nodes[4].left = nodes[7];
        nodes[4].right = nodes[8];

        nodes[6].left = nodes[9];

        System.out.println("Bottom view is : ");
        System.out.println(bottomView(nodes[0]));
    }

    /// Solution
    static ArrayList<Integer> bottomView(Node root) {
        // potd.code.hub
        ArrayList<Integer> bottomView = new ArrayList<>();
        Map<Integer, Integer> colMap = new HashMap<>();
        int[] temp = levelOrder(root, colMap);

        for (int i = temp[0]; i <= temp[1]; i++)
            bottomView.add(colMap.get(i));

        return bottomView;
    }

    // helper method
    private static int[] levelOrder(Node root, Map<Integer, Integer> colMap) {
        int leftCol = 0;
        int rightCol = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair pair = q.poll();
            Node node = pair.node;
            int col = pair.col;

            colMap.put(col, node.data);
            leftCol = Math.min(leftCol, col);
            rightCol = Math.max(rightCol, col);

            if (node.left != null) q.add(new Pair(node.left, col - 1));
            if (node.right != null) q.add(new Pair(node.right, col + 1));
        }

        return new int[]{leftCol, rightCol};
    }

    // helper class
    private static class Pair {
        int col;
        Node node;

        Pair(Node node, int col) {
            this.col = col;
            this.node = node;
        }
    }
}
