package Sliding_Window;/*
 *
 * https://www.geeksforgeeks.org/problems/count-number-of-substrings4528/1
 *
 * # Substrings with K Distinct
 *
 *   Q. Given a string consisting of lowercase characters and an integer k, the task is to count all possible
 *      substrings (not necessarily distinct) that have exactly k distinct characters.
 *    Ex.
 *      Input : s = "aba"
 *              k = 2
 *      Output: 3
 *      Explanation: Possible substrings are ["ab", "ba", "aba"]
 */

import java.util.Scanner;

public class Q02_Substrings_with_K_Distinct {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the string: ");
        String s = sc.next();

        System.out.println("K: ");
        int k = sc.nextByte();

        System.out.println("Number of substring with distinct character of size k: \n" + countSubstr(s, k));
    }

    /// Solution
    static int countSubstr(String s, int k) {
        // potd.code.hub
        int n = s.length();
        int[] freq = new int[26];
        int count = 0, ans = 0;

        int i = 0, j = 0;

        while (j < n){
            int idx = s.charAt(j++) - 'a';
            freq[idx]++;
            if (freq[idx] == 1) count++;

            while (count > k) {
                int idx1 = s.charAt(i++) - 'a';
                freq[idx1]--;
                if (freq[idx1] == 0) count--;
            }

            int t = 1;
            if (count == k) {
                while (j < n && s.charAt(j) == s.charAt(j-1)) {
                    t++;
                    j++;
                }
                ans += (t * (t+1)) / 2;
            }
        }

        return ans;
    }
}