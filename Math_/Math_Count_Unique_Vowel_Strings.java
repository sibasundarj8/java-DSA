package Math_;/*
 *
 * https://www.geeksforgeeks.org/problems/count-unique-vowel-strings/1
 *
 * # Count Unique Vowel Strings
 *
 *   Q. You are given a lowercase string s, determine the total number of distinct strings that can be formed
 *      using the following rules:
 *
 *        ▸ Identify all unique vowels (a, e, i, o, u) present in the string.
 *
 *        ▸ For each distinct vowel, choose exactly one of its occurrences from s. If a vowel appears multiple
 *          times, each occurrence represents a unique selection choice.
 *
 *        ▸ Generate all possible permutations of the selected vowels. Each unique arrangement counts as a
 *          distinct string.
 *
 *        ▸ Return the total number of such distinct strings.
 *    Ex.
 *      Input : s = "aacidf"
 *      Output: 4
 *      Explanation: Vowels in s are 'a' and 'i', Pick each 'a' once with a single 'i',
 *                   make all orders → "ai", "ia", "ai", "ia".
 */

import java.util.Scanner;

public class Math_Count_Unique_Vowel_Strings {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Word: ");
        String s = sc.next();

        System.out.println("Unique vowel string count: " + vowelCount(s));
    }

    /// Solution
    static int vowelCount(String s) {
        // potd.code.hub
        int n = s.length();
        int vowelCount = 0;
        int ans = 1;
        int[] vowelFreq = new int[5];

        for (int x = 0; x < n; x++) {
            char cur = s.charAt(x);
            int idx;

            if (cur == 'a') idx = 0;
            else if (cur == 'e') idx = 1;
            else if (cur == 'i') idx = 2;
            else if (cur == 'o') idx = 3;
            else if (cur == 'u') idx = 4;
            else continue;

            if (vowelFreq[idx] == 0) {
                vowelCount++;
                ans *= vowelCount;
            }
            vowelFreq[idx]++;
        }

        for (int x : vowelFreq)
            if (x != 0) ans *= x;

        return (vowelCount == 0) ? 0 : ans;
    }
}
