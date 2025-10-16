package LeetCode;/*
[Medium]
problem link - https://leetcode.com/problems/smallest-missing-non-negative-integer-after-operations/
*/

public class LeetCode_2598_Smallest_Missing_Non_negative_Integer_After_Operations {

    /// main Method
    public static void main(String[] args) {
        System.out.println(findSmallestInteger(new int[]{1,-10,7,13,6,8}, 7));
    }

    /// Solution
    static int findSmallestInteger(int[] nums, int value) {
        // potd.code.hub
        int minFreq = Integer.MAX_VALUE;
        int minValue = Integer.MAX_VALUE;
        int[] map = new int[value];

        for (int num : nums) {
            int cur = num % value;
            int ele = (cur < 0) ? value + cur : cur;
            map[ele]++;
        }

        for (int i = 0; i < value; i++) {
            int curr = map[i];
            if (curr < minFreq) {
                minFreq = curr;
                minValue = i;
            }
        }

        return value * minFreq + minValue;
    }
}
