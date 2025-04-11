package GFG_160;/*
 * https://www.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1
 *
 * # Dijkstra Algorithm
 *
 *   Q. Given an undirected, weighted graph with V vertices numbered from 0 to V-1 and E edges,
 *      represented by 2d array edges[][], where edges[i]=[u, v, w] represents the edge between
 *      the nodes u and v having w edge weight.
 *
 *      You have to find the shortest distance of all the vertices from the source vertex src,
 *      and return an array of integers where the ith element denotes the shortest distance
 *      between ith node and source vertex src.
 *
 *      Note: The Graph is connected and doesn't contain any negative weight edge.
 *   Ex.
 *      Input : V = 5
 *              edges[][] = {{0, 1,  4},
 *                           {0, 2,  8},
 *                           {1, 4,  6},
 *                           {2, 3,  2},
 *                           {3, 4, 10}}
 *              src = 0
 *      Output: [0, 4, 8, 10, 10]
 *      Explanation:                    <1>---------<4>
 *                                      /     6      |
 *                                     /4            |
 *                                    /              |
 *                                  <0>            10|
 *                                    \              |
 *                                     \8            |
 *                                      \     2      |
 *                                      <2>---------<3>
 *          Shortest Paths:
 *          For 0 to 1 minimum distance will be 4. By following path 0 -> 1
 *          For 0 to 2 minimum distance will be 8. By following path 0 -> 2
 *          For 0 to 3 minimum distance will be 10. By following path 0 -> 2 -> 3
 *          For 0 to 4 minimum distance will be 10. By following path 0 -> 1 -> 4
 */ 
import java.util.*;

public class GFG_148_Dijkstra_Algorithm {

    /// main Method
    public static void main(String[] args) {
        int v = 5;
        int[][] edges = {{0, 1,  4},
                         {0, 2,  8},
                         {1, 4,  6},
                         {2, 3,  2},
                         {3, 4, 10}};
        int src = 0;

        System.out.println("Edges Matrix: ");
        for (int[] i : edges) {
            System.out.println(Arrays.toString(i));
        }

        System.out.println("Graph looks like:");
        System.out.println("""
                               <1>---------<4>
                               /     6      |
                              /4            |
                             /              |
                           <0>            10|
                             \\              |
                              \\8            |
                               \\     2      |
                               <2>---------<3>
                """);

        int[] ans = dijkstra(v, edges, src);
        System.out.println(Arrays.toString(ans));
    }

    /// Solution
    static int[] dijkstra(int v, int[][] edges, int src) {
        // potd.code.hub
        List<List<Pair>> adj = new ArrayList<>(v);
        for (int i = 0;i < v;i++) {
            adj.add(new ArrayList<>());
        }
        // Adjacency List
        for (int[] i : edges){
            adj.get(i[0]).add(new Pair(i[1], i[2]));
            adj.get(i[1]).add(new Pair(i[0], i[2]));
        }

        int[] ans = new int[v];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[src] = 0;

        PriorityQueue<Pair> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.w));
        q.add(new Pair(src, 0));

        while (!q.isEmpty()){
            Pair cur = q.poll();
            for (Pair neighbour : adj.get(cur.v)){
                int dist = ans[cur.v] + neighbour.w;
                if (dist < ans[neighbour.v]){
                    ans[neighbour.v] = dist;
                    q.add(neighbour);
                }
            }
        }

        return ans;
    }
    private static class Pair {
        int v, w;
        Pair(int v, int w){
            this.w = w;
            this.v = v;
        }
    }
}
