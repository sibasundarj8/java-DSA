package LeetCode;/*
 *
 * https://leetcode.com/problems/remove-covered-intervals/
 *
 * # LC. 1288. Remove Covered Intervals
 *
 *   Q. Given an array intervals where intervals[i] = [l-i, r-i] represent the interval [l-i, r-i],
 *      remove all intervals that are covered by another interval in the list.
 *
 *      The interval [a, b] is covered by the interval [c, d] if and only if c <= a and b <= d.
 *
 *      Return the number of remaining intervals.
 *
 *    Ex.
 *      Input : intervals = [[1, 4],
 *                           [3, 6],
 *                           [2, 8]]
 *      Output: 2
 *      Explanation: Interval [3, 6] is covered by [2, 8], therefore it is removed.
 *
 *  Constraints:
 *       ◦ 1 <= intervals.length <= 1000
 *       ◦ intervals[i].length == 2
 *       ◦ 0 <= l-i < r-i <= 10⁵
 *       ◦ All the given intervals are unique.
 */

import java.util.Arrays;
import java.util.Scanner;

public class LeetCode_1288_Remove_Covered_Intervals {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of intervals: ");
        int n = sc.nextInt();
        int[][] intervals = new int[n][2];

        System.out.println("Enter intervals: ");
        for (int i = 0; i < n; i++) {
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
        }

        System.out.println("Number of remaining intervals after removing covered intervals: ");
        System.out.println(removeCoveredIntervals(intervals));
    }

    /// Solution
    static int removeCoveredIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });

        int maxEnd = -1;
        int coveredCount = 0;

        for (int[] interval : intervals) {
            int curEnd = interval[1];
            if (curEnd <= maxEnd) coveredCount++;
            else maxEnd = curEnd;
        }

        return n - coveredCount;
    }
}
