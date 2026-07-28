package Graph;/*
 *
 * https://www.geeksforgeeks.org/problems/level-of-nodes1147/1
 *
 * # Shortest Path in 1-2 Graph
 *
 *   Q. Given a weighted undirected graph with V vertices numbered from 0 to V - 1, represented by an array edges, where
 *      edges[i] = [ui, vi, wi] indicates that there is an edge between vertices ui and vi with a weight of wi. (wi can
 *      only be 1 or 2), and two vertices src and dest, find the shortest distance from src to dest.
 *
 *      The shortest distance is defined as the minimum total weight required to reach dest starting from src.
 *
 *      Return the shortest distance from src to dest. If dest is not reachable from src, return -1.
 *
 *    Ex.
 *      Input : V = 4,
 *              edges[][] = [[0, 1, 1],
 *                           [0, 2, 2],
 *                           [2, 3, 1],
 *                           [1, 2, 1],
 *                           [1, 3, 2]],
 *              src = 0, dest = 3
 *      Output: 3
 *                                           0
 *                                         /   \
 *                                     (1)/     \(2)
 *                                       /  (1)  \
 *                                      1 ------- 2
 *                                       \       /
 *                                     (1)\     /(2)
 *                                         \   /
 *                                           3
 *      Explanation:
 *              One of the shortest paths from vertex 0 to vertex 3 is 0 -> 1 -> 3 with a total weight of 1 + 2 = 3.
 *              Another shortest path is 0 -> 2 -> 3 with a total weight of 2 + 1 = 3.
 *              Hence, the shortest distance from 0 to 3 is 3.
 *
 *  Constraints:
 *        ◦ 2 ≤ V ≤ 10⁵
 *        ◦ 1 ≤ edges.size() ≤ min(2 * 10⁵,  V * (V-1) / 2)
 *        ◦ 0 ≤ edges[i][0], edges[i][1] ≤ V-1
 *        ◦ edges[i][0] != edges[i][1]
 *        ◦ 1 ≤ edges[i][1] ≤ 2
 */

import java.util.*;

public class Graph_Shortest_Path_in_1_2_Graph {

    /// main Method
    public static void main(String[] args) {
        int V = 4;
        int[][] edges = {{0, 1, 1}, {0, 2, 2}, {2, 3, 1}, {1, 2, 1}, {1, 3, 2}};
        int src = 0;
        int dest = 3;

        System.out.print("""
                current graph:
                               0
                             /   \\
                         (1)/     \\(2)
                           /  (1)  \\
                          1 ------- 2
                           \\       /
                         (1)\\     /(2)
                             \\   /
                               3
                source: 0
                destination: 3
                """);

        System.out.println("Shortest path distance: ");
        System.out.println(shortestPath(V, src, dest, edges));
    }

    /// Solution
/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯-Dijkstra-Algorithm-⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O((V + E)log V)
SC : O(V + E)
*/
    static int approach_1(int V, int src, int dest, int[][] edges) {
        if (src == dest) return 0;

        List<List<int[]>> adjList = toAdjList(V, edges);
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int[] dist = new int[V];

        queue.add(new int[]{src, 0});
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            if (dist[curr[0]] < curr[1]) continue;
            if (curr[0] == dest) return curr[1];

            for (int[] edge : adjList.get(curr[0])) {
                int v = edge[0];
                int d = curr[1] + edge[1];

                if (d < dist[v]) {
                    queue.add(new int[]{edge[0], curr[1] + edge[1]});
                    dist[v] = d;
                }
            }
        }

        return -1;
    }

    private static List<List<int[]>> toAdjList(int V, int[][] edges) {
        List<List<int[]>> adjList = new ArrayList<>();

        for (int i = 0; i < V; i++) {
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

/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯--BFS--⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(V + E)
SC : O(V + E)
*/
    static int shortestPath(int V, int src, int dest, int[][] edges) {
        // potd.code.hub
        if (src == dest) return 0;

        int dist = 0;
        List<List<Integer>> adjList = mapToAdjList(V, edges);
        boolean[] visited = new boolean[adjList.size()];
        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(src);
        visited[src] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int u = queue.poll();

                if (u == dest) return dist;

                for (int v : adjList.get(u)) {
                    if (!visited[v]) {
                        visited[v] = true;
                        queue.add(v);
                    }
                }
            }

            dist++;
        }

        return -1;
    }

    private static List<List<Integer>> mapToAdjList(int V, int[][] edges) {
        int newNode = V;
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            if (w == 1) {
                adjList.get(u).add(v);
                adjList.get(v).add(u);
            } else {
                adjList.add(new ArrayList<>());

                adjList.get(u).add(newNode);
                adjList.get(newNode).add(v);

                adjList.get(v).add(newNode);
                adjList.get(newNode).add(u);

                newNode++;
            }
        }

        return adjList;
    }
}
