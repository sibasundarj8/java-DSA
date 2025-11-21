package Graph;/*
 *
 * https://www.geeksforgeeks.org/problems/shortest-path-using-atmost-one-curved-edge--170647/1
 *
 * # Shortest Path Using Atmost One Curved Edge
 *
 *   Q. Given an undirected, connected graph with V vertices numbered from 0 to V-1 and E double-edges, represented as a
 *      2D array edges[][]. Each double-edge is represented by a tuple (x, y, w1, w2), which indicates that there are two
 *      edges between vertices x and y: a straight edge with weight w1 and a curved edge with weight w2.
 *
 *      You are given two vertices a and b and you have to go from a to b through a series of edges such that in the entire
 *      path, you can use at most 1 curved edge. Your task is to find the shortest path from a to b satisfying the above
 *      condition.
 *
 *      If no such path exists that satisfies this restriction, return -1.
 *
 *      Note: It is guaranteed that the shortest path value will fit in a 32-bit integer.
 *
 *    Ex.
 *      Input : V = 4, E = 4, a = 1, b = 3,
 *              edges[][] = [[0, 1, 1, 4],
 *                           [0, 2, 2, 4],
 *                           [0, 3, 3, 1],
 *                           [1, 3, 6, 5]]
 *      Output: 2
 *      Explanation: We can follow the path 1 -> 0 -> 3, this gives a distance of 1+3 = 4 if we follow all straight paths.
 *                   But we can take the curved path  from 0 -> 3, which costs 1. This will result in a cost of 1 + 1 = 2.
 *
 * 
 *  Constraints:
 *          1 ≤ V ≤ 10⁶
 *          0 ≤ E ≤ 10⁶
 *          0 ≤ a, b ≤ V - 1
 *          0 ≤ edges[i][0], edges[i][1] ≤ V-1
 *          0 ≤ edges[i][2], edges[i][3] ≤ 10⁴
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Graph_Shortest_Path_Using_Atmost_One_Curved_Edge {

    /// main Method
    public static void main(String[] args) {
        int v = 4;
        int a = 3;
        int b = 2;

        int[][] edges = {
                {0, 3, 8, 9},
                {1, 2, 7, 4},
                {1, 3, 10, 6}
        };

        System.out.println("Shortest path using at-most one curved edge: ");
        System.out.println(shortestPath(v, a, b, edges));
    }

    /// Solution
    public static int shortestPath(int V, int a, int b, int[][] edges) {
        // potd.code.hub
        ArrayList<ArrayList<int[]>> adjList = constructAdjacencyList(V, edges);
        int[] ab = dijkstra(a, adjList);
        int[] ba = dijkstra(b, adjList);

        int ans = ab[b];

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int curved = edge[3];
            int cost = Math.min(ab[u] + ba[v], ab[v] + ba[u]) + curved;
            ans = Math.min(ans, cost);
        }

        return (ans == 1e8) ? -1 : ans;
    }

    // shortest path from source to every vertex using dijkstra algorithm
    private static int[] dijkstra(int src, ArrayList<ArrayList<int[]>> adjList) {
        int V = adjList.size();
        int[] distance = new int[V];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        Arrays.fill(distance, (int) 1e8);
        distance[src] = 0;
        pq.add(new int[]{src, 0});


        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0];
            int dist = cur[1];

            if (dist != distance[u]) continue;

            for (int[] neighbor : adjList.get(u)) {
                int v = neighbor[0];
                int nextDist = dist + neighbor[1];

                if (nextDist < distance[v]) {
                    distance[v] = nextDist;
                    pq.add(new int[]{v, nextDist});
                }
            }
        }

        return distance;
    }

    // creating adjacency list
    private static ArrayList<ArrayList<int[]>> constructAdjacencyList(int V, int[][] edges) {
        ArrayList<ArrayList<int[]>> adjList = new ArrayList<>();

        for (int i = 0; i < V; i++)
            adjList.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int straight = edge[2];

            adjList.get(u).add(new int[]{v, straight});
            adjList.get(v).add(new int[]{u, straight});
        }

        return adjList;
    }
 /*
   private static class Node {
        int val;
        int distance;
        boolean flag;

        Node(int val, int distance, boolean flag) {
            this.val = val;
            this.distance = distance;
            this.flag = flag;
        }
    }

    public static int shortestPath(int V, int a, int b, int[][] edges) {
        // potd.code.hub
        boolean[] visited = new boolean[V];
        ArrayList<ArrayList<int[]>> adjList = constructAdjacencyList(V, edges);
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.distance));

        pq.add(new Node(a, 0, false));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int u = cur.val;
            int dist = cur.distance;
            boolean flag = cur.flag;
            visited[u] = true;

            System.out.println(u + " " + dist + " " + cur.flag);

            if (u == b) return dist;

            for (int[] neighbor : adjList.get(u)) {
                int v = neighbor[0];
                int straight = neighbor[1];
                int curved = neighbor[2];

                if (!visited[v]) {
                    if (flag) {
                        pq.add(new Node(v, dist + straight, true));
                    } else {
                        pq.add(new Node(v, dist + straight, false));
                        pq.add(new Node(v, dist + curved, true));
                    }
                }
            }
        }

        return -1;
    }

    // creating adjacency list
    private static ArrayList<ArrayList<int[]>> constructAdjacencyList(int V, int[][] edges) {
        ArrayList<ArrayList<int[]>> adjList = new ArrayList<>();

        for (int i = 0; i < V; i++)
            adjList.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int straight = edge[2];
            int curved = edge[3];

            adjList.get(u).add(new int[]{v, straight, curved});
            adjList.get(v).add(new int[]{u, straight, curved});
        }

        return adjList;
    }
  */
}
