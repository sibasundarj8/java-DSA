package Graph;/*
 *
 *  https://www.geeksforgeeks.org/problems/possible-paths--141628/1
 *
 * # Count Tree Paths With Limited Max Edge Weight
 *
 *   Q. Given a weighted tree with n nodes, numbered from 1 to n and n - 1 edges, where each edge is represented as
 *      [u, v, w] indicating an edge between nodes u and v with weight w.
 *
 *      You are also given an array queries[], where each queries[i] represents a maximum allowed edge weight.
 *
 *      For each query x, find the number of distinct paths in the tree such that the maximum edge weight along the
 *      path is less than or equal to x.
 *
 *      Return an array containing the number of valid paths for each query.
 *
 *    Note:
 *      ◦ A path from node 'u' to node 'v' and the path from node 'v' to node 'u' are considered the same path.
 *      ◦ A path must contain at least one edge. A path from a node to itself is not considered.
 *
 *    Ex.
 *      Input : n = 7,
 *              edges[][] = [[1, 2, 3],
 *                           [2, 3, 1],
 *                           [2, 4, 9],
 *                           [3, 6, 7],
 *                           [3, 5, 8],
 *                           [5, 7, 4]],
 *              queries[] = [1, 3, 5]
 *      Output: [1, 3, 4]
 *      Explanation: For x = 1, only the edge [2, 3, 1] satisfies the condition.
 *                   Therefore, the only valid path is 2 -> 3, giving an answer of 1.
 *                   For x = 3, the edges [2, 3, 1] and [1, 2, 3] can be used.
 *                   They form three valid paths: 1 -> 2, 2 -> 3, and 1 -> 3.
 *                   For x = 5, the edges with weights 1, 3, and 4 can be used.
 *                   They form four valid paths: 1 -> 2, 2 -> 3, 1 -> 3, and 5 -> 7.
 *
 *  Constraints:
 *         ◦ 2 ≤ n ≤ 10⁴
 *         ◦ 1 ≤ queries.size() ≤ 10⁴
 *         ◦ 0 ≤ queries[i] ≤ 10⁵
 *         ◦ edges.size() = n-1
 *         ◦ edges[i].size() = 3
 *         ◦ 1 ≤ edges[i][0], edges[i][1] ≤ n
 *         ◦ edges[i][0] != edges[i][1]
 *         ◦ 0 ≤ edges[i][2] ≤ 10⁵
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Graph_Count_Tree_Paths_With_Limited_Max_Edge_Weight {

    /// main Method
    public static void main(String[] args) {
        int n = 7;
        int[][] edges = {
                {2, 3, 1},
                {1, 2, 3},
                {5, 7, 4},
                {3, 6, 7},
                {3, 5, 8},
                {2, 4, 9}
        };

        int[] queries = {1, 3, 5};

        System.out.print("res of example: ");
        System.out.println(maximumWeight(n, edges, queries));
    }

    /// Solution
    static ArrayList<Integer> maximumWeight(int n, int[][] edges, int[] queries) {
        // potd.code.hub
        Arrays.sort(edges, Comparator.comparingInt(a -> a[2]));

        int m = edges.length;
        int[] edgeCount = new int[m];
        int[] parent = new int[n + 1];
        int[] size = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        int prv = 0;
        for (int i = 0; i < m; i++) {
            edgeCount[i] = join(edges[i][0], edges[i][1], parent, size);
            edgeCount[i] += prv;
            prv = edgeCount[i];
        }

        ArrayList<Integer> res = new ArrayList<>();

        for (int maxEdge : queries) {
            int idx = upperBound(edges, maxEdge, m);

            if (idx == -1) res.add(0);
            else res.add(edgeCount[idx]);
        }

        return res;
    }

    private static int join(int a, int b, int[] parent, int[] size) {
        int parent_a = getParent(a, parent);
        int parent_b = getParent(b, parent);

        if (parent_a == parent_b) return 0;

        int newPaths = size[parent_a] * size[parent_b];

        if (size[parent_b] <= size[parent_a]) {
            parent[parent_b] = parent_a;
            size[parent_a] += size[parent_b];
        } else {
            parent[parent_a] = parent_b;
            size[parent_b] += size[parent_a];
        }

        return newPaths;
    }

    private static int getParent(int src, int[] parent) {
        if (parent[src] == src) return src;
        else return parent[src] = getParent(parent[src], parent);
    }

    private static int upperBound(int[][] edges, int target, int n) {
        int i = 0;
        int j = n - 1;

        while (i <= j) {
            int mid = i + (j - i) / 2;

            if (edges[mid][2] <= target) i = mid + 1;
            else j = mid - 1;
        }

        return j;
    }
}
