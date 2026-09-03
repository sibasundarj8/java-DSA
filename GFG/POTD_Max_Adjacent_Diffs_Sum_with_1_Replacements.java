package GFG;/*
 *
 * https://www.geeksforgeeks.org/problems/modify-array-to-maximize-sum-of-adjacent-differences1729/1
 *
 * # Max Adjacent Diffs Sum with 1 Replacements
 *
 *   Q. Given an integer array arr[], you are allowed to replace any elements with 1.  Find the maximum sum of absolute
 *      differences between consecutive elements after any number of modifications.
 *
 *    Ex.
 *      Input : arr[] = [3, 2, 1, 4, 5]
 *      Output: 8
 *      Explanation: Modify the array as arr[] = [3, 1, 1, 4, 1].
 *                   Sum = |1-3| + |1-1| + |4-1| + |1-4| = 8, the maximum possible.
 *
 *  Constraints:
 *      1 ≤ arr.size() ≤ 10⁵
 */

import java.util.Scanner;

public class POTD_Max_Adjacent_Diffs_Sum_with_1_Replacements {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("int[] arr: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.println("Maximum sum of absolute differences between consecutive elements after modifications: ");
        System.out.println(approach_1(arr));
    }

    /// Solution
/*
-------------------------------------------------------brute-force-------------------------------------------------------
Time: O(2ⁿ)
Space: O(n) recursion stack
*/
    static int approach_1(int[] arr) {
        // potd.code.hub
        int n = arr.length;

        if (n <= 1) return 0;

        return (int) Math.max(solve1(1, 0, n, arr), solve1(1, 1, n, arr));
    }

    private static long solve1(int i, int prevChoice, int n, int[] arr) {
        // base case
        if (i == n) return 0;

        // self work
        int prev = (prevChoice == 0) ? arr[i - 1] : 1;

        // recursive work
        long keep = Math.abs(arr[i] - prev) + solve1(i + 1, 0, n, arr);
        long modify = Math.abs(1 - prev) + solve1(i + 1, 1, n, arr);

        return Math.max(keep, modify);
    }

/*
-------------------------------------------------------memoization-------------------------------------------------------
Time: O(n × 2)
Space: O(n) + O(n) recursion stack
*/
    static int approach_2(int[] arr) {
        // potd.code.hub
        int n = arr.length;

        if (n <= 1) return 0;

        long[][] dp = new long[n][2];

        for (int i = 0; i < n; i++) {
            dp[i][0] = dp[i][1] = -1;
        }

        return (int) Math.max(solve2(1, 0, n, arr, dp), solve2(1, 1, n, arr, dp));
    }

    private static long solve2(int i, int prevChoice, int n, int[] arr, long[][] dp) {
        // base case
        if (i == n) return 0;
        if (dp[i][prevChoice] != -1) return dp[i][prevChoice];

        // self work
        int prev = (prevChoice == 0) ? arr[i - 1] : 1;

        // recursive work
        long keep = Math.abs(prev - arr[i]) + solve2(i + 1, 0, n, arr, dp);
        long modify = Math.abs(prev - 1) + solve2(i + 1, 1, n, arr, dp);

        return dp[i][prevChoice] = Math.max(keep, modify);
    }

/*
-------------------------------------------------------tabulation-------------------------------------------------------
Time: O(n)
Space: O(n)
*/
    static int approach_3(int[] arr) {
        // potd.code.hub
        int n = arr.length;

        if (n <= 1) return 0;

        long[][] dp = new long[n + 1][2];

        for (int i = n - 1; i >= 1; i--) {

            // dp[i][0] = maximum sum from index i onward, when arr[i - 1] is kept unchanged
            dp[i][0] = Math.max(
                    Math.abs(arr[i - 1] - arr[i]) + dp[i + 1][0],
                    Math.abs(arr[i - 1] - 1) + dp[i + 1][1]
            );

            // dp[i][1] = maximum sum from index i onward, when arr[i - 1] is replaced with 1
            dp[i][1] = Math.max(
                    Math.abs(1 - arr[i]) + dp[i + 1][0],
                    dp[i + 1][1]
            );
        }

        // First element can either be kept or replaced
        return (int) Math.max(dp[1][0], dp[1][1]);
    }

/*
---------------------------------------------------space-optimization---------------------------------------------------
Time: O(n)
Space: O(1)
*/
    static int maxDiffSum(int[] arr) {
        // potd.code.hub
        int n = arr.length;

        if (n <= 1) return 0;

        long nextKeep, nextModify, currKeep, currModify;
        nextKeep = nextModify = 0;

        for (int i = n - 1; i >= 1; i--) {

            // Case 1: maximum sum from index i onward, when arr[i - 1] is kept unchanged
            currKeep = Math.max(
                    Math.abs(arr[i - 1] - arr[i]) + nextKeep,
                    Math.abs(arr[i - 1] - 1) + nextModify
            );

            // Case 2: maximum sum from index i onward, when arr[i - 1] is replaced with 1
            currModify = Math.max(
                    Math.abs(1 - arr[i]) + nextKeep,
                    nextModify
            );

            // shrink
            nextKeep = currKeep;
            nextModify = currModify;
        }

        // First element can either be kept or replaced
        return (int) Math.max(nextKeep, nextModify);
    }
}
