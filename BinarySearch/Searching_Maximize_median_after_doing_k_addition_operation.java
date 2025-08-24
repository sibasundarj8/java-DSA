package Binary_Search;/*
 *
 * https://www.geeksforgeeks.org/problems/maximize-median-after-doing-k-addition-operation/1
 *
 * # Maximize median after doing k addition operation
 *
 *   Q. Given an array arr[] consisting of positive integers and an integer k. You are allowed to perform at
 *      most k operations, where in each operation, you can increment any one element of the array by 1.
 *
 *      Determine the maximum possible median of the array that can be achieved after performing at most k
 *      such operations.
 *   Ex.
 *      Input : arr[] = [1, 3, 4, 5]
 *              k = 3
 *      Output: 5
 *      Explanation: We can add +2 to the second element and +1 to the third element to get the
 *                   array [1, 5, 5, 5]. After sorting, the array remains [1, 5, 5, 5]. Since the
 *                   length is even, the median is (5 + 5) / 2 = 5.
 *   Constraints:
 *          1 ≤ arr.size() ≤ 105
 *          0 ≤ arr[i], k ≤ 109
 */

import java.util.Arrays;
import java.util.Scanner;

public class Searching_Maximize_median_after_doing_k_addition_operation {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.println("k: ");
        int k = sc.nextInt();

        System.out.println("Maximum Median possible: " + maximizeMedian(arr, k));
    }

    /// Solution
    static int maximizeMedian(int[] arr, int k) {
        int n = arr.length;

        if (n == 1) return arr[0] + k;

        Arrays.sort(arr);

        int s = (n % 2 == 0) ? arr[(n - 1) / 2] : arr[n / 2];
        int e = arr[n / 2] + k;
        int ans = -1;

        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (check(arr, k, mid)) {
                ans = mid;
                s = mid + 1;
            } else e = mid - 1;
        }

        return ans;
    }

    private static boolean check(int[] arr, int k, int tar) {
        int n = arr.length;
        int m = n / 2;

        for (int i = n - 1; i >= m; i--)
            if (arr[i] < tar) k -= (tar - arr[i]);

        if (n % 2 == 0) {
            int temp = (tar * 2 - Math.max(arr[m], tar)) - arr[m - 1];
            k -= temp;
        }

        return k >= 0;
    }
}
