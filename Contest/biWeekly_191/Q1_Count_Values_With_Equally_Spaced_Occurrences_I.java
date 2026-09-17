package Contest.biWeekly_191;/*
 *
 * https://leetcode.com/contest/biweekly-contest-191/problems/count-values-with-equally-spaced-occurrences-i/
 *
 * # Q1. Count Values With Equally Spaced Occurrences I
 *
 *   Q. You are given an integer array nums.
 *
 *      An integer x is called special if:
 *        ◦ x appears exactly three times in nums.
 *        ◦ All three occurrences of x are equally spaced in nums. In other words, if all occurrences of x are at
 *          indices i1 < i2 < i3, then i2 - i1 = i3 - i2.
 *
 *      Return the number of distinct special integers in nums.
 *
 *    Ex.
 *      Input : nums = [1, 8, 1, 5, 1, 5, 8, 5]
 *      Output: 2
 *      Explanation:
 *                ◦ 1 is special because it occurs exactly three times at equally spaced indices 0, 2, and 4.
 *                ◦ 5 is special because it occurs exactly three times at equally spaced indices 3, 5, and 7.
 *                ◦ 8 is not special because it occurs only twice.
 *
 *              Therefore, the answer is 2.
 *
 *  Constraints:
 *      3 <= nums.length <= 100
 *      1 <= nums[i] <= 100
 */

public class Q1_Count_Values_With_Equally_Spaced_Occurrences_I {

    /// Solution
    public int countSpecialIntegers(int[] nums) {
        int n = nums.length;

        int[][] map = new int[3][101];
        int[] idx = new int[101];

        for (int i = 0; i < n; i++) {
            int ele = nums[i];

            if (idx[ele] == 3 || idx[ele] == -1) {
                idx[ele] = -1;
                continue;
            }

            map[idx[ele]++][ele] = i;
        }

        int count = 0;

        for (int i = 0; i < 101; i++) {
            if (idx[i] == 3 && map[2][i] - map[1][i] == map[1][i] - map[0][i]) {
                count++;
            }
        }

        return count;
    }
}
