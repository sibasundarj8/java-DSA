package Tree;/*
 *
 * https://www.geeksforgeeks.org/problems/vertical-sum/1
 *
 * # Vertical Sum
 *
 *   Q. Given a binary tree having n nodes, find the vertical sum of the nodes that are in the same vertical line. Return
 *      all sums through different vertical lines starting from the left-most vertical line to the right-most vertical line.
 *
 *    Ex.
 *      Input :                 1
 *                            /   \
 *                           2     3
 *                          / \   / \
 *                         4   5 6   7
 *      Output: 4 2 12 3 7
 *      Explanation:  4 2 12  3 7
 *                    | |  |  | |
 *                    | |  1  | |
 *                    | |/ | \| |
 *                    | 2  |  3 |
 *                    |/|\ | /|\|
 *                    4 | 5+6 | 7
 *
 *              The tree has 5 vertical lines
 *                ◦ Line 1 has only one node 4 => vertical sum is 4.
 *                ◦ Line 2 has only one node 2 => vertical sum is 2.
 *                ◦ Line-3 has three nodes: 1,5,6 => vertical sum is 1+5+6 = 12.
 *                ◦ Line-4 has only one node 3 => vertical sum is 3.
 *                ◦ Line-5 has only one node 7 => vertical sum is 7.
 *
 *  Constraints:
 *          1 <= n <= 10⁴
 *          1 <= Node value <= 10⁵
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Tree_Vertical_Sum {

    /// Structure
    private static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    /// main Method
    public static void main(String[] args) {
        // Create nodes
        Node[] nodes = {
                new Node(1),
                new Node(2),
                new Node(3),
                new Node(4),
                new Node(5),
                new Node(6),
                new Node(7)
        };

        // Connect nodes
        nodes[0].left = nodes[1];   // 1 -> 2
        nodes[0].right = nodes[2];  // 1 -> 3

        nodes[1].left = nodes[3];   // 2 -> 4
        nodes[1].right = nodes[4];  // 2 -> 5

        nodes[2].left = nodes[5];   // 3 -> 6
        nodes[2].right = nodes[6];  // 3 -> 7

        // Root of tree
        Node root = nodes[0];

        System.out.println("Vertical Sum : ");
        System.out.println(verticalSum(root));
    }

    /// Solution (remove static from everywhere before running on GFG or LC)
    private static int left = 0;
    private static int right = 0;

    static ArrayList<Integer> verticalSum(Node root) {
        // potd.code.hub
        ArrayList<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        traverse(root, 0, map);

        for (int i = left; i <= right; i++) {
            list.add(map.get(i));
        }

        return list;
    }

    private static void traverse(Node root, int level, Map<Integer, Integer> map) {
        // base case
        if (root == null) return;

        // self work
        left = Math.min(left, level);
        right = Math.max(right, level);
        map.put(level, map.getOrDefault(level, 0) + root.data);

        // recursive work
        traverse(root.left, level - 1, map);
        traverse(root.right, level + 1, map);
    }
}
