package Sorting;/*
 *
 * https://www.geeksforgeeks.org/problems/sort-by-absolute-difference-1587115621/1
 *
 * # Sort by Absolute Difference
 *
 *   Q. You are given a number x and array arr[]. Your task is to rearrange the elements of the array according
 *      to the absolute difference with x, i.e., an element having minimum difference comes first, and so on.
 *
 *      Note: If two or more elements are at equal distances arrange them in the same sequence as in the given
 *            array.
 *    Ex.
 *      Input : x = 6, arr[] = [1, 2, 3, 4, 5]
 *      Output: [5, 4, 3, 2, 1]
 *      Explanation: Sorting the numbers according to the absolute difference with 6, we have array elements as
 *                   5, 4, 3, 2, 1.
 *      Constraints:
 *          1 ≤ x ≤ 10⁵
 *          1 ≤ arr.size() ≤ 10⁵
 *          1 ≤ arr[i] ≤ 10⁵
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Sorting_Sort_by_Absolute_Difference {

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

        System.out.println("x: ");
        int x = sc.nextInt();

        rearrange(arr, x);

        System.out.println("Rearranged: " + Arrays.toString(arr));
    }

    /// Solution
    static void rearrange(int[] arr, int x) {
        // potd.code.hub
        int n = arr.length;
        Integer[] temp = new Integer[n];

        Arrays.setAll(temp, i -> arr[i]);
        Arrays.sort(temp, Comparator.comparingInt(a -> Math.abs(a - x)));

        for (int i = 0; i < n; i++) arr[i] = temp[i];
    }
}
