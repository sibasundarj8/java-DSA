package Contest.biWeekly_191;/*
 *
 * https://leetcode.com/contest/biweekly-contest-191/problems/count-values-with-equally-spaced-occurrences-ii/
 *
 * # Q2. Count Values With Equally Spaced Occurrences II
 *
 *   Q. You are given an integer array nums.
 *
 *      An integer x is called special if:
 *        ◦ x appears at least three times in nums.
 *        ◦ All occurrences of x are equally spaced in nums. In other words, if all occurrences of x are at indices
 *          i1 < i2 < ... < im, then i2 - i1 = i3 - i2 = ... = im - im-1.
 *
 *      Return the number of distinct special integers in nums.
 *
 *    Ex.
 *      Input : nums = [1, 8, 1, 5, 1, 5, 8, 5]
 *      Output: 2
 *      Explanation:
 *                ◦ 1 is special because it occurs at equally spaced indices 0, 2, and 4.
 *                ◦ 5 is special because it occurs at equally spaced indices 3, 5, and 7.
 *                ◦ 8 is not special because it occurs only twice.
 *
 *              Therefore, the answer is 2.
 *
 *  Constraints:
 *        ◦ 3 <= nums.length <= 10⁵
 *        ◦ 1 <= nums[i] <= 10⁹
 */

import java.util.HashMap;
import java.util.Map;

public class Q2_Count_Values_With_Equally_Spaced_Occurrences_II {

    /// Solution
    public int countSpecialIntegers(int[] nums) {
        int n = nums.length;

        Map<Integer, int[]> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int ele = nums[i];

            // state --> {isApplicable, freq, lastIdx, lastGap}
            int[] prev = map.get(ele);

            if (prev == null) {
                prev = new int[]{1, 0, i, 0};
                map.put(ele, prev);
            }

            if (prev[0] == 0) continue;

            if (prev[1] > 1) {
                int curGap = i - prev[2];
                if (prev[3] != curGap) prev[0] = 0;
            }

            prev[1]++;
            prev[3] = i - prev[2];
            prev[2] = i;
        }

        int count = 0;

        for (int[] state : map.values()) {
            if (state[0] == 0 || state[1] < 3) continue;
            count++;
        }

        return count;
    }
}