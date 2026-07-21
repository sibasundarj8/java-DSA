package LeetCode;/*
 *
 * https://leetcode.com/problems/maximize-active-section-with-trade-i/
 *
 * # LC. 3499. Maximize Active Section with Trade I
 *
 *   Q. You are given a binary string s of length n, where:
 *        ◦ '1' represents an active section.
 *        ◦ '0' represents an inactive section.
 *
 *      You can perform at most one trade to maximize the number of active sections in s. In a trade, you:
 *        ◦ Convert a contiguous block of '1's that is surrounded by '0's to all '0's.
 *        ◦ Afterward, convert a contiguous block of '0's that is surrounded by '1's to all '1's.
 *
 *      Return the maximum number of active sections in s after making the optimal trade.
 *
 *      Note: Treat s as if it is augmented with a '1' at both ends, forming t = '1' + s + '1'. The augmented '1's do
 *            not contribute to the final count.
 *
 *    Ex.
 *      Input : s = "0100"
 *      Output: 4
 *      Explanation:
 *              String "0100" → Augmented to "101001".
 *              Choose "0100", convert "101001" → "100001" → "111111".
 *              The final string without augmentation is "1111". The maximum number of active sections is 4.
 *
 *  Constraints:
 *       ◦ 1 <= n == s.length <= 10⁵
 *       ◦ s[i] is either '0' or '1'
 */

import java.util.Scanner;

public class LeetCode_3499_Maximize_Active_Section_with_Trade_I {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("""
                Enter binary string, where:
                   ◦ '1' represents an active section.
                   ◦ '0' represents an inactive section.
                """);
        String s = sc.next();

        System.out.println("Maximum number of active sections in s after making the optimal trade: ");
        System.out.println(maxActiveSectionsAfterTrade(s));
    }

    /// Solution
    static int maxActiveSectionsAfterTrade(String s) {
        // potd.code.hub
        int prev = 0;
        int curr = 0;
        int ones = 0;
        int max = 0;
        int n = s.length();
        int i = 0;

        while (i < n) {
            if (s.charAt(i) == '1') {
                if (prev > 0 && curr > 0) {
                    max = Math.max(max, prev + curr);
                }
                if (curr != 0) {
                    prev = curr;
                    curr = 0;
                }
                ones++;
            } else curr++;
            i++;
        }

        if (prev > 0 && curr > 0) {
            max = Math.max(max, prev + curr);
        }

        return ones + max;
    }
}
