package Arrays;/*
 *
 * https://www.geeksforgeeks.org/problems/count-increasing-subarrays5301/1
 *
 * # Count increasing Subarrays
 *
 *   Q. Given an array arr[] of integers, count the number of subarrays in arr[] which are strictly increasing with size
 *      greater or equal to 2. A subarray is a contiguous part of array. A subarray is strictly increasing if each element
 *      is greater than it's previous element if it exists.
 *    Ex.
 *      Input : arr[] = [1, 4, 5, 3, 7, 9]
 *      Output: 6
 *      Explanation: The strictly increasing subarrays are: [1, 4], [1, 4, 5], [4, 5], [3, 7], [3, 7, 9], [7, 9]
 *
 *  Constraints:
 *          1 ≤ arr.size() ≤ 10⁵
 *          1 ≤ arr[i] ≤ 10⁷
 */

import java.util.Scanner;

public class Array_Count_increasing_Subarrays {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.print("""
                number of subarrays in arr[] which are strictly increasing
                with size greater or equal to 2 :
                """);
        System.out.println(countIncreasing(arr));
    }

    /// Solution
    static int countIncreasing(int[] arr) {
        // potd.code.hub
        int n = arr.length;
        int result = 0;
        int len = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i] <= arr[i - 1]) {
                result += countSubarrays(len);
                len = 1;
            } else {
                len++;
            }
        }

        result += countSubarrays(len);

        return result;
    }

    private static int countSubarrays(int len) {
        return (len * (len - 1)) / 2;
    }
}
