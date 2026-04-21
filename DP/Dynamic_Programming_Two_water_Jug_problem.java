package DP;/*
 *
 * https://www.geeksforgeeks.org/problems/two-water-jug-problem3402/1
 *
 * # Two water Jug problem
 *
 *   Q. You are at the side of a river. You are given an m liter jug and an n liter jug . Both the jugs are initially empty.
 *      The jugs don't have markings to allow measuring smaller quantities. You have to use the jugs to measure d liters of
 *      water . Determine the minimum no of operations to be performed to obtain d liters of water in one of the jugs.
 *
 *      The operations you can perform are:
 *        ◦ Empty a Jug
 *        ◦ Fill a Jug
 *        ◦ Pour water from one jug to the other until one of the jugs is either empty or full.
 *
 *    Ex.
 *      Input : m = 3, n = 5, d = 4
 *      Output: 6
 *      Explanation: Operations are as follows-
 *                   1. Fill up the 5 liter jug.
 *                   2. Then fill up the 3 liter jug using 5 liter jug. Now 5 liter jug contains 2 liter water.
 *                   3. Empty the 3 liter jug.
 *                   4. Now pour the 2 liter of water from 5 liter jug to 3 liter jug.
 *                   5. Now 3 liter jug contains 2 liter of water and 5 liter jug is empty.
 *                   6. Now fill up the 5 liter jug.
 *                   7. Now fill one liter of water from 5 liter jug to 3 liter jug. Now we have 4 liter water in 5 liter jug.
 *
 *  Constraints:
 *          1 ≤ n, m ≤ 100
 *          1 ≤ d ≤ 100
 */

import java.util.Scanner;

public class Dynamic_Programming_Two_water_Jug_problem {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Capacity of jug-1: ");
        int m = sc.nextInt();

        System.out.print("Capacity of jug-2: ");
        int n = sc.nextInt();

        System.out.print("Capacity required: ");
        int d = sc.nextInt();

        System.out.print("Minimum number of steps: ");
        System.out.println(minSteps(m, n, d));
    }

    /// Solution
    static int minSteps(int m, int n, int d) {
        // potd.code.hub
        if (d > Math.max(n, m)) return  -1;

        int gcd = gcd(m, n);
        if (d % gcd != 0) return -1;

        return Math.min(solve(m, n, d), solve(n, m, d));
    }

    private static int solve(int from, int to, int d) {
        int m = from;
        int n = to;
        from = to = 0;
        int step = 0;

        while (from != d && to != d) {
            if (from == 0) {
                from = m;
            } else if (to == n) {
                to = 0;
            } else {
                int temp = from;
                from = Math.max(0, from - n + to);
                to = Math.min(n, to + temp);
            }

            step++;
        }

        return step;
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
