package Greedy;/*
 *
 * https://www.geeksforgeeks.org/problems/overlapping-intervals--170633/1
 *
 * # Overlapping Intervals
 *
 *   Q. Given an array of Intervals arr[][], where arr[i] = [startⓘ, endⓘ]. The task is to merge all the overlapping Intervals.
 *    Ex:
 *      Input : arr[][] = [[1, 3], [2, 4], [6, 8], [9, 10]]
 *      Output: [[1, 4], [6, 8], [9, 10]]
 *      Explanation: In the given intervals we have only two overlapping intervals here, [1, 3] and [2, 4] which on merging
 *                   will become [1, 4]. Therefore, we will return [[1, 4], [6, 8], [9, 10]].
 *
 *  Constraints:
 *          1 ≤ arr.size() ≤ 10⁵
 *          0 ≤ startⓘ ≤ endⓘ ≤ 10⁶
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class G06_Overlapping_Intervals {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Number of Intervals: ");
        int n = sc.nextInt();

        int[][] arr = new int[n][2];

        System.out.println("Enter Intervals: (startⓘ, endⓘ)");
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        ArrayList<int[]> ans = mergeOverlap(arr);

        System.out.println("After merging: ");
        for (int[] a : ans) {
            System.out.println(Arrays.toString(a));
        }
    }

    /// Solution
    static ArrayList<int[]> mergeOverlap(int[][] arr) {
        int n = arr.length;
        ArrayList<int[]> list = new ArrayList<>();

        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

        int start = arr[0][0];
        int end = arr[0][1];

        for(int i = 1; i < n; i++) {
            if(arr[i][0] > end) {
                list.add(new int[]{start, end});
                start = arr[i][0];
            }
            end = Math.max(end, arr[i][1]);
        }

        list.add(new int[]{start, end});

        return list;
    }
}
