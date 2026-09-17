package Contest.biWeekly_191;
/*
 *
 * https://leetcode.com/contest/biweekly-contest-191/problems/minimum-days-to-score-exactly-n-points/
 *
 * # Q3. Minimum Days to Score Exactly N Points
 *
 *   Q. You are given an integer n representing a target score.
 *
 *      Your score starts at 0, and each day you either earn points or skip.
 *
 *      Points are earned during a streak. On the first day of a streak you earn 1 point, on the second day 2 points,
 *      on the third day 3 points, and so on. Skipping a day earns nothing and resets the streak, so the next time you
 *      earn points, you start from 1 again.
 *
 *      Return the minimum number of days, including any skipped days, needed to reach a score of exactly n.
 *
 *    Ex.
 *      Input : n = 2
 *      Output: 3
 *      Explanation:
 *                ◦ Day 1: earn 1 point. Score is 1.
 *                ◦ Day 2: skip, which resets the streak. Earning here would add 2 points and take the score past n = 2.
 *                ◦ Day 3: the streak has reset, so earning gives 1 point. Score is exactly n = 2 in 3 days.
 *
 *  Constraints:
 *        ◦ 1 <= n <= 10⁵
 */

public class Q3_Minimum_Days_to_Score_Exactly_N_Points {

    /// Solution
    public int minDays(int n) {
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            int points = 1;

            for (int k = 1; points <= i; k++) {
                min = Math.min(min, dp[i - points] + k + 1);
                points += (k + 1);
            }

            dp[i] = min;
        }

        return dp[n] - 1;
    }
}