package Graph;/*
 *
 * https://leetcode.com/problems/jump-game-iii/
 *
 * # 1306. Jump Game III
 *
 *   Q. Given an array of non-negative integers arr, you are initially positioned at start index of the array. When you are
 *      at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach any index with value 0.
 *
 *      Notice that you can not jump outside the array at any time.
 *
 *    Ex.
 *      Input : arr = [4, 2, 3, 0, 3, 1, 2], start = 5
 *      Output: true
 *      Explanation:
 *              All possible ways to reach at index 3 with value 0 are:
 *              index 5 -> index 4 -> index 1 -> index 3
 *              index 5 -> index 6 -> index 4 -> index 1 -> index 3
 *
 *  Constraints:
 *          1 <= arr.length <= 5 * 10⁴
 *          0 <= arr[i] < arr.length
 *          0 <= start < arr.length
 */

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Graph_Jump_Game_III {

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

        System.out.println("Enter the start index: ");
        int start = sc.nextInt();

        if (start < 0 || start >= n) {
            throw new IllegalArgumentException("Invalid start index");
        }

        System.out.println(canReach(arr, start));
    }

    /// Solution
    static boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();

        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (arr[cur] == 0) {
                return true;
            }

            for (int nxt : new int[]{cur + arr[cur], cur - arr[cur]}) {
                if (nxt >= 0 && nxt < n && !visited[nxt]) {
                    q.add(nxt);
                    visited[nxt] = true;
                }
            }
        }

        return false;
    }
}
