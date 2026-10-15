package Bit_Manipulation;/*
 *
 * https://www.geeksforgeeks.org/problems/geek-hates-too-many-1s--170647/1
 *
 * # Maximum Without 3 Consecutive Set Bits
 *
 *   Q. Given a non-negative integer n, you can only change a set bit (1) to an unset bit (0). Find the maximum
 *      possible value of n such that its binary representation does not contain three consecutive set bits (111)
 *      after performing zero or more allowed operations.
 *
 *    Ex.
 *      Input : n = 7
 *      Output: 6
 *      Explanation: The binary representation of 7 is 111, which contains three consecutive set bits.
 *                   Changing the rightmost set bit to 0 gives: 111 -> 110. Thus, the maximum possible value is 6.
 *
 *  Constraints:
 *        ◦ 0 ≤ n ≤ 10⁹
 */

import java.util.Scanner;

public class Maximum_Without_3_Consecutive_Set_Bits {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("n: ");
        int n = sc.nextInt();

        System.out.print("""
                Maximum possible value of n such that,
                it does not contain three consecutive set bits (111):
                """);
        System.out.println(maxValue(n));
    }

    /// Solution
    static int maxValue(int n) {
        // potd.code.hub
        int cnt = 0;

        for (int i = 30; i >= 0; i--) {
            int bit = (n >> i) & 1;

            if (bit == 1) {
                if (++cnt == 3) {
                    n ^= (1 << i);
                    cnt = 0;
                }
            } else cnt = 0;
        }

        return n;
    }
}
