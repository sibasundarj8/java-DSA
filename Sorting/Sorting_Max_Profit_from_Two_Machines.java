package Sorting;/*
 *
 * https://www.geeksforgeeks.org/problems/max-profit-from-two-machines/1
 *
 * # Max Profit from Two Machines
 *
 *   Q. Given two machines, Machine A and Machine B, and a set of n tasks. The profit earned for performing each task is
 *      given in two arrays a[] and b[] such that if Machine A performs the i-th task, the profit is a[i], and if Machine
 *      B performs it, the profit is b[i].
 *
 *      Machine A can process at most x tasks, and Machine B can process at most y tasks. It is guaranteed that x + y ≥ n,
 *      so all tasks can be assigned. Return the maximum possible profit after assigning each task to either Machine A or
 *      Machine B.
 *
 *    Ex.
 *      Input : x = 3, y = 4,
 *              a[] = [8, 7, 15, 19, 16, 16, 18],
 *              b[] = [1, 7, 15, 11, 12, 31, 9]
 *      Output: 110
 *      Explanation: Machine A performs tasks with indices [0, 3, 6], and Machine B performs the rest [1, 2, 4, 5], giving
 *                   profits (8 + 19 + 18) + (7 + 15 + 12 + 31) = 110.
 *
 *  Constraints:
 *          1 ≤ a.size() == b.size() ≤ 10⁵
 *          1 ≤ x, y ≤ 10⁵
 *          1 ≤ a[i], b[i] ≤ 10⁴
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Sorting_Max_Profit_from_Two_Machines {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Limit of machine A: ");
        int x = sc.nextInt();

        System.out.println("Limit of machine B: ");
        int y = sc.nextInt();
        sc.nextLine();

        System.out.println("enter of profits for work i of machine A: ");
        String[] s1 = sc.nextLine().split(" ");

        int n = s1.length;
        int[] a = new int[n];
        int[] b = new int[n];

        System.out.println("enter of profits for work i of machine B: ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s1[i]);
            b[i] = sc.nextInt();
        }

        System.out.println("Max profit we can get: ");
        System.out.println(maxProfit(x, y, a, b));
    }

    /// Solution
    static int maxProfit(int x, int y, int[] a, int[] b) {
        // potd.code.hub
        int n = a.length;
        int profit = 0;
        Integer[] indices = new Integer[n];

        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, Comparator.comparingInt(idx -> -(Math.abs(a[idx] - b[idx]))));

        for (int idx : indices) {
            if ((a[idx] >= b[idx] && x > 0) || y == 0) {
                profit += a[idx];
                x--;
            } else {
                profit += b[idx];
                y--;
            }
        }

        return profit;
    }
} 
