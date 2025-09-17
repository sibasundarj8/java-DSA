package Recursion;/*
 *
 * https://www.geeksforgeeks.org/problems/decode-the-string2444/1
 *
 * # Decode the string
 *
 *   Q. Given an encoded string s, decode it by expanding the pattern k[substring], where the substring
 *      inside brackets is written k times. k is guaranteed to be a positive integer, and encodedString
 *      contains only lowercase english alphabets. Return the final decoded string.
 *
 *      Note: The test cases are generated so that the length of the output string will never exceed 10⁵.
 *   Ex.
 *      Input : s = "3[b2[ca]]"
 *      Output: "bcacabcacabcaca"
 *      Explanation:
 *          Inner substring “2[ca]” breakdown into “caca”.
 *          Now, new string becomes “3[bcaca]”
 *          Similarly “3[bcaca]” becomes “bcacabcacabcaca” which is final result.
 */

import java.util.Scanner;

public class Recursion_52_Decode_the_string {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter encoded String: ");
        String s = sc.next();

        System.out.println("Decoded version: " + decodeString(s));
    }

    /// Solution
    static String decodeString(String s) {
        int n = s.length();

        StringBuilder word = new StringBuilder();
        StringBuilder num = new StringBuilder();

        for (int i = 0; i < n; i++) {
            char cur = s.charAt(i);

            if (Character.isAlphabetic(cur)) word.append(cur);
            if (Character.isDigit(cur)) num.append(cur);

            if (cur == '[') {
                int count = 1;
                int j = i + 1;

                while (++j < n) {
                    if (s.charAt(j) == '[') count++;
                    if (s.charAt(j) == ']') count--;
                    if (count == 0) break;
                }

                word.append(decodeString(s.substring(i + 1, j)).repeat(Integer.parseInt(num.toString())));
                num.delete(0, num.length());
                i = j;
            }
        }

        return word.toString();
    }
}
