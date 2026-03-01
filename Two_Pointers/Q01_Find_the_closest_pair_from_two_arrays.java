package Two_Pointers;/*
 *
 * https://www.geeksforgeeks.org/problems/find-the-closest-pair-from-two-arrays4215/1
 *
 * # Find the closest pair from two arrays
 *
 *   Q. Given two sorted arrays arr1[] and arr2[] of size n and m and a number x, find the pair whose sum is closest to x
 *      and the pair has an element from each array. In the case of multiple closest pairs return any one of them.
 *
 *      Note : In the driver code, the absolute difference between the sum of the closest pair and x is printed.
 *
 *    Ex.
 *      Input : arr1[] = [1, 4, 5, 7],
 *              arr2[] = [10, 20, 30, 40],
 *              x = 32
 *      Output: [1, 30]
 *      Explanation:The closest pair whose sum is closest to 32 is [1, 30] = 31.
 *
 *  Constraints:
 *          1 ≤ arr1.size(), arr2.size() ≤ 10⁵
 *          1 ≤ arr1[i], arr2[i] ≤ 10⁹
 *          1 ≤ x ≤ 10⁹
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Q01_Find_the_closest_pair_from_two_arrays {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array-1 elements: ");
        String[] s1 = sc.nextLine().split(" ");

        System.out.println("Enter array-1 elements: ");
        String[] s2 = sc.nextLine().split(" ");

        int n = s1.length;
        int m = s2.length;
        int[] arr1 = new int[n];
        int[] arr2 = new int[m];

        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(s1[i]);
        }
        for (int i = 0; i < m; i++) {
            arr2[i] = Integer.parseInt(s2[i]);
        }

        System.out.println("X : ");
        int x = sc.nextInt();

        System.out.println("Closest pair: " + findClosestPair(arr1, arr2, x));
    }

    /// Solution
    static ArrayList<Integer> findClosestPair(int[] arr1, int[] arr2, int x) {
        // potd.code.hub
        int n = arr1.length;
        int m = arr2.length;
        int i = 0;
        int j = m - 1;

        int val1 = arr1[0];
        int val2 = arr2[m - 1];
        int diff = Math.abs(x - (val1 + val2));

        while (i < n && j >= 0) {
            int sum = arr1[i] + arr2[j];
            int currDiff = Math.abs(x - sum);

            if (currDiff < diff) {
                val1 = arr1[i];
                val2 = arr2[j];
                diff = currDiff;
            }

            if (sum < x) i++;
            else if (sum > x) j--;
            else break;
        }

        ArrayList<Integer> list = new ArrayList<>();
        list.add(val1);
        list.add(val2);

        return list;
    }
}
