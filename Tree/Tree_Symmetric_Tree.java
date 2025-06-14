package Tree;/*
 *
 * https://www.geeksforgeeks.org/problems/symmetric-tree/1
 *
 * # Symmetric Tree
 *
 *   Q. Given the root of a binary tree, check whether it is symmetric, i.e., whether the tree is a mirror image
 *      of itself.
 *
 *      A binary tree is symmetric if the left subtree is a mirror reflection of the right subtree.
 *   Ex.
 *      Input : root[] = [1, 2, 2, 3, 4, 4, 3]
 *                                                  1
 *                                                /  \
 *                                               2    2
 *                                              /\    /\
 *                                             3  4  4  3
 *      Output: True
 *      Explanation: As the left and right half of the above tree is mirror image, tree is symmetric.
 */

import java.util.LinkedList;
import java.util.Queue;

public class Tree_Symmetric_Tree {

    /// Structure
    static class Node {
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
                new Node(2),
                new Node(3),
                new Node(4),
                new Node(4),
                new Node(3),
        };

        nodes[0].left = nodes[1];
        nodes[0].right = nodes[2];

        nodes[1].left = nodes[3];
        nodes[1].right = nodes[4];

        nodes[2].left = nodes[5];
        nodes[2].right = nodes[6];

        System.out.println("Symmetric Tree: " + rec(nodes[0]));
    }

    /// Solution
/*----------------------------------------------------Using-Recursion----------------------------------------------------*/
    static boolean rec(Node root) {
        if (root == null) return true;

        return f(root.left, root.right);
    }

    private static boolean f(Node r1, Node r2) {
        if (r1 == null && r2 == null) return true;
        if (r1 == null || r2 == null || r1.data != r2.data) return false;

        return f(r1.left, r2.right) && f(r1.right, r2.left);
    }

/*------------------------------------------------------Using-Queue------------------------------------------------------*/
    static boolean isSymmetric(Node root) {
        // potd.code.hub
        if (root.left == null && root.right == null) return true;
        if (root.left == null || root.right == null) return false;
        if (root.right.data != root.left.data) return false;

        Queue<Node> q = new LinkedList<>();

        q.offer(root.left);
        q.offer(root.right);

        while (!q.isEmpty()) {
            Node n1 = q.poll();
            Node n2 = q.poll();
            Node l1 = n1.left;
            Node r1 = n1.right;
            Node l2 = n2.left;
            Node r2 = n2.right;

            if (l1 != null && r2 != null && l1.data == r2.data) {
                q.offer(l1);
                q.offer(r2);
            } else if (l1 != null || r2 != null) {
                return false;
            }

            if (l2 != null && r1 != null && l2.data == r1.data) {
                q.offer(l2);
                q.offer(r1);
            } else if (l2 != null || r1 != null) {
                return false;
            }
        }

        return true;
    }
}
