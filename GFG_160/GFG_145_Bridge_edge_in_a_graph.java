package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/bridge-edge-in-graph/1
 *
 * # Bridge edge in a graph
 *
 *   Q. Given an undirected graph with V vertices numbered from 0 to V-1 and E edges, represented
 *      by 2d array edges[][], where edges[i]=[u,v] represents the edge between the vertices u and
 *      v. Determine whether a specific edge between two vertices (c, d) is a bridge.
 *
 *      Note:
 *          An edge is called a bridge if removing it increases the number of connected components
 *          of the graph. If there’s only one path between c and d (which is the edge itself), then
 *          that edge is a bridge.
 *
 *   Ex.
 *      Input : c = 0, d = 2
 *              edges[][] = {{1, 0},
 *                           {1, 2},
 *                           {2, 0},
 *                           {0, 3},
 *                           {3, 4}}
 *      Output: false
 *      Explanation: Blocking the edge between nodes 0 and 2 won't affect the connectivity of
 *                   the graph. So, it's not a Bridge Edge. All the Bridge Edges in the graph
 *                   are marked with a blue line in the above image.
 */

import java.util.ArrayList;

public class GFG_145_Bridge_edge_in_a_graph {

    /// main Method
    public static void main(String[] args) {
        int[][] edges = {{1, 0},
                         {1, 2},
                         {2, 0},
                         {0, 3},
                         {3, 4}};
        int v = 5;
        int c = 0;
        int d = 2;

        System.out.println(isBridge(v, edges, c, d));
    }

    /// Solution
    static boolean isBridge(int v, int[][] edges, int c, int d) {
        // potd.code.hub
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0;i < v;i++)
            adj.add(new ArrayList<>());
        // add all edges except edge between c and d.
        for (int[] i : edges){
            if (i[0] == c && i[1] == d || i[1] == c && i[0] == d){
                continue;
            }
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);
        }
        boolean[] visited = new boolean[v];
        dfs(c, adj, visited);

        return !visited[d];
    }
    private static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited){
        visited[node] =  true;
        for (int i : adj.get(node))
            if (!visited[i])
                dfs(i, adj, visited);
    }
}
