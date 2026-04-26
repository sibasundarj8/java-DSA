package Contest.weekly_499;/*
 *
 * https://leetcode.com/contest/weekly-contest-499/problems/sort-vowels-by-frequency/
 *
 * # Q2. Sort Vowels by Frequency
 *
 *   Q. You are given a string s consisting of lowercase English characters.
 *      Rearrange only the vowels in the string so that they appear in non-increasing order of their frequency.
 *      If multiple vowels have the same frequency, order them by the position of their first occurrence in s.
 *
 *      Return the modified string.
 *
 *      Vowels are 'a', 'e', 'i', 'o', and 'u'.
 *
 *      The frequency of a letter is the number of times it occurs in the string.
 *
 *    Ex.
 *      Input: s = "leetcode"
 *      Output: "leetcedo"
 *      Explanation:
 *              Vowels in the string are ['e', 'e', 'o', 'e'] with frequencies: e = 3, o = 1.
 *              Sorting in non-increasing order of frequency and placing them back into the vowel positions results in
 *              "leetcedo".
 *
 *  Constraints:
 *          1 <= s.length <= 10⁵
 *          s consists of lowercase English letters
 */

import java.util.Arrays;

public class Q2_Sort_Vowels_by_Frequency {

    /// Solution
    public String sortVowels(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int[] next = new int[n];
        int nextIdx = -1;
        Pair[] pairs = {new Pair('a'), new Pair('e'), new Pair('i'), new Pair('o'), new Pair('u')};

        // getting vowel with order.
        for (int i = n - 1; i >= 0; i--) {
            char ch = chars[i];

            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                int idx = getVowelIdx(ch);

                pairs[idx].count++;
                pairs[idx].firstIndex = i;
                next[i] = nextIdx;
                nextIdx = i;
            }
        }

        // sorting logic.
        Arrays.sort(pairs, (a, b) -> {
            if (a.count == b.count) {
                return a.firstIndex - b.firstIndex;
            }
            return b.count - a.count;
        });

        // putting back in string.
        for (int i = 0; i < 5; i++) {
            Pair pair = pairs[i];

            while (pair.count-- > 0) {
                chars[nextIdx] = pair.ch;
                nextIdx = next[nextIdx];
            }
        }

        return String.valueOf(chars);
    }

    private int getVowelIdx(char ch) {
        return switch (ch) {
            case 'a' -> 0;
            case 'e' -> 1;
            case 'i' -> 2;
            case 'o' -> 3;
            case 'u' -> 4;
            default -> -1;
        };
    }

    private static class Pair {
        char ch;
        int count;
        int firstIndex;

        Pair(char ch) {
            this.ch = ch;
            count = 0;
        }
    }
}
