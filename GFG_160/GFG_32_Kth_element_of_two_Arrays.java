package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/k-th-element-of-two-sorted-array1317/1
 *
 * # K-th element of two Arrays
 *
 *   Q. Given two sorted arrays a[] and b[] and an element k, the task is to find the element that would
 *      be at the kth position of the combined sorted array.
 *    Ex.
 *      Input : a[] = [2, 3, 6, 7, 9]
 *              b[] = [1, 4, 8, 10]
 *              k = 5
 *      Output: 6
 *      Explanation: The final combined sorted array would be [1, 2, 3, 4, 6, 7, 8, 9, 10]. The 5th element
 *                   of this array is 6.
 */

import java.util.Scanner;

public class GFG_32_Kth_element_of_two_Arrays {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size of A[]: ");
        int n = sc.nextInt();
        
        int[]arr = new int[n];

        System.out.println("Elements of A[]: ");
        for (int i = 0;i < n;i++){
            arr[i] = sc.nextInt();
        }

        System.out.println("Size of B[]: ");
        int m = sc.nextInt();

        int[]brr = new int[m];

        System.out.println("Elements of B[]: ");
        for (int i = 0;i < m;i++){
            brr[i] = sc.nextInt();
        }

        System.out.println("K: ");
        int k = sc.nextInt();

        System.out.println(kthElement(arr, brr, k));
    }

    /// Solution
    static int kthElement(int[]a, int[]b, int k) {
        // potd.code.hub
        int n1 = a.length, n2 = b.length;
        if (n1 > n2) return kthElement(b, a, k);

        int i = Math.max(0, k-n2), j = Math.min(k, n1);
        while (i <= j){
            int mid1 = i + (j-i)/2;
            int mid2 = k - mid1;
            int l1 = (mid1-1 >= 0) ? a[mid1-1] : Integer.MIN_VALUE;
            int l2 = (mid2-1 >= 0) ? b[mid2-1] : Integer.MIN_VALUE;
            int r1 = (mid1 < n1) ? a[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < n2) ? b[mid2] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1) return Math.max(l1, l2);
            else if (l1 > r2) j = mid1-1;
            else i = mid1+1;
        }

        return 0;
    }
}
