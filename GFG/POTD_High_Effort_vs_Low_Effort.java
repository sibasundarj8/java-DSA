package GFG;/*
 *
 * https://www.geeksforgeeks.org/problems/high-effort-vs-low-effort0213/1
 *
 * # High Effort vs Low Effort
 *
 *   Q. Given two integer arrays h[] and l[], where h[i] and l[i] denote the number of tasks that can be completed on
 *      the i-th day by performing a high-effort task and a low-effort task, respectively.
 *
 *      For each day, you may choose exactly one of the following:
 *        ◦ Perform no task.
 *        ◦ Perform a low-effort task.
 *        ◦ Perform a high-effort task, which can only be performed on the first day or if no task was performed on the
 *          previous day.
 *
 *      Return the maximum total number of tasks that can be completed over all days.
 *
 *    Ex.
 *      Input : h[] = [2, 8, 1], l[] = [1, 2, 1]
 *      Output: 9
 *      Explanation: Pick the high-effort task on day 1 and the low-effort task on day 2. Total = 8 + 1 = 9.
 *
 *  Constraints:
 *        ◦ 1 ≤ h.size() ≤ 10⁵
 *        ◦ 0 ≤ h[i] ≤ 10³
 *        ◦ 1 ≤ l.size() ≤ 10⁵
 *        ◦ 0 ≤ l[i] ≤ 10³
 *        ◦ l.size() = h.size()
 */

import java.util.Arrays;
import java.util.Scanner;

public class POTD_High_Effort_vs_Low_Effort {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("int[] h: ");
        String[] H = sc.nextLine().split(" ");

        int n = H.length;
        int[] h = new int[n];
        int[] l = new int[n];

        System.out.print("int[] l: ");
        for (int i = 0; i < n; i++) {
            l[i] = sc.nextInt();
            h[i] = Integer.parseInt(H[i]);
        }

        System.out.println("Maximum total number of tasks that can be completed over all days: ");
        System.out.println(maxTask(h, l));
    }

    /// Solution
/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯-memoization-⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(n)
SC : O(n) + extra call stack space
*/
    static int approach_1(int[] h, int[] l) {
        // potd.code.hub
        int n = h.length;
        int[] dp = new int[n];

        Arrays.fill(dp, -1);

        return solve(n - 1, h, l, dp);
    }

    private static int solve(int i, int[] h, int[] l, int[] dp) {
        // base case
        if (i < 0) return 0;
        if (dp[i] != -1) return dp[i];

        // recursive case
        return dp[i] = Math.max(l[i] + solve(i - 1, h, l, dp), h[i] + solve(i - 2, h, l, dp));
    }

/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯--tabulation--⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(n)
SC : O(n)
*/
    static int approach_2(int[] h, int[] l) {
        // potd.code.hub
        int n = h.length;
        int[] dp = new int[n + 2];

        for (int i = 2; i <= n + 1; i++) {
            dp[i] = Math.max(l[i - 2] + dp[i - 1], h[i - 2] + dp[i - 2]);
        }

        return dp[n + 1];
    }

/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯-space-optimization-⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(n)
SC : O(1)
*/
    static int maxTask(int[] h, int[] l) {
        // potd.code.hub
        int n = h.length;
        int prv1 = 0;
        int prv2 = 0;

        for (int i = 2; i <= n + 1; i++) {
            int cur = Math.max(l[i - 2] + prv1, h[i - 2] + prv2);
            prv2 = prv1;
            prv1 = cur;
        }

        return prv1;
    }
}
