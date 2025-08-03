package GFG_160.Bonus_Problems;/*
 *
 * https://www.geeksforgeeks.org/problems/count-bst-nodes-that-lie-in-a-given-range/1
 *
 * # Count BST nodes that lie in a given range
 *
 *   Q. Given a Binary Search Tree (BST) and a range l-h (inclusive), your task is to return the number of nodes
 *      in the BST whose value lie in the given range.
 *   Ex.
 *      Input : root[] = [10, 5, 50, 1, N, 40, 100]
 *              l = 5
 *              h = 45
 *                            [10]
 *                            /  \
 *                         [5]   [50]
 *                        /      /  \
 *                     [1]    [40]  [100]
 *      Output: 3
 *      Explanation: There are three nodes in range [5, 45] =  5, 10 and 40.
 */

public class Tree_06_Count_BST_nodes_that_lie_in_a_given_range {

    /// Structure
    private static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    /// main Method
    public static void main(String[] args) {
        Node[] nodes = {
                new Node(10),
                new Node(5),
                new Node(50),
                new Node(1),
                new Node(40),
                new Node(100)
        };

        nodes[0].left = nodes[1];
        nodes[0].right = nodes[2];

        nodes[1].left = nodes[3];

        nodes[2].left = nodes[4];
        nodes[2].right = nodes[5];

        int l = 5;
        int r = 45;

        System.out.println("Number of nodes present between " + l + " and " + r + " : ");
        System.out.println(getCount(nodes[0], l, r));
    }

    /// Solution
    static int getCount(Node root, int l, int h) {
        // Your code here
        if (root == null) return 0;

        int left = (root.data >= l) ? getCount(root.left, l, h) : 0;
        int right = (root.data <= h) ? getCount(root.right, l, h) : 0;
        int curr = (l <= root.data && root.data <= h) ? 1 : 0;

        return curr + left + right;
    }
}
