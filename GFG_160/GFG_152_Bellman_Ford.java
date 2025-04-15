package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1
 *
 * # Bellman-Ford
 *
 *   Q. Given a weighted graph with V vertices numbered from 0 to V-1 and E edges, represented
 *      by a 2d array edges[][], where edges[i] = [u, v, w] represents a direct edge from node
 *      u to v having w edge weight. You are also given source vertex src.
 *
 *      Your task is to compute the shortest distances from the source to all other vertices.
 *      If a vertex is unreachable from the source, its distance should be marked as 108.
 *      Additionally, if the graph contains a negative weight cycle, return [-1] to indicate
 *      that shortest paths cannot be reliably computed.
 *   Ex.
 *      Input : V = 5
 *              edges[][] = [[1, 3, 2],
 *                           [4, 3, -1],
 *                           [2, 4, 1],
 *                           [1, 2, 1],
 *                           [0, 1, 5]]
 *              src = 0                    5         2
 *                                     <0>---→<1>---------→<3>
 *                                             |            ↑
 *                                             |            | -1
 *                                           1 |            |
 *                                             ↓     1      |
 *                                            <2>---------→<4>
 *      Output: [0, 5, 6, 6, 7]
 *      Explanation: Shortest Paths:
 *              For 0 to 1 minimum distance will be 5. By following path 0 → 1
 *              For 0 to 2 minimum distance will be 6. By following path 0 → 1  → 2
 *              For 0 to 3 minimum distance will be 6. By following path 0 → 1  → 2 → 4 → 3
 *              For 0 to 4 minimum distance will be 7. By following path 0 → 1  → 2 → 4
 */
import java.util.Arrays;

public class GFG_152_Bellman_Ford {

    /// main Method
    public static void main(String[] args) {
        int v = 5;
        int[][] edge = {{1, 3, 2},
                        {4, 3,-1},
                        {2, 4, 1},
                        {1, 2, 1},
                        {0, 1, 5}};
        int src = 0;
        System.out.println("""
                Edges:
                   [U][V][Wt]          Graph looks like this:
                    ↓  ↓  ↓
                  {{1, 3, 2},          <0>---→<1>---------→<3>
                   {4, 3,-1},                  |            ↑
                   {2, 4, 1},                  |            | -1
                   {1, 2, 1},                1 |            |
                   {0, 1, 5}}                  ↓     1      |
                                              <2>---------→<4>
                """);

        System.out.println("Shortest path: " + Arrays.toString(bellmanFord(v, edge, src)));
    }

    /// Solution
    static int[] bellmanFord(int V, int[][] edges, int src) {
        // potd.code.hub
        int[] dist = new int[V];
        Arrays.fill(dist, (int) 1e8);
        dist[src] = 0;

        for (int i = 1; i <= V; i++) {
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];
                if (dist[u] != 1e8 && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                    if (i == V) return new int[]{-1};
                }
            }
        }

        return dist;
    }
}
