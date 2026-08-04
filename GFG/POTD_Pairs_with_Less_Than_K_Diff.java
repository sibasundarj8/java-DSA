package GFG;/*
 *
 * https://www.geeksforgeeks.org/problems/pairs-with-difference-less-than-k1348/1
 *
 * # Pairs with Less Than K Diff
 *
 *   Q. Given an array arr[] of positive integers and an integer k, find the total number of pairs of elements that have
 *      an absolute difference strictly less than k.
 *
 *      Note:  Pair (i, j) is considered the same as (j, i).
 *
 *    Ex.
 *      Input : arr[] = [1, 10, 4, 2], k = 3
 *      Output: 2
 *      Explanation:
 *              We have an array arr[] = [1, 10, 4, 2] and k = 3 We can make only two pairs with a difference of less
 *              than 3. (1, 2) and (4, 2). So, the answer is 2.
 *
 *  Constraints:
 *        ◦ 1 ≤ arr.size() ≤ 10⁵
 *        ◦ 0 ≤ k ≤ 10⁵
 *        ◦ 1 ≤ arr[i] ≤ 10⁵
 */

import java.util.Arrays;
import java.util.Scanner;

public class POTD_Pairs_with_Less_Than_K_Diff {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("int[] arr: ");
        String[] s = sc.nextLine().split(" ");

        System.out.print("k: ");
        int k = sc.nextInt();

        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.println("Number of pairs which absolute difference is less then " + k + " : ");
        System.out.println(countPairs(arr, k));
    }

    /// Solution
    static int countPairs(int[] arr, int k) {
        // potd.code.hub
        int n = arr.length;
        int count = 0;

        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            int next = ub(i, n - 1, arr[i] + k - 1, arr);
            count += (next - i);
        }

        return count;
    }

    private static int ub(int i, int j, int tar, int[] arr) {
        while (i <= j) {
            int mid = i + ((j - i) >> 1);
            if (arr[mid] <= tar) i = mid + 1;
            else j = mid - 1;
        }

        return j;
    }
}
