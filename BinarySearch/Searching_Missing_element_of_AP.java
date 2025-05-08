package Binary_Search;/*
 *
 * https://www.geeksforgeeks.org/problems/missing-element-of-ap2228/1
 *
 * # Missing element of AP
 *
 *   Q. Given a sorted array arr[] that represents an Arithmetic Progression (AP) with exactly one
 *      missing element, find the missing number.
 *
 *      Note: An element will always exist that, upon inserting into a sequence forms Arithmetic
 *            progression. If the given sequence already forms a valid complete AP, return the
 *            (n+1)-th element that would come next in the sequence.
 *    Ex.
 *      Input : arr[] = [2, 4, 8, 10, 12, 14]
 *      Output: 6
 *      Explanation: Actual AP should be 2, 4, 6, 8, 10, 12, 14.
 */

import java.util.Scanner;

public class Searching_Missing_element_of_AP {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.println("Find Missing: " + findMissing(arr));
    }

    /// Solution
    static int findMissing(int[] arr) {
        // potd.code.hub
        int n = arr.length;
        int dist = Math.min(arr[1] - arr[0], arr[n - 1] - arr[n - 2]);

        int i = 0, j = n - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            int actualEle = arr[0] + dist * mid;
            if (arr[mid] != actualEle) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }

        return (i == n) ? arr[n - 1] + dist : arr[i] - dist;
    }
}
