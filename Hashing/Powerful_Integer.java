package Hashing;/*
 *
 * https://www.geeksforgeeks.org/problems/powerfull-integer--170647/1
 *
 * # Powerful Integer
 *
 *   Q. You are given a 2D integer array interval[][] of length n, where each interval[i] = [start, end]
 *      represents a closed interval (i.e., all integers from start to end, inclusive). You are also given
 *      an integer k. An integer is called Powerful if it appears in at least k intervals. Find the maximum
 *      Powerful Integer.
 *
 *      Note: If no integer occurs at least k times return -1.
 *    Ex.
 *      Input : n = 5
 *              intervals[][] = [[16, 21],
 *                               [5,  8],
 *                               [12, 17],
 *                               [17, 29],
 *                               [9,  24]],
 *              k = 3
 *      Output: 21
 *      Explanation: Integers 16, 17, 18, 19, 20 and 21 appear in at least 3 intervals. The maximum is 21.
 *
 *      Constraints:
 *          1 ≤ n ≤ 10⁵
 *          1 ≤ intervals[i][0] ≤ intervals[i][1] ≤ 10⁹
 *          1 ≤ k ≤ 10⁵
 */

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class Powerful_Integer {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of intervals: ");
        int n = sc.nextInt();

        int[][] intervals = new int[n][2];

        System.out.println("Enter intervals (starting time    ending time)");
        for (int i = 0; i < n; i++) {
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
        }

        System.out.println("K: ");
        int k = sc.nextInt();

        System.out.println("Powerful integer is: " + powerfulInteger(intervals, k));
    }

    /// Solution
/*------------------------------------------------Brute-Force (n * range)------------------------------------------------*/
    public static int bruteForce(int[][] intervals, int k) {
        /*
            • Enter every element into a hash map and count there frequency.
            • Then return largest element which frequency is greater than k.
        */
        int max = -1;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int[] arr : intervals) {
            for (int i = arr[0]; i <= arr[1]; i++) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
        }

        for (int i : map.keySet()) {
            if (map.get(i) >= k) {
                max = Math.max(max, i);
            }
        }

        return max;
    }

/*--------------------------------------------Using-Difference-Array (range)--------------------------------------------*/
    public static int differenceArray(int[][] intervals, int k) {
            /*
                • Create a difference array of size largest ending integer + 2
                • Mark every starting point as 1 and ending point + 1 as -1
                • Apply prefix sum to the difference array.
                • Return the last index which contains greater or equal element with k.
            */
        int max = 0;
    
        // finding the max ending value
        for (int[] arr : intervals) {
            max = Math.max(max, arr[1]);
        }
    
        // difference array
        int[] diff = new int[max + 2];
    
        // setting difference array starting as 1 and ending as -1
        for (int[] arr : intervals) {
            diff[arr[0]]++;
            diff[arr[1] + 1]--;
        }
    
        int ans = -1;
    
        // applying prefix sum
        for (int i = 1; i <= max; i++) {
            diff[i] += diff[i - 1];
            if (diff[i] >= k) {
                ans = Math.max(ans, i);
            }
        }
    
        return ans;
    }

/*---------------------------------------------Using-Difference-HashMap (n)---------------------------------------------*/
    public static int powerfulInteger(int[][] intervals, int k) {
            /*
                • Create a Treemap instead of difference array because we need keys in sorted order.
                • Keep  frequency of every starting point (++) and ending point+1 (--).
                • Apply prefix sum to the map values. Track the maximum possible ans.
                • Here we use only N space and N time to traverse by eliminating redundant additions.
                • No need to add every digit we only need the maximum one.
            */
        int ans = -1, sum = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
    
        // creating difference array like system using hashmap.
        for (int[] arr : intervals) {
            map.put(arr[0], map.getOrDefault(arr[0], 0) + 1);
            map.put(arr[1] + 1, map.getOrDefault(arr[1] + 1, 0) - 1);
        }
    
        // getting max k frequent element.
        for (int i : map.keySet()) {
            if (sum >= k) ans = i - 1;
            sum += map.get(i);
        }
    
        return ans;
    }
}
