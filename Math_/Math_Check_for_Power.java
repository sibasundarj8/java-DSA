package Math_;/*
 *
 * https://www.geeksforgeeks.org/problems/check-if-a-number-is-power-of-another-number5442/1
 *
 * # Check for Power
 *
 *   Q. Given two positive integers x and y, determine if y is a power of x. If y is a power of x, return true. Otherwise,
 *      return false.
 *    Ex.
 *      Input : x = 2, y = 8
 *      Output: true
 *      Explanation: 23 is equal to 8.
 *
 *  Constraints:
 *          1 ≤ x ≤ 10³
 *          1 ≤ y ≤ 10⁹
 */

import java.util.Scanner;

public class Math_Check_for_Power {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("x : ");
        int x = sc.nextInt();

        System.out.print("y : ");
        int y = sc.nextInt();

        System.out.println("IsPower: " + isPower(x, y));
    }

    /// Solution
    static boolean isPower(int x, int y) {
        // potd.code.hub
        if (x == 1) return y == 1;

        while (y % x == 0) {
            y = y / x;
        }

        return y == 1;
    }
}
