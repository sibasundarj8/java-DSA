package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/inorder-traversal/1
 *
 * # Inorder Traversal
 *
 *   Q. Given a Binary Tree, your task is to return its In-Order Traversal.
 *
 *      An inorder traversal first visits the left child (including its entire subtree), then
 *      visits the node, and finally visits the right child (including its entire subtree).
 *    Ex.
 *      Input : root[] = [1, 2, 3, 4, 5]
 *                                          1
 *                                         / \
 *                                        2   3
 *                                       / \
 *                                      4   5
 *      Output: [4, 2, 5, 1, 3]
 *      Explanation: The in-order traversal of the given binary tree is [4, 2, 5, 1, 3].
 */
import java.util.ArrayList;

public class GFG_85_Inorder_Traversal {

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
        Node[] root  = {new Node(1), 
                        new Node(2), 
                        new Node(3), 
                        new Node(4), 
                        new Node(5)};
        root[0].left = root[1];
        root[0].right = root[2];
        root[1].left = root[3];
        root[1].right = root[4];

        System.out.println(inOrder(root[0]));
    }

    /// Solution
    static ArrayList<Integer> inOrder(Node root) {
        // potd.code.hub
        ArrayList<Integer> ans = new ArrayList<>();
        traverse(root, ans);
        
        return ans;
    }
    private static void traverse(Node root, ArrayList<Integer> ans){
        // base Case
        if (root == null) return;
        // recursive work
        traverse(root.left, ans);
        ans.add(root.data);
        traverse(root.right, ans);
    }
}
