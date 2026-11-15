package Contest.weekly_528;/*
 *
 * https://leetcode.com/contest/weekly-contest-528/problems/maximize-score-after-zeroing-subtrees/
 *
 * # Q2. Maximize Score After Zeroing Subtrees
 *
 *   Q. You are given an integer array parent of length n representing a rooted tree with nodes labeled from 0 to n - 1,
 *      where parent[i] denotes the parent of node i. The tree is rooted at node 0, so parent[0] = -1.
 *
 *      You are also given two integer arrays op and score, both of length n, where op[i] determines the operation
 *      allowed at node i, and score[i] represents its score.
 *
 *      You need to process each non-leaf node i according to the following rules:
 *        ◦ If op[i] = 0, you can choose at most one child of node i and set the scores of all nodes in that child's
 *          subtree to 0.
 *
 *        ◦ If op[i] = 1, you must choose exactly one child of node i and set the scores of all nodes in that child's
 *          subtree to 0.
 *
 *      Each non-leaf node must be processed exactly once. You may process the nodes in any order.
 *
 *      Return the maximum possible sum of the scores after performing the operations.
 *
 *      A leaf is a node with no children.
 *
 *      The subtree rooted at a node consists of that node and all of its descendants.
 *
 *    Ex.
 *      Input : parent = [-1, 0, 0, 0, 1, 2, 3, 3],
 *              op = [1, 1, 0, 0, 1, 1, 0, 1],
 *              score = [5, 6, 1, 2, 3, 2, 3, -3]
 *      Output: 16
 *      Explanation:
 *              One optimal way is to process the nodes in the following order:
 *                ◦ Nodes 4, 5, 6, and 7: They are leaf nodes, so no operations are performed on them.
 *
 *                ◦ Node 1: Since op[1] = 1, we must select one of its children. Choose node 4, setting the scores of
 *                  all nodes in its subtree (node 4) to 0.
 *
 *                ◦ Node 2: Since op[2] = 0, we may choose a child or do nothing. For this node, we do nothing.
 *
 *                ◦ Node 3: Since op[3] = 0, we may choose a child or do nothing. Choose node 7, setting the scores of
 *                  all nodes in its subtree (node 7) to 0.
 *
 *                ◦ Node 0: Since op[0] = 1, we must select one of its children. Choose node 2, setting the scores of
 *                  all nodes in its subtree (nodes 2 and 5) to 0.
 *
 *              After performing these operations, the scores are [5, 6, 0, 2, 0, 0, 3, 0], giving a total sum of 16.
 *
 *              No valid sequence of operations can produce a larger sum. Therefore, the answer is 16.
 *
 *  Constraints:
 *        ◦ 1 <= n <= 10⁵
 *        ◦ n == parent.length == op.length == score.length
 *        ◦ parent[0] == -1
 *        ◦ 0 <= parent[i] <= n - 1 for all i in [1, n - 1]
 *        ◦ 0 <= op[i] <= 1
 *        ◦ -10⁴ <= score[i] <= 10⁴
 *        ◦ The input is generated such that the array parent represents a valid tree rooted at node 0.
 */

import java.util.ArrayList;

public class Q2_Maximize_Score_After_Zeroing_Subtrees {

    /// Solution
    public int maxScore(int[] parent, int[] op, int[] score) {
        int n = parent.length;
        int root = 0;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            int p = parent[i];

            if (p != -1) {
                adjList.get(p).add(i);
            } else {
                root = i;
            }
        }

        return calculateScore(root, adjList, op, score);
    }

    private int calculateScore(int src, ArrayList<ArrayList<Integer>> adjList, int[] op, int[] score) {
        // base case
        if (adjList.get(src).isEmpty()) return score[src];

        // recursive work
        int totalScore = score[src];
        int minScore = Integer.MAX_VALUE;

        for (int next : adjList.get(src)) {
            int nextScore = calculateScore(next, adjList, op, score);
            minScore = Math.min(minScore, nextScore);
            totalScore += nextScore;
        }

        // self work
        if (op[src] == 1 || (op[src] == 0 && minScore < 0)) {
            totalScore -= minScore;
        }

        return totalScore;
    }
}