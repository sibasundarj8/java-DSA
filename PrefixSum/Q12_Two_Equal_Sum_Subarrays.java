package PrefixSum;/*
 *
 * https://www.geeksforgeeks.org/problems/split-an-array-into-two-equal-sum-subarrays/1
 *
 * # Two Equal Sum Subarrays
 *
 *   Q. Given an array of integers arr[], return true if it is possible to split it in two subarrays (without reordering
 *      the elements), such that the sum of the two subarrays are equal. If it is not possible then return false.
 *
 *    Ex.
 *      Input : arr[] = [1, 2, 3, 4, 5, 5]
 *      Output: true
 *      Explanation: We can divide the array into [1, 2, 3, 4] and [5, 5]. The sum of both the subarrays are 10.
 *
 *  Constraints:
 *      1 ≤ arr.size() ≤ 10⁵
 *      1 ≤ arr[i] ≤ 10⁶
 */

import java.util.Arrays;
import java.util.Scanner;

public class Q12_Two_Equal_Sum_Subarrays {

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

        System.out.println("Possible to split it in two subarrays with equal sum: ");
        System.out.println(canSplit(arr));
    }

    /// Solution
    static boolean canSplit(int[] arr) {
        // potd.code.hub
        int total = Arrays.stream(arr).sum();
        int sum = 0;

        for (int ele : arr) {
            sum += ele;
            if (2 * sum == total) {
                return true;
            }
        }

        return false;
    }
}
