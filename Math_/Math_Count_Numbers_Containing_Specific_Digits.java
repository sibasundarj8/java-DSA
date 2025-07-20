package Math_;/*
 *
 * https://www.geeksforgeeks.org/problems/count-numbers-containing-specific-digits/1
 *
 * # Count Numbers Containing Specific Digits
 *
 *   Q. You are given an integer n representing the number of digits in a number, and an array arr[] containing
 *      digits from 0 to 9. Your have to count how many n-digit positive integers can be formed such that at least
 *      one digit from the array arr[] appears in the number.
 *    Ex.
 *      Input : n = 2, arr[] = [3, 5]
 *      Output: 34
 *      Explanation: There are a total of 34 two-digit numbers which contain at-least  one out of  [3, 5].
 *    
 *    constrains: 
 *        1 <= n <= 9
 *        1 <= arr.length <= 9
 *        0 <= arr[i] <= 9
 */

import java.util.Scanner;

public class Math_Count_Numbers_Containing_Specific_Digits {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the digits which we are use to form a number: ");
        String[] s = sc.nextLine().split(" ");

        int m = s.length;
        int[] arr = new int[m];

        for (int i = 0; i < m; i++)
            arr[i] = Integer.parseInt(s[i]);

        System.out.println("Enter the number of digits in the number: ");
        int n = sc.nextInt();

        System.out.println("\nCount of valid number can be formed: ");
        System.out.println(countValid(n, arr));
    }

    /// Solution
    static int countValid(int n, int[] arr) {
        // potd.code.hub
        int totalNumber = (int) (Math.pow(10, n) - Math.pow(10, n - 1));
        int extraDigit = 10 - arr.length;
        int withoutDigit = (hasZero(arr)) ?
                (int) Math.pow(extraDigit, n) :
                (int) Math.pow(extraDigit, n - 1) * (extraDigit - 1);

        return totalNumber - withoutDigit;
    }

    private static boolean hasZero(int[] arr) {
        for (int i : arr) if (i == 0) return true;
        return false;
    }
}
