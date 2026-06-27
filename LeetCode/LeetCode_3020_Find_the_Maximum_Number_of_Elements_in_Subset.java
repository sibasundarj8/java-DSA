package LeetCode;/*
 *
 * https://leetcode.com/problems/find-the-maximum-number-of-elements-in-subset/
 *
 * # LC. 3020. Find the Maximum Number of Elements in Subset
 *
 *   Q. You are given an array of positive integers nums.
 *
 *      You need to select a subset of nums which satisfies the following condition:
 *
 *        ◦ You can place the selected elements in a 0-indexed array such that it follows the pattern: [x, x2, x4, ...,
 *          xk/2, xk, xk/2, ..., x4, x2, x] (Note that k can be any non-negative power of 2). For example, [2, 4, 16, 4,
 *          2] and [3, 9, 3] follow the pattern while [2, 4, 8, 4, 2] does not.
 *
 *        ◦ Return the maximum number of elements in a subset that satisfies these conditions.
 *
 *    Ex.
 *      Input : nums = [5,4,1,2,2]
 *      Output: 3
 *      Explanation: We can select the subset {4,2,2}, which can be placed in the array as [2,4,2] which follows the
 *                   pattern and 22 == 4. Hence, the answer is 3.
 *
 *  Constraints:
 *      ◦ 2 <= nums.length <= 10⁵
 *      ◦ 1 <= nums[i] <= 10⁹
 */

import java.util.HashMap;
import java.util.Scanner;

public class LeetCode_3020_Find_the_Maximum_Number_of_Elements_in_Subset {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the array elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.println("Maximum number of elements in a subset: ");
        System.out.println(maximumLength(arr));
    }

    /// Solution
    static int maximumLength(int[] nums) {
        int max = 0;
        HashMap<Long, Integer> map = new HashMap<>();

        for (int ele : nums) {
            map.merge((long) ele, 1, Integer::sum);
        }

        for (long ele : map.keySet()) {
            max = Math.max(max, calculate(ele, map));
        }

        return max;
    }

    private static int calculate(long ele, HashMap<Long, Integer> map) {
        if (map.get(ele) == 1) return 1;

        if (ele == 1) {
            int freq = map.get(ele);
            return ((freq & 1) == 1) ? freq : freq - 1;
        }

        int count = 0;
        long cur = ele;

        while (map.getOrDefault(cur, 0) >= 2) {
            count += 2;
            cur *= cur;
        }

        return (map.containsKey(cur)) ? count + 1 : count - 1;
    }
}
