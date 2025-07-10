package Trie;/*
 *
 * https://www.geeksforgeeks.org/problems/trie-insert-and-search0651/1
 *
 * # Implement Trie
 *
 *   Q. Implement Trie class and complete insert(), search() and isPrefix() function for the following queries:
 *
 *      Type 1 : (1, word), calls insert(word) function and insert word in the Trie
 *      Type 2 : (2, word), calls search(word) function and check whether word exists in Trie or not.
 *      Type 3 : (3, word), calls isPrefix(word) function and check whether word exists as a prefix of any string
 *               in Trie or not.
 *   Ex.  Input : query[][] = [[1, "abcd"],
 *                             [1, "abc"],
 *                             [1, "bcd"],
 *                             [2, "bc"],
 *                             [3, "bc"],
 *                             [2, "abc"]]
 *        Output: [false, true, true]
 *        Explanation: string "bc" does not exist in the trie, "bc" exists as prefix of the word "bcd" in the trie,
 *                     and "abc" also exists in the trie.
 */

import java.util.Scanner;

public class T01_Implement_Trie {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Number of queries: ");
        int n = sc.nextInt();

        String[][] queries = new String[n][2];

        System.out.println("Enter Queries: ");
        for (int i = 0; i < n; i++) {
            queries[i][0] = sc.next();
            queries[i][1] = sc.next();
        }


        Trie trie = new Trie();

        for (String[] s : queries) {
            int x = Integer.parseInt(s[0]);
            switch (x) {
                case 1 -> trie.insert(s[1]);
                case 2 -> System.out.println(trie.search(s[1]));
                case 3 -> System.out.println(trie.isPrefix(s[1]));
                default -> {
                    System.err.println("Invalid input");
                    return;
                }
            }
        }
    }

    /// Solution
    private static class Trie {
        private final Trie[] tries;
        private boolean flag;

        // constructor
        Trie() {
            this.tries = new Trie[26];
            this.flag = false;
        }

        // Insert a word.
        void insert(String word) {
            Trie temp = this;
            int n = word.length();

            for (int i = 0; i < n; i++) {
                int idx = word.charAt(i) - 'a';
                if (temp.tries[idx] == null) temp.tries[idx] = new Trie();
                temp = temp.tries[idx];
            }

            temp.flag = true;
        }

        // Search for a word.
        boolean search(String word) {
            int n = word.length();
            Trie temp = this;

            for (int i = 0; i < n; i++) {
                int idx = word.charAt(i) - 'a';
                if (temp.tries[idx] == null) return false;
                temp = temp.tries[idx];
            }

            return temp.flag;
        }

        // Check if a prefix exists.
        boolean isPrefix(String word) {
            int n = word.length();
            Trie temp = this;

            for (int i = 0; i < n; i++) {
                int idx = word.charAt(i) - 'a';
                if (temp.tries[idx] == null) return false;
                temp = temp.tries[idx];
            }

            return true;
        }
    }
}
