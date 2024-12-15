package GFG_160.Bonus_Problems;/*
 *
 * https://www.geeksforgeeks.org/problems/attend-all-meetings/1
 *
 * # Meeting Rooms
 *
 *   Q. Given an array arr[][] such that arr[i][0] is the starting time of ith meeting and arr[i][1] is
 *      the ending time of ith meeting, the task is to check if it is possible for a person to attend all
 *      the meetings such that he can attend only one meeting at a particular time.
 *
 *      Note: A person can attend a meeting if its starting time is greater than or equal to
 *            the previous meeting's ending time.
 *    Ex.
 *      Input : arr[][] = [[1, 4], [10, 15], [7, 10]]
 *      Output: true
 *      Explanation: Since all the meetings are held at different times, it is possible to attend all
 *                   the meetings.
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Sorting_02_Meeting_Rooms {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Number of Meetings: ");
        int n = sc.nextInt();

        int[][]arr = new int[n][2];

        System.out.println("Enter Starting time and Ending time of meetings: ");
        for (int i = 0;i < n;i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        System.out.println(canAttend(arr));
    }

    /// Solution
    static boolean canAttend(int[][] arr) {
        // potd.code.hub
        int n = arr.length;
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

        for (int i = 1;i < n;i++)
            if (arr[i][0] < arr[i-1][1]) return false;
        
        return true;
    }
}
