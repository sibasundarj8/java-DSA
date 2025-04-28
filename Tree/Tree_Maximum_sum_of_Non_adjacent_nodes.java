package Tree;/*
 * https://www.geeksforgeeks.org/problems/maximum-sum-of-non-adjacent-nodes/1
 *
 * # Maximum sum of Non-adjacent nodes
 *
 *   Q. Given a binary tree with a value associated with each node. Your task is to select a
 *      subset of nodes such that the sum of their values is maximized, with the condition that
 *      no two selected nodes are directly connected that is, if a node is included in the
 *      subset, neither its parent nor its children can be included.
 * 
 *    Ex.
 *          Input : root[] = [1, 2, 3, 4, N, 5, 6]
 *                            (1)                         (✅)      
 *                           /   \                        /   \
 *                         (2)   (3)                    (2)   (3)  
 *                         /     / \                    /     / \
 *                       (4)   (5) (6)               (✅)  (✅)(✅)
 *          Output: 16
 *          Explanation: The maximum sum is obtained by selecting the nodes 1, 4, 5, and 6,
 *                       which are not directly connected to each other. Their total sum is 16.
 */

public class Tree_Maximum_sum_of_Non_adjacent_nodes {

    /// Structure
    private static class Node {
        int data;
        Node left, right;
        Node (int data){
            this.data = data;
        }
    }

    /// main Method
    public static void main(String[] args) {
        Node[] root = {new Node(1),
                       new Node(2),
                       new Node(3),
                       new Node(4),
                       null,
                       new Node(5),
                       new Node(6)};

        root[0].left = root[1];
        root[0].right = root[2];

        root[1].left = root[3];

        root[2].left = root[5];
        root[2].right = root[6];

        System.out.println(getMaxSum(root[0]));
    }

    /// Solution
    private static class Pair {
        int include, exclude;
    }
    static int getMaxSum(Node root) {
        // potd.code.hub
        Pair res = solve(root);
        return Math.max(res.include, res.exclude);
    }
    private static Pair solve (Node root){
        if (root == null){
            return new Pair();
        }
        Pair left = solve(root.left);
        Pair right = solve(root.right);

        Pair ans = new Pair();
        ans.include = root.data + left.exclude + right.exclude;
        ans.exclude = Math.max(left.include, left.exclude) + Math.max(right.include, right.exclude);

        return ans;
    }
}
