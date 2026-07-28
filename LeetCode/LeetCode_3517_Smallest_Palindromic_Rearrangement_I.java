package LeetCode;/*
 *
 * https://leetcode.com/problems/smallest-palindromic-rearrangement-i/
 *
 * # LC. 3517. Smallest Palindromic Rearrangement I
 *
 *   Q. You are given a palindromic string s. Return the lexicographically smallest palindromic permutation of s.
 *
 *    Ex.
 *      Input : s = "babab"
 *      Output: "abbba"
 *      Explanation:
 *              Rearranging "babab" → "abbba" gives the smallest lexicographic palindrome.
 *
 *  Constraints:
 *       ◦ 1 <= s.length <= 10⁵
 *       ◦ s consists of lowercase English letters.
 *       ◦ s is guaranteed to be palindromic.
 */

import java.util.Scanner;

public class LeetCode_3517_Smallest_Palindromic_Rearrangement_I {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the palindromic string: ");
        String s = sc.next();

        if (!isPalindrome(s)) {
            throw new IllegalArgumentException("Not a palindrome string");
        }

        System.out.println("Smallest palindromic permutation of s: ");
        System.out.println(smallestPalindrome(s));
    }

    private static boolean isPalindrome(String s) {
        int n = s.length();
        int m = n >> 1;

        for (int i = 0; i < m; i++) {
            if (s.charAt(i) != s.charAt(n - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    /// Solution
    static String smallestPalindrome(String s) {
        int n = s.length();
        String middle = ((n & 1) == 1) ? String.valueOf(s.charAt(n >> 1)) : "";
        int[] freq = new int[26];

        n >>= 1;

        for (int i = 0; i < n; i++) {
            freq[s.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            sb.repeat((char) (i + 'a'), freq[i]);
        }

        return sb + middle + sb.reverse();
    }
}
