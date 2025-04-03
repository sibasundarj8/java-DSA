package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/1
 *
 * # BFS of graph
 *
 *   Q. Given a connected undirected graph containing V vertices, represented by a 2-d adjacency list
 *      adj[][], where each adj[i] represents the list of vertices connected to vertex i. Perform a
 *      Breadth First Search (BFS) traversal starting from vertex 0, visit vertices from left to right
 *      according to the given adjacency list, and return a list containing the BFS traversal of the graph.
 *
 *      Note: Do traverse in the same order as they are in the given adjacency list.
 *    Ex.
 *      Input: adj[][] = [[1, 2],                    <1>-----<2>
 *                        [0, 2],                     |     / | \
 *                        [0, 1, 3, 4],               |   /   |  \
 *                        [2],                        | /     |   \
 *                        [2]]                       <0>     <3>  <4>
 *      Output: [0, 1, 2, 3, 4]
 *      Explanation: Starting from 0, the BFS traversal proceeds as follows:
 *        Visit 0 → Output: 0
 *        Visit 1 (the first neighbor of 0) → Output: 0, 1
 *        Visit 2 (the next neighbor of 0) → Output: 0, 1, 2
 *        Visit 3 (the first neighbor of 2 that hasn't been visited yet) → Output: 0, 1, 2, 3
 *        Visit 4 (the next neighbor of 2) → Final Output: 0, 1, 2, 3, 4
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GFG_139_BFS_of_graph {

    /// main Method
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(List.of(1, 2)));
        adj.add(new ArrayList<>(List.of(0, 2)));
        adj.add(new ArrayList<>(List.of(0, 1, 3, 4)));
        adj.add(new ArrayList<>(List.of(2)));
        adj.add(new ArrayList<>(List.of(2)));

        System.out.println(bfs(adj));
    }

    /// Solution
    static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int n = adj.size();
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();

        q.add(0);
        visited[0] = true;

        while(!q.isEmpty()){
            int cur = q.poll();
            ans.add(cur);
            for(int i : adj.get(cur)){
                if(!visited[i]){
                    q.add(i);
                    visited[i] = true;
                }
            }
        }

        return ans;
    }
}
