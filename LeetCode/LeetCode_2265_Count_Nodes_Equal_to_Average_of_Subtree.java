package LeetCode;/*
 *
 * https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/
 *
 * # LC. 2265. Count Nodes Equal to Average of Subtree
 *
 *   Q. Given the root of a binary tree, return the number of nodes where the value of the node is equal to the average
 *      of the values in its subtree.
 *
 *      Note:
 *        ◦ The average of n elements is the sum of the n elements divided by n and rounded down to the nearest integer.
 *        ◦ A subtree of root is a tree consisting of root and all of its descendants.
 *
 *    Ex.
 *      Input : root = [4, 8, 5, 0, 1, null, 6]
 *                                                 4
 *                                               /   \
 *                                              8     5
 *                                             / \     \
 *                                            0   1     6
 *      Output: 5
 *      Explanation:
 *              For the node with value 4: The average of its subtree is (4 + 8 + 5 + 0 + 1 + 6) / 6 = 24 / 6 = 4.
 *              For the node with value 5: The average of its subtree is (5 + 6) / 2 = 11 / 2 = 5.
 *              For the node with value 0: The average of its subtree is 0 / 1 = 0.
 *              For the node with value 1: The average of its subtree is 1 / 1 = 1.
 *              For the node with value 6: The average of its subtree is 6 / 1 = 6.
 *
 *  Constraints:
 *        ◦ The number of nodes in the tree is in the range [1, 1000].
 *        ◦ 0 <= Node.val <= 1000
 */

public class LeetCode_2265_Count_Nodes_Equal_to_Average_of_Subtree {

    /// Structure
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    /// main Method
    public static void main(String[] args) {
        TreeNode[] nodes = {
                new TreeNode(4),
                new TreeNode(8),
                new TreeNode(5),
                new TreeNode(0),
                new TreeNode(1),
                new TreeNode(6),
        };

        nodes[0].left = nodes[1];
        nodes[0].right = nodes[2];

        nodes[1].left = nodes[3];
        nodes[1].right = nodes[4];

        nodes[2].right = nodes[5];

        System.out.print("""
                given tree:
                      4
                    /   \\
                   8     5
                  / \\     \\
                 0   1     6
                number of nodes with average value:
                """);

        System.out.println(averageOfSubtree(nodes[0]));
    }

    /// Solution
    static int averageOfSubtree(TreeNode root) {
        return solve(root)[2];
    }

    private static int[] solve(TreeNode root) {
        // base case
        if (root == null) return new int[]{0, 0, 0};

        if (root.left == null && root.right == null)
            return new int[]{1, root.val, 1};

        // recursive case
        int[] left = solve(root.left);
        int[] right = solve(root.right);

        // self work
        int total_nodes = left[0] + right[0] + 1;
        int total_sum = left[1] + right[1] + root.val;
        int avg_val = total_sum / total_nodes;
        int x = left[2] + right[2];
        int avg_count = (root.val == avg_val) ? x + 1 : x;

        return new int[]{total_nodes, total_sum, avg_count};
    }
}

/*
Before solving it we have to make sure something important ?

--> What I am expecting from my child recursive call
    ans :- we need 3 things:
        1) total number of nodes in that subtree
        2) sum of all node_values
        3) number of nodes containing avg value in that subtree

--> how can we make the current state using child subtree states to return ?
    ans :- Here also we need 3 things to modify:
        1) total_nodes = left subtree nodes + right nodes + 1
        2) total sum = left_sum + right_sum + root.val()
        3) total_avg ? calculate currAvg using total_sum and total_count then return left_avg + right_avg + 1 if root.val == calculated avg else ...

Now we have to make another function to deal with it and later return the avg_count from root state.
*/
