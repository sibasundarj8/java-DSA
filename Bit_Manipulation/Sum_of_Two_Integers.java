package Bit_Manipulation;/*
 *
 * https://leetcode.com/problems/sum-of-two-integers/
 *
 * # LC 371. Sum of Two Integers
 *
 *   Q. Given two integers a and b, return the sum of the two integers without using the operators + and -.
 *   Ex.
 *      Input : a = 1, b = 2
 *      Output: 3
 *
 *  Constraints:
 *          -1000 <= a, b <= 1000
 */

import java.util.Scanner;

public class Sum_of_Two_Integers {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("a : ");
        int a = sc.nextInt();

        System.out.print("b : ");
        int b = sc.nextInt();

        System.out.println("a + b = " + getSum(a, b));
    }

    /// Solution
    static int getSum(int a, int b) {
        int sum = 0;
        int c = 0;

        for (int i = 0; i < 32; i++) {
            int i1 = 1 & (a >> i);
            int i2 = 1 & (b >> i);
            
            sum = sum | ((i1 ^ i2 ^ c) << i);
            c = (i1 & i2) | (i1 & c) | (i2 & c);
        }
        
        return sum;
    }
}
