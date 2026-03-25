package Graph;/*
 *
 * https://www.geeksforgeeks.org/problems/minimum-height-roots/1
 *
 * # Minimum height roots
 *
 *   Q. You are given an undirected graph, which has tree characteristics with V vertices numbered from 0 to V-1 and E edges,
 *      represented as a 2D array edges[][], where each element edges[i] = [u, v] represents an edge from vertex u to v.
 *
 *      You can choose any vertex as the root of the tree. Your task is to find all the vertices that, when chosen as the root,
 *      result in the minimum possible height of the tree.
 *
 *      Note: The height of a rooted tree is defined as the maximum number of edges on the path from the root to any leaf node.
 *
 *    Ex.
 *      Input : V = 5                                                  0
 *              E = 4                                                  |
 *              edges = [[0,2], [1,2], [2,3], [3,4]]                   2
 *                                                                    / \
 *                                                                   1   3
 *                                                                        |
 *                                                                        4
 *      Output: [2, 3]
 *      Explanation: If we choose vertices 2 or 3 as the root, the resulting tree has the minimum possible height, which is 2.
 *
 *                   Root=0 (h=3)        Root=1 (h=3)        Root=2 (h=2)        Root=3 (h=2)        Root=4 (h=3)
 *                       0                   1                   2                   3                   4
 *                       |                   |                 / | \               /   \                 |
 *                       2                   2                0  1  3             2     4                3
 *                      / \                 / \                     |            / \                     |
 *                     1   3               0   3                    4           0   1                    2
 *                         |                   |                                                        / \
 *                         4                   4                                                       0   1
 *  Constraints:
 *          1 ≤ V ≤ 10⁵
 *          0 ≤ E ≤ V-1
 *          0 ≤ edges[i][0], edges[i][1] < V
 */

import java.util.*;

public class Graph_Minimum_height_roots {

    /// main Method
    public static void main(String[] args) {
        int v = 5;
        int[][] edges = {
                {0, 2},
                {1, 2},
                {2, 3},
                {3, 4}
        };

        System.out.println("Minimum possible height of the tree: " + minHeightRoot(v, edges));
    }

    /// Solution
/*
✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘-Brute-Force-(Floyd-Warshall)-✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘
TC : O(V³)
SC : O(V²)
*/
    static ArrayList<Integer> bruteForce(int V, int[][] edges) {
        // potd.code.hub
        int[][] distance = floydWarshall(V, edges);
        int min = Integer.MAX_VALUE;
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            int maxInRow = 0;

            for (int j = 0; j < V; j++)
                maxInRow = Math.max(maxInRow, distance[i][j]);

            if (maxInRow < min) {
                min = maxInRow;
                list.clear();
            }
            if (maxInRow == min) list.add(i);
        }

        return list;
    }

    private static int[][] floydWarshall(int V, int[][] edges) {
        int[][] adjMatrix = new int[V][V];

        // constructing adjacency matrix
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjMatrix[u][v] = adjMatrix[v][u] = 1;
        }

        for (int i = 0; i < V; i++) {
            for (int j = i + 1; j < V; j++) {
                if (adjMatrix[i][j] == 0) {
                    adjMatrix[i][j] = adjMatrix[j][i] = Integer.MAX_VALUE;
                }
            }
        }

        // applying floydWarshall
        for (int via = 0; via < V; via++) {
            for (int u = 0; u < V; u++) {
                for (int v = 0; v < V; v++) {

                    int u_via = adjMatrix[u][via];
                    int v_via = adjMatrix[v][via];

                    if (u_via != Integer.MAX_VALUE && v_via != Integer.MAX_VALUE && u != v && u != via && v != via)
                        adjMatrix[u][v] = Math.min(adjMatrix[u][v], u_via + v_via);

                }
            }
        }

        return adjMatrix;
    }

/*
✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔-Leaf-Termination-(Topological-Sort)-✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔
TC : O(V)
SC : O(V)
*/
    static ArrayList<Integer> minHeightRoot(int V, int[][] edges) {
        Queue<Integer> q = new ArrayDeque<>();
        List<HashSet<Integer>> adjList = mapToAdjList(V, edges);

        // adding all the leafs
        for (int i = 0; i < V; i++) {
            if (adjList.get(i).size() == 1) q.offer(i);
        }

        int totalNodes = V;

        // terminating leaf nodes layer-wise like an onion
        while (totalNodes > 2) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int curr = q.poll();
                int next = adjList.get(curr).iterator().next();
                adjList.get(next).remove(curr);

                if (adjList.get(next).size() == 1) q.offer(next);
            }

            totalNodes -= size;
        }

        return new ArrayList<>(q);
    }

    // constructing adjacency list.
    private static List<HashSet<Integer>> mapToAdjList(int V, int[][] edges) {
        List<HashSet<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adjList.add(new HashSet<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        return adjList;
    }
}
