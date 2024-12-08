package GFG_160.Bonus_Problems;/*
 * https://www.geeksforgeeks.org/problems/longest-prefix-suffix2527/1
 *
 * # Longest Prefix Suffix
 *
 *   Q. Given a string of characters s, find the length of the longest prefix which is also a suffix.
 *      Note: Prefix and suffix can be overlapping, but they should not be equal to the entire string.
 *    Ex.
 *      Input : s = "aabcdaabc"
 *      Output: 4
 *      Explanation: The string "aabc" is the longest prefix and suffix.
 */
import java.util.Scanner;

public class String_05_Longest_Prefix_Suffix {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a word: ");
        String s = sc.next();

        System.out.println(longestPrefixSuffix(s));
    }

    /// Solution
    static int longestPrefixSuffix(String s) {
        int n = s.length();
        int[]ans = new int[n];

        int i = 0;
        int j = 1;
        while (j < n){
            if (s.charAt(i) == s.charAt(j)) ans[j++] = ++i;
            else if (i == 0) ans[j++] = 0;
            else i = ans[i-1];
        }

        return ans[n-1];
    }
}
