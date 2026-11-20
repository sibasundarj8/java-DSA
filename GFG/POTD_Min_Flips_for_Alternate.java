package GFG;/*
 *
 * https://www.geeksforgeeks.org/problems/min-number-of-flips3210/1
 *
 * # Min Flips for Alternate
 *
 *   Q. Given a binary string s, we can flip any bit (change 0 to 1 or 1 to 0) to make the string alternating.
 *      A string is called alternating if no two adjacent characters are the same.
 *
 *      Find the minimum number of bit flips required to make the string alternating.
 *
 *    Ex.
 *      Input : s = "0001010111"
 *      Output: 2
 *      Explanation: Flip the bit at indices 1 and 8 to obtain "0101010101", which is an alternating binary string.
 *                   Hence, the minimum number of flips required is 2.
 *
 *  Constraints:
 *        ◦ 1 ≤ s.size() ≤ 10⁵
 *        ◦ s consists only of the characters 0 and 1
 */

import java.util.Scanner;

public class POTD_Min_Flips_for_Alternate {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("binary string: ");
        String s = sc.next();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch != '0' && ch != '1') {
                throw new IllegalArgumentException("Invalid input");
            }
        }

        System.out.println("Minimum number of bit flips required to make the string alternating:");
        System.out.println(minFlips(s));
    }

    /// Solution
    static int minFlips(String s) {
        // potd.code.hub
        int n = s.length();
        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < n; i++) {
            char cur = s.charAt(i);
            boolean oddIdx = (i & 1) == 1;

            if (oddIdx && cur == '0' || !oddIdx && cur == '1') count1++;
            if (oddIdx && cur == '1' || !oddIdx && cur == '0') count2++;
        }

        return Math.min(count1, count2);
    }
}
