package DP;/*
 *
 * https://www.geeksforgeeks.org/problems/weighted-job-scheduling/1
 *
 * # Weighted Job Scheduling
 *
 *   Q. Given a 2D array jobs[][] of size n × 3, where each row represents a single job with the following details:
 *
 *      -~>  jobs[i][0] : Start time of the job
 *      -~>  jobs[i][1] : End time of the job
 *      -~>  jobs[i][2] : Profit earned by completing the job
 *
 *      Find the maximum profit you can earn by scheduling non-overlapping jobs.
 *
 *      Note: Two jobs are said to be non-overlapping if the end time of one job is less than or equal to the start time
 *            of the next job. If a job ends at time X, another job can start exactly at time X.
 *
 *      Input : jobs[][] =  [[1,   2,  50],
 *                           [3,   5,  20],
 *                           [6,  19, 100],
 *                           [2, 100, 200]]
 *      Output: 250
 *      Explanation: The first and fourth jobs with the time range [1, 2] and [2, 100] can be chosen to give maximum
 *                   profit of 50 + 200 = 250.
 *
 *  Constraints:
 *      1 ≤ jobs.size() ≤ 10⁵
 *      1 ≤ jobs[i][0] < jobs[i][1] ≤ 10⁹
 *      1 ≤ jobs[i][2] ≤ 10⁴
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Dynamic_Programming_Weighted_Job_Scheduling {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Number of jobs: ");
        int n = sc.nextInt();

        int[][] jobs = new int[n][3];

        System.out.println("Enter start time > end time > profit");
        for (int i = 0; i < n; i++) {
            jobs[i][0] = sc.nextInt();
            jobs[i][1] = sc.nextInt();
            jobs[i][2] = sc.nextInt();
        }

        System.out.print("Max profit pick: ");
        System.out.println(maxProfit(jobs));
    }

    /// Solution
/*
⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ~Brute Force (2D DP)~ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘
TC : O(n * max(EndTime))
SC : O(n * max(EndTime))
*/
    static int bruteForce(int[][] jobs) {
        int n = jobs.length;

        int t = 0;
        for (int[] arr : jobs) t = Math.max(t, arr[1]);
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));

        int[][] dp = new int[n][t + 1];

        return f(0, 0, n, jobs, dp);
    }

    // helper method
    private static int f(int i, int previousEndTime, int n, int[][] jobs, int[][] dp) {
        // base case
        if (i == n) return 0;
        if (dp[i][previousEndTime] != 0) return dp[i][previousEndTime];

        int start = jobs[i][0];
        int end = jobs[i][1];
        int profit = jobs[i][2];

        // recursive case
        int pick = (start >= previousEndTime) ? f(i + 1, end, n, jobs, dp) + profit : 0;
        int notPick = f(i + 1, previousEndTime, n, jobs, dp);

        // self work
        return dp[i][previousEndTime] = Math.max(pick, notPick);
    }

/*
⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ~Recursion Memoization BinarySearch~ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘
TC : O(n log n)
SC : O(n)
*/
    static int memoization(int[][] jobs) {
        int n = jobs.length;

        int t = 0;
        for (int[] arr : jobs) t = Math.max(t, arr[1]);
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));

        int[] dp = new int[n];

        return solve(0, n, jobs, dp);
    }

    // helper method
    private static int solve(int i, int n, int[][] jobs, int[] dp) {
        // base case
        if (i == n) return 0;
        if (dp[i] != 0) return dp[i];

        int next = lowerBound(jobs, jobs[i][1]);

        // recursive case
        int pick = jobs[i][2];
        if (next != -1) pick += solve(next, n, jobs, dp);
        int notPick = solve(i + 1, n, jobs, dp);

        // self work
        return dp[i] = Math.max(pick, notPick);
    }

    // binary search
    private static int lowerBound(int[][] jobs, int target) {
        int i = 0;
        int j = jobs.length - 1;
        int ans = -1;

        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (jobs[mid][0] >= target) {
                ans = mid;
                j = mid - 1;
            } else i = mid + 1;
        }

        return ans;
    }

/*
⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ~Recursion Memoization BinarySearch~ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘ ⌘
TC : O(n log n)
SC : O(n)
*/
    static int maxProfit(int[][] jobs) {
        int n = jobs.length;

        int t = 0;
        for (int[] arr : jobs) t = Math.max(t, arr[1]);
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));

        int[] dp = new int[n];

        dp[n - 1] = jobs[n - 1][2];
        for (int i = n - 2; i >= 0; i--) {
            int notPick = dp[i + 1]; // not pick -~> profit of next pick remain same.
            int pick = jobs[i][2];   // pick -~> profit of current + profit of next possible.
            int next = binarySearch(jobs, jobs[i][1]);
            if (next != -1) pick += dp[next];

            dp[i] = Math.max(pick, notPick);
        }

        return dp[0];
    }

    // binary search
    private static int binarySearch(int[][] jobs, int target) {
        int i = 0;
        int j = jobs.length - 1;
        int ans = -1;

        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (jobs[mid][0] >= target) {
                ans = mid;
                j = mid - 1;
            } else i = mid + 1;
        }

        return ans;
    }
}
