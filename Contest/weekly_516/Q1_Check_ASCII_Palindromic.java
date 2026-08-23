package Contest.weekly_516;/*
 *
 * https://leetcode.com/contest/weekly-contest-516/problems/check-ascii-palindromic/
 *
 * # Q1. Check ASCII Palindromic
 *
 *   Q. You are given a string s consisting of lowercase English letters.
 *
 *      Construct a binary string by replacing each character in s with the 8-bit binary representation of its ASCII
 *      value, including leading zeros, while preserving the original order of the characters.
 *
 *      Return true if the resulting binary string is a palindrome. Otherwise, return false.
 *
 *    Ex.
 *      Input : s = "ff"
 *      Output: true
 *      Explanation:
 *              The ASCII value of f is 102, whose 8-bit binary representation is 01100110.
 *              Thus, the binary string is 0110011001100110.
 *              Since this binary string is a palindrome, the output is true.
 *
 *  Constraints:
 *        ◦ 1 <= s.length <= 100
 *        ◦ s consists of lowercase English letters.
 */

public class Q1_Check_ASCII_Palindromic {

    /// Solution
    public boolean isPalindromic(String s) {
        int n = s.length();
        int i = 0, j = n - 1;

        while (i <= j) {
            int a = s.charAt(i++);
            int b = s.charAt(j--);

            for (int y = 0; y <= 7; y++) {
                int x = 7 - y;
                if ((a >> x & 1) != (b >> y & 1)) {
                    return false;
                }
            }
        }

        return true;
    }
}
