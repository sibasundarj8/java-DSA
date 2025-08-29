package Sliding_Window;/*
 *
 * https://www.geeksforgeeks.org/problems/smallest-window-in-a-string-containing-all-the-characters-of-another-string-1587115621/1
 *
 * # Smallest window containing all characters
 *
 *   Q. Given two strings s and p. Find the smallest substring in s consisting of all the characters (including
 *      duplicates) of the string p. Return empty string in case no such substring is present.
 *
 *      If there are multiple such substring of the same length found, return the one with the least starting
 *      index.
 *   Ex.
 *      Input : s = "timetopractice", p = "toc"
 *      Output: "toprac"
 *      Explanation: "toprac" is the smallest substring in which "toc" can be found.
 *
 *   Constraints:
 *          1 ≤ s.length(), p.length() ≤ 10⁶
 *          s, p consists of lowercase english letters
 */

import java.util.Scanner;

public class Q14_Smallest_window_containing_all_characters {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("s: ");
        String s = sc.next();

        System.out.print("p: ");
        String p = sc.next();

        System.out.println("Smallest window: " + smallestWindow(s, p));
    }

    /// Solution
    static String smallestWindow(String str, String pat) {
        // potd.code.hub
        int n = str.length();
        int m = pat.length();
        int countUniqueP = 0;
        int countUniqueS = 0;
        int start = 0;
        int length = 0;

        if (n < m) return "";

        char[] s = str.toCharArray();   // Array representation of s
        char[] p = pat.toCharArray();   // Array presentation of p
        int[] frqS = new int[26];       // stores the frequencies of characters of Str
        int[] frqP = new int[26];       // stores the frequencies of characters of Pat

        // calculating pat char frequency
        for (int i = 0; i < m; i++) {
            int idx = p[i] - 'a';
            if (frqP[idx] == 0) countUniqueP++;
            frqP[idx]++;
        }

        // sliding window to find the smallest matching sub-string
        int i = 0, x = 0;

        while (x < n) {
            int idx = s[x] - 'a';
            if (frqP[idx] > 0) {
                frqS[idx]++;
                // increase counting only if it reaches required frequency
                if (frqS[idx] == frqP[idx]) countUniqueS++;
            }

            // checking while shrinking front side
            if (countUniqueS == countUniqueP && (length == 0 || x - i + 1 < length)) {
                start = i;
                length = x - i + 1;
            }

            // shrinking window until char count not smaller then required
            while (i < x && countUniqueS == countUniqueP) {
                int idx1 = s[i] - 'a';
                if (frqP[idx1] > 0) {
                    frqS[idx1]--;
                    if (frqS[idx1] < frqP[idx1]) {
                        countUniqueS--;
                    }
                }

                i++;

                // checking while shrinking back side
                if (countUniqueS == countUniqueP && (x - i + 1 < length)) {
                    start = i;
                    length = x - i + 1;
                }
            }

            x++;
        }

        return str.substring(start, start + length);
    }
}
