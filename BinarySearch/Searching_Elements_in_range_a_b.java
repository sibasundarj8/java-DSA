package BinarySearch;/*
 *
 * https://www.geeksforgeeks.org/problems/find-number-of-elements-in-range-a-b-for-each-query/1
 *
 * # Elements in range [a, b]
 *
 *   Q. Given an unsorted array arr[] and a 2D array queries[][] of size q, where each query is in the form of [a, b]. For
 *      each query, count how many elements in arr[] lie within the range [a, b], i.e., elements satisfying a ≤ x ≤ b.
 *
 *      Return the results for all queries as a list of integers, where each integer corresponds to the count of elements
 *      in the respective query range.
 *    Ex.
 *      Input : arr[] = [1, 4, 2, 8, 5], queries[][] = [[1,  4],
 *                                                      [3,  6],
 *                                                      [0, 10]]
 *      Output: [3, 2, 5]
 *      Explanation: Query [1, 4]: Elements in range → [1, 4, 2] → Count = 3
 *                   Query [3, 6]: Elements in range → [4, 5] → Count = 2
 *                   Query [0, 10]: All elements → [1, 4, 2, 8, 5] → Count = 5
 *
 *  Constraints:
 *          1 ≤ arr.size(), q ≤ 10⁵
 *          0 ≤ arr[i] ≤ 10⁶
 *          0 ≤ queries[i][0] ≤ queries[i][1] ≤ 10⁶
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Searching_Elements_in_range_a_b {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Array elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

        System.out.println("Enter number of queries: ");
        n = sc.nextInt();

        int[][] queries = new int[n][2];

        System.out.println("Enter Queries: (beginning   ending)");
        for (int i = 0; i < n; i++) {
            queries[i][0] = sc.nextInt();
            queries[i][1] = sc.nextInt();
        }

        System.out.println("Number of elements present on the basis of queries: ");
        System.out.println(cntInRange(arr, queries));
    }

    /// Solution
    static ArrayList<Integer> cntInRange(int[] arr, int[][] queries) {
        ArrayList<Integer> list = new ArrayList<>();

        Arrays.sort(arr);

        for(int[] q : queries) {
            int s = lowerBound(arr, q[0]);
            int e = upperBound(arr, q[1]);

            int count = e - s + 1;
            list.add(count);
        }

        return list;
    }

    private static int upperBound(int[] arr, int x) {
        int i = 0;
        int j = arr.length - 1;
        int ans = -1;

        while(i <= j) {
            int mid = i + (j - i) / 2;

            if(arr[mid] <= x) {
                ans = mid;
                i = mid + 1;
            } else j = mid - 1;
        }

        return ans;
    }

    private static int lowerBound(int[] arr, int x) {
        int i = 0;
        int j = arr.length - 1;
        int ans = j + 1;

        while(i <= j) {
            int mid = i + (j - i) / 2;

            if(arr[mid] >= x) {
                ans = mid;
                j = mid - 1;
            } else i = mid + 1;
        }

        return ans;
    }
}
