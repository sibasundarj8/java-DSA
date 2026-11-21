package LeetCode;/*
 *
 * https://leetcode.com/problems/find-subtree-sizes-after-changes/
 *
 * # LC. 3331. Find Subtree Sizes After Changes
 *
 *   Q. You are given a tree rooted at node 0 that consists of n nodes numbered from 0 to n - 1. The tree is represented
 *      by an array parent of size n, where parent[i] is the parent of node i. Since node 0 is the root, parent[0] == -1.
 *
 *      You are also given a string s of length n, where s[i] is the character assigned to node i.
 *
 *      We make the following changes on the tree one time simultaneously for all nodes x from 1 to n - 1:
 *
 *        ◦ Find the closest node y to node x such that y is an ancestor of x, and s[x] == s[y].
 *        ◦ If node y does not exist, do nothing.
 *        ◦ Otherwise, remove the edge between x and its current parent and make node y the new parent of x by adding an
 *          edge between them.
 *
 *      Return an array answer of size n where answer[i] is the size of the subtree rooted at node i in the final tree.
 *
 *    Ex.
 *      Input : parent = [-1, 0, 0, 1, 1, 1], s = "abaabc"
 *      Output: [6, 3, 1, 1, 1, 1]
 *      Explanation: The parent of node 3 will change from node 1 to node 0.
 *
 *  Constraints:
 *        ◦ n == parent.length == s.length
 *        ◦ 1 <= n <= 10⁵
 *        ◦ 0 <= parent[i] <= n - 1 for all i >= 1.
 *        ◦ parent[0] == -1
 *        ◦ parent represents a valid tree.
 *        ◦ s consists only of lowercase English letters.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LeetCode_3331_Find_Subtree_Sizes_After_Changes {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("parent[] : ");
        String[] s1 = sc.nextLine().split(" ");

        int n = s1.length;
        int[] parent = new int[n];

        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(s1[i]);

            if (val < -1 || val >= n) {
                throw new IllegalArgumentException("Invalid Input");
            }

            parent[i] = val;
        }

        System.out.print("s: ");
        String s = sc.next();

        if (s.length() > n) {
            throw new IllegalArgumentException("Invalid Input");
        }

        System.out.print("res[]: ");
        System.out.println(Arrays.toString(findSubtreeSizes(parent, s)));
    }

    /// Solution
    static int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int c = 0; c < n; c++) {
            int p = parent[c];

            if (p != -1) {
                adjList.get(p).add(c);
            }
        }

        int[] size = new int[n];
        Arrays.fill(size, 1);

        int[] last = new int[26];
        Arrays.fill(last, -1);

        solve(0, adjList, s, size, last);

        return size;
    }

    private static void solve(int i, List<List<Integer>> adjList, String s, int[] size, int[] last) {
        char ch = s.charAt(i);
        int idx = ch - 'a';
        int temp = last[idx];
        last[idx] = i;

        for (int nxt : adjList.get(i)) {
            solve(nxt, adjList, s, size, last);

            if (last[s.charAt(nxt) - 'a'] == -1) {
                size[i] += size[nxt];
            }
        }

        last[idx] = temp;

        if (temp != -1) {
            size[temp] += size[i];
        }
    }
}
