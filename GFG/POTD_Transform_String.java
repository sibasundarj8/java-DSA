package GFG;/*
 *
 * https://www.geeksforgeeks.org/problems/transform-string5648/1
 *
 * # Transform String
 *
 *   Q. Given two strings s1 and s2. Find the minimum number of steps required to transform string s1 into string s2.
 *      The only allowed operation for the transformation is selecting a character from string s1 and inserting it in
 *      the beginning of string s1.
 *
 *      If transformation is not possible return -1.
 *
 *    Ex.
 *      Input: s1 = "GeeksForGeeks", s2 = "ForGeeksGeeks"
 *      Output: 3
 *      Explanation: The conversion can take place in 3 operations:
 *                     ◦ Pick 'r' and place it at the front.
 *                       s1 = "rGeeksFoGeeks"
 *
 *                     ◦ Pick 'o' and place it at the front.
 *                       s1 = "orGeeksFGeeks"
 *
 *                     ◦ Pick 'F' and place it at the front.
 *                       s1 = "ForGeeksGeeks"
 *
 *  Constraints:
 *      1 <= s1.length(), s2.length() <= 10⁴
 */

import java.util.Scanner;

public class POTD_Transform_String {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("s1: ");
        String s1 = sc.next();

        System.out.print("s2: ");
        String s2 = sc.next();

        System.out.println("Minimum number of steps required to transform s1 into s2: ");
        System.out.println(transform(s1, s2));
    }

    /// Solution
    static int transform(String s1, String s2) {
        // potd.code.hub
        int n = s1.length();
        int m = s2.length();

        if (n != m) return -1;

        int count = 0;
        int i = n - 1;
        int j = m - 1;
        int[] freq = new int[125];

        while(i >= 0) {
            int s1_idx = s1.charAt(i);
            int s2_idx = s2.charAt(i);

            freq[s1_idx]++;
            freq[s2_idx]--;

            if (s1.charAt(i) == s2.charAt(j)) j--;
            else count++;

            i--;
        }

        for (i = 0; i < 125; i++) {
            if (freq[i] != 0) return -1;
        }

        return count;
    }
}

/*

ex-1
-----
dcba
abcd --> bacd --> cbad --> dcba
 ^         ^         ^

ex-2
-----
abcd
dabc --> cdab --> bcda --> abcd
   ^        ^        ^

[note]: Possible to transform if all the characters in s1 are available
        with exact frequency in s2.

If possible, then how we know at-least how much operation we need ?
[ans] --> I think to traverse in reverse order and trake which are not matching
          with s2.

          something like!

          int count = 0;
          int i = s1.length() - 1;
          int j = s2.length() - 1;

          while(i >= 0) {
              if (s1.charAt(i) == s2.charAt(j)) {
                  count++;
                  j--;
              }
              i--;
          }

          return count;

*/
