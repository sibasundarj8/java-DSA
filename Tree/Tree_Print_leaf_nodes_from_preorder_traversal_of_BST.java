package Tree;/*
 *
 * https://www.geeksforgeeks.org/problems/print-leaf-nodes-from-preorder-traversal-of-bst2657/1
 *
 * # Print leaf nodes from preorder traversal of BST
 *
 *   Q. Given a preorder traversal of a BST, find the leaf nodes of the tree without building the tree.
 *    Ex.
 *      Input : preorder[] = [4, 2, 1, 3, 6, 5]
 *      Output: [1, 3, 5]
 *      Explanation:            4
 *                             /  \
 *                            2    6
 *                           /\    /
 *                          1  3  5
 *
 *                  1, 3 and 5 are the leaf nodes as shown in the figure
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Tree_Print_leaf_nodes_from_preorder_traversal_of_BST {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter preorder of BST: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;

        int[] preOrder = new int[n];
        for (int i = 0; i < n; i++) {
            preOrder[i] = Integer.parseInt(s[i]);
        }

        ArrayList<Integer> ans = leafNodes(preOrder);
        System.out.println("leaf nodes: " + ans);
    }

    /// Solution
    static ArrayList<Integer> leafNodes(int[] preorder) {
        // potd.code.hub
        int n = preorder.length;
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();

        stack.push(preorder[0]);

        for (int i = 1; i < n; i++) {
            int curr = preorder[i];

            if (curr > stack.peek()) {
                int temp = stack.pop();
                boolean flag = false;
                // remove left subTree
                while (!stack.isEmpty() && curr > stack.peek()) {
                    stack.pop();
                    flag = true;
                }
                // check if it is the right child of curr
                if (flag) ans.add(temp);
            }
            
            stack.push(curr);
        }
        ans.add(preorder[n - 1]);

        return ans;
    }
}
