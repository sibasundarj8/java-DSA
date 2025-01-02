package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/subarrays-with-sum-k/1
 *
 * # Sub-arrays with sum K
 *
 *   Q. Given an unsorted array of integers, find the number of continuous sub-arrays having sum exactly equal
 *      to a given number k.
 *    Ex.
 *      Input : arr = [10, 2, -2, -20, 10]
 *              k = -10
 *      Output: 3
 *      Explanation: Sub-arrays: arr[0...3], arr[1...4], arr[3...4] have sum exactly equal to -10.
 */
import java.util.HashMap;
import java.util.Scanner;

public class GFG_49_SubArrays_with_sum_K {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int[]arr = new int[n];

        System.out.println("Elements: ");
        for (int i = 0;i < n;i++){
            arr[i] = sc.nextInt();
        }

        System.out.println("K: ");
        int k = sc.nextInt();

        System.out.println(countSubarrays(arr, k));
    }

    /// Solution
    static int countSubarrays(int []arr, int k) {
        // potd.code.hub
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0, sum = 0;
        for (int i : arr){
            sum += i;
            map.put(sum, map.getOrDefault(sum, 0)+1);
            if (map.containsKey(sum - k)) ans += map.get(sum - k);
        }
        if (map.containsKey(k)) ans += map.get(k);

        return ans;
    }
}
