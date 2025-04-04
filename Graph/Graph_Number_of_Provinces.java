package Graph;/*
 * https://www.geeksforgeeks.org/problems/number-of-provinces/1
 *
 * # Number of Provinces
 *
 *   Q. Given an undirected graph with V vertices. We say two vertices u and v belong to a
 *      single province if there is a path from u to v or v to u. Your task is to find the
 *      number of provinces.
 *
 *      Note: A province is a group of directly or indirectly connected cities and no other
 *            cities outside the group.
 *    Ex.
 *      Input: [                             <0>
 *              [1, 0, 1],                     \        <1>
 *              [0, 1, 0],                      \
 *              [1, 0, 1]                        \
 *             ]                                 <2>
 *      Output: 2
 *      Explanation:
 *              The graph clearly has 2 Provinces [1,3] and [2]. As city 1 and city 3 have a
 *              path between them, they belong to a single province. City 2 has no path to city 1
 *              or city 3, hence it belongs to another province.
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph_Number_of_Provinces {

    /// main Method
    public static void main(String[] args){
        // Adjacency matrix.
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(List.of(1, 0, 1)));
        adj.add(new ArrayList<>(List.of(0, 1, 0)));
        adj.add(new ArrayList<>(List.of(1, 0, 1)));

        System.out.println(numProvinces(adj, 3));
    }

    /// Solution
    static int numProvinces(ArrayList<ArrayList<Integer>> mat, int v) {
        // potd.code.hub
        int n = mat.size(), m = mat.get(0).size();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0;i < v;i++) adj .add(new ArrayList<>());
        // converting matrix representation to Adjacency List.
        for (int i = 0;i < n;i++){
            for (int j = 0;j < m;j++){
                if (mat.get(i).get(j) != 0){
                    adj.get(i).add(j);
                }
            }
        }
        // Counting the BFS calls. You can use DFS also.
        int count = 0;
        boolean[]visited = new boolean[v];
        for (int i = 0;i < v;i++){
            if (!visited[i]){
                count = bfs(i, adj, visited, count);
            }
        }

        return count;
    }
    private static int bfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[]visited, int count){
        Queue<Integer> q = new LinkedList<>();
        visited[node] = true;
        q.add(node);
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i : adj.get(cur)) {
                if (!visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
        return count+1;
    }
}
