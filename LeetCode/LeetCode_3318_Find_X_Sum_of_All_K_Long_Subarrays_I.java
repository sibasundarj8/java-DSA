package LeetCode;/*
 *
 * https://leetcode.com/problems/find-x-sum-of-all-k-long-subarrays-i/
 *
 * # 3318. Find X-Sum of All K-Long Subarrays I (Easy)
 *
 *   Q. You are given an array nums of n integers and two integers k and x.
 *
 *      The x-sum of an array is calculated by the following procedure:
 *        -~> Count the occurrences of all elements in the array.
 *        -~> Keep only the occurrences of the top x most frequent elements. If two elements have the same number of
 *            occurrences, the element with the bigger value is considered more frequent.
 *        -~> Calculate the sum of the resulting array.
 *
 *      Note that if an array has less than x distinct elements, its x-sum is the sum of the array.
 *
 *      Return an integer array answer of length n - k + 1 where answer[i] is the x-sum of the subarray
 *      nums[i...i + k - 1].
 *
 *   Ex.
 *      Input : nums = [1,1,2,2,3,4,2,3], k = 6, x = 2
 *      Output: [6,10,12]
 *      Explanation:
 *          -~> For subarray [1, 1, 2, 2, 3, 4], only elements 1 and 2 will be kept in the resulting array. Hence,
 *              answer[0] = 1 + 1 + 2 + 2.
 *
 *          -~> For subarray [1, 2, 2, 3, 4, 2], only elements 2 and 4 will be kept in the resulting array. Hence,
 *              answer[1] = 2 + 2 + 2 + 4.
 *              Note that 4 is kept in the array since it is bigger than 3 and 1 which occur the same number of times.
 *
 *          -~> For subarray [2, 2, 3, 4, 2, 3], only elements 2 and 3 are kept in the resulting array. Hence,
 *              answer[2] = 2 + 2 + 2 + 3 + 3.
 *
 *  Constraints:
 *       1 <= n == nums.length <= 50
 *       1 <= nums[i] <= 50
 *       1 <= x <= k <= nums.length
 */

import java.util.*;

public class LeetCode_3318_Find_X_Sum_of_All_K_Long_Subarrays_I {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = Integer.parseInt(s[i]);

        System.out.print("K : ");
        int k = sc.nextInt();

        System.out.print("X : ");
        int x = sc.nextInt();

        int[] ans = findXSum(nums, k, x);

        System.out.println("X sum of all k long subarray's : ");
        System.out.println(Arrays.toString(ans));
    }

    /// Solution
    static int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int sum = 0;
        int[] ans = new int[n - k + 1];
        int idx = 0;

        TreeSet<int[]> set = new TreeSet<>((a, b) -> (a[1] == b[1]) ? b[0] - a[0] : b[1] - a[1]);
        HashMap<Integer, int[]> map = new HashMap<>();

        for (int i = 0; i < k; i++) {
            sum += nums[i];
            if (!map.containsKey(nums[i])) map.put(nums[i], new int[]{nums[i], 0});
            map.get(nums[i])[1]++;
        }
        set.addAll(map.values());

        // for first x elements.
        if (set.size() <= x) ans[idx] = sum;
        else {
            int z = 0;
            for (int[] temp : set) {
                if (z == x) break;
                ans[idx] += temp[0] * temp[1];
                z++;
            }
        }
        idx++;

        // sliding window for next k size sub-arrays.
        for (int i = k; i < n; i++) {
            sum -= nums[i - k];
            int[] t = map.get(nums[i - k]);
            set.remove(t);
            t[1]--;
            if (t[1] > 0)set.add(t);

            sum += nums[i];
            if (!map.containsKey(nums[i])) map.put(nums[i], new int[]{nums[i], 0});
            t = map.get(nums[i]);
            set.remove(t);
            t[1]++;
            set.add(t);

            if (set.size() <= x) ans[idx] = sum;
            else {
                int z = 0;
                for (int[] temp : set) {
                    if (z == x) break;
                    ans[idx] += temp[0] * temp[1];
                    z++;
                }
            }
            idx++;
        }

        return ans;
    }
}
