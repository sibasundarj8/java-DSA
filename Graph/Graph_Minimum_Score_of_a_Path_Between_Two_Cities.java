package Graph;/*
 * 
 * https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities/
 *
 * LC. 2492. Minimum Score of a Path Between Two Cities
 *
 *   Q. You are given a positive integer n representing n cities numbered from 1 to n. You are also given a 2D array roads
 *      where roads[i] = [a-i, b-i, distance-i] indicates that there is a bidirectional road between cities a-i and b-i
 *      with a distance equal to distance-i. The cities graph is not necessarily connected.
 *
 *      The score of a path between two cities is defined as the minimum distance of a road in this path.
 *
 *      Return the minimum possible score of a path between cities 1 and n.
 *
 *      Note:
 *        ◦ A path is a sequence of roads between two cities.
 *        ◦ It is allowed for a path to contain the same road multiple times, and you can visit cities 1 and n multiple
 *          times along the path.
 *        ◦ The test cases are generated such that there is at least one path between 1 and n.
 *
 *    Ex.
 *      Input : n = 4,
 *              roads = [[1, 2, 2],
 *                       [1, 3, 4],
 *                       [3, 4, 7]]
 *      Output: 2
 *      Explanation: The path from city 1 to 4 with the minimum score is: 1 -> 2 -> 1 -> 3 -> 4. The score of this path
 *                   is min(2,2,4,7) = 2.
 *
 *  Constraints:
 *        ◦ 2 <= n <= 10⁵
 *        ◦ 1 <= roads.length <= 10⁵
 *        ◦ roads[i].length == 3
 *        ◦ 1 <= a-i, b-i <= n
 *        ◦ a-i != b-i
 *        ◦ 1 <= distance-i <= 10⁴
 *        ◦ There are no repeated edges.
 *        ◦ There is at least one path between 1 and n.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph_Minimum_Score_of_a_Path_Between_Two_Cities {

    /// main Method
    public static void main(String[] args) {

        int n = 4;
        int[][] roads = {
                {1, 2, 2},
                {1, 3, 4},
                {3, 4, 7}
        };

        System.out.println("Minimum possible score of a path between cities 1 and n: ");
        System.out.println(minScore(n,roads));
    }

    /// Solution
    static int minScore(int n, int[][] roads) {
        List<List<int[]>> adjList = mapToAdjList(roads, n);
        int[] dp = new int[n + 1];
        boolean[] visited = new boolean[n + 1];

        Arrays.fill(dp, -1);
        visited[1] = true;


        return getMinEdgeWeight(1, adjList, visited, dp);
    }

    private static int getMinEdgeWeight(int u, List<List<int[]>> adjList, boolean[] visited, int[] dp) {
        // base case
        if (dp[u] != -1) return dp[u];

        // recursive work
        int minEdgeWeight = Integer.MAX_VALUE;

        for (int[] neighbour : adjList.get(u)) {
            int v = neighbour[0];
            int w = neighbour[1];
            minEdgeWeight = Math.min(minEdgeWeight, w);

            if (!visited[v]) {
                visited[v] = true;
                minEdgeWeight = Math.min(minEdgeWeight, getMinEdgeWeight(v, adjList, visited, dp));
            }
        }

        // self work
        return dp[u] = minEdgeWeight;
    }

    private static List<List<int[]>> mapToAdjList(int[][] edges, int numberOfNodes) {
        List<List<int[]>> adjList = new ArrayList<>();

        for (int i = 0; i <= numberOfNodes; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adjList.get(u).add(new int[]{v, w});
            adjList.get(v).add(new int[]{u, w});
        }

        return adjList;
    }
}
