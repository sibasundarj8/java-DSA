package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/maximum-path-sum-from-any-node/1
 *
 * # Maximum path sum from any node
 *
 *   Q. Given a binary tree, the task is to find the maximum path sum. The path may start and end
 *      at any node in the tree.
 *    Ex.
 *      Input : root[] = [10, 2, 10, 20, 1, N, -25, N, N, N, N, 3, 4]
 *      Output: 42
 *      Explanation:
 *                     (10)
 *                     /  \
 *                   (2)  (10)
 *                   / \     \
 *                 (20) 1    -25
 *                           /  \
 *                          3    4
 *              Max path sum is represented using green colour nodes in the above binary tree.
 */
public class GFG_87_Maximum_path_sum_from_any_node {

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
                       new Node(2),
                       new Node(10),
                       new Node(20),
                       new Node(1),
                       new Node(-25),
                       new Node(3),
                       new Node(4)};
        node[0].left = node[1];
        node[0].right = node[2];

        node[1].left = node[3];
        node[1].right = node[4];

        node[2].right = node[5];

        node[5].left = node[6];
        node[5].right = node[7];

        System.out.println(findMaxSum(node[0]));
    }

    /// Solution
    static int findMaxSum(Node node) {
        // potd.code.hub
        int[]ans = {Integer.MIN_VALUE};
        findMax(node, ans);

        return ans[0];
    }
    private static int findMax(Node root, int[]ans){
        // base Case
        if (root == null) return 0;
        // recursive work
        int left = findMax(root.left, ans);
        int right = findMax(root.right, ans);
        // self work
        int temp = Math.max(left, 0) + Math.max(right, 0);
        ans[0] = Math.max(ans[0], temp + root.data);
        return Math.max(Math.max(left, right), 0) + root.data;
    }
}
