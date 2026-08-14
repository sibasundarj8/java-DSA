package LeetCode;/*
 *
 * https://leetcode.com/problems/maximum-length-substring-with-two-occurrences/
 *
 * # LC. 3090. Maximum Length Substring With Two Occurrences
 *
 *   Q. Given a string s, return the maximum length of a substring such that it contains at most two occurrences of each
 *      character.
 *
 *    Ex.
 *      Input : s = "bcbbbcba"
 *      Output: 4
 *      Explanation:
 *              The following substring has a length of 4 and contains at most two occurrences of each
 *              character: "bcbbbcba".
 *
 *  Constraints:
 *        ◦ 2 <= s.length <= 100
 *        ◦ s consists only of lowercase English letters.
 */

import java.util.Scanner;

public class LeetCode_3090_Maximum_Length_Substring_With_Two_Occurrences {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("s: ");
        String s = sc.next();

        System.out.println("maximum length of a substring: ");
        System.out.println(maximumLengthSubstring(s));
    }

    /// Solution
    static int maximumLengthSubstring(String s) {
        // pots.code.hub
        int n = s.length();
        int[] freq = new int[26];
        int i = 0;
        int maxLen = 0;

        for (int j = 0; j < n; j++) {
            int idx = s.charAt(j) - 'a';
            freq[idx]++;

            if (freq[idx] > 2) {
                maxLen = Math.max(maxLen, j - i);

                while (freq[idx] > 2) {
                    freq[s.charAt(i++) - 'a']--;
                }
            }
        }

        return Math.max(maxLen, n - i);
    }
}
