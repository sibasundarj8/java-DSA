package DP;/*
 *
 * https://leetcode.com/problems/minimum-total-distance-traveled/
 *
 * # 2463. Minimum Total Distance Traveled
 *
 *   Q. There are some robots and factories on the X-axis. You are given an integer array robot where robot[i] is the position
 *      of the ith robot. You are also given a 2D integer array factory where factory[j] = [position-j, limit-j] indicates that
 *      position-j is the position of the jth factory and that the jth factory can repair at most limit-j robots.
 *
 *      The positions of each robot are unique. The positions of each factory are also unique. Note that a robot can be in the
 *      same position as a factory initially.
 *
 *      All the robots are initially broken; they keep moving in one direction. The direction could be the negative or the positive
 *      direction of the X-axis. When a robot reaches a factory that did not reach its limit, the factory repairs the robot, and it
 *      stops moving.
 *
 *      At any moment, you can set the initial direction of moving for some robot. Your target is to minimize the total distance
 *      traveled by all the robots.
 *
 *      Return the minimum total distance traveled by all the robots. The test cases are generated such that all the robots can be
 *      repaired.
 *
 *      Note that:
 *          ￮ All robots move at the same speed.
 *          ￮ If two robots move in the same direction, they will never collide.
 *          ￮ If two robots move in opposite directions, and they meet at some point, they do not collide. They cross each other.
 *          ￮ If a robot passes by a factory that reached its limits, it crosses it as if it does not exist.
 *          ￮ If the robot moved from a position x to a position y, the distance it moved is |y - x|.
 *
 *    Ex.
 *      Input : robot = [0, 4, 6], factory = [[2, 2], [6, 2]]
 *                                                                           R      F[2]       R      R,F[2]
 *      Output: 4                                            ⎯⎯|⎯⎯|⎯⎯|⎯⎯|⎯⎯|⎯⎯|⎯⎯|⎯⎯|⎯⎯|⎯⎯|⎯⎯|⎯⎯|⎯⎯
 *                                                             -3   -2  -1   0    1   2   3   4    5   6    7   8
 *      Explanation: As shown in the figure:
 *              - The first robot at position 0 moves in the positive direction. It will be repaired at the first factory.
 *              - The second robot at position 4 moves in the negative direction. It will be repaired at the first factory.
 *              - The third robot at position 6 will be repaired at the second factory. It does not need to move.
 *              The limit of the first factory is 2, and it fixed 2 robots.
 *              The limit of the second factory is 2, and it fixed 1 robot.
 *              The total distance is |2 - 0| + |2 - 4| + |6 - 6| = 4. It can be shown that we cannot achieve a better total distance than 4.
 *
 *  Constraints:
 *          1 <= robot.length, factory.length <= 100
 *          factory[j].length == 2
 *          -10⁹ <= robot[i], position-j <= 10⁹
 *          0 <= limit-j <= robot.length
 *          The input will be generated such that it is always possible to repair every robot.
 */

import java.util.*;

public class Dynamic_Programming_Minimum_Total_Distance_Traveled {

    ///  main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> robots = new ArrayList<>();

        System.out.println("Enter position of robots: ");
        String[] s = sc.nextLine().split(" ");

        for (String pos : s) {
            robots.add(Integer.parseInt(pos));
        }

        System.out.println("Enter number of factories: ");
        int n = sc.nextInt();

        int[][] factories = new int[n][2];

        System.out.println("Enter position and limit of Factories: ");
        for (int i = 0; i < n; i++) {
            factories[i][0] = sc.nextInt();
            factories[i][1] = sc.nextInt();
        }

        System.out.println("Minimum distance traveled by the robot: ");
        System.out.println(minimumTotalDistance(robots, factories));
    }

    /// Solution
