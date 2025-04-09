package Graph;/*
 *
 * https://leetcode.com/problems/critical-connections-in-a-network/
 *
 * # 1192. Critical Connections in a Network
 *
 *   Q. There are n servers numbered from 0 to n - 1 connected by undirected server-to-server connections
 *      forming a network where connections[i] = [a₁, b₁] represents a connection between servers a₁ and b₁.
 *      Any server can reach other servers directly or indirectly through the network.
 *
 *      A critical connection is a connection that, if removed, will make some servers unable to reach some
 *      other server.
 *
 *      Return all critical connections in the network in any order.        <2>
 *   Ex.                                                                   / |
 *      Input : n = 4                                                    /   |
 *              connections = [[0, 1],                                 /     |
 *                             [1, 2],                              <1>      |
 *                             [2, 0],                               | ∖     |
 *                             [1, 3]]                               |   ∖   |
 *      Output: [[1,3]]                                              |     ∖ |
 *      Explanation: [[3,1]] is also accepted.                       |      <0>
 *                                                                  <3>
 */
import java.util.ArrayList;
import java.util.List;

public class Graph_Critical_Connections_in_a_Network {

    /// main Method
    public static void main(String[] args) {
        int n = 4;
        System.out.println("Number of Servers: " + n);

        List<List<Integer>> connections = List.of(List.of(0, 1),
                List.of(1, 2),
                List.of(2, 0),
                List.of(1, 3));

        System.out.println("Edges: ");
        for (List<Integer> i : connections)
            System.out.println(i);

        System.out.println("""
                Looks Like:\s
                                  <2>
                                  / |
                                /   |
                              /     |
                           <1>      |
                            | ∖     |
                            |   ∖   |
                            |     ∖ |
                            |      <0>
                           <3>
                \s""");

        System.out.println("Critical Connections: ");
        System.out.println(criticalConnections(n, connections));
    }

    /// Solution (It may not work for multiple test-cases, Don't forgot to remove static keyword.)
    static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        // sibasundarj8@gmail.com
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        // add all edges except edge between c and d.
        for (List<Integer> i : connections) {
            adj.get(i.get(0)).add(i.get(1));
            adj.get(i.get(1)).add(i.get(0));
        }
        // visited array
        boolean[] visited = new boolean[n];
        // reach time
        int[] tin = new int[n];
        // lowest time of reaching
        int[] low = new int[n];
        // answer List
        List<List<Integer>> ans = new ArrayList<>();

        dfs(0, -1, adj, visited, tin, low, ans);

        return ans;
    }

    private static int step = 0;
    private static void dfs(int node, int p, ArrayList<ArrayList<Integer>> adj, boolean[] visited, int[] tin, int[] low, List<List<Integer>> ans) {
        visited[node] = true;
        tin[node] = low[node] = step++;

        for (int i : adj.get(node)) {
            if (i == p) continue;
            if (!visited[i]){
                dfs(i, node, adj, visited, tin, low, ans);
                low[node] = Math.min(low[node], low[i]);
                if (low[i] > tin[node])
                    ans.add(List.of(node, i));
            }
            else {
                low[node] = Math.min(low[node], low[i]);
            }
        }
    }
}
