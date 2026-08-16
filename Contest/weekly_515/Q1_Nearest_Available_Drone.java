package Contest.weekly_515;/*
 *
 * https://leetcode.com/contest/weekly-contest-515/problems/nearest-available-drone/
 *
 * # Q1. Nearest Available Drone
 *
 *   Q. You are given a 2D integer array drones, where drones[i] = [xi, yi, rangei] represents the x-coordinate,
 *      y-coordinate, and travel range of the ith drone.
 *
 *      You are also given an integer array target = [tx, ty], representing the coordinates of the target.
 *
 *      A drone drones[i] can reach the target if the Manhattan distance between its coordinates and the target
 *      coordinates is less than or equal to its rangei.
 *
 *      Return the index of the reachable drone with the minimum Manhattan distance to the target. If there is a tie,
 *      return the smallest index. If no drone can reach the target, return -1.
 *
 *    Ex.
 *      Input : drones = [[0,0,8],[2,2,9]], target = [3,4]
 *      Output: 1
 *      Explanation:
 *              The distance between drones[0] and target is |0 - 3| + |0 - 4| = 7, which is within its range of 8.
 *              The distance between drones[1] and target is |2 - 3| + |2 - 4| = 3, which is within its range of 9.
 *              Since drones[1] is the nearest drone, the answer is 1.
 *
 *  Constraints:
 *        1 <= drones.length <= 100
 *        drones[i] = [xi, yi, rangei]
 *        target = [tx, ty]
 *        -25 <= xi, yi, tx, ty <= 25
 *        1 <= rangei <= 100
 */

public class Q1_Nearest_Available_Drone {

    /// Solution
    public int nearestDrone(int[][] drones, int[] target) {
        int n = drones.length;
        int minDist = Integer.MAX_VALUE;
        int res = -1;

        for (int i = 0; i < n; i++) {
            int[] drone = drones[i];
            int dist = Math.abs(target[0] - drone[0]) + Math.abs(target[1] - drone[1]);
            if (dist <= drone[2] && dist < minDist) {
                minDist = dist;
                res = i;
            }
        }

        return res;
    }
}
