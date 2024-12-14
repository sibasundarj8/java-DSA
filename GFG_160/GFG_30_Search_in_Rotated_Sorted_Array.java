package GFG_160;/*
 * https://www.geeksforgeeks.org/problems/search-in-a-rotated-array4618/1
 *
 * # Search in Rotated Sorted Array
 *
 *   Q. Given a sorted and rotated array arr[] of distinct elements, the task is to find the index of
 *      a target key. Return -1 if the key is not found.
 *    Ex.
 *      Input : arr[] = [5, 6, 7, 8, 9, 10, 1, 2, 3]
 *              key = 3
 *      Output: 8
 *      Explanation: 3 is found at index 8.
 */

import java.util.Scanner;

public class GFG_30_Search_in_Rotated_Sorted_Array {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int[]arr = new int[n];

        System.out.println("Elements: ");
        for (int i = 0;i < n;i++){
            arr[i] = sc.nextInt();
        }

        System.out.println("Target: ");
        int target = sc.nextInt();

        System.out.println(search(arr, target));
    }

    /// Solution
    static int search(int[] arr, int key) {
        // potd.code.hub
        int i = 0, j = arr.length - 1;

        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (arr[mid] == key) return mid;
            if (arr[i] <= arr[mid]){
                if (arr[i] <= key && key < arr[mid]) j = mid - 1;
                else i = mid+1;
            }
            else {
                if (arr[mid] < key && key <= arr[j]) i = mid+1;
                else j = mid-1;
            }
        }
        return -1;
    }
}
