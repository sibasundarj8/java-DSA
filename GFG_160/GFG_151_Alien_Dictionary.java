package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/alien-dictionary/1
 *
 * # Alien Dictionary
 *
 *   Q. A new alien language uses the English alphabet, but the order of letters is unknown. You are given
 *      a list of words[] from the alien language’s dictionary, where the words are claimed to be sorted
 *      lexicographically according to the language’s rules.
 *
 *      Your task is to determine the correct order of letters in this alien language based on the given words.
 *      If the order is valid, return a string containing the unique letters in lexicographically increasing
 *      order as per the new language's rules. If there are multiple valid orders, return any one of them.
 *
 *      However, if the given arrangement of words is inconsistent with any possible letter ordering, return
 *      an empty string ("").
 *
 *      A string "a" is lexicographically smaller than a string b if, at the first position where they differ,
 *      the character in "a" appears earlier in the alien language than the corresponding character in b. If all
 *      characters in the shorter word match the beginning of the longer word, the shorter word is considered
 *      smaller.
 *
 *      Note: Your implementation will be tested using a driver code. It will print true if your returned
 *            order correctly follows the alien language’s lexicographic rules; otherwise, it will print
 *            false.
 *   Ex.
 *      Input: words[] = ["baa", "abcd", "abca", "cab", "cad"]
 *      Output: true
 *      Explanation: A possible correct order of letters in the alien dictionary is "bdac".
 *              The pair "baa" and "abcd" suggest 'b' appears before 'a' in the alien dictionary.
 *              The pair "abcd" and "abca" suggest 'd' appear before 'a' in the alien dictionary.
 *              The pair "abca" and "cab" suggest 'a' appears before 'c' in the alien dictionary.
 *              The pair "cab" and "cad" suggest 'b' appears before 'd' in the alien dictionary.
 *              So, 'b' → 'd' → 'a' → 'c' is a valid ordering.
 */

import java.util.*;

public class GFG_151_Alien_Dictionary {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        String[] words = new String[n];

        System.out.println("Enter Words: ");
        for (int i = 0;i < n;i++){
            words[i] = sc.next();
        }

        System.out.println(Arrays.toString(findOrder(words).toCharArray()));
    }

    /// Solution
    static String findOrder(String[] words) {
        // potd.code.hub
        int n = words.length;
        HashMap<Character, HashSet<Character>> adj = new HashMap<>();
        adj.put('$', new HashSet<>());

        String s = words[0];
        int sl = s.length();
        for (int i = 0;i < sl;i++){
            adj.putIfAbsent(s.charAt(i), new HashSet<>());
        }

        for (int i = 1;i < n;i++){
            String w1 = words[i-1];
            String w2 = words[i];
            int l1 = w1.length();
            int l2 = w2.length();
            int x = 0;
            boolean flag = true;
            while (x < l1 || x < l2){
                char c1 = (x < l1) ? w1.charAt(x) : '$';
                char c2 = (x < l2) ? w2.charAt(x) : '$';
                adj.putIfAbsent(c2, new HashSet<>());
                if (x < l1 && x < l2 && flag){
                    if (c1 != c2) {
                        adj.get(c1).add(c2);
                        flag = false;
                    }
                }
                if (flag && x >= l2) return "";
                x++;
            }
        }

        adj.remove('$');

        HashSet<Character> visited = new HashSet<>();
        HashSet<Character> backEdge = new HashSet<>();
        Stack<Character> stack = new Stack<>();

        for (char ch : adj.keySet()){
            if (!visited.contains(ch) && dfs(ch, adj, stack, visited, backEdge)){
                return "";
            }
        }

        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()){
            ans.append(stack.pop());
        }

        return ans.toString();
    }
    private static boolean dfs (char node, HashMap<Character, HashSet<Character>> adj, Stack<Character> stack, HashSet<Character> visited, HashSet<Character> backEdge){
        visited.add(node);
        backEdge.add(node);
        for (char ch : adj.get(node)){
            if (!visited.contains(ch) && dfs(ch, adj, stack, visited, backEdge) || backEdge.contains(ch)) {
                return true;
            }
        }
        backEdge.remove(node);
        stack.add(node);
        return false;
    }
}
