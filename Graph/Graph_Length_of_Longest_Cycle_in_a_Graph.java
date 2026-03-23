package Graph;/*
 *
 * https://www.geeksforgeeks.org/problems/length-of-longest-cycle-in-a-graph/1
 *
 * # Length of Longest Cycle in a Graph
 *
 *   Q. Given a directed graph with V vertices numbered from 0 to V-1 and E edges, represented as a 2D array edges[][],
 *      where each entry edges[i] = [u, v] denotes an edge between vertices u and v. Each node has at most one outgoing
 *      edge. Your task is to find the length of the longest cycle present in the graph. If no cycle exists, return -1.
 *
 *      Note: A cycle is a path that starts and ends at the same vertex.
 *
 *    Ex.
 *      Input : V = 7,
 *              edges[][] = [[0, 5],
 *                           [1, 0],                (0) ------------> (5)
 *                           [2, 4],                 ^                  \
 *                           [3, 1],                 |                   v
 *                           [4, 6],                (1) <---- (3) <---- (6) <---- (4) <---- (2)
 *                           [5, 6],
 *                           [6, 3]]
 *      Output: 5
 *      Explanation: longest Cycle is 0->5->6->3->1->0
 *
 *  Constraints:
 *          1 ≤ V, E ≤ 10⁴
 *          0 ≤ edges[i][0], edges[i][1] < V
 */

import java.util.Arrays;

public class Graph_Length_of_Longest_Cycle_in_a_Graph {

    /// main Method
    public static void main(String[] args) {
        int V = 12;
        int[][] edges = {
                {0, 5},
                {1, 0},
                {2, 4},
                {3, 1},
                {4, 6},
                {5, 6},
                {6, 3}
        };

        System.out.println("Longest Cycle in this graph: " + longestCycle(V, edges));
    }

    /// Solution
    static int longestCycle(int V, int[][] edges) {
        // it will work like an adjacency list of functional graph.
        int[] next = new int[V];
        Arrays.fill(next, -1);

        for (int[] edge : edges) {
            next[edge[0]] = edge[1];
        }

        int maxLength = -1;
        int[] traverseId = new int[V];
        int[] visited = new int[V];
        Arrays.fill(visited, -1);

        for (int i = 0; i < V; i++) {
            if (visited[i] == -1) {
                int length = getCycleLength(i, next, visited, traverseId);
                maxLength = Math.max(length, maxLength);
            }
        }

        return maxLength;
    }

    private static int getCycleLength(int start, int[] next, int[] visited, int[] traverseId) {
        // traverse like a linked-list.
        int temp = start;
        visited[temp] = 0;
        traverseId[temp] = start;

        while (next[temp] != -1 && visited[next[temp]] == -1) {

            visited[next[temp]] = visited[temp] + 1;
            traverseId[next[temp]] = start;

            temp = next[temp];
        }

        // if temp exists in same path then return length otherwise no cycle found.
        return (next[temp] != -1 && traverseId[next[temp]] == start) ? visited[temp] - visited[next[temp]] + 1 : -1;
    }
}
