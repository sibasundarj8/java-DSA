package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/minimum-weight-cycle/1
 *
 * # Minimum Weight Cycle
 *
 *   Q. Given an undirected, weighted graph with V vertices numbered from 0 to V-1 and E edges,
 *      represented by a 2d array edges[][], where edges[i] = [u, v, w] represents the edge
 *      between the nodes u and v having w-edge weight.
 *
 *      Your task is to find the minimum weight cycle in this graph.
 *   Ex.
 *      Input : V = 5
 *              edges[][] = [[0, 1, 2],          <0>-----<4>
 *                           [1, 2, 2],            \  3  /
 *                           [1, 3, 1],           2 \   / 1
 *                           [1, 4, 1],              \ /
 *                           [0, 4, 3],              <1>
 *                           [2, 3, 4]]              / \
 *      Output: 6                                 2 /   \ 1
 *      Explanation:                               /  4  \
 *                                               <2>-----<3>
 *              The Minimum-weighted cycle is 0 → 1 → 4 → 0 with a total weight of 6(2 + 1 + 3)
 */
import java.util.*;

public class GFG_154_Minimum_Weight_Cycle {

    /// main Method
    public static void main(String[] args) {
        System.out.println("""
                edges[][] = [[0, 1, 2],          <0>-----<4>
                             [1, 2, 2],            \\  3  /
                             [1, 3, 1],           2 \\   / 1
                             [1, 4, 1],              \\ /
                             [0, 4, 3],              <1>
                             [2, 3, 4]]              / \\
                                                  2 /   \\ 1
                                                   /  4  \\
                                                 <2>-----<3>
                """);
        int v = 5;
        int[][] edges ={{0, 1, 2},
                        {1, 2, 2},
                        {1, 3, 1},
                        {1, 4, 1},
                        {0, 4, 3},
                        {2, 3, 4}};
        System.out.println("Shortest Cycle: " + findMinCycle(v, edges));
    }

    /// Solution
    static int findMinCycle(int V, int[][] edges) {
        // potd.code.hub
        ArrayList<HashSet<Pair>> adj = new ArrayList<>();
        for (int i = 0;i < V;i++){
            adj.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
            adj.get(edge[1]).add(new Pair(edge[0], edge[2]));
        }

        int ans = (int)1e8;

        for (int[]edge : edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            ans = Math.min(ans, dijkstra(adj, u, v, V) + wt);
        }

        return ans;
    }
    private static int dijkstra (ArrayList<HashSet<Pair>> adj, int src, int dst, int v){
        PriorityQueue<Pair> q = new PriorityQueue<>(Comparator.comparing(a -> a.wt));
        int[]dist = new int[v];
        Arrays.fill(dist, (int)1e8);
        dist[src] = 0;
        q.add(new Pair(src, 0));

        while (!q.isEmpty()){
            Pair p = q.poll();
            for (Pair neighbour : adj.get(p.v)){
                int d = dist[p.v] + neighbour.wt;
                if (p.v == src && neighbour.v == dst ||
                    p.v == dst && neighbour.v == src){
                    continue;
                }
                if (dist[neighbour.v] > d){
                    dist[neighbour.v] = d;
                    q.add(neighbour);
                }
            }
        }

        return dist[dst];
    }
    private static class Pair {
        int v;
        int wt;
        Pair(int v, int wt){
            this.v = v;
            this.wt = wt;
        }
    }
}
