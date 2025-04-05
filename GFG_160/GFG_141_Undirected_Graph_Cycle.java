package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
 *
 * # Undirected Graph Cycle
 *
 *   Q. Given an undirected graph with V vertices and E edges, represented as a 2D vector
 *      edges[][], where each entry edges[i] = [u, v] denotes an edge between vertices u and
 *      v, determine whether the graph contains a cycle or not.
 *    Ex.
 *      Input : V = 4
 *              E = 4
 *              edges[][] = [[0, 1],
 *                           [0, 2],
 *                           [1, 2],
 *                           [2, 3]]
 *      Output: true
 *      Explanation:
 *                     <1>---<2>
 *                      |   / |
 *                      |  /  |
 *                      | /   |
 *                     <0>   <3>
 *
 *              1 -> 2 -> 0 -> 1 is a cycle.
 */
import java.util.ArrayList;

public class GFG_141_Undirected_Graph_Cycle {

    /// main Method
    public static void main(String[] args) {
        int[][]edges = {{0, 1}, {1, 2}, {1, 3}, {2, 4}, {3, 4}, {4, 5}};
        int v = 6;

        System.out.println(isCycle(v, edges));
    }

    /// Solution
    static boolean isCycle(int v, int[][] edges) {
        // potd.code.hub
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(v);
        for (int i = 0;i < v;i++) adj.add(new ArrayList<>());
        for (int[] i : edges){
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);
        }
        
        boolean[]visited = new boolean[v];

        for (int i = 0;i < v;i++)
            if (!visited[i])
                if (dfs(i, -1, adj, visited)) return true;

        return false;
    }

    

/// BFS (Breadth First Search)
    /*private static boolean bfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(node, -1));
        visited[node] = true;
        while (!q.isEmpty()){
            Pair p = q.poll();
            for (int i : adj.get(p.v)){
                if (!visited[i]){
                    visited[i] = true;
                    q.add(new Pair(i, p.v));
                }
                else if (i != p.p) return true;
            }
        }
        return false;
    }
    private static class Pair{
        int p;
        int v;
        Pair (int v, int p){
            this.p = p;
            this.v = v;
        }
    }*/



///  DFS (Depth First Search)
    private static boolean dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] visited){
        visited[node] = true;
        for (int i : adj.get(node)){
            if (!visited[i]) {
                if (dfs(i, node, adj, visited)) {
                    return true;
                }
            }
            else if (i != parent){
                return true;
            }
        }
        return false;
    }
}
