package Strings;/*
 *
 * https://www.geeksforgeeks.org/problems/search-pattern-rabin-karp-algorithm--141631/1
 *
 * # Search Pattern (Rabin-Karp Algorithm)
 *
 *   Q. Given two strings, one is a text string and the other is a pattern string. The task is to print the
 *      starting indexes of all the occurrences of the pattern string in the text string. For printing, the
 *      Starting Index of a string should be taken as 1. The strings will only contain lowercase English
 *      alphabets ('a' to 'z').
 *    Ex.
 *      Input : text = "geeksforgeeks"
 *              pattern = "geek"
 *      Output: [1, 9]
 *      Explanation:
 *              The string "geek" occurs twice in text, one starts are index 1 and the other at index 9.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class S9_Search_Pattern_Rabin_Karp_Algorithm {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Text: ");
        String txt = sc.next();

        System.out.println("Pattern: ");
        String pat = sc.next();

        System.out.println("Found at index: " + search(pat, txt));
    }

    /// Solution
    static ArrayList<Integer> search(String pattern, String text) {
        // potd.code.hub
        int hash = 0, code = 0;
        int n = text.length(), m = pattern.length();
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0;i < m;i++){
            hash += (pattern.charAt(i) - 'a' + 1);
        }

        for (int i = 0;i < n;i++) {
            if (i >= m) {
                code -= (text.charAt(i - m) - 'a' + 1);
            }
            code += (text.charAt(i) - 'a' + 1);

            if (i >= m-1 && hash == code){
                boolean flag = true;
                for (int x = 0;x < m;x++) {
                    if (text.charAt(i - m + 1 + x) != pattern.charAt(x)){
                        flag = false;
                        break;
                    }
                }
                if (flag) ans.add(i-m+2);
            }
        }

        return ans;
    }
}
