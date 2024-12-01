package GFG;
/*
 *  https://www.geeksforgeeks.org/problems/root-to-leaf-paths-sum/1
 *
 * # Root to Leaf Paths Sum
 *   Q. Given a binary tree, where every node value is a number. Find the sum of all the numbers that are formed
 *      from root to leaf paths. The formation of the numbers would be like 10 * parent + current
 *      (see the examples for more clarification).
 *    Ex.
 *      Input :        6
 *                    / \
 *                   3   5
 *                  / \   \
 *                 2   5   4
 *                    / \
 *                   7   4
 *
 *      Output: 13997
 *      Explanation : There are 4 leaves, resulting in leaf path of 632, 6357, 6354, 654 sums to 13997.
 */
public class POTD_Root_to_leaf_paths_sum {

    /// Tree Structure
    private static class Tree {
        int data;
        Tree left,right;
        Tree(int d){
            data=d;
            left=null;
            right=null;
        }
    }

    /// Main Method
    public static void main(String[] args) {
        Tree a = new Tree(6);
        Tree b = new Tree(3);
        Tree c = new Tree(2);
        Tree d = new Tree(5);
        Tree e = new Tree(7);
        Tree f = new Tree(4);
        Tree g = new Tree(5);
        Tree h = new Tree(4);

        a.left = b;
        a.right = g;
        b.left = c;
        b.right = d;
        d.left = e;
        d.right = f;
        g.right = h;

        System.out.println(treePathsSum(a));
    }

    /// Solution
    static int treePathsSum(Tree root) {
        // potd.code.hub.
        return prefix(root, 0);
    }
    static int prefix(Tree root, int sum){
        if(root == null) return 0;
        sum = sum*10 + root.data;
        if (root.left == null && root.right == null) return sum;
        return prefix(root.left,sum) + prefix(root.right, sum);
    }
}