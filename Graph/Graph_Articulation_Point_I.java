package Graph;/*
 *
 * https://www.geeksforgeeks.org/problems/articulation-point-1/1
 *
 * # Articulation Point - I
 *
 *   Q. Given an undirected connected graph with V vertices and adjacency list adj. You are
 *      required to find all the vertices removing which (and edges through it) disconnects
 *      the graph into 2 or more components and return it in sorted manner.
 *
 *      Note: Indexing is zero-based i.e., nodes numbering from (0 to V-1). There might be
 *            loops present in the graph.
 *    Ex.
 *      Input :
 *           <0>
 *           /
 *        <1>     <3>
 *           \    /  \
 *            \  /    \
 *            <4>-----<2>
 *
 *      Output:{1,4}
 *      Explanation:
 *          -> Removing the vertex 1 will disconnect the graph as-
 *
 *                  <0>
 *
 *                      <3>
 *                     /  \
 *                    /    \
 *                 <4>-----<2>
 *
 *          -> Removing the vertex 4 will disconnect the graph as-
 *
 *                  <0>
 *                  /
 *               <1>     <3>
 *                          \
 *                           \
 *                           <2>
 */
import java.util.ArrayList;
import java.util.List;

public class Graph_Articulation_Point_I {

    /// main Method
    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(List.of(1)));
        adj.add(new ArrayList<>(List.of(0, 4)));
        adj.add(new ArrayList<>(List.of(3, 4)));
        adj.add(new ArrayList<>(List.of(2, 4)));
        adj.add(new ArrayList<>(List.of(1, 2, 3)));

        int v = 5;

        System.out.println("""
                Graph looks like:
                       <0>
                       /
                    <1>      <3>
                       \\    /  \\
                        \\  /    \\
                        <4>-----<2>\s
               \s""");

        System.out.println(articulationPoints(v, adj));
    }

    /// Solution (Remove static keyword before pasting in GFG)
    static ArrayList<Integer> articulationPoints(int v, ArrayList<ArrayList<Integer>> adj){
        // potd.code.hub
        boolean[] visited = new boolean[v];
        boolean[] artPoints = new boolean[v];
        int[] tin = new int[v];
        int[] low = new int[v];

        dfs(0, -1, adj, visited, artPoints, tin, low);

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0;i < v;i++)
            if (artPoints[i]) ans.add(i);

        return (ans.isEmpty()) ? new ArrayList<>(List.of(-1)) : ans;
    }
    private static int count = 0;
    private static void dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean[]visited, boolean[] points, int[] tin, int[] low){
        visited[node] = true;
        low[node] = tin[node] = count++;

        int child = 0;
        for (int i : adj.get(node)){
            if (i == parent) continue;
            if (!visited[i]){
                dfs(i, node, adj, visited, points, tin, low);
                low[node] = Math.min(low[node], low[i]);
                if (low[i] >= tin[node] && parent != -1) {
                    points[node] = true;
                }
                child++;
            }
            else {
                low[node] = Math.min(low[node], tin[i]);
            }
        }
        if (parent == -1 && child > 1)
            points[node] = true;
    }
}
