package DP;/*
 *
 * https://www.geeksforgeeks.org/problems/cutting-binary-string1342/1
 *
 * # Cutting Binary String
 *
 *   Q. You are given a binary string s consisting only of characters '0' and '1'. Your task is to split this
 *      string into the minimum number of non-empty substrings such that:
 *
 *      Each substring represents a power of 5 in decimal (e.g., 1, 5, 25, 125, ...).
 *      No substring should have leading zeros.
 *      Return the minimum number of such pieces the string can be divided into.
 *      Note: If it is not possible to split the string in this way, return -1.
 *   Ex.
 *      Input : s = "101101101"
 *      Output: 3
 *      Explanation: The string can be split into three substrings: "101", "101", and "101", each of which is
 *                   a power of 5 with no leading zeros.
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Dynamic_Programming_Cutting_Binary_String {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the binary String: ");
        String s = sc.next();

        System.out.println("Number of sub-string formed by cutting the string: ");
        System.out.println(cuts(s));
    }

    /// Solution
    private final static HashSet<Integer> set;

    static {
        set = new HashSet<>();
        int i = 1;
        while (i < (1 << 31 - 1)) {
            set.add(i);
            i *= 5;
        }
    }

    static int cuts(String s) {
        // potd.code.hub
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        int ans = solve(n - 1, s, dp);

        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }

    private static int solve(int start, String s, int[] dp) {
        // base case
        if (start < 0) return 0;
        if (dp[start] != -1) return dp[start];

        // recursive work
        int ans = Integer.MAX_VALUE;
        int num = 0;

        for (int i = start; i >= 0; i--) {
            int cur = s.charAt(i) - '0';
            num |= (cur << (start - i));
            if (cur != 0 && set.contains(num)) {
                int pick = solve(i - 1, s, dp);
                if (pick != Integer.MAX_VALUE) ans = Math.min(ans, 1 + pick);
            }
        }

        return dp[start] = ans;
    }
}
