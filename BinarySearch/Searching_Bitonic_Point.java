package Binary_Search;/*
 *
 * https://www.geeksforgeeks.org/problems/maximum-value-in-a-bitonic-array3001/1
 *
 *   Q. Given an array of integer arr[] that is first strictly increasing and then maybe strictly
 *      decreasing, find the bitonic point, that is the maximum element in the array.
 *
 *      Bitonic Point is a point before which elements are strictly increasing and after which
 *      elements are strictly decreasing.
 *
 *      Note: It is guaranteed that the array contains exactly one bitonic point.
 *    Ex.
 *      Input : arr[] = [1, 2, 4, 5, 7, 8, 3]
 *      Output: 8
 *      Explanation: Elements before 8 are strictly increasing [1, 2, 4, 5, 7] and elements after 8
 *                   are strictly decreasing [3].
 */

import java.util.Scanner;

public class Searching_Bitonic_Point {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];

        for (int i = 0;i < n;i++){
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.println("Bitonic Point: " + findMaximum(arr));
    }

    /// Solution
    static int findMaximum(int[] arr) {
        // potd.code.hub
        int n = arr.length;

        if (n == 1 || arr[0] >= arr[1]) {
            return arr[0];
        }
        if (arr[n - 1] > arr[n - 2]) {
            return arr[n - 1];
        }

        int i = 1, j = n - 2;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (arr[mid - 1] < arr[mid] && arr[mid] >= arr[mid + 1]) {
                return arr[mid];
            } else if (arr[mid - 1] < arr[mid]) {
                i = mid + 1;
            } else j = mid - 1;
        }

        return -1;
    }
}
