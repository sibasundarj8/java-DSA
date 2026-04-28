package SlidingWindow;/*
 *
 * https://www.geeksforgeeks.org/problems/longest-repeating-character-replacement/1
 *
 * # Longest Repeating Character Replacement
 *
 *   Q. Given a string s of length n consisting of uppercase English letters and an integer k, you are allowed to perform at
 *      most k operations.  In each operation, you can change any character of the string to any other uppercase English letter.
 *
 *      Determine the length of the longest substring that can be transformed into a string with all identical characters after
 *      performing at most k such operations.
 *
 *    Ex.
 *      Input : s = "ABBA", k = 2
 *      Output: 4
 *      Explanation: The string "ABBA" can be fully converted into the same character using at most 2 changes. By replacing
 *                   both 'A' with 'B', it becomes "BBBB". Hence, the maximum length is 4.
 *
 *  Constraints:
 *          1 ≤ n, k ≤ 10⁵
 *          s consists of only uppercase English letters.
 */

import java.util.Scanner;

public class Q17_Longest_Repeating_Character_Replacement {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter string: (only uppercase)");
        String s = sc.next();

        System.out.println("Enter K: ");
        int k = sc.nextInt();

        System.out.println("Length of the longest substring that can be converted into a string with all identical characters: ");
        System.out.println(longestSubstr(s, k));
    }

    /// Solution
    static int longestSubstr(String s, int k) {
        // potd.code.hub
        int n = s.length();
        if (k >= n) return n;

        int l = 0;
        int res = 0;
        int highest = 0;
        int[] freq = new int[26];

        for (int r = 0; r < n; r++) {
            int idx = s.charAt(r) - 'A';
            freq[idx]++;
            highest = Math.max(highest, freq[idx]);

            while (r - l + 1 - highest > k) {
                freq[s.charAt(l) - 'A']--;
                l++;
            }

            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}
