package Graph;/*
 *
 * https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1
 *
 * # Minimum Spanning Tree
 *
 *   Q. Given a weighted, undirected, and connected graph with V vertices and E edges, your task
 *      is to find the sum of the weights of the edges in the Minimum Spanning Tree (MST) of the
 *      graph. The graph is represented by an adjacency list, where each element adj[i] is a List
 *      containing List of integers. Each List represents an edge, with the first integer denoting
 *      the endpoint of the edge and the second integer denoting the weight of the edge.
 *   Ex.
 *      Input : v = 3, e = 3                           <0>
 *              edges[][] = {{0, 1, 5},              5 / \
 *                           {1, 2, 3},               /   \ 1
 *                           {0, 2, 1}}             <1>---<2>
 *      Output: 4                                       3
 *      Explanation:   <0>
 *                       \
 *                        \ 1
 *                         \
 *                 <1>-----<2>
 *                      3
 *              The Spanning Tree resulting in the weight
 *              of 4 is shown above.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Graph_Minimum_Spanning_Tree {

    /// main Method
    public static void main(String[] args) {
        List<List<int[]>> edges = new ArrayList<>();
        edges.add(new ArrayList<>(List.of(new int[]{1, 5}, new int[]{2, 1})));
        edges.add(new ArrayList<>(List.of(new int[]{0, 5}, new int[]{2, 3})));
        edges.add(new ArrayList<>(List.of(new int[]{1, 3}, new int[]{0, 1})));
        int v = 3, e = 3;

        System.out.println("""
                Looks like:
                           <0>
                         5 / \\
                          /   \\ 1
                        <1>---<2>
                            3
                """);

        System.out.println(spanningTree(v, e, edges));
    }

    /// Solution
    static int spanningTree(int v, int e, List<List<int[]>> adj) {
        // potd.code.hub
        PriorityQueue<Pair> q = new PriorityQueue<>((a,b) -> a.w - b.w);
        boolean[] visited = new boolean[v];
        int sum = 0;

        q.add(new Pair(0, 0));
        while (!q.isEmpty()){
            Pair p = q.poll();
            if (visited[p.v]) continue;
            visited[p.v] = true;
            sum += p.w;
            for (int[] i : adj.get(p.v)){
                if (!visited[i[0]]){
                    q.add(new Pair(i[0], i[1]));
                }
            }
        }

        return sum;
    }
    private static class Pair {
        int w, v;
        Pair (int v, int w){
            this.v = v;
            this.w = w;
        }
    }
}
