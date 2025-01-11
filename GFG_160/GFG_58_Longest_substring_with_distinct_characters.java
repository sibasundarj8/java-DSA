package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/longest-distinct-characters-in-string5848/1
 *
 * # Longest substring with distinct characters
 *
 *   Q. Given a string s, find the length of the longest substring with all distinct characters.
 *    Ex.
 *      Input : s = "geeksforgeeks"
 *      Output: 7
 *      Explanation: "eksforg" is the longest substring with all distinct characters.
 */
import java.util.Scanner;

public class GFG_58_Longest_substring_with_distinct_characters {

    /// main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Word: ");
        String s = sc.next();

        System.out.println(longestUniqueSubStr(s));
    }

    /// Solution
    static int longestUniqueSubStr(String s) {
        // potd.code.hub
        int n = s.length(), ans = 0, i = 0, j = 0;
        int[]freq = new int[26];

        while (j < n){
            int idx = s.charAt(j++) - 'a';
            while (freq[idx] > 0) freq[(s.charAt(i++) - 'a')]--;
            ans = Math.max(ans, j-i);
            freq[idx]++;
        }

        return ans;
    }
}
