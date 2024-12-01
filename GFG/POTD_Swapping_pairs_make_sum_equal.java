package GFG;/*
 *  Q.  Given two arrays of integers a[] and b[] of size n and m, the task is to check
 *      if a pair of values (one value from each array) exists such that swapping the
 *      elements of the pair will make the sum of two arrays equal.
 *    Ex:-
 *        Input: n = 6
 *               m = 4
 *             a[] = {4, 1, 2, 1, 1, 2}
 *             b[] = (3, 6, 3, 3)
 *
 *       Output: 1
 *
 *       Explanation:
 *                   Sum of elements in a[] = 11,
 *                   Sum of elements in b[] = 15,
 *                   To get same sum from both arrays,
 *                   we can swap following values: 1 from a[] and 3 from b[]
 */

import java.util.Arrays;
import java.util.Scanner;

public class POTD_Swapping_pairs_make_sum_equal
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Array size :");
        long[]arr = new long[(int) sc.nextLong()];

        System.out.println("Elements : ");
        for (int i = 0; i < arr.length;i++)arr[i] = sc.nextInt();

        System.out.println("Size : ");
        long[]arr1 = new long[(int) sc.nextLong()];

        System.out.println("Elements : ");
        for (int i = 0;i < arr1.length;i++)arr1[i] = sc.nextInt();

        System.out.println(findSwapValues(arr,arr.length,arr1,arr1.length));
    }
    static long findSwapValues(long []a, int n, long []b, int m)
    {
        // Your code goes here
        long sumA = 0;
        long sumB = 0;

        for (long i : a)sumA += i;  // sum of Elements
        for (long i : b)sumB += i;

        if ((sumB-sumA)%2 != 0)return -1;
        long target = Math.abs((sumB-sumA)/2);

        // Sorting Increasing order
        Arrays.sort(a);
        Arrays.sort(b);

        // Two pointer Approach
        int i = 0;
        int j = 0;
        while (i<n && j<m)
        {
            long gap = Math.abs(a[i]-b[j]);

            if (gap == target)return 1;
            else if (gap > target)i++;
            else j++;
        }
        return -1;
    }
}