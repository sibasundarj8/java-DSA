package StringBuilder;/*
 *
 * https://www.geeksforgeeks.org/problems/urlify-a-given-string--141625/1
 *
 * # URLify a given string
 *
 *   Q. Given a string s, replace all the spaces in the string with '%20'.
 *    Ex.
 *      Input : s = "i love programming"
 *      Output: "i%20love%20programming"
 *      Explanation: The 2 spaces are replaced by '%20'
 *
 *  Constraints:
 *          1 ≤ s.size() ≤ 10⁴
 */

import java.util.Scanner;

public class SB4_URLify_a_given_string {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter String: ");
        String s = sc.nextLine();

        System.out.println("URLify version: ");
        System.out.println(URLify(s));
    }

    /// Solution
    static String URLify(String s) {
        // potd.code.hub
        int n = s.length();
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            sb.append((ch == ' ') ? "%20" : ch);
        }

        return sb.toString();
    }
}
