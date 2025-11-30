package Trie;/*
 *
 * https://www.geeksforgeeks.org/problems/count-of-distinct-substrings/1
 *
 * # Count of distinct substrings
 *
 *   Q. Given a string s consisting of lowercase English characters, determine the total number of distinct non-empty
 *      substrings present in the string. A substring is defined as a contiguous block of characters within the string.
 *
 *      Two substrings are considered distinct if their contents differ, even if they originate from different positions
 *      in the string.
 *
 *      Note: The empty substring is not counted.
 *
 *    Ex.
 *      Input : s = "ababa"
 *      Output: 9
 *      Explanation: All distinct substrings of "ababa" are: "a",
 *                                                           "b",
 *                                                           "ab",
 *                                                           "ba",
 *                                                           "aba",
 *                                                           "bab",
 *                                                           "abab",
 *                                                           "baba",
 *                                                           "ababa".
 *  Constraints:
 *          1 ≤ s.size() ≤ 3000
 */

import java.util.HashSet;
import java.util.Scanner;

public class T03_Count_of_distinct_substrings {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the String: ");
        String s = sc.next();

        System.out.print("Number of unique sub-strings: ");
        System.out.println(new Solution().countSubs(s));
    }

    /// Solution
/*
☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕︎☕☕☕-Brute-Force-☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕
TC : O(n³)
SC : O(n²)
*/
    static int bruteForce(String s) {
        // potd.code.hub
        int n = s.length();
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < n; i++)
            for (int j = i + 1; j <= n; j++)
                set.add(s.substring(i, j));

        return set.size();
    }
}

/*
☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕︎☕☕☕-Using-Trie-☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕☕
TC : O(n²)
SC : O(n²)
*/
class Trie {
    private final Trie[] chars;
    private int numberOfSubString;

    Trie() {
        chars = new Trie[26];
        numberOfSubString = 0;
    }

    void addString(String s) {
        int n = s.length();
        Trie t = this;

        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';
            if (t.chars[idx] == null) {
                t.chars[idx] = new Trie();
                numberOfSubString++;
            }
            t = t.chars[idx];
        }
    }

    int getNumberOfSubString() {
        return numberOfSubString;
    }
}

class Solution {
    public int countSubs(String s) {
        // potd.code.hub
        int n = s.length();
        Trie trie = new Trie();

        for (int i = 0; i < n; i++) {
            trie.addString(s.substring(i, n));
        }

        return trie.getNumberOfSubString();
    }
}
