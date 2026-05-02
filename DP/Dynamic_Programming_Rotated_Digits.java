package DP;/*
 *
 * https://leetcode.com/problems/rotated-digits/
 *
 * # 788. Rotated Digits
 *
 *   Q. An integer x is a good if after rotating each digit individually by 180 degrees, we get a valid number that is
 *      different from x. Each digit must be rotated - we cannot choose to leave it alone.
 *
 *      A number is valid if each digit remains a digit after rotation. For example:
 *        ◦ 0, 1, and 8 rotate to themselves,
 *        ◦ 2 and 5 rotate to each other (in this case they are rotated in a different direction, in other words, 2 or 5
 *          gets mirrored),
 *        ◦ 6 and 9 rotate to each other, and
 *        ◦ the rest of the numbers do not rotate to any other number and become invalid.
 *
 *      Given an integer n, return the number of good integers in the range [1, n].
 *
 *    Ex.
 *      Input : n = 10
 *      Output: 4
 *      Explanation: There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
 *      Note that 1 and 10 are not good numbers, since they remain unchanged after rotating.
 *
 *  Constraints:
 *          1 <= n <= 10⁴
 */

import java.util.Arrays;
import java.util.Scanner;

public class Dynamic_Programming_Rotated_Digits {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 8250; i < 9000; i++) {
            System.out.println((char) i);
        }

        System.out.print("N : ");
        int n = sc.nextInt();

        System.out.print("Number of good numbers: ");
        System.out.println(rotatedDigits(n));
    }

    /// Solution
    private static final int[] map = {0, 1, 5, -1, -1, 2, 9, -1, 8, 6};

/*
☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒-Brute-Force-☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒
TC : O(n log₁₀ n)
sC : O(1)
*/

    static int bruteForce(int n) {
        // potd.code.hub
        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (isGoodNumberBf(i)) {
                count++;
            }
        }

        return count;
    }

    private static boolean isGoodNumberBf(int n) {
        boolean flag = false;

        while (n > 0) {
            int dig = n % 10;
            n = n / 10;

            if (map[dig] == -1) return false;
            if (map[dig] != dig) flag = true;
        }

        return flag;
    }

/*
☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎-memoization-☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎
TC : O(n)
SC : O(n) + recursive depth
*/
    static int memoization(int n) {
        // potd.code.hub
        int count = 0;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        for (int i = 1; i <= n; i++) {
            if (isGoodNumberMemo(i, dp) == 1) {
                count++;
            }
        }

        return count;
    }

    private static int isGoodNumberMemo(int n, int[] dp) {
        // base case
        if (n <= 0) return 0;
        if (dp[n] != -1) return dp[n];

        // recursive work
        int check = isGoodNumberMemo(n / 10, dp);

        // self work
        int dig = n % 10;
        int currStatus;

        if (map[dig] == -1) currStatus = 2;
        else if (map[dig] == dig) currStatus = 0;
        else currStatus = 1;

        return dp[n] = Math.max(check, currStatus);
    }

/*
☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎-Tabulation-☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎☑︎
TC : O(n)
SC : O(n)
*/
    static int rotatedDigits(int n) {
        // potd.code.hub
        int count = 0;
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int check = dp[i / 10];

            // self work
            int dig = i % 10;
            int currStatus;

            if (map[dig] == -1) currStatus = 2;
            else if (map[dig] == dig) currStatus = 0;
            else currStatus = 1;

            dp[i] = Math.max(check, currStatus);
            if (dp[i] == 1) count++;
        }

        return count;
    }
}
