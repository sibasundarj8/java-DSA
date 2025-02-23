package GFG_160.Bonus_Problems;/*
 *
 * https://www.geeksforgeeks.org/problems/longest-subarray-with-sum-divisible-by-k1259/1
 *
 * # Longest subarray with sum divisible by K
 *
 *   Q. Given an array arr[] and a positive integer k, find the length of the longest subarray with the
 *      sum of the elements divisible by k.
 *
 *      Note: If there is no subarray with sum divisible by k, then return 0.
 *    Ex.
 *      Input : arr[] = [-2, 2, -5, 12, -11, -1, 7]
 *              k = 3
 *      Output: 5
 *      Explanation: The subarray [2, -5, 12, -11, -1] has sum = -3, which is divisible by 3.
 */
import java.util.Arrays;
import java.util.Scanner;

public class PrefixSum_05_Longest_subarray_with_sum_divisible_by_K {

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

        System.out.println(longestSubarrayDivK(arr, k));
    }

    /// Solution
    static int longestSubarrayDivK(int[] arr, int k) {
        // potd.code.hub
        int ans = 0, n = arr.length, sum = 0;
        int[] freq = new int[k];
        Arrays.fill(freq, -2);
        freq[0] = -1;
    
        for (int i = 0;i < n;i++){
            sum = ((sum + arr[i]) % k + k) % k;
            if (freq[sum] == -2) freq[sum] = i;
            else ans = Math.max(ans, i - freq[sum]);
        }

        return ans;
    }
}
