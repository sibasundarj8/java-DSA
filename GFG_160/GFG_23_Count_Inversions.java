package GFG_160;/*
 * https://www.geeksforgeeks.org/problems/inversion-of-array-1587115620/1
 *
 * # Count Inversions
 *
 *   Q. Given an array of integers arr[]. Find the Inversion Count in the array. Two elements arr[i] and
 *      arr[j] form an inversion if arr[i] > arr[j] and i < j.
 *
 *      Inversion Count: For an array, inversion count indicates how far (or close) the array is from being
 *      sorted. If the array is already sorted then the inversion count is 0. If an array is sorted in the
 *      reverse order then the inversion count is the maximum.
 * 
 *    Ex.
 *      Input : arr[] = [2, 4, 1, 3, 5]
 *      Output: 3
 *      Explanation: The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).
 */
import java.util.Scanner;

public class GFG_23_Count_Inversions {

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

        System.out.println(inversionCount(arr));
    }

    /// Solution
    static int inversionCount(int[]arr) {
        // potd.code.hub
        int n = arr.length;
        return sort(arr, 0, n-1);
    }
    // using meargeSort
    private static int sort(int[]arr, int i, int j){
        int inv = 0;
        if (i < j){
            int mid = i + (j - i) / 2;
            inv += sort(arr, i, mid);
            inv += sort(arr, mid + 1, j);
            inv += merge(arr, i, j, mid);
        }
        return inv;
    }
    private static int merge(int[] arr, int l, int r, int mid) {
        int inv = 0;
        int n = mid - l + 1;
        int m = r - mid;
        int[]left = new int[n];
        int[]right = new int[m];
        int i = 0,j;
        while (i < n || i < m){
            if (i < n) left[i] = arr[l+i];
            if (i < m) right[i] = arr[mid+1+i];
            i++;
        }

        i = j = 0;
        int k = l;
        while (i < n && j < m){
            if (left[i] <= right[j])
                arr[k++] = left[i++];
            else {
                arr[k++] = right[j++];
                inv += n-i;     // although two arrays are sorted, next (n-i) elements are also greater than arr[j]
            }
        }
        while (i < n) arr[k++] = left[i++];
        while (j < m) arr[k++] = right[j++];

        return inv;
    }
}
