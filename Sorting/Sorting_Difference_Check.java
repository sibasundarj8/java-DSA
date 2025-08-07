package Sorting;/*
 *
 * https://www.geeksforgeeks.org/problems/difference-check/1
 *
 * # Difference Check
 *
 *   Q. Given an array arr[] of time strings in 24-hour clock format "HH:MM:SS", return the minimum difference
 *      in seconds between any two time strings in the arr[].
 *
 *      The clock wraps around at midnight, so the time difference between "23:59:59" and "00:00:00" is 1 second.
 *   Ex.
 *      Input : arr[] = ["00:00:01", "23:59:59", "00:00:05"]
 *      Output: 2
 *      Explanation: The time difference is minimum between "00:00:01" and "23:59:59".
 */

import java.util.Arrays;
import java.util.Scanner;

public class Sorting_Difference_Check {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter times: (format: HH:MM:SS)");
        String[] arr = sc.nextLine().split(" ");

        System.out.println("Minimum difference: " + minDifference(arr));
    }

    /// Solution
    private static int toSecond(String time) {
        int hr = Integer.parseInt("" + time.charAt(0) + time.charAt(1));
        int min = Integer.parseInt("" + time.charAt(3) + time.charAt(4));
        int sec = Integer.parseInt("" + time.charAt(6) + time.charAt(7));

        return 3600 * hr + 60 * min + sec;
    }

    /*-------------------------------------------------- Sorting (n log n) --------------------------------------------------*/
    static int sorting(String[] arr) {
        // potd.code.hub
        int n = arr.length;
        int ans = Integer.MAX_VALUE;

        Arrays.sort(arr);
        
        for (int i = 1; i < n; i++) {
            int prvTime = toSecond(arr[i - 1]);
            int curTime = toSecond(arr[i]);

            ans = Math.min(ans, curTime - prvTime);
        }

        int last = toSecond(arr[0]) + (toSecond("23:59:60") - toSecond(arr[n - 1]));

        return Math.min(last, ans);
    }

    /*-------------------------------------------------- Visited Array (n) --------------------------------------------------*/
    static int minDifference(String[] arr) {
        // potd.code.hub
        int totalSec = 24 * 3600;
        int first = totalSec;
        int last = -1;
        boolean[] visit = new boolean[totalSec];

        // marking
        for (String s : arr) {
            // converting to seconds.
            int sec = toSecond(s);
            // two times are equal means diff 0.
            if (visit[sec]) return 0;
            // marking
            visit[sec] = true;

            first = Math.min(first, sec);
            last = Math.max(last, sec);
        }

        // finding min dif
        int ans = first + (totalSec - last);
        int prv = first;

        for (int i = first + 1; i <= last; i++) {
            if (!visit[i]) continue;
            ans = Math.min(ans, i - prv);
            prv = i;
        }

        return ans;
    }
}
