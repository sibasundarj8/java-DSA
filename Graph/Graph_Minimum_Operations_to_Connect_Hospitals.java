package Graph;/*
 *
 * https://www.geeksforgeeks.org/problems/minimize-connections/1
 *
 * # Minimum Operations to Connect Hospitals
 *
 *   Q. You are given an undirected network of V hospitals numbered from 0 to V - 1, represented as a 2D array edges[][],
 *      where each element edges[i] = [u, v] denotes a direct connection between hospital u and hospital v.
 *
 *      In one operation, you are allowed to remove any existing link and reconnect it between two hospitals that are
 *      currently not directly or indirectly connected.
 *
 *      Your task is to determine the minimum number of operations required to make sure that all hospitals become connected,
 *      either directly or indirectly, using the given links.
 *
 *      Note: If it is impossible to connect all hospitals into a single network, return -1.
 *
 *   Ex.
 *      Input : V = 4,                             [0]----[1]
 *              E = 3,                              |     /
 *              edges[][] = [[0, 1],                |   /
 *                           [0, 2],                | /
 *                           [1, 2]]               [2]    [3]
 *      Output: 1
 *      Explanation: Remove the connection between hospitals 1 and 2 and connect the hospitals 1 and 3.
 *
 *  Constraints:
 *          1 ≤ V ≤ 10³
 *          0 ≤ E ≤ V*(V-1)/2
 *          0 ≤ edges[i][0], edges[i][1] < V
 */

import java.util.ArrayList;

public class Graph_Minimum_Operations_to_Connect_Hospitals {

    /// main Method
    public static void main(String[] args) {
        int V = 4;
        int[][] edges = {
                {0, 1},
                {0, 2},
                {1, 2}
        };

        System.out.println("Minimum operation required to connect the hospitals: ");
        System.out.println(minConnect(V, edges));
    }

    /// Solution
    public static int minConnect(int V, int[][] edges) {
        // potd.code.hub
        int E = edges.length;
        if (E < V - 1) return -1;

        boolean[] visited = new boolean[V];
        ArrayList<ArrayList<Integer>> adjList = constructAdjacencyList(V, edges);
        int component = 0;

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                component++;
                dfs(i, adjList, visited);
            }
        }

        return component - 1;
    }

    // Depth first search
    private static void dfs(int src, ArrayList<ArrayList<Integer>> adjList, boolean[] visited) {
        visited[src] = true;

        for (int i : adjList.get(src)) {
            if (!visited[i]) {
                dfs(i, adjList, visited);
            }
        }
    }

    // converting Edges array to Adjacency list
    private static ArrayList<ArrayList<Integer>> constructAdjacencyList(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for (int i = 0; i < V; i++)
            list.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            list.get(u).add(v);
            list.get(v).add(u);
        }

        return list;
    }
}
