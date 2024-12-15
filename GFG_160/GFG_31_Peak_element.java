package GFG_160;/*
 * https://www.geeksforgeeks.org/problems/peak-element/1
 *
 * # Peak element
 *
 *   Q. Given an array arr[] where no two adjacent elements are same, find the index of a peak element.
 *      An element is considered to be a peak if it is greater than its adjacent elements (if they exist).
 *      If there are multiple peak elements, return index of any one of them. The output will be "true"
 *      if the index returned by your function is correct; otherwise, it will be "false".
 *
 *      Note: Consider the element before the first element and the element after the last element to be
 *            negative infinity.
 *    Ex.
 *      Input : arr = [1, 2, 4, 5, 7, 8, 3]
 *      Output: true
 *      Explanation: arr[5] = 8 is a peak element because arr[4] < arr[5] > arr[6].
 */

import java.util.Scanner;

public class GFG_31_Peak_element {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(peakElement(arr) != -1);
    }

    /// Solution
    static int peakElement(int[] arr) {
        // potd.code.hub
        int n = arr.length;

        if (n == 1 || arr[0] > arr[1]) return 0;
        if (arr[n-1] > arr[n-2]) return n-1;

        int i = 1, j = n-2;
        while (i <= j){
            int mid = i + (j-i)/2;
            if (arr[mid-1] < arr[mid] && arr[mid] > arr[mid+1]) return mid;
            if (arr[mid - 1] < arr[mid]) i = mid + 1;
            else j = mid - 1;
        }

        return -1;
    }
}
