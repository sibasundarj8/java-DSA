package GFG_160;/*
 * 
 * https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
 *
 * # Directed Graph Cycle
 *
 *   Q. Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, check
 *      whether it contains any cycle or not.
 *
 *      The graph is represented as a 2D vector edges[][], where each entry edges[i] = [u, v]
 *      denotes an edge from vertices u to v.
 *   Ex.
 *      Input : V = 4
 *              edges[][] = [[0, 1],
 *                           [1, 2],
 *                           [2, 3],
 *                           [3, 3]]
 *      Output: true                   (0)------------>(1)
 *                                                      |
 *                                                      |
 *                                     ___              |
 *                                     \ ↙              |
 *                                     (3)<------------(2)
 *      Explanation: 3 -> 3 is a cycle
 */
import java.util.ArrayList;

public class GFG_144_Directed_Graph_Cycle {

    /// main Method
    public static void main(String[] args) {
        int[][]edges = {{0, 1},
                        {1, 2},
                        {2, 3},
                        {3, 3}};
        int v = 4;

        System.out.println(isCyclic(v, edges));
    }

    /// Solution
    static boolean isCyclic(int v, int[][] edges) {
        // potd.code.hub
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(v);
        for (int i = 0;i < v;i++) adj.add(new ArrayList<>());

        for (int[] i : edges)
            adj.get(i[0]).add(i[1]);

        boolean[] visited = new boolean[v];
        boolean[] backEdge = new boolean[v];

        for (int i = 0;i < v;i++)
            if (!visited[i])
                if(dfs(i, adj, visited, backEdge))
                    return true;

        return false;
    }
    private static boolean dfs (int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] backEdge){
        visited[node] =  true;
        backEdge[node] = true;
        for (int i : adj.get(node))
            if (!visited[i] && dfs(i, adj, visited, backEdge) || backEdge[i])
                return true;
        backEdge[node] = false;
        return false;
    }
}
