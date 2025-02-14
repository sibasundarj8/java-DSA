package GFG_160.Bonus_Problems;/*
 *
 * https://www.geeksforgeeks.org/problems/longest-subarray-with-majority-greater-than-k/0
 *
 * # Longest Sub-array with Majority Greater than K
 * 
 *   Q. Given an array arr[] and an integer k, the task is to find the length of longest sub-array
 *      in which the count of elements greater than k is more than the count of elements less than
 *      or equal to k.
 *    Ex.
 *      Input : arr[] = [1, 2, 3, 4, 1] , k = 2
 *      Output: 3
 *      Explanation: The sub-array [2, 3, 4] or [3, 4, 1] satisfy the given condition, and there is
 *                   no sub-array of length 4 or 5 which will hold the given condition, so the answer
 *                   is 3.
 */
import java.util.HashMap;
import java.util.Scanner;

public class PrefixSum_02_Longest_SubArray_with_Majority_Greater_than_K {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Elements: ");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        System.out.println("k: ");
        int k = sc.nextInt();

        System.out.println(longestSubArray(arr, k));
    }

    /// Solution
    static int longestSubArray(int[] arr, int k) {
        // potd.code.hub
        int n = arr.length, prefix = 0, ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0;i < n;i++){
            prefix += (arr[i] > k) ? 1 : -1;
            if (prefix > 0) ans = i+1;
            if (map.containsKey(prefix - 1))
                ans = Math.max(ans, i - map.get(prefix - 1));
            map.putIfAbsent(prefix, i);
        }
        return ans;
    }
}
