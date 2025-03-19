package LeetCode;/*
 *
 * https://leetcode.com/problems/minimum-operations-to-make-binary-array-elements-equal-to-one-i/
 *
 * #3191. Minimum Operations to Make Binary Array Elements Equal to One I
 *
 *   Q. You are given a binary array nums.
 *
 *      You can do the following operation on the array any number of times (possibly zero):
 *
 *         • Choose any 3 consecutive elements from the array and flip all of them. Flipping an element
 *           means changing its value from 0 to 1, and from 1 to 0.
 *
 *      Return the minimum number of operations required to make all elements in nums equal to 1. If it
 *      is impossible, return -1.
 *   Ex.
 *      Input : nums = [0,1,1,1,0,0]
 *      Output: 3
 *      Explanation:
 *          We can do the following operations:
 *          Choose the elements at indices 0, 1 and 2. The resulting array is nums = [1,0,0,1,0,0].
 *          Choose the elements at indices 1, 2 and 3. The resulting array is nums = [1,1,1,0,0,0].
 *          Choose the elements at indices 3, 4 and 5. The resulting array is nums = [1,1,1,1,1,1].
 */
import java.util.Scanner;

public class LeetCode_3191_Minimum_Operations_to_Make_Binary_Array_Elements_Equal_to_One_I {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int[]arr = new int[n];

        System.out.println("Elements: (0/1)");
        for (int i = 0;i < n;i++)
            arr[i] = sc.nextInt();

        System.out.println(minOperations(arr));
    }

    /// Solution
    static int minOperations(int...nums){
        int n = nums.length;
        int count = 0;

        for (int i = 0;i < n-2;i++) {
            if (nums[i] == 0) {
                nums[i] = 1-nums[i];
                nums[i+1] = 1-nums[i+1];
                nums[i+2] = 1-nums[i+2];
                count++;
            }
        }

        if (nums[n-1] == 0 || nums[n-2] == 0) return -1;

        return count;
    }
}
