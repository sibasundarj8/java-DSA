package Trie;/*
 *
 * https://leetcode.com/problems/longest-common-suffix-queries/
 *
 * # 3093. Longest Common Suffix Queries
 *
 *   Q. You are given two arrays of strings wordsContainer and wordsQuery.
 *
 *      For each wordsQuery[i], you need to find a string from wordsContainer that has the longest common suffix with
 *      wordsQuery[i]. If there are two or more strings in wordsContainer that share the longest common suffix, find
 *      the string that is the smallest in length. If there are two or more such strings that have the same smallest
 *      length, find the one that occurred earlier in wordsContainer.
 *
 *      Return an array of integers ans, where ans[i] is the index of the string in wordsContainer that has the longest
 *      common suffix with wordsQuery[i].
 *
 *    Ex.
 *      Input : wordsContainer = ["abcd","bcd","xbcd"],
 *              wordsQuery = ["cd","bcd","xyz"]
 *      Output: [1,1,1]
 *      Explanation:
 *              Let's look at each wordsQuery[i] separately:
 *
 *                ◦ For wordsQuery[0] = "cd", strings from wordsContainer that share the longest common suffix "cd" are
 *                  at indices 0, 1, and 2. Among these, the answer is the string at index 1 because it has the shortest
 *                  length of 3.
 *
 *                ◦ For wordsQuery[1] = "bcd", strings from wordsContainer that share the longest common suffix "bcd" are
 *                  at indices 0, 1, and 2. Among these, the answer is the string at index 1 because it has the shortest
 *                  length of 3.
 *
 *                ◦ For wordsQuery[2] = "xyz", there is no string from wordsContainer that shares a common suffix. Hence,
 *                  the longest common suffix is "", that is shared with strings at index 0, 1, and 2. Among these, the
 *                  answer is the string at index 1 because it has the shortest length of 3.
 *
 *  Constraints:
 *        ◦ 1 <= wordsContainer.length, wordsQuery.length <= 10⁴
 *        ◦ 1 <= wordsContainer[i].length <= 5 * 10³
 *        ◦ 1 <= wordsQuery[i].length <= 5 * 10³
 *        ◦ wordsContainer[i] consists only of lowercase English letters.
 *        ◦ wordsQuery[i] consists only of lowercase English letters.
 *        ◦ Sum of wordsContainer[i].length is at most 5 * 10⁵.
 *        ◦ Sum of wordsQuery[i].length is at most 5 * 10⁵.
 */


import java.util.Arrays;
import java.util.Scanner;

public class T06_Longest_Common_Suffix_Queries {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter words of wordsContainer[] : ");
        String[] wordsContainer = sc.nextLine().split(" ");

        System.out.println("Enter words of wordsQuery[] : ");
        String[] wordsQuery = sc.nextLine().split(" ");

        System.out.println("Longest common suffix present on index: ");
        int[] res = stringIndices(wordsContainer, wordsQuery);

        System.out.println(Arrays.toString(res));
    }

    /// Solution
    static int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        // potd.code.hub
        int n = wordsContainer.length;
        int m = wordsQuery.length;
        int[] res = new int[m];
        TrieNode trieNode = new TrieNode();

        for (int i = 0; i < n; i++) {
            trieNode.insert(wordsContainer[i], i);
        }

        for (int i = 0; i < m; i++) {
            res[i] = trieNode.getIndex(wordsQuery[i]);
        }

        return res;
    }

    // trie structure (don't remove static from anywhere form here)
    private static class TrieNode {
        private int bestIndex = -1;
        private int bestLength = Integer.MAX_VALUE;
        private final TrieNode[] children = new TrieNode[26];

        // inserting a word
        void insert(String word, int index) {
            int n = word.length();
            TrieNode node = this;

            for (int i = n - 1; i >= 0; i--) {
                int idx = word.charAt(i) - 'a';

                if (n < node.bestLength || (n == node.bestLength && index < node.bestIndex)) {
                    node.bestLength = n;
                    node.bestIndex = index;
                }

                if (node.children[idx] == null) {
                    node.children[idx] = new TrieNode();
                }

                node = node.children[idx];
            }

            if (n < node.bestLength || (n == node.bestLength && index < node.bestIndex)) {
                node.bestLength = n;
                node.bestIndex = index;
            }
        }

        // getting the index with longest prefix
        int getIndex(String word) {
            int n = word.length();
            TrieNode node = this;

            for (int i = n - 1; i >= 0; i--) {
                int idx = word.charAt(i) - 'a';

                if (node.children[idx] == null) {
                    break;
                }

                node = node.children[idx];
            }

            return node.bestIndex;
        }
    }
}
