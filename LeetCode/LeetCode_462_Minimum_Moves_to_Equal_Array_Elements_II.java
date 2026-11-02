package LeetCode;/*
 *
 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/
 *
 * # LC. 462. Minimum Moves to Equal Array Elements II
 *
 *   Q. Given an integer array nums of size n, return the minimum number of moves required to make all array elements
 *      equal.
 *
 *      In one move, you can increment or decrement an element of the array by 1.
 *
 *    Ex.
 *      Input : nums = [1, 2, 3]
 *      Output: 2
 *      Explanation:
 *              Only two moves are needed (remember each move increments or decrements one element):
 *              [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 *
 *  Constraints:
 *        ◦ n == nums.length
 *        ◦ 1 <= nums.length <= 10⁵
 *        ◦ -10⁹ <= nums[i] <= 10⁹
 */

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class LeetCode_462_Minimum_Moves_to_Equal_Array_Elements_II {

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

        System.out.println("minimum number of moves required to make all array elements equal: ");
        System.out.println(minMoves2(nums));
    }

    /// Solution
/*
---------------------------------------------------------Sorting---------------------------------------------------------
TC : O(n log n)
SC : O(1)
*/
    static int approach_1(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        int moves = 0;
        int i = 0, j = n - 1;

        while (i < j) {
            moves += (nums[j] - nums[i]);
            i++;
            j--;
        }

        return moves;
    }

/*
----------------------------------------------------------Heap----------------------------------------------------------
TC : O(m log m)
SC : O(m)        ∵ m = n/2
*/
    static int approach_2(int[] nums) {
        int n = nums.length;
        int moves = 0;
        int k = n >> 1;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int ele : nums) {
            if (pq.size() < k) {
                pq.add(ele);
            } else if (pq.peek() < ele) {
                pq.poll();
                pq.add(ele);
            }
        }

        int median = pq.peek();

        for (int ele : nums) {
            moves += Math.abs(median - ele);
        }

        return moves;
    }

/*
------------------------------------------Quick-Select--(Hoare’s-partitioning)------------------------------------------
TC : O(n)
SC : O(1)
*/
    static int minMoves2(int[] nums) {
        int n = nums.length;
        int moves = 0;
        int m = n >>> 1;

        quickSelect(0, n - 1, nums, m);

        int median = nums[m];

        for (int ele : nums) {
            moves += Math.abs(median - ele);
        }

        return moves;
    }

    private static void quickSelect(int low, int high, int[] nums, int n) {
        // base case
        if (low >= high) return;

        // self work
        int pivot = getMedianOfThree(nums[low], nums[(low + high) >> 1], nums[high]);
        int l = low - 1;  // left window --> holds elements <= pivot
        int r = high + 1; // right window--> holds elements >= pivot

        while (true) {
            do {
                l++;
            } while (nums[l] < pivot);

            do {
                r--;
            } while (nums[r] > pivot);

            if (l >= r) break;

            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            // we don't need to increment i or decrement j bcz we are already incrementing i
            // and decrementing j at least once in do-while loop before check.
        }

        // recursive work
        if (r >= n) quickSelect(low, r, nums, n);
        else quickSelect(r + 1, high, nums, n);
    }

    private static int getMedianOfThree(int a, int b, int c) {
        if ((a >= b) ^ (a >= c)) return a;
        if ((b >= a) ^ (b >= c)) return b;
        return c;
    }
}
