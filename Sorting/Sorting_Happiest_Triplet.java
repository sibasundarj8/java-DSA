package Sorting;/*
 *
 * https://www.geeksforgeeks.org/problems/happiest-triplet2921/1
 *
 * # Happiest Triplet
 *
 *   Q. You are given three arrays a[], b[], c[] of the same size . Find a triplet such that (maximum-minimum) in that triplet
 *      is the minimum of all the triplets. A triplet should be selected so that it should have one number from each of the three
 *      given arrays. This triplet is the happiest among all the possible triplets. Print the triplet in decreasing order.
 *
 *      Note: If there are 2 or smallest difference triplets, then the one with the smallest sum of its elements should
 *            be displayed.
 *    Ex.
 *      Input : a[] = [15, 12, 18, 9],
 *              b[] = [10, 17, 13, 8],
 *              c[] = [14, 16, 11, 5]
 *      Output: [11, 10, 9]
 *      Explanation: Multiple triplets have the same minimum difference, and among them [11, 10, 9] has the smallest sum, so
 *                   it is chosen.
 *
 *  Constraints:
 *      1 ≤ a.size(), b.size() ,c.size() ≤ 10⁵
 *      1 ≤ a[i], b[i], c[i] ≤ 10⁵
 */

import java.util.Arrays;
import java.util.Scanner;

public class Sorting_Happiest_Triplet {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter elements of array A: ");
        String[] s = sc.nextLine().split(" ");

        int n =  s.length;
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s[i]);
        }

        System.out.println("Enter elements of array B: ");
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        System.out.println("Enter elements of array C: ");
        for (int i = 0; i < n; i++) {
            c[i] = sc.nextInt();
        }

        System.out.println("Smallest triplet elements: ");
        System.out.println(Arrays.toString(smallestDiff(a, b, c)));
    }

    /// Solution
    static int[] smallestDiff(int[] a, int[] b, int[] c) {
        // potd.code.hub
        int n = a.length;
        int i = 0;
        int j = 0;
        int k = 0;
        int smallestHappyLevel = Integer.MAX_VALUE;
        int[] ans = new int[3];

        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);

        while (i < n && j < n && k < n) {
            int currHappyLevel = getHappyLevel(a[i], b[j], c[k]);

            if (currHappyLevel < smallestHappyLevel) {
                smallestHappyLevel = currHappyLevel;
                ans[0] = a[i];
                ans[1] = b[j];
                ans[2] = c[k];
            }

            if (a[i] <= b[j] && a[i] <= c[k]) i++;
            else if (b[j] <= c[k]) j++;
            else k++;
        }

        // re-formating the answer array
        Arrays.sort(ans);
        int temp = ans[0];
        ans[0] = ans[2];
        ans[2] = temp;

        return ans;
    }

    private static int getHappyLevel(int a, int b, int c) {
        int max = Math.max(a, Math.max(b, c));
        int min = Math.min(a, Math.min(b, c));

        return max - min;
    }
}
