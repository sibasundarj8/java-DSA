package Greedy;/*
 *
 * https://www.geeksforgeeks.org/problems/string-stack--165812/1
 *
 *   Q. You are given two strings pat and tar consisting of lowercase English characters. You can
 *      construct a new string s by performing any one of the following operation for each character
 *      in pat:
 *
 *         •   Append the character pat[i] to the string s.
 *         •   Delete the last character of s (if s is empty do nothing).
 *
 *      After performing operations on every character of pat exactly once, your goal is to determine
 *      if it is possible to make the string s equal to string tar.
 *  Ex.
 *      Input : pat = "agiffghd", tar = "gfg"
 *      Output: true
 *      Explanation: Skip the first character 'a' in pat. Append 'g' and 'i' to s, resulting in s = "gi".
 *                   Delete the last character for 'f', leaving s = "g". Append 'f', 'g', and 'h' to s,
 *                   resulting in s = "gfgh". Finally, delete the last character for 'd', leaving s = "gfg",
 *                   which matches tar.
 *
 *   Constraints:
 *      1 ≤ pat.size(), tar.size() ≤ 10⁵
 */

import java.util.Scanner;

public class G05_String_stack {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("pat: ");
        String pat = sc.next();

        System.out.print("tar: ");
        String tar = sc.next();

        System.out.println(stringStack("Conversion possible: " + pat, tar));
    }

    /// Solution
    static boolean stringStack(String pat, String tar) {
        int n = pat.length();
        int m = tar.length();

        int j = m - 1;
        int next = n;

        for (int i = n - 1; i >= 0; i--) {
            if (pat.charAt(i) == tar.charAt(j) && (next - i) % 2 == 1) {
                next = i;
                j--;

                if (j == -1) return true;
            }
        }

        return false;
    }
}
