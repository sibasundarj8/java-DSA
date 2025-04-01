package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1
 *
 * # DFS of Graph
 *
 *   Q. Given a connected undirected graph represented by a 2-d adjacency list adj[][], where each adj[i]
 *      represents the list of vertices connected to vertex i. Perform a Depth-First Search (DFS) traversal
 *      starting from vertex 0, visit vertices from left to right as per the given adjacency list, and return
 *      a list containing the DFS traversal of the graph.
 *
 *      Note: Do traverse in the same order as they are in the given adjacency list.
 *   Ex.
 *      Input : adj[][] = [[2, 3, 1],            (0)
 *                         [0],                 / | \
 *                         [0, 4],            /   |  \
 *                         [0],            (2)    |  (1)
 *                         [2]]             |    (3)
 *      Output: [0, 2, 4, 3, 1]            (4)
 *      Explanation: Starting from 0, the DFS traversal proceeds as follows:
 *              Visit 0 → Output: 0
 *              Visit 2 (the first neighbor of 0) → Output: 0, 2
 *              Visit 4 (the first neighbor of 2) → Output: 0, 2, 4
 *              Backtrack to 2, then backtrack to 0, and visit 3 → Output: 0, 2, 4, 3
 *              Finally, backtrack to 0 and visit 1 → Final Output: 0, 2, 4, 3, 1
 */

import java.util.ArrayList;
import java.util.List;

public class GFG_138_DFS_of_Graph {

    /// main Method
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        adj.add(new ArrayList<>(List.of(2, 3, 1)));
        adj.add(new ArrayList<>(List.of(0)));
        adj.add(new ArrayList<>(List.of(0, 4)));
        adj.add(new ArrayList<>(List.of(0)));
        adj.add(new ArrayList<>(List.of(2)));

        System.out.println(dfs(adj));
    }

    /// Solution
    static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // potd.code.hub
        ArrayList<Integer> ans = new ArrayList<>();
        dfs(0, adj, new boolean[adj.size()], ans);
        
        return ans;
    }
    private static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> ans){
        visited[node] = true;
        ans.add(node);
        for (int i : adj.get(node))
            if (!visited[i])
                dfs(i, adj, visited, ans);
    }
}
