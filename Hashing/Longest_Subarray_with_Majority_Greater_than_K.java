package Hashing;/*
 *
 * https://www.geeksforgeeks.org/problems/longest-subarray-with-majority-greater-than-k/1
 *
 * # Longest Subarray with Majority Greater than K
 *
 *   Q. Given an array arr[] and an integer k, the task is to find the length of longest subarray in
 *      which the count of elements greater than k is more than the count of elements less than or
 *      equal to k.
 *   Ex.
 *      Input : arr[] = [1, 2, 3, 4, 1]
 *              k = 2
 *      Output: 3
 *      Explanation: The subarray [2, 3, 4] or [3, 4, 1] satisfy the given condition, and there is no
 *                   subarray of length 4 or 5 which will hold the given condition, so the answer is 3.
 */
import java.util.HashMap;
import java.util.Scanner;

public class Longest_Subarray_with_Majority_Greater_than_K {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Element: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];

        for (int i = 0;i < n;i++){
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.println("k: ");
        int k = sc.nextInt();

        System.out.println("Longest sub-array size: " + longestSubarray(arr, k));
    }

    /// Solution
    static int longestSubarray(int[] arr, int k) {
        // potd.code.hub
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int ans = 0;
        int sum = 0;

        for (int i = 0;i < n;i++){
            sum += (arr[i] > k) ? 1 : -1;
            map.putIfAbsent(sum, i);
            ans = Math.max(ans, i - map.getOrDefault(sum-1, i));
        }

        return (sum > 0) ? n : ans;
    }
}
