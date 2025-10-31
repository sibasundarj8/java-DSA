package Graph;/*
 *
 * https://www.geeksforgeeks.org/problems/shortest-cycle/1
 *
 * # Shortest Cycle
 *
 *   Q. You are given an undirected connected graph with V vertices numbered from 0 to V-1 and E edges, represented as a
 *      2D array edges[][], where each element edges[i] = [u, v] represents an undirected edge between vertex u and v.
 *      Find the length of the shortest cycle in the graph. If the graph does not contain any cycle, return -1.
 *
 *      Note: A cycle is a path that starts and ends at the same vertex without repeating any edge or vertex (except the
 *            start/end vertex). The shortest cycle is the one with the minimum number of edges.
 *   Ex.
 *      Input: V = 7, E = 9, edges[][] = [[0, 5], [0, 6], [1, 2], [1, 4], [1, 5], [1, 6], [2, 6], [2, 3], [3, 4]]
 *
 *                                                  (3)⎯⎯-(2)⎯⎯(6)⎯⎯⎯(0)
 *                                                  |       |    /       /
 *                                                  |       |  /       /
 *                                                  |       |/       /
 *                                                 (4)⎯⎯⎯(1)⎯⎯⎯(5)
 *      Output: 3
 *      Explanation: Possible cycles include:
 *                   1 → 2 → 6 → 1 (length = 3)
 *                   1 → 2 → 3 → 4 → 1 (length = 4)
 *                   0 → 5 → 1 → 6 → 0 (length = 4)
 *                   The smallest one is 1 → 2 → 6 → 1, with length 3.
 *
 * Constraints:
 *      1 ≤ V ≤ 10³
 *      0 ≤ E ≤ 10³
 *      0 ≤ edges[i][0], edges[i][1] < V
 */

import java.util.*;

public class Graph_Shortest_Cycle {

    /// main Method
    public static void main(String[] args) {
        int v = 7;
        int[][] edges = {
                {0, 5},
                {0, 6},
                {1, 2},
                {1, 4},
                {1, 5},
                {1, 6},
                {2, 6},
                {2, 3},
                {3, 4}
        };

        System.out.println("Smallest cycle length: " + shortCycle(v, edges));
    }

    /// Solution
/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯Brute-Force⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(E × (V + E))
SC : O(V² + E)
*/
    static int bruteForce(int v, int[][] edges) {
        // potd.code.hub
        List<Set<Integer>> adjList = adjList(v, edges);
        int ans = Integer.MAX_VALUE;
        boolean[][] visited = new boolean[v][v]; // ensuring check an edge only once not twice.

        // checking for every node.
        for (int i = 0; i < v; i++) {

            // to avoid concurrent modification exception
            List<Integer> list = new ArrayList<>(adjList.get(i));

            for (int j : list) // checking for every neighbours
                if (!visited[i][j]) ans = Math.min(ans, shortestPathLengthBfs(i, j, v, adjList, visited));
        }

        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }

    // getting the shortest cycle length from source to destination using BFS (for particular edge)
    private static int shortestPathLengthBfs(int src, int dst, int v, List<Set<Integer>> adjList, boolean[][] done) {
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[v];

        done[src][dst] = true;
        done[dst][src] = true;
        adjList.get(src).remove(dst);   // cycle detection
        adjList.get(dst).remove(src);

        q.add(new int[]{src, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            visited[cur[0]] = true;

            if (cur[0] == dst) return cur[1] + 1;

            for (int i : adjList.get(cur[0]))
                if (!visited[i]) q.add(new int[]{i, cur[1] + 1});
        }

        adjList.get(src).add(dst);      // restoring the edge
        adjList.get(dst).add(src);      // you can say: backtracking

        return Integer.MAX_VALUE;
    }

    // converting edge matrix to adjacency list.
    private static List<Set<Integer>> adjList(int v, int[][] edges) {
        List<Set<Integer>> list = new ArrayList<>();
        for (int i = 0; i < v; i++) list.add(new HashSet<>());

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            list.get(a).add(b);
            list.get(b).add(a);
        }

        return list;
    }

/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯Optimized⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(V × (V + E))
SC : O(V + E)
*/
    static int shortCycle(int v, int[][] edges) {
        // potd.code.hub
        int ans = Integer.MAX_VALUE;
        List<Set<Integer>> adjList = adjacencyList(v, edges);

        for (int i = 0; i < v; i++)
            ans = Math.min(ans, shortestPathLen(i, v, adjList));

        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }

    // getting the shortest cycle length for particular vertex.
    private static int shortestPathLen(int vertex, int v, List<Set<Integer>> adjList) {
        Queue<Integer> q = new LinkedList<>();

        // using to store the distance from vertex and also works as a visited array
        int[] dist = new int[v];

        Arrays.fill(dist, -1);
        dist[vertex] = 0;
        q.add(vertex);

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int j : adjList.get(cur)) {
                if (dist[j] == -1) {
                    dist[j] = dist[cur] + 1;
                    q.add(j);
                }
                // distance of 'j' is greater or equal with distance of 'cur' means 'j' never be the parent of 'cur'
                // 'j' is not parent and visited means there is a cycle.
                else if (dist[j] >= dist[cur]) {
                    return dist[j] + dist[cur] + 1;
                }
            }
        }

        return Integer.MAX_VALUE;
    }

    // converting edge matrix to adjacency list.
    private static List<Set<Integer>> adjacencyList(int v, int[][] edges) {
        List<Set<Integer>> list = new ArrayList<>();
        for (int i = 0; i < v; i++) list.add(new HashSet<>());

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            list.get(a).add(b);
            list.get(b).add(a);
        }

        return list;
    }
}
