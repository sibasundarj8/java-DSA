package Contest.weekly_499;/*
 *
 * https://leetcode.com/contest/weekly-contest-499/problems/valid-elements-in-an-array/
 *
 * # Q1. Valid Elements in an Array©leetcode
 *
 *   Q. You are given an integer array nums.
 *
 *      An element nums[i] is considered valid if it satisfies at least one of the following conditions:
 *        ◦ It is strictly greater than every element to its left.
 *        ◦ It is strictly greater than every element to its right.
 *
 *      The first and last elements are always valid.
 *      Return an array of all valid elements in the same order as they appear in nums.
 *
 *    Ex.
 *      Input: nums = [1,2,4,2,3,2]
 *      Output: [1,2,4,3,2]
 *      Explanation:
 *              nums[0] and nums[5] are always valid.
 *              nums[1] and nums[2] are strictly greater than every element to their left.
 *              nums[4] is strictly greater than every element to its right.
 *              Thus, the answer is [1, 2, 4, 3, 2].©leetcode
 *
 *  Constraints:
 *          1 <= nums.length <= 100
 *          1 <= nums[i] <= 100
 */

import java.util.Arrays;

public class Q1_Valid_Elements_in_an_Array {

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
