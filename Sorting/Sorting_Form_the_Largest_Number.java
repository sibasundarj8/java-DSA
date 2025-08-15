package Sorting;/*
 *
 * https://www.geeksforgeeks.org/problems/largest-number-formed-from-an-array1117/1
 *
 * # Form the Largest Number
 *
 *   Q. Given an array of integers arr[] representing non-negative integers, arrange them so that after
 *      concatenating all of them in order, it results in the largest possible number. Since the result
 *      may be very large, return it as a string.
 *    Ex.
 *      Input : arr[] = [54, 546, 548, 60]   
 *      Output: 6054854654
 *      Explanation: Given numbers are [54, 546, 548, 60], the arrangement [60, 548, 546, 54] gives the
 *                   largest value.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Sorting_Form_the_Largest_Number {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.println("Largest number: " + findLargest(arr));
    }

    /// Solution
    static String findLargest(int[] arr) {
        // potd.code.hub
        String[] str = new String[arr.length];

        // putting all the elements of arr to String array
        Arrays.setAll(str, i -> String.valueOf(arr[i]));

        // sorting on the basis of which order gives greater element
        Arrays.sort(str, (a, b) -> {
            StringBuilder ab = new StringBuilder().append(a).append(b);
            StringBuilder ba = new StringBuilder().append(b).append(a);
            return ba.compareTo(ab);
        });

        // returning if largest element present in arr is 0.
        if (str[0].equals("0")) return "0";

        // adding to stringBuilder using stream
        StringBuilder ans = new StringBuilder();
        Arrays.stream(str).forEach(ans::append);

        return ans.toString();
    }
}
