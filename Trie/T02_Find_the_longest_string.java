package Trie;/*
 *
 * https://www.geeksforgeeks.org/problems/find-the-longest-string--170645/1
 *
 * # Find the longest string
 *
 *   Q. Given an array of strings words[]. Find the longest string in words[] such that every prefix of it is also
 *      present in the array words[].
 *
 *      Note: If multiple strings have the same maximum length, return the lexicographically smallest one.
 *   Ex.
 *      Input : words[] = ["p", "pr", "pro", "probl", "problem", "pros", "process", "processor"]
 *      Output: pros
 *      Explanation: "pros" is the longest word with all prefixes ("p", "pr", "pro", "pros") present in the array
 *                   words[].
 */

import java.util.*;

public class T02_Find_the_longest_string {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the words: ");
        String[] words = sc.nextLine().split(" ");

        System.out.println("Longest String with all prefix: " + longestString(words));
    }

    /// Solution
/*--------------------------------------------------Trie-Implementation--------------------------------------------------*/
    private static class Trie {
        private final Trie[] tries;
        private boolean flag;

        // constructor
        Trie() {
            this.tries = new Trie[26];
            this.flag = false;
        }

        // Insert a word.
        private void insert(String word) {
            Trie temp = this;
            int n = word.length();

            for (int i = 0; i < n; i++) {
                int idx = word.charAt(i) - 'a';
                if (temp.tries[idx] == null) temp.tries[idx] = new Trie();
                temp = temp.tries[idx];
            }

            temp.flag = true;
        }

        // Check all prefix are available or not
        private boolean checkAllPrefix(String word) {
            Trie temp = this;

            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                temp = temp.tries[idx];

                if (temp == null || !temp.flag) return false;
            }

            return true;
        }
    }

/*
----------------------------------------------------Type-1-Using-Trie----------------------------------------------------
✅ Little bit faster
❌ More complex code
❌ Hard to implement
*/
    public static String longestString(String[] words) {
        // potd.code.hub
        Trie trie = new Trie();
        trie.flag = true;

        // inserting each word to the Trie
        for (String word : words)
            trie.insert(word);

        List<String> list = new ArrayList<>();

        solve(trie, new StringBuilder(), list);

        list.sort(Comparator.comparing(a -> -a.length()));

        return list.get(0);
    }

    private static void solve(Trie trie, StringBuilder s, List<String> ans) {
        // base case
        if (!trie.flag) return;

        // recursive case
        for (int i = 0; i < 26; i++) {
            if (trie.tries[i] != null && trie.tries[i].flag) {
                s.append((char) (i + 'a'));
                solve(trie.tries[i], s, ans);
                s.deleteCharAt(s.length() - 1);
            }
        }

        ans.add(s.toString());
    }

/*
----------------------------------------------------Type-2-Using-Trie----------------------------------------------------
❌ Little bit slower
✅ Straightforward code
✅ Easier to implement
*/
    public static String longestString2(String[] words) {
        // potd.code.hub
        String ans = "";
        Trie trie = new Trie();
        trie.flag = true;

        // inserting each word to the Trie
        for (String word : words)
            trie.insert(word);

        Arrays.sort(words);

        for (String s : words)
            if (s.length() > ans.length() && trie.checkAllPrefix(s))
                ans = s;

        return ans;
    }
}
