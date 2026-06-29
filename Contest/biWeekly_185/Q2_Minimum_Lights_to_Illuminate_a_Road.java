package Contest.biWeekly_185;/*
 *
 * https://leetcode.com/contest/biweekly-contest-185/problems/minimum-lights-to-illuminate-a-road/
 *
 * # Q2. Minimum Lights to Illuminate a Road
 *
 *   Q. You are given an integer array lights of length n, representing positions 0 through n - 1 on a road.
 *      For each position i:
 *        ◦ If lights[i] = v, where v > 0, there is a working bulb at position i that illuminates every position from
 *          max(0, i - v) to min(n - 1, i + v), inclusive.
 *        ◦ If lights[i] = 0, there is no working bulb at position i.
 *
 *      A position is visible if it is illuminated by at least one working bulb.
 *
 *      You may install additional bulbs at any positions. Each additional bulb installed at position j illuminates positions
 *      from max(0, j - 1) to min(n - 1, j + 1), inclusive.
 *
 *      Return the minimum number of additional bulbs required to make every position on the road visible.
 *
 *    Ex.
 *      Input : lights = [0,0,0,0]
 *      Output: 2
 *      Explanation:
 *              One optimal placement is:
 *                ◦ Install an additional bulb at position 1, illuminating positions [0, 1, 2].
 *                ◦ Install an additional bulb at position 3, illuminating positions [2, 3].
 *              Therefore, the minimum number of additional bulbs required is 2.
 *
 *  Constraints:
 *     ◦ 1 <= n == lights.length <= 10⁵
 *     ◦ 0 <= lights[i] <= n
 */

public class Q2_Minimum_Lights_to_Illuminate_a_Road {

    /// Solution
    public int minLights(int[] lights) {
        int n = lights.length;
        int count = 0;
        int[] difference = new int[n + 1];

        for (int i = 0; i < n; i++) {
            if (lights[i] > 0) {
                int l = Math.max(i - lights[i], 0);
                int r = Math.min(i + lights[i], n - 1);
                difference[l]++;
                difference[r + 1]--;
            }
        }

        for (int i = 1; i <= n; i++) {
            difference[i] += difference[i - 1];
        }

        int i = 0;
        while (i < n) {
            if (difference[i] == 0) {
                count++;
                i += 3;
            } else i++;
        }

        return count;
    }
}