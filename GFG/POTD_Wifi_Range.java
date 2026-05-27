package GFG;/*
 *
 * https://www.geeksforgeeks.org/problems/wifi-range--170647/1
 *
 * # Wi-Fi Range
 *
 *   Q. There are n rooms in a straight line in GeekLand State University's hostel. You are given a binary string s of
 *      length n, where s[i] = '1' means there is a Wi-Fi router in the i-th room, and s[i] = '0' means there is no Wi-Fi
 *      in that room.
 *
 *      Each Wi-Fi router has a range of x, meaning it can cover up to x rooms to its left and x rooms to its right.
 *
 *      Given x and s, determine whether all rooms are covered by at least one Wi-Fi router. Return true if all rooms are
 *      covered; otherwise, return false.
 *
 *    Ex.
 *      Input: x = 1, s = "10010"
 *      Output: true
 *      Explanation:
 *                ◦ Index 0: Wi-Fi is available.
 *                ◦ Index 1: Since the range of the 0th index is 1, Wi-Fi is available here.
 *                ◦ Index 2: Since the range of the 3rd index is 1, Wi-Fi is also available here.
 *                ◦ Index 3: Wi-Fi is available.
 *                ◦ Index 4: The range of the 3rd index covers this position.
 *              So, all the rooms have Wi-Fi. Therefore, the answer is true for this test case.
 *
 *  Constraints:
 *          1 ≤ n ≤ 10⁵
 *          0 ≤ x ≤ 10⁵
 */

import java.util.Scanner;

public class POTD_Wifi_Range {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter binary string: ");
        String s = sc.next();

        System.out.println("Enter x : ");
        int x = sc.nextInt();

        System.out.println("Are all rooms covered : ");
        System.err.println(wifiRange(s, x) ? "YES" : "NO");
    }

    /// Solution
/*
☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒-Prefix/Suffix-Nearest-Router-Arrays-☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒
TC : O(n)
SC : O(n)
*/
    static boolean approach_1(String s, int x) {
        // potd.code.hub
        int n = s.length();
        int[] nextRouter = new int[n];
        int[] prevRouter = new int[n];

        prevRouter[0] = (int) -1e6;
        nextRouter[n - 1] = (int) 1e6;

        if (s.charAt(0) == '1') {
            prevRouter[0] = 0;
        }

        if (s.charAt(n - 1) == '1') {
            nextRouter[n - 1] = n - 1;
        }

        for (int i = 1; i < n; i++) {
            prevRouter[i] = s.charAt(i) == '1' ? i : prevRouter[i - 1];
            nextRouter[n - 1 - i] = s.charAt(n - 1 - i) == '1' ? n - 1 - i : nextRouter[n - i];
        }

        for (int i = 0; i < n; i++) {
            if (i - prevRouter[i] > x && nextRouter[i] - i > x) {
                return false;
            }
        }

        return true;
    }

/*
☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑-Greedy-Interval-Coverage-☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑
TC : O(n)
SC : O(1)
*/
    static boolean wifiRange(String s, int x) {
        // potd.code.hub
        int n = s.length();
        int prvRight = -1;

        for (int i = 0; i < n; i++) {

            if (s.charAt(i) == '1') {
                int curLeft = i - x;
                int curRight = i + x;

                if (prvRight + 1 < curLeft) {
                    return false;
                }

                prvRight = curRight;
            }

        }

        return prvRight >= n - 1;
    }
}
