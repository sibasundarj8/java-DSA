package Tree;/*
 *
 * https://www.geeksforgeeks.org/problems/burning-tree/1
 *
 * # Burning Tree
 *
 *   Q. Given the root of a binary tree and a target node, determine the minimum time required to burn the entire tree if
 *      the target node is set on fire. In one second, the fire spreads from a node to its left child, right child, and parent.
 *
 *      Note: The tree contains unique values.
 *
 *    Ex.
 *      Input : root = [1, 2, 3, 4, 5, 6, 7]
 *              target = 2                     1
 *                                           /   \
 *                                          2     3
 *                                         / \   / \
 *                                        4   5 6   7
 *      Output: 3
 *      Explanation: Initially 2 is set to fire at 0 sec
 *                   At 1 sec: Nodes 4, 5, 1 catches fire.
 *                   At 2 sec: Node 3 catches fire.
 *                   At 3 sec: Nodes 6, 7 catches fire.
 *                   It takes 3s to burn the complete tree.
 *
 *  Constraints:
 *          1 ≤ number of nodes ≤ 10⁵
 *          1 ≤ node.data ≤ 10⁵
 */

public class Tree_Burning_Tree {

    /// Structure
    private static class  Node {
        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
        }
    }

    /// main method
    public static void main(String[] args) {
        Node[] nodes = {
                new Node(1),
                new Node(2),
                new Node(3),
                new Node(4),
                new Node(5),
                new Node(6),
                new Node(7),
        };

        nodes[0].left = nodes[1];
        nodes[0].right = nodes[2];

        nodes[1].left = nodes[3];
        nodes[1].right = nodes[4];

        nodes[2].left = nodes[5];
        nodes[2].right = nodes[6];

        int target = 2;

        System.out.println("Time required to born all the nodes: ");
        System.out.println(minTime(nodes[0], target) + " sec");
    }

    /// Solution
    static int minTime(Node root, int target) {
        // potd.code.hub
        int[] maxPath = new int[1];
        int[] downward = new int[1];

        findTarget(root, target, maxPath, downward);

        return Math.max(downward[0], maxPath[0]);
    }

    // getting the target with the longest path from target calculation.
    private static Pair findTarget(Node root, int target, int[] maxPath, int[] downward) {
        // base case
        if (root == null) return new Pair(false, 0);

        // recursive case
        Pair left = findTarget(root.left, target, maxPath, downward);
        Pair right = findTarget(root.right, target, maxPath, downward);

        // self work
        if (left.targetExists || right.targetExists) {
            maxPath[0] = Math.max(maxPath[0], left.downwardLength + right.downwardLength);
        }

        Pair pair;

        if (root.data == target) {
            downward[0] = Math.max(left.downwardLength, right.downwardLength);
            pair = new Pair(true, 1);
        } else if (left.targetExists) pair = new Pair(true, left.downwardLength + 1);
        else if (right.targetExists) pair = new Pair(true, right.downwardLength + 1);
        else pair = new Pair(false, Math.max(left.downwardLength, right.downwardLength) + 1);
 
        return pair;
    }

    private record Pair(boolean targetExists, int downwardLength){}
}
