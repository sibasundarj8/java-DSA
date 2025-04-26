package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/implementing-floyd-warshall2042/1
 *
 * # Floyd Warshall
 *
 *   Q. You are given a weighted directed graph, represented by an adjacency matrix, dist[][]
 *      of size n x n, where dist[i][j] represents the weight of the edge from node i to node
 *      j. If there is no direct edge, dist[i][j] is set to a large value (i.e., 108) to represent infinity.
 *
 *      The graph may contain negative edge weights, but it does not contain any negative weight
 *      cycles.
 *
 *      Your task is to find the shortest distance between every pair of nodes i and j in the
 *      graph.
 *
 *      Note: Modify the distances for every pair in place.
 *   Ex.
 *      Input : dist[][] = [[0, 4, ∞, 5, ∞],
 *                          [∞, 0, 1, ∞, 6],
 *                          [2, ∞, 0, 3, ∞],
 *                          [∞, ∞, 1, 0, 2],
 *                          [1, ∞, ∞, 4, 0]]
 *
 *      Output: [[0, 4, 5, 5, 7], 
 *               [3, 0, 1, 4, 6], 
 *               [2, 6, 0, 3, 5], 
 *               [3, 7, 1, 0, 2], 
 *               [1, 5, 5, 4, 0]]
 *
 *      Explanation: Each cell dist[i][j] in the output shows the shortest distance from node i 
 *                   to node j, computed by considering all possible intermediate nodes.
 */
public class GFG_153_Floyd_Warshall {

    /// main Method
    public static void main(String[] args) {
        int x = (int)1e8;
        int[][] dist = {{0, 4, x, 5, x},
                        {x, 0, 1, x, 6},
                        {2, x, 0, 3, x},
                        {x, x, 1, 0, 2},
                        {1, x, x, 4, 0}};

        floydWarshall(dist);

        for (int[] i : dist){
            for (int j : i){
                System.out.print(j + "  ");
            }
            System.out.println();
        }
    }

    /// Solution
    static void floydWarshall(int[][] dist) {
        // potd.code.hub
        int n = dist.length;

        for (int via = 0;via < n;via++){
            for (int u = 0;u < n;u++){
                for (int v = 0;v < n;v++){
                    if (u == v || u == via || v == via || dist[u][via] == 1e8 || dist[via][v] == 1e8){
                        continue;
                    }
                    dist[u][v] = Math.min(dist[u][v], dist[u][via] + dist[via][v]);
                }
            }
        }
    }
}
