package GFG;/*
 *
 * https://www.geeksforgeeks.org/problems/elements-in-the-range2834/1
 *
 * # Elements in the Range
 *
 *   Q. Given an array arr[] containing distinct positive integers, and two integers start and end defining a range.
 *      Determine if the array contains all elements within inclusive range [start, end].
 *
 *      Note: If the array contains all elements in the given range return true otherwise return false.
 *
 *    Ex.
 *      Input : start = 2, end = 5, arr[] =  [1, 4, 5, 2, 7, 8, 3]
 *      Output: true
 *      Explanation: All integers within the range [2, 5] are 2, 3, 4, and 5, and all of them are present in the array.
 *                   Therefore, the answer is true for this test case.
 *
 *  Constraints:
 *          1 ≤ arr.size() ≤ 10⁵
 *          0 ≤ arr[i] ≤ 10⁵
 *          0 ≤ start ≤ end ≤ 10⁵
 */

import java.util.Scanner;

public class POTD_Elements_in_the_Range {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array elements: ");
        String[] s = sc.nextLine().split(" ");

        System.out.println("Enter start: ");
        int start = sc.nextInt();

        System.out.println("Enter end: ");
        int end = sc.nextInt();

        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.println("Does array contains all elements within the range: ");
        System.err.println(checkElements(start, end, arr) ? "YES" : "NO");
    }

    /// Solution
/*
☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑-in-place-tracking-☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑
TC : O(n)
TC : O(1)
*/
    static boolean approach_1(int start, int end, int[] arr) {
        // potd.code.hub
        int n = arr.length;
        int diff = end - start;

        if (diff + 1 > n) return false;

        // incrementing all values by 1 to handle 0's.
        for (int i = 0; i < n; i++) {
            arr[i]++;
        }

        for (int i = 0; i < n; i++) {
            int val = Math.abs(arr[i]) - 1;

            if (start <= val && val <= end) {
                int idx = val - start;

                if (arr[idx] >= 0) {
                    arr[idx] = -arr[idx];
                }
            }
        }

        for (int i = 0; i <= diff; i++) {
            if (arr[i] >= 0) {
                return false;
            }
        }

        return true;
    }

/*
☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑-Direct-Counting-☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑
TC : O(n)
SC : O(1)
*/
    static boolean checkElements(int start, int end, int[] arr) {
        // potd.code.hub
        int required = end - start + 1;
        int have = 0;

        for (int val : arr) {
            if (start <= val && val <= end) {
                have++;
            }
        }

        return required == have;
    }
}
