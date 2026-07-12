package Contest.weekly_510;/*
 *
 * https://leetcode.com/problems/number-of-elapsed-seconds-between-two-times/
 *
 * # Q1. Number of Elapsed Seconds Between Two Times
 *
 *   Q. You are given two valid times startTime and endTime, each represented as a string in the format "HH:MM:SS".
 *      Return the number of seconds that have elapsed from startTime to endTime.
 *
 *    Ex.
 *      Input : startTime = "12:34:56", endTime = "13:00:00"
 *      Output: 1504
 *      Explanation:
 *              endTime is 25 minutes and 4 seconds ahead of startTime, which equals 1504 seconds.
 *
 *  Constraints:
 *        ◦ startTime.length == 8
 *        ◦ endTime.length == 8
 *        ◦ startTime and endTime are valid times in the format "HH:MM:SS"
 *        ◦ 00 <= HH <= 23
 *        ◦ 00 <= MM <= 59
 *        ◦ 00 <= SS <= 59
 *        ◦ endTime is not earlier than startTime
 */

public class Q1_Number_of_Elapsed_Seconds_Between_Two_Times {

    /// Solution
    public int secondsBetweenTimes(String startTime, String endTime) {
        if (startTime.equals(endTime)) return 0;

        String[] s = startTime.split(":");
        String[] e = endTime.split(":");
        long[] start = new long[3];
        long[] end = new long[3];

        for (int i = 0; i < 3; i++) {
            start[i] = Integer.parseInt(s[i]);
            end[i] = Integer.parseInt(e[i]);
        }

        long startSecond = start[2];
        long endSecond = end[2];

        startSecond += start[1] * 60 + start[0] * 3600;
        endSecond += end[1] * 60 + end[0] * 3600;

        return (int) (endSecond - startSecond);
    }
}