package LeetCode;/*
 *
 * https://leetcode.com/problems/process-string-with-special-operations-i/
 *
 * # 3612. Process String with Special Operations I
 *
 *   Q. You are given a string s consisting of lowercase English letters and the special characters: *, #, and %.
 *
 *      Build a new string result by processing s according to the following rules from left to right:
 *        ◦ If the letter is a lowercase English letter append it to result.
 *        ◦ A '*' removes the last character from result, if it exists.
 *        ◦ A '#' duplicates the current result and appends it to itself.
 *        ◦ A '%' reverses the current result.
 *
 *      Return the final string result after processing all characters in s.
 *
 *    Ex.
 *      Input : s = "a#b%*"
 *      Output: "ba"
 *      Explanation: +---+------+---------------------------+----------------+
 *                   | i | s[i] | Operation                 | Current result |
 *                   +---+------+---------------------------+----------------+
 *                   | 0 | 'a'  | Append 'a'                | "a"            |
 *                   | 1 | '#'  | Duplicate result          | "aa"           |
 *                   | 2 | 'b'  | Append 'b'                | "aab"          |
 *                   | 3 | '%'  | Reverse result            | "baa"          |
 *                   | 4 | '*'  | Remove the last character | "ba"           |
 *                   +---+------+---------------------------+----------------+
 *              Thus, the final result is "ba".
 *
 *  Constraints:
 *      1 <= s.length <= 20
 *      s consists of only lowercase English letters and special characters *, #, and %.
 */

import java.util.Scanner;

public class LeetCode_3612_Process_String_with_Special_Operations_I {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the string: ");
        String s = sc.next();

        System.out.println("After processing: ");
        System.out.println(processStr(s));
    }

    /// Solution
    static String processStr(String s) {
        // potd.code.hub
        int n = s.length();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch == '*') {
                int len = sb.length();
                if (len > 0) sb.deleteCharAt(len - 1);
            }
            else if (ch == '#') sb.append(sb);
            else if (ch == '%') sb.reverse();
            else sb.append(ch);
        }

        return sb.toString();
    }
}
