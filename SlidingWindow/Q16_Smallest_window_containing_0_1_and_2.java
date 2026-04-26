package SlidingWindow;/*
 *
 * https://www.geeksforgeeks.org/problems/smallest-window-containing-0-1-and-2--170637/1
 *
 * # Smallest window containing 0, 1 and 2
 *
 *   Q. Given a string s consisting only of the characters '0', '1' and '2', determine the length of the smallest substring
 *      that contains all three characters at least once.
 *
 *      If no such substring exists, return -1.
 *
 *    Ex.
 *      Input : s = "10212"
 *      Output: 3
 *      Explanation: The substring "102" is the shortest substring that contains all three characters '0', '1', and '2',
 *                   so the answer is 3.
 *
 *  Constraints:
 *          1 ≤ s.size() ≤ 10⁵
 */

import java.util.Scanner;

public class Q16_Smallest_window_containing_0_1_and_2 {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number containing 0, 1, 2");
        String s = sc.next();

        System.out.println("Length of smallest sub-string containing 0, 1, 2: ");
        System.out.println(smallestSubstring(s));
    }

    /// Solution
    static int smallestSubstring(String s) {
        // potd.code.hub
        int n = s.length();
        int count = 0;
        int res = Integer.MAX_VALUE;
        int l = 0;
        int[] freq = new int[3];

        for (int r = 0; r < n; r++) {
            int idx = s.charAt(r) - '0';

            if (freq[idx] == 0) count++;
            freq[idx]++;

            while (count == 3) {
                res = Math.min(res, r - l + 1);

                idx = s.charAt(l) - '0';
                freq[idx]--;
                if (freq[idx] == 0) count--;

                l++;
            }
        }

        return (res == Integer.MAX_VALUE) ? -1 : res;
    }
}
