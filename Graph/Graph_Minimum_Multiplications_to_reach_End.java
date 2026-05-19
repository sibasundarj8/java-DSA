package Graph;/*
 *
 * https://www.geeksforgeeks.org/problems/minimum-multiplications-to-reach-end/1
 *
 * # Minimum Multiplications to reach End
 *
 *   Q. Given two integers, start and end, along with an array of integers arr[]. In one operation, you can multiply the
 *      current value by any element from arr[], and then take the result modulo 1000 to obtain a new value.
 *
 *      Find the minimum steps in which end can be achieved starting from start. If it is not possible to reach end, then
 *      return -1.
 *
 *    Ex.
 *      Input : arr[] = [2, 5, 7], start = 3, end = 30
 *      Output: 2
 *      Explanation:
 *              Step 1: 3*2 = 6 % 1000 = 6
 *              Step 2: 6*5 = 30 % 1000 = 30
 *
 *  Constraints:
 *          1  ≤ arr.size()  ≤ 10³
 *          1  ≤ arr[i]  ≤ 10³
 *          0  ≤ start, end  < 10³
 */

import java.util.*;

public class Graph_Minimum_Multiplications_to_reach_End {

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

        System.out.print("Start: ");
        int start = sc.nextInt();

        System.out.print("End: ");
        int end = sc.nextInt();

        System.out.println("Minimum steps to reach end from start: ");
        System.out.println(minSteps(arr, start, end));
    }

    /// Solution
    static int minSteps(int[] arr, int start, int end) {
        // potd.code.hub
        int mod = (int) 1e3;
        int steps = 0;
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[1001];

        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                int cur = q.poll();

                if (cur == end) {
                    q.clear();
                    return steps;
                }

                for (int x : arr) {
                    int next = (cur * x) % mod;

                    if (!visited[next]) {
                        visited[next] = true;
                        q.add(next);
                    }
                }
            }

            steps++;
        }

        return -1;
    }
}
