package Graph;/*
 *
 * https://www.geeksforgeeks.org/problems/max-dag-edges/1
 *
 * # Max DAG Edges
 *
 *   Q. Given a directed acyclic graph (DAG) with V vertices numbered from 0 to V-1 and E edges, represented as a 2D
 *      array edges[][], where each entry edges[i] = [u, v] denotes a directed edge from vertex u to vertex v, find
 *      the maximum number of additional edges that can be added to the graph without forming any cycles.
 *
 *      Note: The resulting graph must remain a DAG, meaning that adding any further edge would not create a cycle.
 *    Ex.
 *      Input : V = 4, E = 4, edges[][] = [[0, 1], [0, 2], [1, 2], [2, 3]]
 *      Output: 2
 *      Explanation: Two additional edges (0 -> 3, 1 -> 3) can be added without forming cycles.
 * 
 *  Constraints:
 *      1 ≤ V ≤ 10³
 *      0 ≤ E ≤ (V*(V-1))/2
 *      0 ≤ edges[i][0], edges[i][1] < V
 */

public class Graph_Max_DAG_Edges {

    /// main Method
    public static void main(String[] args) {
        int v = 4;
        int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {2, 3}};

        System.out.println("Number of edge we can add: ");
        System.out.println(maxEdgesToAdd(v, edges));
    }

    /// Solution
    static int maxEdgesToAdd(int v, int[][] edges) {
        // potd.code.hub
        int possible = v * (v - 1) / 2;
        return possible - edges.length;
    }
}
