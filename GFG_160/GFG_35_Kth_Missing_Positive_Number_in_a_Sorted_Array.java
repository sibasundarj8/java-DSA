package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/kth-missing-positive-number-in-a-sorted-array/1
 *
 * # Kth Missing Positive Number in a Sorted Array
 *
 *   Q. Given a sorted array of distinct positive integers arr[], we need to find the kth positive number
 *      that is missing from arr[].
 *    Ex.
 *      Input : arr[] = [2, 3, 4, 7, 11]
 *              k = 5
 *      Output: 9
 *      Explanation: Missing are 1, 5, 6, 8, 9, 10… and 5th missing number is 9.
 *
 */
 
import java.util.Scanner;

public class GFG_35_Kth_Missing_Positive_Number_in_a_Sorted_Array {

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

        System.out.println("k: ");
        int k = sc.nextInt();

        System.out.println(kthMissing(arr, k));
    }

    /// Solution
    static int kthMissing(int[] arr, int k) {
        // potd.code.hub;
        int n = arr.length;
        int ans = n+k;

        int i = 0, j = n-1;
        while (i <= j){
            int mid = i + (j-i)/2;
            int temp = arr[mid] - mid;
            if (temp > k){
                ans = arr[mid] - (temp - k);
                j = mid - 1;
            }
            else i = mid + 1;
        }
        return ans;
    }
}
