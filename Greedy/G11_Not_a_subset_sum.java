package Greedy;/*
 *
 * https://www.geeksforgeeks.org/problems/smallest-number-subset1220/1
 *
 * # Not a subset sum
 *
 *   Q. Given an array arr[] of positive integers, find the smallest positive integer such that it cannot be represented
 *      as the sum of elements of any subset of the given array set.
 *
 *    Ex.
 *      Input : arr[] = [3, 1, 2]
 *      Output: 7
 *      Explanation: 7 is the smallest positive number for which no subset is there with sum 7.
 *
 *  Constraints
 *          1 ≤ arr.size() ≤ 10⁵
 *          1 ≤ arr[i] ≤ 10³
 */

import java.util.Arrays;
import java.util.Scanner;

public class G11_Not_a_subset_sum {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Array elements:");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.println("Smallest positive integer which is not a subset sum of arr: ");
        System.out.println(findSmallest(arr));
    }

    /// Solution
    static int findSmallest(int[] arr) {
        // potd.code.hub
        int expected = 1;
        Arrays.sort(arr);

        for (int ele : arr) {

            // if expected is greater than ele then we can't generate expected sum.
            if (ele > expected) {
                return expected;
            }

            // now we can generate more sums by adding the current element with every combination.
            expected += ele;
        }

        return expected;
    }
}
