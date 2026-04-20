package DP;/*
 *
 * https://www.geeksforgeeks.org/problems/dearrangement-of-balls0918/1
 *
 * # Count Derangements
 *
 *   Q. Given a number n, find the total number of Derangements of elements from 1 to n. A Derangement is a permutation of
 *      n elements, such that no element appears in its original position, i.e., 1 should not be the first element, 2 should
 *      not be second, etc. For example, [5, 3, 2, 1, 4] is a Derangement of first 5 elements.
 *
 *      Note: The answer will always fit into a 32-bit integer.
 *
 *    Ex.
 *      Input : n = 3
 *      Output: 2
 *      Explanation: For the set [1, 2, 3], there are only two possible derangements: [2, 3, 1] and [3, 1, 2].
 *
 *  Constraints:
 *          1 ≤ n ≤ 12
 */

import java.util.Arrays;
import java.util.Scanner;

public class Dynamic_Programming_Count_Derangements {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n : ");
        int n = sc.nextInt();

        System.out.println("Number of Derangements: ");
        System.out.println(derangeCount(n));
    }

    /// Solution
/*
◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦-Brute-Force-◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦
TC : O(2ⁿ)
SC : O(1) + extra n space for recursive call stack
*/
    static int bruteForce(int n) {
        // potd.code.hub
        if (n == 1) return 0;
        if (n == 2) return 1;

        return (n - 1) * (bruteForce(n - 2) + bruteForce(n - 1));
    }

/*
◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦-Memoization-◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦
TC : O(n)
SC : O(n) + extra n space for recursive call stack
*/
    static int memoization(int n) {
        // potd.code.hub
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return f(n, dp);
    }

    private static int f(int n, int[] dp) {
        if (n == 1) return 0;
        if (n == 2) return 1;
        if (dp[n] != -1) return dp[n];

        return dp[n] = (n - 1) * (f(n - 2, dp) + f(n - 1, dp));
    }

/*
◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦-Tabulation-◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦
TC : O(n)
SC : O(n)
*/
    static int tabulation(int n) {
        // potd.code.hub
        if (n == 1) return 0;

        int[] dp = new int[n + 1];
        dp[1] = 0;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = (i - 1) * (dp[i - 2] + dp[i - 1]);
        }

        return dp[n];
    }

/*
◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦-Space-Optimization-◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦
TC : O(n)
SC : O(1)
*/
    static int derangeCount(int n) {
        // potd.code.hub
        if (n == 1) return 0;

        int curr = 1;
        int prev1 = 1;
        int prev2 = 0;

        for (int i = 3; i <= n; i++) {
            curr = (i - 1) * (prev2 + prev1);
            prev2 = prev1;
            prev1 = curr;
        }

        return curr;
    }
}
