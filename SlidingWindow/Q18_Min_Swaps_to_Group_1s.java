package SlidingWindow;/*
 *
 * https://www.geeksforgeeks.org/problems/minimum-swaps-required-to-group-all-1s-together2451/1
 *
 * # Min Swaps to Group 1s
 *
 *   Q. You are given a binary array arr[] consisting only of 0s and 1s. Determine the minimum number of swaps required to
 *      group all the 1s together in a contiguous subarray.
 *
 *      A swap operation allows you to choose any two indices i and j and exchange their values (i.e., swap(arr[i], arr[j])).
 *
 *      If the array contains no 1s, return -1.
 *
 *    Ex.
 *      Input : arr[] = [1, 0, 1, 0, 1, 1]
 *      Output: 1
 *      Explanation: Only 1 swap is required to group all 1's together. Swapping index 0 and 3 will give a
 *                   rr[] = [0, 0, 1, 1, 1, 1].
 *
 *  Constraints:
 *          1 ≤ arr.size() ≤ 10⁶
 *          0 ≤ arr[i] ≤ 1
 */

import java.util.Arrays;
import java.util.Scanner;

public class Q18_Min_Swaps_to_Group_1s {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array elements: (either 0 or 1)");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
            if (arr[i] != 0 && arr[i] != 1) {
                throw new IllegalArgumentException("array elements must be 0 or 1");
            }
        }

        System.out.println("Minimum number of swaps required to group all the 1s together: ");
        System.out.println(minSwaps(arr));
    }

    /// Solution
    static int minSwaps(int[] arr) {
        // potd.code.hub
        int n = arr.length;
        int totalOnes = Arrays.stream(arr).sum();

        if (totalOnes == 0) {
            return -1;
        }

        int l = 0;
        int currentOnes = 0;
        int maxOne = 0;

        for (int r = 0; r < n; r++) {
            if (r >= totalOnes) {
                currentOnes -= arr[l++];
            }
            currentOnes += arr[r];
            maxOne = Math.max(maxOne, currentOnes);
        }

        return totalOnes - maxOne;
    }
}
