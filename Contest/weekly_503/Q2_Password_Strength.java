package Contest.weekly_503;/*
 *
 * https://leetcode.com/contest/weekly-contest-503/problems/password-strength/
 *
 * # Q2. Password Strength
 *
 *   Q. You are given a string password.
 *
 *      The strength of the password is calculated based on the following rules:
 *        ◦ 1 point for each distinct lowercase letter ('a' to 'z').
 *        ◦ 2 points for each distinct uppercase letter ('A' to 'Z').
 *        ◦ 3 points for each distinct digit ('0' to '9').
 *        ◦ 5 points for each distinct special character from the set "!@#$".
 *
 *      Each character contributes at most once, even if it appears multiple times.
 *
 *      Return an integer denoting the strength of the password.
 *
 *    Ex.
 *      Input : password = "aA1!"
 *      Output: 11
 *      Explanation:
 *              The distinct characters are 'a', 'A', '1' and '!'.
 *              Thus, the strength = 1 + 2 + 3 + 5 = 11.
 *
 *  Constraints:
 *          1 <= password.length <= 10⁵
 *          password consists of lowercase and uppercase English letters, digits, and special characters from "!@#$".
 */

import java.util.HashSet;

public class Q2_Password_Strength {

    /// Solution
    public int passwordStrength(String password) {
        int n = password.length();
        int score = 0;
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            char ch = password.charAt(i);

            // continue if already exist bcz we only need to calculate for distinct one.
            if (set.contains(ch)) continue;

            // otherwise add score
            if ('a' <= ch && ch <= 'z') score += 1;
            else if ('A' <= ch && ch <= 'Z') score += 2;
            else if ('0' <= ch && ch <= '9') score += 3;
            else if (ch == '!' || ch == '@' || ch == '#' || ch == '$') score += 5;

            // finally add ch to set
            set.add(ch);
        }

        return score;
    }
}