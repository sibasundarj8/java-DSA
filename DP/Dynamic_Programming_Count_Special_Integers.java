package DP;/*
 *
 * https://leetcode.com/problems/count-special-integers/
 *
 * # LC. 2376. Count Special Integers
 *
 *   Q. We call a positive integer special if all of its digits are distinct. Given a positive integer n, return the number
 *      of special integers that belong to the interval [1, n].
 *
 *    Ex.
 *      Input : n = 20
 *      Output: 19
 *      Explanation: All the integers from 1 to 20, except 11, are special. Thus, there are 19 special integers.
 *
 *  Constraints:
 *          1 <= n <= 2 * 10⁹
 */

import java.util.Arrays;
import java.util.Scanner;

public class Dynamic_Programming_Count_Special_Integers {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("n: ");
        int n = sc.nextInt();

        System.out.print("count of special integers: ");
        System.out.println(countSpecialNumbers(n));
    }

    /// Solution
/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯-Digit-DP-⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : TC = O(D * 2¹⁰ * 10)
SC : O(D * 2¹⁰)
*/
    static int approach_1(int n) {
        // potd.code.hub
        String number = Integer.toString(n);
        int len = number.length();
        int[][][][] dp = new int[len][1 << 10][2][2];

        for (int[][][] a : dp) {
            for (int[][] b : a) {
                for (int[] c : b) {
                    Arrays.fill(c, -1);
                }
            }
        }

        return solve(0, 0, 1, 1, number, len, dp);
    }

    private static int solve(int idx, int bitMask, int lz, int tight, String number, int size, int[][][][] dp) {
        // base case
        if (idx == size) {
            return (lz == 0) ? 1 : 0;
        }

        if (dp[idx][bitMask][lz][tight] != -1) {
            return dp[idx][bitMask][lz][tight];
        }

        // recursive case
        int total = 0;
        int up = (tight == 1) ? number.charAt(idx) - '0' : 9;

        /*
            Here we have to check weather the digit used or not.
            We need an array or hashset to track that but can't use DP with array or hashset as parameter.
            So we need a number which bocome a state of DP, and we need only 9 spaces to store,
            that's why I choose bitmasking. If I use digit x then I will set x'th bit.
            And before using a digit I will check that bit is already set or not.
            LZ -> leading zeros which tells me wheather it is leading zero or not.
        */
        for (int i = 0; i <= up; i++) {
            if (lz == 0 && (bitMask & (1 << i)) > 0) {
                continue;
            }

            int newMask = (lz == 1 && i == 0) ? bitMask : (bitMask | (1 << i));
            int newLz = (lz == 1 && i == 0) ? 1 : 0;
            int newTight = (tight == 1 && i == up) ? 1 : 0;

            total += solve(idx + 1, newMask, newLz, newTight, number, size, dp);
        }

        return dp[idx][bitMask][lz][tight] = total;
    }

/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯--combinatorics-/-permutation-counting--⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC = O(D²)
SC = O(D)
*/
    static int countSpecialNumbers(int n) {
        // potd.code.hub
        String number = Integer.toString(n);
        int len = number.length();
        int total = 0;
        int mul = 1;

        /*
            I divided the problem into 2 parts.
            for example if number is 48025 then
                part - 1  ---> 1 to 9999 (all 1-digit numbers + all 2-digit numbers +...+ all 4-digit numbers)
                part - 2  ---> 10000 to 48025 (remaining 5-digit numbers)

            I solved part - 1 using combinatorics formula and part - 2 using recursion
        */

        // part - 1
        for (int i = 0; i <= len - 2; i++) {
            int p = (i == 0) ? 9 : 10 - i;
            mul *= p;
            total += mul;
        }

        // part - 2
        return total + solve(0, 1, 0, len, number);
    }

    private static int solve(int idx, int tight, int mask, int size, String number) {
        // base case
        if (idx == size) {
            return 1;
        }

        // recursive case
        if (tight == 0) {
            return (10 - idx) * solve(idx + 1, tight, mask, size, number);
        }

        int total = 0;
        int lb = (idx == 0) ? 1 : 0;
        int ub = number.charAt(idx) - '0';

        for (int i = lb; i <= ub; i++) {
            if ((mask & (1 << i)) != 0) continue;
            int newTight = (tight == 1 && i == ub) ? 1 : 0;
            int newMask = mask | (1 << i);
            total += solve(idx + 1, newTight, newMask, size, number);
        }

        return total;
    }
}
