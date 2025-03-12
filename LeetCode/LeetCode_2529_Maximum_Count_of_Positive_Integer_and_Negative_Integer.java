package LeetCode;/*
 *
 * https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer/
 *
 * #2529. Maximum Count of Positive Integer and Negative Integer
 *
 *   Q. Given an array nums sorted in non-decreasing order, return the maximum between the number
 *      of positive integers and the number of negative integers.
 *
 *      In other words, if the number of positive integers in nums is pos and the number of
 *      negative integers is neg, then return the maximum of pos and neg.
 *
 *      Note that 0 is neither positive nor negative.
 *   Ex.
 *      Input : nums = [-3,-2,-1,0,0,1,2]
 *      Output: 3
 *      Explanation: There are 2 positive integers and 3 negative integers. The maximum count among
 *                   them is 3.
 */
import java.util.Scanner;

public class LeetCode_2529_Maximum_Count_of_Positive_Integer_and_Negative_Integer {

    /// main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Elements: ");
        for (int i = 0;i < n;i++)
            arr[i] = sc.nextInt();

        System.out.println(maximumCount(arr));
    }

    /// Solution
    static int maximumCount(int[] nums) {
        // @ sibasundarj8@gmail.com
        int n = nums.length, neg = 0, pos = 0;

        int i = 0, j = n-1;
        while (i <= j){
            int mid = i + (j-i)/2;
            if (nums[mid] < 0){
                neg = mid+1;
                i = mid+1;
            }
            else j = mid-1;
        }

        i = 0;
        j = n-1;
        while (i <= j){
            int mid = i + (j-i)/2;
            if (nums[mid] > 0){
                pos = n-mid;
                j = mid-1;
            }
            else i = mid+1;
        }

        return Math.max(pos, neg);
    }
}
