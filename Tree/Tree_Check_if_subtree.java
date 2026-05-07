package Tree;/*
 *
 * https://www.geeksforgeeks.org/problems/check-if-subtree/1
 *
 * # Check if subtree
 *
 *   Q. Given two binary trees with roots root1 (for tree T) and root2 (for tree S), each containing at most N nodes.
 *      Determine whether tree S is a subtree of tree T.
 *
 *      Return true if S is a subtree of T, otherwise return false.
 *
 *      Note: A tree S is considered a subtree of T if there exists a node in T such that the subtree rooted at that node
 *            is identical to S. Two trees are identical if they have the same structure and the same node values.
 *
 *    Ex.
 *      Input : root1 = [1, 2, 3, N, N, 4], root2 = [3, 4]
 *                                                           1             3
 *                                                         /   \          /
 *                                                        2     3        4
 *                                                       / \   /
 *                                                      N   N 4
 *      Output: true
 *      Explanation: In the tree rooted at root1, the subtree starting at node 3 is identical to the tree rooted at root2
 *                   (same structure and node values). Hence, root2 is a subtree of root1, so the output is true.
 *
 *  Constraints:
 *          1 ≤ n ≤ 10³
 *          1 ≤ value of nodes ≤ 10⁴
 */

public class Tree_Check_if_subtree {

    /// Structure
    private static class Node {
        int data;
        Node left, right;
        public Node(int data) {
            this.data = data;
        }
    }

    /// main Method
    public static void main(String[] args) {

        boolean flag = isSubTree(new Node(12), new Node(2));
        System.out.println(flag);

        if (true) return;

        // Tree-1
        Node[] nodes1 = {
                new Node(1),
                new Node(2),
                new Node(3),
                new Node(4)
        };

        // Tree-1 connections
        nodes1[0].left = nodes1[1];
        nodes1[0].right = nodes1[2];

        nodes1[2].left = nodes1[3];

        // Tree-2
        Node[] nodes2 = {
                new Node(3),
                new Node(4)
        };

        // Tree-2 connections
        nodes2[0].left = nodes2[1];

        // Root node
        Node root1 = nodes1[0];
        Node root2 = nodes2[0];

        System.out.println("""
                   root-1   1          root-2   3
                          /   \\                /
                         2     3              4
                        / \\   /
                       N   N 4
                """);
        System.out.println("is subtree : " + isSubTree(root1, root2));
    }

    /// Solution
/*
☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒-brute-force-☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒
TC : O(n × m)
SC : O(N + M)  --> recursive call stack space
*/
    static boolean bruteForce(Node root1, Node root2) {
        // potd.code.hub
        if (root2 == null) return true;
        if (root1 == null) return false;

        // recursive case
        if (root1.data ==  root2.data && check(root1, root2)) return true;
        else return isSubTree(root1.left, root2) || isSubTree(root1.right, root2);
    }

    private static boolean check(Node root1, Node root2) {
        // base case
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null || root1.data != root2.data) return false;

        // recursive case
        return check(root1.left, root2.left) && check(root1.right, root2.right);
    }

/*
☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑-Serialization-+-KMP-☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑
TC : O(N + M)
SC : O(N + M)
*/
    static boolean isSubTree(Node root1, Node root2) {
        // potd.code.hub
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        serialize(root1, sb1);
        serialize(root2, sb2);

        return kmp(sb1.toString(), sb2.toString());
    }

    private static void serialize(Node root, StringBuilder sb) {
        // base case
        if (root == null) {
            sb.append('N');
            return;
        }

        // self work
        sb.append('.').append(root.data).append('.');

        // recursive case
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // KMP algorithm
    private static boolean kmp(String txt, String pat) {
        int n = txt.length();
        int m = pat.length();
        int[] lps = lps(pat);

        int t = 0;  // pointer to iterate text
        int p = 0;  // pointer to iterate pattern

        while(t < n) {
            if(txt.charAt(t) == pat.charAt(p)) {
                t++;
                p++;
            } else if(p > 0) p = lps[p - 1];
            else t++;

            if(p == m) return true;
        }

        return false;
    }

    // longest prefix suffix
    private static int[] lps(String str) {
        int n = str.length();
        int[] lps = new int[n];

        int p = 0;  // prefix
        int s = 1;  // suffix

        while(s < n) {
            if(str.charAt(p) == str.charAt(s)) lps[s++] = ++p;
            else if(p > 0) p = lps[p - 1];
            else s++;
        }

        return lps;
    }
}
