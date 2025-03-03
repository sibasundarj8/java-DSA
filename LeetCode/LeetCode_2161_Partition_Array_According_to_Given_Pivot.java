package LeetCode;/*
 *
 * https://leetcode.com/problems/partition-array-according-to-given-pivot/description/
 *
 * #2161. Partition Array According to Given Pivot
 *
 *   Q. You are given a 0-indexed integer array nums and an integer pivot. Rearrange nums such
 *      that the following conditions are satisfied:
 *
 *        • Every element less than pivot appears before every element greater than pivot.
 *        • Every element equal to pivot appears in between the elements less than and greater
 *          than pivot.
 *        • The relative order of the elements less than pivot and the elements greater than pivot
 *          is maintained.
 *        • More formally, consider every pi, pj where pi is the new position of the ith element
 *          and pj is the new position of the jth element. If i < j and both elements are smaller
 *          (or larger) than pivot, then pi < pj.
 *
 *       Return nums after the rearrangement.
 *    Ex.
 *      Input : nums = [9, 12, 5, 10, 14, 3, 10]
 *              pivot = 10
 *      Output: [9,5,3,10,10,12,14]
 *      Explanation:
 *            ⁕ Elements 9, 5, and 3 are less than the pivot so they are on the left side of the
 *              array.
 *            ⁕ The elements 12 and 14 are greater than the pivot, so they are on the right side
 *              of the array.
 *            ⁕ The relative ordering of the elements less than and greater than pivot is also
 *              maintained. [9, 5, 3] and [12, 14] are the respective orderings.
 */
import java.util.Scanner;

public class LeetCode_2161_Partition_Array_According_to_Given_Pivot {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Elements: ");
        for (int i = 0;i < n;i++)
            arr[i] = sc.nextInt();

        System.out.println("Pivot: ");
        int p = sc.nextInt();

        for (int i : pivotArray(arr, p))
            System.out.print(i + " ");
        System.out.println();
    }

    /// Solution
    static int[] pivotArray(int[] arr, int pivot) {
        int n = arr.length;
        int pos = 0, freq = 0;
        int[]ans = new int[n];

        for (int i : arr)
            if (i < pivot) pos++;
            else if (i == pivot) freq++;

        int min = 0, max = pos + freq;
        for (int ele : arr)
            if (ele < pivot) ans[min++] = ele;
            else if (ele > pivot) ans[max++] = ele;
            else ans[pos++] = ele;

        return ans;
    }
}
