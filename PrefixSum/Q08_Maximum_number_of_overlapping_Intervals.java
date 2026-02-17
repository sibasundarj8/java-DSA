package PrefixSum;/*
 *
 * https://www.geeksforgeeks.org/problems/intersecting-intervals/1
 *
 * # Maximum number of overlapping Intervals
 *
 *   Q. You are given an array of intervals arr[][], where each interval is represented by two integers [start, end] (inclusive).
 *      Return the maximum number of intervals that overlap at any point in time.
 *    Ex.
 *      Input : arr[][] = [[1, 2], [2, 4], [3, 6]]
 *      Output: 2
 *      Explanation: The maximum overlapping intervals are 2(between (1, 2) and (2, 4) or between (2, 4) and (3, 6))
 *
 *  Constraints:
 *          2 ≤ arr.size() ≤ 2 * 10⁴
 *          1 ≤ arr[i][0] < arr[i][1] ≤ 4*10⁶
 */

import java.util.*;

public class Q08_Maximum_number_of_overlapping_Intervals {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of intervals you want in the array: ");
        int n = sc.nextInt();

        int[][] arr = new int[n][2];

        System.out.println("Enter the intervals: ");
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        System.out.println("Maximum number of overlapping intervals : ");
        System.out.println(overlapInt(arr));
    }

    /// Solution
/*
✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔-Using--Difference-Array-✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔
TC : O(maxEle)
SC : O(maxEle)
*/
    static int differenceArray(int[][] arr) {
        // pod.code.hub
        int m = 0;
        int maxOverlap = 0;

        for (int[] interval : arr) {
            m = Math.max(m, interval[1]);
        }

        int[] prefix = new int[m + 2];

        for (int[] interval : arr) {
            prefix[interval[0]]++;
            prefix[interval[1] + 1]--;
        }

        for (int i = 1; i < m + 1; i++) {
            prefix[i] += prefix[i - 1];
            maxOverlap = Math.max(maxOverlap, prefix[i]);
        }

        return maxOverlap;
    }

/*
✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔-Using--Sweep-Line-Algorithm-✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔
TC : O(n log n)
SC : O(n)
*/
    static int sweepLineAlgo(int[][] arr) {
        int maxOverlap = 0;
        int active = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int[] interval : arr) {
            map.put(interval[0], map.getOrDefault(interval[0], 0) + 1);
            map.put(interval[1] + 1, map.getOrDefault(interval[1] + 1, 0) - 1);
        }

        for (int overlap : map.values()) {
            active += overlap;
            if (active > maxOverlap) maxOverlap = active;
        }

        return maxOverlap;
    }

/*
✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔-Using--Min-Heap-✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔
TC : O(n log n)
SC : O(n)
*/
    static int overlapInt(int[][] arr) {
        int maxOverlap = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

        for (int[] interval : arr) {
            while (!pq.isEmpty() && pq.peek() < interval[0]) pq.poll();
            pq.add(interval[1]);
            maxOverlap = Math.max(maxOverlap, pq.size());
        }

        return maxOverlap;
    }
}
