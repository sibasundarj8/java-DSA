package GFG;/*
 *
 * https://www.geeksforgeeks.org/problems/the-pattern-matcher/1
 *
 * # Repeated Pattern Check
 *
 *   Q. Given a string s made of two characters of 'x' and 'y'.  The task is to verify whether s is made by
 *      concatenating substrings that follow the pattern xⁿyⁿ  (equal number of y's follow equal number of x's).
 *
 *    Ex.
 *      Input: s = "xxyyxy"
 *      Output: true
 *      Explanation: The string can be split into "xxyy" + "xy". Both substrings contain an equal number of
 *                   consecutive 'x' and 'y' characters.
 *
 *  Constraints:
 *        ◦ 1 ≤ s.size() ≤ 10⁵
 *        ◦ s consists only of the characters x and y
 */

import java.util.Scanner;

public class POTD_Repeated_Pattern_Check {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("S: (x or y allowed)");
        String s = sc.next();

        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch != 'x' && ch != 'y') {
                throw new IllegalArgumentException("Not a valid input");
            }
        }

        System.out.println("is s made by concatenating substrings that follow the pattern xⁿyⁿ : ");
        System.out.println(findPattern(s));
    }

    /// Solution
    static boolean findPattern(String s) {
        // code here
        int n = s.length();
        char ch = s.charAt(0);
        int x = (ch == 'x') ? 1 : 0;
        int y = (ch == 'y') ? 1 : 0;

        for (int i = 1; i < n; i++) {
            ch = s.charAt(i);

            if (ch == 'x' && s.charAt(i - 1) == 'y') {
                if (x != y) return false;
                x = 1;
                y = 0;
            } else {
                if (ch == 'x') x++;
                else y++;
            }
        }

        return x == y;
    }
}
