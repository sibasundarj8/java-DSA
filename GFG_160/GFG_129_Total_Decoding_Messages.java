package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/total-decoding-messages1235/1
 *   
 * # Total Decoding Messages
 *
 *   Q. A message containing letters A-Z is being encoded to numbers using the following mapping:
 *
 *      'A' -> 1
 *      'B' -> 2
 *      ...
 *      'Z' -> 26
 *
 *      You are given a string digits. You have to determine the total number of ways that message can be
 *      decoded.
 *   Ex.
 *      Input: digits = "123"
 *      Output: 3
 *      Explanation: "123" can be decoded as "ABC" (1, 2, 3),
 *                                            "LC" (12, 3),
 *                                            "AW" (1, 23).
 */
import java.util.Arrays;
import java.util.Scanner;

public class GFG_129_Total_Decoding_Messages {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter encoded Number: ");
        System.out.println(countWays(sc.next()));
    }

    /// Solution
    static int countWays(String digits) {
        // potd.code.hub
        int n = digits.length();
        char[] digit = digits.toCharArray();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return solve(0, digit, n, dp);
    }

    private static int solve(int idx, char[] dig, int n, int[] dp) {
        // base Case
        if (idx >= n) return 1;
        if (dig[idx] == '0') return 0;
        if (dp[idx] != -1) return dp[idx];

        int p2 = 0;
        int p1 = solve(idx + 1, dig, n, dp);

        if (idx != n - 1) {
            int num = (dig[idx] - '0') * 10 + dig[idx + 1] - '0';
            if (num < 27) p2 = solve(idx + 2, dig, n, dp);
        }

        return dp[idx] = p1 + p2;
    }
}
