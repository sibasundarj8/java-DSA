package Deloitte_Mock;/*
 *
 * ## Problem Statement (easy)
 *
 *      You are given a string s of even length. Split this string into two halves of equal lengths, and
 *      let a be the first half and b be the second half.
 *
 *      Two strings are alike if they have the same number of vowels ('a', 'e', 'i', 'o', 'u', 'A', 'E',
 *      'I', 'O', 'U'). Notice that s contains uppercase and lowercase letters.
 *
 *      Return true if a and b are alike. Otherwise, return false.
 *  Ex.
 *      input : s = book
 *      output: true
 */

import java.util.Scanner;

public class Q02_Alike_Strings {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        System.out.println(halvesAreAlike(s));
    }

    /// Solution
    static boolean halvesAreAlike(String s) {
        int n = s.length();

        if ((n & 1) == 1) {
            System.err.println("[EXCEPTION]: length must be even");
            return false;
        }

        int half = 0;
        int total = 0;

        for (int i = 0; i < n; i++) {
            if (isVowel(s.charAt(i))) {
                if (i < n / 2) half++;
                total++;
            }
        }

        return half * 2 == total;
    }

    private static boolean isVowel(Character ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
               ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
}