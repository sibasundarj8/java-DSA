package Strings;/*
 *
 * https://leetcode.com/problems/words-within-two-edits-of-dictionary/
 *
 * # 2452. Words Within Two Edits of Dictionary
 *
 *   Q. You are given two string arrays, queries and dictionary. All words in each array comprise lowercase English letters
 *      and have the same length.
 *
 *      In one edit you can take a word from queries, and change any letter in it to any other letter. Find all words from
 *      queries that, after a maximum of two edits, equal some word from dictionary.
 *
 *      Return a list of all words from queries, that match with some word from dictionary after a maximum of two edits.
 *      Return the words in the same order they appear in queries.
 *
 *    Ex.
 *      Input : queries = ["word","note","ants","wood"], dictionary = ["wood","joke","moat"]
 *      Output: ["word","note","wood"]
 *      Explanation:
 *              - Changing the 'r' in "word" to 'o' allows it to equal the dictionary word "wood".
 *              - Changing the 'n' to 'j' and the 't' to 'k' in "note" changes it to "joke".
 *              - It would take more than 2 edits for "ants" to equal a dictionary word.
 *              - "wood" can remain unchanged (0 edits) and match the corresponding dictionary word.
 *              Thus, we return ["word","note","wood"].
 *
 *  Constraints:
 *          1 <= queries.length, dictionary.length <= 100
 *          n == queries[i].length == dictionary[j].length
 *          1 <= n <= 100
 *          All queries[i] and dictionary[j] are composed of lowercase English letters.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class S16_Words_Within_Two_Edits_of_Dictionary {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter queries[]: ");
        String[] queries = sc.nextLine().split(" ");

        System.out.println("Enter dictionary[]: ");
        String[] dictionary = sc.nextLine().split(" ");

        int len = queries[0].length();
        for (String query : queries) {
            if (query.length() != len) {
                throw new RuntimeException("all the queries length must be " + len);
            }
        }
        for (String word : dictionary) {
            if (word.length() != len) {
                throw new RuntimeException("all the dictionary word's length must be " + len);
            }
        }

        System.out.println("words can be replaced after at-most 2 edits: ");
        System.out.println(twoEditWords(queries, dictionary));
    }

    /// Solution
    static List<String> twoEditWords(String[] queries, String[] dictionary) {
        // potd.code.hub
        List<String> res = new ArrayList<>();

        for (String query : queries) {
            for (String word : dictionary) {
                if (withinTwoEdits(query, word)) {
                    res.add(query);
                    break;
                }
            }
        }

        return res;
    }

    private static boolean withinTwoEdits(String s1, String s2) {
        int n = s1.length();
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
                if (count > 2) return false;
            }
        }

        return true;
    }
}
