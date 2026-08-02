package GFG;/*
 *
 * https://www.geeksforgeeks.org/problems/count-in-array2138/1
 *
 * # Sequences where Adjacent Divide
 *
 *   Q. Given two positive integer n and m. Find the number of arrays of size n that can be formed such that:
 *        ◦ Each element is in the range [1, m].
 *        ◦ All adjacent are such that one of them divide the another
 *          i.e. element Ai divides Ai + 1 or Ai+1 divides Ai.
 *
 *    Ex.
 *      Input : n = 3, m = 3
 *      Output: 17
 *      Explanation: The possible arrays are [1, 1, 1], [1, 1, 2], [1, 1, 3],
 *                                           [1, 2, 1], [1, 2, 2], [1, 3, 1],
 *                                           [1, 3, 3], [2, 1, 1], [2, 1, 2],
 *                                           [2, 1, 3], [2, 2, 1], [2, 2, 2],
 *                                           [3, 1, 1], [3, 1, 2], [3, 1, 3],
 *                                           [3, 3, 1], [3, 3, 3].
 *
 *  Constraints:
 *       1 ≤ n ≤ 11
 *       1 ≤ m ≤ 11
 */ 

import java.util.Arrays;
import java.util.Scanner;

public class POTD_Sequences_where_Adjacent_Divide {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("n: ");
        int n = sc.nextInt();

        System.out.print("m: ");
        int m = sc.nextInt();

        System.out.println("Number of arrays of size n where each adjacent element are divisible: ");
        System.out.println(count(n, m));
    }

    /// Solution
    static int count(int n, int m) {
        // potd.code.hub
        int[][] dp = new int[12][12];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return solve(1, n, m, dp);
    }

    private static int solve(int prv, int n, int m, int[][] dp) {
        // base case
        if (n == 0) return 1;
        if (dp[prv][n] != -1) return dp[prv][n];

        // recursive work
        int count = 0;

        for (int i = 1; i <= m; i++) {
            if (prv % i == 0 || i % prv == 0) {
                count += solve(i, n - 1, m, dp);
            }
        }

        return dp[prv][n] = count;
    }
}
