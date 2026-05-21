package Bit_Manipulation;/*
 *
 * https://www.geeksforgeeks.org/problems/check-set-bits5408/1
 *
 * # Check if All Bits Set
 *
 *   Q. Given a number n, check whether every bit in the binary representation of the given number is set or not.
 *      Return true if yes, otherwise false.
 *
 *    Ex.
 *      Input : n = 7
 *      Output: true
 *      Explanation: Binary for 7 is 111 all the bits are set so the output is true.
 *
 *  Constraints:
 *          0 ≤ n ≤ 10⁵
 */

import java.util.Scanner;

public class Check_if_All_Bits_Set {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int n = sc.nextInt();

        System.out.print("Are all bits set: ");
        System.err.println(isBitSet(n) ? "YES" : "NO");
    }

    /// Solution
    static boolean isBitSet(int n) {
        // potd.code.hub
        return (n > 0) && ((n & (n + 1)) == 0);
    }
}
