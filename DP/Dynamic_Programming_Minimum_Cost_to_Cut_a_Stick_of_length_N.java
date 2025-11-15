package DP;/*
 *
 * https://www.geeksforgeeks.org/problems/minimum-cost-to-cut-a-stick-of-length-n/1
 *
 * # Minimum Cost to Cut a Stick of length N
 *
 *   Q. You are given a wooden stick of length n, labeled from 0 to n. You are also given an integer array cuts[], where
 *      each element cuts[i] represents a position along the stick at which you can make a cut.
 *
 *      Each cut costs an amount equal to the length of the stick being cut at that moment. After performing a cut, the
 *      stick is divided into two smaller sticks.
 *
 *      You can perform the cuts in any order. Your task is to determine the minimum total cost required to perform all
 *      the cuts.
 *   Ex.
 *      Input : n = 10, cuts[] = [2, 4, 7]
 *      Output: 20
 *      Explanation: If we cut the stick in the order [4, 2, 7], the cost will be 10 + 4 + 6 = 20, which is the minimum
 *                   total cost.
 *
 *  Constraints:
 *          2 ≤ n ≤ 10⁶
 *          1 ≤ cuts[i] ≤ n - 1
 *          1 ≤ cuts.size() ≤ 100
 */

import java.util.Arrays;
import java.util.Scanner;

public class Dynamic_Programming_Minimum_Cost_to_Cut_a_Stick_of_length_N {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Length of Stick");
        int n = sc.nextInt();

        System.out.println("Enter cuts positions: ");
        String[] s = sc.nextLine().split(" ");

        int m = s.length;
        int[] cuts = new int[m];
        for (int i = 0; i < m; i++) cuts[i] = Integer.parseInt(s[i]);

        System.out.println("Minimum total cost required to perform all the cuts: ");
        System.out.println(minCutCost(n, cuts));
    }

    /// Solution
/*
⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁~Memoization~⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁⌁
TC : O(m³)
SC : O(m²)
*/
    static int minCutCost(int n, int[] cuts) {
        // potd.code.hub
        int m = cuts.length;
        int[] arr = new int[m + 2];
        int[][] dp = new int[m + 2][m + 2];

        Arrays.sort(cuts);
        arr[m + 1] = n;
        System.arraycopy(cuts, 0, arr, 1, m);
        for(int[] i : dp) Arrays.fill(i, -1);

        return f(0, m + 1, arr, dp);
    }

    // helper method
    private static int f(int i, int j, int[] arr, int[][] dp) {
        // base case -> no need to add (i > j) case here because I handled that before the recursive call, in for loop.
        if(dp[i][j] != -1) return dp[i][j];

        // recursive case
        int ans = Integer.MAX_VALUE;

        for(int x = i + 1; x < j; x++)  // getting the minimum after trying all possible cuts.
            ans = Math.min(ans, f(i, x, arr, dp) + f(x, j, arr, dp));

        // self work
        return dp[i][j] = (ans == Integer.MAX_VALUE) ? 0 : ans + (arr[j] - arr[i]);
    }
}
