package PrefixSum;/*
 *
 * https://leetcode.com/problems/sum-of-distances/
 *
 * # 2615. Sum of Distances
 *
 *   Q. You are given a 0-indexed integer array nums. There exists an array arr of length nums.length, where arr[i] is the
 *      sum of |i - j| over all j such that nums[j] == nums[i] and j != i. If there is no such j, set arr[i] to be 0.
 *
 *      Return the array arr.
 *
 *    Ex.
 *      Input: nums = [1,3,1,1,2]
 *      Output: [5,0,3,4,0]
 *      Explanation:
 *              When i = 0, nums[0] == nums[2] and nums[0] == nums[3]. Therefore, arr[0] = |0 - 2| + |0 - 3| = 5.
 *              When i = 1, arr[1] = 0 because there is no other index with value 3.
 *              When i = 2, nums[2] == nums[0] and nums[2] == nums[3]. Therefore, arr[2] = |2 - 0| + |2 - 3| = 3.
 *              When i = 3, nums[3] == nums[0] and nums[3] == nums[2]. Therefore, arr[3] = |3 - 0| + |3 - 2| = 4.
 *              When i = 4, arr[4] = 0 because there is no other index with value 2.
 *
 *  Constraints:
 *          1 <= nums.length <= 10⁵
 *          0 <= nums[i] <= 10⁹
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Q13_Sum_of_Distances {

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

        System.out.println("Sum of Distances where nums[j] == nums[i] and j != i : ");
        long[] ans = distance(arr);
        System.out.println(Arrays.toString(ans));
    }

    /// Solution
/*
◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦-Approach-1-◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦
TC : O(n log n)
SC : O(n)
*/
    static long[] approach_1(int[] nums) {
        // potd.code.hub
        int n = nums.length;
        long[] res = new long[n];
        HashMap<Integer, ArrayList<Long>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add((long) i);
        }

        for (ArrayList<Long> indexes : map.values()) {
            calculatePrefixSum(indexes);
        }

        for (int i = 0; i < n; i++) {
            ArrayList<Long> list = map.get(nums[i]);
            int len = list.size();
            if (list.size() == 1) {
                res[i] = 0;
            } else {
                int idx = search(list, i);

                long left = (idx == 0) ? 0 : (long) idx * i - list.get(idx - 1);
                long right = (idx == len - 1) ? 0 : -((long) (len - 1 - idx) * i) + (list.getLast() - list.get(idx));

                res[i] = left + right;
            }
        }

        return res;
    }

    private static int search(ArrayList<Long> list, int tar) {
        if (list.getFirst() == tar) return 0;
        int i = 1;
        int j = list.size() - 1;

        while (i <= j) {
            int mid = i + (j - i) / 2;
            long val = list.get(mid) - list.get(mid - 1);

            if (val == tar) return mid;
            else if (val < tar) i = mid + 1;
            else j = mid - 1;
        }

        return -1;
    }

    private static void calculatePrefixSum(ArrayList<Long> list) {
        int n = list.size();

        for (int i = 1; i < n; i++) {
            list.set(i, list.get(i) + list.get(i - 1));
        }
    }

/*
◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦-Approach-2-◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦
TC : O(n)
SC : O(n)
*/
    static long[] distance(int[] nums) {
        int n = nums.length;
        long[] res = new long[nums.length];
        HashMap<Integer, Data> map = new HashMap<>();

        for (int l = 0; l < n; l++) {
            int r = n - 1 - l;
            Data data1 = map.computeIfAbsent(nums[l], k -> new Data());
            Data data2 = map.computeIfAbsent(nums[r], k -> new Data());

            // left calculation
            res[l] += (long) data1.count1 * l - data1.sum1;
            data1.sum1 += l;
            data1.count1++;

            // right calculation
            res[r] += -((long) data2.count2 * r) + data2.sum2;
            data2.sum2 += r;
            data2.count2++;
        }

        return res;
    }

    private static class Data {
        long sum1 = 0;
        long sum2 = 0;
        int count1 = 0;
        int count2 = 0;
    }
}
