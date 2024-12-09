package GFG_160;/*
 * https://www.geeksforgeeks.org/problems/insert-interval-1666733333/1
 *
 * # Insert Interval
 *
 *   Q. Geek has an array of non-overlapping intervals where intervals[i] = [start(i), end(i)] represent
 *      the start and the end of the ith event and intervals is sorted in ascending order by start(i).
 *      He wants to add a new interval newInterval= [newStart, newEnd] where newStart and newEnd represent
 *      the start and end of this interval.
 *
 *      Help Geek to insert newInterval into intervals such that intervals is still sorted in ascending
 *      order by start(i) and intervals still does not have any overlapping intervals (merge overlapping
 *      intervals if necessary).
 *    Ex.
 *      Input : intervals = [[1,3], [4,5], [6,7], [8,10]], newInterval = [5,6]
 *      Output: [[1,3], [4,7], [8,10]]
 *      Explanation: The newInterval [5,6] overlaps with [4,5] and [6,7].
 */
import java.util.Scanner;
import java.util.ArrayList;

public class GFG_25_Insert_Interval {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Number of Intervals: ");
        int n = sc.nextInt();

        int[][] arr = new int[n][2];

        System.out.println("Enter starting time and then ending time of a task: ");
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        int[] temp = new int[2];
        System.out.println("Enter the new Interval you want to insert: ");
        temp[0] = sc.nextInt();
        temp[1] = sc.nextInt();

        for (int[] i : insertInterval(arr, temp)) {
            System.out.println(i[0] + " " + i[1]);
        }
    }

    /// Solution
    static ArrayList<int[]> insertInterval(int[][] intervals, int[] newInterval) {
        // potd.code.hub
        int n = intervals.length;
        ArrayList<int[]> ans = new ArrayList<>();

        ArrayList<int[]> arr = new ArrayList<>();
        boolean flag = true;
        for (int[]x : intervals){
            if (flag && x[0] > newInterval[0]){
                arr.add(newInterval);
                flag = false;
            }
            arr.add(x);
        }
        if (flag) arr.add(newInterval);

        int i = 0;
        int start = arr.get(0)[0], end = arr.get(0)[1];
        while (i <= n){
            if (arr.get(i)[0] > end){
                ans.add(new int[]{start, end});
                start = arr.get(i)[0];
            }
            end = Math.max(end, arr.get(i)[1]);
            i++;
        }

        ans.add(new int[]{start, end});

        return ans;
    }
}
