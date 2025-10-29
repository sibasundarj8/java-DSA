package Graph;/*
 *
 * https://www.geeksforgeeks.org/problems/diameter-of-a-graph/1
 *
 * # Graph Diameter
 *
 *   Q. You are given an undirected graph with V vertices numbered from 0 to V-1 and E edges, represented as a 2D array
 *      edges[][], where each element edges[i] = [u, v] represents an undirected edge between vertex u and vertex v.
 *      Find the diameter of the graph.
 *
 *      The diameter of a graph (sometimes called the width) is the number of edges on the longest path between two
 *      vertices in the graph.
 *   Ex.
 *      Input : V = 7, E = 6, edges[][] = [[0, 2], [0, 4], [0, 3], [3, 1], [3, 5], [1, 6]]
 *
 *              2-⎯⎯0⎯⎯-3⎯⎯-1
 *                   |     |    |
 *                   4     5    6
 *      Output: 4
 *      Explanation: The longest path in the graph is from vertices 2 to vertices 6 (2 -> 0 -> 3 -> 1 -> 6).
 *
 *  Constraints:
 *      2 ≤ V ≤  10⁵
 *      1 ≤ E ≤  V - 1
 *      0 ≤ edges[i][0], edges[i][1] < V
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Graph_Graph_Diameter {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of Vertices: ");
        int v = sc.nextInt();

        System.out.println("Enter number of edges: ");
        int n = sc.nextInt();

        int[][] edges = new int[n][2];

        System.out.println("Enter edges: ");
        for (int i = 0; i < n; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }

        System.out.println("Diameter: " + diameter(v, edges));
    }

    /// Solution
    static int diameter(int v, int[][] edges) {
        // potd.code.hub
        ArrayList<ArrayList<Integer>> adjList = adjacencyList(v, edges);
        int[] nodeDist = {0, 0};

        dfs(0, 0, adjList, new boolean[v], nodeDist);
        dfs(nodeDist[0], 0, adjList, new boolean[v], nodeDist);

        return nodeDist[1];
    }

    // dfs
    private static void dfs(int src, int dist, ArrayList<ArrayList<Integer>> adjList, boolean[] visited, int[] nodeDist) {
        if (dist > nodeDist[1]) {
            nodeDist[0] = src;
            nodeDist[1] = dist;
        }
        visited[src] = true;

        for (int neighbour : adjList.get(src))
            if (!visited[neighbour])
                dfs(neighbour, dist + 1, adjList, visited, nodeDist);
    }

    // converting edge array to adjacency list.
    private static ArrayList<ArrayList<Integer>> adjacencyList(int v, int[][] edges) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < v; i++) lists.add(new ArrayList<>());

        for (int[] temp : edges) {
            lists.get(temp[0]).add(temp[1]);
            lists.get(temp[1]).add(temp[0]);
        }

        return lists;
    }
}
