package Tree;/*
 *
 * https://www.geeksforgeeks.org/problems/zigzag-tree-traversal/1
 *
 * # ZigZag Tree Traversal (Medium)
 *
 *   Q. Given the root of a binary tree. You have to find the zigzag level order traversal of the binary tree.
 *
 *      Note: In zig zag traversal we traverse the nodes from left to right for odd-numbered levels, and from
 *            right to left for even-numbered levels.
 *   Ex.
 *      Input : root = [7, 9, 7, 8, 8, 6, N, 10, 9]
 *                                                                         7
 *                                                                        / \
 *                                                                       9   7
 *                                                                      / \   \
 *                                                                     8   8   6
 *                                                                    / \
 *                                                                  10   9
 *      Output: [7, 7, 9, 8, 8, 6, 9, 10]
 *      Explanation:
 *              Level 1 (left to right): [7]
 *              Level 2 (right to left): [7, 9]
 *              Level 3 (left to right): [8, 8, 6]
 *              Level 4 (right to left): [9, 10]
 *              Final result: [7, 7, 9, 8, 8, 6, 9, 10]
 */

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class T14_ZigZag_Tree_Traversal {

    /// Structure
    static class Node {
        int data;
        Node left, right;
        Node(int data) {this.data = data;}
    }

    /// main Method
    public static void main(String[] args) {
        Node[] nodes = {
                new Node(7),
                new Node(9),
                new Node(7),
                new Node(8),
                new Node(8),
                new Node(6),
                new Node(10),
                new Node(9),
        };

        nodes[0].left = nodes[1];
        nodes[0].right = nodes[2];

        nodes[1].left = nodes[3];
        nodes[1].right = nodes[4];

        nodes[2].right = nodes[5];

        nodes[3].left = nodes[6];
        nodes[3].right = nodes[7];

        System.out.println("""
                Zig-zag traversal of  7
                                     / \\
                                    9   7
                                   / \\   \\
                                  8   8   6
                                 / \\
                               10   9
                """);
        System.out.println(zigZagTraversal(nodes[0]));
    }

    /// Solution
    static ArrayList<Integer> zigZagTraversal(Node root) {
        // potd.code.hub
        int level = 0;
        ArrayList<Integer> zigzag = new ArrayList<>();
        Deque<Node> deque = new LinkedList<>();

        deque.add(root);

        while (!deque.isEmpty()) {
            int n = deque.size();

            for (int i = 0; i < n; i++) {    // traversing all the nodes present at the current level
                Node curr;

                if (level == 0) {            // for even level
                    curr = deque.pollFirst();

                    if (curr.left != null) deque.addLast(curr.left);
                    if (curr.right != null) deque.addLast(curr.right);

                } else {                     // for odd level
                    curr = deque.pollLast();

                    if (curr.right != null) deque.addFirst(curr.right);
                    if (curr.left != null) deque.addFirst(curr.left);
                }

                zigzag.add(curr.data);
            }
          
            level ^= 1;
        }

        return zigzag;
    }
}
