package Contest.weekly_503;/*
 *
 * https://leetcode.com/contest/weekly-contest-503/problems/minimum-operations-to-sort-a-permutation/
 *
 * # Q3. Minimum Operations to Sort a Permutation
 *
 *   Q. You are given an integer array nums of length n, where nums is a permutation of the integers from 0 to n - 1.
 *
 *      You may perform only the following operations:
 *        ◦ Reverse the entire array.
 *        ◦ Rotate Left by One: Move the first element to the end of the array, and rest elements to left by one position.
 *
 *      Return an integer denoting the minimum number of operations required to sort the array in increasing order. If it
 *      is not possible to sort the array using only the given operations, return -1.
 *
 *    Ex.
 *      Input : nums = [1, 0, 2]
 *      Output: 2
 *      Explanation:
 *              Reverse the array: [2, 0, 1]
 *              Rotate Left by one: [0, 1, 2]
 *              The array becomes sorted in 2 operations, which is minimal.
 *
 *  Constraints:
 *          1 <= n == nums.length <= 10⁵
 *          0 <= nums[i] <= n - 1
 *          nums is a permutation of integers from 0 to n - 1.
 */

public class Q3_Minimum_Operations_to_Sort_a_Permutation {

    /// Solution
    public int minOperations(int[] nums) {
        int n = nums.length;
        int dropsInc = 0;
        int dropsDec = 0;
        int posInc = -1;
        int posDec = -1;

        if (n == 1) return 0;

        for (int i = 0; i < n; i++) {
            if (nums[(i - 1 + n) % n] > nums[i]) {
                dropsInc++;
                posInc = i;
            }
            if (nums[(i - 1 + n) % n] < nums[i]) {
                dropsDec++;
                posDec = i;
            }
        }

        if (dropsInc <= 1) {
            return Math.min(posInc, n - posInc + 2);
        } 
        
        if (dropsDec <= 1) {
            return Math.min(posDec, n - posDec) + 1;
        } 
        
        return -1;
    }
}
