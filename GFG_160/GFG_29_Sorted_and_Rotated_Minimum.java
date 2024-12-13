package GFG_160;/*
 * https://www.geeksforgeeks.org/problems/minimum-element-in-a-sorted-and-rotated-array3611/1
 *
 * # Sorted and Rotated Minimum
 *
 *   Q. A sorted array arr[] (may contain duplicates) is rotated at some unknown point, the task is to find
 *      the minimum element in it.
 *    Ex.
 *      Input : arr[] = [5, 6, 1, 2, 3, 4]
 *      Output: 1
 *      Explanation: 1 is the minimum element in the array.
 */
import java.util.Scanner;

public class GFG_29_Sorted_and_Rotated_Minimum {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int[]arr = new int[n]; // must be a rotated sorted array

        System.out.println("Elements: ");
        for (int i = 0;i < n;i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(findMin(arr));
    }

    /// Solution
    static int findMin(int[] arr) {
        // potd.code.hub
        int ans = arr[0];
        int i = 0, j = arr.length - 1;

        while (i <= j) {
            int mid = i + (j - i) / 2;
            ans = Math.min(ans, arr[mid]);
            if (arr[mid] <= arr[j]) {
                ans = Math.min(arr[i], ans);
                j = mid - 1;
            }
            else if (arr[i] <= arr[mid]) i = mid + 1;
        }

        return ans;
    }
}
