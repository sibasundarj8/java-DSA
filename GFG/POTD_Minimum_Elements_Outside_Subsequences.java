package GFG;/*
 *
 * https://www.geeksforgeeks.org/problems/minimum-number-of-elements-which-are-not-part-of-increasing-or-decreasing-subsequence2617/1
 *
 * # Minimum Elements Outside Subsequences
 *
 *   Q. Given an array arr[] of size n, partition its elements into a strictly increasing subsequence and a strictly
 *      decreasing subsequence.
 *
 *      Each element can belong to at most one of these subsequences, and some elements may remain unused.
 *
 *      Determine the minimum number of elements that cannot be included in either subsequence.
 *
 *    Ex.
 *      Input : arr[] = [7, 8, 1, 2, 4, 6, 3, 5, 2, 1, 8, 7]
 *      Output: 2
 *      Explanation: One possible increasing subsequence is: [1, 2, 4, 5, 8].
 *                   One possible decreasing subsequence is: [7, 6, 3, 2, 1].
 *                   The remaining elements are 8 and 7, so the minimum number of unselected elements is 2.
 *
 *  Constraints:
 *        1 ≤ n ≤ 100
 *        1 ≤ arr[i] ≤ 100
 */

import java.util.Arrays;
import java.util.Scanner;

public class POTD_Minimum_Elements_Outside_Subsequences {

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

        System.out.println("Minimum number of elements that cannot be included in either subsequence: ");
        System.out.println(minCount(arr));
    }

    /// Solution
/*
-------------------------------------------------------memoization-------------------------------------------------------
TC : O(n³)
SC : O(n³) + extra n recursive call stack
*/
    static int approach_1(int[] arr) {
        // potd.code.hub
        int n = arr.length;
        int[][][] dp = new int[n + 1][n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return solve(1, 0, 0, n, arr, dp);
    }

    private static int solve(int i, int incPrvIdx, int descPrvIdx, int n, int[] arr, int[][][] dp) {
        // base case
        if (i > n) return 0;
        if (dp[i][incPrvIdx][descPrvIdx] != -1) {
            return dp[i][incPrvIdx][descPrvIdx];
        }

        // recursive work
        // exclude --> (+1)
        int min = 1 + solve(i + 1, incPrvIdx, descPrvIdx, n, arr, dp);

        // include to increasing sequence
        if (incPrvIdx == 0 || arr[incPrvIdx - 1] < arr[i - 1]) {
            min = Math.min(min, solve(i + 1, i, descPrvIdx, n, arr, dp));
        }

        // include to decreasing sequence
        if (descPrvIdx == 0 || arr[descPrvIdx - 1] > arr[i - 1]) {
            min = Math.min(min, solve(i + 1, incPrvIdx, i, n, arr, dp));
        }

        return dp[i][incPrvIdx][descPrvIdx] = min;
    }

/*
-------------------------------------------------------tabulation-------------------------------------------------------
TC : O(n³)
SC : O(n³)
*/
    static int approach_2(int[] arr) {
        // potd.code.hub
        int min, n = arr.length;
        int[][][] dp = new int[n + 2][n + 1][n + 1];

        for (int i = n; i >= 1; i--) {
            for (int incPrvIdx = n - 1; incPrvIdx >= 0; incPrvIdx--) {
                for (int descPrvIdx = n - 1; descPrvIdx >= 0; descPrvIdx--) {

                    // exclude --> (+1)
                    min = 1 + dp[i + 1][incPrvIdx][descPrvIdx];

                    // include to increasing sequence
                    if (incPrvIdx == 0 || arr[incPrvIdx - 1] < arr[i - 1]) {
                        min = Math.min(min, dp[i + 1][i][descPrvIdx]);
                    }

                    // include to decreasing sequence
                    if (descPrvIdx == 0 || arr[descPrvIdx - 1] > arr[i - 1]) {
                        min = Math.min(min, dp[i + 1][incPrvIdx][i]);
                    }

                    dp[i][incPrvIdx][descPrvIdx] = min;
                }
            }
        }

        return dp[1][0][0];
    }

/*
---------------------------------------------------space-optimization---------------------------------------------------
TC : O(n³)
SC : O(n²)
*/
    static int minCount(int[] arr) {
        // potd.code.hub
        int min, n = arr.length;
        int[][] curr = new int[n + 1][n + 1];
        int[][] next = new int[n + 1][n + 1];

        for (int i = n; i >= 1; i--) {
            for (int incPrvIdx = n - 1; incPrvIdx >= 0; incPrvIdx--) {
                for (int descPrvIdx = n - 1; descPrvIdx >= 0; descPrvIdx--) {

                    // exclude --> (+1)
                    min = 1 + next[incPrvIdx][descPrvIdx];

                    // include to increasing sequence
                    if (incPrvIdx == 0 || arr[incPrvIdx - 1] < arr[i - 1]) {
                        min = Math.min(min, next[i][descPrvIdx]);
                    }

                    // include to decreasing sequence
                    if (descPrvIdx == 0 || arr[descPrvIdx - 1] > arr[i - 1]) {
                        min = Math.min(min, next[incPrvIdx][i]);
                    }

                    curr[incPrvIdx][descPrvIdx] = min;
                }
            }

            int[][] temp = curr;
            curr = next;
            next = temp;
        }

        return next[0][0];
    }
}
