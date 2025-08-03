package Tree;/*
 *
 * https://www.geeksforgeeks.org/problems/array-to-bst4443/1
 *
 * # Array to BST
 *
 *   Q. Given a sorted array. Convert it into a Height Balanced Binary Search Tree (BST). Return the root of the BST.
 *
 *      Height-balanced BST means a binary tree in which the depth of the left subtree and the right subtree of every
 *      node never differ by more than 1.
 *
 *      Note: The driver code will check the BST, if it is a Height-balanced BST, the output will be true
 *            otherwise the output will be false.
 *    Ex.
 *      Input : nums = [1, 2, 3, 4, 5, 6, 7]
 *      Output: true
 *      Explanation: The preorder traversal of the following BST formed is [4, 2, 1, 3, 6, 5, 7]:
 *
 *                                         [4]
 *                                        /   \
 *                                     [2]     [6]
 *                                     / \     / \
 *                                   [1] [3] [5] [7]
 */

import java.util.*;

public class Tree_Array_to_BST {

    ///  Structure
    private static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the node values: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        Arrays.sort(arr);

        Node root = sortedArrayToBST(arr);
        ArrayList<ArrayList<Integer>> ans = levelOrder(root);

        if (ans == null) {
            System.out.println("Null");
            return;
        }

        for (ArrayList<Integer> list : ans) {
            System.out.println(list);
        }
    }

    // level order traversal
    private static ArrayList<ArrayList<Integer>> levelOrder(Node root) {
        // potd.code.hub
        if (root == null) return null;

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();

        q.offer(root);

        while (!q.isEmpty()) {
            ans.add(new ArrayList<>());
            int n = q.size();

            for (int i = 0; i < n; i++) {
                Node temp = q.poll();
                ans.get(ans.size() - 1).add(temp.data);

                if (temp.left != null) q.add(temp.left);
                if (temp.right != null) q.add(temp.right);
            }
        }

        return ans;
    }

    /// Solution
    static Node sortedArrayToBST(int[] nums) {
        // potd.code.hub
        return construct(0, nums.length - 1, nums);
    }

    private static Node construct(int s, int e, int[] nums) {
        // base case
        if (s > e) return null;

        // recursive work
        int mid = s + (e - s) / 2;
        Node left = construct(s, mid - 1, nums);
        Node right = construct(mid + 1, e, nums);

        // self work
        Node cur = new Node(nums[mid]);
        cur.left = left;
        cur.right = right;

        return cur;
    }
}
