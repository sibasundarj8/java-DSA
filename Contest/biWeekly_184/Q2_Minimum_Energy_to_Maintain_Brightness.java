package Contest.biWeekly_184;/*
 *
 * https://leetcode.com/contest/biweekly-contest-184/problems/minimum-energy-to-maintain-brightness/
 *
 * # Q2. Minimum Energy to Maintain Brightness
 *
 *   Q. You are given an integer n, representing n light bulbs arranged in a line and indexed from 0 to n - 1.
 *
 *      You are also given an integer brightness and a 2D integer array intervals, where intervals[i] = [start_i, end_i]
 *      represents an inclusive time interval during which the lighting requirement must be satisfied.
 *
 *      At each time unit, every bulb can independently be either on or off. A bulb that is on illuminates its own position
 *      and its adjacent positions, if they exist.
 *
 *      The total illumination at a time unit is the number of illuminated positions. Each position is counted at most once.
 *
 *      For every integer time unit covered by at least one interval in intervals, the total illumination must be at least
 *      brightness. At time units not covered by any interval, all bulbs may remain off. Each bulb that is on consumes 1
 *      unit of energy for that time unit.
 *
 *      Return an integer denoting the minimum total energy required.
 *
 *    Ex.
 *      Input : n = 5, brightness = 5, intervals = [[6,12]]
 *      Output: 14
 *      Explanation:
 *              Turn on the light bulbs at positions 1 and 4.
 *              Current state of line: 0 1 0 0 1.
 *              All 5 positions are illuminated, so the required brightness is reached.
 *              The active interval has length 12 - 6 + 1 = 7, so the total energy is 2 * 7 = 14.
 *
 *  Constraints:
 *        ◦ 1 <= n <= 10⁶
 *        ◦ 1 <= brightness <= n
 *        ◦ 1 <= intervals.length <= 10⁵
 *        ◦ intervals[i] == [start_i, end_i]
 *        ◦ 0 <= start_i <= end_i <= 10⁹
 */

import java.util.Arrays;
import java.util.Comparator;

public class Q2_Minimum_Energy_to_Maintain_Brightness {

    /// Solution
    public long minEnergy(int n, int brightness, int[][] intervals) {
        int totalActiveTime = totalTime(intervals);
        int minBulb = (brightness + 2) / 3;

        return (long) totalActiveTime * minBulb;
    }

    private int totalTime(int[][] intervals) {
        int total = 0;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int n = intervals.length;
        int startTime = intervals[0][0];
        int endTime = intervals[0][1];

        for (int i = 1; i < n; i++) {
            if (endTime < intervals[i][0]) {
                total += (endTime - startTime + 1);
                startTime = intervals[i][0];
            }

            endTime = Math.max(endTime, intervals[i][1]);
        }

        total += (endTime - startTime + 1);

        return total;
    }
}