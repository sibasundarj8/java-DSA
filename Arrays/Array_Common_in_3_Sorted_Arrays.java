package Array;/*
 *
 * https://www.geeksforgeeks.org/problems/common-elements1132/1
 *
 * # Common in 3 Sorted Arrays
 *
 *   Q. Given three sorted arrays in non-decreasing order, return all common elements in non-decreasing order across these
 *      arrays. If there are no such elements return an empty array.
 *
 *    Ex.
 *      Input : a[] = [1, 5, 10, 20, 40, 80];
 *              b[] = [6, 7, 20, 80, 100];
 *              c[] = [3, 4, 15, 20, 30, 70, 80, 120];
 *      Output: [20, 80]
 *      Explanation: The elements 20 and 80 appear in all three arrays a, b, and c, making them the only common elements,
 *                   so the output is [20, 80].
 *
 *  Constraints:
 *          1 ≤ a.size(), b.size(), c.size() ≤ 10⁵
 *          -105 ≤ a[i], b[i] , c[i] ≤ 10⁵
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Array_Common_in_3_Sorted_Arrays {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter elements of a[]: ");
        String[] s1 = sc.nextLine().split(" ");

        System.out.println("Enter elements of b[]: ");
        String[] s2 = sc.nextLine().split(" ");

        System.out.println("Enter elements of c[]: ");
        String[] s3 = sc.nextLine().split(" ");

        int len1 = s1.length;
        int len2 = s2.length;
        int len3 = s3.length;
        int[] a = new int[len1];
        int[] b = new int[len2];
        int[] c = new int[len3];

        for (int x = 0; x < len1; x++) a[x] = Integer.parseInt(s1[x]);
        for (int x = 0; x < len2; x++) b[x] = Integer.parseInt(s2[x]);
        for (int x = 0; x < len3; x++) c[x] = Integer.parseInt(s3[x]);

        System.out.println("Common elements in non-decreasing order : ");
        System.out.println(commonElements(a, b, c));
    }

    /// Solution
    static ArrayList<Integer> commonElements(int[] a, int[] b, int[] c) {
        // code here
        int n1 = a.length;
        int n2 = b.length;
        int n3 = c.length;
        int i = 0;
        int j = 0;
        int k = 0;
        ArrayList<Integer> list = new ArrayList<>();

        while (i < n1 && j < n2 && k < n3) {
            int aVal = a[i];
            int bVal = b[j];
            int cVal = c[k];

            // removing duplicates.
            if (i > 0 && aVal == a[i - 1]) {
                i++;
                continue;
            }

            if (j > 0 && bVal == b[j - 1]) {
                j++;
                continue;
            }

            if (k > 0 && cVal == c[k - 1]) {
                k++;
                continue;
            }

            // checking only uniques.
            if (aVal == bVal && bVal == cVal) list.add(aVal);
            if (aVal <= bVal && aVal <= cVal) i++;
            if (bVal <= aVal && bVal <= cVal) j++;
            if (cVal <= aVal && cVal <= bVal) k++;
        }

        return list;
    }
}
