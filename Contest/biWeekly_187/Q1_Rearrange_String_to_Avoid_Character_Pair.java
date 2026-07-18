package Contest.biWeekly_187;/*
 *
 * https://leetcode.com/contest/biweekly-contest-187/problems/rearrange-string-to-avoid-character-pair/
 *
 * # Q1. Rearrange String to Avoid Character Pair
 *
 *   Q. You are given a string s and two distinct lowercase English letters x and y.
 *
 *      Rearrange the characters of s to construct a new string t such that:
 *        ◦ t is a permutation of s.
 *        ◦ Every occurrence of y appears before every occurrence of x in t.
 *        ◦ Return any valid string t.
 *
 *      A permutation is a rearrangement of all the characters of a string.
 *
 *    Ex.
 *      Input : s = "aabc", x = "a", y = "c"
 *      Output: "cbaa"
 *      Explanation:
 *              The string "cbaa" is a permutation of "aabc", and every occurrence of 'c' appears before every
 *              occurrence of 'a'.
 *
 *  Constraints:
 *      1 <= s.length <= 100
 *      s consists of lowercase English letters.
 *      x and y are lowercase English letters.
 *      x != y
 */

public class Q1_Rearrange_String_to_Avoid_Character_Pair {

    /// Solution
    public String rearrangeString(String s, char x, char y) {
        int countX = 0;
        int countY = 0;
        StringBuilder others = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == x) countX++;
            else if (c == y) countY++;
            else others.append(c);
        }

        StringBuilder result = new StringBuilder();

        result.repeat(y, countY);
        result.append(others);
        result.repeat(x, countX);

        return result.toString();
    }
}
