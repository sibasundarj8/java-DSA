package Graph;/*
 *
 * https://www.geeksforgeeks.org/problems/mother-vertex/1
 *
 * # Mother Vertex
 *
 *   Q. Given a directed graph with V vertices labeled from 0 to V-1 and a list of edges edges[][], where each edge is
 *      represented as [u, v] indicating a directed edge from vertex u to vertex v, find a Mother Vertex of the graph.
 *
 *      A Mother Vertex is a vertex from which all other vertices can be reached.
 *
 *        ◦ If multiple such vertices exist, return the one with the smallest value.
 *        ◦ If no such vertex exists, return -1.
 *
 *    Ex.
 *      Input : V = 5, edges[][] = [[0, 2], [0, 3], [1, 0], [2, 1], [3, 4]]
 *      Output: 0
 *      Explanation: Vertices 0, 1, and 2 can each reach all other vertices in the graph. Among them, 0 is the smallest,
 *                   so the output is 0.
 *                                            (1) ─────────▶ (0) ─────────▶ (3)
 *                                             ▲              │              │
 *                                             │              │              │
 *                                             │              ▼              ▼
 *                                             └─────────────(2)            (4)
 *
 *  Constraints:
 *          1 ≤ V ≤ 10⁵
 *          1 ≤ edges[i][0], edges[i][1] ≤ V-1
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph_Mother_Vertex {

    /// main Method
    public static void main(String[] args) {
        int v = 5;
        int[][] edges = {{0, 2}, {0, 3}, {1, 0}, {2, 1}, {3, 4}};

        System.out.print("""
                graph:
                 (1) ─────────▶ (0) ─────────▶ (3)
                  ▲              │              │
                  │              │              │
                  │              ▼              ▼
                  └─────────────(2)            (4)
                
                Mother Vertex of the graph:
                """);
        System.out.println(findMotherVertex(v, edges));
    }

    /// Solution
    static int findMotherVertex(int V, int[][] edges) {
        // potd.code.hub
        List<List<Integer>> adjList = mapToAdjacencyList(V, edges);
        boolean[] visited = new boolean[V];
        int candidate = -1;

        // find
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, adjList, visited);
                candidate = i;
            }
        }

        // verify
        Arrays.fill(visited, false);
        dfs(candidate, adjList, visited);

        for (boolean flag : visited) {
            if (!flag) return -1;
        }

        return candidate;
    }

    // dfs traversal
    private static void dfs(int src, List<List<Integer>> adjList, boolean[] visited) {
        visited[src] = true;

        for (int next : adjList.get(src)) {
            if (!visited[next]) {
                dfs(next, adjList, visited);
            }
        }
    }

    // convert edges array to adjacency list
    private static List<List<Integer>> mapToAdjacencyList(int v, int[][] edges) {
        List<List<Integer>> adjacencyList = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
        }

        return adjacencyList;
    }
}
