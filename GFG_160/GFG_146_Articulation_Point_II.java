package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/articulation-point2616/0
 *
 * # Articulation Point - II
 *
 *   Q. You are given an undirected graph with V vertices and E edges. The graph is represented
 *      as a 2D array edges[][], where each element edges[i] = [u, v] indicates an undirected
 *      edge between vertices u and v.
 *
 *      Your task is to return all the articulation points (or cut vertices) in the graph.
 *      An articulation point is a vertex whose removal, along with all its connected edges,
 *      increases the number of connected components in the graph.
 *
 *      Note: The graph may be disconnected, i.e., it may consist of more than one connected
 *            component.
 *            If no such point exists, return {-1}.
 *    Ex.
 *      Input : V = 5                      <2>---<4>-----<1>
 *              edges[][] = [[0, 1],        |    /        |
 *                           [1, 4],        |   /         |
 *                           [4, 3],        |  /          |
 *                           [4, 2],        | /           |
 *                           [2, 3]]       <3>           <0>
 *      Output: [1, 4]
 *      Explanation: Removing the vertex 1 will disconnect the graph as-
 *
 *                   <2>---<4>
 *                    |    /
 *                    |   /
 *                    |  /
 *                    | /
 *                   <3>    <0>
 *
 *              -> Removing the vertex 4 will disconnect the graph as-
 *
 *                   <2>           <1>
 *                    |             |
 *                    |             |
 *                    |             |
 *                    |             |
 *                   <3>           <0>
 */
import java.util.ArrayList;
import java.util.List;

public class GFG_146_Articulation_Point_II {

    /// main Method
    public static void main(String[] args) {
        int[][] edges = {{0, 1},
                         {1, 4},
                         {4, 3},
                         {4, 2},
                         {2, 3}};
        int v = 5;

        System.out.println(articulationPoints(v, edges));
    }

    /// Solution
    static ArrayList<Integer> articulationPoints(int v, int[][] edges) {
        // potd.code.hub

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(v);
        for (int i = 0;i < v;i++)
            adj.add(new ArrayList<>());
        for (int[] i : edges){
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);
        }

        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[v];
        boolean[] artPoint = new boolean[v];
        int[] tin = new int[v];
        int[] low = new int[v];

        for (int i = 0;i < v;i++) {
            if (!visited[i]) {
                dfs(0, -1, adj, visited, artPoint, tin, low);
            }
        }

        for (int i = 0;i < v;i++){
            if (artPoint[i]){
                ans.add(i);
            }
        }

        return (ans.isEmpty()) ? new ArrayList<>(List.of(-1)) : ans;
    }
    private static int count = 0;
    private static void dfs (int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] point, int[] tin, int[] low){
        visited[node] = true;
        tin[node] = low[node] = count++;

        int child = 0;
        for (int i : adj.get(node)){
            if (i == parent) continue;
            if (!visited[i]){
                dfs(i, node, adj, visited, point, tin, low);
                low[node] = Math.min(low[node], low[i]);
                if (low[i] >= tin[node] && parent != -1){
                    point[node] = true;
                }
                child++;
            }
            else {
                low[node] = Math.min(low[node], tin[i]);
            }
        }

        if (parent == -1 && child > 1){
            point[node] = true;
        }
    }
}
