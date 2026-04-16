package Hashing;/*
 *
 * https://leetcode.com/problems/closest-equal-element-queries/
 *
 * # 3488. Closest Equal Element Queries
 *
 *   Q. You are given a circular array nums and an array queries.
 *
 *      For each query i, you have to find the following:
 *          ◦ The minimum distance between the element at index queries[i] and any other index j in the circular array,
 *            where nums[j] == nums[queries[i]]. If no such index exists, the answer for that query should be -1.
 *
 *      Return an array answer of the same size as queries, where answer[i] represents the result for query i.
 *
 *    Ex.
 *      Input : nums = [1,3,1,4,1,3,2], queries = [0,3,5]
 *      Output: [2,-1,3]
 *      Explanation:
 *              Query 0: The element at queries[0] = 0 is nums[0] = 1. The nearest index with the same value is 2, and the
 *                       distance between them is 2.
 *
 *              Query 1: The element at queries[1] = 3 is nums[3] = 4. No other index contains 4, so the result is -1.
 *
 *              Query 2: The element at queries[2] = 5 is nums[5] = 3. The nearest index with the same value is 1, and the
 *                       distance between them is 3 (following the circular path: 5 -> 6 -> 0 -> 1).
 *
 *  Constraints:
 *          1 <= queries.length <= nums.length <= 10⁵
 *          1 <= nums[i] <= 10⁶
 *          0 <= queries[i] < nums.length
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Closest_Equal_Element_Queries {

    /// main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter num[]: ");
        String[] s1 = sc.nextLine().split(" ");

        System.out.println("Enter queries[]: ");
        String[] s2 = sc.nextLine().split(" ");

        int n = s1.length;
        int m = s2.length;
        int[] nums = new int[n];
        int[] queries = new int[m];

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(s1[i]);
        }
        for (int i = 0; i < m; i++) {
            queries[i] = Integer.parseInt(s2[i]);
        }

        System.out.println("Answer: ");
        System.out.println(solveQueries(nums, queries));
    }

    /// Solution
    static List<Integer> solveQueries(int[] nums, int[] queries) {
        // potd.code.hub
        int n = nums.length;
        int m = queries.length;
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        for (int i : queries) {
            List<Integer> list = map.get(nums[i]);
            int len = list.size();

            if (len <= 1) {
                ans.add(-1);
            }
            else {
                int pos = binarySearch(list, i);
                int left = (pos - 1 + len) % len;
                int right = (pos + 1) % len;
                int leftPos = list.get(left);
                int rightPos = list.get(right);
                int leftDist = Math.min(n - Math.abs(i - leftPos), Math.abs(i - leftPos));
                int rightDist = Math.min(n - Math.abs(i - rightPos), Math.abs(i - rightPos));

                ans.add(Math.min(leftDist, rightDist));
            }
        }

        return ans;
    }

    private static int binarySearch(List<Integer> list, int target) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (list.get(mid) == target) return mid;
            if (list.get(mid) < target) low = mid + 1;
            else if (list.get(mid) > target) high = mid - 1;
        }

        return -1;
    }
}
