package DP;/*
 *
 * https://www.geeksforgeeks.org/problems/maximize-dot-product2649/1
 *
 * # Max Dot Product with 0 Insertions
 *
 *   Q. Given two arrays a[] and b[] of positive integers of size n and m respectively, where m ≤ n.  You are allowed to
 *      insert zeros anywhere into the second array b so that its length becomes equal to n.
 *
 *        ◦ The dot product of two arrays of equal length n is defined as: a[0]*b[0] + a[1]*b[1] + ... + a[n-1]*b[n-1].
 *        ◦ Return the maximum possible dot product of the two arrays.
 *
 *    Ex.
 *      Input : a[] = [2, 3, 1, 7, 8],
 *              b[] = [3, 6, 7]
 *      Output: 107
 *      Explanation: Maximum dot product is obtained after inserting 0 at the first and third positions in array b.
 *                   Therefore, b becomes [0, 3, 0, 6, 7].
 *                   Maximum dot product = 2*0 + 3*3 + 1*0 + 7*6 + 8*7 = 107.
 *                   Therefore, answer for this test case is 107.
 *
 *  Constraints:
 *      1 ≤ m ≤ n ≤ 10³
 *      1 ≤ a[i], b[i] ≤ 10³
 */

import java.util.Arrays;
import java.util.Scanner;

public class Dynamic_Programming_Max_Dot_Product_with_0_Insertions {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a[] elements: ");
        String[] s1 = sc.nextLine().split(" ");

        System.out.println("Enter b[] elements: ");
        String[] s2 = sc.nextLine().split(" ");

        int n = s1.length;
        int m = s2.length;
        if (m > n) throw new IllegalArgumentException("size of a[] should be greater than equals to size of b[]");

        int[] a = new int[n];
        int[] b = new int[m];

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s1[i]);
        }
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(s2[i]);
        }

        System.out.println("Maximum possible dot product of the two arrays: ");
        System.out.println(maxDotProduct(a, b));
    }

    /// Solution
/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯-memoization-⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(n * m)
SC : O(n * m) + extra recursive call stack
*/
    static int memoization(int[] a, int[] b) {
        // potd.code.hub
        int n = a.length;
        int m = b.length;
        int[][] dp = new int[n][m];

        for (int[] x : dp) {
            Arrays.fill(x, -1);
        }

        return solve(n - 1, m - 1, a, b, dp);
    }

    private static int solve(int i, int j, int[] a, int[] b, int[][] dp) {
        // base case
        if (i < 0 || j < 0) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        // recursive work
        int pick = a[i] * b[j] + solve(i - 1, j - 1, a, b, dp);
        int notPick = (i > j) ? solve(i - 1, j, a, b, dp) : 0;

        // self work
        return dp[i][j] = Math.max(pick, notPick);
    }

/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯--tabulation--⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(n * m)
SC : O(n * m)
*/
    static int tabulation(int[] a, int[] b) {
        // potd.code.hub
        int n = a.length;
        int m = b.length;
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // recursive case simulation
                int pick = a[i - 1] * b[j - 1] + dp[i - 1][j - 1];
                int notPick = (i > j) ? dp[i - 1][j] : 0;
                // self work simulation
                dp[i][j] = Math.max(pick, notPick);
            }
        }

        return dp[n][m];
    }

/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯-space-optimized-⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(n * m)
SC : O(m)
*/
    static int maxDotProduct(int[] a, int[] b) {
        // potd.code.hub
        int n = a.length;
        int m = b.length;
        int[] prev = new int[m + 1];
        int[] curr = new int[m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // recursive case simulation
                int pick = a[i - 1] * b[j - 1] + prev[j - 1];
                int notPick = (i > j) ? prev[j] : 0;
                // self work simulation
                curr[j] = Math.max(pick, notPick);
            }

            int[] temp = curr;
            curr = prev;
            prev = temp;
        }

        return prev[m];
    }
}
