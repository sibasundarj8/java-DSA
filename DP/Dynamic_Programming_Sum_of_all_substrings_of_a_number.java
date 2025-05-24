package DP;/*
 *
 * https://www.geeksforgeeks.org/problems/sum-of-all-substrings-of-a-number-1587115621/1
 *
 * # Sum of all substrings of a number
 *
 *   Q. Given an integer s represented as a string, the task is to get the sum of all possible sub-strings of
 *      this string.
 *
 *      Note: The number may have leading zeros.
 *      It is guaranteed that the total sum will fit within a 32-bit signed integer.
 *    Ex.
 *      Input : s = "6759"
 *      Output: 8421
 *      Explanation:
 *      Sum = 6 + 7 + 5 + 9 + 67 + 75 + 59 + 675 + 759 + 6759 = 8421
 */

import java.util.Scanner;

public class Dynamic_Programming_Sum_of_all_substrings_of_a_number {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Number: ");
        String s = sc.next();

        System.out.println("Sum of substrings: " + sumSubstrings(s));
    }

    /// Solution
    static int sumSubstrings(String s) {
        // potd.code.hub
        int n = s.length();

        return solve(n, s);
    }

/**************************************************<---Brute-Force--->**************************************************/
// TC: O(n²)
// SC: O(1)
    private static int bf(String s) {
        int n = s.length();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int num = 0;
            for (int j = i; j < n; j++) {
                int digit = s.charAt(j) - '0';
                num *= 10;
                num += digit;
                ans += num;
            }
        }

        return ans;
    }

/***************************************************<---Recursion--->***************************************************/
// TC: O(n)
// SC: O(n + n)
    private static int solve(String s, int n) {
        int[] dp = new int[n];
        int ans = 0;

        f(s, n - 1, dp);

        for (int i : dp)
            ans += i;

        return ans;
    }

    private static int f(String s, int idx, int[] dp) {
        // base case
        if (idx == 0) {
            return dp[0] = s.charAt(idx) - '0';
        }
        // recursive case
        int digit = s.charAt(idx) - '0';
        int sum = digit * (idx+1) + 10 * f(s, idx-1, dp);

        return dp[idx] = sum;
    }

/***************************************************<---Tabulation--->**************************************************/
// TC: O(n)
// SC: O(n)
    private static int solve(String s) {
        int n = s.length();
        int[] dp = new int[n];

        dp[0] = s.charAt(0) - '0';
        int ans = dp[0];

        for (int i = 1; i < n; i++) {
            int digit = s.charAt(i) - '0';
            dp[i] = dp[i-1] * 10 + digit * (i+1);
            ans += dp[i];
        }

        return ans;
    }

/***********************************************<---Space-Optimization--->**********************************************/
// TC: O(n)
// SC: O(1)
    private static int solve(int n, String s) {
        int curr, prev = 0;
        int ans = prev;

        for (int i = 0; i < n; i++) {
            int digit = s.charAt(i) - '0';
            curr = prev * 10 + digit * (i + 1);
            prev = curr;
            ans += curr;
        }

        return ans;
    }
}
