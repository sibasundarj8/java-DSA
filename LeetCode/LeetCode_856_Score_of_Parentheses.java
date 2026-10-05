package LeetCode;/*
 *
 * https://leetcode.com/problems/score-of-parentheses/
 *
 * # LC. 856. Score of Parentheses
 *
 *   Q. Given a balanced parentheses string s, return the score of the string.
 *
 *      The score of a balanced parentheses string is based on the following rule:
 *        ◦ "()" has score 1.
 *        ◦ AB has score A + B, where A and B are balanced parentheses strings.
 *        ◦ (A) has score 2 * A, where A is a balanced parentheses string.
 *
 *    Ex-1.
 *      Input : s = "()"
 *      Output: 1
 *
 *    Ex-2.
 *      Input : s = "(())"
 *      Output: 2
 *
 *    Ex-3.
 *      Input : s = "()()"
 *      Output: 2
 *
 *    Ex-4.
 *      Input : "(())()(()())((()))"
 *      Output: 11
 *
 *  Constraints:
 *        ◦ 2 <= s.length <= 50
 *        ◦ s consists of only '(' and ')'.
 *        ◦ s is a balanced parentheses string.
 */

import java.util.Scanner;

public class LeetCode_856_Score_of_Parentheses {

    private static boolean isValid(String s) {
        int bal = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') bal++;
            else bal--;

            if (bal < 0) {
                return false;
            }
        }

        return bal == 0;
    }

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a valid parentheses string: ");
        String str = sc.next();

        if (!isValid(str)) {
            throw new IllegalArgumentException("Not a valid parentheses");
        }

        System.out.println("Score of a balanced parentheses string: ");
        System.out.println(scoreOfParentheses(str));
    }

    /// Solution
/*
--------------------------------------------------------Recursion--------------------------------------------------------
TC : O(n)
SC : O(n)
*/
    static int approach_1(String s1) {
        // potd.code.hub
        char[] s = s1.toCharArray();
        int n = s.length;
        int total = 0;

        int[] stack = new int[n];
        int top = -1;

        int[] pair = new int[n];

        for (int i = 0; i < n; i++) {
            char ch = s[i];

            if (ch == '(') stack[++top] = i;
            else {
                int pop = stack[top--];
                pair[pop] = i;
                pair[i] = pop;
            }
        }

        for (int i = 0; i < n; i++) {
            total += solve(i, pair[i], pair);
            i = pair[i];
        }

        return total;
    }

    private static int solve(int x, int y, int[] pair) {
        // base case
        if (x + 1 == y) return 1;

        // recursive work
        int total = 0;

        for (int i = x + 1; i < y; i++) {
            total += solve(i, pair[i], pair);
            i = pair[i];
        }

        return total << 1;
    }

/*
-------------------------------------------------------Mathematics-------------------------------------------------------
TC : O(n)
SC : O(1)
*/
    static int scoreOfParentheses(String s) {
        int n = s.length();
        int depth = -1;
        int score = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                depth++;
            } else {
                if (s.charAt(i - 1) == '(') {
                    score += (1 << depth);
                }
                depth--;
            }
        }

        return score;
    }
}
