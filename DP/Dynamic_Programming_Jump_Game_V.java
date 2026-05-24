package DP;/*
 *
 * https://leetcode.com/problems/jump-game-v/
 *
 * # 1340. Jump Game V
 *
 *   Q. Given an array of integers arr and an integer d. In one step you can jump from index i to index:
 *
 *        ◦ i + x where: i + x < arr.length and  0 < x <= d.
 *
 *        ◦ i - x where: i - x >= 0 and  0 < x <= d.
 *
 *        ◦ In addition, you can only jump from index i to index j if arr[i] > arr[j] and arr[i] > arr[k] for all indices
 *          k between i and j (More formally min(i, j) < k < max(i, j)).
 *
 *      You can choose any index of the array and start jumping. Return the maximum number of indices you can visit.
 *
 *      Notice that you can not jump outside the array at any time.
 *
 *    Ex.
 *      Input : arr = [6, 4, 14, 6, 8, 13, 9, 7, 10, 6, 12],
 *              d = 2
 *      Output: 4
 *      Explanation: You can start at index 10. You can jump 10 --> 8 --> 6 --> 7 as shown.
 *
 *                   Note that if you start at index 6 you can only jump to index 7. You cannot jump to index 5 because
 *                   13 > 9. You cannot jump to index 4 because index 5 is between index 4 and 6 and 13 > 9.
 *
 *                   Similarly, You cannot jump from index 3 to index 2 or index 1.
 *
 *  Constraints:
 *          1 <= arr.length <= 1000
 *          1 <= arr[i] <= 10⁵
 *          1 <= d <= arr.length
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Dynamic_Programming_Jump_Game_V {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the array elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.println("Enter d: ");
        int d = sc.nextInt();

        System.out.println("Maximum number of indices we can visit: ");
        System.out.println(maxJumps(arr, d));
    }

    /// Solution
/*
☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑-bottom-up-DP-☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑
TC : O(n log n + (n * d))
SC : O(n)
*/
    static int bottom_up(int[] arr, int d) {
        // potd.code.hub
        int n = arr.length;
        int max = 0;
        int[] dp = new int[n];
        Integer[] indices = new Integer[n];

        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, Comparator.comparingInt(i -> arr[i]));

        for (int i = 0; i < n; i++) {
            max = Math.max(max, maxJumpFromHere(indices[i], arr, d, dp));
        }

        return max;
    }

    // helper
    private static int maxJumpFromHere(int src, int[] arr, int d, int[] dp) {
        int n = arr.length;
        int max = 0;
        int leftTarget = Math.max(src - d, 0);
        int rightTarget = Math.min(src + d, n - 1);

        // move forward
        for (int i = src + 1; i <= rightTarget; i++) {
            if (arr[src] <= arr[i]) break;
            max = Math.max(max, dp[i]);
        }

        // move backword
        for (int i = src - 1; i >= leftTarget; i--) {
            if (arr[src] <= arr[i]) break;
            max = Math.max(max, dp[i]);
        }


        return dp[src] = max + 1;
    }

/*
☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑-top-down-DP-☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑
TC : O(n * d)
TC : O(n) + extra recursive call stack
*/
    static int maxJumps(int[] arr, int d) {
        // potd.code.hub
        int n = arr.length;
        int max = 0;
        int[] dp = new int[n];
    
        Arrays.fill(dp, -1);
    
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dfs(i, d, n, arr, dp));
        }
    
        return max;
    }

    private static int dfs(int src, int d, int n, int[] arr, int[] dp) {
        // base case
        if (dp[src] != -1) return dp[src];

        int max = 0;
        int leftTarget = Math.max(src - d, 0);
        int rightTarget = Math.min(src + d, n - 1);

        // forward
        for (int i = src + 1; i <= rightTarget; i++) {
            if (arr[src] <= arr[i]) break;
            max = Math.max(max, dfs(i, d, n, arr, dp));
        }

        // backward
        for (int i = src - 1; i >= leftTarget; i--) {
            if (arr[src] <= arr[i]) break;
            max = Math.max(max, dfs(i, d, n, arr, dp));
        }

        // self work
        return dp[src] = 1 + max;
    }
}
