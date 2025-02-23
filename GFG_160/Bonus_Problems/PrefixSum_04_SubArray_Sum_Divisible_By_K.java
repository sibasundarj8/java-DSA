package GFG_160.Bonus_Problems;/*
 *
 * https://www.geeksforgeeks.org/problems/sub-array-sum-divisible-by-k2617/1
 *
 * # Subarray Sum Divisible By K
 *
 *   Q. You are given an integer array arr[] and a value k. The task is to find the count of all
 *      subarrays whose sum is divisible by k.
 *    Ex.
 *      Input: arr[] = [4, 5, 0, -2, -3, 1]
 *                      k = 5
 *      Output: 7
 *      Explanation: There are 7 sub-arrays whose sum is divisible by k:
 *                  [4, 5, 0, -2, -3, 1]
 *                  [5]
 *                  [5, 0]
 *                  [5, 0, -2, -3]
 *                  [0]
 *                  [0, -2, -3]
 *                  [-2, -3]
 */
import java.util.Scanner;

public class PrefixSum_04_SubArray_Sum_Divisible_By_K {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Elements: ");
        for (int i = 0;i < n;i++)
            arr[i] = sc.nextInt();

        System.out.println("k: ");
        int k = sc.nextInt();

        System.out.println(subCount(arr, k));
    }

    /// Solution
    static int subCount(int[] arr, int k) {
        // potd.code.hub
        int sum = 0, ans = 0;
        int[] freq = new int[k];
        freq[0] = 1;

        for (int i : arr) {
            // sum may exceed the Integer limit, That's why I am storing the remainders.
            sum = ((sum + i) % k + k) % k;
            ans += freq[sum];
            freq[sum]++;
        }
        
        return ans;
    }
}
