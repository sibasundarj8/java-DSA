package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/largest-subarray-of-0s-and-1s/1
 *
 * # Largest sub-array of 0's and 1's
 *
 *   Q. Given an array arr of 0s and 1s. Find and return the length of the longest sub-array with
 *      equal number of 0s and 1s.
 *    Ex.
 *      Input : arr[] = [1, 0, 1, 1, 1, 0, 0]
 *      Output: 6
 *      Explanation: arr[1...6] is the longest sub-array with three 0s and three 1s.
 */
import java.util.HashMap;
import java.util.Scanner;

public class GFG_63_Largest_subArray_of_0s_and_1s {

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
        int n = arr.length, sum = 0, ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>(n);
        for (int i = 0;i < n;i++){
            sum += (arr[i] == 0) ? -1 : 1;
            ans = (sum == 0) ? i+1 : Math.max(ans, i - map.getOrDefault(sum, i));
            map.putIfAbsent(sum, i);
        }
        
        return ans;
    }
}
