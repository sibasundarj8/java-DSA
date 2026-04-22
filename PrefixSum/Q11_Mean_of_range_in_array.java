package PrefixSum;/*
 *
 * https://www.geeksforgeeks.org/problems/mean-of-range-in-array2123/1
 *
 * # Mean of range in array
 *
 *   Q. Given an integer array arr[] and a 2D array queries[][]. Each query queries[i] = [l, r] represents a subarray ranging
 *      from index l to r (inclusive). For every query, compute the mean (average) of the elements in the specified range, and
 *      return the floor value of that mean.
 *
 *      Return an array where each element corresponds to the result of a query.
 *
 *    Ex.
 *      Input : arr[] = [1, 2, 3, 4, 5], queries[][] = [[0, 2], [1, 3], [0, 4]]
 *      Output: [2, 3, 3]
 *      Explanation: The array is [1, 2, 3, 4, 5].
 *              Query 1: l = 0, r = 2 → subarray [1, 2, 3] → sum = 6 → mean = 6/3 = 2
 *              Query 2: l = 1, r = 3 → subarray [2, 3, 4] → sum = 9 → mean = 9/3 = 3
 *              Query 3: l = 0, r = 4 → subarray [1, 2, 3, 4, 5] → sum = 15 → mean = 15/5 = 3
 *              Hence the answer is [2, 3, 3]
 *
 *  Constraints:
 *      1 ≤ arr.size() ≤ 10⁵
 *      1 ≤ arr[i] ≤ 10³
 *      1 ≤ queries.size() ≤ 10⁵
 *      1 ≤ queries[i][0] ≤ queries[i][1] < arr.size()
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Q11_Mean_of_range_in_array {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.println("Enter the number of queries: ");
        n = sc.nextInt();
        int[][] queries = new int[n][2];

        System.out.println("Enter queries: (l  r)");
        for (int i = 0; i < n; i++) {
            queries[i][0] = sc.nextInt();
            queries[i][1] = sc.nextInt();
        }

        System.out.println("mean according to the query: ");
        System.out.println(findMean(arr, queries));
    }

    /// Solution
    static ArrayList<Integer> findMean(int[] arr, int[][] queries) {
        // potd.code.hub
        int n = arr.length;
        long[] prefix = new long[n];
        ArrayList<Integer> res = new ArrayList<>();
        prefix[0] = arr[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];
            long sum = (l == 0) ? prefix[r] : prefix[r] - prefix[l - 1];
            res.add((int) sum / (r - l + 1));
        }

        return res;
    }
}
