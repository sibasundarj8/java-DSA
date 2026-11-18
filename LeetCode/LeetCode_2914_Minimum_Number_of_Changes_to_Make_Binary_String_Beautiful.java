package LeetCode;/*
 *
 * https://leetcode.com/problems/minimum-number-of-changes-to-make-binary-string-beautiful/
 *
 * LC. 2914. Minimum Number of Changes to Make Binary String Beautiful
 *
 *   Q. You are given a 0-indexed binary string s having an even length.
 *
 *      A string is beautiful if it's possible to partition it into one or more substrings such that:
 *        ◦ Each substring has an even length.
 *        ◦ Each substring contains only 1's or only 0's.
 *
 *      You can change any character in s to 0 or 1.
 *
 *      Return the minimum number of changes required to make the string s beautiful.
 *
 *    Ex.
 *      Input : s = "1001"
 *      Output: 2
 *      Explanation: We change s[1] to 1 and s[3] to 0 to get string "1100".
 *                   It can be seen that the string "1100" is beautiful because we can partition it into "11|00".
 *                   It can be proven that 2 is the minimum number of changes needed to make the string beautiful.
 *
 *  Constraints:
 *        ◦ 2 <= s.length <= 10⁵
 *        ◦ s has an even length.
 *        ◦ s[i] is either '0' or '1'.
 */

import java.util.Scanner;

public class LeetCode_2914_Minimum_Number_of_Changes_to_Make_Binary_String_Beautiful {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("binary String: ");
        String s = sc.next();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch != '0' && ch != '1') {
                throw new IllegalArgumentException("Invalid input");
            }
        }

        System.out.println("Minimum number of changes required to make the string s beautiful: ");
        System.out.println(minChanges(s));
    }

    /// Solution
    static int minChanges(String s) {
        int n = s.length();
        int changesCount = 0;

        for (int i = 1; i < n; i += 2) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                changesCount++;
            }
        }

        return changesCount;
    }
}
