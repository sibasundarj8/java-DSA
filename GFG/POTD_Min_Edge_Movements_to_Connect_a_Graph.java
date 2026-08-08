package GFG;/*
 *
 * https://www.geeksforgeeks.org/problems/connecting-the-graph/1
 *
 * # Min Edge Movements to Connect a Graph
 *
 *   Q. Given a graph with n vertices (0 to n-1) and m edges. You can remove one edge from anywhere and add that edge
 *      between any two vertices in one operation.
 *
 *      Find the minimum number of operations that will be required to connect the graph. If it is not possible to
 *      connect the graph, return -1.
 *
 *    Ex.
 *      Input : n = 6, edges[][] = [[0,1], [0,2], [0,3], [1,2], [1,3]]
 *                                                                         (0)-----(2)     (4)
 *                                                                          | \   / |
 *                                                                          |   x   |
 *                                                                          | /   \ |
 *                                                                         (1)     (3)     (5)
 *      Output: 2
 *      Explanation: Remove edge between (1,2) and(0,3) and
 *                   add edge between (1,4) and (3,5)                      (0)-----(2)     (4)
 *                                                                          |       |       |
 *                                                                          |       |       |
 *                                                                          |       |       |
 *                                                                         (1)     (3)-----(5)
 *  Constraints:
 *        ◦ 1 ≤ n ≤ 10⁵
 *        ◦ 1 ≤ m ≤ 10⁵
 *        ◦ 2 ≤ m (cols) ≤ 2
 *        ◦ edges[i][j] < n
 *        ◦ edges.rows ≤ m
 *        ◦ There are no multi-edges in the graph.
 */

import java.util.ArrayList;
import java.util.List;

public class POTD_Min_Edge_Movements_to_Connect_a_Graph {

    /// main Method
    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {
                {0, 1},
                {0, 2},
                {0, 3},
                {1, 2},
                {1, 3}
        };

        System.out.print("""
                graph:
                        (0)-----(2)     (4)
                         | \\   / |
                         |   x   |
                         | /   \\ |
                        (1)     (3)     (5)
                
                Minimum number of edge movement required to connect all the components :
                """);
        System.out.println(minEdgesReq(n, edges));
    }

    /// Solution
/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯--DFS--⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(n + m)
SC : O(n + m)
*/
    static int approach_1(int n, int[][] edges) {
        // potd.code.hub
        if (edges.length < n - 1) return -1;

        int componentCount = 0;
        List<Integer>[] adjList = mapToAdjList(n, edges);
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, adjList, visited);
                componentCount++;
            }
        }

        return componentCount - 1;
    }

    private static void dfs(int src, List<Integer>[] adjList, boolean[] visited) {
        for (int v : adjList[src]) {
            if (!visited[v]) {
                visited[v] = true;
                dfs(v, adjList, visited);
            }
        }
    }

    private static List<Integer>[] mapToAdjList(int n, int[][] edges) {
        List<Integer>[] adjList = new List[n];

        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjList[u].add(v);
            adjList[v].add(u);
        }

        return adjList;
    }

/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯--DSU--⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(n + m)
TC : O(n)
*/
    static int minEdgesReq(int n, int[][] edges) {
        if (edges.length < n - 1) return -1;

        int[] parents = new int[n];

        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        for (int[] edge : edges) {
            join(edge[0], edge[1], parents);
        }

        int componentCount = 0;

        for (int i = 0; i < n; i++) {
            if (parents[i] == i) {
                componentCount++;
            }
        }

        return componentCount - 1;
    }

    private static void join(int a, int b, int[] parents) {
        // base case
        int parentA = getParent(a, parents);
        int parentB = getParent(b, parents);

        if (parentA != parentB) {
            parents[parentB] = parentA;
        }
    }

    private static int getParent(int child, int[] parents) {
        if (child == parents[child]) {
            return child;
        }

        return parents[child] = getParent(parents[child], parents);
    }
}
