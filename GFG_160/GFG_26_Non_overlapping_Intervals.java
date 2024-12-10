package GFG_160;/*
 * https://www.geeksforgeeks.org/problems/non-overlapping-intervals/1
 *
 * # Non-overlapping Intervals
 *
 *   Q. Given a 2D array intervals[][] of representing intervals where intervals[i] = [start(i), end(i)].
 *      Return the minimum number of intervals you need to remove to make the rest of the intervals
 *      non-overlapping.
 *    Ex.
 *      Input : intervals[][] = [[1, 2], [2, 3], [3, 4], [1, 3]]
 *      Output: 1
 *      Explanation: [1, 3] can be removed and the rest of the intervals are non-overlapping.
 */
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class GFG_26_Non_overlapping_Intervals {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Number of Intervals: ");
        int n = sc.nextInt();

        int[][]arr = new int[n][2];

        System.out.println("Enter starting time and then ending time of a task: ");
        for (int i = 0;i < n;i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        System.out.println(minRemoval(arr));
    }

    /// Solution
    static int minRemoval(int[][]intervals) {
        // potd.code.hub
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        int end = 0, count = 0;
        for (int[]i : intervals){
            if (i[0] >= end) {
                count++;
                end = Math.max(end, i[1]);
            }
        }

        return intervals.length - count;
    }
}
