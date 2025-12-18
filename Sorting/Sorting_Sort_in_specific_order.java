package Sorting;/*
 *
 * https://www.geeksforgeeks.org/problems/sort-in-specific-order2422/1
 *
 * # Sort in specific order
 *
 *   Q. Given an array arr[] of positive integers. Your have to sort them so that the first part of the array contains odd
 *      numbers sorted in descending order, and the rest of the portion contains even numbers sorted in ascending order.
 *    Ex.
 *      Input : arr[] = [1, 2, 3, 5, 4, 7, 10]
 *      Output: [7, 5, 3, 1, 2, 4, 10]
 *      Explanation: 7, 5, 3, 1 are odd numbers in descending order and 2, 4, 10 are even numbers in ascending order.
 *
 *  Constraints:
 *          1 ≤ arr.size() ≤ 10⁵
 *          0 ≤ arri ≤ 10⁹
 */

import java.util.Arrays;
import java.util.Scanner;

public class Sorting_Sort_in_specific_order {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

        Arrays.sort(arr, 0, 4);

//        mergeSort(arr, 0, n - 1);

        System.out.println(Arrays.toString(arr));
    }

    /// Solution
/*
⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊using-Comparator⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊
TC : O(n log n)
SC : O(n)
*/
    static void usingComparator(int[] arr) {
        int n = arr.length;
        Integer[] a = new Integer[n];

        for (int i = 0; i < n; i++) a[i] = arr[i];

        Arrays.sort(a, (x, y) -> {
            boolean xOdd = ((x & 1) == 1);
            boolean yOdd = ((y & 1) == 1);

            if (xOdd && yOdd) return y - x;
            if (!xOdd && !yOdd) return x - y;
            if (xOdd) return -1;
            return 1;
        });

        for (int i = 0; i < n; i++) arr[i] = a[i];
    }

/*
⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊using-merge-sort⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊
TC : O(n log n)
SC : O(n)
*/
    static void usingMergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int l, int r) {
        // base case
        if (l >= r) return;

        // recursive work
        int mid = l + (r - l) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);

        // self work
        merge(arr, l, r, mid);
    }

    private static void merge(int[] arr, int l, int r, int mid) {
        int n = mid - l + 1;
        int m = r - mid;

        int[] left = new int[n];
        int[] right = new int[m];

        System.arraycopy(arr, l, left, 0, n);
        System.arraycopy(arr, mid + 1, right, 0, m);

        int i = 0, j = 0, k = l;
        while (i < n && j < m) {
            boolean iOdd = ((left[i] & 1) == 1);
            boolean jOdd = ((right[j] & 1) == 1);

            if (iOdd && jOdd) arr[k] = (left[i] > right[j]) ? left[i++] : right[j++];
            else if (!iOdd && !jOdd) arr[k] = (left[i] < right[j]) ? left[i++] : right[j++];
            else if (iOdd) arr[k] = left[i++];
            else arr[k] = right[j++];
            k++;
        }

        while (i < n) arr[k++] = left[i++];
        while (j < m) arr[k++] = right[j++];
    }

/*
⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊using-negative-marker⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊⥊
TC : O(n log n)
SC : O(1)
*/
    static void sortIt(int[] arr) {
        int n = arr.length;

        for(int i = 0; i < n; i++) {    // making odd numbers negative
            if((arr[i] & 1) == 1) arr[i] *= -1;
        }

        Arrays.sort(arr);

        for(int i = 0; i < n; i++) {    // restoring odd numbers
            if(arr[i] < 0) arr[i] *= -1;
        }
    }
}
