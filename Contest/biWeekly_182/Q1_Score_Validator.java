package Contest.biWeekly_182;/*
 *
 * https://leetcode.com/contest/biweekly-contest-182/problems/score-validator/
 *
 * # Q1. Score Validator
 *
 *   Q. You are given a string array events.
 *
 *      Initially, score = 0 and counter = 0. Each element in events is one of the following:
 *        ◦ "0", "1", "2", "3", "4", "6": Add that value to the total score.
 *        ◦ "W": Increase the counter by 1. No score is added.
 *        ◦ "WD": Add 1 to the total score.
 *        ◦ "NB": Add 1 to the total score.
 *
 *      Process the array from left to right. Stop processing when either:
 *        ◦ All elements in events have been processed, or
 *        ◦ The counter becomes 10.
 *
 *      Return an integer array [score, counter], where:
 *        ◦ score is the final total score.
 *        ◦ counter is the final counter value.
 *
 *    Ex.
 *      Input : events = ["1","4","W","6","WD"]
 *      Output: [12,1]
 *      Explanation:
 *              Event | Score | Counter
 *              "1"   |   1   |   0
 *              "4"   |   5   |   0
 *              "W"   |   5   |   1
 *              "6"   |   11  |   1
 *              "WD"  |   12  |   1
 *
 *              Final result: [12, 1].
 *
 *  Constraints:
 *          1 <= events.length <= 1000
 *          events[i] is one of "0", "1", "2", "3", "4", "6", "W", "WD", or "NB".
 */

public class Q1_Score_Validator {

    /// Solution
    public int[] scoreValidator(String[] events) {
        int[] score = {0, 0};

        for (String s : events) {
            if (s.equals("W")) score[1]++;
            else if (s.equals("WD") || s.equals("NB")) score[0]++;
            else score[0] += Integer.parseInt(s);

            if (score[1] == 10) break;
        }

        return score;
    }
}
