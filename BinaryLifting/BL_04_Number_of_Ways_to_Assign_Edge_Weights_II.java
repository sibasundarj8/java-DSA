package BinaryLifting;/*
 *
 * https://leetcode.com/problems/number-of-ways-to-assign-edge-weights-ii/
 *
 * # LC. 3559. Number of Ways to Assign Edge Weights II
 *
 *   Q. There is an undirected tree with n nodes labeled from 1 to n, rooted at node 1. The tree is represented by a 2D
 *      integer array edges of length n - 1, where edges[i] = [ui, vi] indicates that there is an edge between nodes u_i
 *      and v_i.
 *
 *      Initially, all edges have a weight of 0. You must assign each edge a weight of either 1 or 2.
 *
 *      The cost of a path between any two nodes u and v is the total weight of all edges in the path connecting them.
 *
 *      You are given a 2D integer array queries. For each queries[i] = [u_i, v_i], determine the number of ways to
 *      assign weights to edges in the path such that the cost of the path between u_i and v_i is odd.
 *
 *      Return an array answer, where answer[i] is the number of valid assignments for queries[i].
 *
 *      Since the answer may be large, apply modulo 10⁹ + 7 to each answer[i].
 *
 *      Note: For each query, disregard all edges not in the path between node u_i and v_i.
 *
 *    Ex.
 *      Input : edges = [[1, 2], [1, 3], [3, 4], [3, 5]],
 *              queries = [[1, 4], [3, 4], [2, 5]]
 *      Output: [2, 1, 4]
 *      Explanation:
 *              ◦ Query [1,4]: The path from Node 1 to Node 4 consists of two edges (1 → 3 and 3 → 4). Assigning weights
 *                (1,2) or (2,1) results in an odd cost. Thus, the number of valid assignments is 2.
 *
 *              ◦ Query [3,4]: The path from Node 3 to Node 4 consists of one edge (3 → 4). Assigning weight 1 makes the
 *                cost odd, while 2 makes it even. Thus, the number of valid assignments is 1.
 *
 *              ◦ Query [2,5]: The path from Node 2 to Node 5 consists of three edges (2 → 1, 1 → 3, and 3 → 5).
 *                Assigning (1,2,2), (2,1,2), (2,2,1), or (1,1,1) makes the cost odd. Thus, the number of valid
 *                assignments is 4.
 *
 *  Constraints:
 *        ◦ 2 <= n <= 10⁵
 *        ◦ edges.length == n - 1
 *        ◦ edges[i] == [u_i, v_i]
 *        ◦ 1 <= queries.length <= 10⁵
 *        ◦ queries[i] == [u_i, v_i]
 *        ◦ 1 <= u_i, v_i <= n
 *        ◦ edges represents a valid tree.
 */

import java.util.*;

public class BL_04_Number_of_Ways_to_Assign_Edge_Weights_II {

    /// main Method
    public static void main(String[] args) {
        int[][] edges = {{3,4},{1,6},{1,3},{1,2},{2,5}};
        int[][] queries = {{5,2},{1,1},{4,5}};

        System.out.print("""
                The number of ways to assign edge weights on the path from u to v for each query
                such that its total cost is odd :
                """);
        int[] res = assignEdgeWeights(edges, queries);
        System.out.println(Arrays.toString(res));
    }

    /// Solution
    private static final int MOD = (int) 1e9 + 7;

    static int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        // potd.code.hub
        int n = queries.length;
        int[] res = new int[n];
        TreeMachine treeMachine = new TreeMachine();

        treeMachine.process(edges);

        for (int i = 0; i < n; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            int distance = treeMachine.getDistance(u, v);

            res[i] = (distance == 0) ? 0 : (int) modularPowOf2(distance - 1);
        }

