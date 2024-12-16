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
        int n = a.length, m = b.length;

        int i = 0, j = 0;
        while (i < n && j < m){
            k--;
            if (a[i] < b[j]){
                if (k == 0) return a[i];
                i++;
            }
            else {
                if (k == 0) return b[j];
                j++;
            }
        }
        if (i < n && k > 0) return a[i+k-1];
        else if (j < m && k > 0) return b[j+k-1];

        return -1;
    }
}
