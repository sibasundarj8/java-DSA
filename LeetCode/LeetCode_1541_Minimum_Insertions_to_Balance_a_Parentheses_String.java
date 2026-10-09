package LeetCode;/*
 *
 * https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/
 *
 * # LC. 1541. Minimum Insertions to Balance a Parentheses String
 *
 *   Q. Given a parentheses string s containing only the characters '(' and ')'.
 *
 *      A parentheses string is balanced if:
 *        ◦ Any left parenthesis '(' must have a corresponding two consecutive right parenthesis '))'.
 *        ◦ Left parenthesis '(' must go before the corresponding two consecutive right parenthesis '))'.
 *
 *      In other words, we treat '(' as an opening parenthesis and '))' as a closing parenthesis.
 *
 *      For example, "())", "())(())))" and "(())())))" are balanced, ")()", "()))" and "(()))" are not balanced.
 *
 *      You can insert the characters '(' and ')' at any position of the string to balance it if needed.
 *
 *      Return the minimum number of insertions needed to make s balanced.
 *
 *    Ex.
 *      Input : s = "(()))"
 *      Output: 1
 *      Explanation: The second '(' has two matching '))', but the first '(' has only ')' matching. We need to add
 *                   one more ')' at the end of the string to be "(())))" which is balanced.
 *
 *  Constraints:
 *        ◦ 1 <= s.length <= 10⁵
 *        ◦ s consists of '(' and ')' only.
 */

import java.util.Scanner;

public class LeetCode_1541_Minimum_Insertions_to_Balance_a_Parentheses_String {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the parenthesis: ");
        String s = sc.next();

        System.out.println("Minimum number of insertions needed to make s balanced: ");
        System.out.println(minInsertions(s));
    }

    /// Solution
    static int minInsertions(String s1) {
        // potd.code.hub
        char[] s = s1.toCharArray();
        int n = s.length;
        int open = 0;
        int res = 0;

        for (int i = 0; i < n; i++) {
            char ch = s[i];

            if (ch == '(') open++;
            else {
                if (open == 0) {
                    open++;
                    res++;
                }

                if (i == n - 1 || s[i + 1] != ')') {
                    res++;
                } else i++;

                open--;
            }
        }

        return res + (open << 1);
    }
}
