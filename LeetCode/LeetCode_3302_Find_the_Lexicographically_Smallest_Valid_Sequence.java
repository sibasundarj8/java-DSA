package LeetCode;/*
 *
 * https://leetcode.com/problems/find-the-lexicographically-smallest-valid-sequence/
 *
 * # LC. 3302. Find the Lexicographically Smallest Valid Sequence
 *
 *   Q. You are given two strings word1 and word2.
 *
 *      A string x is called almost equal to y if you can change at most one character in x to make it identical to y.
 *
 *      A sequence of indices seq is called valid if:
 *        ◦ The indices are sorted in ascending order.
 *        ◦ Concatenating the characters at these indices in word1 in the same order results in a string that is almost
 *          equal to word2.
 *
 *      Return an array of size word2.length representing the lexicographically smallest valid sequence of indices.
 *      If no such sequence of indices exists, return an empty array.
 *
 *      Note that the answer must represent the lexicographically smallest array, not the corresponding string formed
 *      by those indices.
 *
 *    Ex.
 *      Input : word1 = "vbcca", word2 = "abc"
 *      Output: [0,1,2]
 *      Explanation:
 *              The lexicographically smallest valid sequence of indices is [0, 1, 2]:
 *              Change word1[0] to 'a'.
 *              word1[1] is already 'b'.
 *              word1[2] is already 'c'.
 *
 *  Constraints:
 *        1 <= word2.length < word1.length <= 3 * 10⁵
 *        word1 and word2 consist only of lowercase English letters.
 */

import java.util.Arrays;
import java.util.Scanner;

public class LeetCode_3302_Find_the_Lexicographically_Smallest_Valid_Sequence {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("word-1: ");
        String word1 = sc.next();

        System.out.print("word-2: ");
        String word2 = sc.next();

        System.out.println("The lexicographically smallest valid sequence of indices: ");
        System.out.println(Arrays.toString(validSequence(word1, word2)));
    }

    /// Solution
    static int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();

        int[] suffix = new int[n + 1];
        int j = m - 1;

        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1];

            if (j >= 0 && w1[i] == w2[j]) {
                suffix[i]++;
                j--;
            }
        }

        int prefix = 0;
        j = 0;
        boolean isPossible = false;
        int[] res = new int[m];

        for (int i = 0; i < n; i++) {
            boolean equal = w1[i] == w2[j];

            if (!equal && prefix + 1 + suffix[i + 1] >= m) {
                res[j++] = i;
                isPossible = true;
                break;
            }

            if (equal) {
                prefix++;
                res[j++] = i;
                if (prefix == m) {
                    isPossible = true;
                    break;
                }
            }
        }

        if (!isPossible) return new int[0];

        for (int i = res[j - 1] + 1; i < n && j < m; i++) {
            if (w1[i] == w2[j]) {
                res[j++] = i;
            }
        }

        return res;
    }
}
