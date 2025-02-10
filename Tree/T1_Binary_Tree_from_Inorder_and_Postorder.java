package Tree;/*
 *
 * https://www.geeksforgeeks.org/problems/tree-from-postorder-and-inorder/1
 *
 * # Binary Tree from Inorder and Postorder
 *
 *   Q. Given inorder and postorder traversals of a binary tree(having n nodes) in the arrays
 *      inorder[] and postorder[] respectively. The task is to construct a unique binary tree
 *      from these traversals and return its root.
 *      Driver code will print the preorder traversal of the constructed tree.
 *
 *      Note: The inorder and postorder traversals contain unique values, and every value present
 *            in the postorder traversal is also found in the inorder traversal.
 *    Ex.
 *      Input : inorder[] = [4, 8, 2, 5, 1, 6, 3, 7]
 *              postorder[] = [8, 4, 5, 2, 6, 7, 3, 1]
 *      Output: [1, 2, 4, 8, 5, 3, 6, 7]
 *      Explanation: For the given postorder and inorder traversal of tree the resultant binary
 *                   tree will be:
 *                              1
 *                            /   \
 *                          2      3
 *                        /  \    /  \
 *                       4    5  6    7
 *                        \
 *                         8
 */
import java.util.HashMap;
import java.util.Scanner;

public class T1_Binary_Tree_from_Inorder_and_Postorder {

    /// Structure
    private static class Node{
        int data;
        Node left, right;
        Node(int data){
            this.data = data;
        }
        void preOrder(){
            print(this);
        }
        private void print(Node root){
            if (root == null) return;
            System.out.print(root.data + " ");
            print(root.left);
            print(root.right);
        }
    }

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Number of Nodes: ");
        int n = sc.nextInt();

        int[] inOrder = new int[n], postOrder = new int[n];

        System.out.println("InOrder: ");
        for (int i = 0;i < n;i++) inOrder[i] = sc.nextInt();

        System.out.println("PostOrder: ");
        for (int i = 0;i < n;i++) postOrder[i] = sc.nextInt();

        Node root = buildTree(inOrder, postOrder);

        root.preOrder();
    }

    /// Solution
    static Node buildTree(int[] inorder, int[] postorder) {
        // potd.code.hub
        int n = inorder.length;
        HashMap<Integer, Integer> map = new HashMap<>(n);
        for (int i = 0;i < n;i++) map.put(inorder[i], i);

        return built(0, n-1, postorder, 0, n-1, map);
    }
    static Node built (int inS, int inE, int[] postOrder, int postS, int postE, HashMap<Integer, Integer> map){
        // base Case
        if (inS > inE || postS > postE) return null;
        // self Work
        Node root = new Node(postOrder[postE]);
        int inIdx = map.get(root.data);
        int temp = inE - inIdx;
        // recursive work
        root.left = built(inS, inIdx-1, postOrder, postS, postE-temp-1, map);
        root.right = built(inIdx+1, inE, postOrder, postS-temp, postE-1, map);
        return root;
    }
}
