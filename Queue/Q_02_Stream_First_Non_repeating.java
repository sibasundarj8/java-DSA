package Queue;/*
 *
 * https://www.geeksforgeeks.org/problems/first-non-repeating-character-in-a-stream1216/1
 *
 * # Stream First Non-repeating
 *
 *   Q. Given a string s consisting of only lowercase alphabets, for each index i in the string (0 ≤ i < n), find the first
 *      non-repeating character in the prefix s[0...i]. If no such character exists, use '#'.
 *    Ex.
 *      Input : s = "aabc"
 *      Output: a#bb
 *      Explanation:
 *              At i=0 ("a"): First non-repeating character is 'a'.
 *              At i=1 ("aa"): No non-repeating character, so '#'.
 *              At i=2 ("aab"): First non-repeating character is 'b'.
 *              At i=3 ("aabc"): Non-repeating characters are 'b' and 'c'; 'b' appeared first, so 'b'.
 *
 *  Constraints:
 *          1 ≤ s.size() ≤ 10⁵
 */

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Q_02_Stream_First_Non_repeating {

    /// main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the String: ");
        String s = sc.next();

        System.out.println("first non-repeating character in the prefix: ");
        System.out.println(firstNonRepeating(s));
    }

    /// Solution
    static String firstNonRepeating(String s) {
        // potd.code.hub
        int n = s.length();
        StringBuilder ans = new StringBuilder();
        int[] freq = new int[26];
        Queue<Character> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            // increase the frequency of current character
            char ch = s.charAt(i);
            int idx = ch - 'a';
            freq[idx]++;

            // add it to queue is it's the unique one.
            if (freq[idx] == 1) queue.offer(ch);

            // clean queue until peek is a repeating character
            while (!queue.isEmpty() && freq[queue.peek() - 'a'] > 1) {
                queue.poll();
            }

            // now answer is in the peek of the queue.
            ch = (queue.isEmpty()) ? '#' : queue.peek();
            ans.append(ch);
        }

        return ans.toString();
    }
}
