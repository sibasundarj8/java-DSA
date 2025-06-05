package Graph;/*
 *
 * https://www.geeksforgeeks.org/problems/count-the-paths4332/1
 *
 * # Count the paths
 *
 *    Q. Given a Directed Acyclic Graph (DAG) with V nodes labeled from 0 to V-1, and a list of directed edges,
 *       count the total number of distinct paths from a given start node to a destination node. Each edge is
 *       represented as edges[i] = [u, v], indicating a directed edge from u to v.
 *    Ex.
 *      Input : edges[][] = [[0,1],
 *                           [0,3],
 *                           [2,0],
 *                           [2,1],
 *                           [1,3]]
 *              V = 4
 *              src = 2
 *              dest = 3
 *      Output: 3
 *      Explanation: There are three ways to reach at 3 from 2. These are: 2 -> 1 -> 3, 2 -> 0 -> 3 and
 *                                                                         2 -> 0 -> 1 -> 3.
 */

import java.util.ArrayList;
import java.util.Arrays;

public class Graph_Count_the_paths {

    /// main Method
    public static void main(String[] args) {
        int[][] edges = {
                {0, 1},
                {0, 3},
                {2, 0},
                {2, 1},
                {1, 3}
        };
      
        int v = 4;
        int src = 2;
        int dest = 3;

        System.out.println("number of paths from " + src + " to " + dest + " : " + countPaths(edges, v, src, dest));
    }

    /// Solution
    static int countPaths(int[][] edges, int v, int src, int dest) {
        // potd.code.hub
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] dp = new int[v];
        Arrays.fill(dp, -1);

        // making adjacency list
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] i : edges) {
            int a = i[0];
            int b = i[1];
            adj.get(a).add(b);
        }

        return f(adj, src, dest, new boolean[v], dp);
    }

    private static int f(ArrayList<ArrayList<Integer>> adj, int src, int dest, boolean[] visited, int[] dp) {
        // base case
        if (visited[src]) return 0;
        if (src == dest) return 1;
        if (dp[src] != -1) return dp[src];

        // self work
        visited[src] = true;
        int ans = 0;
        
        // recursive call
        for (int i : adj.get(src)) {
            ans += f(adj, i, dest, visited, dp);
        }

        // backtracking
        visited[src] = false;

        return dp[src] = ans;
    }
}
