package Hashing;/*
 *
 * https://www.geeksforgeeks.org/problems/substrings-with-similar-first-and-last-characters3644/1
 *
 * # Substrings with same first and last characters
 *
 *   Q. Given a string s consisting of lowercase characters, the task is to find the count of all substrings that
 *      start and end with the same character.
 *   Ex.
 *      Input : s = "abcab"
 *      Output: 7
 *      Explanation: There are 7 substrings where the first and last characters are the
 *                   same: "a", "abca", "b", "bcab", "c", "a", and "b"
 */

import java.util.Scanner;

public class Substrings_with_same_first_and_last_characters {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("String: ");
        String s = sc.next();

        System.out.println("Number of substring with same first and last char: ");
        System.out.println(countSubstring(s));
    }

    /// Solution
    static int countSubstring(String s) {
        // potd.code.hub
        int n = s.length();
        int[] freq = new int[26];

        int ans = 0;

        for (int i = 0;i < n;i++){
            int idx = s.charAt(i) - 'a';
            freq[idx]++;
        }

        for (int i : freq){
            ans += i * (i+1) / 2;
        }

        return ans;
    }
}
