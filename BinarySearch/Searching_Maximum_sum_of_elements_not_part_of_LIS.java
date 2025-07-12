package Binary_Search;/*
 *
 * https://www.geeksforgeeks.org/problems/maximum-sum-of-elements-not-part-of-lis/1
 *
 * # Maximum sum of elements not part of LIS
 *
 *   Q. Given an array arr[] of positive integers, your task is to find the maximum possible sum of all elements
 *      that are not part of the Longest Increasing Subsequence (LIS).
 *   Ex.
 *      Input : arr[] = [5, 4, 3, 2, 1]
 *      Output: 14
 *      Explanation: The elements which are not in LIS is 5, 4, 3 and 2.
 *
 *      Input : arr[] = [4, 6, 1, 2, 3, 8]
 *      Output: 10
 *      Explanation: The elements which are not in LIS is 4 and 6.
 */    

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Searching_Maximum_sum_of_elements_not_part_of_LIS {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];

        for (int i = 0;i < n;i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.println("Max sum of non-LIS: " + nonLisMaxSum(arr));
    }

    /// Solution
    static int nonLisMaxSum(int[] arr) {
        // potd.code.hub
        int total = 0;

        for (int i : arr) total += i;

        return total - minLisSum(arr);
    }
    private static int minLisSum(int[] arr) {
        int n = arr.length;
        List<Integer> list = new ArrayList<>();
        int[]prefix = new int[n];

        list.add(arr[0]);

        for (int i : arr) {
            if (i > list.get(list.size() - 1)) {
                int pos = list.size();
                list.add(i);
                prefix[pos] = i + prefix[pos - 1];
            } else {
                int pos = lowerBound(list, i);
                list.set(pos, i);
                prefix[pos] = (pos == 0) ? i : i + prefix[pos - 1];
            }
        }

        int sum = 0;
        for (int i = 0;i < n;i++)
            sum = Math.max(sum, prefix[i]);

        return sum;
    }
    private static int lowerBound (List<Integer> list, int target) {
        int i = 0, j = list.size()-1, ans = -1;

        while (i <= j) {
            int mid = i + (j-i)/2;
            if (list.get(mid) >= target) {
                ans = mid;
                j = mid-1;
            }else i = mid+1;
        }

        return ans;
    }
}
