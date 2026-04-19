package Contest.biWeekly_180;/*
 * https://leetcode.com/contest/biweekly-contest-180/problems/traffic-signal-color/
 *
 * # Q1. Traffic Signal Color
 *
 *   Q. You are given an integer timer representing the remaining time (in seconds) on a traffic signal.
 *
 *      The signal follows these rules:
 *          If timer == 0, the signal is "Green"
 *          If timer == 30, the signal is "Orange"
 *          If 30 < timer <= 90, the signal is "Red"
 *          Return the current state of the signal. If none of the above conditions are met, return "Invalid".
 *
 *      Ex:
 *          Input : timer = 60
 *          Output: "Red"
 *          Explanation: Since timer = 60, and 30 < timer <= 90, the answer is "Red".
 *
 *  Constraints:
 *      0 <= timer <= 1000
 */

public class Q1_Traffic_Signal_Color {

    /// Solution
    public String trafficSignal(int timer) {
        if (timer == 0) return "Green";
        if (timer == 30) return "Orange";
        if (30 < timer && timer <= 90) return "Red";
        return "Invalid";
    }
}
