package BitMasking;/*
 *
 * https://www.geeksforgeeks.org/problems/anagram-palindrome4720/1
 *
 * # Anagram Palindrome
 *
 *   Q. Given a string s, determine whether its characters can be rearranged to form a palindrome. Return true if it is possible
 *      to rearrange the string into a palindrome; otherwise, return false.
 *
 *    Ex.
 *      Input : s = "baba"
 *      Output: true
 *      Explanation: Can be rearranged to form a palindrome "abba"
 *
 *  Constraints:
 *          1 ≤ s.length ≤ 10⁶
 *          s consists of only lowercase English letters.
 */

import java.util.Scanner;

public class BM_03_Anagram_Palindrome {

    /// main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the String: ");
        String s = sc.next();

        System.out.println("Possible to rearrange the string into a palindrome");
        System.out.println(canFormPalindrome(s));
    }

    /// Solution
    static boolean canFormPalindrome(String s) {
        // potd.code.hub
        int n = s.length();
        int mask = 0;

        for (int i = 0; i < n; i++) {
            int bit = s.charAt(i) - 'a';
            // that bit is 0 means it appears odd times and 1 means even times
            mask ^= (1 << bit);
        }

        // mask & (mask - 1) == 0 ensures that there is at most one set bit in the mask.
        return (mask & (mask - 1)) == 0;
    }
}
