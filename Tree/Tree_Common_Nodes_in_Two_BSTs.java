package Tree;/*
 *
 * https://www.geeksforgeeks.org/problems/print-common-nodes-in-bst/1
 *
 * # Common Nodes in Two BSTs
 *
 *   Q. Given the roots r1 and r2 of two Binary Search Trees (BST), find all nodes that are present in both trees
 *      i.e. the intersection nodes of the two BSTs.
 *
 *      Return the common node values in sorted order.
 *
 *    Ex.
 *      Input : r1 = [5, 1, 10, 0, 4, 7, N, N, N, N, N, N, 9],
 *              r2 = [10, 7, 20, 4, 9, N, N]
 *                                            5                10
 *                                          /   \             /  \
 *                                         1     10          7    20
 *                                        / \    /          / \
 *                                       0   4  7          4   9
 *                                               \
 *                                                9
 *      Output: [4, 7, 9, 10]
 *      Explanation: The values present in both BSTs are 4, 7, 9, and 10.
 *                   Hence, the answer is [4, 7, 9, 10].
 *
 *  Constraints:
 *      ◦ 1 ≤ size of binary trees ≤ 10⁵
 *      ◦ 0 ≤ Node.data ≤ 10⁹
 */

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Tree_Common_Nodes_in_Two_BSTs {

    /// Structure
    private static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    /// main Method
    public static void main(String[] args) {
        Node[] nodes1 = {
                new Node(5),
                new Node(1),
                new Node(10),
                new Node(0),
                new Node(4),
                new Node(7),
                new Node(9)
        };

        nodes1[0].left = nodes1[1];
        nodes1[0].right = nodes1[2];

        nodes1[1].left = nodes1[3];
        nodes1[1].right = nodes1[4];

        nodes1[2].left = nodes1[5];

        nodes1[5].right = nodes1[6];

        Node[] nodes2 = {
                new Node(10),
                new Node(7),
                new Node(20),
                new Node(4),
                new Node(9)
        };

        nodes2[0].left = nodes2[1];
        nodes2[0].right = nodes2[2];

        nodes2[1].left = nodes2[3];
        nodes2[1].right = nodes2[4];

        System.out.print("""
                tree-1:     5        tree-2:    10
                          /   \\                /  \\
                         1     10             7    20
                        / \\    /             / \\
                       0   4  7             4   9
                               \\
                                9
                common elements:
                """);
        System.out.println(findCommon(nodes1[0], nodes2[0]));
    }

    /// Solution
    static ArrayList<Integer> findCommon(Node r1, Node r2) {
        // potd.code.hub
        ArrayList<Integer> common = new ArrayList<>();
        ArrayDeque<Node> stack1 = new ArrayDeque<>();
        ArrayDeque<Node> stack2 = new ArrayDeque<>();

        Node tmp1 = r1;
        Node tmp2 = r2;

        while ((tmp1 != null || !stack1.isEmpty()) &&
               (tmp2 != null || !stack2.isEmpty())) {

            while (tmp1 != null) {
                stack1.push(tmp1);
                tmp1 = tmp1.left;
            }

            while (tmp2 != null) {
                stack2.push(tmp2);
                tmp2 = tmp2.left;
            }

            int cur1 = stack1.peek().data;
            int cur2 = stack2.peek().data;

            if (cur1 < cur2) {
                tmp1 = stack1.pop().right;
            } else if (cur1 > cur2) {
                tmp2 = stack2.pop().right;
            } else {
                common.add(cur1);
                tmp1 = stack1.pop().right;
                tmp2 = stack2.pop().right;
            }
        }

        return common;
    }
}
