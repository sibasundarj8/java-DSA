package Array;/*
 *
 * https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/0
 *
 * # Longest Sub-Array with Sum K
 *
 *   Q. Given an array arr[] containing integers and an integer k, your task is to find the length of the
 *      longest sub-array where the sum of its elements is equal to the given value k. It is guaranteed
 *      that a valid sub-array exists.
 *    Ex.
 *      Input : arr[] = [1, -1, 5, -2, 3]
 *              k = 3
 *      Output: 4
 *      Explanation: The sub-array [1, -1, 5, -2] has a sum of 3 and a length 4.
 */
import java.util.HashMap;
import java.util.Scanner;
 
public class Array_Longest_Sub_Array_with_Sum_K {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int []arr = new int[n];

        System.out.println("Elements: ");
        for (int i = 0;i < n;i++){
            arr[i] = sc.nextInt();
        }

        System.out.println("K: ");
        int k = sc.nextInt();

        System.out.println(lenOfLongestSubArr(arr, k));
    }

    /// Solution
    static int lenOfLongestSubArr(int[]arr, int k) {
        // potd.code.hub
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int ans = 0;
        for(int i = 0;i < n;i++){
            sum += arr[i];
            map.putIfAbsent(sum, i);
            if (sum == k) ans = i+1;
            else if (map.containsKey(sum-k)){
                ans = Math.max(ans, i - map.get(sum-k));
            }
        }

        return ans;
    }
}
