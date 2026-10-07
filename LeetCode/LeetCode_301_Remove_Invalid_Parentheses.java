package LeetCode;/*
 *
 * https://leetcode.com/problems/remove-invalid-parentheses/
 *
 * # LC. 301. Remove Invalid Parentheses
 *
 *   Q. Given a string s that contains parentheses and letters, remove the minimum number of invalid parentheses
 *      to make the input string valid.
 *
 *      Return a list of unique strings that are valid with the minimum number of removals. You may return the
 *      answer in any order.
 *
 *    Ex.
 *      Input : s = "()())()"
 *      Output: ["(())()", "()()()"]
 *
 *  Constraints:
 *        ◦ 1 <= s.length <= 25
 *        ◦ s consists of lowercase English letters and parentheses '(' and ')'.
 *        ◦ There will be at most 20 parentheses in s.
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class LeetCode_301_Remove_Invalid_Parentheses {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter String: ");
        String s = sc.nextLine();

        System.out.println("Valid strings with the minimum number of removals: ");
        System.out.println(removeInvalidParentheses(s));
    }

    /// Solution
    private static HashSet<String> res;

    static List<String> removeInvalidParentheses(String s1) {
        char[] s = s1.toCharArray();
        int n = s.length;

        int open = 0;
        int close = 0;

        for (char ch : s) {
            if (ch == '(') open++;
            else if (ch == ')') {
                if (open > 0) open--;
                else close++;
            }
        }

        int m = n - open - close;
        res = new HashSet<>(m);
        solve(0, 0, open, close, 0, n, s, new char[m], m);

        return new ArrayList<>(res);
    }

    private static void solve(int idx, int currIdx, int open, int close, int bal, int n, char[] s, char[] curr, int m) {
        // base case
        if (idx == n || bal < 0 || currIdx == m) {
            if (bal == 0 && currIdx == m) {
                res.add(String.valueOf(curr));
            }
            return;
        }

        // recursive case
        char ch = s[idx];

        if (ch == '(') {
            // use
            curr[currIdx] = ch;
            solve(idx + 1, currIdx + 1, open, close, bal + 1, n, s, curr, m);
            // skip
            if (open > 0) {
                solve(idx + 1, currIdx, open - 1, close, bal, n, s, curr, m);
            }
        } else if (ch == ')') {
            // use
            curr[currIdx] = ch;
            solve(idx + 1, currIdx + 1, open, close, bal - 1, n, s, curr, m);
            // skip
            if (close > 0) {
                solve(idx + 1, currIdx, open, close - 1, bal, n, s, curr, m);
            }
        } else {
            curr[currIdx] = ch;
            solve(idx + 1, currIdx + 1, open, close, bal, n, s, curr, m);
        }
    }
}
