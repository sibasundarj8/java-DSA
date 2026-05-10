package Contest.weekly_501;/*
 *
 * https://leetcode.com/contest/weekly-contest-501/problems/minimize-array-sum-using-divisible-replacements/
 *
 * #  Q3. Minimize Array Sum Using Divisible Replacements
 *
 *   Q. You are given an integer array nums.
 *
 *      You can perform the following operation any number of times:
 *        ◦ Choose two indices a and b such that nums[a] % nums[b] == 0.
 *        ◦ Replace nums[a] with nums[b].
 *
 *      Return the minimum possible sum of the array after performing any number of operations.
 *
 *    Ex.
 *      Input : nums = [4,2,8,3]
 *      Output: 9
 *      Explanation:
 *              Choose a = 0, b = 1, where nums[a] = 4 and nums[b] = 2. Since 4 % 2 == 0, replace nums[0] with nums[1].
 *              Choose a = 2, b = 1, where nums[a] = 8 and nums[b] = 2. Since 8 % 2 == 0, replace nums[2] with nums[1].
 *              The array becomes [2, 2, 2, 3].
 *              No further operation reduces the sum. Thus, the final sum is 2 + 2 + 2 + 3 = 9.
 *
 *  Constraints:
 *          1 <= nums.length <= 10⁵
 *          1 <= nums[i] <= 10⁵
 */

import java.util.Arrays;
import java.util.HashSet;

public class Q3_Minimize_Array_Sum_Using_Divisible_Replacements {

    /// Solution
    public long minArraySum(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        long ans = 0;

        Arrays.sort(nums);

        for (int num : nums) {
            int best = num;

            for (int divisor1 = 1; divisor1 * divisor1 <= num; divisor1++) {
                if (num % divisor1 == 0) {
                    int divisor2 = num / divisor1;

                    if (set.contains(divisor1)) {
                        best = Math.min(best, divisor1);
                        break;
                    }

                    if (set.contains(divisor2)) {
                        best = Math.min(best, divisor2);
                    }
                }
            }

            ans += best;
            set.add(num);
        }

        return ans;
    }
}
