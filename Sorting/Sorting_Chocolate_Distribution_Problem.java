package Sorting;/*
 *
 * https://www.geeksforgeeks.org/problems/chocolate-distribution-problem3825/1
 *
 * # Chocolate Distribution Problem
 *
 *   Q. Given an array arr[] of positive integers, where each value represents the number of chocolates in a packet. Each
 *      packet can have a variable number of chocolates. There are m students, the task is to distribute chocolate packets
 *      among m students such that -
 *          i. Each student gets exactly one packet.
 *         ii. The difference between maximum number of chocolates given to a student and minimum number of chocolates
 *             given to a student is minimum and return that minimum possible difference.
 *    Ex.
 *      Input : arr = [3, 4, 1, 9, 56, 7, 9, 12]
 *              m = 5
 *      Output: 6
 *      Explanation: The minimum difference between maximum chocolates and minimum chocolates is 9 - 3 = 6 by choosing
 *                   following m packets :[3, 4, 9, 7, 9].
 *
 *  Constraints:
 *          1 ≤ m <= arr.size ≤ 10⁵
 *          1 ≤ arr[i] ≤ 10⁹
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Sorting_Chocolate_Distribution_Problem {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Array elements: ");
        String[] s = sc.nextLine().split(" ");

        ArrayList<Integer> list = new ArrayList<>();
        for (String ele : s) list.add(Integer.parseInt(ele));

        System.out.print("m : ");
        int m = sc.nextInt();

        System.out.println("Minimum difference between max chocolates and min chocolates: ");
        System.out.println(findMinDiff(list, m));
    }

    /// Solution
    static int findMinDiff(ArrayList<Integer> arr, int m) {
        int n = arr.size();
        int ans = Integer.MAX_VALUE;

        Collections.sort(arr);

        for (int i = m - 1; i < n; i++) {
            ans = Math.min(ans, arr.get(i) - arr.get(i - m + 1));
        }

        return ans;
    }
}
