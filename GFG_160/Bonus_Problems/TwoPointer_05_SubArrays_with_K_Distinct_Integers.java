package GFG_160.Bonus_Problems;/*
 *
 * https://www.geeksforgeeks.org/problems/subarrays-with-k-different-integers/0
 *
 * # Sub-arrays with K Distinct Integers
 *
 *   Q. You are given an array arr[] of positive integers and an integer k, find the number of
 *      sub-arrays in arr[] where the count of distinct integers is exactly k.
 *
 *      Note: A sub-array is a contiguous part of an array.
 *    Ex.
 *      Input : arr[] = [3, 1, 2, 2, 3], k = 3
 *      Output: 4
 *      Explanation: Sub-arrays formed with exactly 3 distinct integers are:
 *                   arr[0..2], arr[0..3], arr[0..4], arr[1..4].
 */
import java.util.HashMap;
import java.util.Scanner;

public class TwoPointer_05_SubArrays_with_K_Distinct_Integers {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int[]arr = new int[n];

        System.out.println("Elements: ");
        for (int i = 0;i < n;i++) arr[i] = sc.nextInt();

        System.out.println("k: ");
        int k = sc.nextInt();

        System.out.println(exactlyK(arr, k));
    }

    /// Solution
    static int exactlyK(int[]arr, int k) {
        // potd.code.hub
        return atMostK(arr, k) - atMostK(arr, k-1);
    }
    private static int atMostK(int[]arr, int k){
        int n = arr.length, i = 0, j = 0, ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>(k+1);
        while (j < n){
            map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
            while (map.size() > k){
                map.put(arr[i], map.get(arr[i]) - 1);
                if (map.get(arr[i]) == 0) map.remove(arr[i]);
                i++;
            }
            ans += j-i+1;
            j++;
        }
        return ans;
    }
}
