package Math_;/*
 *
 * https://www.geeksforgeeks.org/problems/lcm-triplet1501/1
 *
 * # LCM Triplet
 *
 *   Q. Given a number n. Find the maximum possible LCM that can be obtained by selecting three numbers less than
 *      or equal to n.
 *      Note : LCM stands for Lowest Common Multiple.
 *    Ex.
 *      Input : n = 9
 *      Output: 504
 *      Explanation: 504 is the maximum LCM that can be attained by any triplet of numbers less than or equal 9.
 *                   The triplet which has this LCM is {7, 8, 9}.
 */

import java.util.Scanner;

public class Math_LCM_Triplet {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("N: ");
        int n = sc.nextInt();

        System.out.println("Largest LCM of triplet possible: " + lcmTriplets(n));
    }

    /// Solution
    static int lcmTriplets(int n) {
        // potd.code.hub
        if (n <= 2) return n;
        
        if ((n & 1) == 1) {                 // odd
            return n * (n - 1) * (n - 2);
        } else if (n % 3 == 0) {            // divisible by 6 
            return (n - 1) * (n - 2) * (n - 3);
        } else {                            // even and not divisible by 6
            return n * (n - 1) * (n - 3);
        }
    }
}
