package GFG;/*
 *
 * https://www.geeksforgeeks.org/problems/count-even-length1907/1
 *
 * # Binary Strings with Equal Sum of Two Halves
 *
 *   Q. Given a number n, find count of all binary sequences of length 2n such that sum of first n bits is same as sum of
 *      last n bits.
 *
 *      Note: Since the answer can be very large, so return the answer modulo 10⁹+7.
 *
 *    Ex.
 *      Input : n = 2
 *      Output: 6
 *      Explanation: There are 6 sequences of length 2*n, the sequences are 0101, 0110, 1010, 1001, 0000 and 1111.
 *
 *  Constraints:
 *      1 ≤ n ≤ 10⁵
 */

import java.util.Scanner;

public class POTD_Binary_Strings_with_Equal_Sum_of_Two_Halves {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter N: ");
        int n = sc.nextInt();

        System.out.println("""
                Count of binary sequences of length 2n such that
                sum of first n bits is same as sum of last n bits:""");
        System.out.println(computeValue(n));
    }

    /// Solution
    private static final int MOD = (int) (1e9 + 7);

    static int computeValue(int n) {
        // potd.code.hub
        int up = n << 1;
        long comb = 1;

        // counting ²ⁿCₙ

        for (int i = 0; i < n; i++) {
            int modInv = power(i + 1, MOD - 2);
            
            // modular multiplication
            comb = (comb * (up - i)) % MOD; 
            
            // modular division => multiply with modular inverse.  ~ Format's little theorem
            comb = (comb * modInv) % MOD; 
        }

        return (int) comb;
    }

    private static int power(int a, int n) {
        // base case
        if (n == 0) return 1;

        // recursive work
        long sub_problem = power(a, n / 2);

        // self work
        int res = (int) ((sub_problem * sub_problem) % MOD);
        if ((n & 1) == 1) return (int) ((res * (long) a) % MOD);
        else return res;
    }
}
