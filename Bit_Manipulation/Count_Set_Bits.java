package Bit_Manipulation;/*
 *
 * https://www.geeksforgeeks.org/problems/set-bits0143/1
 *
 * # Count Set Bits
 *
 *   Q. Given a positive integer n. Your task is to return the count of set bits.
 *
 *    Ex.
 *      Input: n = 6
 *      Output: 2
 *      Explanation: Binary representation is '110', so the count of the set bit is 2.
 *
 *  Constraints:
 *          1 ≤ n ≤ 10⁹
 */

import java.util.Scanner;

public class Count_Set_Bits {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int n = sc.nextInt();

        System.out.println("Number of set bits: ");
        System.out.println(setBits(n));
    }

    /// Solution
/*
-------------------------------------------------------brute-force-------------------------------------------------------
TC : O(log n)
SC : O(1)
*/
    static int approach_1(int n) {
        int count = 0;

        while (n != 0) {
            count += (n & 1);
            n = n >> 1;
        }

        return count;
    }

/*
-----------------------------------------------Brian-Kernighan's-Algorithm-----------------------------------------------
TC : O(k) where k = number of set bits
SC : O(1)
*/
    static int approach_2(int n) {
        // potd.code.hub
        int count = 0;

        while (n != 0) {
            n &= (n - 1);
            count++;
        }

        return count;
    }

/*
---------------------------------------------------Using-Lookup-table---------------------------------------------------
TC : O(1)
SC : O(1) (or O(256) auxiliary static storage)
*/
    static int setBits(int n) {
        // potd.code.hub
        return bitsSetTable256[n & 0xff] +
                bitsSetTable256[(n >> 8) & 0xff] +
                bitsSetTable256[(n >> 16) & 0xff] +
                bitsSetTable256[n >> 24];
    }

    // helper (don't remove static billow here)
    private static final int[] bitsSetTable256 = new int[256];

    static {
        bitsSetTable256[0] = 0;

        for (int i = 1; i < 256; i++) {
            bitsSetTable256[i] = bitsSetTable256[i & (i - 1)] + 1;
        }
    }
}
