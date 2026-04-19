package Contest.biWeekly_180;/*
 *
 * https://leetcode.com/contest/biweekly-contest-180/problems/count-digit-appearances/
 *
 * # Q2. Count Digit Appearances
 *
 *   Q. You are given an integer array nums and an integer digit.
 *      Return the total number of times digit appears in the decimal representation of all elements in nums.
 *
 *    Ex.
 *      Input : nums = [12,54,32,22], digit = 2
 *      Output: 4
 *      Explanation: The digit 2 appears once in 12 and 32, and twice in 22. Thus, the total number of times digit 2 appears is 4.
 *
 *  Constraints:
 *          1 <= nums.length <= 1000
 *          1 <= nums[i] <= 10⁶
 *          0 <= digit <= 9
 */

public class Q2_Count_Digit_Appearances {

    /// Solution
    public int countDigitOccurrences(int[] nums, int digit) {
        int count = 0;

        for(int i : nums) {
            count += countDigit("" + i, digit);
        }

        return count;
    }

    private int countDigit(String s, int digit) {
        int n = s.length();
        int count = 0;

        for (int i = 0; i < n; i++) {
            int cur = s.charAt(i) - '0';

            if(cur == digit) count++;
        }

        return count;
    }
}
