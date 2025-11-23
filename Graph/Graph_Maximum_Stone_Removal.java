package Graph;/*
 *
 * https://www.geeksforgeeks.org/problems/maximum-stone-removal-1662179442/1
 *
 * # Maximum Stone Removal
 *
 *   Q. Given an 2D array of non-negative integers stones[][] where stones[i] = [xi , yi] represents the location of the
 *      ith stone on a 2D plane, the task is to return the maximum possible number of stones that you can remove.
 *
 *      A stone can be removed if it shares either the same row or the same column as another stone that has not been
 *      removed.
 *
 *      Note: Each coordinate point may have at most one stone.
 *
 *   Ex.
 *      Input : stones[][] = [[0, 0], [0, 1], [1, 0], [1, 2], [2, 1], [2, 2]]
 *      Output: 5
 *      Explanation:
 *              One way to remove 5 stones is as follows:
 *              1. Remove stone [2, 2] because it shares the same row as [2, 1].
 *              2. Remove stone [2, 1] because it shares the same column as [0, 1].
 *              3. Remove stone [1, 2] because it shares the same row as [1, 0].
 *              4. Remove stone [1, 0] because it shares the same column as [0, 0].
 *              5. Remove stone [0, 1] because it shares the same row as [0, 0].
 *              Stone [0, 0] cannot be removed since it does not share any row/column with another stone still on the plane.
 *
 *  Constraints:
 *        1 ≤ stones.size() ≤ 1000
 *        0 ≤ xi, yi ≤ 104
 *        No two stones are at same position.
 */

import java.util.ArrayList;
import java.util.HashMap;

public class Graph_Maximum_Stone_Removal {

    /// main Method
    public static void main(String[] args) {
        int[][] stones = {
                {0, 0},
                {0, 1},
                {1, 0},
                {1, 2},
                {2, 1},
                {2, 2}
        };

        System.out.println("Maximum possible number of stones that you can remove : ");
        System.out.println(maxRemove(stones));
    }

    /// Solution
    public static int maxRemove(int[][] stones) {
        // potd.code.hub
        int V = stones.length;
        int ans = 0;

        ArrayList<int[]> edgeList = constructEdgeList(stones);
        ArrayList<ArrayList<Integer>> adjacencyList = constructAdjacencyList(V, edgeList);
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, adjacencyList, visited);
                ans++;
            }
        }

        return V - ans;
    }

    private static void dfs(int src, ArrayList<ArrayList<Integer>> adjList, boolean[] visited) {
        visited[src] = true;

        for (int next : adjList.get(src)) {
            if (!visited[next]) {
                dfs(next, adjList, visited);
            }
        }
    }

    private static ArrayList<int[]> constructEdgeList(int[][] stones) {
        int n = stones.length;
        ArrayList<int[]> list = new ArrayList<>();
        HashMap<Integer, Integer> rowNode = new HashMap<>();
        HashMap<Integer, Integer> colNode = new HashMap<>();

        for(int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    list.add(new int[]{i, j});
                }
            }
        }

        return list;
    }

    private static ArrayList<ArrayList<Integer>> constructAdjacencyList(int V, ArrayList<int[]> edges) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            lists.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            lists.get(u).add(v);
            lists.get(v).add(u);
        }

        return lists;
    }
}
