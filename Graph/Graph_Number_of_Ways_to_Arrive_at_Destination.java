package Graph;/*
 *
 * https://www.geeksforgeeks.org/problems/number-of-ways-to-arrive-at-destination/1
 *
 * # Number of Ways to Arrive at Destination
 *
 *   Q. You are given an undirected weighted graph with V vertices numbered from 0 to V-1 and E edges, represented as a
 *      2D array edges[][], where edges[i] = [u_i, v_i, time_i] means that there is an undirected edge between nodes u_i
 *      and v_i that takes time_i minutes to reach.
 *
 *      Your task is to return in how many ways you can travel from node 0 to node V - 1 in the shortest amount of time.
 *    Ex.
 *      Input : V = 6,                                                         [3]
 *              edges[][] = [[0, 2, 3],                                       / |
 *                           [0, 4, 2],                                   1 /   |
 *                           [0, 5, 7],                                   /     | 3
 *                           [2, 3, 1],                                [2]__    |
 *                           [2, 5, 5],                                 |  5 \  |
 *                           [5, 3, 3],                               3 |      [5]
 *                           [5, 1, 4],                                 | ___/  |  \ 4
 *                           [1, 4, 1],                                [0]  7   |    \
 *                           [4, 5, 5]]                                   \     | 5  [1]
 *      Output: 4                                                         2 \   |    /
 *      Explanation: The shortest path from 0 to 5 is 7.                      \ |  /   1
 *                   Four ways to reach 5 in 7 minutes a re:                   [4]
 *                   0 -> 5
 *                   0 -> 4 -> 5
 *                   0 -> 4 -> 1 -> 5
 *                   0 -> 2 -> 3 -> 5
 *
 *  Constraints:
 *          1 ≤ V ≤ 200
 *          V - 1 ≤ edges.size() ≤ V * (V - 1) / 2
 *          0 ≤ u_i, v_i ≤ V - 1
 *          1 ≤ time_i ≤ 10⁵
 *          u_i != v_i
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Graph_Number_of_Ways_to_Arrive_at_Destination {

    /// main Method
    public static void main(String[] args) {
        int v = 4;
        int[][] edges = {
                {0, 1, 2},
                {1, 2, 3},
                {0, 3, 5},
                {1, 3, 3},
                {2, 3, 4}
        };

        System.out.println("min cost path count: " + countPaths(v, edges));
    }

    /// Solution
    public static int countPaths(int v, int[][] edges) {
        // potd.code.hub
        ArrayList<ArrayList<int[]>> adjList = adjList(v, edges);
        boolean[] visited = new boolean[v];
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int min = Integer.MAX_VALUE;
        int ans = 0;

        q.add(new int[]{0, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int vl = cur[0];
            int wt = cur[1];

            visited[vl] = true;
            if (vl == v - 1) {
                min = Math.min(min, wt);
                if (wt == min) ans++;
            }

            for (int[] neighbour : adjList.get(vl)) {
                int neighbourVal = neighbour[0];
                int neighbourWt = neighbour[1];

                if (!visited[neighbourVal])
                    q.add(new int[]{neighbourVal, wt + neighbourWt});
            }
        }

        return ans;
    }

    // converting edges array to adjacency list.
    private static ArrayList<ArrayList<int[]>> adjList(int v, int[][] edges) {
        ArrayList<ArrayList<int[]>> list = new ArrayList<>();
        for(int i = 0; i < v; i++) list.add(new ArrayList<>());

        for(int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            int wt = edge[2];
            list.get(a).add(new int[]{b, wt});
            list.get(b).add(new int[]{a, wt});
        }

        return list;
    }
}
