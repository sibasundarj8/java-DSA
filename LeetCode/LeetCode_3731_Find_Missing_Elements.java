package LeetCode;/*
 *
 * https://leetcode.com/problems/find-missing-elements/
 *
 * # LC. 3731. Find Missing Elements
 *
 *   Q. You are given an integer array nums consisting of unique integers.
 *
 *      Originally, nums contained every integer within a certain range. However, some integers might have gone missing
 *      from the array.
 *
 *      The smallest and largest integers of the original range are still present in nums.
 *
 *      Return a sorted list of all the missing integers in this range. If no integers are missing, return an empty list.
 *
 *    Ex.
 *      Input : nums = [1, 4, 2, 5]
 *      Output: [3]
 *      Explanation:
 *              The smallest integer is 1 and the largest is 5, so the full range should be [1,2,3,4,5]. Among these,
 *              only 3 is missing.
 *
 *  Constraints:
 *        ◦ 2 <= nums.length <= 100
 *        ◦ 1 <= nums[i] <= 100
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LeetCode_3731_Find_Missing_Elements {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("int[] nums: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.println("Mising number in that range: ");
        System.out.println(findMissingElements(arr));
    }

    /// Solution
    static List<Integer> findMissingElements(int[] nums) {
        // potd.code.hub
        int l = Integer.MAX_VALUE;
        int h = Integer.MIN_VALUE;
        List<Integer> list = new ArrayList<>();

        for (int ele : nums) {
            l = Math.min(l, ele);
            h = Math.max(h, ele);
        }

        int m = h - l + 1;
        boolean[] seen = new boolean[m];

        for (int ele : nums) {
            seen[ele - l] = true;
        }

        for (int i = 0; i < m; i++) {
            if (!seen[i]) {
                list.add(i + l);
            }
        }

        return list;
    }
}
