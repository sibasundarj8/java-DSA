package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/construct-tree-1/1
 *
 * # Construct Tree from Inorder & Preorder
 *
 *   Q. Given two arrays representing the inorder and preorder traversals of a binary tree,
 *      construct the tree and return the root node of the constructed tree.
 *
 *      Note: The output is written in postorder traversal.
 *    Ex.
 *      Input : inorder[] =  [3, 1, 4, 0, 2, 5],
 *              preorder[] = [0, 1, 3, 4, 2, 5]
 *      Output: [3, 4, 1, 5, 2, 0]
 *      Explanation: The tree will look like
 *                                          0
 *                                         / \
 *                                        1   2
 *                                       / \   \
 *                                      3   4   5
 */
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GFG_84_Construct_Tree_from_Inorder_and_Preorder {

    /// Structure
    private static class Node{
        int data;
        Node left, right;
        Node(int data){
            this.data = data;
        }
        void print(){
            Queue<Node> q = new LinkedList<>();
            StringBuilder s = new StringBuilder();
            q.offer(this);
            while (!q.isEmpty()){
                Node temp = q.poll();
                if (temp == null){
                    s.append("N ");
                    continue;
                }
                s.append(temp.data).append(" ");
                q.add(temp.left);
                q.add(temp.right);
            }
            while (!s.isEmpty() && !Character.isDigit(s.charAt(s.length()-1))){
                s.deleteCharAt(s.length()-1);
            }
            System.out.println(s);
        }
    }

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Number of Nodes: ");
        int n = sc.nextInt();

        int[] preOrder = new int[n], inOrder = new int[n];

        System.out.println("Preorder Traversal : ");
        for (int i = 0;i < n;i++) preOrder[i] = sc.nextInt();

        System.out.println("Inorder Traversal : ");
        for (int i = 0;i < n;i++) inOrder[i] = sc.nextInt();

        Node root = buildTree(inOrder, preOrder);

        root.print();
    }

    /// Solution
    static Node buildTree(int[] inorder, int[] preorder) {
        // potd.code.hub
        int n = preorder.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0;i < n;i++) map.put(inorder[i], i);

        return buildTree(preorder, 0, n-1, 0, n-1, map);
    }
    private static Node buildTree(int[] preorder, int preStart, int preEnd, int inStart, int inEnd, HashMap<Integer, Integer> inMap) {
        if (preStart > preEnd || inStart > inEnd) return null;
        Node root = new Node(preorder[preStart]);
        int inRoot = inMap.get(root.data);
        int numsLeft = inRoot - inStart;
        root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inStart, inRoot - 1, inMap);
        root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inRoot + 1, inEnd, inMap);
        return root;
    }
}
