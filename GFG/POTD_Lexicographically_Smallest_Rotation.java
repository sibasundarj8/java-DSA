package GFG;/*
 *
 * https://www.geeksforgeeks.org/problems/lexicographically-smallest-string--151951/1
 *
 * # Lexicographically Smallest Rotation
 *
 *   Q. Given a string s, find the lexicographically smallest string after rotating the string left any number of
 *      times including 0.
 *
 *    Ex.
 *      Input : s = "abcd"
 *      Output: "abcd"
 *      Explanation: String after each rotation are "abcd", "bcda", "cdab", "dabc" and so on.
 *                   Lexicographically smallest among them is "abcd".
 *
 *  Constraints:
 *        ◦ 1 ≤ s.size() ≤ 10⁶
 *        ◦ s consists only of lowercase English alphabets
 */

import java.util.Scanner;

public class POTD_Lexicographically_Smallest_Rotation {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("String s: ");
        String s = sc.next();

        System.out.println("Lexicographically smallest among them is: ");
        System.out.println(lexiString(s));
    }

    /// Solution
    static String lexiString(String s1) {
        // potd.code.hub
        int n = s1.length();
        int m = n << 1;
        char[] s = new char[m];

        for (int i = 0; i < m; i++) {
            s[i] = s1.charAt(i % n);
        }

        int i = 0;
        int j = 1;
        int k = 0;

        while (i < n && j < n && k < n) {
            int idx1 = i + k;
            int idx2 = j + k;

            if (idx1 == idx2) {
                i++;
                k = 0;
            } else if (s[idx1] < s[idx2]) {
                j += k + 1;
                k = 0;
            } else if (s[idx1] > s[idx2]) {
                i += k + 1;
                k = 0;
            } else {
                k++;
            }
        }

        return String.valueOf(s, Math.min(i, j), n);
    }
}
