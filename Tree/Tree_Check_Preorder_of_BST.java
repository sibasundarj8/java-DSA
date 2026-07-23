package Tree;/*
 *
 * https://www.geeksforgeeks.org/problems/preorder-traversal-and-bst4006/1
 *
 * # Check Preorder of BST
 *
 *   Q. Given an array arr[ ] consisting of distinct integers, check if the given array can represent preorder traversal
 *      of a BST.
 *
 *    Ex.
 *      Input : arr[] = [2, 4, 3]
 *      Output: true
 *      Explanation: Given arr[] can represent preorder traversal of following BST:
 *
 *  Constraints:
 *        ◦ 1 ≤ arr.size() ≤ 10⁵
 *        ◦ 0 ≤ arr[i] ≤ 10⁵
 */

import java.util.ArrayDeque;
import java.util.List;

public class Tree_Check_Preorder_of_BST {

    /// main Method
    public static void main(String[] args) {
        System.out.println(canRepresentBST(List.of(1, 6, 2, 4, 3, 5, 7, 9, 8, 10)));
    }

    /// Solution
    static boolean canRepresentBST(List<Integer> arr) {
        // potd.code.hub
        int root = Integer.MIN_VALUE;
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int val : arr) {
            if (val <= root) return false;

            while (!stack.isEmpty() && val >= stack.peek()) {
                root = stack.poll();
            }

            stack.push(val);
        }

        return true;
    }
}