/*
◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦-Brute-Force-◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦
TC : O(2ⁿ × f)
SC : O(n)
*/
    static long bruteforce(List<Integer> robot, int[][] factory) {
        int n = robot.size();
        Arrays.sort(factory, Comparator.comparingInt(f -> f[0]));

        return rec(n - 1, robot, factory);
    }

    private static long rec(int idx, List<Integer> robots, int[][] factories) {
        // base case
        if (idx < 0) return 0;

        // self work
        int[] nearestFactories = getNearestFactories(robots.get(idx), factories);
        int leftPos = nearestFactories[0];
        int rightPos = nearestFactories[1];
        long leftDist = (leftPos != -1) ? Math.abs(factories[leftPos][0] - robots.get(idx)) : -1;
        long rightDist = (rightPos != -1) ? Math.abs(factories[rightPos][0] - robots.get(idx)) : -1;

        // recursive case
        long goLeft = Long.MAX_VALUE;
        long goRight = Long.MAX_VALUE;

        // choose to go left
        if (leftPos != -1) {
            factories[leftPos][1]--;
            goLeft = rec(idx - 1, robots, factories) + leftDist;
            factories[leftPos][1]++;
        }

        // choose to go right
        if (rightPos != -1) {
            factories[rightPos][1]--;
            goRight = rec(idx - 1, robots, factories) + rightDist;
            factories[rightPos][1]++;
        }

        return Math.min(goLeft, goRight);
    }

    private static int[] getNearestFactories(int pos, int[][] dist) {
        int[] res = {-1, -1};
        int n = dist.length;

        for (int i = 0; i < n; i++) {
            if (pos == dist[i][0] && 0 < dist[i][1]) {
                res[0] = res[1] = i;
                break;
            }
            if (dist[i][0] < pos && 0 < dist[i][1]) res[0] = i;
            if (dist[i][0] > pos && 0 < dist[i][1]) {
                res[1] = i;
                break;
            }
        }

        return res;
    }

/*
◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦-memoization-◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦
TC : O(m × n)
SC : O(m × n) + recursion stack O(m + n)
*/
    static long memoization(List<Integer> robot, int[][] factory) {
        List<Integer> factories = new ArrayList<>();

        Collections.sort(robot);
        Arrays.sort(factory, Comparator.comparingInt(f -> f[0]));

        for (int[] fact : factory) {
            for (int i = 0; i < fact[1]; i++) {
                factories.add(fact[0]);
            }
        }

        int n = robot.size();
        int m = factories.size();
        long[][] dp = new long[m][n];

        for (long[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        return rec(0, 0, m, n, robot, factories, dp);
    }

    private static long rec(int fi, int ri, int m, int n, List<Integer> robots, List<Integer> factories, long[][] dp) {
        // base case
        if (ri >= n) return 0;
        if (fi >= m) return (long) 1e18;
        if (dp[fi][ri] != -1) return dp[fi][ri];

        // recursive work
        int cost = Math.abs(factories.get(fi) - robots.get(ri));
        long pick = rec(fi + 1, ri + 1, m, n, robots, factories, dp) + cost;
        long skip = rec(fi + 1, ri, m, n, robots, factories, dp);

        // self work
        return dp[fi][ri] = Math.min(pick, skip);
    }

/*
◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦-Tabulation-◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦
TC : O(m × n)
SC : O(m × n)
*/
    static long tabulation(List<Integer> robot, int[][] factory) {
        List<Integer> factories = new ArrayList<>();

        Collections.sort(robot);
        Arrays.sort(factory, Comparator.comparingInt(f -> f[0]));

        for (int[] fact : factory) {
            for (int i = 0; i < fact[1]; i++) {
                factories.add(fact[0]);
            }
        }

        int n = robot.size();
        int m = factories.size();
        long[][] dp = new long[m + 1][n + 1];

        for (int i = 0; i < n; i++) {
            dp[m][i] = (long) 1e18;
        }

        for (int fi = m - 1; fi >= 0; fi--) {
            for (int ri = n - 1; ri >= 0; ri--) {

                // recursive work simulation
                int cost = Math.abs(factories.get(fi) - robot.get(ri));
                long pick = dp[fi + 1][ri + 1] + cost;
                long skip = dp[fi + 1][ri];

                // self work simulation
                dp[fi][ri] = Math.min(pick, skip);

            }
        }

        return dp[0][0];
    }

/*
◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦-space-optimization-◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦
TC = O(m × n)
SC = O(n)
*/
    static long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        List<Integer> factories = new ArrayList<>();

        Collections.sort(robot);
        Arrays.sort(factory, Comparator.comparingInt(f -> f[0]));

        for (int[] fact : factory) {
            for (int i = 0; i < fact[1]; i++) {
                factories.add(fact[0]);
            }
        }

        int n = robot.size();
        int m = factories.size();
        long[] next = new long[n + 1];
        long[] curr = new long[n + 1];

        Arrays.fill(next,  (long) 1e18);
        next[n] = 0;

        for (int fi = m - 1; fi >= 0; fi--) {
            for (int ri = n - 1; ri >= 0; ri--) {

                curr[n] = 0;

                // recursive work simulation
                int cost = Math.abs(factories.get(fi) - robot.get(ri));
                long pick = next[ri + 1] + cost;
                long skip = next[ri];

                // self work simulation
                curr[ri] = Math.min(pick, skip);

            }
            long[] temp = next;
            next = curr;
            curr = temp;
        }

        return next[0];
    }
}
