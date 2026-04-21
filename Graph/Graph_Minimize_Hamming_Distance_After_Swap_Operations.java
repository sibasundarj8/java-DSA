package Graph;/*
 *
 * https://leetcode.com/problems/minimize-hamming-distance-after-swap-operations/
 *
 * # 1722. Minimize Hamming Distance After Swap Operations
 *
 *   Q. You are given two integer arrays, source and target, both of length n. You are also given an array allowedSwaps
 *      where each allowedSwaps[i] = [a_i, b_i] indicates that you are allowed to swap the elements at index a_i and index b_i
 *      (0-indexed) of array source. Note that you can swap elements at a specific pair of indices multiple times and in any
 *      order.
 *
 *      The Hamming distance of two arrays of the same length, source and target, is the number of positions where the elements
 *      are different. Formally, it is the number of indices i for 0 <= i <= n-1 where source[i] != target[i] (0-indexed).
 *
 *      Return the minimum Hamming distance of source and target after performing any amount of swap operations on array source.
 *
 *    Ex.
 *      Input : source = [1, 2, 3, 4], target = [2, 1, 4, 5], allowedSwaps = [[0, 1], [2, 3]]
 *      Output: 1
 *      Explanation: source can be transformed the following way:
 *                   - Swap indices 0 and 1: source = [2, 1, 3, 4]
 *                   - Swap indices 2 and 3: source = [2, 1, 4, 3]
 *                   The Hamming distance of source and target is 1 as they differ in 1 position: index 3.
 *
 *  Constraints:
 *          n == source.length == target.length
 *          1 <= n <= 10⁵
 *          1 <= source[i], target[i] <= 10⁵
 *          0 <= allowedSwaps.length <= 10⁵
 *          allowedSwaps[i].length == 2
 *          0 <= a_i, bi <= n - 1
 *          a_i != b_i
 */

import java.util.*;

public class Graph_Minimize_Hamming_Distance_After_Swap_Operations {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Source[]: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] source = new int[n];
        for (int i = 0; i < n; i++) {
            source[i] = Integer.parseInt(s[i]);
        }

        System.out.println("Enter Target[]: ");
        int[] target = new int[n];
        for (int i = 0; i < n; i++) {
            target[i] = sc.nextInt();
        }

        System.out.println("Enter number of allowedSwaps allowed: ");
        n = sc.nextInt();
        int[][] allowedSwaps = new int[n][2];

        System.out.println("Enter allowedSwaps: ");
        for (int i = 0; i < n; i++) {
            allowedSwaps[i][0] = sc.nextInt();
            allowedSwaps[i][1] = sc.nextInt();
        }

        System.out.println("Minimum Hamming distance of source and target after performing allowedSwaps: ");
        System.out.println(minimumHammingDistance(source, target, allowedSwaps));
    }

    /// Solution
    static int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        // potd.code.hub
        int n = source.length;
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>(n);
        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int[] edge : allowedSwaps) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                ArrayList<Integer> component = bfs(i, adjacencyList, visited);
                HashMap<Integer, Integer> map = new HashMap<>();

                for (int idx : component) {
                    map.put(target[idx], map.getOrDefault(target[idx], 0) + 1);
                }

                for (int idx : component) {
                    if (map.getOrDefault(source[idx], 0) > 0) {
                        map.put(source[idx], map.get(source[idx]) + 1);
                    } else {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private static ArrayList<Integer> bfs(int src, ArrayList<ArrayList<Integer>> adjacencyList, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        q.add(src);
        res.add(src);
        visited[src] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : adjacencyList.get(cur)) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                    res.add(next);
                }
            }
        }

        return res;
    }
}
