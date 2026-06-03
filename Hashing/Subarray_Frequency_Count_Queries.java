package Hashing;/*
 *
 * https://www.geeksforgeeks.org/problems/count-frequency-of-an-element-in-a-given-range/1
 *
 * # Subarray Frequency Count Queries
 *
 *   Q. Given an array arr[] of n integers and a 2D array queries[][] representing q queries, where each queries[i] consists
 *      of three integers: l, r, and x. For each query determine how many times the element x appears in the arr[] from index l to r (both inclusive).
 *
 *      Return a list of integers where the i-th value represents the answer to the i-th query.
 *
 *    Ex.
 *      Input : arr[] = [1, 2, 1, 3, 1, 2, 3],
 *              queries[][] = [[0, 4, 1],
 *                             [2, 5, 2],
 *                             [1, 6, 3],
 *                             [0, 6, 5]]
 *      Output: [3, 1, 2, 0]
 *      Explanation:
 *              query [0, 4, 1] -> Subarray = [1, 2, 1, 3, 1], 1 appears 3 times
 *              query [2, 5, 2] -> Subarray = [1, 3, 1, 2], 2 appears 1 time
 *              query [1, 6, 3] -> Subarray = [2, 1, 3, 1, 2, 3] 3 appears 2 times
 *              query [0, 6, 5] -> Subarray = [1, 2, 1, 3, 1, 2, 3],  5 appears 0 times
 *
 *  Constraints:
 *          1 ≤ arr.size(), queries.size() ≤ 10⁵
 *          1 ≤ arr[i], queries[i][2] ≤ 10⁵
 *          0 ≤ queries[i][0] ≤ queries[i][1] < arr.size()
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Subarray_Frequency_Count_Queries {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    }

    /// Solution
    static ArrayList<Integer> freqInRange(int[] arr, int[][] queries) {
        // potd.code.hub
        int n = arr.length;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();

        // deserialize the indexes
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        // use binary search to answer the queries
        for (int[] query : queries) {
            ArrayList<Integer> list = map.get(query[2]);

            if (list == null) {
                ans.add(0);
                continue;
            }

            int left = lowerBound(list, query[0]);
            int right = lowerBound(list, query[1] + 1);

            ans.add((left < right) ? right - left : 0);
        }

        return ans;
    }

    private static int lowerBound(ArrayList<Integer> list, int k) {
        int i = 0;
        int j = list.size() - 1;

        while (i <= j) {
            int mid = i + (j - i) / 2;

            if (list.get(mid) >= k) j = mid - 1;
            else i = mid + 1;
        }

        return i;
    }
}
