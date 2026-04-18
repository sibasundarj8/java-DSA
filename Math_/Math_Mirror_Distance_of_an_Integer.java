package Math_;/*
 *
 * https://leetcode.com/problems/mirror-distance-of-an-integer/
 *
 * # 3783. Mirror Distance of an Integer
 *
 *   Q. You are given an integer n.
 *
 *          ◦ Define its mirror distance as: abs(n - reverse(n)) where reverse(n) is the integer formed by reversing the
 *            digits of n.
 *          ◦ Return an integer denoting the mirror distance of n.
 *          ◦ abs(x) denotes the absolute value of x.
 *
 *    Ex.
 *      Input : n = 25
 *      Output: 27
 *      Explanation:
 *              reverse(25) = 52.
 *              Thus, the answer is abs(25 - 52) = 27.
 *
 *  Constraints:
 *          1 <= n <= 10⁹
 */

import java.util.Scanner;

public class Math_Mirror_Distance_of_an_Integer {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number: ");
        int num = sc.nextInt();

        System.out.println("Distance from " + num + " to mirror(" + num + "): ");
        System.out.println(mirrorDistance(num));
    }

    /// Solution
    static int mirrorDistance(int n) {
        // potd.code.hub
        int orgNum = n;
        int mirror = 0;

        while (n > 0) {
            mirror = mirror * 10 + n % 10;
            n /= 10;
        }

        return Math.abs(mirror - orgNum);
    }
}
