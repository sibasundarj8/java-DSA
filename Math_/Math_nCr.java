package Math_;/*
 *
 * https://www.geeksforgeeks.org/problems/ncr1019/1
 *
 * # nCr
 *
 *   Q. Given two integer values n and r, the task is to find the value of Binomial Coefficient nCr
 *
 *      A binomial coefficient nCr can be defined as the coefficient of xr in the expansion of (1 + x)n that
 *      gives the number of ways to choose r objects from a set of n objects without considering the order.
 *
 *      The binomial coefficient nCr is calculated as : C(n,r) = n! / r! * (n-r) !
 *
 *      Note: If r is greater than n, return 0.
 *
 *      It is guaranteed that the value of nCr will fit within a 32-bit integer.
 *   Ex.
 *      Input : n = 5
 *              r = 2
 *      Output: 10
 *      Explanation: The value of 5C2 is calculated as 5!/(5−2)!*2! = 5!/3!*2! = 10.
 */

import java.util.Scanner;

public class Math_nCr {

    /// main Method
    public static void main(String[] args) {
        int n, r;
        Scanner sc = new Scanner(System.in);

        System.out.print("n : ");
        n = sc.nextInt();

        System.out.print("r : ");
        r = sc.nextInt();

        System.out.println("ⁿCʀ : " + nCr(n, r));
    }

    /// Solution
    static int nCr(int n, int r) {
        // potd.code.hub
        if (n < r) return 0;
        if (n == r) return 1;

        int m = Math.min(r, n - r);
        long ans = 1;

        for (int i = 0; i < m; i++) {
            ans *= n - i;
            ans /= i + 1;
        }

        return (int) ans;
    }
}
