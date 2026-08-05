package LeetCode;/*
 *
 * https://leetcode.com/problems/remove-methods-from-project/
 *
 * # LC. 3310. Remove Methods From Project
 *
 *   Q. I built a directed graph from the invocations and used BFS starting from method k to identify all suspicious
 *      methods. Then, I iterated through the safe methods to check if any invoked a suspicious one. If they did, I
 *      returned all methods; otherwise, I returned only the safe ones.
 *
 *    Ex.
 *      Input : n = 4, k = 1,
 *              invocations = [[1, 2],
 *                             [0, 1],
 *                             [3, 2]]
 *      Output: [0, 1, 2, 3]
 *      Explanation:             1
 *                            ⬋    ⬉
 *                          2       0
 *                            ⬉
 *                              3
 *              Method 2 and method 1 are suspicious, but they are directly invoked by methods 3 and 0, which are not
 *              suspicious. We return all elements without removing anything.
 *
 *  Constraints:
 *        ◦ 1 <= n <= 10⁵
 *        ◦ 0 <= k <= n - 1
 *        ◦ 0 <= invocations.length <= 2 * 10⁵
 *        ◦ invocations[i] == [a_i, b_i]
 *        ◦ 0 <= a_i, b_i <= n - 1
 *        ◦ a_i != b_i
 *        ◦ invocations[i] != invocations[j]
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LeetCode_3310_Remove_Methods_From_Project {

    /// main Method
    public static void main(String[] args) {
        int n = 4;
        int k = 1;
        int[][] invocations = {
                {1, 2},
                {0, 1},
                {3, 2}
        };

        System.out.println("output: ");
        System.out.println(remainingMethods(n, k, invocations));
    }

    /// Scanner
    static List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> adjList = mapToAdjList(invocations, n);
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();

        queue.offer(k);
        visited[k] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int i : adjList.get(cur)) {
                if (!visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }

        boolean flag = false;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                for (int next : adjList.get(i)) {
                    if (visited[next]) {
                        flag = true;
                        break;
                    }
                }
            }
        }

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (flag || !visited[i]) {
                res.add(i);
            }
        }

        return res;
    }

    private static List<List<Integer>> mapToAdjList(int[][] edges, int n) {
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
        }

        return adjList;
    }
}
