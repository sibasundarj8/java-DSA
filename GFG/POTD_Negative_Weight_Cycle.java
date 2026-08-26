package GFG;/*
 *
 * https://www.geeksforgeeks.org/problems/negative-weight-cycle3504/1
 *
 * # Negative Weight Cycle
 *
 *   Q. Given a weighted directed graph containing V vertices numbered from 0 to V - 1 and a list of E directed edges[][],
 *      determine whether the graph contains a negative weight cycle or not.
 *
 *      Each edge is represented as: [u, v, w], where there is a directed edge from vertex u to vertex v having the given
 *      weight w.
 *
 *      Note: A negative-weight cycle is a cycle in a graph whose edges sum to a negative value.
 *
 *    Ex.
 *      Input : V = 4, E = 4,
 *              edges[][] = [[0, 3, 6],
 *                           [1, 0, 4],
 *                           [1, 2, 6],
 *                           [3, 1, 2]]
 *      Output: false
 *      Explanation: Cycle 1 -> 0 -> 3 -> 1 has total weight 6 + 4 + 2 = 12, which is positive, so no negative weight
 *                   cycle exists.
 *
 *  Constraints:
 *        ◦ 1 ≤ V ≤ 10³
 *        ◦ 0 ≤ E ≤ 10⁵
 *        ◦ 0 ≤ u, v < V
 *        ◦ -10⁶ ≤ w ≤ 10⁶
 */

public class POTD_Negative_Weight_Cycle {

    /// main Method
    public static void main(String[] args) {
        int V = 4;
        int[][] edges = {
                {0, 3, 6},
                {1, 0, 4},
                {1, 2, 6},
                {3, 1, 2}
        };

        System.out.println("Ans: " + isNegativeWeightCycle(V, edges));
    }

    /// Solution
    static boolean isNegativeWeightCycle(int V, int[][] edges) {
        // potd.code.hub
        boolean flag;
        int[] dist = new int[V];

        for (int i = 1; i <= V; i++) {
            flag = true;

            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int newDist = dist[u] + edge[2];

                if (newDist < dist[v]) {
                    flag = false;
                    dist[v] = newDist;

                    if (i == V) return true;
                }
            }

            if (flag) return false;
        }

        return false;
    }
}
