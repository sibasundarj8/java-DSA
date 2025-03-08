package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/longest-palindrome-in-a-string3411/1
 *
 * # Longest Palindrome in a String
 *
 *   Q. Given a string s, your task is to find the longest palindromic substring within s.
 *
 *      A substring is a contiguous sequence of characters within a string, defined as s[i...j]
 *      where 0 ≤ i ≤ j < len(s).
 *
 *      A palindrome is a string that reads the same forward and backward. More formally, s is a
 *      palindrome if reverse(s) == s.
 *
 *      Note: If there are multiple palindromic substrings with the same length, return the first
 *            occurrence of the longest palindromic substring from left to right.
 *    Ex.
 *      Input : s = "forgeeksskeegfor"
 *      Output: "geeksskeeg"
 *      Explanation: There are several possible palindromic substrings like.
 *                   "Kssk", "ss", "eeksskee" etc. But the substring "geeksskeeg" is the longest
 *                    among all.
 */
import java.util.Scanner;

public class GFG_114_Longest_Palindrome_in_a_String {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("String: ");
        String s = sc.next();

        System.out.println(longestPalindrome(s));
    }

    /// Solution
    static String longestPalindrome(String s) {
        // potd.code.hub
        int n = s.length();
        int maxLen = 1, start = 1;

        // both for odd and even
        for (int i = 1;i < n;i++){
            int len = 1 + palindromeLength(s, i-1, i+1); // odd
            int len2 = palindromeLength(s, i-1, i);      // even
            if (len > maxLen) {
                maxLen = len;
                start = i - len / 2;
            }
            if (len2 > maxLen) {
                maxLen = len2;
                start = i - len2 / 2;
            }
        }

        return s.substring(start, start+maxLen);
    }
    private static int palindromeLength(String s, int i, int j){
        int n = s.length(), len = 0;
        while (i >= 0 && j < n){
            if (s.charAt(i) == s.charAt(j)){
                len += 2;
                i--;
                j++;
            }
            else break;
        }
        return len;
    }
}
