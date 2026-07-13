package Graph;/*
 *
 * https://leetcode.com/problems/count-the-number-of-complete-components/
 *
 * # LC. 2685. Count the Number of Complete Components
 *
 *   Q. You are given an integer n. There is an undirected graph with n vertices, numbered from 0 to n - 1.
 *      You are given a 2D integer array edges where edges[i] = [a-i, b-i] denotes that there exists an undirected
 *      edge connecting vertices a-i and b-i.
 *
 *      Return the number of complete connected components of the graph.
 *
 *      A connected component is a subgraph of a graph in which there exists a path between any two vertices, and no
 *      vertex of the subgraph shares an edge with a vertex outside the subgraph.
 *
 *      A connected component is said to be complete if there exists an edge between every pair of its vertices.
 *
 *    Ex.
 *      Input : n = 6, edges = [[0,1],[0,2],[1,2],[3,4]]
 *      Output: 3
 *      Explanation: From the picture above, one can see that all the components of this graph are complete.
 *
 *  Constraints:
 *        ◦ 1 <= n <= 50
 *        ◦ 0 <= edges.length <= n * (n - 1) / 2
 *        ◦ edges[i].length == 2
 *        ◦ 0 <= a-i, b-i <= n - 1
 *        ◦ a-i != b-i
 *        ◦ There are no repeated edges.
 */

import java.util.ArrayList;
import java.util.List;

public class Graph_Count_the_Number_of_Complete_Components {

    /// main Method
    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {
                {0, 1},
                {0, 2},
                {1, 2},
                {3, 4}
        };

        System.out.println("""
                Graph:
                         0 ⎯ 1    3
                    5     \\  /     |
                            2      4
                """);

        System.out.println("Number of complete components: ");
        System.out.println(countCompleteComponents(n, edges));
    }

    /// Solution
    static int countCompleteComponents(int n, int[][] edges) {
        // potd.code.hub
        List<List<Integer>> adjList = mapToAdjList(n, edges);
        boolean[] visited = new boolean[n];

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                long[] x = solve(i, adjList, visited);
                int nodeCount = (int) x[0];
                int edgeCount = (int) (x[1] >> 1);
                int requiredEdges = (nodeCount * (nodeCount - 1)) >> 1;

                if (edgeCount == requiredEdges) count++;
            }
        }

        return count;
    }

    private static long[] solve(int u, List<List<Integer>> adjList, boolean[] visited) {
        long[] ans = {1, adjList.get(u).size()}; // [number of nodes, number of edges]

        for (int v : adjList.get(u)) {
            if (!visited[v]) {
                visited[v] = true;
                long[] next = solve(v, adjList, visited);
                ans[0] += next[0];
                ans[1] += next[1];
            }
        }

        return ans;
    }

    private static List<List<Integer>> mapToAdjList(int n, int[][] edges) {
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            list.get(u).add(v);
            list.get(v).add(u);
        }

        return list;
    }
}
