package Bit_Manipulation;/*
 *
 * https://www.geeksforgeeks.org/problems/count-total-set-bits-1587115620/1
 *
 * # Count set bits
 *
 *   Q. You are given a number n. Find the total count of set bits for all numbers from 1 to n (both inclusive).
 *    Ex.
 *      Input : n = 4
 *      Output: 5
 *      Explanation: For numbers from 1 to 4. for 1: 0 0 1 => 1 set bit, for 2: 0 1 0 => 1 set bit, for 3: 0 1 1 => 2 set
 *                   bits, for 4: 1 0 0 => 1 set bit. Therefore, the total set bits are 5.
 *  Constraints:
 *          1 ≤ n ≤ 10⁸
 */

import java.util.Scanner;

public class Count_set_bits {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number: ");
        int n = sc.nextInt();

        System.out.println("Total number of set-bits form 1 to " + n + " : ");
        System.out.println(countSetBits(n));
    }

    /// Solution
    public static int countSetBits(int n) {
        // potd.code.hub
        int count = 0;
        int mst = (int) (Math.log(n) / Math.log(2)) + 1;

        for (int i = 0; i < mst; i++) {
            int startEle = 1 << i;
            int pow = 2 * startEle;
            int totalEle = n - startEle + 1;

            int t1 = totalEle % pow;
            int t2 = (totalEle - t1) / 2;

            count += t2;
            count += Math.min(startEle, t1);
        }

        return count;
    }
}
