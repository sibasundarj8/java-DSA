package DP;/*
 *
 * https://www.geeksforgeeks.org/problems/longest-common-increasing-subsequence1437/1
 *
 * # Longest Common Increasing Subsequence
 *
 *   Q. Given two arrays, a[] and b[], find the length of the longest common increasing subsequence(LCIS).
 *      Note:  LCIS refers to a subsequence that is present in both arrays and strictly increases.
 *    Ex.
 *      Input : a[] = [3, 4, 9, 1]
 *              b[] = [5, 3, 8, 9, 10, 2, 1]
 *      Output: 2
 *      Explanation: The longest increasing subsequence that is common is [3, 9] and its length is 2.
 *
 *  Constraints:
 *      1 ≤ a.size(), b.size() ≤ 10³
 *      1 ≤ a[i], b[i] ≤ 10⁴
 */

import java.util.Arrays;
import java.util.Scanner;

public class Dynamic_Programming_Longest_Common_Increasing_Subsequence {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Elements of a[]: ");
        String[] s1 = sc.nextLine().split(" ");

        System.out.println("Elements of b[]: ");
        String[] s2 = sc.nextLine().split(" ");
        
        int n = s1.length;
        int m = s2.length;
        int[] a = new int[n];
        int[] b = new int[m];
        int t = Math.max(n, m);
        
        for (int i = 0; i < t; i++) {
            if (i < n) a[i] = Integer.parseInt(s1[i]);
            if (i < m) b[i] = Integer.parseInt(s2[i]);
        }

        System.out.println("length of Longest Common Increasing Subsequence: ");
        System.out.println(LCIS(a, b));
    }

    /// Solution
/*
⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿~Brute-Force~⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿
TC : O(n * m * n)
SC : O(n * m * n)
*/
    public static int bruteForce(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        int[][][] dp = new int[n][m][n + 1];

        for(int[][] arr : dp)
            for(int[] brr : arr) Arrays.fill(brr, -1);

        return f(0, 0, -1, n, m, a, b, dp);
    }

    // helper method
    private static int f(int i, int j, int prv, int n, int m, int[] a, int[] b, int[][][] dp) {
      
        // [base case] -> if any index reaches the end of the array then it can
        // form a common increasing subsequence of length 0.
      
        if(i >= n || j >= m) return 0;
        if(dp[i][j][prv + 1] != -1) return dp[i][j][prv + 1];
      
        // [recursive case] -> if ele at both arrays matches then recursive call for pick or not pick means (i+1, j+1) and
        //                     return the maximum of pick or not pick.
        //                  -> else call for all combinations means once for (i, j+1) and once for (i+1, j) return the
        //                     maximum of grow-a or grow-b.
      
        int ans;
        if(a[i] == b[j] && (prv == -1 || a[i] > a[prv])) {
            ans = Math.max(
                    1 + f(i + 1, j + 1, i, n, m, a, b, dp),     // pick
                        f(i + 1, j + 1, prv, n, m, a, b, dp)    // not-pick
            );
        }
        else {
            ans = Math.max(
                    f(i + 1, j, prv, n, m, a, b, dp),              // grow a[]
                    f(i, j + 1, prv, n, m, a, b, dp)               // grow b[]
            );
        }

        return dp[i][j][prv + 1] = ans;
    }
/*
⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿~Optimized~⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿
TC : O(n * m)
SC : O(m)
*/
    public static int LCIS(int[] a, int[] b) {
        int m = b.length;
        int ans = 0;
        int[] dp = new int[m];

        for (int ele : a) { // check for every ele of a[]
            int curMax = 0;
          
            // check the longest subsequence ending at position j in b and also common in a.
            for (int j = 0; j < m; j++) {
              
                if (ele > b[j]) curMax = Math.max(curMax, dp[j]);
                else if (ele == b[j]) {  // for equal ele update the dp array.
                    dp[j] = curMax + 1;
                    ans = Math.max(ans, dp[j]);
                }
            }
        }

        return ans;
    }
}
