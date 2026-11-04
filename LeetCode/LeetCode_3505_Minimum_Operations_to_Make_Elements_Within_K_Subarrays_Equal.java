package LeetCode;/*
 *
 * https://leetcode.com/problems/minimum-operations-to-make-elements-within-k-subarrays-equal/
 *
 * # LC. 3505. Minimum Operations to Make Elements Within K Subarrays Equal
 *
 *   Q. You are given an integer array nums and two integers, x and k. You can perform the following operation any
 *      number of times (including zero): Increase or decrease any element of nums by 1.
 *
 *      Return the minimum number of operations needed to have at least k non-overlapping subarrays of size exactly
 *      x in nums, where all elements within each subarray are equal.
 *
 *    Ex.
 *      Input : nums = [5, -2, 1, 3, 7, 3, 6, 4, -1],
 *              x = 3,
 *              k = 2
 *      Output: 8
 *      Explanation:
 *              ◦ Use 3 operations to add 3 to nums[1] and use 2 operations to subtract 2 from nums[3]. The resulting
 *                array is [5, 1, 1, 1, 7, 3, 6, 4, -1].
 *
 *              ◦ Use 1 operation to add 1 to nums[5] and use 2 operations to subtract 2 from nums[6]. The resulting
 *                array is [5, 1, 1, 1, 7, 4, 4, 4, -1].
 *
 *              ◦ Now, all elements within each subarray [1, 1, 1] (from indices 1 to 3) and [4, 4, 4] (from indices
 *                5 to 7) are equal. Since 8 total operations were used, 8 is the output.
 *
 *  Constraints:
 *      ◦ 2 <= nums.length <= 10⁵
 *      ◦ -10⁶ <= nums[i] <= 10⁶
 *      ◦ 2 <= x <= nums.length
 *      ◦ 1 <= k <= 15
 *      ◦ 2 <= k * x <= nums.length
 */

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class LeetCode_3505_Minimum_Operations_to_Make_Elements_Within_K_Subarrays_Equal {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("nums[]: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.print("x: ");
        int x = sc.nextInt();

        System.out.print("k: ");
        int k = sc.nextInt();

        System.out.print("""
                minimum number of operations needed to have at least k
                non-overlapping subarrays of size exactly x in nums:
                """);
        System.out.println(minOperations(arr, x, k));
    }

    /// Solution
    private static final long MAX_VALUE = Long.MAX_VALUE >>> 1;

    static long minOperations(int[] nums, int x, int k) {
        // potd.code.hub
        int n = nums.length;
        long[] cost = new long[n - x + 1];
        CostCalculationService costCalculationService = new CostCalculationService();

        for (int i = 0; i < n; i++) {
            costCalculationService.addElement(nums[i]);

            if (i >= x - 1) {
                int idx = i - x + 1;
                cost[idx] = costCalculationService.getCost();
                costCalculationService.removeElement(nums[idx]);
            }
        }

        long[][] dp = new long[k][n - x + 1];
        for (long[] row : dp) {
            Arrays.fill(row, MAX_VALUE);
        }

        return solve(0, 0, k, x, n, cost, dp);
    }

    private static long solve(int count, int i, int k, int x, int n, long[] cost, long[][] dp) {
        // base case
        if (count == k) return 0;

        int subArrayNeeded = k - count;
        int cellsNeeded = subArrayNeeded * x;
        int cellsHave = n - i;

        if (cellsNeeded > cellsHave) return MAX_VALUE;
        if (dp[count][i] != MAX_VALUE) return dp[count][i];

        // recursive work
        long nextPick = solve(count + 1, i + x, k, x, n, cost, dp);
        long pick = (nextPick == MAX_VALUE) ? MAX_VALUE : cost[i] + nextPick;
        long skip = solve(count, i + 1, k, x, n, cost, dp);

        // self work
        return dp[count][i] = Math.min(pick, skip);
    }

    private static class CostCalculationService {
        private int LEFT_SIZE = 0;
        private int RIGHT_SIZE = 0;
        private long LEFT_SUM = 0;
        private long RIGHT_SUM = 0;
        private final TreeMap<Integer, Integer> LEFT = new TreeMap<>();
        private final TreeMap<Integer, Integer> RIGHT = new TreeMap<>();

        void addElement(int num) {

            if (RIGHT_SIZE == 0 || num >= RIGHT.firstKey()) {
                RIGHT.put(num, RIGHT.getOrDefault(num, 0) + 1);
                RIGHT_SUM += num;
                RIGHT_SIZE++;
            } else {
                LEFT.put(num, LEFT.getOrDefault(num, 0) + 1);
                LEFT_SUM += num;
                LEFT_SIZE++;
            }

            this.rebalance();
        }

        void removeElement(int num) {
            Integer cnt = LEFT.get(num);

            if (cnt != null) {
                if (cnt == 1) LEFT.remove(num);
                else LEFT.put(num, cnt - 1);

                LEFT_SUM -= num;
                LEFT_SIZE--;

            } else {
                cnt = RIGHT.get(num);

                if (cnt == 1) RIGHT.remove(num);
                else RIGHT.put(num, cnt - 1);

                RIGHT_SUM -= num;
                RIGHT_SIZE--;
            }

            this.rebalance();
        }

        long getCost() {
            int median = RIGHT.firstKey();
            long rightCost = RIGHT_SUM - (long) RIGHT_SIZE * median;
            long leftCost = (long) LEFT_SIZE * median - LEFT_SUM;

            return leftCost + rightCost;
        }

        private void rebalance() {
            if (LEFT_SIZE > RIGHT_SIZE) {
                int val = LEFT.lastKey();

                LEFT.put(val, LEFT.get(val) - 1);
                LEFT_SIZE--;

                RIGHT.put(val, RIGHT.getOrDefault(val, 0) + 1);
                RIGHT_SIZE++;

                LEFT_SUM -= val;
                RIGHT_SUM += val;

                if (LEFT.get(val) == 0) LEFT.remove(val);

            } else if (RIGHT_SIZE > LEFT_SIZE + 1) {
                int val = RIGHT.firstKey();

                RIGHT.put(val, RIGHT.get(val) - 1);
                RIGHT_SIZE--;

                LEFT.put(val, LEFT.getOrDefault(val, 0) + 1);
                LEFT_SIZE++;

                RIGHT_SUM -= val;
                LEFT_SUM += val;

                if (RIGHT.get(val) == 0) RIGHT.remove(val);
            }
        }
    }
}
