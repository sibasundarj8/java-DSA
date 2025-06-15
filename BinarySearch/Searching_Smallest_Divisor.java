package Binary_Search;/*
 *
 * https://www.geeksforgeeks.org/problems/smallest-divisor/1
 *
 * # Smallest Divisor
 *
 *   Q. Given an integer array arr[] and an integer k (where k ≥ arr.length), find the smallest positive integer
 *      divisor such that the sum of the ceiling values of each element in arr[] divided by this divisor is less
 *      than or equal to k.
 *    Ex.
 *      Input : arr[] = [1, 2, 5, 9]
 *              k = 6
 *      Output: 5
 *      Explanation: 5 is the smallest divisor having sum of quotients (1 + 1 + 1 + 2 = 5) less than or equal to 6.
 */

import java.util.Scanner;

public class Searching_Smallest_Divisor {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Array Elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.println("Enter K (must be greater then " + n + "):");
        int k = sc.nextInt();

        if (k < n) {
            System.out.println("must be greater then " + n);
            return;
        }

        System.out.println("Smallest Divisor: " + smallestDivisor(arr, k));
    }

    /// Solution
    static int smallestDivisor(int[] arr, int k) {
        // potd.code.hub
        int i = 1, ans = -1, j = 1;
        
        // lower bound -> 1, upper bound -> the largest element
        for (int x : arr) j = Math.max(x, j);

        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (isPos(arr, mid, k)) {
                ans = mid;
                j = mid - 1;
            } else i = mid + 1;
        }

        return ans;
    }

    private static boolean isPos(int[] arr, int k, int target) {
        int ans = 0;
        for (int i : arr)
            ans += ((i + k - 1) / k);
        return ans <= target;
    }
}
