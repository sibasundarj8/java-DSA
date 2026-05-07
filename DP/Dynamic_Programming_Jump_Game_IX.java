package DP;/*
 *
 * https://leetcode.com/problems/jump-game-ix/
 *
 * # 3660. Jump Game IX
 *
 *   Q. You are given an integer array nums. From any index i, you can jump to another index j under the following rules:
 *
 *        ◦ Jump to index j where j > i is allowed only if nums[j] < nums[i].
 *        ◦ Jump to index j where j < i is allowed only if nums[j] > nums[i].
 *
 *      For each index i, find the maximum value in nums that can be reached by following any sequence of valid jumps
 *      starting at 'i'.
 *
 *      Return an array ans, where ans[i] is the maximum value reachable starting from index i.
 *
 *    Ex.
 *      Input : nums = [2, 1, 3]
 *      Output: [2, 2, 3]
 *      Explanation:
 *            ◦ For i = 0: No jump increases the value.
 *            ◦ For i = 1: Jump to j = 0 as nums[j] = 2 is greater than nums[i].
 *            ◦ For i = 2: Since nums[2] = 3 is the maximum value in nums, no jump increases the value.
 *          Thus, ans = [2, 2, 3].
 *
 *  Constraints:
 *          1 <= nums.length <= 10⁵
 *          1 <= nums[i] <= 10⁹
 */

import java.util.*;

public class Dynamic_Programming_Jump_Game_IX {

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

        System.out.println("Maximum value reachable starting from each index: ");
        System.out.println(Arrays.toString(maxValue(arr)));
    }

    /// Solution
/*
☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒-brute-force-☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒
TC : O(n²)
SC : O(n)
*/
    static int[] bruteForce(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(idx -> -nums[idx]));
        for (int i = 0; i < n; i++) {
            pq.add(i);
        }

        while (!pq.isEmpty()) {
            int idx = pq.poll();
            if (dp[idx] == -1) {
                dp[idx] = nums[idx];
                process(idx, nums, dp);
            }
        }

        return dp;
    }

    private static void process(int idx, int[] nums, int[] dp) {
        int n = nums.length;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(idx);

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int i = 0; i < n; i++) {
                if (dp[i] == -1) {
                    if ((i < cur && nums[i] > nums[cur]) || (cur < i && nums[i] < nums[cur])) {
                        dp[i] = dp[cur];
                        q.add(i);
                    }
                }
            }
        }
    }

/*
☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑-Greedy-Connected-Component-Merging-☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑
TC : O(n)
SC : O(n)
*/
    static int[] maxValue(int[] nums) {
        // potd.code.hub
        int n = nums.length;
        int suffixMin = nums[n - 1];
        int[] prefixMax = new int[n]; // also works as a DP array

        prefixMax[0] = nums[0];
        for(int i = 1; i < n; i++){
            prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
        }

        for (int i = n - 2; i >= 0; i--) {
            if (prefixMax[i] > suffixMin) {
                prefixMax[i] = prefixMax[i + 1];
            }
            suffixMin = Math.min(suffixMin, nums[i]);
        }

        return prefixMax;
    }
}
