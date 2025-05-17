package Tree;/*
 *
 * https://www.geeksforgeeks.org/problems/level-order-traversal-in-spiral-form/1
 *
 * # Level Order in spiral form
 *
 *   Q. Given a binary tree and the task is to find the spiral order traversal of the tree and return the list
 *      containing the elements. Spiral order Traversal mean: Starting from level 0 for root node, for all the
 *      even levels we print the node's value from right to left and for all the odd levels we print the node's
 *      value from left to right.
 *
 *      For below tree, function should return [1, 2, 3, 4, 5, 6, 7]
 *                                            [1]
 *                                           /   \
 *                                        [2]    [3]
 *                                       /  \    /  \
 *                                      [7] [6] [5]  [4]
 *    Ex.
 *      Input : root = [10, 20, 30, 40, 60]
 *      Output: [10, 20, 30, 60, 40]
 *      Explanation: Start with root (10), print level 0 (right to left), level 1 (left to right), and continue
 *                   alternating.
 */

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Tree_Level_Order_in_spiral_form {

    /// main Method
    public static void main(String[] args) {
        Node[] nodes = {new Node(1),
                        new Node(2),
                        new Node(3),
                        new Node(7),
                        new Node(6),
                        new Node(5),
                        new Node(4),
        };
        nodes[0].left = nodes[1];
        nodes[0].right = nodes[2];

        nodes[1].left = nodes[3];
        nodes[1].right = nodes[4];

        nodes[2].left = nodes[5];
        nodes[2].right = nodes[6];

        System.out.println("spiral form: " + findSpiral(nodes[0]));
    }

    /// Structure
    private static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    /// Solution
/***************************************************-Using-two-Stacks-***************************************************/
    /*
    static ArrayList<Integer> findSpiral(Node root) {
        // potd.code.hub
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        if (root != null) s1.push(root);

        while (!s1.isEmpty() || !s2.isEmpty()) {
            Node node;

            while (!s1.isEmpty()) {
                node = s1.pop();
                if (node.right != null) s2.push(node.right);
                if (node.left != null) s2.push(node.left);
                ans.add(node.data);
            }

            while (!s2.empty()) {
                node = s2.pop();
                if (node.left != null) s1.push(node.left);
                if (node.right != null) s1.push(node.right);
                ans.add(node.data);
            }
        }

        return ans;
    }
    */
/***************************************************-Using-ArrayDeque-***************************************************/
    static ArrayList<Integer> findSpiral(Node root) {
        // potd.code.hub
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayDeque<Node> deque = new ArrayDeque<>();
        int flag = -1;

        if (root != null) deque.addFirst(root);

        while (!deque.isEmpty()) {
            int n = deque.size();
            Node node;

            if (flag == 1) {

                for (int i = 0; i < n; i++) {
                    node = deque.pollFirst();
                    if (node.left != null) deque.addLast(node.left);
                    if (node.right != null) deque.addLast(node.right);
                    ans.add(node.data);
                }

            } else {

                for (int i = 0; i < n; i++) {
                    node = deque.pollLast();
                    if (node.right != null) deque.addFirst(node.right);
                    if (node.left != null) deque.addFirst(node.left);
                    ans.add(node.data);
                }
            }

            flag *= -1;
        }

        return ans;
    }
}
