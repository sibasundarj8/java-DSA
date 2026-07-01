package DP;/*
 *
 * https://www.geeksforgeeks.org/problems/subset-with-sum-divisible-by-m2546/1
 *
 * # Check Subset sum divisible by k
 *
 *   Q. Given an array arr[] of positive integers and a value k. Return true if the sum of any non-empty subset of the
 *      given array is divisible by k otherwise, return false.
 *
 *    Ex.
 *      Input : arr[] = [3, 1, 7, 5],
 *              k = 6
 *      Output: true
 *      Explanation: If we take the subset {7, 5} then sum will be 12 which is divisible by 6.
 *
 *  Constraints:
 *          1 ≤ arr.size(), k ≤ 10³
 *          1 ≤ arr[i] ≤ 10³
 */

import java.util.Scanner;

public class Dynamic_Programming_Check_Subset_sum_divisible_by_k {

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

        System.out.print("k : ");
        int k = sc.nextInt();

        System.out.println("is the sum of any non-empty subset divisible by k: ");
        System.out.println(divisibleByK(arr, k));
    }

    /// Solution
/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯-memoization-⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(n * k)
SC : O(n * k) + extra recursive call stack
*/
    static boolean approach_1(int[] arr, int k) {
        // potd.code.hub
        int n = arr.length;
        int[][][] dp = new int[n][k][2];

        for (int[][] mat : dp) {
            for (int[] row : mat) {
                row[0] = row[1] = -1;
            }
        }

        return solve(n - 1, 0, 0, arr, k, dp) == 1;
    }

    private static int solve(int idx, int sum, int picked, int[] arr, int k, int[][][] dp) {
        // base case
        if (idx == -1)  {
            return (sum == 0 && picked == 1) ? 1 : 0;
        }
        if (dp[idx][sum][picked] != -1) return dp[idx][sum][picked];

        // recursive case
        int pick = solve(idx - 1, (sum + arr[idx]) % k, 1, arr, k, dp);
        int notPick = solve(idx - 1, sum, picked, arr, k, dp);

        return dp[idx][sum][picked] = Math.max(pick, notPick);
    }

/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯--tabulation--⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(n * k)
SC : O(n * k)
*/
    static boolean approach_2(int[] arr, int k) {
        // potd.code.hub
        int n = arr.length;
        int[][][] dp = new int[n + 1][k][2];
        dp[0][0][1] = 1;

        for (int idx = 1; idx <= n; idx++) {
            for (int sum = k - 1; sum >=  0; sum--) {
                int pick = dp[idx - 1][(sum + arr[idx - 1]) % k][1];
                dp[idx][sum][0] = Math.max(pick, dp[idx - 1][sum][0]);
                dp[idx][sum][1] = Math.max(pick, dp[idx - 1][sum][1]);
            }
        }

        return dp[n][0][0] == 1;
    }

/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯-space-optimized-⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(n * k)
SC : O(k)
*/
    static boolean divisibleByK(int[] arr, int k) {
        // potd.code.hub
        int n = arr.length;
        int[][] prev = new int[k][2];
        int[][] curr = new int[k][2];
        prev[0][1] = 1;

        for (int idx = 1; idx <= n; idx++) {
            for (int sum = k - 1; sum >=  0; sum--) {
                int pick = prev[(sum + arr[idx - 1]) % k][1];
                curr[sum][0] = Math.max(pick, prev[sum][0]);
                curr[sum][1] = Math.max(pick, prev[sum][1]);
            }
            int[][] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[0][0] == 1;
    }
}
