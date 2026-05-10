package Contest.weekly_501;/*
 *
 * https://leetcode.com/contest/weekly-contest-501/problems/count-valid-word-occurrences/
 *
 * # Q2. Count Valid Word Occurrences
 *
 *   Q. You are given an array of strings chunks. The strings are concatenated in order to form a single string s.
 *
 *      You are also given an array of strings queries.
 *
 *      A word is defined as a substring of s that:
 *        ◦ consists of lowercase English letters ('a' to 'z'),
 *        ◦ may include hyphens ('-') only if each hyphen is surrounded by lowercase English letters, and
 *        ◦ is not part of a longer substring that also satisfies the above conditions.
 *
 *      Any character that is not a lowercase English letter or a valid hyphen acts as a separator.
 *
 *      Return an integer array ans such that ans[i] is the number of occurrences of queries[i] as a word in s.
 *
 *      A substring is a contiguous non-empty sequence of characters within a string.
 *
 *    Ex.
 *      Input : chunks = ["a--b a-", "-c"], queries = ["a", "b", "c"]
 *      Output: [2, 1, 1]
 *      Explanation:
 *              Concatenating all strings in chunks gives s = "a--b a--c".
 *              The valid words in s are "a" which appears twice, "b" which appears once, and "c" which appears once.
 *              Thus, the ans = [2, 1, 1].
 *
 *  Constraints:
 *        ◦ 1 <= chunks.length <= 10⁵
 *        ◦ 1 <= chunks[i].length <= 10⁵
 *        ◦ chunks[i] may consist of lowercase English letters, spaces, and hyphens.
 *        ◦ The total length of all strings in chunks does not exceed 10⁵
 *        ◦ 1 <= queries.length <= 10⁵
 *        ◦ 1 <= queries[i].length <= 10⁵
 *        ◦ queries[i] is a valid word
 *        ◦ The total length of all strings in queries does not exceed 10⁵
 */

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Q2_Count_Valid_Word_Occurrences {

    /// Solution
    public int[] countWordOccurrences(String[] chunks, String[] queries) {
        String completeSentence = String.join("", chunks);
        HashMap<String, Integer> map = new HashMap<>();
        String regex = "[a-z]+(?:-[a-z]+)*";

        Matcher matcher = Pattern.compile(regex).matcher(completeSentence);

        while (matcher.find()) {
            String word = matcher.group();
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        int m = queries.length;
        int[] res = new int[m];

        for (int i = 0; i < m; i++) {
            res[i] = map.getOrDefault(queries[i], 0);
        }

        return res;
    }
}
