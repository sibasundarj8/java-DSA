package Sliding_Window;/*
 *
 * https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1
 *
 * # Longest Substring with K Uniques
 *
 *   Q. You are given a string s consisting only lowercase alphabets and an integer k. Your task is to find the
 *      length of the longest substring that contains exactly k distinct characters.
 *
 *      Note : If no such substring exists, return -1.
 *    Ex.
 *      Input : s = "aabacbebebe"
 *              k = 3
 *      Output: 7
 *      Explanation: The longest substring with exactly 3 distinct characters is "cbebebe", which includes 'c',
 *                   'b', and 'e'.
 */
import java.util.Scanner;

public class Q10_Longest_Substring_with_K_Uniques {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the word: ");
        String s = sc.next();

        System.out.println("k: ");
        int k = sc.nextInt();

        System.out.println("size of longest substring: " + longestKSubstr(s, k));
    }

    /// Solution
    static int longestKSubstr(String s, int k) {
        // potd.code.hub
        int n = s.length();
        int ans = -1;
        int uniqueCount = 0;
        int[] freq = new int[26];

        int i = 0, p = 0;

        while (i < n) {
            int cur = s.charAt(i++) - 'a';
            if (freq[cur] == 0) uniqueCount++;
            freq[cur]++;

            while (uniqueCount > k) {
                int pre = s.charAt(p++) - 'a';
                freq[pre]--;
                if (freq[pre] == 0) uniqueCount--;
            }

            if (uniqueCount == k) ans = Math.max(ans, i - p);
        }

        return ans;
    }
}
