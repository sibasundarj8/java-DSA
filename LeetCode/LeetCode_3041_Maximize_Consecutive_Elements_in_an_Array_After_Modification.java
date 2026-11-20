package LeetCode;/*
 *
 * https://leetcode.com/problems/maximize-consecutive-elements-in-an-array-after-modification/
 *
 * # LC. 3041. Maximize Consecutive Elements in an Array After Modification
 *
 *   Q. You are given a 0-indexed array nums consisting of positive integers.
 *      Initially, you can increase the value of any element in the array by at most 1.
 *
 *      After that, you need to select one or more elements from the final array such that those elements are
 *      consecutive when sorted in increasing order. For example, the elements [3, 4, 5] are consecutive while
 *      [3, 4, 6] and [1, 1, 2, 3] are not.
 *
 *      Return the maximum number of elements that you can select.
 *
 *    Ex.
 *      Input : nums = [2, 1, 5, 1, 1]
 *      Output: 3
 *      Explanation: We can increase the elements at indices 0 and 3. The resulting array is nums = [3,1,5,2,1].
 *                   We select the elements [3,1,5,2,1] and we sort them to obtain [1,2,3], which are consecutive.
 *                   It can be shown that we cannot select more than 3 consecutive elements.
 *
 *  Constraints:
 *        ◦ 1 <= nums.length <= 10⁵
 *        ◦ 1 <= nums[i] <= 10⁶
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class LeetCode_3041_Maximize_Consecutive_Elements_in_an_Array_After_Modification {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("nums[] : ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }

        System.out.println("maximum number of elements:");
        System.out.println(maxSelectedElements(nums));
    }

    /// Solution
/*
------------------------------------------------------Using-HashMap------------------------------------------------------
TC : O(n log n)
SC : O(n)
*/
    static int usingHashMap(int[] nums) {
        // potd.code.hub
        Arrays.sort(nums);

        int max = 1;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int cur : nums) {
            int y = map.getOrDefault(cur, 0) + 1;
            int x = map.getOrDefault(cur - 1, 0) + 1;

            map.put(cur + 1, y);
            map.put(cur, x);

            max = Math.max(max, Math.max(x, y));
        }

        return max;
    }
/*
-------------------------------------------------------Tabulation-------------------------------------------------------
TC : O(n log n)
SC : O(n)
*/
    static int tabulation(int[] nums) {
        // potd.code.hub
        int n = nums.length;
        int[][] dp = new int[2][n];

        Arrays.sort(nums);

        dp[0][n - 1] = dp[1][n - 1] = 1;
        int max = 1;

        for (int i = n - 2; i >= 0; i--) {
            int cur = nums[i];
            int nxt = nums[i + 1];

            if (cur == nxt) {
                dp[0][i] = dp[1][i + 1] + 1;
                dp[1][i] = dp[1][i + 1];
            } else if (cur + 1 == nxt) {
                dp[0][i] = dp[0][i + 1] + 1;
                dp[1][i] = dp[1][i + 1] + 1;
            } else if (cur + 2 == nxt) {
                dp[0][i] = 1;
                dp[1][i] = dp[0][i + 1] + 1;
            } else {
                dp[0][i] = dp[1][i] = 1;
            }

            max = Math.max(max, Math.max(dp[0][i], dp[1][i]));
        }

        return max;
    }

/*
-----------------------------------------------------Space-Optimized-----------------------------------------------------
TC : O(n log n)
SC : O(1)
*/
    static int maxSelectedElements(int[] nums) {
        // potd.code.hub
        int n = nums.length;
        Arrays.sort(nums);

        int nxt0 = 1;
        int nxt1 = 1;
        int cur0, cur1;
        int max = 1;

        for (int i = n - 2; i >= 0; i--) {
            int cur = nums[i];
            int nxt = nums[i + 1];

            if (cur == nxt) {
                cur0 = nxt1 + 1;
                cur1 = nxt1;
            } else if (cur + 1 == nxt) {
                cur0 = nxt0 + 1;
                cur1 = nxt1 + 1;
            } else if (cur + 2 == nxt) {
                cur0 = 1;
                cur1 = nxt0 + 1;
            } else {
                cur0 = cur1 = 1;
            }

            max = Math.max(max, Math.max(cur0, cur1));
            nxt0 = cur0;
            nxt1 = cur1;
        }

        return max;
    }
}
