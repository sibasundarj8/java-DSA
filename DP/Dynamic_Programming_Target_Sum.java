package DP;/*
 *
 * https://www.geeksforgeeks.org/problems/target-sum-1626326450/1
 *
 * # Target Sum
 *
 *   Q. Given an array of integers arr[] and an integer target. We need to build an expression out of arr[] by adding one
 *      of the symbols '+' or  '-' before each integer in arr[] and then concatenate all the integers.
 *
 *      For example : if arr[] = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the
 *      expression "+2-1".
 *
 *      Return the number of different expressions that can be built, which evaluates to target.
 *
 *      Note : An expression is considered different from another if the placement of '+' and '-' operators differs, even
 *             if the resulting value is the same.
 *    Ex.
 *      Input : arr[] = [1, 1, 1, 1, 1], target = 3
 *      Output: 5
 *      Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
 *                   -1 + 1 + 1 + 1 + 1 = 3
 *                   +1 - 1 + 1 + 1 + 1 = 3
 *                   +1 + 1 - 1 + 1 + 1 = 3
 *                   +1 + 1 + 1 - 1 + 1 = 3
 *                   +1 + 1 + 1 + 1 - 1 = 3
 *
 *
 *  Constraints:
 *          1 ≤ arr.size() ≤ 50
 *          1 ≤ arr[i] ≤ 20
 *          0 ≤ sum(arr) ≤ 1000
 *          -1000 ≤ target ≤ 1000
 */

import java.util.Arrays;
import java.util.Scanner;

public class Dynamic_Programming_Target_Sum {

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

        System.out.println("Enter target: ");
        int target = sc.nextInt();

        System.out.println("Number of different expressions: ");
        System.out.println(totalWays(arr, target));
    }

    /// Solution
/*
✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔-Memoization-✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔
TC : O(n * ((total - target) / 2))
SC : O(n * ((total - target) / 2)) + O(n) extra recursive call stack
*/
    static int memoization(int[] arr, int target) {
        // potd.code.hub
        int n = arr.length;
        int total = 0;
        for (int i : arr) total += i;

        if ((total - target) % 2 != 0) return 0;

        int newTarget = (total - target) / 2;

        int[][] dp = new int[n][newTarget + 1];

        for (int[] temp : dp) {
            Arrays.fill(temp, -1);
        }

        return f(n - 1, newTarget, arr, dp);
    }

    private static int f(int idx, int target, int[] arr, int[][] dp) {
        // base case
        if (target == 0) return 1;
        if (idx < 0) return 0;
        if (dp[idx][target] != -1) return dp[idx][target];

        // recursive case
        int pick = (target >= arr[idx]) ? f(idx - 1, target - arr[idx], arr, dp) : 0;
        int notPick = f(idx - 1, target, arr, dp);

        return dp[idx][target] = pick + notPick;
    }

/*
✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔-Tabulation-✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔
TC : O(n * ((total - target) / 2))
SC : O(n * ((total - target) / 2))
*/
    static int tabulation(int[] arr, int target) {
        int n = arr.length;
        int total = 0;
        for (int i : arr) total += i;

        if ((total - target) % 2 != 0) return 0;

        int newTarget = (total - target) / 2;

        int[][] dp = new int[n + 1][newTarget + 1];

        // simulating the base case
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        // bottom-up
        for (int idx = 1; idx <= n; idx++) {
            for (int j = 1; j <= newTarget; j++) {

                // simulation of recursive case
                int pick = (j >= arr[idx - 1]) ? dp[idx - 1][j - arr[idx - 1]] : 0;
                int notPick = dp[idx - 1][j];

                dp[idx][j] = pick + notPick;
            }
        }

        return dp[n][newTarget];
    }

/*
✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔-Space-Optimized-✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔
TC : O(n * ((total - target) / 2))
SC : O((total - target) / 2)
*/
    static int totalWays(int[] arr, int target) {
        int n = arr.length;
        int total = 0;
        for (int i : arr) total += i;

        if ((total - target) % 2 != 0) return 0;

        int newTarget = (total - target) / 2;

        int[] prv = new int[newTarget + 1];
        int[] cur = new int[newTarget + 1];

        // simulating the base case
        prv[0] = 1;
        cur[0] = 1;

        // bottom-up
        for (int idx = 1; idx <= n; idx++) {
            for (int j = 1; j <= newTarget; j++) {

                // simulation of recursive case
                int pick = (j >= arr[idx - 1]) ? prv[j - arr[idx - 1]] : 0;
                int notPick = prv[j];

                cur[j] = pick + notPick;
            }

            int[] temp = cur;
            cur = prv;
            prv = temp;
        }

        return prv[newTarget];
    }
}
