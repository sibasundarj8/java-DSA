package Math_;/*
 *
 * https://www.geeksforgeeks.org/problems/sort-the-given-array-after-applying-the-given-equation0304/1
 *
 * # Sort the given array after applying the given equation
 *
 *   Q. Given an integer array arr[] sorted in ascending order, along with three integers: A, B, and C. The task
 *      is to transform each element x in the array using the quadratic function A*(x2) + B*x + C. After applying
 *      this transformation to every element, return the modified array in sorted order.
 *    Ex.
 *      Input : arr[] = [-4, -2, 0, 2, 4]
 *              A = 1
 *              B = 3
 *              C = 5
 *      Output: [3, 5, 9, 15, 33]
 *      Explanation: After applying f(x) = 1*(x2)+ 3*x + 5 to each x, we get [9, 3, 5, 15, 33].
 *                   After sorting this array, the array becomes [3, 5, 9, 15, 33].
 */

import java.util.*;

public class Math_Sort_the_given_array_after_applying_the_given_equation {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.print("a: ");
        int a = sc.nextInt();

        System.out.print("b: ");
        int b = sc.nextInt();

        System.out.print("c: ");
        int c = sc.nextInt();

        System.out.println(sortArray(arr, a, b, c));
    }

    /// Solution
    static ArrayList<Integer> sortArray(int[] arr, int A, int B, int C) {
        // potd.code.hub
        int n = arr.length;
        int[] ans = new int[n];
        int idx = (A < 0) ? 0 : n-1;

        int i = 0, j = n - 1;
        while (i <= j) {
            int left = f(arr[i], A, B, C);
            int right = f(arr[j], A, B, C);

            if (A < 0) {
                if (left < right) {
                    ans[idx++] = left;
                    i++;
                } else {
                    ans[idx++] = right;
                    j--;
                }
            } else {
                if (left > right) {
                    ans[idx--] = left;
                    i++;
                } else {
                    ans[idx--] = right;
                    j--;
                }
            }
        }

        ArrayList<Integer> res = new ArrayList<>(n);
        Arrays.stream(ans).forEach(res::add);

        return res;
    }

    private static int f(long x, int a, long b, int c) {
        long ans = a * x * x + b * x + c;
        return (int) ans;
    }
}
