package GFG;/*
 *
 * https://www.geeksforgeeks.org/problems/binary-searchable-elements/1
 *
 * # Binary Searchable Count
 *
 *   Q. Given an array arr[] consisting of n distinct integers, find the maximum count of integers that are binary
 *      searchable in the given array. Binary searchable elements are determined using the standard Binary Search
 *      implementation described below.
 *        ◦ Initially l is 0 and r is size of array - 1
 *        ◦ while(l <= r), compute mid as floor of (l + r)/2 and compare with mid.
 *        ◦ If the target element is same as mid, return true. Else if mid is smaller, change l = mid + 1, else change
 *          r = mid - 1.
 *
 *      For example:
 *
 *        ◦ In arr[] = [2, 1, 3, 4, 6, 5], the element 5 is not binary searchable. During Binary Search, the search
 *          eventually reaches the subarray containing 6, and since 6 > 5, the search moves left (r = mid - 1), causing
 *          the element 5 to be skipped.
 *
 *        ◦ In arr[] = [2, 1, 3, 4, 5, 6], the element 5 is binary searchable because the standard Binary Search process
 *          eventually reaches and finds 5.
 *
 *    Ex.
 *      Input: arr[] = [2, 1, 3, 5, 4, 6]
 *      Output: 4
 *      Explanation: arr[0], arr[2], arr[4], arr[5] can be found.
 *
 *  Constraints:
 *          1 ≤ n ≤ 10⁵
 *          1 ≤ arr[i] ≤ 10⁵
 */

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class POTD_Binary_Searchable_Count {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.println("Count of binary searchable elements: ");
        System.out.println(binarySearchable(arr));
    }

    /// Solution
/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯--brute-force-(binary-search)--⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(n log n)
SC : O(1)
*/
    static int approach_1(int[] arr) {
        // potd.code.hub
        int count = 0;

        for (int ele : arr) {
            if (binarySearch(arr, ele)) {
                System.out.print(ele + " ");
                count++;
            }
        }
        System.out.println();

        return count;
    }

    private static boolean binarySearch(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {
            int m = (l + r) / 2;
            if (arr[m] == target) return true;
            if (arr[m] < target) l = m + 1;
            else r = m - 1;
        }

        return false;
    }

/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯--using-BFS--⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(n)
SC : O(n)
*/
    static int binarySearchable(int[] arr) {
        // potd.code.hub
        int n = arr.length;
        int count = 0;

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, n - 1, Integer.MIN_VALUE, Integer.MAX_VALUE});

        while (!q.isEmpty()) {
            int[] pair = q.poll();
            int l = pair[0];
            int r = pair[1];
            int low = pair[2];
            int high = pair[3];
            int mid = (l + r) / 2;

            if (low < arr[mid] && arr[mid] < high) {
                count++;
            }

            if (l <= mid - 1) {
                q.offer(new int[]{l, mid - 1, low, Math.min(arr[mid], high)});
            }

            if (mid + 1 <= r) {
                q.offer(new int[]{mid + 1, r, Math.max(arr[mid], low), high});
            }
        }

        return count;
    }
}
