package GFG_160.Bonus_Problems;/*
 *
 * https://www.geeksforgeeks.org/problems/minimum-removals-for-target-sum/0
 *
 * # Minimum Removals for Target Sum
 *
 *   Q. You are given an array of positive integers arr[] and an integer k. In one operation, you can remove
 *      either the leftmost or the rightmost element from the array. After each operation, the size of arr[]
 *      will be reduced by one.
 *
 *      Your task is to determine the minimum number of operations required to make the total sum of removed
 *      elements exactly equal to k. If it is not possible to achieve this, return -1.
 *    Ex.
 *      Input : arr[] = [3, 4, 1, 3, 2], k = 5
 *      Output: 2
 *      Explanation: Removing 3 from left and 2 from right gives a sum of 5 in 2 operations.
 */
import java.util.Scanner;

public class TwoPointer_06_Minimum_Removals_for_Target_Sum {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int[]arr = new int[n];

        System.out.println("Elements: ");
        for (int i = 0;i < n;i++) arr[i] = sc.nextInt();

        System.out.println("Target: ");
        int t = sc.nextInt();

        System.out.println(minRemovals(arr, t));
    }

    /// Solution
    static int minRemovals(int[] arr, int k) {
        // potd.code.hub
        int n = arr.length, i = 0, sum = 0, ans = 0, j;
        for (int x : arr) sum += x;
        if (sum == k) return n;
        k = sum - k;
        sum = 0;
        for (j = 0;j < n;j++) {
            sum += arr[j];
            while (sum > k) sum -= arr[i++];
            if (sum == k) ans = Math.max(ans, j-i+1);
        }
        return (ans != 0) ? n-ans : -1;
    }
}
