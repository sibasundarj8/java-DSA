package Graph;/*
 *
 * https://www.geeksforgeeks.org/problems/bipartite-graph/1
 *
 * # Bipartite Graph
 *
 *   Q. Given an adjacency list of a graph adj. Check whether the graph is bipartite or not.
 *
 *      A bipartite graph can be colored with two colors such that no two adjacent vertices
 *      share the same color. This means we can divide the graph’s vertices into two distinct
 *      sets where:
 *
 *      😁 All edges connect vertices from one set to vertices in the other set.
 *      😁 No edges exist between vertices within the same set.
 *
 *   Ex.
 *      Input: adj = [[2, 3],                                  <0>   <1>
 *                    [2],                                     / \   /
 *                    [0, 1, 3],                              /   \ /
 *                    [0, 2]]                               <3>---<2>
 *      Output: false
 *      Explanation: The given graph cannot be colored in two colors such that the color of
 *                   adjacent vertices differs.
 */
import java.util.*;

public class Graph_Bipartite_Graph {

    /// main Method
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(List.of(2, 3)));
        adj.add(new ArrayList<>(List.of(2)));
        adj.add(new ArrayList<>(List.of(0, 1, 3)));
        adj.add(new ArrayList<>(List.of(0, 2)));

        System.out.println("""
                Input: \s
                             <0>   <1>
                             / \\   /
                            /   \\ /
                          <3>---<2>
                """);

        System.out.println("is Bipartite: \t" + isBipartite(adj));
    }

    /// Solution
    static boolean isBipartite(ArrayList<ArrayList<Integer>> adj) {
        // potd.code.hub
        int n = adj.size();

        Queue<Integer> q = new LinkedList<>();
        int[] color = new int[n];

        Arrays.fill(color, -1);

        for (int x = 0;x < n;x++){
            if (color[x] == -1){
                q.add(x);
                color[x] = 0;
                while (!q.isEmpty()) {
                    int cur = q.poll();
                    for (int i : adj.get(cur)) {
                        if (color[i] == -1) {
                            color[i] = (color[cur] == 0) ? 1 : 0;
                            q.add(i);
                        } else if (color[i] == color[cur]) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}
