package GFG;/*
 *
 * https://www.geeksforgeeks.org/problems/possible-pairs1550/1
 *
 * # Pairs with Given GCD and LCM
 *
 *   Q. Given two integers x and y representing the GCD and LCM of two unknown positive integers a and b, count the
 *      number of valid pairs (a, b) satisfying these conditions. Note that (a, b) and (b, a) are counted as distinct
 *      pairs when a ≠ b.
 *
 *    Ex.
 *      Input : x = 2, y = 12
 *      Output: 4
 *      Explanation: The valid pairs are (2, 12), (4, 6), (6, 4), and (12, 2), since each pair has GCD = 2 and LCM = 12.
 *
 *  Constraints:
 *      1 ≤ x, y ≤ 10⁴
 */

import java.util.Scanner;

public class POTD_Pairs_with_Given_GCD_and_LCM {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("x: ");
        int x = sc.nextInt();

        System.out.print("y: ");
        int y = sc.nextInt();

        System.out.println("Number of pairs whose gcd: " + x + " and lcm: " + y + " : ");
        System.out.println(pairCount(x, y));
    }

    /// Solution
    static int pairCount(int x, int y) {
        // potd.code.hub
        if (y % x != 0) return 0;
        if (x == y) return 1;

        int count = 0;
        int div = y / x;
        int q;

        for (int p = 1; p * p < div; p++) {
            if (div % p == 0) {
                q = div / p;

                if (gcd(p, q) == 1) {
                    count += 2;
                }
            }
        }

        return count;
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
