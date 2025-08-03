package GFG_160.Bonus_Problems;/*
 * 
 * https://www.geeksforgeeks.org/problems/normal-bst-to-balanced-bst/1
 *
 * # Normal BST to Balanced BST
 *
 *   Q. Given a root of a Binary Search Tree, modify and return the given BST such that it is balanced and has
 *      minimum possible height. If there is more than one answer, return any of them.
 *
 *      Note: The height of balanced BST returned by you will be compared with the expected height of the balanced
 *            tree.
 *    Ex.
 *      Input : root[] = [4, 3, 5, 2, N, N, 6, 1, N, N, 7]
 *                             [4]
 *                             / \
 *                           [3] [5]
 *                           /     \
 *                         [2]     [6]
 *                         /         \
 *                       [1]         [7]
 *      Output: 3              [4]
 *                            /   \
 *                         [2]     [6]
 *                        / \       / \
 *                      [1] [3]   [5] [7]
 *
 *      Explanation: The above unbalanced BST is converted to balanced with the minimum possible height i.e. 3.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Tree_05_Normal_BST_to_Balanced_BST {

    /// Structure
    static class Node {
        int data;
        Node right, left;

        Node(int item) {
            data = item;
        }
    }

    /// main Method
    public static void main(String[] args) {
        Node[] nodes = {
                new Node(4), // 0
                new Node(3), // 1
                new Node(5), // 2
                new Node(2), // 3
                new Node(6), // 4
                new Node(1), // 5
                new Node(7), // 6
        };

        nodes[0].left = nodes[1];
        nodes[1].left = nodes[3];
        nodes[3].left = nodes[5];

        nodes[0].right = nodes[2];
        nodes[2].right = nodes[4];
        nodes[4].right = nodes[6];

        System.out.println("Before balancing: ");
        for (ArrayList<Integer> list : levelOrder(nodes[0])) {
            System.out.println(list);
        }

        nodes[0] = balanceBST(nodes[0]);

        System.out.println("After balancing: ");
        for (ArrayList<Integer> list : levelOrder(nodes[0])) {
            System.out.println(list);
        }
    }

    // level order traversal
    private static ArrayList<ArrayList<Integer>> levelOrder(Node root) {
        // potd.code.hub
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();

        q.offer(root);

        while (!q.isEmpty()) {
            ans.add(new ArrayList<>());
            int n = q.size();

            for (int i = 0; i < n; i++) {
                Node temp = q.poll();
                ans.get(ans.size() - 1).add(temp.data);

                if (temp.left != null) q.add(temp.left);
                if (temp.right != null) q.add(temp.right);
            }
        }

        return ans;
    }

    /// Solution
    static Node balanceBST(Node root) {
        // potd.code.hub
        ArrayList<Node> inOrder = new ArrayList<>();

        inOrderTraversal(root, inOrder);

        return construct(0, inOrder.size() - 1, inOrder);
    }

    // in-order traversal
    private static void inOrderTraversal(Node root, ArrayList<Node> list) {
        // base case
        if (root == null) return;

        // recursive work
        inOrderTraversal(root.left, list);

        list.add(root);

        inOrderTraversal(root.right, list);
    }

    // construct balanced BST
    private static Node construct(int s, int e, ArrayList<Node> list) {
        // base case
        if (s > e) return null;

        int mid = s + (e - s) / 2;

        // recursive work
        Node left = construct(s, mid - 1, list);
        Node right = construct(mid + 1, e, list);

        // self work
        Node cur = list.get(mid);
        cur.left = left;
        cur.right = right;

        return cur;
    }
}
