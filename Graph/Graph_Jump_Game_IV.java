package Graph;/*
 *
 * https://leetcode.com/problems/jump-game-iv/
 *
 * # 1345. Jump Game IV
 *
 *   Q. Given an array of integers arr, you are initially positioned at the first index of the array.
 *
 *      In one step you can jump from index i to index:
 *        ◦ i + 1 where: i + 1 < arr.length.
 *        ◦ i - 1 where: i - 1 >= 0.
 *        ◦ j where: arr[i] == arr[j] and i != j.
 *
 *      Return the minimum number of steps to reach the last index of the array.
 *
 *      Notice that you can not jump outside the array at any time.
 *
 *    Ex.
 *      Input : arr = [100, -23, -23, 404, 100, 23, 23, 23, 3, 404]
 *      Output: 3
 *      Explanation: You need three jumps from index 0 --> 4 --> 3 --> 9. Note that index 9 is the last index of the array.
 *
 *  Constraints:
 *          1 <= arr.length <= 5 * 10⁴
 *          -10⁸ <= arr[i] <= 10⁸
 */

import java.util.*;

public class Graph_Jump_Game_IV {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.println("Minimum number of steps to reach the last index: ");
        System.out.println(minJumps(arr));
    }

    /// Solution
    static int minJumps(int[] arr) {
        int n = arr.length;
        int step = 0;

        boolean[] visited = new boolean[n];
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        // BFS
        q.offer(0);
        visited[0] = true;

        outer:
        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                int cur = q.poll();
                if (cur == n - 1) {
                    break outer;
                }

                // moving to the same elements
                for (int x : map.get(arr[cur])) {
                    if (!visited[x]) {
                        visited[x] = true;
                        q.offer(x);
                    }
                }
                map.get(arr[cur]).clear();

                // moving just one step forward or backward
                for (int x : new int[]{cur - 1, cur + 1}) {
                    if (0 <= x && x < n && !visited[x]) {
                        visited[x] = true;
                        q.offer(x);
                    }
                }
            }

            step++;
        }

        return step;
    }
}
