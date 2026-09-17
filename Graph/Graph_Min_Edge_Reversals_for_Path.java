package Graph;/*
 *
 * https://www.geeksforgeeks.org/problems/minimum-edges/1
 *
 * # Min Edge Reversals for Path
 *
 *   Q. Given a directed graph with n vertices numbered from 1 to n. The graph is represented using a 2D array
 *      edges[][] of size m, where each entry edges[i] = [u, v] denotes a directed edge from vertex u to vertex v.
 *      You are also given a source vertex src and a destination vertex dst.
 *
 *      Find the minimum number of edges that need to be reversed so that there exists at least one path from src
 *      to dst.
 *
 *      If it is not possible to create a path from src to dst, return -1.
 *
 *    Ex.
 *      Input : n = 3,
 *              edges[][] = [[1, 2],
 *                           [3, 2]],
 *              src = 1,                1  --->  2  <---  3
 *              dst = 3
 *      Output: 1
 *      Explanation: Reverse the edge 3 -> 2.
 *
 *  Constraints:
 *        ◦ 1 ≤ n, m ≤ 10⁵
 *        ◦ 1 ≤ edges[i][0], edges[i][1] ≤ n
 *        ◦ 1 ≤ src, dst ≤ n
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph_Min_Edge_Reversals_for_Path {

    /// main Method
    public static void main(String[] args) {
        int[][] edges = {
                {1, 2},
                {3, 2}
        };

        int n = 3;
        int src = 1;
        int dst = 3;

        System.out.print("""
                graph:
                        1  --->  2  <---  3
                
                Minimum number of edges that need to be reversed so that there exists at least one path from src
                to dst:
                """);
        System.out.println(minimumEdgeReversal(edges, n, src, dst));
    }

    /// Solution
    static int minimumEdgeReversal(int[][] edges, int n, int src, int dst) {
        // potd.code.hub
        List<List<Integer>> adjList = mapToAdjListWithReverseEdges(edges, n);
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        int[] costs = new int[n + 1];

        Arrays.fill(costs, Integer.MAX_VALUE);

        // 0-1 BFS
        int u, v, w;
        int cost, newCost;
        dq.add(src);
        costs[src] = 0;

        while (!dq.isEmpty()) {
            u = dq.poll();
            cost = costs[u];

            if (u == dst) return cost;

            for (int packedNext : adjList.get(u)) {
                v = packedNext >> 1;
                w = packedNext & 1;
                newCost = cost + w;

                if (newCost < costs[v]) {
                    costs[v] = newCost;

                    if (w == 0) dq.addFirst(v);
                    else dq.addLast(v);
                }
            }
        }

        return -1;
    }

    private static List<List<Integer>> mapToAdjListWithReverseEdges(int[][] edges, int n) {
        List<List<Integer>> adjList = new ArrayList<>();
        int u, v;

        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            u = edge[0];
            v = edge[1];

            /*
                I basically packed two information in bits.
                  ---> next node
                  ---> edge weight. it can be either 0 or 1 so only LSB is enough to store that.
            */
            adjList.get(u).add(v << 1);         // LSB --> 0
            adjList.get(v).add((u << 1) | 1);   // LSB --> 1
        }

        return adjList;
    }
}
