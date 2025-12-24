package BinarySearch;/*
 *
 * https://www.geeksforgeeks.org/problems/count-elements-less-than-or-equal-to-k-in-a-sorted-rotated-array/1
 *
 * # Count elements less than or equal to k in a sorted rotated array
 *
 *   Q. Given a sorted array arr[] containing distinct positive integers that has been rotated at some unknown pivot, and
 *      a value x. Your task is to count the number of elements in the array that are less than or equal to x.
 *
 *    Ex:
 *      Input : arr[] = [6, 10, 12, 15, 2, 4, 5],
 *              x = 14
 *      Output: 6
 *      Explanation: All elements except 15 are less than 14, so the count of all elements less than 14 is 6.
 *
 *  Constraints:
 *      1 ≤ arr.size() ≤ 10⁵
 *      0 ≤ arr[i], x ≤ 10⁹
 */

public class Searching_Count_elements_less_than_or_equal_to_k_in_a_sorted_rotated_array {

    /// main Method
    public static void main(String[] args) {
        int[] arr = {6, 10, 12, 15, 2, 4, 5};
        int x = 14;

        System.out.println("number of elements smaller than " + x + " : ");
        System.out.println(countLessEqual(arr, x));
    }

    /// Solution
    static int countLessEqual(int[] arr, int x) {
        // code here
        int pivot = pivot(arr);

        int lc = count(arr, 0, pivot - 1, x);
        int rc = count(arr, pivot, arr.length - 1, x);

        return lc + rc;
    }

    private static int count(int[] arr, int i, int j, int x) {
        int ub = i - 1;
        int l = i, r = j;

        while(l <= r) {
            int mid = l + (r - l) / 2;

            if(arr[mid] <= x) {
                ub = mid;
                l = mid + 1;
            }
            else r = mid - 1;
        }

        return ub - i + 1;
    }

    private static int pivot(int[] arr) {
        int i = 0;
        int j = arr.length - 1;

        while(i < j) {
            int mid = i + (j - i) / 2;
            if(arr[mid] > arr[j]) i = mid + 1;
            else j = mid;
        }

        return i;
    }
}
