package GFG;/*
 *
 * https://www.geeksforgeeks.org/problems/party-in-town3951/1
 *
 * # Party in Town
 *
 *   Q. Geek Town has n houses numbered from 1 to n, choose a house to host a party such that its distance from its
 *      farthest house is as small as possible. Return this minimum possible distance.
 *
 *      The houses are connected by n − 1 bidirectional roads, forming a tree.
 *
 *      The connections are given as an adjacency list adj, where adj[i] contains all houses directly connected to
 *      house i + 1.
 *
 *    Ex.
 *      Input : adj[][] = [[2],
 *                         [1, 4, 3],          2
 *                         [2],              / | \
 *                         [2]]             1  4  3
 *      Output: 1
 *      Explanation: Party should take place at house number 2. Maximum distance from house number 2 is 1.
 *
 *  Constraints:
 *        ◦ 1 ≤ n ≤ 10⁵
 *        ◦ 1 ≤ adj[i][j]
 *        ◦ adj.size() = n
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class POTD_Party_in_Town {

    /// main Method
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        adj.add(new ArrayList<>());
        adj.add(new ArrayList<>());
        adj.add(new ArrayList<>());
        adj.add(new ArrayList<>());

        adj.get(0).add(2);
        adj.get(1).addAll(List.of(1, 4, 3));
        adj.get(2).add(2);
        adj.get(3).add(2);

        System.out.print("""
                Tree:
                      2
                    / | \\
                   1  4  3
                """);
        System.out.println("Party point minimized max distance:");
        System.out.println(partyHouse(adj));
    }

    /// Solution
    static int partyHouse(ArrayList<ArrayList<Integer>> adj) {
        // potd.code.hub
        int n = adj.size();
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n];

        q.offer(1);
        int last = 1;
        visited[0] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : adj.get(cur - 1)) {
                if (!visited[next - 1]) {
                    visited[next - 1] = true;
                    last = next;
                    q.offer(next);
                }
            }
        }

        int dist = 0;
        q.offer(last);
        visited[last - 1] = false;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int cur = q.poll();

                for (int next : adj.get(cur - 1)) {
                    if (visited[next - 1]) {
                        visited[next - 1] = false;
                        q.offer(next);
                    }
                }
            }

            dist++;
        }

        return dist >> 1;
    }
}
