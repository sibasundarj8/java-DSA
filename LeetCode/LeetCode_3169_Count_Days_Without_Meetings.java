package LeetCode;/*
 *
 * https://leetcode.com/problems/count-days-without-meetings/
 *
 * # 3169. Count Days Without Meetings
 *
 *   Q. You are given a positive integer days representing the total number of days an employee is
 *      available for work (starting from day 1). You are also given a 2D array meetings of size n
 *      where, meetings[i] = [start_i, end_i] represents the starting and ending days of meeting i
 *      (inclusive).
 *
 *      Return the count of days when the employee is available for work but no meetings are scheduled.
 *
 *      Note: The meetings may overlap.
 *   Ex.
 *      Input: days = 10, meetings = [[5, 7],
 *                                    [1, 3],
 *                                    [9, 10]]
 *      Output: 2
 *      Explanation:
 *              There is no meeting scheduled on the 4th and 8th days.
 */
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class LeetCode_3169_Count_Days_Without_Meetings {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Days: ");
        int days = sc.nextInt();

        System.out.println("Number of meetings: ");
        int n = sc.nextInt();

        int[][]meetings = new int[n][2];

        System.out.println("Elements: ");
        for (int i = 0;i < n;i++){
            meetings[i][0] = sc.nextInt();
            meetings[i][1] = sc.nextInt();
        }

        System.out.println(countDays(days, meetings));
    }

    /// Solution
    static int countDays(int days, int[][] meetings) {
        // sibasundarj8@gmail.com
        int n = meetings.length;
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        int ans = 0, max = meetings[0][1];
        for (int i = 1;i < n;i++){
            if (meetings[i][0] > max)
                ans += meetings[i][0] - max - 1;
            max = Math.max(max, meetings[i][1]);
        }

        ans += meetings[0][0] - 1;
        if (max < days) ans += days - max;

        return ans;
    }
}
