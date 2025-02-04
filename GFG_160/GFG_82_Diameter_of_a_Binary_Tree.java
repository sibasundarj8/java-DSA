package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/diameter-of-binary-tree/1
 *
 * # Diameter of a Binary Tree
 *
 *   Q. Given a binary tree, the diameter (also known as the width) is defined as the number of
 *      edges on the longest path between two leaf nodes in the tree. This path may or may not
 *      pass through the root. Your task is to find the diameter of the tree.
 *    Ex.
 *      Input : root[] = [5, 8, 6, 3, 7, 9]
 *      Output: 4
 *                             (5)
 *                             /  \
 *                           (8)  (6)
 *                           / \  /
 *                         (3) 7(9)
 *      Explanation: The longest path has 4 edges (node 3 -> node 8 -> node 5 -> node 6 -> node 9).
 */
public class GFG_82_Diameter_of_a_Binary_Tree {

    /// Structure
    private static class Node{
        int data;
        Node left, right;
        Node(int data){
            this.data = data;
        }
    }

    /// main method
    public static void main(String[] args) {
        Node[]arr = {new Node(5),
                     new Node(8),
                     new Node(6),
                     new Node(3),
                     new Node(7),
                     new Node(9)};
        arr[0].left = arr[1];
        arr[0].right = arr[2];
        arr[1].left = arr[3];
        arr[1].right = arr[4];
        arr[2].left = arr[5];

        System.out.println(diameter(arr[0]));
    }

    /// Solution
    static int diameter(Node root) {
        // potd.code.hub
        int[]ans = new int[1];
        find(root, ans);

        return ans[0];
    }
    private static int find(Node root, int[]ans){
        // base Case
        if (root == null) return 0;
        // recursive work
        int left = find(root.left, ans);
        int right = find(root.right, ans);
        // self work
        ans[0] = Math.max(ans[0], left + right);
        return Math.max(left, right) + 1;
    }
}
