package Tree;/*
 *
 * https://www.geeksforgeeks.org/problems/construct-tree-from-preorder-postorder/1
 *
 * # Construct Tree from Preorder & Postorder
 *
 *   Q. Given two arrays pre[] and post[] that represent the preorder and postorder traversals of a full binary
 *      tree. Your task is to construct the binary tree and return its root.
 *
 *      Note:  Full Binary Tree is a binary tree where every node has either 0 or 2 children. The preorder and
 *             postorder traversals contain unique values, and every value present in the preorder traversal is
 *             also found in the postorder traversal.
 *    Ex.
 *      input : pre =  {1, 2, 4, 5, 6, 8, 9, 10, 11, 7, 3}
 *              post = {4, 8, 10, 11, 9, 6, 7, 5, 2, 3, 1}
 *      output: The tree will look like this:                                    1
 *                                                                              / \
 *                                                                             2   3
 *                                                                            / \
 *                                                                           4   5
 *                                                                              / \
 *                                                                             6   7
 *                                                                            / \
 *                                                                           8   9
 *                                                                              / \
 *                                                                            10   11
 *
 * Constraints:
 *        1 ≤ number of nodes ≤ 10³
 *        1 ≤ pre[i], post[i] ≤ 10⁴
 */

import java.util.*;

public class T13_Construct_Tree_from_Preorder_and_Postorder {

    /// Structure
    static class Node {
        int data;
        Node left, right;

        Node(int val) {
            data = val;
        }
    }

    // print level-order of a tree
    private static ArrayList<String> levelOrder(Node root) {
        ArrayList<String> result = new ArrayList<>();
        if (root == null) return result;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node == null) {
                result.add("N");
                continue;
            }

            result.add(String.valueOf(node.data));

            // Always enqueue both children, even if null
            queue.add(node.left);
            queue.add(node.right);
        }

        // Optional: trim trailing "N" values for cleaner output
        int i = result.size() - 1;
        while (i >= 0 && result.get(i).equals("N"))
            result.remove(i--);

        return result;
    }

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter pre-order elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] pre = new int[n];
        int[] post = new int[n];

        System.out.println("Enter post-order elements: ");
        for (int i = 0; i < n; i++) {
            pre[i] = Integer.parseInt(s[i]);
            post[i] = sc.nextInt();
        }

        // print level-order
        System.out.println("Level order of that tree: ");
        System.out.println(levelOrder(constructTree(pre, post)));
    }

    /// Solution
    static Node constructTree(int[] pre, int[] post) {
        // potd.code.hub
        int n = pre.length;

        HashMap<Integer, Node> valueNodeMap = new HashMap<>();  // also works as visited array.
        HashMap<Integer, Integer> postIdxMap = new HashMap<>(); // used to get the index of element.

        for (int i = 0; i < n; i++)
            postIdxMap.put(post[i], i);

        Node head = new Node(pre[0]);
        valueNodeMap.put(pre[0], head);

        for (int i = 0; i < n; i++) {
            Node temp = valueNodeMap.get(pre[i]);
            if (isSafe(i, pre, postIdxMap.get(pre[i]), post, n, valueNodeMap)) {
                int leftVal = pre[i + 1];
                int rightVal = post[postIdxMap.get(pre[i]) - 1];
                temp.left = new Node(leftVal);
                temp.right = new Node(rightVal);
                valueNodeMap.put(leftVal, temp.left);
                valueNodeMap.put(rightVal, temp.right);
            }
        }

        return head;
    }

    // helper method --> ensures current node is not a leaf node
    private static boolean isSafe(int preIdx, int[] pre, int postIdx, int[] post, int n, HashMap<Integer, Node> map) {
        return preIdx < n - 1 && postIdx > 0 && !map.containsKey(pre[preIdx + 1]) && !map.containsKey(post[postIdx - 1]);
    }
}
