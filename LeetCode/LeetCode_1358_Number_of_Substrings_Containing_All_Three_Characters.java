package LeetCode;/*
 *
 * https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
 *
 * # 1358. Number of Substrings Containing All Three Characters
 *
 *   Q. Given a string s consisting only of characters a, b and c.
 *
 *      Return the number of substrings containing at least one occurrence of all these characters
 *      a, b and c.
 *   Ex.
 *      Input: s = "aaacb"
 *      Output: 3
 *      Explanation: The substrings containing at least one occurrence of the characters a, b and
 *                   c are "aaacb", "aacb" and "acb".
 *
 *  Constraints:
 *      3 <= s.length <= 5 x 10⁴
 *      s only consists of a, b or c characters.
 */

import java.util.Arrays;
import java.util.Scanner;

public class LeetCode_1358_Number_of_Substrings_Containing_All_Three_Characters {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Word which should only contains 'a', 'b', 'c'.");
        String s = sc.next();

        System.out.println("Number of sub-strings which contains a, b, c at least once: ");
        System.out.println(numberOfSubstrings(s));
    }

    /// Solution
    static int numberOfSubstrings(String s) {
        // potd.code.hub
        int n = s.length();
        int a = -1;
        int b = -1;
        int c = -1;
        int count = 0;

        for (int i = 0; i < n; i++) {
            char curr = s.charAt(i);

            // storing the last seen of a, b, c
            if (curr == 'a') a = i;
            else if (curr == 'b') b = i;
            else c = i;

            // smallest valid sub-string whose last index is i
            count += (Math.min(a, Math.min(b, c)) + 1);
        }

        return count;
    }
}
