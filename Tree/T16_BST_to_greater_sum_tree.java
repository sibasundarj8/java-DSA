package Tree;/*

problem name- BST to greater sum tree [medium]
problem link- https://www.geeksforgeeks.org/problems/bst-to-greater-sum-tree/1

*/

public class T16_BST_to_greater_sum_tree {

    /// Solution
    public static void transformTree(Node root) {
        // potd.code.hub
        rec(root, new int[]{0});
    }

    // helper method
    private static void rec(Node root, int[] sum) {
        // base case
        if (root == null) return;
        
        // right sub-tree
        rec(root.right, sum);
        
        // self work
        int temp = root.data;
        root.data = sum[0];
        sum[0] += temp;
        
        // left sub-tree
        rec(root.left, sum);
    }
}
