package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/height-of-binary-tree/1
 *
 * # Given a binary tree, find its height.
 *
 *   Q. The height of a tree is defined as the number of edges on the longest path from the root to
 *      a leaf node. A leaf node is a node that does not have any children.
 *    Ex.
 *      Input : root[] = [1, 2, 3, 4, N, N, 5, N, N, 6, 7]
 *                                                          1
 *                                                         / \
 *                                                        2   3
 *                                                       /     \
 *                                                      4       5
 *                                                             / \
 *                                                            6   7
 *      Output: 3
 *      Explanation: The longest path from the root (node 1) to a leaf node 6 with 3 edge.
 */
public class GFG_81_Height_of_Binary_Tree {

    /// Structure
    private static class Node{
        int data;
        Node left, right;
        Node (int data){
            this.data = data;
        }
    }

    /// main Method
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);

        a.left = b;
        a.right = c;
        b.left = d;
        c.right = e;
        e.left = f;
        e.right = g;

        System.out.println(height(a));
    }

    /// Solution
    static int height(Node node) {
        // potd.code.hub
        if (node == null) return -1;
        // recursive work
        int left = height(node.left);
        int right = height(node.right);
        // self work
        return Math.max(left, right) + 1;
    }
}
