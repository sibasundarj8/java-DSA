package Graph;/*
 *
 * https://www.geeksforgeeks.org/problems/project-manager--141631/1
 *
 * # Minimum Time to Finish Project
 *
 *   Q. An IT company is working on a large project consisting of n modules.
 *        ◦ The given array time required (in months) to complete the ith module is stored in the array duration[].
 *        ◦ The array dependencies[][], where dependencies[i] = [u, v], indicates that module v can be started only
 *          after module u is completed.
 *
 *      Multiple modules can be worked on simultaneously as long as all their dependencies have been completed.
 *
 *      Find the minimum time required to complete the entire project.
 *        ◦ If the project cannot be completed due to a cyclic dependency, return -1.
 *        ◦ A module is never dependent on itself.
 *
 *    Ex.
 *      Input : duration[] = [10, 20, 30, 10, 30, 20],
 *              dependencies[][] = [[5, 2], [5, 0], [4, 0], [4, 1], [2, 3], [3, 1]]
 *      Output: 80
 *      Explanation:                              5     4
 *                                               / \   / \
 *                                              2    0    1
 *                                                \     /
 *                                                  \ /
 *                                                   3
 *              The Graph of dependency forms this and the project will be completed when Module 1 is completed.
 *              The minimum taken time is 80 months, the maximum taken time is through the path 5 -> 2 -> 3 -> 1
 *              which takes 20 + 30 + 10 + 20
 *
 *  Constraints:
 *        ◦ 1 ≤ duration.size() ≤ 10⁵
 *        ◦ 0 ≤ duration[i] ≤ 10⁵
 *        ◦ 0 ≤ m ≤ 2*10⁵
 *        ◦ 0 ≤ dependencies[i][j] < 10⁵
 */

import java.util.*;

public class Graph_Minimum_Time_to_Finish_Project {

    /// main Method
    public static void main(String[] args) {
        int[] duration = {10, 20, 30, 10, 30, 20};
        int[][] dependencies = {
                {5, 2},
                {5, 0},
                {4, 0},
                {4, 1},
                {2, 3},
                {3, 1}
        };

        System.out.print("""
                        Graph:
                                5     4
                               / \\   / \\
                              2    0    1
                                \\     /
                                  \\ /
                                   3
                        """);
        System.out.println("Minimum time required to complete the entire project:");
        System.out.println(minTime(duration, dependencies));
    }

    /// Solution
    static int minTime(int[] duration, int[][] dependencies) {
        // potd.code.hub
        int n = duration.length;
        List<List<Integer>> adjList = toAdjucencyList(n, dependencies);

        int[] dp = new int[n];
        int max = 0;
        boolean[] flag = new boolean[1];
        boolean[] path = new boolean[n];
        Arrays.fill(dp, -1);

        for (int i = 0; i < n; i++) {
            if (dp[i] == -1) {
                Arrays.fill(path, false);
                max = Math.max(solve(i, adjList, duration, dp, flag, path), max);
            }
        }

        if (flag[0]) return -1;
        return max;
    }

    private static int solve(int src, List<List<Integer>> adjList, int[] cost, int[] dp, boolean[] flag, boolean[] path) {
        // base case
        if (flag[0]) return -1;

        if (dp[src] != -1) {
            return dp[src];
        }

        // recursive work
        path[src] = true;
        int max = 0;

        for (int next : adjList.get(src)) {
            if (path[next]) flag[0] = true;

            max = Math.max(max, solve(next, adjList, cost, dp, flag, path));
        }

        path[src] = false;

        // self work
        return dp[src] = max + cost[src];
    }

    private static List<List<Integer>> toAdjucencyList(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
        }

        return adjList;
    }
}
