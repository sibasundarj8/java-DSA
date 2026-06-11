package LeetCode;/*
 *
 * https://leetcode.com/problems/number-of-ways-to-assign-edge-weights-i/
 *
 * # LC. 3558. Number of Ways to Assign Edge Weights I
 *
 *   Q. There is an undirected tree with n nodes labeled from 1 to n, rooted at node 1. The tree is represented by a 2D
 *      integer array edges of length n - 1, where edges[i] = [ui, vi] indicates that there is an edge between nodes u_i
 *      and v_i.
 *
 *      Initially, all edges have a weight of 0. You must assign each edge a weight of either 1 or 2.
 *
 *      The cost of a path between any two nodes u and v is the total weight of all edges in the path connecting them.
 *
 *      Select any one node x at the maximum depth. Return the number of ways to assign edge weights in the path from node
 *      1 to x such that its total cost is odd.
 *
 *      Since the answer may be large, return it modulo 109 + 7.
 *
 *      Note: Ignore all edges not in the path from node 1 to x.
 *
 *    Ex.
 *      Input : edges = [[1, 2],
 *                       [1, 3],
 *                       [3, 4],
 *                       [3, 5]]
 *      Output: 2
 *      Explanation:
 *              The maximum depth is 2, with nodes 4 and 5 at the same depth. Either node can be selected for processing.
 *              For example, the path from Node 1 to Node 4 consists of two edges (1 → 3 and 3 → 4).
 *              Assigning weights (1,2) or (2,1) results in an odd cost. Thus, the number of valid assignments is 2.
 *
 *  Constraints:
 *        ◦ 2 <= n <= 10⁵
 *        ◦ edges.length == n - 1
 *        ◦ edges[i] == [u_i, v_i]
 *        ◦ 1 <= u_i, v_i <= n
 *        ◦ edges represents a valid tree.
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class LeetCode_3558_Number_of_Ways_to_Assign_Edge_Weights_I {

    /// main Method
    public static void main(String[] args) {
        int[][] edges = {
                {1, 2},
                {1, 3},
                {3, 4},
                {3, 5}
        };

        System.out.print("""
                The number of ways to assign edge weights on deepest path such
                that its total cost is odd :
                """);
        System.out.println(assignEdgeWeights(edges));
    }

    /// Solution
    private static final int MOD = (int) (1e9 + 7);

    static int assignEdgeWeights(int[][] edges) {
        // potd.code.hub
        int depth = -1;

        boolean[] visited = new boolean[edges.length + 2];
        ArrayList<ArrayList<Integer>> adjList = mapToAdjList(edges);
        Queue<Integer> q = new ArrayDeque<>();

        q.add(1);
        visited[1] = true;

        while (!q.isEmpty()) {
            depth++;
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int curr = q.poll();

                for (int next : adjList.get(curr)) {
                    if (visited[next]) continue;
                    q.add(next);
                    visited[next] = true;
                }
            }
        }

        // permutation and combination on depth;
        return (int) modularPowOf2(depth - 1);
    }

    private static ArrayList<ArrayList<Integer>> mapToAdjList(int[][] edges) {
        int n = edges.length;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        for (int i = 0; i <= n + 1; i++) {
            res.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            res.get(u).add(v);
            res.get(v).add(u);
        }

        return res;
    }

    private static long modularPowOf2(int n) {
        // base case
        if (n < 32) return (1L << n);

        // recursive case
        long x = modularPowOf2(n / 2) % MOD;

        // self work
        x = x * x % MOD;
        return ((n & 1) == 0) ? x : x * 2 % MOD;
    }
}
