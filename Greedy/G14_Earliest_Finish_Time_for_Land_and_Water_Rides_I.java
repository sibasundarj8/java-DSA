package Greedy;/*
 *
 * https://leetcode.com/problems/earliest-finish-time-for-land-and-water-rides-i/
 *
 * # 3633. Earliest Finish Time for Land and Water Rides I
 *
 *   Q. You are given two categories of theme park attractions: land rides and water rides.
 *
 *      • Land rides
 *          ◦ landStartTime[i] – the earliest time the ith land ride can be boarded.
 *          ◦ landDuration[i] – how long the ith land ride lasts.
 *
 *      • Water rides
 *          ◦ waterStartTime[j] – the earliest time the jth water ride can be boarded.
 *          ◦ waterDuration[j] – how long the jth water ride lasts.
 *
 *      A tourist must experience exactly one ride from each category, in either order.
 *          ◦ A ride may be started at its opening time or any later moment.
 *          ◦ If a ride is started at time t, it finishes at time t + duration.
 *          ◦ Immediately after finishing one ride the tourist may board the other (if it is already open) or wait until
 *            it opens.
 *
 *      Return the earliest possible time at which the tourist can finish both rides.
 *
 *    Ex.
 *      Input : landStartTime = [2, 8],
 *              landDuration = [4, 1],
 *              waterStartTime = [6],
 *              waterDuration = [3]
 *      Output: 9
 *      Explanation:
 *              • Plan A (land ride 0 → water ride 0):
 *                  ◦ Start land ride 0 at time landStartTime[0] = 2. Finish at 2 + landDuration[0] = 6.
 *                  ◦ Water ride 0 opens at time waterStartTime[0] = 6. Start immediately at 6, finish at 6 + waterDuration[0] = 9.
 *
 *              • Plan B (water ride 0 → land ride 1):
 *                  ◦ Start water ride 0 at time waterStartTime[0] = 6. Finish at 6 + waterDuration[0] = 9.
 *                  ◦ Land ride 1 opens at landStartTime[1] = 8. Start at time 9, finish at 9 + landDuration[1] = 10.
 *
 *              • Plan C (land ride 1 → water ride 0):
 *                  ◦ Start land ride 1 at time landStartTime[1] = 8. Finish at 8 + landDuration[1] = 9.
 *                  ◦ Water ride 0 opened at waterStartTime[0] = 6. Start at time 9, finish at 9 + waterDuration[0] = 12.
 *
 *              • Plan D (water ride 0 → land ride 0):
 *                  ◦ Start water ride 0 at time waterStartTime[0] = 6. Finish at 6 + waterDuration[0] = 9.
 *                  ◦ Land ride 0 opened at landStartTime[0] = 2. Start at time 9, finish at 9 + landDuration[0] = 13.
 *
 *              Plan A gives the earliest finish time of 9.
 *
 *  Constraints:
 *      ◦ 1 <= n, m <= 100
 *      ◦ landStartTime.length == landDuration.length == n
 *      ◦ waterStartTime.length == waterDuration.length == m
 *      ◦ 1 <= landStartTime[i], landDuration[i], waterStartTime[j], waterDuration[j] <= 1000
 */

import java.util.Scanner;

public class G14_Earliest_Finish_Time_for_Land_and_Water_Rides_I {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter landStartTime[] elements: ");
        String[] s1 = sc.nextLine().split(" ");

        int n = s1.length;
        int[] landStartTime = new int[n];
        int[] landDuration = new int[n];

        System.out.println("Enter landDuration[] elements: ");
        for (int i = 0; i < n; i++) {
            landStartTime[i] = Integer.parseInt(s1[i]);
            landDuration[i] = sc.nextInt();
        }

        System.out.println("Enter waterStartTime[] elements: ");
        String[] s2 = sc.nextLine().split(" ");

        int m = s2.length;
        int[] waterStartTime = new int[m];
        int[] waterDuration = new int[m];

        System.out.println("Enter waterDuration[] elements: ");
        for (int i = 0; i < m; i++) {
            waterStartTime[i] = Integer.parseInt(s2[i]);
            waterDuration[i] = sc.nextInt();
        }

        System.out.println("Earliest possible time at which the tourist can finish both rides: ");
        System.out.println(earliestFinishTime(landStartTime, landDuration, waterStartTime, waterDuration));
    }

    /// Solution
/*
☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒-Brute-Force-☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒
TC : O(n * m)
SC : O(1)
*/
    static int bruteForce(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n = landStartTime.length;
        int m = waterStartTime.length;
        int minTime = Integer.MAX_VALUE;

        // try every possible combination.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int landEndTime = landStartTime[i] + landDuration[i];
                int waterEndTime = waterStartTime[j] + waterDuration[j];

                // try first land and then water
                int a = Math.max(landEndTime, waterStartTime[j]) + waterDuration[j];

                // try first water and then land
                int b = Math.max(waterEndTime, landStartTime[i]) + landDuration[i];

                minTime = Math.min(minTime, Math.min(a, b));
            }
        }

        return minTime;
    }

/*
☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑-Greedy-☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑
TC : O(n + m)
SC : O(1)
*/
    static int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        // potd.code.hub

        // Land Ride --> Water Ride
        int a = getCompletionTime(landStartTime, landDuration, waterStartTime, waterDuration);
        // Water Ride --> Land Ride
        int b = getCompletionTime(waterStartTime, waterDuration, landStartTime, landDuration);

        return Math.min(a, b);
    }

    /*
     * For a fixed second ride:
     * completionTime = max(firstRideFinish, secondRideStart) + secondRideDuration
     *
     * This expression is monotonic with respect to firstRideFinish.
     * Therefore, the optimal first ride is always the one that finishes earliest.
     */
    private static int getCompletionTime(int[] start1, int[] duration1, int[] start2, int[] duration2) {
        int n = start1.length;
        int m = start2.length;
        int finish1 = Integer.MAX_VALUE;
        int finish2 = Integer.MAX_VALUE;

        // getting the minimum from round-1
        for (int i = 0; i < n; i++) {
            finish1 = Math.min(finish1, start1[i] + duration1[i]);
        }

        // calculating round-2 on the basis of round-1 min.
        for (int i = 0; i < m; i++) {
            finish2 = Math.min(finish2, Math.max(finish1, start2[i]) + duration2[i]);
        }

        return finish2;
    }
}
