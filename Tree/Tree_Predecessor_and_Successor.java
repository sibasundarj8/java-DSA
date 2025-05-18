package Tree;/*
 *
 * https://www.geeksforgeeks.org/problems/predecessor-and-successor/1
 *
 * # Predecessor and Successor
 *
 *   Q. You are given root node of the BST and an integer key. You need to find the in-order successor and
 *      predecessor of the given key. If either predecessor or successor is not found, then set it to NULL.
 *
 *      Note:- In an inorder traversal the number just smaller than the target is the predecessor and the
 *             number just greater than the target is the successor.
 *    Ex.
 *      Input : root[] = [8, 1, 9, N, 4, N, 10, 3, N, N, N]
 *              key = 8
 *                                 [8]
 *                                /   \
 *                              [1]   [9]
 *                                \     \
 *                                [4]   [10]
 *                                /
 *                             [3]
 *      Output: 4 9
 *      Explanation: In the given BST the inorder predecessor of 8 is 4 and inorder successor of 8 is 9.
 */

import java.util.ArrayList;
import java.util.List;

public class Tree_Predecessor_and_Successor {

    /// Structure
    private static class Node {
        int data;
        Node left, right;
        Node(int x) {
            data = x;
            left = right = null;
        }
    }

    /// main Method
    public static void main(String[] args) {
        Node[] nodes = {
                new Node(8),
                new Node(1),
                new Node(9),
                new Node(4),
                new Node(10),
                new Node(3),
        };

        nodes[0].left = nodes[1];
        nodes[0].right = nodes[2];

        nodes[1].right = nodes[3];

        nodes[2].right = nodes[4];

        nodes[3].left = nodes[5];

        int key = 8;

        ArrayList<Node> ans = findPreSuc(nodes[0], key);

        for (Node n : ans){
            System.out.print(n.data + " ");
        }
    }

    /// Solution
    static ArrayList<Node> findPreSuc(Node root, int key) {
        // potd.code.hub
        List<Node> nodes = new ArrayList<>();
        nodes.add(null);
        nodes.add(null);
        
        ArrayList<Node> ans = new ArrayList<>(nodes);
        solve (root, key, ans);

        return ans;
    }
    private static void solve (Node root, int key, ArrayList<Node> ans) {
        if (root == null) return;

        solve(root.left, key, ans);
        if (root.data < key){
            if (ans.get(0) == null || root.data > ans.get(0).data) {
                ans.set(0, root);
            }
        }else if (root.data > key) {
            if (ans.get(1) == null || root.data < ans.get(1).data) {
                ans.set(1, root);
            }
        }
        solve(root.right, key, ans);
    }
}
