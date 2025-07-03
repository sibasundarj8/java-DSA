package Sliding_Window;/*
 *
 * https://www.geeksforgeeks.org/problems/substrings-of-length-k-with-k-1-distinct-elements/1
 *
 * # Substrings of length k with k-1 distinct elements
 *
 *   Q. Given a string s consisting only lowercase alphabets and an integer k. Find the count of all substrings of
 *      length k which have exactly k-1 distinct characters.
 *    Ex.
 *      Input : s = "abcc"
 *              k = 2
 *      Output: 1
 *      Explanation: Possible substring of length k = 2 are,
 *              ab : 2 distinct characters
 *              bc : 2 distinct characters
 *              cc : 1 distinct characters
 *              Only one valid substring so, count is equal to 1.
 */
import java.util.Scanner;

public class Q08_Substrings_of_length_k_with_k1_distinct_elements {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("String: ");
        String s = sc.next();

        System.out.print("k: ");
        int k = sc.nextInt();

        System.out.println("Number of sub-strings with k distinct characters: ");
        System.out.println(substrCount(s, k));
    }

    /// Solution
    static int substrCount(String s, int k) {
        // potd.code.hub
        int n = s.length(), ans = 0;
        int l = 0, r = 0;
        int cur, prv, distinctCount = 0;
        int[]freq = new int[26];

        while (r < n) {
            cur = s.charAt(r) - 'a';
            if (freq[cur] == 0) distinctCount++;
            freq[cur]++;

            if (r >= k) {
                prv = s.charAt(l++) - 'a';
                freq[prv]--;
                if (freq[prv] == 0) distinctCount--;
            }

            if (r >= k-1 && distinctCount == k-1) ans++;

            r++;
        }

        return ans;
    }
}
