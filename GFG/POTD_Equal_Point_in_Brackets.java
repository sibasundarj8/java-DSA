package GFG;/*
 *
 * https://www.geeksforgeeks.org/problems/find-equal-point-in-string-of-brackets2542/1
 *
 * # Equal Point in Brackets
 *
 *   Q. Given a string s of opening and closing brackets '(' and ')' only, find an equal point in the string. An equal point
 *      is a position k (0-based) such that the number of opening brackets before position k is equal to the number of closing
 *      brackets from position k to the end of the string. If multiple such points exist, return the first valid position.
 *
 *        ◦ The string can be split at any position from 0 to n, where n is the length of the string.
 *        ◦ If we split at 0, it means there is an empty string on left.
 *        ◦ If we split at n, it means there is an empty string on right.
 *
 *    Ex.
 *      Input : s = "(())))("
 *      Output: 4
 *
 *  Constraints:
 *      1 ≤ s.size() ≤ 10⁵
 */

import java.util.Scanner;

public class POTD_Equal_Point_in_Brackets {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the brackets : ");
        String brackets = sc.next();

        System.out.println("the number of opening brackets before is equal to number of closing after the position: ");
        System.out.println(findIndex(brackets));
    }

    /// Solution
    static int findIndex(String s) {
        // potd.code.hub
        int n = s.length();
        int totalClosing = 0;
        int totalOpening = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == ')')
                totalClosing++;
        }

        for (int i = 0; i < n; i++) {
            if (totalOpening == totalClosing)
                return i;

            if (s.charAt(i) == '(')
                totalOpening++;
            else
                totalClosing--;
        }

        return n;
    }
}
