package Contest.weekly_519;/*
 *
 * https://leetcode.com/contest/weekly-contest-519/problems/count-shadow-pairs-i/
 *
 * # Q3. Count Shadow Pairs I
 *
 *   Q. You are given an integer array nums of length n.
 *
 *      A pair of indices (i, j) is called a shadow pair if all the following conditions are satisfied:
 *        ◦ 0 <= i < j < n
 *        ◦ nums[i] < nums[j]
 *        ◦ There does not exist an index k such that i < k < j and nums[k] < nums[i] < nums[j].
 *
 *      Return the total number of shadow pairs.
 *
 *    Ex.
 *      Input : nums = [3, 1, 4, 1, 5]
 *      Output: 3
 *      Explanation:
 *                  +--------+---------+---------+----------------------------------------------------+
 *                  | (i, j) | nums[i] | nums[j] |                    Shadow Pair                     |
 *                  +--------+---------+---------+----------------------------------------------------+
 *                  | (1, 2) |    1    |   4     | No index k exists such that 1 < k < 2              |
 *                  +--------+---------+---------+----------------------------------------------------+
 *                  | (1, 4) |    1    |   5     | nums[2] = 4 and nums[3] = 1 are not smaller than 1 |
 *                  +--------+---------+---------+----------------------------------------------------+
 *                  | (3, 4) |    1    |   5     | No index k exists such that 3 < k < 4              |
 *                  +--------+---------+---------+----------------------------------------------------+
 *
 *                  Thus, the answer is 3.
 *
 *  Constraints:
 *        ◦ 3 <= n == nums.length <= 10⁵
 *        ◦ 1 <= nums[i] <= 10⁹
 */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q3_Count_Shadow_Pairs_I {

    /// Solution
    public long shadowPairs(int[] nums) {
        int n = nums.length;
        long count = 0;
        int[] nse = nextSmaller(nums, n);
        int[] pos = new int[n];
        Map<Integer, List<Integer>> eleIndices = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int ele = nums[i];
            List<Integer> indices = eleIndices.computeIfAbsent(ele, k -> new ArrayList<>());
            pos[i] = indices.size();
            indices.add(i);
        }

        for (int i = 0; i < n; i++) {
            int range = nse[i] - i - 1;

            if (range > 0) {
                int ele = nums[i];
                List<Integer> indices = eleIndices.get(ele);
                int lastIdx = ub(indices, i + range, pos[i] + 1, indices.size() - 1);
                int inValid = lastIdx - pos[i];
                count += range - inValid;
            }
        }

        return count;
    }

    private int ub(List<Integer> list, int target, int i, int j) {
        while (i <= j) {
            int mid = i + ((j - i) >> 1);
            if (list.get(mid) <= target) i = mid + 1;
            else j = mid - 1;
        }

        return j;
    }

    private int[] nextSmaller(int[] nums, int n) {
        int top = -1;
        int[] stack = new int[n];
        int[] nse = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (top != -1 && nums[i] <= nums[stack[top]]) {
                top--;
            }

            if (top != -1) nse[i] = stack[top];
            else nse[i] = n;

            stack[++top] = i;
        }

        return nse;
    }
}