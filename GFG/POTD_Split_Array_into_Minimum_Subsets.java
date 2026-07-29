package GFG;/*
 *
 * https://www.geeksforgeeks.org/problems/split-array-into-minimum-subsets/1
 *
 * # Split Array into Minimum Subsets
 *
 *   Q. Given an array arr[] of distinct positive numbers. Split the array into the minimum number of subsets
 *      (or subsequences) such that each subset contains consecutive numbers.
 *
 *    Ex.
 *      Input : arr[] = [100, 56, 5, 6, 102, 58, 101, 57, 7, 103, 59]
 *      Output: 3
 *      Explanation: [5, 6, 7], [56, 57, 58, 59], [100, 101, 102, 103] are 3 subsequences in which numbers are
 *                   consecutive.
 *
 *  Constraints:
 *        1 ≤ arr.size() ≤ 10⁵
 *        0 ≤ arr[i] ≤ 10⁹
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class POTD_Split_Array_into_Minimum_Subsets {

    /// main Method
    public static void main(String[] args) throws IOException {
        System.out.println("Enter array elements: ");
        StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());

        int n = st.countTokens();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println("Minimum number of subsets with consecutive numbers: ");
        System.out.println(minSubsets(arr));
    }

    /// Solution
    static int minSubsets(int[] arr) {
        // potd.code.hub
        int count = 0;
        HashSet<Integer> set = new HashSet<>();

        for (int ele : arr) {
            set.add(ele);
        }

        for (int ele : arr) {
            if (!set.contains(ele - 1)) {
                count++;
            }
        }

        return count;
    }
}
