package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/missing-number-in-array1416/1
 *
 * # Missing in Array
 *
 *   Q. You are given an array arr[] of size n - 1 that contains distinct integers in the range
 *      from 1 to n (inclusive). This array represents a permutation of the integers from 1 to n
 *      with one element missing. Your task is to identify and return the missing element.
 *   Ex.
 *      Input : arr[] = [8, 2, 4, 5, 3, 7, 1]
 *      Output: 6
 *      Explanation: All the numbers from 1 to 8 are present except 6.
 */

import java.util.Scanner;

public class GFG_158_Missing_in_Array {

    /// main Methods
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Array Elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.println("Missing: " + missingNum(arr));
    }

    /// Solution
    static int missingNum(int[] arr) {
        // potd.code.hub
        int n = arr.length;
        int xor = 0;

        for (int i = 0; i < n; i++)
            xor ^= (i + 1) ^ arr[i];

        return xor ^ (n + 1);
    }
}
