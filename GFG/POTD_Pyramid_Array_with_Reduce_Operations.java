package GFG;/*
 *
 * https://www.geeksforgeeks.org/problems/pyramid-form3044/1
 *
 * # Pyramid Array with Reduce Operations
 *
 *   Q. Given an array arr[] consisting of stones, where arr[i] represents the height of the i-th stone.
 *
 *          ◦ You need to transform the stones into a pyramid by only reducing the heights of the stones.
 *            Reducing the height of a stone by 1 costs 1 unit, and stones cannot be increased or moved.
 *
 *          ◦ A valid pyramid consists of a contiguous subarray whose heights follow the pattern:
 *            1, 2, 3, ..., x - 1, x, x - 1, ..., 2, 1 for some positive integer x.
 *
 *          ◦ Every stone outside this subarray must have a height of 0.
 *
 *      Find the minimum total cost required to build a pyramid. It is guaranteed that at least one valid pyramid can
 *      always be formed.
 *
 *    Ex.
 *      Input : arr[] = [1, 2, 3, 4, 2, 1]
 *      Output: 4
 *      Explanation: We can obtain the array [1, 2, 3, 2, 1, 0] by subtracting 2 out of 4, 1 out of 2, and 1 out of 1.
 *                   In total, we will subtract 4.
 *
 *  Constraints:
 *        ◦ 1 ≤ arr.size(), arr[i] ≤ 10⁵
 */

import java.util.Scanner;

public class POTD_Pyramid_Array_with_Reduce_Operations {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("arr[]: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.println("Minimum cost required to build a pyramid: ");
        System.out.println(formPyramid(arr));
    }

    /// Solution
    static int formPyramid(int[] arr) {
        // potd.code.hub
        int n = arr.length;
        int[] right = new int[n];

        right[n - 1] = Math.min(arr[n - 1], 1);

        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.min(arr[i], right[i + 1] + 1);
        }

        long max = 0;
        long total = 0;
        long curr, prev = 0;

        for (int i = 0; i < n; i++) {
            curr = Math.min(prev + 1, arr[i]);
            max = Math.max(max, Math.min(curr, right[i]));
            prev = curr;
            total += arr[i];
        }

        return (int) (total - max * max);
    }
}
