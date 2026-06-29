package Contest.weekly_506;/*
 *
 * https://leetcode.com/contest/weekly-contest-506/problems/frequency-balance-subarray/
 *
 * # Q2. Frequency Balance Subarray
 *
 *   Q. You are given an integer array nums.
 *
 *      Define a frequency balance subarray as follows:
 *        ◦ If the subarray contains only one element, it is frequency balanced.
 *        ◦ If the subarray contains at least two elements, then every element with maximum frequency must occur exactly
 *          twice as many times as every other distinct value in that subarray.
 *
 *      Return an integer denoting the length of the longest frequency balance subarray.
 *      A subarray is a contiguous non-empty sequence of elements within an array.
 *      The frequency of an element x is the number of times it occurs in the array.
 *
 *    Ex.
 *      Input : nums = [1, 2, 2, 1, 2, 3, 3, 3]
 *      Output: 5
 *      Explanation:
 *              The longest frequency balance subarray is [2, 1, 2, 3, 3].
 *              The elements that appear most frequently are 2 and 3, both appearing twice.
 *              The remaining element 1 appears once, meeting the requirements.
 *
 *  Constraints:
 *          1 <= nums.length <= 10³
 *          1 <= nums[i] <= 10⁹
 */

import java.util.HashMap;

public class Q2_Frequency_Balance_Subarray {

    /// Solution
    public int getLength(int[] nums) {
        int maxLength = 0;
        int n = nums.length;
        int id = 0;
        int[] compressed = new int[n];
        HashMap<Integer, Integer> valIdMap = new HashMap<>();

        // coordinate-compression
        for (int i = 0; i < n; i++) {
            int val = nums[i];
            if (!valIdMap.containsKey(val)) valIdMap.put(val, id++);
            compressed[i] = valIdMap.get(val);
        }

        // checking every possible sub-array
        for (int i = 0; i < n; i++) {
            int[] freq = new int[id];
            int[] freqCount = new int[n + 1];
            int maxFreq = 0;
            int distinctFreqCount = 0;

            for (int j = i; j < n; j++) {
                int val = compressed[j];
                int oldFrq = freq[val];
                int newFrq = oldFrq + 1;

                freq[val] = newFrq;
                maxFreq = Math.max(maxFreq, newFrq);

                freqCount[newFrq]++;
                freqCount[oldFrq]--;
                if (freqCount[newFrq] == 1) distinctFreqCount++;
                if (freqCount[oldFrq] == 0) distinctFreqCount--;

                if (isBalanced(freqCount, distinctFreqCount, maxFreq)) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }

        return maxLength;
    }

    private boolean isBalanced(int[] freqCount, int distinctFreqCount, int maxFreq) {
        // what if there is only one type of elements.
        if (distinctFreqCount == 1 && freqCount[maxFreq] == 1) return true;

        // what is the frequencies of elements are in form of F and 2F
        if ((maxFreq & 1) == 1) return false;
        if (distinctFreqCount > 2) return false;

        return freqCount[maxFreq >> 1] != 0;
    }
}