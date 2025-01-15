package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1
 *
 * # Longest Sub-array with Sum K
 *
 *   Q. Given an array arr[] containing integers and an integer k, your task is to find the length
 *      of the longest sub-array where the sum of its elements is equal to the given value k.
 *      If there is no sub-array with sum equal to k, return 0.
 *    Ex.
 *      Input : arr[] = [10, 5, 2, 7, 1, -10]
 *              k = 15
 *      Output: 6
 *      Explanation: Sub-arrays with sum = 15 are [5, 2, 7, 1], [10, 5] and [10, 5, 2, 7, 1, -10].
 *                   The length of the longest sub-array with a sum of 15 is 6.
 */
import java.util.HashMap;
import java.util.Scanner;

public class GFG_62_Longest_SubArray_with_Sum_K {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int[]arr = new int[n];

        System.out.println("Elements: ");
        for (int i = 0;i < n;i++)arr[i] = sc.nextInt();

        System.out.println("K: ");
        int k = sc.nextInt();

        System.out.println(longestSubArray(arr, k));
    }

    /// Solution
    static int longestSubArray(int[]arr, int k) {
        // potd.code.hub
        int n = arr.length, ans = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0;i < n;i++){
            sum += arr[i];
            if (sum == k) ans = i+1;
            map.putIfAbsent(sum, i);
            ans = Math.max(ans, i - map.getOrDefault(sum-k, i));
        }
        return ans;
    }
}
