package Trie;/*
 *
 * https://www.geeksforgeeks.org/problems/shortest-unique-prefix-for-every-word/1
 *
 * # Shortest Unique Prefix for Every Word
 *
 *   Q. Given an array of strings arr[ ], find the shortest prefix of each string that uniquely identifies it among all
 *      strings in the array. A prefix is unique if it is not a prefix of any other string in the array.
 *
 *      Note: No string in the given array is a prefix of another string.
 *
 *    Ex.
 *      Input : arr[] = ["zebra", "dog", "duck", "dove"]
 *      Output: ["z", "dog", "du", "dov"]
 *      Explanation: z => zebra, dog => dog, duck => du, dove => dov
 *
 *  Constraints:
 *        ◦ 1 ≤ |arr| ≤ 1000
 *        ◦ 1 ≤ |arr[i]| ≤ 1000
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class T07_Shortest_Unique_Prefix_for_Every_Word {

    /// main Method
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter words: ");
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        int n = st.countTokens();
        String[] words = new String[n];

        for (int i = 0; i < n; i++) {
            words[i] = st.nextToken();
        }

        System.out.println("Unique prefixes: ");
        System.out.println(findPrefixes(words));
    }

    /// Solution
    private static class TrieNode {
        private final TrieNode[] children = new TrieNode[26];
        private int count;

        void insert(String word) {
            TrieNode node = this;
            int n = word.length();

            for (int i = 0; i < n; i++) {
                int index = word.charAt(i) - 'a';

                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }

                node = node.children[index];
                node.count++;
            }
        }

        String getUniquePrefix(String word) {
            TrieNode node = this;
            StringBuilder sb = new StringBuilder();
            int n = word.length();

            for (int i = 0; i < n; i++) {
                char ch = word.charAt(i);
                int index = ch - 'a';

                sb.append(ch);
                node = node.children[index];

                if (node.count == 1) break;
            }

            return sb.toString();
        }
    }

    static ArrayList<String> findPrefixes(String[] arr) {
        // potd.code.hub
        TrieNode root = new TrieNode();

        for (String word : arr) {
            root.insert(word);
        }

        ArrayList<String> res = new ArrayList<>();

        for (String word : arr) {
            res.add(root.getUniquePrefix(word));
        }

        return res;
    }
}
