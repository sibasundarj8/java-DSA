package Array;/*
 *
 * https://www.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1
 *
 * # Largest sub-array with 0 sum
 *
 *   Q. Given an array arr containing both positive and negative integers, the task is to compute
 *      the length of the largest sub-array that has a sum of 0.
 *    Ex.
 *      Input : arr[] = [15, -2, 2, -8, 1, 7, 10, 23]
 *      Output: 5
 *      Explanation: The largest sub-array with a sum of 0 is [-2, 2, -8, 1, 7].
 */
import java.util.HashMap;
import java.util.Scanner;

public class Array_Largest_subArray_with_0_sum {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int[]arr = new int[n];

        System.out.println("Elements: ");
        for (int i = 0;i < n;i++) arr[i] = sc.nextInt();

        System.out.println(maxLen(arr));
    }

    /// Solution
    static int maxLen(int[] arr) {
        // potd.code.hub
        int n = arr.length, prefix = 0, ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n;i++){
            prefix += arr[i];
            if (prefix == 0) ans = i+1;
            if (map.containsKey(prefix))
                ans = Math.max(ans, i - map.get(prefix));
            map.putIfAbsent(prefix, i);
        }

        return ans;
    }
}
