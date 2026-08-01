package GFG;/*
 *
 * https://www.geeksforgeeks.org/problems/max-value-after-m-range-operation4300/1
 *
 * # Max After m Range Increments
 *
 *   Q. Given three arrays a[], b[], and k[], representing m range increment operations on an array arr[] of size n,
 *      where all elements of arr[] are initially 0.
 *
 *      Increment(a[i], b[i], k[i]) adds k[i] to each element arr[j] such that a[i] ≤ j ≤ b[i] (mainly indexes in range
 *      from a[i] to b[i])
 *
 *      After performing all the given operations, find the maximum value present in the array.
 *
 *    Ex.
 *      Input : n = 4,
 *              a[] = [1, 0, 3],
 *              b[] = [2, 0, 3],
 *              k[] = [603, 286, 882]
 *      Output: 882
 *      Explanation: Initially, arr = [0, 0, 0, 0]
 *                   After the first operation: arr = [0, 603, 603, 0]
 *                   After the second operation: arr = [286, 603, 603, 0]
 *                   After the third operation: arr = [286, 603, 603, 882]
 *                   The maximum element after all operations is 882.
 *
 *  Constraints:
 *        1 ≤  n ≤ 10⁶
 *        1 ≤  a.size() = b.size() = k.size() = m  ≤ 10⁶
 *        0 ≤  a_i  ≤  b_i  ≤ n-1
 *        0 ≤  ki  ≤ 10⁶
 */

import java.util.Scanner;

public class POTD_Max_After_m_Range_Increments {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("int[] a : ");
        String[] s1 = sc.nextLine().split(" ");

        System.out.print("int[] b : ");
        String[] s2 = sc.nextLine().split(" ");

        System.out.print("int[] k : ");
        String[] s3 = sc.nextLine().split(" ");

        int n = s1.length;

        if (n != s2.length || n != s3.length) {
            throw new IllegalArgumentException("must be same length");
        }

        int[] a = new int[n];
        int[] b = new int[n];
        int[] k = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s1[i]);
            b[i] = Integer.parseInt(s2[i]);
            k[i] = Integer.parseInt(s3[i]);
        }

        System.out.println("Maximum after addition: ");
        System.out.println(findMax(n, a, b, k));
    }

    /// Solution
    static int findMax(int n, int[] a, int[] b, int[] k) {
        // potd.code.hub
        int len = a.length;
        int[] diffArray = new int[n + 1];

        for (int i = 0; i < len; i++) {
            diffArray[a[i]] += k[i];
            diffArray[b[i] + 1] -= k[i];
        }

        int max = diffArray[0];
        for (int i = 1; i < n; i++) {
            diffArray[i] += diffArray[i - 1];
            max = Math.max(max, diffArray[i]);
        }

        return max;
    }
}
