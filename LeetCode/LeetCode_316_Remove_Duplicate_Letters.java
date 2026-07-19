package LeetCode;/*
 *
 * https://leetcode.com/problems/remove-duplicate-letters/
 *
 * # LC. 316. Remove Duplicate Letters
 *
 *   Q. Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure
 *      your result is the smallest in lexicographical order among all possible results.
 *
 *    Ex.
 *      Input : s = "cbacdcbc"
 *      Output: "acdb"
 *
 *  Constraints:
 *       1 <= s.length <= 10⁴
 *       s consists of lowercase English letters.
 */

import java.util.Scanner;

public class LeetCode_316_Remove_Duplicate_Letters {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the word: ");
        String word = sc.next();

        System.out.println("Smallest in lexicographical order after removing duplicates: ");
        System.out.println(removeDuplicateLetters(word));
    }

    /// Solution
    static String removeDuplicateLetters(String s) {
        // potd.code.hub
        int n = s.length();
        int[] lastIndex = new int[26];

        for (int i = 0; i < n; i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        StringBuilder stack = new StringBuilder();
        boolean[] seen = new boolean[26];

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            int idx = ch - 'a';

            if (!seen[idx]) {
                while (!stack.isEmpty()
                        && stack.charAt(stack.length() - 1) > ch
                        && lastIndex[stack.charAt(stack.length() - 1) - 'a'] > i) {

                    int lastIdx = stack.length() - 1;
                    char lastChar = stack.charAt(lastIdx);
                    stack.deleteCharAt(lastIdx);
                    seen[lastChar - 'a'] = false;
                }

                stack.append(ch);
                seen[idx] = true;
            }
        }

        return stack.toString();
    }
}
