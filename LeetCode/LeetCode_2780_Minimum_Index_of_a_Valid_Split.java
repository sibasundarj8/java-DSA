package LeetCode;/*
 *
 * https://leetcode.com/problems/minimum-index-of-a-valid-split/description/
 *
 * # 2780. Minimum Index of a Valid Split
 *
 *   Q. An element x of an integer array arr of length m is dominant if more than half the elements
 *      of arr have a value of x.
 *
 *      You are given a 0-indexed integer array nums of length n with one dominant element.
 *
 *      You can split nums at an index i into two arrays nums[0, ..., i] and nums[i + 1, ..., n - 1],
 *      but the split is only valid if:
 *
 *       • 0 <= i < n - 1
 *       • nums[0, ..., i], and nums[i + 1, ..., n - 1] have the same dominant element.
 *
 *      Here, nums[i, ..., j] denotes the subarray of nums starting at index i and ending at index j,
 *      both ends being inclusive. Particularly, if j < i then nums[i, ..., j] denotes an empty subarray.
 *
 *      Return the minimum index of a valid split. If no valid split exists, return -1.
 *   Ex.
 *      Input : nums = [2,1,3,1,1,1,7,1.2.1]
 *      Output: 4
 *      Explanation: We can split the array at index 4 to get arrays [2,1,3,1,1] and [1,7,1,2,1].
 *           In array [2,1,3,1,1], element 1 is dominant since it occurs thrice in the array and 3 * 2 > 5.
 *           In array [1,7,1,2,1], element 1 is dominant since it occurs thrice in the array and 3 * 2 > 5.
 *           Both [2,1,3,1,1] and [1,7,1,2,1] have the same dominant element as nums, so this is a valid split.
 *           It can be shown that index 4 is the minimum index of a valid split.
 */
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class LeetCode_2780_Minimum_Index_of_a_Valid_Split {

    /// main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Elements: ");
        String[] s = sc.nextLine().split(" ");

        List<Integer> list = new LinkedList<>();
        for (String x : s)
            list.add(Integer.parseInt(x));

        System.out.println(minimumIndex(list));
    }

    /// Solution
    static int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        int[] majority = majorityElement(nums, n);

        if (majority[0] != -1){
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (nums.get(i) == majority[0])
                    count++;
                if (count > (i+1)/2 && majority[1]-count > (n-i-1)/2)
                    return i;
            }
        }

        return -1;
    }
    private static int[] majorityElement(List<Integer> list, int n){
        int maj = -1, count = 0;
        for (int i : list){
            if (count == 0){
                maj = i;
                count++;
            }
            else if (maj == i) count++;
            else count--;
        }
        count = 0;
        for (int i : list)
            if (i == maj) count++;

        return (count > n/2) ? new int[]{maj, count} : new int[]{-1};
    }
}
