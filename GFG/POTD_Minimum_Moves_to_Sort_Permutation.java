package GFG;/*
 *
 * https://www.geeksforgeeks.org/problems/morning-assembly3038/1
 *
 * # Minimum Moves to Sort Permutation
 *
 *   Q. Given an array arr[] containing integers from 1 to n exactly once, sort the array in ascending order.
 *
 *      In one operation, you can pick any element and move it either to the beginning or to the end of the array.
 *
 *      Return the minimum number of operations required to sort the array.
 *
 *    Ex.
 *      Input : arr[] = [4, 3, 1, 2]
 *      Output: 2
 *      Explanation: Move 3 to the end to get [1, 2, 4, 3]. Then move 4 to the end to get [1, 2, 3, 4].
 *
 *  Constraints:
 *        ◦ arr.size() ≤ 10⁵
 *        ◦ 1 ≤ arr[i] ≤ arr.size()
 */

import java.util.Scanner;

public class POTD_Minimum_Moves_to_Sort_Permutation {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("arr[]: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
            if (arr[i] > n) {
                throw new IllegalArgumentException("array elements must be in between 1 and " + n);
            }
        }

        System.out.println("Minimum move required to sort: ");
        System.out.println(minMoves(arr));
    }

    /// Solution
    static int minMoves(int[] arr) {
        // potd.code.hub
        int n = arr.length;
        int max = 0;
        int[] prev = new int[n];

        for (int ele : arr) {
            int idx = ele - 1;

            if (idx == 0) prev[idx] = 1;
            else prev[idx] = prev[idx - 1] + 1;

            max = Math.max(max, prev[idx]);
        }

        return n - max;
    }
}
