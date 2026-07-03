package BinarySearch;/*
 *
 * https://leetcode.com/problems/network-recovery-pathways/
 *
 * # LC. 3620. Network Recovery Pathways
 *
 *   Q. You are given a directed acyclic graph of n nodes numbered from 0 to n − 1. This is represented by a 2D array
 *      edges of length m, where edges[i] = [u-i, v-i, cost-i] indicates a one‑way communication from node u-i to node
 *      v-i with a recovery cost of cost-i.
 *
 *      Some nodes may be offline. You are given a boolean array online where online[i] = true means node 'i' is online.
 *      Nodes 0 and n − 1 are always online.
 *
 *      A path from 0 to n − 1 is valid if:
 *        ◦ All intermediate nodes on the path are online.
 *        ◦ The total recovery cost of all edges on the path does not exceed k.
 *
 *      For each valid path, define its score as the minimum edge‑cost along that path.
 *
 *      Return the maximum path score (i.e., the largest minimum-edge cost) among all valid paths. If no valid path exists,
 *      return -1.
 *
 *    Ex.
 *      Input : edges = [[0, 1, 5],                 [3] <--------- [2]
 *                       [1, 3, 10],                 ^      4       ^
 *                       [0, 2, 3],                  | 10         3 |
 *                       [2, 3, 4]],                 |       5      |
 *              online = [true,true,true,true],     [1] <--------- [0]
 *              k = 10
 *      Output: 3
 *      Explanation:
 *            ◦ The graph has two possible routes from node 0 to node 3:
 *
 *               1. Path 0 → 1 → 3
 *                    ⎯ Total cost = 5 + 10 = 15, which exceeds k (15 > 10), so this path is invalid.
 *
 *               2. Path 0 → 2 → 3
 *                    ⎯ Total cost = 3 + 4 = 7 <= k, so this path is valid.
 *                    ⎯ The minimum edge‐cost along this path is min(3, 4) = 3.
 *
 *            ◦ There are no other valid paths. Hence, the maximum among all valid path‐scores is 3.
 *
 *  Constraints:
 *      ◦ n == online.length
 *      ◦ 2 <= n <= 5 * 10⁴
 *      ◦ 0 <= m == edges.length <= min(10⁵, n * (n - 1) / 2)
 *      ◦ edges[i] = [u-i, v-i, cost-i]
 *      ◦ 0 <= u-i, v-i < n
 *      ◦ u-i != v-i
 *      ◦ 0 <= cost-i <= 10⁹
 *      ◦ 0 <= k <= 5 * 10¹³
 *      ◦ online[i] is either true or false, and both online[0] and online[n − 1] are true.
 *      ◦ The given graph is a directed acyclic graph.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Searching_Network_Recovery_Pathways {

    /// main Method
    public static void main(String[] args) {
        int[][] edges = {
                {0, 1, 5},
                {1, 3, 10},
                {0, 2, 3},
                {2, 3, 4}
        };
        boolean[] online = {true, true, true, true};
        long k = 10;

        System.out.println("Largest of minimum weight of valid paths: ");
        System.out.println(findMaxPathScore(edges, online, k));
    }

    /// Solution
    static int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;
        List<List<int[]>> adjList = mapToAdjList(edges, n);
        long[] dp = new long[n];

        int i = 0;
        int j = 0;
        for (int[] edge : edges) {
            j = Math.max(j, edge[2]);
        }

        while (i <= j) {
            int mid = i + (j - i) / 2;
            Arrays.fill(dp, -1);
            boolean isPossible = getMinCost(0, mid, n, adjList, online, dp) <= k;

            if (isPossible)
                i = mid + 1;
            else j = mid - 1;
        }

        return j;
    }

    private static long getMinCost(int src, int minReq, int n, List<List<int[]>> adjList, boolean[] online, long[] dp) {
        // base case
        if (src == n - 1) return 0;
        if (dp[src] != -1) return dp[src];

        // recursive case
        long minCost = Long.MAX_VALUE / 2;

        for (int[] neighbor : adjList.get(src)) {
            int v = neighbor[0];
            int w = neighbor[1];

            if (online[v] && w >= minReq) {
                minCost = Math.min(minCost, getMinCost(v, minReq, n, adjList, online, dp) + w);
            }
        }

        return dp[src] = minCost;
    }

    private static List<List<int[]>> mapToAdjList(int[][] edges, int numberOfNodes) {
        List<List<int[]>> adjList = new ArrayList<>();

        for (int i = 0; i < numberOfNodes; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }

        return adjList;
    }
}