        return res;
    }

    // calculating modular power : 2ⁿ
    private static long modularPowOf2(int n) {
        // base case
        if (n < 63) return (1L << n) % MOD;

        // recursive case
        long x = modularPowOf2(n / 2) % MOD;

        // self work
        x = x * x % MOD;
        return ((n & 1) == 0) ? x : x * 2 % MOD;
    }

    // A machine which will process a tree first and then answer distance between any two nodes.
    private static class TreeMachine {
        private int LOG;
        private List<List<Integer>> adjList;
        private int[][] matrix;
        private int[] depth;

        // updating all the 2's power ancestors.
        void process(int[][] edges) {
            int numberOfNodes = edges.length + 1;
            depth = new int[numberOfNodes + 1];

            depth[0] = matrix[1][0] = -1;
            Arrays.fill(matrix[0], -1);

            LOG = 1;
            while ((1 << LOG) <= numberOfNodes) {
                LOG++;
            }

            matrix = new int[numberOfNodes + 1][LOG];
            adjList = mapToAdjacencyList(edges);

            updateDepthFromRoot(numberOfNodes);

            for (int k = 1; k < LOG; k++){
                for (int i = 1; i <= numberOfNodes; i++) {
                    matrix[i][k] = (matrix[i][k - 1] == -1) ? -1 : matrix[matrix[i][k - 1]][k - 1];
                }
            }
        }

        // getting the distance between two nodes
        int getDistance(int u, int v) {
            // potd.code.hub
            int lca = getLCA(u, v);
            return depth[u] + depth[v] - 2 * depth[lca];
        }

        // getting LCA (lowest common ancestor) of two nodes
        int getLCA(int u, int v) {
            // potd.code.hub
            if (matrix == null) {
                throw new IllegalArgumentException("process edge-array of the tree before requesting anything !!");
            }

            if (depth[u] > depth[v]) u = getKthAncestor(u, depth[u] - depth[v]);
            if (depth[v] > depth[u]) v = getKthAncestor(v, depth[v] - depth[u]);

            if (u == v) return u;

            while (matrix[u][0] != matrix[v][0]) {
                for (int i = 0; i < LOG; i++) {
                    if (matrix[u][i] == matrix[v][i]) break;
                    u = matrix[u][i];
                    v = matrix[v][i];
                }
            }

            return matrix[u][0];
        }

        // getting k'th ancestor of a node
        int getKthAncestor(int node, int k) {
            // potd.code.hub
            if (matrix == null) {
                throw new IllegalArgumentException("process edge-array of the tree before requesting anything !!");
            }

            int res = node;

            for (int i = LOG - 1; i >= 0; i--) {
                if ((k & (1 << i)) != 0) {
                    res = matrix[res][i];
                    if (res == -1) break;
                }
            }

            return res;
        }

        // getting the depth of every node from root node.
        private void updateDepthFromRoot(int numberOfNodes) {
            // potd.code.hub
            int dist = 0;
            boolean[] visited = new boolean[numberOfNodes + 1];
            Queue<Integer> queue = new ArrayDeque<>();

            queue.offer(1);
            visited[1] = true;

            while (!queue.isEmpty()) {
                int size = queue.size();

                for (int i = 0; i < size; i++) {
                    int curr = queue.poll();
                    depth[curr] = dist;

                    for (int next : adjList.get(curr)) {
                        if (!visited[next]) {
                            visited[next] = true;
                            matrix[next][0] = curr;
                            queue.offer(next);
                        }
                    }
                }

                dist++;
            }
        }

        // converting edge array to adjacency-list.
        private List<List<Integer>> mapToAdjacencyList(int[][] edges) {
            // potd.code.hub
            int n = edges.length + 1;
            List<List<Integer>> res = new ArrayList<>();

            for (int i = 0; i <= n; i++) {
                res.add(new ArrayList<>());
            }

            for (int[] edge : edges) {
                res.get(edge[0]).add(edge[1]);
                res.get(edge[1]).add(edge[0]);
            }

            return res;
        }
    }
}
