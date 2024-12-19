package GFG_160.Bonus_Problems;/*
 *
 * https://www.geeksforgeeks.org/problems/square-root/0
 *
 * # Square Root
 *
 *   Q. Given a positive integer n, find the square root of n. If n is not a perfect square, then return the
 *      floor value.
 *
 *      Floor value of any number is the greatest Integer which is less than or equal to that number.
 *    Ex.
 *      Input : n = 11
 *      Output: 3
 *      Explanation: Since, 11 is not a perfect square, floor of square root of 11 is ±3.
 */
import java.util.Scanner;

public class Searching_04_Square_Root {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number: ");
        int n = sc.nextInt();

        System.out.println(floorSqrt(n));
    }

    /// Solution
    static int floorSqrt(int n) {
        // potd.code.hub
        int i = 0, j = n;
        while (i <= j){
            int mid = i + (j-i)/2;
            if (mid * mid <= n) i = mid+1;
            else j = mid-1;
        }

        return j;
    }
}
