package GFG;/*
 *
 * https://www.geeksforgeeks.org/problems/secret-cipher--141631/1
 *
 * # Secret Cipher
 *
 *   Q. Geek wants to send a secret message to his friend Keeg. Instead of sending the original message directly,
 *      he encrypts it by inserting the character '*'.
 *
 *      Keeg decodes the message as follows:
 *        ◦ Traverse the encoded string from left to right and initialize the original string as empty.
 *        ◦ Whenever a normal character appears, append it to the current original string.
 *        ◦ Whenever '*' is encountered, remove it and append all characters before it to the end of the current
 *          original string.
 *        ◦ Repeat until no '*' remains.
 *
 *      Given the original string s, find the lexicographically smallest encrypted string that decodes to s.
 *
 *    Ex.
 *      Input : s = "ababcababcd"
 *      Output: ab*c*d
 *      Explanation: We can encrypt the string in following way : "ababcababcd" -> "ababc*d" -> "ab*c*d"
 *
 *  Constraints:
 *        ◦ 1 ≤ |s| ≤ 10⁵
 */

import java.util.Scanner;

public class POTD_Secret_Cipher {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the string: ");
        String s = sc.next();

        System.out.println("Encrypted string: ");
        System.out.println(compress(s));
    }

    /// Solution
    static String compress(String s) {
        // pod.code.hub
        int n = s.length();
        int[] lps = new int[n];

        int l = 0;
        int r = 1;

        while (r < n) {
            if (s.charAt(l) == s.charAt(r)) lps[r++] = ++l;
            else if (l == 0) lps[r++] = 0;
            else l = lps[l - 1];
        }

        int i = n - 1;
        StringBuilder sb = new StringBuilder();

        while (i >= 0) {
            int len = i + 1;
            int half = len >> 1;
            int period = len - lps[i];

            if ((len & 1) == 0 && half % period == 0) {
                sb.append('*');
                i >>= 1;
            } else {
                sb.append(s.charAt(i--));
            }
        }

        return sb.reverse().toString();
    }
}

/*

    a b a b c a b a b -- string
    0 0 1 2 0 1 2 3 4 -- lps[]
    0 1 2 3 4 5 6 7 8 -- indices

    a b * * a b

 */
