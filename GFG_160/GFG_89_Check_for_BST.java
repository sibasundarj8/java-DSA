package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/check-for-bst/1
 *
 * # Check for BST
 *
 *   Q. Given the root of a binary tree. Check whether it is a BST or not.
 *      Note: We are considering that BSTs can not contain duplicate Nodes.
 *
 *      A BST is defined as follows:
 *        • The left subtree of a node contains only nodes with keys less than the node's key.
 *        • The right subtree of a node contains only nodes with keys greater than the node's key.
 *        • Both the left and right subtrees must also be binary search trees.
 *    Ex.
 *      Input : root = [10, 5, 20, N, N, 9, 25]
 *                             10
 *                            /  \
 *                           5   20
 *                              /  \
 *                             9   25
 *      Output: false
 *      Explanation: The node with key 9 present in the right subtree has lesser key value than
 *                   root node.
 */
public class GFG_89_Check_for_BST {

    /// Structure
    private static class Node{
        int data;
        Node left, right;
        Node(int data){
            this.data = data;
        }
    }

    /// main Method
    public static void main(String[] args) {
        Node[] node = {new Node(10),
                       new Node(5),
                       new Node(20),
                       new Node(9),
                       new Node(25)};
        node[0].left = node[1];
        node[0].right = node[2];

        node[2].left = node[3];
        node[2].right = node[4];

        System.out.println(isBST(node[0]));
    }

    /// Solution
    static boolean isBST(Node root) {
        // potd.code.hub
        int[]arr = {0};
        
        return check(root, arr);
    }
    private static boolean check(Node root, int[]arr){
        if (root == null) return true;
        if (!check(root.left, arr)) return false;
        if (root.data < arr[0]) return false;
        arr[0] = root.data;
        return check(root.right, arr);
    }
}
