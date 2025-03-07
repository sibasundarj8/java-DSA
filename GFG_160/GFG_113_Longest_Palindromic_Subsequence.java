package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/longest-palindromic-subsequence-1612327878/1
 *
 * # Longest Palindromic Subsequence
 *
 *   Q. Given a string s, return the length of the longest palindromic subsequence.
 *
 *      A subsequence is a sequence that can be derived from the given sequence by deleting some or
 *      no elements without changing the order of the remaining elements.
 *
 *      A palindromic sequence is a sequence that reads the same forward and backward.
 *   Ex. 
 *      Input : s = "bbabcbcab"
 *      Output: 7
 *      Explanation: Subsequence "babcbab" is the longest subsequence which is also a palindrome.
 */
import java.util.Scanner;

public class GFG_113_Longest_Palindromic_Subsequence {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Word: ");
        String s = sc.next();

        System.out.println(longestPalinSubseq(s));
    }

    /// Solution
    static int longestPalinSubseq(String s1) {
        // potd.code.hub
        int n = s1.length();
        String s2 = new StringBuilder(s1).reverse().toString();

        int[]curr = new int[n+1];
        int[]prev = new int[n+1];

        for (int i = 1;i <= n;i++){
            for (int j = 1;j <= n;j++){
                if (s1.charAt(i-1) == s2.charAt(j-1))
                    curr[j] = 1 + prev[j-1];
                else curr[j] = Math.max(prev[j], curr[j-1]);
            }
            prev = curr.clone();
        }

        return prev[n];
    }
}
