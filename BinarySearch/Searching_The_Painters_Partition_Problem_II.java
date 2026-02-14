package BinarySearch;/*
 *
 * https://www.geeksforgeeks.org/problems/the-painters-partition-problem1535/1
 *
 * # The Painter's Partition Problem-II
 *
 *   Q. Given an array arr[] where each element denotes the length of a board, and an integer k representing the number of
 *      painters available. Each painter takes 1 unit of time to paint 1 unit length of a board.
 *
 *      Determine the minimum amount of time required to paint all the boards, under the constraint that each painter can
 *      paint only a contiguous sequence of boards (no skipping or splitting allowed).
 *    Ex.
 *      Input : arr[] = [5, 10, 30, 20, 15], k = 3
 *      Output: 35
 *      Explanation: The optimal allocation of boards among 3 painters is -
 *                   Painter 1 → [5, 10] → time = 15
 *                   Painter 2 → [30] → time = 30
 *                   Painter 3 → [20, 15] → time = 35
 *                   Job will be done when all painters finish i.e. at time = max(15, 30, 35) = 35
 *
 *  Constraints:
 *          1 ≤ arr.size() ≤ 10⁵
 *          1 ≤ arr[i] ≤ 10⁴
 *          1 ≤ k ≤ 10⁵
 */

import java.util.Scanner;

public class Searching_The_Painters_Partition_Problem_II {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("arr[] : ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.print("k: ");
        int k = sc.nextInt();

        System.out.println("Minimum amount of time required to paint all the boards: ");
        System.out.println(minTime(arr, k));
    }

    /// Solution
    static int minTime(int[] arr, int k) {
        // potd.code.hub
        int low = Integer.MIN_VALUE;
        int high = 0;

        for (int ele : arr) {
            low = Math.max(low, ele);
            high += ele;
        }

        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(arr, mid, k)) {
                ans = mid;
                high = mid - 1;
            } else low = mid + 1;
        }

        return ans;
    }

    private static boolean isPossible(int[] arr, int time, int painters) {
        int sum = 0;

        for (int length : arr) {
            if (length > time) return false;

            sum += length;

            if (sum > time) {
                sum = length;
                painters--;
            }
        }

        return painters > 0;
    }
}
