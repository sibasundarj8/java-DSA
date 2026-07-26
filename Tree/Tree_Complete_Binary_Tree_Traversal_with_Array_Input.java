package Tree;/*
 *
 * https://www.geeksforgeeks.org/problems/print-binary-tree-levels-in-sorted-order3241/1
 *
 * # Complete Binary Tree Traversal with Array Input
 *
 *   Q. Given an integer array arr[] representing the nodes of a Complete Binary Tree in level order traversal, return
 *      the nodes at each level in sorted ascending order.
 *
 *      For every level of the binary tree, sort the values present at that level independently and return the resulting
 *      levels as a 2D array, where the i-th row contains the sorted values of the i-th level.
 *
 *    Ex.
 *      Input : arr[] = [7, 6, 5, 4, 3, 2, 1]
 *      Output: [[7], [5, 6], [1, 2, 3, 4]]
 *      Explanation: The complete binary tree formed from the given level order traversal is:
 *                                                                       7
 *                                                                     /   \
 *                                                                    6     5
 *                                                                   / \   / \
 *                                                                  4   3 2   1
 *                   The nodes at each level after sorting are:
 *                      ◦ Level 0: [7]
 *                      ◦ Level 1: [5, 6]
 *                      ◦ Level 2: [1, 2, 3, 4]
 *
 *  Constraints:
 *        ◦ 1 ≤ arr.size() ≤ 10⁴
 *        ◦ 1 ≤ arr[i] ≤ 10⁹
 */

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Tree_Complete_Binary_Tree_Traversal_with_Array_Input {

    /// main Method
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        bw.write("Enter the tree in form of array: \n");
        bw.flush();
        st = new StringTokenizer(br.readLine().trim());
        int n = st.countTokens();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write("Level order traversal: (sorted order) \n");
        bw.flush();
        ArrayList<ArrayList<Integer>> ans = levelSort(arr);
        for (ArrayList<Integer> list : ans) {
            bw.write(list.toString());
            bw.newLine();
        }

        bw.flush();
    }

    /// Solution
    static ArrayList<ArrayList<Integer>> levelSort(int[] arr) {
        // potd.code.hub
        int n = arr.length;
        ArrayList<ArrayList<Integer>> levelOrder = new ArrayList<>();

        int start = 0;
        int end = 0;

        while (start < n) {
            ArrayList<Integer> level = new ArrayList<>();

            for (int i = start; i <= end; i++) {
                level.add(arr[i]);
            }

            level.sort(null);
            levelOrder.add(level);

            start = (start << 1) + 1;
            end = Math.min(n - 1, (end << 1) + 2);
        }

        return levelOrder;
    }
}
