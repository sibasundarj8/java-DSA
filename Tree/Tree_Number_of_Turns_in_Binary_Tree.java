package Tree;/*
 *
 * https://www.geeksforgeeks.org/problems/number-of-turns-in-binary-tree/1
 *
 * # Number of Turns in Binary Tree
 *
 *   Q. Given root of a binary tree and the values of its two nodes p and q, count turns required to travel from node p
 *      to q.
 *
 *      A turn occurs whenever the direction of movement changes from left to right or right to left while traversing
 *      the tree.
 *
 *      If the path between the two nodes does not involve any turns (i.e., the nodes lie on the same straight path),
 *      return -1.
 *
 *      Note: All node values are distinct.
 *
 *    Ex.
 *      Input : root[] = [1, 2, 3, 4, 5, 6, 7, 8, N, N, N, 9, 10],
 *              p = 5,
 *              q = 10
 *                                  1
 *                                /   \
 *                              2       3
 *                             / \     / \
 *                            4   5   6   7
 *                           /       / \
 *                          8       9  10
 *      Output: 4
 *      Explanation: The path from node 5 to node 10 is: 5 -> 2 -> 1 -> 3 -> 6 → 10. Direction changes occur at nodes
 *                   2, 1, 3, and 6. Therefore, the number of turns is 4.
 *
 *  Constraints:
 *        ◦ 1 ≤ n ≤ 10⁴, n is the number of nodes
 *        ◦ 1 ≤ node.data ≤ 10⁴
 *        ◦ 1 ≤ p, q ≤ n
 */

public class Tree_Number_of_Turns_in_Binary_Tree {

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
        Node[] nodes = new Node[10];

        for (int i = 0; i < 10; i++) {
            nodes[i] = new Node(i + 1);
        }

        nodes[0].left = nodes[1];
        nodes[0].right = nodes[2];

        nodes[1].left = nodes[3];
        nodes[1].right = nodes[4];

        nodes[2].left = nodes[5];
        nodes[2].right = nodes[6];

        nodes[3].left = nodes[7];

        nodes[5].left = nodes[8];
        nodes[5].right = nodes[9];

        int p = 5;
        int q = 10;

        System.out.printf("""
                tree:
                        1
                      /   \\
                    2       3
                   / \\     / \\
                  4   5   6   7
                 /       / \\
                8       9  10
                
                p = %s
                q = %s
                
                Number of turns required to travel from node p to q:
                """, p, q);
        System.out.println(numberOfTurns(nodes[0], p, q));
    }

    /// Solution
    static int numberOfTurns(Node root, int p, int q) {
        // potd.code.hub
        boolean[] flags = new boolean[2];
        Node lca = lowestCommonAncestor(root, p, q, flags);

        if (!flags[0] || !flags[1]) return -1;

        int pTurnCount = countTurns(lca, -1, p);
        int qTurnCount = countTurns(lca, -1, q);
        int totalTurns = pTurnCount + qTurnCount;

        if (lca.data == p || lca.data == q) {
            return (totalTurns == 0) ? -1 : totalTurns;
        }
        return totalTurns + 1;
    }

    // 0 --> left
    // 1 --> right
    private static int countTurns(Node root, int prevMove, int tar) {
        // base case
        if (root == null) return -1;
        if (root.data == tar) return 0;

        // recursive work
        int l = countTurns(root.left, 0, tar);
        int r = countTurns(root.right, 1, tar);

        // self work
        if (l != -1) return (prevMove == 1) ? l + 1 : l;
        if (r != -1) return (prevMove == 0) ? r + 1 : r;
        return -1;
    }

    private static Node lowestCommonAncestor(Node root, int p, int q, boolean[] flags) {
        // base case
        if (root == null) return null;

        // recursive work
        Node l = lowestCommonAncestor(root.left, p, q, flags);
        Node r = lowestCommonAncestor(root.right, p, q, flags);

        // self work
        if (root.data == p) {
            flags[0] = true;
            return root;
        }
        if (root.data == q) {
            flags[1] = true;
            return root;
        }

        if (l != null && r != null) return root;
        else return l == null ? r : l;
    }
}
