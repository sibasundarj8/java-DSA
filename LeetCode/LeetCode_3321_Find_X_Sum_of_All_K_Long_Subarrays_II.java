package LeetCode;/*
 *
 * https://leetcode.com/problems/find-x-sum-of-all-k-long-subarrays-ii/
 *
 * # 3321. Find X-Sum of All K-Long Subarrays II (Hard)
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
 *       nums.length == n
 *       1 <= n <= 10⁵
 *       1 <= nums[i] <= 10⁹
 *       1 <= x <= k <= nums.length
 */

import java.util.*;

public class LeetCode_3321_Find_X_Sum_of_All_K_Long_Subarrays_II  {

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

        long[] ans = findXSum(nums, k, x);

        System.out.println("X sum of all k long subarray's : ");
        System.out.println(Arrays.toString(ans));
    }

    /// Solution
    static long[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        long[] ans = new long[n - k + 1];
        int idx = 0;    // used to iterate over the ans array.
        long sum = 0;   // going to store the top x frequent elements at running time.

        // used to get the array stored in set in O(1).
        HashMap<Integer, long[]> map = new HashMap<>();

        // used to store the top x frequent from k elements.
        TreeSet<long[]> top = new TreeSet<>((a, b) -> (int) ((a[1] == b[1]) ? b[0] - a[0] : b[1] - a[1]));

        // used to store remaining from that k elements.
        TreeSet<long[]> rem = new TreeSet<>((a, b) -> (int) ((a[1] == b[1]) ? b[0] - a[0] : b[1] - a[1]));

        // setting up the first k size window elements and their frequencies.
        for (int i = 0; i < k; i++) {
            if (!map.containsKey(nums[i])) map.put(nums[i], new long[]{nums[i], 0});
            map.get(nums[i])[1]++;
        }

        // adding then into the respective tree-sets.
        for (long[] arr : map.values()) {
            top.add(arr);
            sum += arr[0] * arr[1];

            // if top is full then add the elements to top-set and transfer the least frequent element to rem-set.
            if (top.size() > x) {
                long[] m1 = top.removeLast();
                rem.add(m1);
                sum -= m1[0] * m1[1];
            }
        }

        // sum of the x frequent elements of first k sized window.
        ans[idx++] = sum;

        // sliding window.
        for (int i = k; i < n; i++) {
            long[] t = map.get(nums[i - k]);    // removing left most element

            // if that is present in top-set then remove it, otherwise check inside rem-set.
            if (top.contains(t)) {
                top.remove(t);
                sum -= t[0] * t[1];

                // add the most frequent element of rem-set to the top-set only if remaining set is not empty.
                if (!rem.isEmpty()) {
                    long[] m1 = rem.removeFirst();
                    top.add(m1);
                    sum += m1[0] * m1[1];
                }
            } else rem.remove(t);

            t[1]--;             // decrease frequency by 1 (window slides).

            if (t[1] > 0) {     // add the element to set only if it exists, means frequency is greater than 0.
                top.add(t);     // for now adding it to top-set, I will maintain top x later on.
                sum += t[0] * t[1];
            }

            // adding the right most element
            if (!map.containsKey(nums[i])) map.put(nums[i], new long[]{nums[i], 0});
            t = map.get(nums[i]);

            // always I have to remove the array from set before adding, because modification of arra which is inside the
            // tree set breaks the tree-set rules.
            if (top.contains(t)) {
                top.remove(t);
                sum -= t[0] * t[1];

                // adding the most frequent ele of rem-set to top-set maintain the top-set size -~> x.
                if (!rem.isEmpty()) {
                    long[] m1 = rem.removeFirst();
                    top.add(m1);
                    sum += m1[0] * m1[1];
                }
            } else rem.remove(t);

            t[1]++;             // increasing the frequency by 1 (window slides).

            top.add(t);         // adding it to the top-set initially.
            sum += t[0] * t[1]; // updating the sum ensuring the running stream sum.

            // reducing the top-set size to x and add least frequent elements to rem-set and tracking the sum concurrently.
            while (top.size() > x) {
                long[] m1 = top.removeLast();
                rem.add(m1);
                sum -= m1[0] * m1[1];
            }

            // updating in ans array.
            ans[idx++] = sum;
        }

        return ans;
    }
}
