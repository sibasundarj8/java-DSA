package GFG_160;/* 
 *
 * https://www.geeksforgeeks.org/problems/topological-sort/1
 *
 * # Topological sort
 *
 *   Q. Given a Directed Acyclic Graph (DAG) of V (0 to V-1) vertices and E edges represented
 *      as a 2D list of edges[][], where each entry edges[i] = [u, v] denotes a directed-edge
 *      u -> v. Return topological sort for the given graph.
 *
 *      Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices
 *      such that for every directed-edge u -> v, vertex u comes before v in the ordering.
 *
 *      Note: As there are multiple Topological orders possible, you may return any of them.
 *            If your returned Topological sort is correct, then the output will be true else
 *            false.
 *   Ex.
 *      Input : V = 4, E = 3            [1]----->[0]<-----[3]
 *              edges[][] = [[3, 0],              ↑
 *                           [1, 0],              |
 *                           [2, 0]]              |
 *                                               [2]
 *      Output: true
 *      Explanation: The output true denotes that the order is valid. Few valid Topological
 *                   orders for the given graph are:
 *         possible orders: [3, 2, 1, 0]
 *                          [1, 2, 3, 0]
 *                          [2, 3, 1, 0]
 */
import java.util.ArrayList;
import java.util.Stack;

public class GFG_Topological_sort {

    /// main Method
    public static void main(String[] args) {
        int v = 4;
        int[][] edges = {{3, 0},
                         {1, 0},
                         {2, 0}};

        System.out.println(topoSort(v, edges));
    }

    /// Solution
    public static ArrayList<Integer> topoSort(int v, int[][] edges) {
        // potd.code.hub
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(v);
        for (int i = 0;i < v;i++) adj.add(new ArrayList<>());

        for (int[] i : edges)
            adj.get(i[0]).add(i[1]);

        boolean[] visited = new boolean[v];
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>(v);

        for (int i = 0;i < v;i++)
            if (!visited[i])dfs(i, adj, visited, stack);

        while (!stack.isEmpty())
            ans.add(stack.pop());

        return ans;
    }
    private static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> stack){
        visited[node] =  true;
        for (int i : adj.get(node))
            if (!visited[i])
                dfs(i, adj, visited, stack);
        stack.add(node);
    }
}
