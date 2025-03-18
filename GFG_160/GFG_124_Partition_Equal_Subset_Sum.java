package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/subset-sum-problem2014/1
 *
 * # Partition Equal Subset Sum
 *
 *   Q. Given an array arr[], determine if it can be partitioned into two subsets such that the sum of
 *      elements in both parts is the same.
 *
 *      Note: Each element must be in exactly one subset.
 *   Ex.
 *      Input : arr = [1, 5, 11, 5]
 *      Output: true
 *      Explanation: The two parts are [1, 5, 5] and [11].
 */
import java.util.Scanner;

public class GFG_124_Partition_Equal_Subset_Sum {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0;i < n;i++)
            arr[i] = sc.nextInt();

        System.out.println(equalPartition(arr));
    }

    /// Solution
    static boolean equalPartition(int...arr) {
        // potd.code.hub
        int n = arr.length, sum = 0;
        
        for (int j : arr) sum += j;
        if (sum % 2 != 0) return false;

        return solve(n-1, arr, sum/2);
    }
    private static boolean solve(int idx, int[] arr, int target){
        // base Case
        if (target == 0) return true;
        if (idx < 0 || target < 0) return false;
        return solve(idx-1, arr, target-arr[idx]) || solve(idx-1, arr, target);
    }
}
