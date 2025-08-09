package Strings;/*
 *
 * https://www.geeksforgeeks.org/problems/longest-periodic-proper-prefix/1
 *
 * # Longest Periodic Proper Prefix (Hard)
 *
 *   Q. Given a string s, find the length of longest periodic proper prefix of s. If no such prefix exists, return -1.
 *
 *      A periodic proper prefix is a non-empty prefix of s (but not the whole string), such that repeating this prefix
 *      enough times produces a string that starts with s.
 *
 *    Ex.
 *      Input : s = "abcab"
 *      Output: 3
 *      Explanation: Repeating the proper prefix "abc" forms "abcabc., which contains "abcab" as a prefix.
 *                   No longer proper prefix satisfies this.
 */

import java.util.Scanner;

public class S11_Longest_Periodic_Proper_Prefix {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Word: ");
        String word = sc.next();

        System.out.println("Length of longest periodic prefix: " + getLongestPrefix(word));
    }

    /// Solution
/*------------------------------------------------------- K M P - algo --------------------------------------------------*/
    public static int getLongestPrefix(String s) {
        int n = s.length();
        int[] lps = lps(s);
        int prefix = lps[n - 1]; // longest prefix

        if (prefix == 0) return -1;

        // getting the shortest prefix suffix (by walking on the “border chain”)
        while (lps[prefix - 1] > 0) {
            prefix = lps[prefix - 1];
        }

        return n - prefix;
    }

    private static int[] lps(String s) {
        int n = s.length();
        int[] ps = new int[n];

        int prefix = 0;

        for (int suffix = 1; suffix < n; suffix++) {

            while (prefix > 0 && s.charAt(prefix) != s.charAt(suffix)) {
                prefix = ps[prefix - 1];
            }

            if (s.charAt(prefix) == s.charAt(suffix)) prefix++;
            ps[suffix] = prefix;
        }

        return ps;
    }

/*-------------------------------------------- Double rolled hashing (Rabin karp) ---------------------------------------*/
    /*
    Hash function: 
       Correct rolling hash for "abcd" with base = 5
       Mapping: 'a' = 0, 'b' = 1, 'c' = 2, 'd' = 3
       Base = 5, no modulus for now.

       hash = (0 * 5³) + (1 * 5²) + (2 * 5¹) + (3 * 5⁰)
            = (0 * 125) + (1 * 25) + (2 * 5) + (3 * 1)
            = 0 + 25 + 10 + 3
            = 38
    */
    static int rabinKarp(String s) {
        // potd.code.hub
        int n = s.length();

        long base1 = 29;
        long base2 = 31;
        long mod1 = (long) (1e9 + 7);
        long mod2 = (long) (1e9 + 9);

        long[] prefix = {0, 0};
        long[] suffix = {0, 0};
        long[] power = {1, 1};
        
        for (int i = 0; i < n - 1; i++) {

            int digF = s.charAt(i) - 'a' + 1;
            int digL = s.charAt(n - 1 - i) - 'a' + 1;

            // prefix hash
            prefix[0] = (prefix[0] * base1 + digF) % mod1;
            prefix[1] = (prefix[1] * base2 + digF) % mod2;

            // suffix hash
            suffix[0] = (suffix[0] + power[0] * digL) % mod1;
            suffix[1] = (suffix[1] + power[1] * digL) % mod2;

            // update powers
            power[0] = (power[0] * base1) % mod1;
            power[1] = (power[1] * base2) % mod2;

            if (prefix[0] == suffix[0] && prefix[1] == suffix[1]) {
                // smallest border found, answer is n - border
                return n - (i + 1);
            }
        }

        return -1;
    }
}
