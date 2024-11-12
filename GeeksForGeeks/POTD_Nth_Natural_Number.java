/*
 *   Q. Given a positive integer n. You have to find nth natural number after removing all the numbers
 *      containing digit 9.
 *
 *      Examples:
 *              Input : n = 9
 *              Output: 10
 *         Explanation: After removing natural numbers that contain digit 9, the first 9 numbers are
 *                      1,2,3,4,5,6,7,8,10 and the 9th number is 10.
 */
package GFG;

import java.util.Scanner;

public class POTD_Nth_Natural_Number {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("N : ");
        long n = sc.nextInt();
        System.out.println(findNth(n));
    }
    static long findNth(long n) {
        // potd.code.hub
        long ans = 0;
        // Decimal to Nonary(0,1,2,3,4,5,6,7,8)
        for (long i = 1L;n > 0;n/=9){
            ans += n%9 * i;
            i *= 10;
        }
        return ans;
    }
}