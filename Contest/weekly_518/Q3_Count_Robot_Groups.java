package Contest.weekly_518;/*
 *
 * https://leetcode.com/contest/weekly-contest-518/problems/count-robot-groups/
 *
 * # Q3. Count Robot Groups
 *
 *   Q. You are given a strictly increasing integer array position, where position[i] is the initial position of the
 *      ith robot at time t = 0.
 *
 *      You are also given an integer array speed, where speed[i] is the constant speed of the ith robot in units per
 *      second, and an integer distance.
 *
 *      Time is continuous and measured in seconds. A robot or group with speed v moves v * t units to the right over
 *      any interval of t seconds.
 *
 *      Whenever the distance between two robots or groups becomes at most distance, they merge into a single group.
 *
 *      If multiple robots or groups satisfy the merging condition at the same time, all merges happen simultaneously.
 *      In particular, every connected collection of robots or groups whose consecutive positions differ by at most
 *      distance merges into one group.
 *
 *      After a merge, the resulting group takes the current position and speed of the rightmost robot in that group.
 *      Once merged, robots never separate.
 *
 *      Return the number of groups remaining after all possible merges have occurred.
 *
 *      An array is strictly increasing if each element is strictly greater than its previous element, if one exists.
 *
 *    Ex.
 *      Input : position = [1, 5, 6, 20],
 *              speed = [4, 3, 2, 3],
 *              distance = 1
 *      Output: 2
 *      Explanation:
 *                ◦ Initially, the groups are {R1}, {R2}, {R3}, and {R4}.
 *
 *                ◦ At t = 0, the robots R2 and R3 at positions 5 and 6, respectively, merge because they are 1 unit
 *                  apart. The resulting group moves with the position and speed of the rightmost robot R3. The groups
 *                  are now {R1}, {R2, R3}, and {R4}.
 *
 *                ◦ Later at t = 2, the robot R1 catches up to the group {R2, R3} and merges with it. The groups are
 *                  now {R1, R2, R3} and {R4}.
 *
 *              Thus, the answer is 2.
 *
 *  Constraints:
 *        ◦ 1 <= position.length == speed.length <= 10⁵
 *        ◦ 1 <= position[i], speed[i], distance <= 10⁹
 *        ◦ position is strictly increasing.
 *
 */

public class Q3_Count_Robot_Groups {

    /// Solution
    public int countGroups(int[] position, int[] speed, int distance) {
        int n = position.length;
        int groups = 1;

        for (int i = n - 2; i >= 0; i--) {
            if (position[i + 1] - position[i] <= distance || speed[i] > speed[i + 1]) {
                speed[i] = speed[i + 1];
            } else {
                groups++;
            }
        }

        return groups;
    }
}