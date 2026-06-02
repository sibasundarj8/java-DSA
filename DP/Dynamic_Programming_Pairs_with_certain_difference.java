package DP;/*
 *
 * https://www.geeksforgeeks.org/problems/pairs-with-specific-difference1533/1
 *
 * # Pairs with certain difference
 *
 *   Q. Given an array of integers and a number k, the task is the find maximum pair sum with the following conditions on
 *      the pairs.
 *        ◦ Pair difference should be less than k.
 *        ◦ Pairs should be disjoint. For example if (x, y) is a result pair, then neither x nor y should appear in any
 *          other result pair.
 *        ◦ Sum of p pairs means sum of 2p elements in the result.
 *        ◦ If no valid pairs can be formed, return 0.
 *
 *    Ex.
 *      Input : arr[] = [3, 5, 10, 15, 17, 12, 9], K = 4
 *      Output: 62
 *      Explanation :
 *              The valid disjoint pairs with difference less than K are: (3, 5), (10, 12), (15, 17)
 *              The maximum sum obtained from these pairs is: 3 + 5 + 10 + 12 + 15 + 17 = 62
 *
 *              An alternative pairing could be: (3, 5), (9, 12), (15, 17)
 *              However, this combination results in a smaller total sum, so it is not optimal.
 *
 *  Constraints:
 *      1 ≤ arr.size() ≤ 10⁵
 *      0 ≤ k ≤ 10⁵
 *      1 ≤ arr[i] ≤ 10⁴
 */

import java.util.Arrays;
import java.util.Scanner;

public class Dynamic_Programming_Pairs_with_certain_difference {

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

        System.out.println("Enter k: ");
        int k = sc.nextInt();

        System.out.println("Maximum pair sum: ");
        System.out.println(sumDiffPairs(arr, k));
    }

    /// Solution
/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯-Memoization-⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(n log n)
SC : O(n) + Extra recursive call stack
*/
    static int memoization(int[] arr, int k) {
        // potd.code.hub
        int n = arr.length;
        int[] dp = new int[n + 1];

        Arrays.fill(dp, -1);
        Arrays.sort(arr);

        return solve(n, arr, k, dp);
    }

    private static int solve(int idx, int[] arr, int k, int[] dp) {
        // base case
        if (idx <= 1) return 0;
        if (dp[idx] != -1) return dp[idx];

        // recursive work
        int notPick = solve(idx - 1, arr, k, dp);
        int pick = (arr[idx - 1] - arr[idx - 2] < k) ? arr[idx - 1] + arr[idx - 2] + solve(idx - 2, arr, k, dp) : 0;

        // self work
        return dp[idx] = Math.max(pick, notPick);
    }

/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯--Tabulation--⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(n log n)
SC : O(n)
*/
    static int tabulation(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];

        Arrays.sort(arr);

        for (int idx = 2; idx <= n; idx++) {

            // recursive work simulation
            int notPick = dp[idx - 1];
            int pick = (arr[idx - 1] - arr[idx - 2] < k) ? arr[idx - 1] + arr[idx - 2] + dp[idx - 2] : 0;

            // self work simulation
            dp[idx] = Math.max(pick, notPick);
        }

        return dp[n];
    }

/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯-Space-Optimized-⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(n log n)
SC : O(1)
*/
    static int sumDiffPairs(int[] arr, int k) {
        int n = arr.length;
        int curr = 0;
        int prv1 = 0;
        int prv2 = 0;

        Arrays.sort(arr);

        for (int idx = 2; idx <= n; idx++) {

            // recursive work simulation
            int notPick = prv1;
            int pick = (arr[idx - 1] - arr[idx - 2] < k) ? arr[idx - 1] + arr[idx - 2] + prv2 : 0;

            // self work simulation
            curr = Math.max(pick, notPick);

            // rolling
            prv2 = prv1;
            prv1 = curr;
        }

        return curr;
    }
}
