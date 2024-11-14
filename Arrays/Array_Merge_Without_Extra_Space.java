package Array;/*
 * https://www.geeksforgeeks.org/problems/merge-two-sorted-arrays-1587115620/1?page=6&sortBy=submissions
 *
 * # Merge Without Extra Space
 *
 *   Q. Given two sorted arrays a[] and b[] in non-decreasing order. Merge them in sorted order without
 *      using any extra space. Modify a so that it contains the first n elements and modify b so that
 *      it contains the last m elements.
 *    Ex.
 *      Input : a[] = [2, 4, 7, 10]
 *              b[] = [2, 3]
 *      Output: a[] = 2 2 3 4
 *              b[] = 7 10
 *      Explanation: After merging the two non-decreasing arrays, we get, 2 2 3 4 7 10
 */

import java.util.Scanner;

public class Array_Merge_Without_Extra_Space {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("A[] Size: ");
        int n = sc.nextInt();
        int[]arr = new int[n];

        System.out.println("Elements: ");
        for (int i = 0;i < n;i++){
            arr[i] = sc.nextInt();
        }

        System.out.println("B[] Size: ");
        int m = sc.nextInt();
        int[]brr = new int[m];

        System.out.println("Elements: ");
        for (int i = 0;i < m;i++){
            brr[i] = sc.nextInt();
        }

        mergeArrays(arr, brr);

        for (int i : arr) System.out.print(i + " ");
        System.out.println();
        for (int i : brr) System.out.print(i + " ");
        System.out.println();
    }

    /// Solution (Shell Sort)
    static void mergeArrays(int[]a, int[]b) {
        // potd.code.hub
        int n = a.length;
        int m = b.length;

        int len = n+m;
        int gap = (len/2) + (len%2);

        while (gap > 0){
            int left = 0;
            int right = left + gap;
            while(right < len){
                // left in A[] & right in B[]
                if (left < n && right >= n){
                    swap(a, b, left, right-n);
                }
                // both in B[]
                else if (left >= n){
                    swap(b, b, left-n, right-n);
                }
                // both in A[]
                else {
                    swap(a, a, left, right);
                }
                left++;
                right++;
            }
            if (gap == 1) break;
            gap = (gap/2) + (gap%2);
        }
    }
    // Swap
    static void swap(int[]arr, int[]brr, int i, int j){
        if (arr[i] > brr[j]){
            int temp = arr[i];
            arr[i] = brr[j];
            brr[j] = temp;
        }
    }
}
